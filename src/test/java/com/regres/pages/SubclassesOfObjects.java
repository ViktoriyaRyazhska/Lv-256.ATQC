package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubclassesOfObjects extends RegistratorHomePage {
	public WebElement addNewSubclass;
	public WebElement listOfAllSubclassesTitle;
	public WebElement nameSubclassSidney;
	public WebElement nameSubclassIvano_Frankivsk;
	public WebElement deleteSubclassSidney; // Шукаю кнопку "Видалити" за назваю сабкласу "Sidney"
	public WebElement deleteSubclassIvanoFrankivsk; // Шукаю кнопку "Видалити" за назваю сабкласу "Ivano-Frankivsk"
	private WebElement okButton;
	

	String ADD_NEW_SUBCLASS_XPATH = "//a[contains(@href,\'addrestype\')]";
	String LIST_OF_ALL_SUBCLASS_XPATH = "//*[@id='body']/div/h4";
	String NAME_SUBCLASS_XPATH = "//td[contains(., 'Sidney')]";
	String DELETE_BUTTON_XPATH = "//td[contains(., 'Sidney')]/following::a";
	String DELETE_BUTT_XPATH = "//td[contains(., 'Ivano-Frankivsk')]/following::a";
	String NAME_SUB_XPATH = "//td[contains(., 'Ivano-Frankivsk')]";
	String OK_BUTTON_XPATH = "//button[@data-bb-handler='confirm']";
	
	public SubclassesOfObjects(WebDriver driver) {
		super(driver);
		listOfAllSubclassesTitle = driver.findElement(By.xpath(LIST_OF_ALL_SUBCLASS_XPATH));
		addNewSubclass = driver.findElement(By.xpath(ADD_NEW_SUBCLASS_XPATH));
		

	}
	public WebElement getOkButton() {
		okButton=driver.findElement(By.xpath(OK_BUTTON_XPATH));
		return okButton;
	}

	public WebElement getNameSubclass() {
		nameSubclassSidney = driver.findElement(By.xpath(NAME_SUBCLASS_XPATH));
		return nameSubclassSidney;
	}

	public WebElement getNameSub() {
		nameSubclassIvano_Frankivsk = driver.findElement(By.xpath(NAME_SUB_XPATH));
		return nameSubclassIvano_Frankivsk;
	}

	public WebElement getDeleteSubclassSidney() {
		deleteSubclassSidney = driver.findElement(By.xpath(DELETE_BUTTON_XPATH));
		return deleteSubclassSidney;
	}

	public WebElement getdeleteSubclassIvano_Frankivsk() {
		deleteSubclassIvanoFrankivsk = driver.findElement(By.xpath(DELETE_BUTT_XPATH));
		return deleteSubclassIvanoFrankivsk;
	}

	public WebElement getlistOfAllSubclassesTitle() {
		return listOfAllSubclassesTitle;
	}

	public WebElement getAddNewSubclass() {
	//	addNewSubclass = driver.findElement(By.xpath(ADD_NEW_SUBCLASS_XPATH));
		return addNewSubclass;
	}

	public AddNewSubclassPage clickAddNewSubclass() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(listOfAllSubclassesTitle));
		getAddNewSubclass().click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.stalenessOf(listOfAllSubclassesTitle));
		return new AddNewSubclassPage(driver);
	}

	public void clickOnDeleteSubclassButton() {
		getDeleteSubclassSidney().click();
		
	}
	public void clickDeleteSubclassButton() {
		
		
		getdeleteSubclassIvano_Frankivsk().click();
		
	}
	public SubclassesOfObjects clickOkButton() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(getOkButton()));
		okButton.click();
		new WebDriverWait(driver, 5);
		return new SubclassesOfObjects(driver);
	}
	
	

}