package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.regres.testdata.UserContainer;

public class ChangePasswordPage extends DropdownHomePage {
	// Elements of ChangePasswordPage
	private WebElement title;
	private WebElement passwordLabel;
	private WebElement passwordField;
	private WebElement newPasswordLabel;
	private WebElement newPasswordField;
	private WebElement confirmPasswordLabel;
	private WebElement confirmPasswordField;
	private WebElement confirmButton;
	private WebElement cancelButton;
	private WebElement message;
	// Field for password
	private String password;
	// Locators
	String PASSWORD_LABEL_LOCATOR = "[for='password']";
	String PASSWORD_FIELD_LOCATOR = "password";
	String NEW_PASSWORD_LABEL_LOCATOR = "[for='newPassword']";
	String NEW_PASSWORD_FIELD_LOCATOR = "newPassword";
	String CONFIRM_PASSWORD_LABEL_LOCATOR = "[for='confirmNewPassword']";
	String CONFIRM_PASSWORD_FIELD_LOCATOR = "confirmNewPassword";
	String CONFIRM_BUTTON_LOCATOR = "update";
	String CANCEL_BUTTON_LOCATOR = "cancel";
	String TITLE_LOCATOR = "legend";
	String EMPTY_FIELDS_MESSAGE_LOCATOR = "validationMessage";
	String WRONG_PASSWORD_MESSAGE_LOCATOR = "password.errors";
	String WRONG_NEW_PASSWORD_MESSAGE_LOCATOR = "newPassword.errors";
	String WRONG_CONFIRM_PASSWORD_MESSAGE_LOCATOR = "confirmNewPassword.errors";

	/**
	 * Sends parameters into Change Password Page fields
	 * 
	 * @param password
	 *            - current password
	 * @param newPassword
	 *            - new password
	 * @param confirmPassword
	 *            - confirmation of new password
	 * 
	 */
	public void setup(String password, String newPassword, String confirmPassword) {
		passwordField.clear();
		passwordField.sendKeys(password);
		newPasswordField.clear();
		newPasswordField.sendKeys(newPassword);
		confirmPasswordField.clear();
		confirmPasswordField.sendKeys(confirmPassword);

	}

	// sets empty fields and clicks confirm button
	public void getEmptyFieldsMessage() {
		setup("", "", "");
		clickConfirmButton();

	}

	/**
	 * 
	 * @return Empty field error message
	 */
	public String getEmptyFieldMessageText() {
		return passwordField.getAttribute(EMPTY_FIELDS_MESSAGE_LOCATOR);
	}

	/**
	 * clicks on confirm button
	 * 
	 * @return new dropdown page
	 */
	public DropdownHomePageImpl clickConfirmButtonSuccess() {
		clickConfirmButton();
		return new DropdownHomePageImpl(driver);
	}
/**
 * clicks on confirm button
 */
	public void clickConfirmButton() {
		confirmButton.click();

	}
/**
 * clicks on cancel button
 * @return new dropdown page
 */
	public DropdownHomePageImpl clickCancelButton() {
		cancelButton.click();
		return new DropdownHomePageImpl(driver);
	}
/**
 * initiate wrong password message
 * @param password - current password
 */
	public void getWrongPasswordMessage(String password) {
		setup(password + "+", password, password);
		clickConfirmButton();
		message = driver.findElement(By.id(WRONG_PASSWORD_MESSAGE_LOCATOR));

	}
/**
 * initiate wrong new password message
 * @param password - current password
 */
	public void getWrongNewPasswordMessage(String password) {
		setup(password, "/asd", "/asd");
		clickConfirmButton();
		message = driver.findElement(By.id(WRONG_NEW_PASSWORD_MESSAGE_LOCATOR));
	}
/**
 * initiate wrong confirm password message
 * @param password - current password
 */
	public void getWrongConfirmMessage(String password) {
		setup(password, password, password + "+");
		clickConfirmButton();
		message = driver.findElement(By.id(WRONG_CONFIRM_PASSWORD_MESSAGE_LOCATOR));
	}
/**
 * 
 * @param password - current password
 * @return new dropdown page with succes message initiated
 */
	public DropdownHomePageImpl getSuccesMessage(String password) {
		setup(password, password, password);
		DropdownHomePageImpl dropdown = clickConfirmButtonSuccess();
		message = dropdown.getSuccesMessage();
		return new DropdownHomePageImpl(driver, message);
	}
/**
 * change password
 * @param password - current password
 * @return dropdown page
 */
	public DropdownHomePageImpl setNewPassword(String password) {
		this.password = password + "--";
		setup(password, this.password, this.password);
		DropdownHomePageImpl dropdown = clickConfirmButtonSuccess();
		return dropdown;
	}
/**
 * return old password
 * @param password - current password
 * @return dropdown page
 */
	public DropdownHomePageImpl returnOldPassword(String password) {
		this.password = new UserContainer().getRegistrator().getPassword();
		setup(password, "registrator", "registrator");
		DropdownHomePageImpl dropdown = clickConfirmButtonSuccess();
		return dropdown;
	}
/**
 * 
 * @return message text
 */
	public String getMessageText() {
		return message.getText().trim();
	}

	/**
	 * Constructor initialize the WebDriver and elements on the Change password page
	 * 
	 * @param driver
	 */
	public ChangePasswordPage(WebDriver driver) {
		super(driver);
		passwordLabel = driver.findElement(By.cssSelector(PASSWORD_LABEL_LOCATOR));
		passwordField = driver.findElement(By.id(PASSWORD_FIELD_LOCATOR));
		newPasswordLabel = driver.findElement(By.cssSelector(NEW_PASSWORD_LABEL_LOCATOR));
		newPasswordField = driver.findElement(By.id(NEW_PASSWORD_FIELD_LOCATOR));
		confirmPasswordLabel = driver.findElement(By.cssSelector(CONFIRM_PASSWORD_LABEL_LOCATOR));
		confirmPasswordField = driver.findElement(By.id(CONFIRM_PASSWORD_FIELD_LOCATOR));
		confirmButton = driver.findElement(By.id(CONFIRM_BUTTON_LOCATOR));
		cancelButton = driver.findElement(By.id(CANCEL_BUTTON_LOCATOR));
		title = driver.findElement(By.cssSelector(TITLE_LOCATOR));

	}

	/**
	 * This method sets language for the app.
	 * 
	 * @param language
	 *            - language to be set
	 * @return page, on which this method is executed.
	 */
	public ChangePasswordPage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		return new ChangePasswordPage(driver);
	}

	// Getters and Setters
	public WebElement getTitle() {
		return title;
	}

	public WebElement getPasswordLabel() {
		return passwordLabel;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getNewPasswordLabel() {
		return newPasswordLabel;
	}

	public WebElement getNewPasswordField() {
		return newPasswordField;
	}

	public WebElement getConfirmPasswordLabel() {
		return confirmPasswordLabel;
	}

	public WebElement getConfirmPasswordField() {
		return confirmPasswordField;
	}

	public WebElement getConfirmButton() {
		return confirmButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getMessage() {
		return message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
