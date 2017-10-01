package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;

/**
 * Class representation of a Commissioner home page.
 */
public class CommissionerHomePage extends DropdownHomePage {

	public WebElement coowners;
	public WebElement activeCoowners;
	public WebElement inactiveCoowners;
	public WebElement nonConfirmedCoowners;
	public WebElement blockedCoowners;
	public WebElement registerNewUser;

	String COOWNERS_XPATH = "//a[@data-toggle=\"dropdown\"]";
	String ACTIVE_COOWNERS_XPATH = "//a[contains(@href,\"get-all-users\")]";
	String INACTIVE_COOWNERS_CSSSELECTOR = ".dropdown-menu [href$='inactive']";
	String NON_CONFIRMED_COOWNERS_XPATH = "//a[contains(@href,\"notcomfirmed\")]";
	String BLOCKED_COOWNERS_XPATH = "//a[contains(@href,\"block\")]";
	String REGISTERED_NEW_USER_XPATH = "//a[contains(@href,\"manualregistration\")]";

	public CommissionerHomePage(WebDriver driver) {
		super(driver);
	}

	public void clickCoowners() {
		clickUserName();
		getCoowners().click();
		getActiveCoowners();
		getInactiveCoowners();
		getNonConfirmedCoowners();
		getBlockedCoowners();
	}

	// getters
	public WebElement getCoowners() {
		return driver.findElement(By.xpath(COOWNERS_XPATH));
	}

	public WebElement getActiveCoowners() {
		return driver.findElement(By.xpath(ACTIVE_COOWNERS_XPATH));
	}

	public WebElement getInactiveCoowners() {
		return driver.findElement(By.cssSelector(INACTIVE_COOWNERS_CSSSELECTOR));
	}

	public WebElement getNonConfirmedCoowners() {
		return driver.findElement(By.xpath(NON_CONFIRMED_COOWNERS_XPATH));
	}

	public WebElement getBlockedCoowners() {
		return driver.findElement(By.xpath(BLOCKED_COOWNERS_XPATH));
	}

	public String getCoownersText() {
		return getCoowners().getText().trim();
	}

	public String getActiveCoownersText() {
		return getActiveCoowners().getText().trim();
	}

	public String getInactiveCoownersText() {
		return getInactiveCoowners().getText().trim();
	}

	public String getNonConfirmedCoownersText() {
		return getNonConfirmedCoowners().getText().trim();
	}

	public String getBlockedCoownersText() {
		return getBlockedCoowners().getText().trim();
	}

	public ActiveCoownersActionsDropdown clickActiveCoowners() {
		getActiveCoowners().click();
		return new ActiveCoownersActionsDropdown(driver);
	}

	public void clickInactiveCoowners() {
		getInactiveCoowners().click();
	}

	public void clickNonConfirmedCoowners() {
		getNonConfirmedCoowners().click();
	}

	public void clickBlockedCoowners() {
		getBlockedCoowners().click();
	}

	public WebElement getRegisterNewUser() {
		return driver.findElement(By.xpath(REGISTERED_NEW_USER_XPATH));
	}

	/**
	 * Verifies if register new user button is present on the LoginPage
	 * 
	 * @return True - if register button is present.
	 * @return False - if register button is NOT present.
	 */

	public boolean checkRegisterNewUserButtonExists() {
		return !driver.findElements(By.xpath(REGISTERED_NEW_USER_XPATH)).isEmpty();
	}

	@Override
	public CommissionerHomePage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		return new CommissionerHomePage(driver);
	}
}