package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommissionerWithRegistrationHomePage extends CommissionerHomePage {
	String REGISTRATION_CSSSELECTOR="[href=\"/manualregistration\"]";

	public CommissionerWithRegistrationHomePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getRegistration() {
		return driver.findElement(By.cssSelector(REGISTRATION_CSSSELECTOR));
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
