package com.automationpractice.wappi.utils.poi;

import static com.automationpractice.wappi.utils.util.Const.STATUS_ERROR;
import static com.automationpractice.wappi.utils.util.Const.STATUS_OK;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	private static final Logger LOGGER = Logger.getLogger(Excel.class);

	private Excel() {
	}

	public static void modifyExcelCell(String filePath, int indexSheet, CellType cellType, String cellValue) {
		try (
				// Read the spreadsheet that needs to be updated
				FileInputStream inputDocument = new FileInputStream(new File(filePath));
				// convert it into a POI object
				Workbook workbook = WorkbookFactory.create(inputDocument);) {

			// Access the worksheet, so that we can update / modify it.
			Sheet sheet = workbook.getSheetAt(indexSheet);

			// Get Row at index lastRow
			int lastRow = sheet.getLastRowNum();
			Row newRow = sheet.createRow(++lastRow);

			// Get the Cell at index from the above row
			Cell cell = newRow.createCell(0);

			// Update the cell's type
			cell.setCellType(cellType);

			if (cellType == CellType.STRING)
				cell.setCellValue(cellValue);
			else if (cellType == CellType.BOOLEAN)
				cell.setCellValue(Boolean.parseBoolean(cellValue));
			else if (cellType == CellType.NUMERIC && isInteger(cellValue))
				cell.setCellValue(Integer.parseInt(cellValue));
			else if (cellType == CellType.NUMERIC && isDouble(cellValue))
				cell.setCellValue(Double.parseDouble(cellValue));

			// Open FileOutputStream to write updates
			FileOutputStream outputFile = new FileOutputStream(new File(filePath));
			// write changes
			workbook.write(outputFile);
			// close the stream
			outputFile.close();
			int index = filePath.lastIndexOf('/') + 1;
			String fileName = filePath.substring(index, filePath.length());
			String message = String.format("the %s value has been successfully registered in book %s", cellValue,
					fileName);
			LOGGER.info(message);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	private static boolean isInteger(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return false;
		}
	}

	private static boolean isDouble(String number) {
		try {
			Double.parseDouble(number);
			return true;
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return false;
		}
	}

	public static void createExcellBook(Map<String, Map<String, Map<String, List<String>>>> booksCollection) {
		// Creamos el libro de trabajo de Excel formato OOXML
		Workbook workbook = new XSSFWorkbook();
		try {
			// PARA CADA CLAVE DE LIBRO...
			for (Map.Entry<String, Map<String, Map<String, List<String>>>> booksEntry : booksCollection.entrySet()) {

				String booksCollectionKey = booksEntry.getKey();
				Map<String, Map<String, List<String>>> booksCollectionValue = booksEntry.getValue();

				// Creamos el archivo donde almacenaremos la hoja
				// de calculo, recuerde usar la extension correcta,
				// en este caso .xlsx
				File archivo = new File(booksCollectionKey);

				// PARA CADA CLAVE DE HOJA...
				for (Map.Entry<String, Map<String, List<String>>> bookDataEntry : booksCollectionValue.entrySet()) {

					String bookDataKey = bookDataEntry.getKey();
					Map<String, List<String>> sheetData = bookDataEntry.getValue();

					// La hoja donde pondremos los datos
					Sheet sheet = workbook.createSheet(bookDataKey);

					// Se insertan los datos en las celdas de Excel.
					insertDataInCells(sheet, sheetData);

					// Ahora guardaremos el archivo
					saveBook(archivo, workbook);
				}
			}
		} finally {
			try {
				// Cerramos el libro para concluir operaciones
				workbook.close();

			} catch (Exception e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	private static void insertDataInCells(Sheet sheet, Map<String, List<String>> sheetData) {

		ArrayList<ArrayList<String>> listaDeColumnas = new ArrayList<>();

		// PARA CADA CLAVE DE COLUMNA DE LA HOJA...
		for (Map.Entry<String, List<String>> sheetDataEntry : sheetData.entrySet()) {

			String key = sheetDataEntry.getKey();
			ArrayList<String> sheetDataColumnValue = (ArrayList<String>) sheetDataEntry.getValue();

			// Agrega el título en el índice cero (0)
			sheetDataColumnValue.add(0, key);

			listaDeColumnas.add(sheetDataColumnValue);
		}

		// Recorre filas (se basa en el número de filas de la columna).
		for (int i = 0; i < listaDeColumnas.get(0).size(); i++) {
			// Ahora creamos una fila con su respectiva posición.
			Row fila = sheet.createRow((i));

			// Recorre columnas
			for (int j = 0; j < listaDeColumnas.size(); j++) {
				// Creamos una celda en esa fila, en la
				// posicion indicada por el contador del ciclo
				Cell celda = fila.createCell(j);
				celda.setCellValue(listaDeColumnas.get(j).get(i));
			}
		}
	}

	private static void saveBook(File file, Workbook workbook) {
		// Ahora guardaremos el archivo
		try {
			// Creamos el flujo de salida de datos,
			// apuntando al archivo donde queremos
			// almacenar el libro de Excel
			FileOutputStream salida = new FileOutputStream(file);

			// Almacenamos el libro de
			// Excel via ese
			// flujo de datos
			workbook.write(salida);

			LOGGER.info("Archivo creado existosamente en " + file.getAbsolutePath());

		} catch (FileNotFoundException e) {
			LOGGER.error("Archivo no localizable en sistema de archivos", e);
		} catch (IOException e) {
			LOGGER.error("Error de entrada/salida", e);
		}
	}

	// Actualizar celda de estado en la verificación
	public static void updateStatus(String filePath, int indexSheet, int columnStatus, String idTransaction,
			boolean status) {

		try (FileInputStream inputDocument = new FileInputStream(new File(filePath));
				Workbook workbook = WorkbookFactory.create(inputDocument)) {
			Sheet sheet = workbook.getSheetAt(indexSheet);
			Row row = sheet.getRow(findIdTransaction(sheet, idTransaction));
			Cell cell = row.getCell(columnStatus);
			if (cell == null)
				cell = row.createCell(columnStatus);
			cell.setCellType(CellType.STRING);
			if (status)
				cell.setCellValue(STATUS_OK);
			else
				cell.setCellValue(STATUS_ERROR);
			FileOutputStream fileOut = new FileOutputStream(filePath);
			workbook.write(fileOut);
			fileOut.close();
			int index = (filePath.lastIndexOf('/') != -1) ? filePath.lastIndexOf('/') : filePath.lastIndexOf("//");
			String fileName = filePath.substring(index + 1, filePath.length());
			String message = String.format("the %s value has been successfully registered in book %s", idTransaction,
					fileName);
			LOGGER.info(message);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	private static int findIdTransaction(Sheet sheet, String idTransaction) {
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getCellTypeEnum() == CellType.STRING
						&& cell.getRichStringCellValue().getString().trim().equals(idTransaction.trim())) {
					return row.getRowNum();
				}
			}
		}
		return 0;
	}

}
