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
	private WebElement optionPersonal;
	private WebElement optionManual;
	private WebElement optionMixed;
	private WebElement confirmButton;
	private WebElement registerButton;

	String TIME_ZONE_BLOCK_TITLE_XPATH = "//form[@id='сhangeReg']/div[2]//h3[@class='panel-title']";
	String TIME_ZONE_LABEL_XPATH = "//form[@id='сhangeReg']/div[2]//p";
	String TIME_ZONE_FIELD_XPATH = "//form[@id='сhangeReg']/div[2]//input";
	String CONFIRM_CHANGES_BUTTON_ID = "confirmRegistrationMethod";
	String FIRST_MATCH_TIMEZONE_XPATH = "//*[@data-index='0']";
	String RESULT_SET_TIMEZONE_CLASSNAME = "autocomplete-suggestion";
	
	
	public AdminSettingsPage(WebDriver driver) {
		super(driver);
		timeZoneBlockTitle = driver.findElement(By.xpath(TIME_ZONE_BLOCK_TITLE_XPATH));
		timeZoneLabel = driver.findElement(By.xpath(TIME_ZONE_LABEL_XPATH));
		methodRegisteringLabel = driver.findElement(By.xpath("//form[@id='сhangeReg']/div[1]//p"));
		methodRegisteringTitle = driver
				.findElement(By.xpath("//form[@id='сhangeReg']/div[1]//h3[@class='panel-title']"));
		timeZoneField = driver.findElement(By.xpath(TIME_ZONE_FIELD_XPATH));
		confirmChangesButton = driver.findElement(By.id(CONFIRM_CHANGES_BUTTON_ID));
		optionPersonal = driver.findElement(By.xpath("(//input[@value='PERSONAL'])"));
		optionManual = driver.findElement(By.xpath("(//input[@value='MANUAL'])"));
		optionMixed = driver.findElement(By.xpath("(//input[@value='MIXED'])"));

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
		return optionPersonal;
	}

	public WebElement getOptionManual() {
		return optionManual;
	}

	public WebElement getOptionMixed() {
		return optionMixed;
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
	 * @param timezone - desired timezone.
	 * @return AdminSettingsPage after clicking 'Confirm' button.
	 */
	public AdminSettingsPage setTimeZone(String timezone) {
		timeZoneField.clear();
		timeZoneField.sendKeys(timezone);
		
		// wait until app finds desired timezone in database.
		(new WebDriverWait(driver, 15))
				.until(ExpectedConditions.visibilityOfElementLocated(By.className(RESULT_SET_TIMEZONE_CLASSNAME))); //waith until results are shown 
		
		searchResult = driver.findElement(By.xpath(FIRST_MATCH_TIMEZONE_XPATH)); 
		searchResult.click(); //click on the first match
		
		confirmChangesButton.click(); // confirm changes
		
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(timeZoneBlockTitle)); 
		return new AdminSettingsPage(driver);
	}
	
	/**
	 * Sets invalid value for the timezone field
	 * Returns error page.
	 * @param invalidTimeZone - invalid credentials for the timezone field.
	 * @return error page.
	 */
	public OhErrorPage setInvalidTimeZone(String invalidTimeZone) {
		
		timeZoneField.clear();
		timeZoneField.sendKeys(invalidTimeZone);
		this.confirmChangesButton.click();
		
		return new OhErrorPage(driver);
	}

	public LoginPage personalRegistration() {

		if (!optionPersonal.isSelected()) {
			clickOptionPersonal();
			confirmChangesButton.click();
		}
		clickLogout();
		return new LoginPage(driver);
	}

	public LoginPage manualRegistration() {

		if (!optionManual.isSelected()) {
			clickOptionManual();
			confirmChangesButton.click();
		}
		clickLogout();
		return new LoginPage(driver);
	}

	public LoginPage mixedlRegistration() {

		if (!optionMixed.isSelected()) {
			clickOptionMixed();
			confirmChangesButton.click();
		}
		clickLogout();
		return new LoginPage(driver);
	}

}
