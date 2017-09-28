package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommissionerWithRegistrationHomePage extends CommissionerHomePage {
	public WebElement registration;

	public CommissionerWithRegistrationHomePage(WebDriver driver) {
		super(driver);
		registration = driver.findElement(By.cssSelector("[href=\"/manualregistration\"]"));
	}

	public WebElement getRegistration() {
		return registration;
	}

	public void setRegistration(WebElement registration) {
		this.registration = registration;
	}

	public void clickRegistration() {
		getRegistration().click();
	}

	// Business Logic
	@Override
	public CommissionerWithRegistrationHomePage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new CommissionerWithRegistrationHomePage(driver);
	}
}
