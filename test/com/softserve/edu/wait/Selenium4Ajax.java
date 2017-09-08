package com.softserve.edu.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium4Ajax {

	@Test
	public void Ajax() throws Exception {
		// Preconditions
		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.w3schools.com/xml/ajax_intro.asp");
		Thread.sleep(1000);

		// Test steps
		// find WebElement.
		WebElement ajaxChange = driver.findElement(By.cssSelector("#demo h2"));
		Assert.assertEquals(ajaxChange.getText(), "Let AJAX change this text");
		//
		Thread.sleep(1000);
		// find button and Click.
		driver.findElement(By.cssSelector("#demo button")).click();

		// Store the current window handle
		String ajaxPage = driver.getWindowHandle();
		System.out.println(ajaxPage);

//		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//		// Wait until an element is no longer attached to the DOM.
//		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(ajaxChange));
//
//		// Check
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		Thread.sleep(1000);
//		Assert.assertEquals(driver
//				.findElement(By.xpath("//div[@id='demo']/p[contains(text(), 'AJAX is not a programming')]")).getText(),
//				"AJAX is not a programming language.");
//		Assert.assertTrue(
//				driver.findElement(By.xpath("//div[@id='demo']/p[contains(text(), 'AJAX is a technique for ')]"))
//						.getText().contains("AJAX is a technique for accessing web servers from a web page"));

		//
		driver.findElement(By.partialLinkText("Try it Yourself")).click();
		Thread.sleep(2000);
		driver.switchTo().window(ajaxPage);
		Thread.sleep(2000);
//		driver.quit();
	}
}
