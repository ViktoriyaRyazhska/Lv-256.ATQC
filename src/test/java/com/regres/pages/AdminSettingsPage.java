package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminSettingsPage extends AdminHomePage {
	private WebElement timeZoneBlockTitle;
	private WebElement timeZoneLabel;
	private WebElement timeZoneField;
	private WebElement confirmChangesButton;
	private WebElement searchResult;
	private WebElement methodRegisteringTitle;
	private WebElement methodRegisteringLabel;
	private WebElement optionPersonalRadioButton;
	private WebElement optionManualRadioButton;
	private WebElement optionMixedRadioButton;
	private WebElement confirmButton;
	private WebElement registerButton;

	String TIME_ZONE_BLOCK_TITLE_XPATH = "//form[@id='сhangeReg']/div[2]//h3[@class='panel-title']";
	String TIME_ZONE_LABEL_XPATH = "//form[@id='сhangeReg']/div[2]//p";
	String TIME_ZONE_FIELD_XPATH = "//form[@id='сhangeReg']/div[2]//input";
	String CONFIRM_CHANGES_BUTTON_ID = "confirmRegistrationMethod";
	String OPTION_PERSONAL_RADIO_BUTTON_XPATH = "//input[@value='PERSONAL']";
	String OPTION_MANUAL_RADIO_BUTTON_XPATH = "//input[@value='MANUAL']";
	String OPTION_MIXED_RADIO_BUTTON_XPATH = "//input[@value='MIXED']";

	public AdminSettingsPage(WebDriver driver) {
		super(driver);
		timeZoneBlockTitle = driver.findElement(By.xpath(TIME_ZONE_BLOCK_TITLE_XPATH));
		timeZoneLabel = driver.findElement(By.xpath(TIME_ZONE_LABEL_XPATH));
		methodRegisteringLabel = driver.findElement(By.xpath("//form[@id='сhangeReg']/div[1]//p"));
		methodRegisteringTitle = driver
				.findElement(By.xpath("//form[@id='сhangeReg']/div[1]//h3[@class='panel-title']"));
		timeZoneField = driver.findElement(By.xpath(TIME_ZONE_FIELD_XPATH));
		confirmChangesButton = driver.findElement(By.id(CONFIRM_CHANGES_BUTTON_ID));
		optionPersonalRadioButton = driver.findElement(By.xpath(OPTION_PERSONAL_RADIO_BUTTON_XPATH));
		optionManualRadioButton = driver.findElement(By.xpath(OPTION_MANUAL_RADIO_BUTTON_XPATH));
		optionMixedRadioButton = driver.findElement(By.xpath(OPTION_MIXED_RADIO_BUTTON_XPATH));

	}

	public WebElement getTimeZoneBlockTitle() {
		return timeZoneBlockTitle;
	}

	public WebElement getMethodRegisteringTitle() {
		return methodRegisteringTitle;
	}

	public WebElement getMethodRegisteringLabel() {
		return methodRegisteringLabel;
	}

	public WebElement getTimeZoneLabel() {
		return timeZoneLabel;
	}

	public WebElement getTimeZoneField() {
		return timeZoneField;
	}

	public WebElement getConfirmChangesButton() {
		return confirmChangesButton;
	}

	public String getTimeZoneBlockTitleText() {
		return timeZoneBlockTitle.getText().trim();
	}

	public String getMethodRegisteringTitleText() {
		return methodRegisteringTitle.getText().trim();
	}

	public String getMethodRegisteringLabelText() {
		return methodRegisteringLabel.getText().trim();
	}

	public String getTimeZoneLabelText() {
		return timeZoneLabel.getText().trim();
	}

	/**
	 * @return Text of time zone field(current time zone)
	 */
	public String getTimeZoneFieldText() {

		return timeZoneField.getAttribute("value");
	}

	public WebElement getOptionPersonal() {
		return optionPersonalRadioButton;
	}

	public WebElement getOptionManual() {
		return optionManualRadioButton;
	}

	public WebElement getOptionMixed() {
		return optionMixedRadioButton;
	}

	public void clickOptionPersonal() {
		getOptionPersonal().click();
	}

	public void clickOptionManual() {
		getOptionManual().click();
	}

	public void clickOptionMixed() {
		getOptionMixed().click();
	}

	/**
	 * Sets time zone for the app,
	 * 
	 * @param timezone
	 *            - desired timezone.
	 * @return AdminSettingsPage after clicking 'Confirm' button.
	 */
	public AdminSettingsPage setTimeZone(String timezone) {
		timeZoneField.clear();
		timeZoneField.sendKeys(timezone);

		// wait until app finds desired timezone in database.
		(new WebDriverWait(driver, 15))
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("autocomplete-suggestion"))); // classname
		searchResult = driver.findElement(By.xpath("//*[@data-index='0']"));
		searchResult.click(); // click on the first match

		confirmChangesButton.click(); // confirm changes

		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(timeZoneBlockTitle));
		return new AdminSettingsPage(driver);
	}

	/**
	 * Sets invalid value for the timezone field Returns error page.
	 * 
	 * @param invalidTimeZone
	 *            - invalid credentials for the timezone field.
	 * @return error page.
	 */
	public OhErrorPage setInvalidTimeZone(String invalidTimeZone) {

		timeZoneField.clear();
		timeZoneField.sendKeys(invalidTimeZone);
		this.confirmChangesButton.click();

		return new OhErrorPage(driver);
	}

	/**
	 * Select Personal Registration option
	 * 
	 * @return new AdminSettingsPage.
	 */
	public AdminSettingsPage personalRegistration() {
		/**
		 * Checks 'Manual option' radio button. If it is already checked, does nothing.
		 */
		if (!optionManualRadioButton.isSelected()) {
			clickOptionPersonal();
		}
		confirmChangesButton.click(); // confirm changes
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.stalenessOf(methodRegisteringTitle));
		return new AdminSettingsPage(driver);
	}

	/**
	 * Select Only commissioner can register new co-owner option
	 * 
	 * @return new AdminSettingsPage.
	 */
	public AdminSettingsPage manualRegistration() {
		/**
		 * Checks 'Personal option' radio button. If it is already checked, does
		 * nothing.
		 */
		if (!optionPersonalRadioButton.isSelected()) {
			clickOptionManual();
		}
		confirmChangesButton.click(); // confirm changes
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.stalenessOf(methodRegisteringTitle));
		return new AdminSettingsPage(driver);
	}

	/**
	 * Select Both registration method are available option
	 * 
	 * @return new AdminSettingsPage.
	 */
	public AdminSettingsPage mixedlRegistration() {
		/**
		 * Checks 'Mixed option' radio button. If it is already checked, does nothing.
		 */
		if (!optionMixedRadioButton.isSelected()) {
			clickOptionMixed();
		}
		confirmChangesButton.click(); // confirm changes
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.stalenessOf(methodRegisteringTitle));
		return new AdminSettingsPage(driver);
	}
}
