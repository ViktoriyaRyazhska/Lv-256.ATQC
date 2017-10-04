package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditCommunityPage extends AddNewCommunitiesPage {

	String EDIT_COMMUNITY_LABEL = "//h2";

	public EditCommunityPage(WebDriver driver) {
		super(driver);

	}

	public WebElement getEditNewCommunitiesPageLabel() {
		return driver.findElement(By.xpath(EDIT_COMMUNITY_LABEL));
	}

	public String getEditNewCommunitiesPageLabelText() {
		return getEditNewCommunitiesPageLabel().getText().trim();
	}
	
	public AdminCommunitiesPage editCreatedCommunities(String name2, String number2){
		getCommunitiesName().clear();
		getCommunitiesName().sendKeys(name2);
		getCommunitiesRegistrationNumber().clear();
		getCommunitiesRegistrationNumber().sendKeys(number2);
		getSubmitButton().click();
		return new AdminCommunitiesPage(driver);
	}
}
