package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {
	
	private WebDriver driver;
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='/images/masts/mast_register.gif']");
	
	By usernameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By registerBtnLocator = By.name("register");
	
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("login");
	
	By homePageLocator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "Z:\\Descargas\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		
		//1- Click en REGISTER
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000); //Por ahora uso este delay. No se recomienda
		
		//2- Completar campos para registrar usuario
		
		//Si es true, entonces la imagen esta" 
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			//Lleno los campos
			driver.findElement(usernameLocator).sendKeys("qualityadmin");
			driver.findElement(passwordLocator).sendKeys("pass1");
			driver.findElement(confirmPasswordLocator).sendKeys("pass1");
			
			//Click en SUBMIT
			driver.findElement(registerBtnLocator).click();	
		}else {
			
			System.out.println("Register page was not found");
		}
		
		
		
		//3- Confirmar mensaje de usuario registrado
		
		//Creo una lista de WebElements, porque hay varios font
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		//En la posicion 6 esta el texto queme interesa
		assertEquals("Note: Your user name is qualityadmin.", fonts.get(5).getText());
	}
	
	@Test
	public void signIn() throws InterruptedException {
		
		if(driver.findElement(userLocator).isDisplayed()){
			driver.findElement(userLocator).sendKeys("qualityadmin");
			driver.findElement(passLocator).sendKeys("pass1");
			driver.findElement(signInBtnLocator).click();
			Thread.sleep(2000);
			
			assertTrue(driver.findElement(homePageLocator).isDisplayed());
		}else {
			System.out.println("Username textBox was not present");
		}
	}

}
