package com.regres.pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewCommunitiesPage2 extends AdminHomePage {

	String COMMUNITIES_NAME_FILED_NAME = "name";
	String REG_NUMBER_FILED_NAME = "registrationNumber";
	String SUBMIT_BUTTON_XPATH = "//input[@type='submit']";
	String CLEAR_FORM_BUTTON_XPATH = "//button[@type='reset']";
	String COMMUNITIES_NAME_LABEL_XPATH = "//div[1]/label";
	String REG_NUMBER_LABEL_XPATH = "//div[2]/label";
	String ADD_COMMUNITY_PAGE_LABEL_XPATH = "//h2";
	String REGISTRATION_NUMBER_ERROR_ID = "registrationNumber.errors";

	
	private static volatile AddNewCommunitiesPage2 instance = null;

	public AddNewCommunitiesPage2(WebDriver driver) {
		super(driver);
	}

	public static AddNewCommunitiesPage2 get(WebDriver driver) {
		if (instance == null) {
			synchronized (AddNewCommunitiesPage2.class) {
				if (instance == null) {
					instance = new AddNewCommunitiesPage2(driver);
				}
			}
		}
		return instance;
	}
	
	// getters for elements on a page
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

	// getters of text from elements on a page
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

	// clicks on elements on a page
	public void clickClearFormButton() {
		getClearFormButton().click();
	}

	public void clickSubmitButton() {
		getSubmitButton().click();
	}

	// method that creates new community
	public AdminCommunitiesPage2 createNewCommunities(String communityName, String regNumber) {
		getCommunitiesName().clear();
		getCommunitiesName().sendKeys(communityName);
		getCommunitiesRegistrationNumber().clear();
		getCommunitiesRegistrationNumber().sendKeys(regNumber);
		clickSubmitButton();
		return AdminCommunitiesPage2.get(driver);
	}

	// method that fills communities name and reg number
	public void fillInNameandRegNumber(String communityName, String regNumber) {
		getCommunitiesName().clear();
		getCommunitiesName().sendKeys(communityName);
		getCommunitiesRegistrationNumber().clear();
		getCommunitiesRegistrationNumber().sendKeys(regNumber);
	}

	// method that clears name field and fills reg number field for community
	public void clearNameAndfillIndRegNumber(String regNumber) {
		getCommunitiesName().clear();
		getCommunitiesRegistrationNumber().clear();
		getCommunitiesRegistrationNumber().sendKeys(regNumber);
	}

}
