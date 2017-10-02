package com.regres.pages.manage.coowners.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.manage.coowners.CoownersTable;

public class ActiveCoownersActionsDropdown extends CoownersTable {
	// Locators for actions for active co-owners
	String SET_ROLE_CSSSELECTOR = ".dropdown-submenu>a";
	String SET_COMMUNITY_CSSSELECTOR = ".set-community";
	String RESET_PASSWORD_CSSSELECTOR = ".reset-password";
	String ADMINISTRATOR_ROLE_CSSSELECTOR = ".set-role";
	String REGISTRATOR_ROLE_XPATH = "//a[@val=\"REGISTRATOR\"]";
	String COOWNER_ROLE_XPATH ="//a[@val=\"USER\"]";
	String COMMISSIONER_ROLE_XPATH = "//a[@val=\"COMMISSIONER\"]";

	By communitiesName = By.className(".communName");

	//Locators for Confirm message window
	String OK_BUTTON_XPATH = "//button[@data-bb-handler='ok']";
	String CLOSE_BUTTON_CLASS_NAME = "close";
	String CANSEL_BUTTON_CSSSELECTOR = ".btn.btn-info";
	String TITLE_MESSAGE_CLASS_NAME = "modal-title";
	String LABEL_CLASS_NAME = "control-label";
	
	
	public ActiveCoownersActionsDropdown(WebDriver driver) {
		super(driver);
	}

	public void clickActionsDropdown() {
		getActions().click();
		getSetRole();
		getSetCommunity();
		getResetPassword();
	}

	public void clickSetRole() {
		// Initiate mouse action using Actions class
		Actions builder = new Actions(driver);
		// move the mouse to the earlier identified menu option
		builder.moveToElement(getSetRole()).build().perform();
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(COMMISSIONER_ROLE_XPATH))); 
		
		getAdministratorRole();
		getRegistratorRole();
		getCoownerRole();
		getCommissionerRole();
	}

	public void initConfMessage() {
		InactiveCoownersActionsDropdown windowMes = new InactiveCoownersActionsDropdown(driver);
		windowMes.simpleConfirmMessage();
		confirm = windowMes.getConfirmMessage();
	}

	public WebElement getSetRole() {
		return driver.findElement(By.cssSelector(SET_ROLE_CSSSELECTOR));
	}

	public WebElement getSetCommunity() {
		return driver.findElement(By.cssSelector(SET_COMMUNITY_CSSSELECTOR));
	}

	public WebElement getResetPassword() {
		return driver.findElement(By.cssSelector(RESET_PASSWORD_CSSSELECTOR));
	}

	public WebElement getAdministratorRole() {
		return driver.findElement(By.cssSelector(ADMINISTRATOR_ROLE_CSSSELECTOR));
	}

	public WebElement getRegistratorRole() {
	return driver.findElement(By.xpath(REGISTRATOR_ROLE_XPATH));
	}

	public WebElement getCoownerRole() {
		return driver.findElement(By.xpath(COOWNER_ROLE_XPATH));
	}

	public WebElement getCommissionerRole() {
		return driver.findElement(By.xpath(COMMISSIONER_ROLE_XPATH));
	}

	public void clickSetCommunity() {
		getSetCommunity().click();
		confirm = new ConfirmMessagePage(driver);
		// initialize these elements on 'Set community' confirm message
		confirm.setOkButton(driver.findElement(By.xpath("//button[@data-bb-handler='ok']")));
		confirm.setCloseButton(driver.findElement(By.className("close")));
		confirm.setCancelButton(driver.findElement(By.cssSelector(".btn.btn-info")));
		confirm.setTitleMessage(driver.findElement(By.className("modal-title")));
		confirm.setLabel(driver.findElement(By.className("control-label")));
		confirm.setInput(driver.findElement(By.id("tc_search")));
	}

	public void clickSetCommunityNotSelected() {
		getSetCommunity().click();
		initConfMessage();
	}

	public void clickResetPassword() {
		getResetPassword().click();
		initConfMessage();
	}

	public void clickAdministratorRole() {
		getAdministratorRole().click();
		initConfMessage();
	}

	public void clickRegistratorRole() {
		getRegistratorRole().click();
		initConfMessage();
	}

	public void clickCoownerRole() {
		getCoownerRole().click();
		initConfMessage();
	}

	public void clickCommissionerRole() {
		getCommissionerRole().click();
		initConfMessage();
	}

	public String getSetRoleText() {
		return getSetRole().getText().trim();
	}

	public String getSetCommunityText() {
		return getSetCommunity().getText().trim();
	}

	public String getResetPasswordText() {
		return getResetPassword().getText().trim();
	}

	public String getAdministratorRoleText() {
		return getResetPassword().getText().trim();
	}

	public String getRegistratorRoleText() {
		return getRegistratorRole().getText().trim();
	}

	public String getCoownerRoleText() {
		return getCoownerRole().getText().trim();
	}

	public String getCommissionerRoleText() {
		return getCommissionerRole().getText().trim();
	}

}
