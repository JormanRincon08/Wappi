package com.automationpractice.wappi.utils.poi;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	private static final Logger LOGGER = Logger.getLogger(ReadExcel.class);

	public List<Map<String, String>> getData(String excelFilePath, String sheetName) {
		Sheet sheet = getSheetByName(excelFilePath, sheetName);
		return readSheet(sheet);
	}

	public List<Map<String, String>> getData(String excelFilePath, int sheetNumber) {
		Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
		return readSheet(sheet);
	}

	private Sheet getSheetByName(String excelFilePath, String sheetName) {
		return getWorkBook(excelFilePath).getSheet(sheetName);
	}

	private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) {
		return getWorkBook(excelFilePath).getSheetAt(sheetNumber);
	}

	private Workbook getWorkBook(String excelFilePath) {
		try {
			return WorkbookFactory.create(new File(excelFilePath));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new XSSFWorkbook();
		}
	}

	private List<Map<String, String>> readSheet(Sheet sheet) {
		Row row;
		int totalRow = sheet.getPhysicalNumberOfRows();
		List<Map<String, String>> excelRows = new ArrayList<>();
		int headerRowNumber = getHeaderRowNumber(sheet);
		if (headerRowNumber != -1) {
			int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
			int setCurrentRow = 1;
			for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
				row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
				LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
				}
				excelRows.add(columnMapdata);
			}
		}
		return excelRows;
	}

	private int getHeaderRowNumber(Sheet sheet) {
		Row row;
		int totalRow = sheet.getLastRowNum();
		for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
			row = getRow(sheet, currentRow);
			if (row != null) {
				int totalColumn = row.getLastCellNum();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					Cell cell;
					cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell.getCellTypeEnum() == CellType.STRING || cell.getCellTypeEnum() == CellType.NUMERIC
							|| cell.getCellTypeEnum() == CellType.BOOLEAN || cell.getCellTypeEnum() == CellType.ERROR) {
						return row.getRowNum();
					}
				}
			}
		}
		return (-1);
	}

	private Row getRow(Sheet sheet, int rowNumber) {
		return sheet.getRow(rowNumber);
	}

	private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
		LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();
		Cell cell;
		if (row != null) {
			cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

			if (sheet.getRow(sheet.getFirstRowNum())
					.getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
					.getCellTypeEnum() != CellType.BLANK) {
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
						.getStringCellValue();
				if (cell.getCellTypeEnum() == CellType.STRING) {
					columnMapdata.put(columnHeaderName, cell.getStringCellValue());
				} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
					columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
				} else if (cell.getCellTypeEnum() == CellType.BLANK) {
					columnMapdata.put(columnHeaderName, "");
				} else if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
					columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
				} else if (cell.getCellTypeEnum() == CellType.ERROR) {
					columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
				}
			}
		} else {
			if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
					.getCellTypeEnum() != CellType.BLANK) {
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, "");
			}
		}
		return columnMapdata;
	}
}
