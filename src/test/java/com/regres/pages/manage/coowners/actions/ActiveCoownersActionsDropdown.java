package com.regres.pages.manage.coowners.actions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.OhErrorPage;
import com.regres.pages.manage.coowners.CoownersTable;

public class ActiveCoownersActionsDropdown extends CoownersTable {
	// Locators for actions for active co-owners
	String SET_ROLE_CSSSELECTOR = ".dropdown-submenu>a";
	String SET_COMMUNITY_CSSSELECTOR = ".set-community";
	String RESET_PASSWORD_CSSSELECTOR = ".reset-password";
	String ADMINISTRATOR_ROLE_CSSSELECTOR = ".set-role";
	String REGISTRATOR_ROLE_XPATH = "//a[@val=\"REGISTRATOR\"]";
	String COOWNER_ROLE_XPATH = "//a[@val=\"USER\"]";
	String COMMISSIONER_ROLE_XPATH = "//a[@val=\"COMMISSIONER\"]";
	String COMUNITIES_LOCATOR = "//a[href $= 'show-all-communities']";

	By communitiesName = By.className(".communName");
	private ConfirmMessagePage confirmMessage;

	WebDriverWait wait;
	
	// Locators for Confirm message window
	String CONFIRM_BUTTON_CSSSELECTOR = ".submit.btn.btn-success";
	// String CONFIRM_BUTTON_XPATH=
	// "//*[@id='userCommunitySelectModal']/div/div/div[3]/button[2]";
	String DROPDOWN_INPUT_CSSSELECTOR = "body div.autocomplete-suggestions div.autocomplete-suggestion.autocomplete-selected";
	String CLOSE_BUTTON_CLASS_NAME = "close";
	String CANSEL_BUTTON_CSSSELECTOR = ".btn.btn-info";
	String TITLE_MESSAGE_CLASS_NAME = "modal-title";
	String LABEL_CLASS_NAME = "control-label";
	String INPUT_ID = "tc_search";
	private String inputValue;

	public ActiveCoownersActionsDropdown(WebDriver driver) {
		super(driver);

	}

	public void clickActionsDropdown() {
		getActions().click();
		getSetRole();
		getSetCommunity();
		getResetPassword();
	}

	/**
	 * Method for open "Set Role" Dropdown
	 */
	public void clickSetRole() {
		// Initiate mouse action using Actions class
		Actions builder = new Actions(driver);
		// move the mouse to the earlier identified menu option
		builder.moveToElement(getSetRole()).build().perform();
		(new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(COMMISSIONER_ROLE_XPATH)));

