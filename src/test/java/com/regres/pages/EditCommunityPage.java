package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class represents Edit Community page which has all the same elements as Add
 * New Community page, so it extends the last one.
 */

public class EditCommunityPage extends AddNewCommunitiesPage {

	String EDIT_COMMUNITY_LABEL = "//h2";

	public EditCommunityPage(WebDriver driver) {
		super(driver);
	}

	// getters for elements
	public WebElement getEditNewCommunitiesPageLabel() {
		return driver.findElement(By.xpath(EDIT_COMMUNITY_LABEL));
	}

	// getters of elements text
	public String getEditNewCommunitiesPageLabelText() {
		return getEditNewCommunitiesPageLabel().getText().trim();
	}

	// method clears filled fields from previously created community and fills
	// it with new data
	// after what submits changes
	public AdminCommunitiesPage editCreatedCommunities(String communityName2, String regNumber2) {
		getCommunitiesName().clear();
		getCommunitiesName().sendKeys(communityName2);
		getCommunitiesRegistrationNumber().clear();
		getCommunitiesRegistrationNumber().sendKeys(regNumber2);
		getSubmitButton().click();
		return new AdminCommunitiesPage(driver);
	}
}
