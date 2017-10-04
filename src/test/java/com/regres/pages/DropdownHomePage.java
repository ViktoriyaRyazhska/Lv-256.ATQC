package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;

/**
 * Class representation of drop-down list and home button .
 */

public class DropdownHomePage extends TitleLocalFooter {
	public WebElement homeButton;
	public WebElement userName;
	public WebElement changePassword;
	public WebElement resetPassword;
	public WebElement menuDownButton;
	public WebElement logout;
	protected String HOME_BUTTON_LOCATOR = "//*[@id=\"navigationbar\"]//following::a";
	protected String USER_NAME_LOCATOR = ".btn.btn-primary.btn-sm";
	protected String MENU_DOWN_BUTTON_LOCATOR = ".btn.btn-primary.btn-sm.dropdown-toggle";
	protected String CHANGE_PASSWORD_LOCATOR = ".change-password";
	protected String RESET_PASSWORD_LOCATOR = ".reset-my-password";
	protected String LOGOUT_LOCATOR = "[href*='/logout']";

	/**
	 * Constructor
	 * 
	 * @param driver
	 *            - Selenium WebDriver
	 */
	public DropdownHomePage(WebDriver driver) {
		super(driver);
		homeButton = driver.findElement(By.xpath(HOME_BUTTON_LOCATOR));
		userName = driver.findElement(By.cssSelector(USER_NAME_LOCATOR));
		menuDownButton = driver.findElement(By.cssSelector(MENU_DOWN_BUTTON_LOCATOR));
	}
/**
 * clicks on dropdown menu and initiates dropdown elements
 */
	public void clickMenuDownButton() {
		getMenuDownButton().click();
		changePassword = driver.findElement(By.cssSelector(CHANGE_PASSWORD_LOCATOR));
		resetPassword = driver.findElement(By.cssSelector(RESET_PASSWORD_LOCATOR));
		logout = driver.findElement(By.cssSelector(LOGOUT_LOCATOR));
	}

	// Getters and Setters
	public WebElement getHomeButton() {
		return homeButton;
	}

	public void setHomeButton(WebElement homeButton) {
		this.homeButton = homeButton;
	}

	public WebElement getUserName() {
		return userName;
	}

	public void setUserName(WebElement userName) {
		this.userName = userName;
	}

	public WebElement getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(WebElement changePassword) {
		this.changePassword = changePassword;
	}

	public WebElement getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(WebElement resetPassword) {
		this.resetPassword = resetPassword;
	}

	public WebElement getMenuDownButton() {
		return menuDownButton;
	}

	public void setMenuDownButton(WebElement downButton) {
		this.menuDownButton = downButton;
	}

	public WebElement getLogout() {
		return logout;
	}

	public void setLogout(WebElement logout) {
		this.logout = logout;
	}

	// returns visible text on the element
	public String getHomeButtonText() {
		return getHomeButton().getText().trim();
	}

	public String getUserNameText() {
		return getUserName().getText().trim();
	}

	public String getChangePasswordText() {
		return getChangePassword().getText().trim();
	}

	public String getResetPasswordText() {
		return getResetPassword().getText().trim();
	}

	public String getMenuDownButtonText() {
		return getMenuDownButton().getText().trim();
	}

	public String getLogoutText() {
		return getLogout().getText().trim();
	}

	// clicks homeButton
	public void clickHomeButton() {
		getHomeButton().click();
	}

	// clicks userName
	public void clickUserName() {
		getUserName().click();
	}

	// public void getChangePassword() {getChangePassword().click();}
	// public void getResetPassword() {getResetPassword().click();}
	/**
	 * Clicks logout
	 * 
	 * @return new Login page
	 */

	public LoginPage clickLogout() {
		clickMenuDownButton();
		getLogout().click();
		// Return a new page object representing the destination.
		return new LoginPage(driver);
	}

	/**
	 * changes language for the page
	 * 
	 * @return - new dropdown page
	 */
	@Override
	public DropdownHomePage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new DropdownHomePage(driver);
	}

	/**
	 * Gets on password change page
	 * 
	 * @return - new password change page
	 */
	public ChangePasswordPage clickChangePassword() {
		clickMenuDownButton();
		getChangePassword().click();
		return new ChangePasswordPage(driver);

	}

	/**
	 * Gets on password change page
	 * 
	 * @return - new password change page
	 */
	public ChangePasswordPage changePassword() {
		getChangePassword().click();
		return new ChangePasswordPage(driver);
	}
}
