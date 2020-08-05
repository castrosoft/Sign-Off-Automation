package com.qualitystream.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public WriteExcelFile() {

	}
	
	/**
	 * Me permite escribir una lista de datos en el Excel
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param dataToWrite
	 * @throws IOException
	 */

	public void writeExcel(String filePath, String sheetName, String[] dataToWrite) throws IOException {

		File file = new File(filePath);

		// Aca estan los datos del archivo que cargamos
		FileInputStream inputStream = new FileInputStream(file);

		// Objeto donde guardo el Excel
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);

		// Objeto donde guardo la Hoja con la que estamos trabajando
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName);

		// Nro de filas de datos del Excel
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

		// Creo un objeto fila
		XSSFRow row = newSheet.getRow(0);
		
		// Creo un objeto fila, que es donde vamos a escribir
		XSSFRow newRow = newSheet.createRow(rowCount + 1);

		for (int i = 0; i < row.getLastCellNum(); i++) {
			
			// Creo una celda
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(dataToWrite[i]);
		}

		inputStream.close();

		FileOutputStream outputStream = new FileOutputStream(file);

		// Escribo la info en el Excel
		newWorkBook.write(outputStream);

		outputStream.close();

	}

	/**
	 * 
	 * Me permite crear un valor en una celda especifica
	 * 
	 * @param filePath Path del documento Excel
	 * @param sheetName Nombre de la hoja
	 * @param rowNumber Nro de la fila donde quiero escribir
	 * @param cellNumber Nro de la celda de esa fila donde quiero escribir
	 * @param resultText Texto que quiero escribir en esa celda especifica
	 * @throws IOException
	 */
	public void writeCellValue(String filePath, String sheetName, int rowNumber, int cellNumber, String resultText)
			throws IOException {
		File file = new File(filePath);

		// Aca estan los datos del archivo que cargamos
		FileInputStream inputStream = new FileInputStream(file);

		// Objeto donde guardo el Excel
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);

		// Objeto donde guardo la Hoja con la que estamos trabajando
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName);

		// Creo la fila
		XSSFRow row = newSheet.getRow(rowNumber);

		// Creo la celda desde donde voy a escribir el resultado
		XSSFCell firstCell = row.getCell(cellNumber - 1);

		System.out.println("First cell value is:" + firstCell.getStringCellValue());

		// Creo otra celda
		XSSFCell nextCell = row.createCell(cellNumber);
		nextCell.setCellValue(resultText);

		System.out.println("Nextcell value:" + nextCell.getStringCellValue());

		inputStream.close();

		FileOutputStream outputStream = new FileOutputStream(file);

		// Escribo la info en el Excel
		newWorkBook.write(outputStream);

		outputStream.close();
	}

}
