package com.regres.pages.manage.coowners.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.manage.coowners.CoownersTable;

public class ActiveCoownersActionsDropdown extends CoownersTable{
	//Locators for actions for active co-owners
	By setRole=By.cssSelector(".dropdown-submenu>a");
	By setCommunity=By.cssSelector(".set-community");
	By resetPassword=By.cssSelector(".reset-password");
	By administratorRole = By.cssSelector(".set-role");
	By registratorRole = By.xpath("//a[@val=\"REGISTRATOR\"]");
	By coownerRole=By.xpath("//a[@val=\"USER\"]");
	By commissionerRole = By.xpath("//a[@val=\"COMMISSIONER\"]");
	
	By communitiesName = By.className(".communName");//taras
	
	public ActiveCoownersActionsDropdown(WebDriver driver) {
		super(driver);				
	}
//	public  String getCommunitiesName() {//taras
//		
//	List<WebElement> drop = driver.findElements(communitiesName);
//	java.util.Iterator<WebElement> i = drop.iterator();
//	while(i.hasNext()) {
//	    WebElement row = i.next();
//	    return row.getText();
//	  }
//	return null;
//	}
	
	public void clickActionsDropdown() {
		getActions().click();
		getSetRole();
		getSetCommunity();
		getResetPassword();
	}
	public void clickSetRole() {
		//Initiate mouse action using Actions class
		Actions builder = new Actions(driver); 
		// move the mouse to the earlier identified menu option		
		builder.moveToElement(getSetRole()).build().perform();
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.
				presenceOfElementLocated(commissionerRole));  // until this submenu is found
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
		return driver.findElement(setRole);
	}
	
	public WebElement getSetCommunity() {
		return driver.findElement(setCommunity);
	}
	public WebElement getResetPassword() {
		return driver.findElement(resetPassword);
	}
	public WebElement getAdministratorRole() {
		return driver.findElement(administratorRole);
	}
	public WebElement getRegistratorRole() {
		return driver.findElement(registratorRole);
	}
	public WebElement getCoownerRole() {
		return driver.findElement(coownerRole);
	}
	public WebElement getCommissionerRole() {
		return driver.findElement(commissionerRole);
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
	public void clickCoownerRole(){
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
