package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.regres.tests.AddNewResourceTest;

public class RegistratorHomePage extends DropdownHomePage {
	// Fields
	WebElement resourcesSearch;
	WebElement subclassesOfObjects;
	WebElement addNewResourceNavTab;

	private String RESOURCES_SEARCH_LOCATOR = ".dropdown>a";
	private String SUBCLASSES_OF_OBJECT_LOCATOR = ".//*[@id='navigationbar']/ul/li[3]/a";
	private String ADD_NEW_RESOURCE_NAV_TAB_LOCATOR = "[href*='registrator/resource/new'";

	public RegistratorHomePage(WebDriver driver) {
		super(driver);
		resourcesSearch = driver.findElement(By.cssSelector(RESOURCES_SEARCH_LOCATOR));
		subclassesOfObjects = driver.findElement(By.xpath(SUBCLASSES_OF_OBJECT_LOCATOR));
		addNewResourceNavTab = driver.findElement(By.cssSelector(ADD_NEW_RESOURCE_NAV_TAB_LOCATOR));
	}

	public AddNewResourcePage clickAddNewResourceNavTab() {
		addNewResourceNavTab.click();
		return new AddNewResourcePage(driver);
	}
	public WebElement getAddNewResourceNavTab() {
		return addNewResourceNavTab;
	}


	public void setAddNewResourceNavTab(WebElement addNewResourceNavTab) {
		this.addNewResourceNavTab = addNewResourceNavTab;
	}


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

	// Business Logic
	@Override
	public RegistratorHomePage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new RegistratorHomePage(driver);
	}
}