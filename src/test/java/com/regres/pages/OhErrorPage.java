package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This page appears when timezone(Admin->Settings->set timezone)
 * is set in the incorrect format
 * @author PETYAggg
 *
 */
public class OhErrorPage {
	
	private WebDriver driver;
	private WebElement errorTitle;
	private WebElement errorDescription;
	private WebElement goToHomePageButton;
	
	String ERROR_TITLE_XPATH = "//div[@class='alert alert-danger']/h3";
	String ERROR_DESCRIPTION_XPATH = "//div[@class='alert alert-danger']/p";
	String GO_TO_HOMEPAGE_BUTTON_CLASSNAME = "btn";
	
	public OhErrorPage(WebDriver driver) {
		
		this.driver= driver;
		this.errorTitle = driver.findElement(By.xpath(ERROR_TITLE_XPATH));
		this.errorDescription = driver.findElement(By.xpath(ERROR_DESCRIPTION_XPATH));
		this.goToHomePageButton = driver.findElement(By.className(GO_TO_HOMEPAGE_BUTTON_CLASSNAME));
	}

	public WebElement getErrorTitle() {
		return errorTitle;
	}

	public WebElement getErrorDescription() {
		return errorDescription;
	}

	public WebElement getGoToHomePageButton() {
		return goToHomePageButton;
	}
	
	public String getErrorTitleText() {
		return errorTitle.getText();
	}

	public String getErrorDescriptionText() {
		return errorDescription.getText();
	}

	public String getGoToHomePageButtonText() {
		return goToHomePageButton.getText();
	}
	
	public AdminHomePage clickGoToHomePageButton() {
		
		goToHomePageButton.click();
		return new AdminHomePage(driver);
	}
	
}
