package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ChangePasswordPage extends DropdownHomePage {
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

	public void setup(String password,String newPassword,String confirmPassword) {
		passwordField.clear();
		passwordField.sendKeys(password);
		newPasswordField.clear();
		newPasswordField.sendKeys(newPassword);
		confirmPasswordField.clear();
		confirmPasswordField.sendKeys(confirmPassword);
		
		
	}
	public void getEmptyFieldsMessage() {
		setup("","","");
		clickConfirmButton();
		
	}
	public String getEmptyFieldMessageText() {
		return passwordField.getAttribute("validationMessage");
	}
	public DropdownHomePageImpl clickConfirmButtonSuccess() {
		confirmButton.click();
		
		return new DropdownHomePageImpl(driver);
	}
	public void clickConfirmButton() {
		confirmButton.click();
		
	}
	public DropdownHomePageImpl clickCancelButton() {
		cancelButton.click();
		return new DropdownHomePageImpl(driver);
	}
	public void getWrongPasswordMessage(String password) {
		setup(password+"+",password,password);
		clickConfirmButton();
		message = driver.findElement(By.id("password.errors"));
		
	}
	
	public void getWrongNewPasswordMessage(String password) {
		setup(password,"/asd","/asd");
		clickConfirmButton();
		message = driver.findElement(By.id("newPassword.errors"));
	}
	public void getWrongConfirmMessage(String password) {
		setup(password,password,password+"+");
		clickConfirmButton();
		message = driver.findElement(By.id("confirmNewPassword.errors"));
	}
	public DropdownHomePageImpl getSuccesMessage(String password) {
		setup(password,password,password);
		DropdownHomePageImpl dropdown = clickConfirmButtonSuccess();
		message = dropdown.getSuccesMessage();
		return new DropdownHomePageImpl(driver, message);
	}
	public String getMessageText() {
		return message.getText().trim();
	}
	

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
		passwordLabel = driver.findElement(By.cssSelector("[for='password']"));
		passwordField = driver.findElement(By.id("password"));
		newPasswordLabel = driver.findElement(By.cssSelector("[for='newPassword']"));
		newPasswordField = driver.findElement(By.id("newPassword"));
		confirmPasswordLabel = driver.findElement(By.cssSelector("[for='confirmNewPassword']"));
		confirmPasswordField = driver.findElement(By.id("confirmNewPassword"));
		confirmButton = driver.findElement(By.id("update"));
		cancelButton = driver.findElement(By.id("cancel"));
		title = driver.findElement(By.cssSelector("legend"));
		
		
	}

	public ChangePasswordPage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		return new ChangePasswordPage(driver);
	}

}
