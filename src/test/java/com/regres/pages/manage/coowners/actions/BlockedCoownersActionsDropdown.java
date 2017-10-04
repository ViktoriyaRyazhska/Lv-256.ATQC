package com.regres.pages.manage.coowners.actions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.OhErrorPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.manage.coowners.CoownersTable;

public class BlockedCoownersActionsDropdown extends CoownersTable {
	// Locators for actions for active co-owners
	private WebElement unblock;
	String UNBLOCK_CLASS_NAME = "unblock";

	private ConfirmMessagePage confirmMessage;
	
	public BlockedCoownersActionsDropdown(WebDriver driver) {
		super(driver);
		this.unblock = driver.findElement(By.className(UNBLOCK_CLASS_NAME));
	}

	public WebElement getUnblock() {
		return unblock;
	}

	public void setUnblock(WebElement unblock) {
		this.unblock = unblock;
	}
	
	public void clickUnblock() {
		getUnblock().click();
		initConfMessage();
	}
	public void clickActionsDropdown() {
		getUnblock();
	}
	
	public void initConfMessage() {
		InactiveCoownersActionsDropdown windowMes = new InactiveCoownersActionsDropdown(driver);
		windowMes.simpleConfirmMessage();
		confirm = windowMes.getConfirmMessage();
	}

	
//	public void ClickConfirmButton() {
//		confirmMessage = new ConfirmMessagePage(driver);
//		getConfirmButton().click();
//		initConfMessage();
////		confirm.setOkButton(driver.findElement(By.xpath("//button[@data-bb-handler='ok']")));
////		confirm.setTitleMessage(driver.findElement(By.className("bootbox-body")));
//		new WebDriverWait(driver, 10)
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='ok']")));
//	}

	// Business Logic
	@Override
	public BlockedCoownersActionsDropdown setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new BlockedCoownersActionsDropdown(driver);
	}

	public static enum LoginPageL10n {
		CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER(
				"Для виконання даної операції спочатку потрібно вибрати співвласників, "
						+ "натиснувши на відповідні стрічки в таблиці",
				"Для выполнения данной операции сначала нужно выбрать совладельцев, "
						+ "нажав на соответствующие строки в таблице",
				"To perform this operation you must first select coowners"
						+ " by clicking on the appropriate rows in the table");

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
