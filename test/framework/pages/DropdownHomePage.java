package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class representation of drop-down list and home button .
 * 
 * @author Kryvenko Yaroslava
 *
 */

public abstract class DropdownHomePage extends TitleLocalFooter{
	public WebElement homeButton;
	public WebElement userName;
	public WebElement changePassword;
	public WebElement resetPassword;
	public WebElement menuDownButton;
	public WebElement logout;

	public DropdownHomePage (WebDriver driver) {
		super(driver);
		homeButton=driver.findElement(By.xpath("//*[@id=\"navigationbar\"]//following::a"));
		userName = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm"));
		menuDownButton = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle"));		
	}
	
	public void clickMenuDownButton (){
		getMenuDownButton().click();
		changePassword = driver.findElement(By.cssSelector(".change-password"));
		resetPassword = driver.findElement(By.cssSelector(".reset-my-password"));
		logout = driver.findElement(By.cssSelector("[href=\"/logout\"]"));
	}
	
	public WebElement getHomeButton() {return homeButton;}
	public void setHomeButton(WebElement homeButton) {this.homeButton = homeButton;}
	public WebElement getUserName() { return userName;}
	public void setUserName(WebElement userName) {this.userName = userName;}
	public WebElement getChangePassword() {return changePassword;}
	public void setChangePassword(WebElement changePassword) {this.changePassword = changePassword;}
	public WebElement getResetPassword() {return resetPassword;}
	public void setResetPassword(WebElement resetPassword) {this.resetPassword = resetPassword;}
	public WebElement getMenuDownButton() {return menuDownButton;}
	public void setMenuDownButton(WebElement downButton) {this.menuDownButton = downButton;}
	public WebElement getLogout() {return logout;}
	public void setLogout(WebElement logout) {this.logout = logout;}
	
	public String getHomeButtonText() {return getHomeButton().getText().trim();}
	public String getUserNameText() {return getUserName().getText().trim();}
	public String getChangePasswordText() {return getChangePassword().getText().trim();}
	public String getResetPasswordText() {return getResetPassword().getText().trim();}
	public String getMenuDownButtonText() {return getMenuDownButton().getText().trim();}
	public String getLogoutText() {return getLogout().getText().trim();}
	
	public void clickHomeButton() {getHomeButton().click();}
	public void clickUserName() { getUserName().click();}
//	public void getChangePassword() {getChangePassword().click();}
//	public void getResetPassword() {getResetPassword().click();}
	
	public void clickLogout() {getLogout().click();}
	
	public LoginPage successLogout() {
		clickMenuDownButton();	
		clickLogout();
		// Return a new page object representing the destination.
		return new LoginPage(driver);
	}
}



