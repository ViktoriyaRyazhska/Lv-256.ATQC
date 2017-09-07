package com.example.selenium.ide.tests;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExchangeRateUsd {
	// initial WebDriver
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// initial property
		System.setProperty("webdriver.gecko.driver", "resources//geckodriver.exe");// "D:\\1\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// go to kurs.com.ua
		driver.get("https://kurs.com.ua/");
	}

	/**
	 * Test Exchange rate USD is present on page 'Exchange rate in Ukraine'
	 * kurs.com.ua and print this rate on console.
	 */
	@Test
	public void testExchangeRateUSD() {

		// check is element present on page
		assertNotNull("//div[@id='elBoardSummary']//a[contains(text(),'USD')]");
		//print exchange rate
		printExchangeRateUSD();
	}
	
	@AfterClass
	public void tearDown() {
		// close WebDriver
		driver.quit();
	}

	//print Exchange Rate USD on console
	private void printExchangeRateUSD() {
		// get selling rate
		String selling = driver
				.findElement(By
						.xpath("//div[@id='elBoardSummary']//a[contains(text(),'USD')]/following::td[3]/span[@class='ipsKurs_rate']"))
				.getText();
		// get buying course
		String buying = driver
				.findElement(By
						.xpath("//div[@id='elBoardSummary']//a[contains(text(),'USD')]/following::td[1]/span[@class='ipsKurs_rate']"))
				.getText();
		// print exchange rate of USD on console
		System.out.println("Exchange rate USD: \n" + "Buying: " + buying + ", Selling: " + selling);
	}
}
