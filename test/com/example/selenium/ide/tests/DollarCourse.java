package com.example.selenium.ide.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DollarCourse {

	@Test
	public void testCourseUSD() {
		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://kurs.com.ua/");
		assertEquals(
				driver.findElement(By.xpath("//*[@id='elBoardSummary']//*[@data-role='tableRows']/tr[1]//a")).getText(),
				"USD");
		String selling = driver.findElement(By.xpath(
				"//*[@id='elBoardSummary']//*[@data-role='tableRows']/tr[1]/td[@data-rate-type=\"ask\"]/span[@class='ipsKurs_rate']"))
				.getText();
		String buying = driver.findElement(By.xpath(
				"//*[@id='elBoardSummary']//*[@data-role='tableRows']/tr[1]/td[@data-rate-type=\"bid\"]/span[@class='ipsKurs_rate']"))
				.getText();
		System.out.println("Curse of USD: \n" + "Buying: " + buying + ", Selling: " + selling);
		driver.quit();
	}
}
