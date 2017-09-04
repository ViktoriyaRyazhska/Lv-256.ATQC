package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenShotTest {

	WebDriver driver;
	private boolean isCaptureScreen = false;

	@BeforeClass
	public void oneTimeSetUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\ATQC_new\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

//	@AfterClass
	public void oneTimeTearDown() {
		driver.quit();
	}

	@BeforeMethod
	public void setUp() {
		isCaptureScreen = true;
	}

	@AfterMethod
	public void tearDown() throws IOException {
		System.out.println("isCaptureScreen = " + isCaptureScreen);
		if (isCaptureScreen) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// For example copy somewhere
			FileUtils.copyFile(scrFile, new File("d:\\1\\screenshot.png"));
		}
	}

	@Test
	public void testSelen() throws Exception {
		driver.get("https://www.google.com.ua/");
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("selenium ide download");
		driver.findElement(By.id("lst-ib")).submit();
		// driver.findElement(By.name("btnG")).click();
		//
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleContains("selenium ide download"));
		//
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// For example copy somewhere
		FileUtils.copyFile(scrFile, new File("d:\\2\\screenshot.png"));

		Thread.sleep(500);
		driver.findElement(By.partialLinkText("Selenium IDE")).click();
		// Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String text = driver.findElement(By.id("addon-summary")).getText();
		Assert.assertTrue(text.contains("Selenium IDE is an integrated development"));
		//

		isCaptureScreen = false;
		System.out.println("Test DONE");
	}

}
