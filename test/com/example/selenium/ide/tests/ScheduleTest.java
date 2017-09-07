package com.example.selenium.ide.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScheduleTest {

	@Test
	public void testSchedule() {
		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://softserve.academy/");
		driver.findElement(By.xpath("//*[contains(text(),'Lviv: schedule')]")).click();

		switchToNewTab(driver);// switch WebDriver to new Tab

		driver.findElement(By.xpath("//*[@href = 'week062.htm' and text()='5']")).click();
		assertEquals(driver.findElement(By.linkText("Lv-256 ATQC")).getText(), "Lv-256 ATQC");
		driver.quit();
	}

	// switch WebDriver to new Tab
	public void switchToNewTab(WebDriver driver) {
		String winHandle = null;
		for (String newWinHandle : driver.getWindowHandles()) {
			winHandle = newWinHandle;
		}
		driver.switchTo().window(winHandle);
	}

}
