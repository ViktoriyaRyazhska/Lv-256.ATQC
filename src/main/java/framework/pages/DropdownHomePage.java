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

public class DropdownHomePage extends TitleLocalFooter{
	public WebDriver driver;
	public WebElement homeButton;
	public WebElement userName;
	public WebElement changePassword;
	public WebElement resetPassword;
	public WebElement downButton;
	public WebElement logout;

	public DropdownHomePage (WebDriver driver) {
		super(driver);
		homeButton=driver.findElement(By.xpath("//*[@id=\"navigationbar\"]//following::a"));
		userName = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm"));
		downButton = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle"));
		changePassword = driver.findElement(By.cssSelector(".change-password"));
		resetPassword = driver.findElement(By.cssSelector(".reset-my-password"));
		logout = driver.findElement(By.cssSelector("[href=\"/logout\"]"));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

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

//	public WebElement getDownButton() {
//		return downButton;
//	}
//
//	public void setDownButton(WebElement downButton) {
//		this.downButton = downButton;
//	}

	public WebElement getLogout() {
		return logout;
	}

	public void setLogout(WebElement logout) {
		this.logout = logout;
	}
}

