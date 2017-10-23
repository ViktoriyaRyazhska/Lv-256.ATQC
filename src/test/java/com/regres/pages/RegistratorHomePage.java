package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistratorHomePage extends DropdownHomePage {
	// Fields
	WebElement resourcesSearch;
	WebElement subclassesOfObjects;

	private String RESOURCES_SEARCH_LOCATOR = ".dropdown>a";
	private String SUBCLASSES_OF_OBJECT_LOCATOR = ".//*[@id='navigationbar']/ul/li[3]/a";

	public RegistratorHomePage(WebDriver driver) {
		super(driver);
		//resourcesSearch = driver.findElement(By.cssSelector(RESOURCES_SEARCH_LOCATOR));
		//subclassesOfObjects = driver.findElement(By.xpath(SUBCLASSES_OF_OBJECT_LOCATOR));
	}

	public WebElement getResourcesSearch() {
		resourcesSearch = driver.findElement(By.cssSelector(RESOURCES_SEARCH_LOCATOR));
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
		subclassesOfObjects = driver.findElement(By.xpath(SUBCLASSES_OF_OBJECT_LOCATOR));
		return subclassesOfObjects;
	}

	public String getSubclassesOfObjectsText() {
		return getSubclassesOfObjects().getText();
	}

	public SubclassesOfObjects clickSubclassesOfObjects() {
		getSubclassesOfObjects().click();
		return SubclassesOfObjects.get(driver);
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