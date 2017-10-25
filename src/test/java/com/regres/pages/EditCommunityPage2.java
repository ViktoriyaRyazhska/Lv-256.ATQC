package com.regres.pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class represents Edit Community page which has all the same elements as Add
 * New Community page, so it extends the last one.
 */

public class EditCommunityPage2 extends AdminHomePage {
	String COMMUNITIES_NAME_FILED_NAME = "name";
	String REG_NUMBER_FILED_NAME = "registrationNumber";
	String SUBMIT_BUTTON_XPATH = "//input[@type='submit']";
	String EDIT_COMMUNITY_LABEL = "//h2";

	
	private static volatile EditCommunityPage2 instance = null;

	public EditCommunityPage2(WebDriver driver) {
		super(driver);
	}

	public static EditCommunityPage2 get(WebDriver driver) {
		if (instance == null) {
			synchronized (EditCommunityPage2.class) {
				if (instance == null) {
					instance = new EditCommunityPage2(driver);
				}
			}
		}
		return instance;
	}
	
	// getters for elements
	public WebElement getEditNewCommunitiesPageLabel() {
		return driver.findElement(By.xpath(EDIT_COMMUNITY_LABEL));
	}

	// getters of elements text
	public String getEditNewCommunitiesPageLabelText() {
		return getEditNewCommunitiesPageLabel().getText().trim();
	}
	public WebElement getCommunitiesName() {
		return driver.findElement(By.name(COMMUNITIES_NAME_FILED_NAME));
	}
	public WebElement getCommunitiesRegistrationNumber() {
		return driver.findElement(By.name(REG_NUMBER_FILED_NAME));
	}
	public WebElement getSubmitButton() {
		return driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH));
	}
	
	// method clears filled fields from previously created community and fills
	// it with new data
	// after what submits changes
	public AdminCommunitiesPage2 editCreatedCommunities(String communityName2, String regNumber2) {
		getCommunitiesName().clear();
		getCommunitiesName().sendKeys(communityName2);
		getCommunitiesRegistrationNumber().clear();
		getCommunitiesRegistrationNumber().sendKeys(regNumber2);
		getSubmitButton().click();
		return AdminCommunitiesPage2.get(driver);
	}
}
