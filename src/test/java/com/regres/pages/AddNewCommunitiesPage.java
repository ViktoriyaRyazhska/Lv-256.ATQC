/**
 * 
 */
package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

public class AddNewCommunitiesPage extends AdminHomePage{
	
	String COMMUNITIES_NAME_FILED_NAME = "name";
	String REG_NUMBER_FILED_NAME = "registrationNumber";
	String SUBMIT_BUTTON_XPATH = "//input[@type='submit']";
	String CLEAR_FORM_BUTTON_XPATH = "//button[@type='reset']";
	String COMMUNITIES_NAME_LABEL_XPATH = "//div[1]/label";
	String REG_NUMBER_LABEL_XPATH = "//div[2]/label";
	String ADD_COMMUNITY_PAGE_LABEL_XPATH = "//h2";
	String REGISTRATION_NUMBER_ERROR_ID = "registrationNumber.errors";
	
	public AddNewCommunitiesPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getCommunitiesName() {
		return driver.findElement(By.name(COMMUNITIES_NAME_FILED_NAME));
	}
	public WebElement getRegError() {
		return driver.findElement(By.id(REGISTRATION_NUMBER_ERROR_ID));
	}
	
	public WebElement getCommunitiesRegistrationNumber() {
		return driver.findElement(By.name(REG_NUMBER_FILED_NAME));
	}

	public WebElement getSubmitButton() {
		return driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH));
	}

	public WebElement getClearFormButton() {
		return driver.findElement(By.xpath(CLEAR_FORM_BUTTON_XPATH));
	}

	public WebElement getCommunitiesNameLabel() {
		return driver.findElement(By.xpath(COMMUNITIES_NAME_LABEL_XPATH));
	}

	public WebElement getCommunitiesRegistrationNumberLabel() {
		return driver.findElement(By.xpath(REG_NUMBER_LABEL_XPATH));
	}

	public WebElement getAddNewCommunitiesPageLabel() {
		return driver.findElement(By.xpath(ADD_COMMUNITY_PAGE_LABEL_XPATH));
	}
	public String getSubmitButtonText() {
		return getSubmitButton().getText().trim();
	}
	public String getClearFormButtonText() {
		return getClearFormButton().getText().trim();
	}
	public String getCommunitiesNameLabelText() {
		return getCommunitiesNameLabel().getText().trim();
	}
	public String getCommunitiesRegistrationNumberLabelText() {
		return getCommunitiesRegistrationNumberLabel().getText().trim();
	}
	public String getAddNewCommunitiesPageLabelText() {
		return getAddNewCommunitiesPageLabel().getText().trim();
	}
	public String getRegErrorText() {
		return getRegError().getText().trim();
	}
	public String getCommunitiesNameText() {
		return getCommunitiesName().getText().trim();
	}
	public String getRegistrationNumberText() {
		return getCommunitiesRegistrationNumber().getText().trim();
	}
	public void clickClearFormButton() {
		getClearFormButton().click();
	}
	public void clickSubmitButton() {
		getSubmitButton().click();
	}
	
	
	public AdminCommunitiesPage createNewCommunities(String name, String number){
		getCommunitiesName().clear();
		getCommunitiesName().sendKeys(name);
		getCommunitiesRegistrationNumber().clear();
		getCommunitiesRegistrationNumber().sendKeys(number);
		clickSubmitButton();
		return new AdminCommunitiesPage(driver);
	}
	
	public AdminCommunitiesPage inputIncorrectDataInRegNumber(String name, String number){
		getCommunitiesName().clear();
		getCommunitiesName().sendKeys(name);
		getCommunitiesRegistrationNumber().clear();
		getCommunitiesRegistrationNumber().sendKeys(number);
		clickSubmitButton();
		return new AdminCommunitiesPage(driver);
	}
	
	public void fillInNameandRegNumber(String name, String number){
		getCommunitiesName().clear();
		getCommunitiesName().sendKeys(name);
		getCommunitiesRegistrationNumber().clear();
		getCommunitiesRegistrationNumber().sendKeys(number);
		
	}
	
	public void clearNameAndfillIndRegNumber(String number){
		getCommunitiesName().clear();
		getCommunitiesRegistrationNumber().clear();
		getCommunitiesRegistrationNumber().sendKeys(number);
		}

}
