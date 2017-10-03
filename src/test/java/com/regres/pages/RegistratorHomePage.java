package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;

public class RegistratorHomePage extends DropdownHomePage {
	// Fields
	WebElement resourcesSearch;
	WebElement subclassesOfObjects;
	WebElement procuration;
	WebElement addNewResource;
	//
	WebElement procurationEnteringData;
	WebElement procurationExtractFromRegister;

	public RegistratorHomePage(WebDriver driver) {
		super(driver);
		resourcesSearch = driver.findElement(By.cssSelector(".dropdown>a"));
		subclassesOfObjects = driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/a"));
		procuration = driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/a"));
		// procurationEnteringData =
		// driver.findElement(By.xpath(".//*[@id='menuForUser']"));
		// procurationExtractFromRegister =
		// driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/ul/li[2]/a"));
		addNewResource = driver.findElement(By.xpath("//a[contains(@href,\"resource/new\")]"));
	}

	// public void clickProcuration(WebDriver driver) {
	// procurationEnteringData =
	// driver.findElement(By.xpath(".//*[@id='menuForUser']"));
	// procurationExtractFromRegister =
	// driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/ul/li[2]/a"));
	// }

	public WebElement getResourcesSearch() {
		return resourcesSearch;
	}

	public String getResourcesSearchText() {
		return getResourcesSearch().getText();
	}

	public ResourcesSearchPage clickResourcesSearch() {
		getResourcesSearch().click();
		return new ResourcesSearchPage(driver);
	}

	public WebElement getSubclassesOfObjects() {
		return subclassesOfObjects;
	}

	public String getSubclassesOfObjectsText() {
		return getSubclassesOfObjects().getText();
	}

	public SubclassesOfObjects clickSubclassesOfObjects() {
		getSubclassesOfObjects().click();
		return new SubclassesOfObjects(driver);
	}

	public WebElement getProcuration() {
		return procuration;
	}

	public String getProcurationText() {
		return getProcuration().getText();
	}

	public void clickProcuration() {
		getProcuration().click();
	}

	public WebElement getAddNewResource() {
		return addNewResource;
	}

	public String getAddNewResourceText() {
		return getAddNewResource().getText();
	}

	public SubclassesOfObjects clickAddNewResource() {
		getAddNewResource().click();
		return new SubclassesOfObjects(driver);
	}

	// Business Logic
	@Override
	public RegistratorHomePage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new RegistratorHomePage(driver);
	}

}