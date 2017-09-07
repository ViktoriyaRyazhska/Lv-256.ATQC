package com.example.selenium.ide.tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HaveClassTodayTest {

	@Test
	public void testDayclass() {

		ScheduleTest switchTab = new ScheduleTest();
		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://softserve.academy/");
		driver.findElement(By.xpath("//*[contains(text(),'Lviv: schedule')]")).click();

		switchTab.switchToNewTab(driver);// switch WebDriver to new Tab

		driver.findElement(By.linkText("09-04")).click();
		driver.findElement(By.linkText("Lv-256 ATQC")).click();
		assertEquals(driver.findElement(By.linkText("Lv-256.ATQC")).getText(), "Lv-256.ATQC");
		assertEquals(driver.findElement(By.linkText("Lv-256.AQC +expert")).getText(), "Lv-256.AQC +expert");

		driver.quit();
	}
}
