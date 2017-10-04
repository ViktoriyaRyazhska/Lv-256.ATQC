package com.regres.pages.manage.coowners.actions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.GoogleEmailPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.manage.coowners.CoownersTable;

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

	public GoogleEmailPage goToEmail() {
		// Return a new page object representing the destination.
		return new GoogleEmailPage(driver);
	}

	@Override
	public NonConfirmedCoownersActionsDropdown setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new NonConfirmedCoownersActionsDropdown(driver);
	}
	
	public static enum LoginPageL10n {
		CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER(
				"Для виконання даної операції спочатку потрібно вибрати співвласників, "
						+ "натиснувши на відповідні стрічки в таблиці",
				"Для выполнения данной операции сначала нужно выбрать совладельцев, "
						+ "нажав на соответствующие строки в таблице",
				"To perform this operation you must first select coowners"
						+ " by clicking on the appropriate rows in the table" ),
		TITLE_TABLE_TEXT("Непідтверджені співвласники", "Неподтверждённые совладельцы", "Non-confirmed coowners"),
		SEND_EMAIL_CONFIRM_MESSAGE(
				"Листи успішно надіслано","Успешно отправлено","Successfully sent"),
		CANCEL_SET_COMMUNITY_CONFIRM_MESSAGE(
				"Відмінити","Отменить","Cancel"),
		CONFIRM_SET_COMMUNITY_CONFIRM_MESSAGE(
				"Підтвердити","Подтвердить","Confirm"),
		NOT_BE_EMPTY_SET_COMMUNITY_CONFIRM_MESSAGE(
				"Поле \"Громада\" не може бути пустим. Будь-ласка виберіть значення зі списку.",
				"Поле не может быть пустым. Пожалуйста выберите значение из списка.",
				"This field cant be empty. Please select a value from the list."),
		OK("OK","OK","OK"),
		CHANGES_ACCEPTED("Зміни застосовано","Изменения сохранены","Changes accepted");
		
		private HashMap<ChangeLanguageFields, String> field;

		private LoginPageL10n(String... localization) {
			this.field = new HashMap<ChangeLanguageFields, String>();
			int i = 0;
			for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
				this.field.put(language, localization[i]);
				i++;
			}
		}

		public String getLocalization(ChangeLanguageFields language) {
			return this.field.get(language).trim();
		}
	}
}
