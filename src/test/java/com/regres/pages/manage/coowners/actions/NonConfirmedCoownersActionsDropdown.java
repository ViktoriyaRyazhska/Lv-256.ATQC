package com.regres.pages.manage.coowners.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.testdata.GoogleEmail;

public class NonConfirmedCoownersActionsDropdown extends CoownersTable {

	// these elements are in 'Actions' dropdown
	private WebElement delete;
	private WebElement sendEmail;
	// Locators for actions dropdown for non-confirmed co-owners
	private String DELETE_ID = "DELETE";
	private String SEND_EMAIL_AGAIN_ID = "SENDEMAILAGAIN";

	/**
	 * Constructor non-confirmed the WebDriver on 'Inactive coowners' page for
	 * 'Actions' dropdown
	 * 
	 * @param driver
	 */
	public NonConfirmedCoownersActionsDropdown(WebDriver driver) {
		super(driver);
	}

	/**
	 * @return the delete
	 */
	public WebElement getDelete() {
		return delete;
	}

	/**
	 * @return the sendEmail
	 */
	public WebElement getSendEmail() {
		return sendEmail;
	}

	/**
	 * Click on delete
	 */
	public void clickDelete() {
		this.delete.click();
	}

	/**
	 * Click on Send Email
	 */
	public void clickSendEmail() {
		this.sendEmail.click();
	}

	// click on "Actions" dropdown
	public void clickActionsDropdown() {
		this.clickUserName();
		this.getActions().click();

		// initialize these elements in 'Action' dropdown
		this.delete = driver.findElement(By.id(DELETE_ID));
		this.sendEmail = driver.findElement(By.id(SEND_EMAIL_AGAIN_ID));
	}

	// Business Logic

	public ConfirmMessagePage getConfMessage() {
		InactiveCoownersActionsDropdown inactive = new InactiveCoownersActionsDropdown(driver);
		// init web elements on confarm message page
		inactive.simpleConfirmMessage();
		return inactive.getConfirmMessage();
	}

	public GoogleEmail goToEmail() {
		// Return a new page object representing the destination.
		return new GoogleEmail(driver);
	}

	@Override
	public NonConfirmedCoownersActionsDropdown setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new NonConfirmedCoownersActionsDropdown(driver);
	}

}
