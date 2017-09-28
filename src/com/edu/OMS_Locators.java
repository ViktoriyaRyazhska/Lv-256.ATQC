package com.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OMS_Locators {

	@Test
	public void checkLogin() {
		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://ssu-oms.training.local:8280/oms5/login.htm");

		driver.findElement(By.name("j_username"));
		driver.findElement(By.name("j_username")).sendKeys("iva");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("qwerty");
		driver.findElement(By.name("submit")).click();
		Assert.assertEquals("ivanka",
				driver.findElement(By.xpath("//tbody/tr/td[text()='First name']/following-sibling::td")).getText());
		driver.quit();
	}

	@Test
	public void createUser() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "D:\\ATQC_new\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://localhost:8080/OMS");
		driver.findElement(By.name("j_username")).clear();
		driver.findElement(By.name("j_username")).sendKeys("iva");
		driver.findElement(By.name("j_password")).clear();
		driver.findElement(By.name("j_password")).sendKeys("qwerty");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[text()='Administration']")).click();
		driver.findElement(By.xpath("//a[@href='addUser.htm']")).click();
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("aaaa");
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys("aaaa");
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("aaaa");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("aaaa");
		driver.findElement(By.id("confirmPassword")).clear();
		driver.findElement(By.id("confirmPassword")).sendKeys("aaaa");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("a.a@gmail.com");
		Thread.sleep(1000);
		// driver.findElement(By.id("roleID")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Select select = new Select(driver.findElement(By.id("field")));
		select.selectByValue("LOGIN");
		(new Select(driver.findElement(By.id("condition")))).selectByValue("EQUALS");
		driver.findElement(By.id("searchField")).clear();
		driver.findElement(By.id("searchField")).sendKeys("aaaa");
		driver.findElement(By.name("search")).click();
		Thread.sleep(1000);

		Assert.assertEquals("aaaa", driver.findElement(By.xpath("//tbody/tr/td[text()='aaaa']")).getText());
		driver.findElement(By.xpath("//tbody/tr/td[text()='aaaa']/following-sibling::td[*]/a[text()='Delete ']"))
				.click();
		Thread.sleep(1000);

		// driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.id("logout")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);

		driver.quit();
	}

}



