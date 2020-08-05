package com.qualitystream.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public ReadExcelFile() {

	}

	/**
	 * @param filePath  Path del documento Excel
	 * @param sheetName Hoja del libro de Excel que va a ser leida
	 * @throws IOException
	 * 
	 */
	public void readExcel(String filePath, String sheetName) throws IOException {
		File file = new File(filePath);

		// Aca estan los datos del archivo que cargamos
		FileInputStream inputStream = new FileInputStream(file);

		// Objeto donde guardo el Excel
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);

		// Objeto donde guardo la Hoja con la que estamos trabajando
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName);

		// Nro de filas de datos del Excel
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

		// Recorro por c/u de las celdas de la/s fila/s
		for (int i = 0; i <= rowCount; i++) {
			XSSFRow row = newSheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue() + " ||");
			}
		}
	}

	/**
	 * Me permite leer una celda especifica
	 * 
	 * @param filePath
	 * @param sheetNAme
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws IOException
	 */
	public String getCellValue(String filePath, String sheetName, int rowNumber, int cellNumber) throws IOException {
		File file = new File(filePath);

		// Aca estan los datos del archivo que cargamos
		FileInputStream inputStream = new FileInputStream(file);

		// Objeto donde guardo el Excel
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);

		// Objeto donde guardo la Hoja con la que estamos trabajando
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName);

		// Fila
		XSSFRow row = newSheet.getRow(rowNumber);

		// Celda
		XSSFCell cell = row.getCell(cellNumber);

		return cell.getStringCellValue();
	}

}
