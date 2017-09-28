

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.pages.ConfirmMessage;

public class ActiveCoownersActionsDropdown extends CoownersTable{
	//Locators for actions for active co-owners
	By setRole=By.cssSelector(".dropdown-submenu>a");
	By setCommunity=By.cssSelector(".set-community");
	By resetPassword=By.cssSelector(".reset-password");
	By administratorRole = By.cssSelector(".set-role");
	By registratorRole = By.xpath("//a[@val=\"REGISTRATOR\"]");
	By coownerRole=By.xpath("//a[@val=\"USER\"]");
	By commissionerRole = By.xpath("//a[@val=\"COMMISSIONER\"]");
	
	public ConfirmMessage confirm;
	
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
		getSetRole().click();
		getAdministratorRole();
		getRegistratorRole();
		getCoownerRole();
		getCommissionerRole();
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
		confirm = new ConfirmMessage(driver);
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
		InactiveCoownersActionsDropdown windowMes = new InactiveCoownersActionsDropdown(driver);
		windowMes.simpleConfirmMessage();
	}
	
	public void clickResetPassword() {
		confirm = new ConfirmMessage(driver);
		getResetPassword().click();
	}
	public void clickAdministratorRole() {
		getAdministratorRole().click();
	}
	public void clickRegistratorRole() {
		getRegistratorRole().click();
	}
	public void clickCoownerRole() {
		getCoownerRole().click();
	}
	public void clickCommissionerRole() {
		getCommissionerRole().click();
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
