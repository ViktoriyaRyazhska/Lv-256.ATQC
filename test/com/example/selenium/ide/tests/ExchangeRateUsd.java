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
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// go to "UBR" web page Exchange rate in Ukraine Banks
		driver.get("http://ubr.ua/banks");
	}

	/**
	 * Test Exchange rate USD is present on page 'Exchange rate in Ukraine Banks'
	 * on 'UBR' page and print this rate on console.
	 */
	@Test
	public void testExchangeRateUSD() {

		// check is element 'USD' present on page
		assertNotNull("//table[@id='js-tb-currency']//span[contains(text(), 'USD')]");

		// print exchange rate
		printExchangeRateUSD();
	}

	@AfterClass
	public void tearDown() {
		// close WebDriver
		driver.quit();
	}

	/*
	 * print Exchange Rate USD on console
	 */
	private void printExchangeRateUSD() {
		// get buying course
		String buying = driver
				.findElement(By
					.xpath("(//table[@id='js-tb-currency']//span[contains(text(), 'USD')]/following::strong)[1]"))
						.getText();

		// get selling rate
		String selling = driver
				.findElement(By
						.xpath("(//table[@id='js-tb-currency']//span[contains(text(), 'USD')]/following::strong)[2]"))
							.getText();

		// print exchange rate of USD on console
		System.out.println("Exchange rate USD: \n" + "Buying: " + buying + ", Selling: " + selling);
	}
}
