package com.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageUser {
	WebDriver driver;

	private void login(String userName, String password) {
		System.setProperty("webdriver.gecko.driver", "D:\\ATQC_new\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8081/OMS");
		driver.findElement(By.name("j_username")).sendKeys(userName);
		driver.findElement(By.name("j_password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
	}

	private void logout() {
		driver.findElement(By.id("logout")).click();
		driver.quit();
	}

	@Test
	public void test01CreateNewUser() {
		login("iva", "qwerty");
		driver.findElement(By.xpath("//a[@href='users.htm']")).click();
		driver.findElement(By.xpath("//a[@href='addUser.htm']")).click();
		driver.findElement(By.id("login")).sendKeys("aaa");
		driver.findElement(By.id("firstName")).sendKeys("aaa");
		driver.findElement(By.id("lastName")).sendKeys("aaa");
		driver.findElement(By.id("password")).sendKeys("aaaa");
		driver.findElement(By.id("confirmPassword")).sendKeys("aaaa");
		driver.findElement(By.id("email")).sendKeys("aaa@gmail.com");
		driver.findElement(By.xpath("//input[@value='Create']")).submit();
		new Select(driver.findElement(By.id("field"))).selectByVisibleText("First Name");
		new Select(driver.findElement(By.id("condition"))).selectByVisibleText("equals");
		driver.findElement(By.id("searchField")).sendKeys("aaa");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText().startsWith("aa");
			}
		});
		Assert.assertEquals("aaa", driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText());
		logout();
	}
}
