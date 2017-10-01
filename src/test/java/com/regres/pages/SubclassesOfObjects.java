package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubclassesOfObjects extends RegistratorHomePage {
	public WebElement addNewSubclass;
	public WebElement listOfAllSubclassesTitle;
	public WebElement nameSubclassS;
	public WebElement nameSubclassI;
	public WebElement deleteSubclassS;
	public WebElement deleteSubclassI;

	String ADD_NEW_SUBCLASS_XPATH = "//a[contains(@href,\'addrestype\')]";
	String LIST_OF_ALL_SUBCLASS_XPATH = "//*[@id='body']/div/h4";
	String NAME_SUBCLASS_XPATH = "//td[contains(., 'Sidney')]";
	String DELETE_BUTTON_XPATH = "\"//td[contains(., 'Sidney')]/following::a";
	String DELETE_BUTT_XPATH = "//td[contains(., 'Ivano-Frankivsk')]/following::a";
	String NAME_SUB_XPATH = "//td[contains(., 'Ivano-Frankivsk')]";

	public SubclassesOfObjects(WebDriver driver) {
		super(driver);
		addNewSubclass = driver.findElement(By.xpath(ADD_NEW_SUBCLASS_XPATH));
		listOfAllSubclassesTitle = driver.findElement(By.xpath(LIST_OF_ALL_SUBCLASS_XPATH));
	}

	public WebElement getNameSubclas() {
		nameSubclassS = driver.findElement(By.xpath(NAME_SUBCLASS_XPATH));
		return nameSubclassS;
	}

	public WebElement getNameSub() {
		nameSubclassI = driver.findElement(By.xpath(NAME_SUB_XPATH));
		return nameSubclassI;
	}

	public WebElement getDeleteSubclassS() {
		return deleteSubclassS;
	}

	public WebElement getDeleteSubclassI() {
		return deleteSubclassI;
	}

	public SubclassesOfObjects clickDeleteSubclass() {
		getDeleteSubclassS().click();
		return new SubclassesOfObjects(driver);
	}
	public SubclassesOfObjects clickDeleteSub() {
		getDeleteSubclassI().click();
		return new SubclassesOfObjects(driver);
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
