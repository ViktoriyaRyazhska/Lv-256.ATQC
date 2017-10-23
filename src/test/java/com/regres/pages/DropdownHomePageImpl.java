package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * DropdownHomePageImpl Page Object
 * 
 * @author Юрій
 *
 */
public class DropdownHomePageImpl extends DropdownHomePage {
	private WebElement message;
	String MESSAGE_LOCATOR = "strong";

	/**
	 * Constructor that initiates dropdown elements
	 * 
	 * @param driver
	 *            - Selenium WebDriver
	 */
	public DropdownHomePageImpl(WebDriver driver) {
		super(driver);
		homeButton = driver.findElement(By.xpath(HOME_BUTTON_LOCATOR));
		userName = driver.findElement(By.cssSelector(USER_NAME_LOCATOR));
		menuDownButton = driver.findElement(By.cssSelector(MENU_DOWN_BUTTON_LOCATOR));
	}

	/**
	 * Constructor that initiates dropdown elements and succes message
	 * 
	 * @param driver
	 *            - Selenium WebDriver
	 * @param message
	 *            - succes message
	 */
	public DropdownHomePageImpl(WebDriver driver, WebElement message) {
		super(driver);
		homeButton = driver.findElement(By.xpath(HOME_BUTTON_LOCATOR));
		userName = driver.findElement(By.cssSelector(USER_NAME_LOCATOR));
		menuDownButton = driver.findElement(By.cssSelector(MENU_DOWN_BUTTON_LOCATOR));
		this.message = message;
	}

	/**
	 * 
	 * @return - succes message
	 */
	public WebElement getSuccesMessage() {
		message = driver.findElement(By.cssSelector(MESSAGE_LOCATOR));
		return message;

	}

	/**
	 * 
	 * @return visible text of succes message
	 */
	public String getMessageText() {
		return message.getText().trim();
	}

	/**
	 * changes language for the page
	 * 
	 * @return - new dropdown page
	 */
	@Override
	public DropdownHomePageImpl setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		return new DropdownHomePageImpl(driver);
	}

}
