package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReportsInTest {
	WebDriver driver;

	@BeforeClass(groups = {"group1", "group2"})
	public void start() {
		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test(groups = "group1")
	public void testingMethod11() {
		Reporter.log("Running Testing method11");
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("SoftServe");
		driver.findElement(By.name("q")).submit();
//		driver.findElement(By.id("_fZl")).click();
		(new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				System.out.println("running apply");
				System.out.println(d.getTitle());
				return d.getTitle().contains("SoftServe");
			}
		});
		WebElement element = driver.findElement(By.cssSelector("div.kno-rdesc span"));
		Assert.assertTrue(element.getText().contains("SoftServe "));
		System.out.println("Method - testingMethod11( ): " + element.getText());
	}

	@Test(groups = "group1")
	public void testingMethod12() {
		Reporter.log("Running Testing method12");
		driver.get("http://www.msn.com/");
		WebElement element = driver.findElement(By.cssSelector(".logo"));
		Assert.assertEquals("http://www.msn.com/en-us", element.getAttribute("href"));
		System.out.println("Method - testingMethod12( ): " + element.getAttribute("href"));
	}

	@Test(groups = "group2")
	public void testingMethod21() {
		Reporter.log("Running Testing method21");
		driver.get("http://auto.ria.com/");

		WebElement element = driver.findElement(By.id("BuRadioButton"));
		Assert.assertTrue(element.isDisplayed());
		System.out.println("Method - testingMethod21( ): " + element.getTagName() + " " + element.isSelected());
	}

	@Test(groups = "group3")
	public void testingMethod31() {
		Reporter.log("Running Testing method31");
		WebElement element = driver.findElement(By.xpath("/html/body/img"));
		Assert.assertTrue(element.isDisplayed());
		System.out.println("Method - testingMethod31( ): " + element.isDisplayed());
	}
	
	@AfterClass(groups = {"group1", "group2"})
	public void close(){
		driver.close();
	}
}



