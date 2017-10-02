package com.regres.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class representation of all 'Confirm Message' on all pages, you need to set your WebElements
 * 
 */

public class ConfirmMessagePage {
	// confirm message
	private WebElement confirmMessage;
	private WebElement closeButton;
	private WebElement okButton;
	private WebElement cancelButton;

	// set community confirm message
	private WebElement titleMessage;
	private WebElement label;
	private WebElement input;

	// init WebDriver
	public ConfirmMessagePage(WebDriver driver) {
	}

	// Functional

	/**
	 * @return the confirmMessage
	 */
	public WebElement getConfirmMessage() {
		return confirmMessage;
	}

	/**
	 * @return the closeButton
	 */
	public WebElement getCloseButton() {
		return closeButton;
	}

	/**
	 * @return the okButton
	 */
	public WebElement getOkButton() {
		return okButton;
	}

	/**
	 * @return the cancelButton
	 */
	public WebElement getCancelButton() {
		return cancelButton;
	}

	/**
	 * @return the titleMessage
	 */
	public WebElement getTitleMessage() {
		return titleMessage;
	}

	/**
	 * @return the label
	 */
	public WebElement getLabel() {
		return label;
	}

	/**
	 * @return the input
	 */
	public WebElement getInput() {
		return input;
	}

	/**
	 * @param confirmMessage
	 *            the confirmMessage to set
	 */
	public void setConfirmMessage(WebElement confirmMessage) {
		this.confirmMessage = confirmMessage;
	}

	/**
	 * @param closeButton
	 *            the closeButton to set
	 */
	public void setCloseButton(WebElement closeButton) {
		this.closeButton = closeButton;
	}

	/**
	 * @param okButton
	 *            the okButton to set
	 */
	public void setOkButton(WebElement okButton) {
		this.okButton = okButton;
	}

	/**
	 * @param cancelButton
	 *            the cancelButton to set
	 */
	public void setCancelButton(WebElement cancelButton) {
		this.cancelButton = cancelButton;
	}

	/**
	 * @param titleMessage
	 *            the titleMessage to set
	 */
	public void setTitleMessage(WebElement titleMessage) {
		this.titleMessage = titleMessage;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(WebElement label) {
		this.label = label;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(WebElement input) {
		this.input = input;
	}

	/**
	 * @return String the confirmMessage Text
	 */
	public String getConfirmMessageText() {
		return confirmMessage.getText().trim();
	}

	/**
	 * @return String the okButton Text
	 */
	public String getOkButtonText() {
		return okButton.getText().trim();
	}

	/**
	 * @return String the titleMessage Text
	 */
	public String getTitleMessageText() {
		return titleMessage.getText().trim();
	}

	/**
	 * @return String the Label Text
	 */
	public String getLabelText() {
		return label.getText().trim();
	}

	/**
	 * @return String the cancelButton Text
	 */
	public String getCancelButtonText() {
		return cancelButton.getText().trim();
	}

	// click on 'OK' button on confirm message
	public void clickOkButton() {
		this.okButton.click();
	}

	// click on 'Close' button on confirm message
	public void clickCloseButton() {
		this.closeButton.click();
	}

	// click on 'Cancel' button confirm message
	public void clickCancelButton() {
		this.cancelButton.click();
	}

}
