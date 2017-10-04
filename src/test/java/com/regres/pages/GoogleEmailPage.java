package com.regres.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class GoogleEmailPage {

	private WebDriver driver;
//	private String email = "bzhyvko90@gmail.com";
//	private String password = "19902712";
//	private String unreadCommand = "l:unread ";
//	private String searchEmail = "Заявка на реєстрацію";
	
	// Locators for actions dropdown for non-confirmed co-owners
	private String GMAIL_URL = "http://gmail.com";
	private String LOGIN_ID = "identifierId";
	private String PASSWORD_NAME = "password";
	private String INPUT_SEARCH_XPATH = "//div[@role = 'search']//input[@type = 'text']";
	private String BUTTON_SEARCH_XPATH = "//div[@role = 'search']//button";
	private String EMAIL_TEXT_CSS_SELECTOR= "strong";
	private String ACCAUNT_NAME_XPATH = "//span[@class='gb_7a gbii']";
	private String LOGOUT_ID = "gb_71";
	
	public GoogleEmailPage(WebDriver driver) {
		this.driver = driver;
	}
	// this constructor 
	public List<WebElement> getEmail() {						
		return 	driver.findElements(By.cssSelector("span.y2"));
	}
	// sign in to gmail
	public void signIn(String email, String password) {
		// sign in "gmail.com"
		Reporter.log("opening gmail.com", true);
		driver.get(GMAIL_URL);
		Reporter.log("enter Email: " + email, true);
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(LOGIN_ID))));
		driver.findElement(By.id(LOGIN_ID)).clear();
		driver.findElement(By.id(LOGIN_ID)).sendKeys(email + "\n");
		Reporter.log("enter Password: " + password, true);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.name("password"))));
		driver.findElement(By.name(PASSWORD_NAME)).clear();
		driver.findElement(By.name(PASSWORD_NAME)).sendKeys(password + "\n");
	}
	// search email wit specific command
	public void search(String search) {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions
			.visibilityOfElementLocated(By
					.xpath(INPUT_SEARCH_XPATH)));
		driver.findElement(By.xpath(INPUT_SEARCH_XPATH))
				.sendKeys(search);
		driver.findElement(By.xpath(BUTTON_SEARCH_XPATH)).click();
	}
	// open email
	public void openEmail() {
		driver.navigate().refresh();
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions
				.stalenessOf(driver.findElement(By
						.cssSelector("span.y2"))));
		Reporter.log("Open Email" , true);
		this.getEmail().get(0).click();
	}
	// get login name from email
	public String getLoginName() {
		return driver.findElement(By.cssSelector(EMAIL_TEXT_CSS_SELECTOR)).getText();
	}
	
	// logout from gmail.com
	public void logout() {
		driver.findElement(By.xpath(ACCAUNT_NAME_XPATH)).click();
		driver.findElement(By.id(LOGOUT_ID)).click();
	}
	
	// open new tab and switch to it
	public void switchToNewTab() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    
	    String winHandle = null;
		for (String newWinHandle : tabs) {
			winHandle = newWinHandle;
		}
		driver.switchTo().window(winHandle); //switches to new tab
	}
	// switch back to main screen and close opened tab
	public void switchBackToMainAndCloseOldTab() {
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.close();
		driver.switchTo().window(tabs.get(0)); // switch back to main screen
	}
	

}
