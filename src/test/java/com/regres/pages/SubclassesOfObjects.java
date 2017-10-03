package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.regres.testdata.NewSubclass;

public class SubclassesOfObjects extends RegistratorHomePage {
	public WebElement addNewSubclass;
	public WebElement listOfAllSubclassesTitle;
	public WebElement deleteSubclass;
	private WebElement okButton;
	private WebElement nameSubclass;

	String ADD_NEW_SUBCLASS_XPATH = "//a[contains(@href,\'addrestype\')]";
	String LIST_OF_ALL_SUBCLASS_XPATH = "//*[@id='body']/div/h4";
	String OK_BUTTON_XPATH = "//button[@data-bb-handler='confirm']";

	public SubclassesOfObjects(WebDriver driver) {
		super(driver);
		listOfAllSubclassesTitle = driver.findElement(By.xpath(LIST_OF_ALL_SUBCLASS_XPATH));
		addNewSubclass = driver.findElement(By.xpath(ADD_NEW_SUBCLASS_XPATH));

	}

	public WebElement getOkButton() {
		okButton = driver.findElement(By.xpath(OK_BUTTON_XPATH));
		return okButton;
	}

	public SubclassesOfObjects clickOkButton() {
		getOkButton().click();
		return new SubclassesOfObjects(driver);
	}

	public WebElement getlistOfAllSubclassesTitle() {
		return listOfAllSubclassesTitle;
	}

	public WebElement getAddNewSubclass() {
		return addNewSubclass;
	}

	public AddNewSubclassPage clickAddNewSubclass() {
		getAddNewSubclass().click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.stalenessOf(listOfAllSubclassesTitle));
		return new AddNewSubclassPage(driver);
	}

	public SubclassesOfObjects clickOnDeleteSubclassButton(NewSubclass sub) {
		getDeleteSubclass(sub).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(getOkButton()));
		okButton.click();
		return new SubclassesOfObjects(driver);
	}

	public WebElement getDeleteSubclass(NewSubclass sub) {
		deleteSubclass = driver.findElement(By.xpath("//td[contains(., '" + sub.getNameClasses() + "')]/following::a"));
		return deleteSubclass;

	}

	public WebElement getSubclassName(NewSubclass sub) {
		nameSubclass = driver.findElement(By.xpath("//td[contains(., '" + sub.getNameClasses() + "')]"));
		return nameSubclass;
	}

	public WebElement getNameSubclassDB(NewSubclass sub) {
		nameSubclass = driver.findElement(By.xpath("//td[contains(., '" + sub.getNameClasses() + "')]"));
		return nameSubclass;
	}
}

