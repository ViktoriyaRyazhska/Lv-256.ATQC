package com.regres;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class has methods for testing on the "Subclass" page for the Registrar
 * 
 * @author Bohdan Zhyvko
 *
 */
public class SubclassesOfObjectsPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public void initWebDriver() {
		// initial property
		System.setProperty("webdriver.gecko.driver", 
				"resources//geckodriver.exe");// "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts()
			.implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
	}

	/**
	 * Go to RegRes, Log in and go to 'Subclasses of objects' tab
	 */
	public void precondition() {
		// go to RegRes LogIn page
		driver.get("http://regres.herokuapp.com/");//"http://java.training.local:8080/registrator/");
		// Log in to RegRes
		logIn();
		// Click on 'Subclasses of objects' tab
		clickOnSubclassesTab();
	}

	/**
	 * Log In to RegRes as "Registrator"
	 */
	public void logIn() {
		// choose English localization
		new Select(driver.findElement(By.id("changeLanguage")))
					.selectByValue("en");
		// clear login input field
		driver.findElement(By.id("login")).clear();
		// write login
		driver.findElement(By.id("login")).sendKeys("registrator");
		// clear password input field
		driver.findElement(By.id("password")).clear();
		// write password
		driver.findElement(By.id("password"))
			.sendKeys("registrator");
		driver.findElement(By.id("password")).submit();
		// click on 'Sign In'
	}
	
	/*----------------------------------Add Subclass----------------------------------*/
	
	/**
	 * Create new Subclass
	 */
	public void addSubclass() {
		// add new subclass
		driver.findElement(By.linkText("Add new subclass")).click();
		driver.findElement(By.name("typeName")).clear();
		driver.findElement(By.name("typeName")).sendKeys("Test");
		driver.findElement(By.id("valid")).click();
	}
	
	/*----------------------------------Delete Subclass----------------------------------*/

	/**
	 * Get confirm message text.
	 * 
	 * @return String of confirm message text.
	 */

	public String getConfirmMessageText() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.className("bootbox-body")));
		return driver.findElement(By.className("bootbox-body")).getText();
	}

	/**
	 * Get true - if subclass present on 'Subclasses' table,
	 * false - if subclass is
	 * not present on 'Subclasses' table
	 * 
	 * @param subclassName
	 *            - check the subclass name is present on 'Subclasses' table
	 * @return true/false
	 */
	public boolean isSubclassPresent(String subclassName) {
		// driver.get(driver.getCurrentUrl());
		driver.navigate().refresh();
		driver.manage().timeouts()
			.implicitlyWait(0, TimeUnit.MILLISECONDS);
		
		boolean exists = !(driver.findElements(By
				.xpath("//td[text() = '" + subclassName + "']"))
			.isEmpty());
		driver.manage().timeouts()
			.implicitlyWait(10, TimeUnit.SECONDS);
		return exists;
	}

	/**
	 * Delete subclass
	 * 
	 * @param subclassName
	 *            - delete the subclass from 'Subclasses' table
	 */
	public void deleteSubclass(String subclassName) {
		clickOnDeleteSubclassButton(subclassName);
		// Wait for delete confirm message
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.className("bootbox-body")));
		// Clock 'OK' - button
		clickOnOkButton();
	}

	/**
	 * Click on subclass 'Delete' button by subclass
	 *  name on confirm message
	 */
	public void clickOnDeleteSubclassButton(String subclassName) {
		driver.findElement(By
				.xpath("//td[text() = '" 
						+ subclassName + "']/following::a"))
		.click();
	}

	/**
	 * Click on 'OK' button on confirm message
	 */
	public void clickOnOkButton() {
		driver.findElement(By
				.xpath("//button[@class = 'btn btn-primary']"))
		.click();
	}

	/**
	 * Click on 'Close' button on confirm message
	 */
	public void clickOnCloseButton() {
		driver.findElement(By.className("close")).click();
	}

	/**
	 * Click on 'Cancel' button on confirm message
	 */
	public void clickOnCancelButton() {
		driver.findElement(By.cssSelector(".btn.btn-default"))
			.click();
	}

	/**
	 * Click on 'Subclasses of objects' tab
	 */
	public void clickOnSubclassesTab() {
		driver.findElement(By
				.partialLinkText("Subclasses of objects"))
					.click();
	}

	/*----------------------------------Close driver----------------------------------*/
	/**
	 * Close web driver
	 */
	public void quit() {
		driver.quit();
	}

}
