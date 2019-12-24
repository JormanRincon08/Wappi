package com.automationpractice.wappi.utils.poi;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class DataToFeature {

	protected static String data;
	protected static String idCaso;
	protected static boolean foundHashTag = false;
	protected static boolean featureData = false;

	protected static String sheetName;
	protected static String excelFilePath;

	private static final Logger LOGGER = Logger.getLogger(DataToFeature.class);

	private DataToFeature() {
	}

	private static List<String> setExcelDataToFeature(File featureFile) {
		List<String> fileData = new ArrayList<>();
		try (BufferedReader buffReader = new BufferedReader(
				new InputStreamReader(new BufferedInputStream(new FileInputStream(featureFile)), UTF_8))) {
			foundHashTag = false;
			featureData = false;

			while ((data = buffReader.readLine()) != null) {
				sheetName = null;
				excelFilePath = null;

				if (data.trim().contains("@TestCase")) {
					idCaso = data.trim();
					idCaso = idCaso.substring(9);
				}
				if (data.trim().contains("##@externaldata")) {
					foundHashTag = true;
					fileData = getDataExcel(fileData);
				}
				if (foundHashTag) {
					foundHashTag = false;
					featureData = true;
				} else {
					if ((data.startsWith("|") || data.endsWith("|")) && featureData) {
						continue;
					}
					featureData = false;
					fileData.add(data);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return fileData;
	}

	private static List<String> getDataExcel(List<String> fileData) {
		List<Map<String, String>> excelData = null;
		excelFilePath = data.substring(StringUtils.ordinalIndexOf(data, "@", 2) + 1, data.lastIndexOf('@'));
		sheetName = data.substring(data.lastIndexOf('@') + 1, data.length());

		fileData.add(data);

		excelData = new ReadExcel().getData(excelFilePath, sheetName);
		for (int rowNumber = 0; rowNumber < excelData.size() - 1; rowNumber++) {
			StringBuilder cellData = new StringBuilder();
			cellData.append("      ");
			for (Entry<String, String> mapData : excelData.get(rowNumber).entrySet()) {
				cellData.append("|" + mapData.getValue());
			}
			cellData.append("|");
			fileData.add(cellData.toString());
		}

		return fileData;
	}

	private static List<File> listOfFeatureFiles(File folder) {
		List<File> featureFiles = new ArrayList<>();
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				featureFiles.addAll(listOfFeatureFiles(fileEntry));
			} else {
				if (fileEntry.isFile() && fileEntry.getName().endsWith(".feature")) {
					featureFiles.add(fileEntry);
				}
			}
		}
		return featureFiles;
	}

	public static void overrideFeatureFiles(String featuresDirectoryPath) {
		try {
			List<File> listOfFeatureFiles = listOfFeatureFiles(new File(featuresDirectoryPath));
			for (File featureFile : listOfFeatureFiles) {

				List<String> featureWithExcelData = setExcelDataToFeature(featureFile);
				try (BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(featureFile), UTF_8));) {
					for (String string : featureWithExcelData) {
						writer.write(string);
						writer.write("\n");
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}
