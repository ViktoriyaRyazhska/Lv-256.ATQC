package com.example.selenium.ide.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DollarCourse {

	@Test
	public void testCourseUSD() {
		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://kurs.com.ua/");
		assertEquals(
				driver.findElement(By.xpath("(//*[@id='elBoardSummary']//*[contains(text(), 'USD')]/td)[1]")).getText(),
				"USD");
		String selling = driver.findElement(By.xpath(
				"(//*[@id='elBoardSummary']//*[contains(text(), 'USD')]/td[@data-rate-type='ask']/span[@class='ipsKurs_rate'])[1]"))
				.getText();
		String buying = driver.findElement(By.xpath(
				"(//*[@id='elBoardSummary']//*[contains(text(), 'USD')]/td[@data-rate-type='bid']/span[@class='ipsKurs_rate'])[1]"))
				.getText();
		System.out.println("Curse of USD: \n" + "Buying: " + buying + ", Selling: " + selling);
		driver.quit();
	}
}
