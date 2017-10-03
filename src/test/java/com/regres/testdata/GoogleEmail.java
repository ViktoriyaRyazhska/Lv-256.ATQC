package com.regres.testdata;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class GoogleEmail {

	private WebDriver driver;
	private String email = "bzhyvko90@gmail.com";
	private String password = "19902712";
	private String unreadCommand = "l:unread ";
	private String searchEmail = "Заявка на реєстрацію";
	
	public GoogleEmail(WebDriver driver){
		this.driver = driver;
	}

	public List<WebElement> getEmail() {
		(new WebDriverWait(driver, 10)).until(
				ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//td//span[contains (text(), 'заявка на реєстрацію')]"))));
				return driver.findElements(By.xpath("//td//span[contains (text(), 'заявка на реєстрацію')]"));
	}

	public void signIn() {
		// sign in "gmail.com"
		Reporter.log("opening gmail.com", true);
		driver.get("http://gmail.com");
		Reporter.log("enter Email: " + email, true);
		(new WebDriverWait(driver, 10)).until(
				ExpectedConditions.visibilityOf(driver.findElement(By.id("identifierId"))));
		driver.findElement(By.id("identifierId")).clear();
		driver.findElement(By.id("identifierId")).sendKeys(email + "\n");
		Reporter.log("enter Password: " + password, true);
		(new WebDriverWait(driver, 10)).until(
				ExpectedConditions.visibilityOf(driver.findElement(By.name("password"))));
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password + "\n");
	}

	public void search() {
		driver.findElement(By.xpath("//div[@role = 'search']//input[@type = 'text']"))
				.sendKeys(unreadCommand + searchEmail);
		driver.findElement(By.xpath("//div[@role = 'search']//button")).click();
	}
	
	public void openEmail() {
		
		Reporter.log("enter Password: " + getEmail().size(), true);
		this.getEmail().get(0).click();
		//driver.findElement(By.xpath("(//div[@class = 'UI']//tr)[1]")).click();
	}
	
	public String getLoginName() {
		return driver.findElement(By.cssSelector("strong")).getText();
	}
}
