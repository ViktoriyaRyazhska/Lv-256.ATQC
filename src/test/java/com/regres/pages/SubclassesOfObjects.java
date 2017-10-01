package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubclassesOfObjects extends RegistratorHomePage {
	public WebElement addNewSubclass;
	public WebElement listOfAllSubclassesTitle;
	public WebElement nameSubclass;
	String ADD_NEW_SUBCLASS_XPATH = "//a[contains(@href,\\'addrestype\\')]";
	String LIST_OF_ALL_SUBCLASS_XPATH = "//*[@id='body']/div/h4";
	// String DELETE_BUTTON_XPATH="//td[contains(., 'Sidney')]/following::a";
	String NAME_SUBCLASS_XPATH = "//td[contains(., 'Sidney')]";

	public SubclassesOfObjects(WebDriver driver) {
		super(driver);
		addNewSubclass=driver.findElement(By.xpath(ADD_NEW_SUBCLASS_XPATH));
		listOfAllSubclassesTitle=driver.findElement(By.xpath(LIST_OF_ALL_SUBCLASS_XPATH));
	}

	public WebElement getNameSubclas() {
		nameSubclass=driver.findElement(By.xpath(NAME_SUBCLASS_XPATH));
		return nameSubclass;
	}

	public WebElement getlistOfAllSubclassesTitle() {
		return listOfAllSubclassesTitle;
	}

	public WebElement getAddNewSubclass() {
		return addNewSubclass;
	}

	public AddNewSubclassPage clickAddNewSubclass() {
		addNewSubclass.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.stalenessOf(listOfAllSubclassesTitle));
		return new AddNewSubclassPage(driver);
	}

}
