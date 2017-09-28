package com.regres.pages.manage.coowners.actions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.manage.coowners.CoownersTable;

/**
 * Class representation of 'Actions' dropdown on 'Inactive coowners' page for
 * Administrator home page or Commisioner Home Page
 * 
 */
public class InactiveCoownersActionsDropdown extends CoownersTable {
	// these elements are in 'Actions' dropdown
	private WebElement unblock;
	private WebElement block;
	private WebElement setCommunity;
	private ConfirmMessagePage confirmMessage;
	/**
	 * Constructor initialize the WebDriver on 'Inactive coowners' page for
	 * 'Actions' dropdown
	 * 
	 * @param driver
	 */
	public InactiveCoownersActionsDropdown(WebDriver driver) {
		super(driver);
	}

	// PageObject
	// get Data
	/**
	 * @return the unblock
	 */
	public WebElement getUnblock() {
		return unblock;
	}
	/**
	 * @return the unblock
	 */
	public ConfirmMessagePage getConfirmMessage() {
		return confirmMessage;
	}

	/**
	 * @return the block
	 */
	public WebElement getBlock() {
		return block;
	}

	/**
	 * @return the setCommunity
	 */
	public WebElement getSetCommunity() {
		return setCommunity;
	}

	// click on "Action" dropdown
	public void clickActionsDropdown() {
		this.clickUserName();
		this.getActions().click();
		
		// initialize these elements in 'Action' dropdown
		this.unblock = driver.findElement(By.className("unblock"));
		this.block = driver.findElement(By.className("block"));
		this.setCommunity = driver.findElement(By.className("set-community"));
	}

	// click on "Unblock"
	public void clickUnblock() {
		this.unblock.click();
		// initialize these elements on 'Unblock' confirm message
		simpleConfirmMessage();
	}

	// click on "Block"
	public void clickBlock() {
		this.block.click();
		// initialize these elements on 'Block' confirm message
		simpleConfirmMessage();
	}

	/**
	 * click on "Set community" but you can`t select coowners by clicking on the
	 * rows in the table
	 */
	public void clickSetCommunityButNotSelectedCoowners() {
		this.setCommunity.click();
		// initialize these elements on 'Set community' Don`t selected confirm message
		simpleConfirmMessage();
	}

	/**
	 * click on "Set community" before that you must select coowners by clicking on
	 * the rows in the table
	 */
	public void clickSetCommunity() {
		confirmMessage = new ConfirmMessagePage(driver);
		this.setCommunity.click();
		// initialize these elements on 'Set community' confirm message
		confirmMessage.setOkButton(driver.findElement(By.xpath("//button[@data-bb-handler='ok']")));
		confirmMessage.setCloseButton(driver.findElement(By.cssSelector("div.modal-body button.close")));
		confirmMessage.setCancelButton(driver.findElement(By.cssSelector(".btn.btn-info")));
		confirmMessage.setTitleMessage(driver.findElement(By.className("modal-title")));
		confirmMessage.setLabel(driver.findElement(By.className("control-label")));
		confirmMessage.setInput(driver.findElement(By.id("tc_search")));
	}

	// click on 'Confirm' on "Set community"
	public void clickConfirmOnSetCommunityMessage() {
		confirmMessage.clickOkButton();
		// initialize these elements on 'Confirm' confirm message after 'Set community'
		// confirm message
		simpleConfirmMessage();
	}

	/**
	 * initialize elements on the 'Confirm message': 
	 * - confirm message 
	 * - 'OK' button
	 * - close button
	 */
	public void simpleConfirmMessage() {
		confirmMessage = new ConfirmMessagePage(driver);
		//wait for confirm message appears
		(new WebDriverWait(driver, 10)).until(
				ExpectedConditions.visibilityOf(driver.findElement(By.className("bootbox-body"))));
		// initialize these elements for all confirm message
		// but only without 'Set community' confirm message
		// when choose coowners on the table
		confirmMessage.setConfirmMessage(driver.findElement(By.className("bootbox-body")));
		confirmMessage.setOkButton(driver.findElement(By.xpath("//button[@data-bb-handler='ok']")));
		confirmMessage.setCloseButton(driver.findElement(By.cssSelector("div.modal-body button.close")));
	}
	
	// Business Logic
	@Override
	public InactiveCoownersActionsDropdown setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown()); 
		lang.selectByVisibleText(language.toString()); 
		// Return a new page object representing the destination.
		return new InactiveCoownersActionsDropdown(driver);
	}
	
	public static enum LoginPageL10n {
		CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER(
				"Для виконання даної операції спочатку потрібно вибрати співвласників, "
						+ "натиснувши на відповідні стрічки в таблиці",
				"Для выполнения данной операции сначала нужно выбрать совладельцев, "
						+ "нажав на соответствующие строки в таблице",
				"To perform this operation you must first select coowners"
						+ " by clicking on the appropriate rows in the table" );
		
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