		// Initiate dropdown that appeared after click on "Set role"
		getAdministratorRole();
		getRegistratorRole();
		getCoownerRole();
		getCommissionerRole();
	}

	public void initConfMessage() {
		InactiveCoownersActionsDropdown windowMes = new InactiveCoownersActionsDropdown(driver);
		windowMes.simpleConfirmMessage();
		confirm = windowMes.getConfirmMessage();
	}

	public WebElement getSetRole() {
		return driver.findElement(By.cssSelector(SET_ROLE_CSSSELECTOR));
	}

	public WebElement getSetCommunity() {
		return driver.findElement(By.cssSelector(SET_COMMUNITY_CSSSELECTOR));
	}

	public WebElement getResetPassword() {
		return driver.findElement(By.cssSelector(RESET_PASSWORD_CSSSELECTOR));
	}

	public WebElement getAdministratorRole() {
		return driver.findElement(By.cssSelector(ADMINISTRATOR_ROLE_CSSSELECTOR));
	}

	public WebElement getRegistratorRole() {
		return driver.findElement(By.xpath(REGISTRATOR_ROLE_XPATH));
	}

	public WebElement getCoownerRole() {
		return driver.findElement(By.xpath(COOWNER_ROLE_XPATH));
	}

	public WebElement getCommissionerRole() {
		return driver.findElement(By.xpath(COMMISSIONER_ROLE_XPATH));
	}

	public void clickSetCommunityNotSelected() {
		getSetCommunity().click();
		initConfMessage();
	}

	public void clickResetPassword() {
		getResetPassword().click();
		initConfMessage();
	}

	public void clickAdministratorRole() {
		getAdministratorRole().click();
		initConfMessage();
	}

	public void clickRegistratorRole() {
		getRegistratorRole().click();
		OhErrorPage windowMes = new OhErrorPage(driver);
		windowMes.clickGoToHomePageButton();
		initConfMessage();
	}

	public void clickCoownerRole() {
		getCoownerRole().click();
		initConfMessage();
	}

	public void clickCommissionerRole() {
		getCommissionerRole().click();
		initConfMessage();
	}

	public String getSetRoleText() {
		return getSetRole().getText().trim();
	}

	public String getSetCommunityText() {
		return getSetCommunity().getText().trim();
	}

	public String getResetPasswordText() {
		return getResetPassword().getText().trim();
	}

	public String getAdministratorRoleText() {
		return getResetPassword().getText().trim();
	}

	public String getRegistratorRoleText() {
		return getRegistratorRole().getText().trim();
	}

	public String getCoownerRoleText() {
		return getCoownerRole().getText().trim();
	}

	public String getCommissionerRoleText() {
		return getCommissionerRole().getText().trim();
	}

	public void clickSetCommunity() {
		getSetCommunity().click();
		// initialize elements on 'Set community' window
		getInputField();
		getConfirmButton();
		getCloseButton();
		getCancelButton();
		getTitleMessage();
		getLabel();
	}

	public WebElement getInputField() {
		return driver.findElement(By.id(INPUT_ID));
	}

	public void clickInputField() {
		getInputField().click();
	}

	public void sendValueInInputField(String value) {
		clickInputField();
		getInputField().sendKeys(value);
		getInputField().click();
		clickDropdownInput();
	}

	public void sendInvalidValueInInputField(String value) {
		clickInputField();
		getInputField().sendKeys(value);
	}

	public void setInputField(String inputValue) {
		this.inputValue = inputValue;
	}

	public WebElement getConfirmButton() {
		return driver.findElement(By.cssSelector(CONFIRM_BUTTON_CSSSELECTOR));
	}

	public void clickConfirmButton() {
		confirmMessage = new ConfirmMessagePage(driver);
		getConfirmButton().click();
		initConfMessage();
		// confirm.setOkButton(driver.findElement(By.xpath("//button[@data-bb-handler='ok']")));
		// confirm.setTitleMessage(driver.findElement(By.className("bootbox-body")));
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='ok']")));
	}

	public ActiveCoownersActionsDropdown clickConfirmButtonNew() {
		getConfirmButton().click();
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='ok']")));
		clickButton();
		driver.navigate().refresh();
		return new ActiveCoownersActionsDropdown(driver);
	}

	public WebElement getClickButton() {
		return driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
	}

	public void clickButton() {
		getClickButton().click();
	}
	public ActiveCoownersActionsDropdown assignCommunityToFirstUserInRow(String communityName) {
		clickFirstNameFirstRow();
		clickActionsDropdown();
		clickSetCommunity();
		clickInputField();
		sendValueInInputField(communityName);
		clickConfirmButtonNew();
		return new ActiveCoownersActionsDropdown(driver);
	}
	public WebElement getCancelButton() {
		return driver.findElement(By.cssSelector(CANSEL_BUTTON_CSSSELECTOR));
	}

	public WebElement getCloseButton() {
		return driver.findElement(By.className(CLOSE_BUTTON_CLASS_NAME));
	}

	public WebElement getTitleMessage() {
		return driver.findElement(By.className(TITLE_MESSAGE_CLASS_NAME));
	}

	public WebElement getLabel() {
		return driver.findElement(By.className(LABEL_CLASS_NAME));
	}

	public WebElement getDropdownInput() {
		return driver.findElement(By.cssSelector(DROPDOWN_INPUT_CSSSELECTOR));
	}

	public void clickDropdownInput() {
	
		getDropdownInput().click();
		
	}

	// Business Logic
	@Override
	public ActiveCoownersActionsDropdown setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new ActiveCoownersActionsDropdown(driver);
	}

	public static enum LoginPageL10n {
		CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER(
				"Ð”Ð»Ñ� Ð²Ð¸ÐºÐ¾Ð½Ð°Ð½Ð½Ñ� Ð´Ð°Ð½Ð¾Ñ— Ð¾Ð¿ÐµÑ€Ð°Ñ†Ñ–Ñ— Ñ�Ð¿Ð¾Ñ‡Ð°Ñ‚ÐºÑƒ Ð¿Ð¾Ñ‚Ñ€Ñ–Ð±Ð½Ð¾ Ð²Ð¸Ð±Ñ€Ð°Ñ‚Ð¸ Ñ�Ð¿Ñ–Ð²Ð²Ð»Ð°Ñ�Ð½Ð¸ÐºÑ–Ð², "
						+ "Ð½Ð°Ñ‚Ð¸Ñ�Ð½ÑƒÐ²ÑˆÐ¸ Ð½Ð° Ð²Ñ–Ð´Ð¿Ð¾Ð²Ñ–Ð´Ð½Ñ– Ñ�Ñ‚Ñ€Ñ–Ñ‡ÐºÐ¸ Ð² Ñ‚Ð°Ð±Ð»Ð¸Ñ†Ñ–",
				"Ð”Ð»Ñ� Ð²Ñ‹Ð¿Ð¾Ð»Ð½ÐµÐ½Ð¸Ñ� Ð´Ð°Ð½Ð½Ð¾Ð¹ Ð¾Ð¿ÐµÑ€Ð°Ñ†Ð¸Ð¸ Ñ�Ð½Ð°Ñ‡Ð°Ð»Ð° Ð½ÑƒÐ¶Ð½Ð¾ Ð²Ñ‹Ð±Ñ€Ð°Ñ‚ÑŒ Ñ�Ð¾Ð²Ð»Ð°Ð´ÐµÐ»ÑŒÑ†ÐµÐ², "
						+ "Ð½Ð°Ð¶Ð°Ð² Ð½Ð° Ñ�Ð¾Ð¾Ñ‚Ð²ÐµÑ‚Ñ�Ñ‚Ð²ÑƒÑŽÑ‰Ð¸Ðµ Ñ�Ñ‚Ñ€Ð¾ÐºÐ¸ Ð² Ñ‚Ð°Ð±Ð»Ð¸Ñ†Ðµ",
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
