package com.softserve.edu.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Selenium3Javascript {

	@Test
	public void testSelen() throws Exception {
		// System.setProperty("webdriver.gecko.driver",
		// "D:\\WS_ATQC\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", "D:\\ATQC_new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//
		driver.get("http://regres.herokuapp.com");
		Thread.sleep(1000);

		// ((JavascriptExecutor) driver)
		// .executeScript("document.getElementById(\"loginForm\").innerHTML =
		// \"<div>hahaha</div>\";");

		System.out.println("Alert must be shown");

		((JavascriptExecutor) driver).executeScript("alert('Hello,	world!')");
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		driver.quit();
	}

}
