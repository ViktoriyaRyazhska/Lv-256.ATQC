package com.regres.pages;

import java.util.List;

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
	// private static volatile SubclassesOfObjects instance = null;

	String ADD_NEW_SUBCLASS_XPATH = "//a[contains(@href,\'addrestype\')]";
	String LIST_OF_ALL_SUBCLASS_XPATH = "//*[@id='body']/div/h4";
	String OK_BUTTON_XPATH = "//button[@data-bb-handler='confirm']";


	private static volatile SubclassesOfObjects instance = null;

	public static SubclassesOfObjects get(WebDriver driver) {
		if (instance == null) {
			synchronized (SubclassesOfObjects.class) {
				if (instance == null) {
					instance = new SubclassesOfObjects(driver);
				}
			}
		}
		return instance;
	}
	private SubclassesOfObjects(WebDriver driver) {
		super(driver);
		//listOfAllSubclassesTitle = driver.findElement(By.xpath(LIST_OF_ALL_SUBCLASS_XPATH));
		//addNewSubclass = driver.findElement(By.xpath(ADD_NEW_SUBCLASS_XPATH));

	}

	public WebElement getOkButton() {
		okButton = driver.findElement(By.xpath(OK_BUTTON_XPATH));
		return okButton;
	}

	public SubclassesOfObjects clickOkButton() {
		getOkButton().click();
		return SubclassesOfObjects.get(driver);
	}

	public WebElement getlistOfAllSubclassesTitle() {
		listOfAllSubclassesTitle = driver.findElement(By.xpath(LIST_OF_ALL_SUBCLASS_XPATH));
		return listOfAllSubclassesTitle;
	}

	public WebElement getAddNewSubclass() {
		addNewSubclass = driver.findElement(By.xpath(ADD_NEW_SUBCLASS_XPATH));
		return addNewSubclass;
	}

	public AddNewSubclassPage clickAddNewSubclass() {
		getAddNewSubclass().click();
		//new WebDriverWait(driver, 15).until(ExpectedConditions.stalenessOf(listOfAllSubclassesTitle));
		return AddNewSubclassPage.get(driver);
	}
	public SubclassesOfObjects clickOnDeleteSubclassButton(NewSubclass sub) {
		getDeleteSubclass(sub).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(getOkButton()));
		okButton.click();
		return SubclassesOfObjects.get(driver);
	}


	public WebElement getDeleteSubclass(NewSubclass sub) {
		deleteSubclass = driver.findElement(By.xpath("//td[contains(., '" + sub.getNameClasses() + "')]/following::a"));
		return deleteSubclass;

	}

	public WebElement getSubclassName(NewSubclass sub) {
		nameSubclass = driver.findElement(By.xpath("//td[contains(., '" + sub.getNameClasses() + "')]"));
		return nameSubclass;
	}

	public int getSubclassNameCount(NewSubclass sub) {
		List<WebElement> elements = driver.findElements(By.xpath("//td[contains(., '" + sub.getNameClasses() + "')]"));
		return elements.size();
	}
	
//	public boolean isEmpty(NewSubclass sub) {
//		boolean exists = !(driver.findElements(By.xpath("//td[contains(., '" + sub.getNameClasses() + "')]")).isEmpty());
//		return exists;
//	}

	public boolean hasSubclassName(NewSubclass sub) {
		nameSubclass = driver.findElement(By.xpath("//td[contains(., '" + sub.getNameClasses() + "')]"));
		return nameSubclass != null;
	}

	public WebElement getNameSubclassDB(NewSubclass sub) {
		nameSubclass = driver.findElement(By.xpath("//td[contains(., '" + sub.getNameClasses() + "')]"));
		return nameSubclass;
	}
}
