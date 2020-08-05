package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTesting_SWD_Test {

	private WebDriver driver;
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
	private By searchBoxLocator = By.id("search_query_top");
	private By searchBtnLocator = By.name("submit_search");
	private By resultTextLocator = By.cssSelector("span.heading-counter");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "Z:\\Descargas\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();

		driver.get("http://automationpractice.com");
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void test() throws IOException {

		// Path del Excel
		String filepath = "Z:\\EclipseProjects\\Selenium-Quality-Stream\\Selenium-Quality-Stream\\docs\\excel\\test.xlsx";

		// Guardo el valor de la fila 0, celda 0 (= dresses)
		String searchText = readFile.getCellValue(filepath, "Hoja1", 0, 0);

		// Envio esa busqueda del excel a la pagina web
		driver.findElement(searchBoxLocator).clear();
		driver.findElement(searchBoxLocator).sendKeys(searchText);
		driver.findElement(searchBtnLocator).click();
		
		// Guardo el mensaje que sale luego del click: "x results have been found"
		String resultText = driver.findElement(resultTextLocator).getText();

		System.out.println("Page result text:" + resultText);

		// Me devuelve lo que esta escrito en el Excel
		readFile.readExcel(filepath, "Hoja1");

		// Escribo en el Excel.
		writeFile.writeCellValue(filepath, "Hoja1", 0, 1, resultText);

		// Para verficar que se escribio ese valor en la pagina
		readFile.readExcel(filepath, "Hoja1");

	}
}
