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

	public CommissionerHomePage(WebDriver driver) {
		super(driver);
		coowners = driver.findElement(By.xpath("//a[@data-toggle=\"dropdown\"]"));
	}

	public void clickCoowners() {
		clickUserName();
		coowners.click();
		activeCoowners = driver.findElement(By.xpath("//a[contains(@href,\"get-all-users\")]"));
		inactiveCoowners = driver.findElement(By.cssSelector(".dropdown-menu [href$='inactive']"));
		nonConfirmedCoowners = driver.findElement(By.xpath("//a[contains(@href,\"notcomfirmed\")]"));
		blockedCoowners = driver.findElement(By.xpath("//a[contains(@href,\"block\")]"));
		registerNewUser = driver.findElement(By.xpath("//a[contains(@href,\"manualregistration\")]"));
		registerNewUser = driver.findElement(By.xpath("//a[contains(@href,\"mixedregistration\")]"));
	}

	public WebElement getCoowners() {
		return coowners;
	}

	public void setCoowners(WebElement coowners) {
		this.coowners = coowners;
	}

	public WebElement getActiveCoowners() {
		return activeCoowners;
	}

	public void setActiveCoowners(WebElement activeCoowners) {
		this.activeCoowners = activeCoowners;
	}

	public WebElement getInactiveCoowners() {
		return inactiveCoowners;
	}

	public void setInactiveCoowners(WebElement inactiveCoowners) {
		this.inactiveCoowners = inactiveCoowners;
	}

	public WebElement getNonConfirmedCoowners() {
		return nonConfirmedCoowners;
	}

	public void setNonConfirmedCoowners(WebElement nonConfirmedCoowners) {
		this.nonConfirmedCoowners = nonConfirmedCoowners;
	}

	public WebElement getBlockedCoowners() {
		return blockedCoowners;
	}

	public void setBlockedCoowners(WebElement blockedCoowners) {
		this.blockedCoowners = blockedCoowners;
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
		return registerNewUser;
	}

	public void setRegisterNewUser(WebElement registerNewUser) {
		this.registerNewUser = registerNewUser;
	}

	public String getRegisterNewUserText() {
		return getRegisterNewUser().getText().trim();
	}

	@Override
	public CommissionerHomePage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		return new CommissionerHomePage(driver);
	}
}