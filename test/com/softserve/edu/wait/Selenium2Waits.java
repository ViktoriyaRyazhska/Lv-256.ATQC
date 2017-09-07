package com.softserve.edu.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium2Waits {

	@Test
	public void testSelen() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\ATQC_new\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		driver.get("http://regres.herokuapp.com");
		Thread.sleep(2000);

		new Select(driver.findElement(By.id("changeLanguage"))).selectByVisibleText("english");
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("changeLanguage"))).selectByVisibleText("українська");
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("changeLanguage"))).selectByValue("ru");
		Thread.sleep(2000);
		
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("ha-ha-ha");
		Thread.sleep(2000);
		//
		driver.navigate().refresh();
		//
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebElement login = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
//		login.sendKeys("admin");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// login.sendKeys("admin");
		//
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		Thread.sleep(2000);
		//
		driver.findElement(By.id("password")).submit();
		Thread.sleep(2000);
		//
		Assert.assertEquals(driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']")).getText(),
				"admin");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
		//
		driver.findElement(By.xpath("//a[@href='/logout']")).click();
		//
		Thread.sleep(2000);
		Assert.assertNotNull(driver.findElement(By.xpath("//img[@src='/resource/img/ukraine_logo2.gif']")));

		Assert.assertNotNull(login);

		//
		login = driver.findElement(By.id("login"));
		login.clear();
		login.sendKeys("ha-ha-ha");
		driver.quit();
	}

}
