package com.regres.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class represents Community page which contains all created communities where
 * administrator can manage them by deleting, activating, creating new and
 * editing previously created.
 */

public class AdminCommunitiesPage extends AdminHomePage {
	WebDriverWait wait;
	Properties property;

	String ADD_COMMUNITY_BUTTON_CSSSELECTOR = "html body div.container div.row div#body p.pull-left a.btn.btn-success";
	String COMMUNITIES_LABEL_XPATH = "//h4";
	String INACTIVE_CHECKBOX_ID = "inactiveCheckbox";
	String INACTIVE_CHECKBOX_LABEL_XPATH = "//div[2]/label";
	String TABLE_CSSSELECTOR = "table.table.table-striped.table-bordered.table-hover";
	String COMMUNITIES_HEADER_XPATH = "//thead//th[1]";
	String REG_NUMBER_HEADER_XPATH = "//thead//th[2]";
	String ACTIONS_HEADER_XPATH = "//thead//th[3]";
	String EDIT_COMMUNITIES_BUTTON_XPATH = "//a[contains(@href,'editCommunity?id=2156')]";
	String DELETE_COMMUNITY_BUTTON_ID = "deletecommunity";
	String ACTIVATE_COMMUNITY_BUTTON_ID = "activecommunity";
	String NOTIFICATION_OK_BUTTON_XPATH = "//button[@data-bb-handler='confirm']";
	String ROWS_IN_TABLE_XPATH = "//tr[@class='commun']//*[text()='";
	String DELETE_IN_ROW_BUTTON_XPATH = "']/following::a[@id='deletecommunity']";
	String EDIT_IN_ROW_BUTTON_XPATH = "']/following::a[@id='editcommunity']";
	String JS_CLICK = "arguments[0].click();";
	String NOT_ACTIVATED_COMUNITIES_XPATH = "//tr[@class='commun' and @type='0']";
	String ENGLISH_LANGUAGE = "english";
	String RUSSIAN_LANGUAGE = "русский";
	String UKRAINIAN_LANGUAGE = "українська";
	String USER_REPO = "user.dir";
	String ENGLISH_FILE_PATH = "\\resources\\English.properties";
	String RUSSIAN_FILE_PATH = "\\resources\\Russian.properties";
	String UKRAINIAN_FILE_PATH = "\\resources\\Ukrainian.properties";

	public AdminCommunitiesPage(WebDriver driver) {
		super(driver);
	}

	// getters for elements on the page
	public WebElement getAddNewCommunityButton() {
		return driver.findElement(By.cssSelector(ADD_COMMUNITY_BUTTON_CSSSELECTOR));
	}

	public WebElement getNotificationOkButton() {
		return driver.findElement(By.xpath(NOTIFICATION_OK_BUTTON_XPATH));
	}

	public WebElement getCommunitiesLabel() {
		return driver.findElement(By.xpath(COMMUNITIES_LABEL_XPATH));
	}

	public WebElement getInactiveCheckbox() {
		return driver.findElement(By.id(INACTIVE_CHECKBOX_ID));
	}

	public WebElement getInactiveCheckboxLabel() {
		return driver.findElement(By.xpath(INACTIVE_CHECKBOX_LABEL_XPATH));
	}

	public WebElement getTableWithCommunities() {
		return driver.findElement(By.cssSelector(TABLE_CSSSELECTOR));
	}

	public WebElement getTerritorialCommunityHeader() {
		return driver.findElement(By.xpath(COMMUNITIES_HEADER_XPATH));
	}

	public WebElement getRegistrationNumberHeader() {
		return driver.findElement(By.xpath(REG_NUMBER_HEADER_XPATH));
	}

	public WebElement getActionsHeader() {
		return driver.findElement(By.xpath(ACTIONS_HEADER_XPATH));
	}

	public WebElement getEditCommunityButton() {
		return driver.findElement(By.xpath(EDIT_COMMUNITIES_BUTTON_XPATH));
	}

	public WebElement getDeleteCommunityButton() {
		return driver.findElement(By.id(DELETE_COMMUNITY_BUTTON_ID));
	}

	public WebElement getActiveCommunityButton() {
		return driver.findElement(By.id(ACTIVATE_COMMUNITY_BUTTON_ID));
	}

	// getters for text in elements located on the page
	public String getAddNewCommunityButtonText() {
		return getAddNewCommunityButton().getText().trim();
	}

	public String getCommunitiesLabelText() {
		return getCommunitiesLabel().getText().trim();
	}

	public String getInactiveCheckboxLabelText() {
		return getInactiveCheckboxLabel().getText().trim();
	}

	public String getTerritorialCommunityHeaderText() {
		return getTerritorialCommunityHeader().getText().trim();
	}

	public String getRegistrationNumberHeaderText() {
		return getRegistrationNumberHeader().getText().trim();
	}

	public String getActionsHeaderText() {
		return getActionsHeader().getText().trim();
	}

	public String getEditCommunityButtonText() {
		return getEditCommunityButton().getText().trim();
	}

	public String getDeleteCommunityButtonText() {
		return getDeleteCommunityButton().getText().trim();
	}

	public String getActiveCommunityButtonText() {
		return getActiveCommunityButton().getText().trim();
	}

	// clicks on elements
	public AddNewCommunitiesPage clickAddNewCommunityButton() {
		getAddNewCommunityButton().click();
		return new AddNewCommunitiesPage(driver);
	}

	public void clickInactiveCheckbox() {
		getInactiveCheckbox().click();
	}

	public EditCommunityPage clickEditCommunityButton() {
		getEditCommunityButton().click();
		return new EditCommunityPage(driver);
	}

	public void clickDeleteCommunityButton() {
		getDeleteCommunityButton().click();
	}

	public void clickActiveCommunityButton() {
		getActiveCommunityButton().click();
	}

	public void clickNotificationOkButton() {
		getNotificationOkButton().click();
	}

	// refreshes the page and waits
	public void refreshAndWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.navigate().refresh();
	}

	// method that click and deletes community by name
	public AdminCommunitiesPage deleteCommunity(String communityName) {
		driver.findElement(By.xpath(ROWS_IN_TABLE_XPATH + communityName + DELETE_IN_ROW_BUTTON_XPATH)).click();
		((JavascriptExecutor) driver).executeScript(JS_CLICK, getNotificationOkButton());
		return new AdminCommunitiesPage(driver);
	}

	// method that verifies is there communities name in table
	public boolean verifyCommunityPresence(String communityName) throws TimeoutException {
		refreshAndWait();
		wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath(ROWS_IN_TABLE_XPATH + communityName + "']"), communityName));
	}

	// method that not activated communities are shown if click on appropriate
	// checkbox
	public boolean verifyNotActiveCommunitiesAreShown() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(NOT_ACTIVATED_COMUNITIES_XPATH)));
		return true;
	}

	/**
	 * Sets the language for the page
	 */
	@Override
	public AdminCommunitiesPage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		return new AdminCommunitiesPage(driver);
	}

	// method that calls appropriate Language properties files loadings in
	// dependence from language that is set
	public void setLanguageFileToBeLoaded(ChangeLanguageFields language) throws IOException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getCommunitiesLabel()));
		if (language.toString().equalsIgnoreCase(ENGLISH_LANGUAGE))
			loadEnglishPropertiesFile();
		else if (language.toString().equalsIgnoreCase(RUSSIAN_LANGUAGE))
			loadRussianPropertiesFile();
		else if (language.toString().equalsIgnoreCase(UKRAINIAN_LANGUAGE))
			loadUkrainianPropertiesFile();
	}

	// method that loads English properties file
	public void loadEnglishPropertiesFile() throws IOException {
		property = new Properties();
		File fs = new File(System.getProperty(USER_REPO) + ENGLISH_FILE_PATH);
		FileReader obj = new FileReader(fs);
		property.load(obj);
	}

	// method that loads Russian properties file
	public void loadRussianPropertiesFile() throws IOException {
		property = new Properties();
		File fs2 = new File(System.getProperty(USER_REPO) + RUSSIAN_FILE_PATH);
		FileReader obj2 = new FileReader(fs2);
		property.load(obj2);
	}

	// method that loads Ukrainian properties file
	public void loadUkrainianPropertiesFile() throws IOException {
		property = new Properties();
		File fs3 = new File(System.getProperty(USER_REPO) + UKRAINIAN_FILE_PATH);
		FileReader obj3 = new FileReader(fs3);
		property.load(obj3);
	}

	// method that get needed value by key from appropriate properties file
	public String getLocalizationValue(String value) throws IOException {
		String data = property.getProperty(value);
		return data;
	}

	// method that opens edit page for community from table by its name
	public EditCommunityPage clickEditOnCreatedCommunity(String communityName) {
		driver.findElement(By.xpath(ROWS_IN_TABLE_XPATH + communityName + EDIT_IN_ROW_BUTTON_XPATH)).click();
		return new EditCommunityPage(driver);
	}

	// method that verifies if renamed community is present in table
	public boolean verifyEditedCommunityPresence(String communityName2) throws TimeoutException {
		refreshAndWait();
		wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(ROWS_IN_TABLE_XPATH + communityName2 + "']"), communityName2));
	}

	// method that verifies that renamed community is not present in table
	public boolean verifyEditedCommunityAbsence(String communityName) throws TimeoutException {
		refreshAndWait();
		wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath(ROWS_IN_TABLE_XPATH + communityName + "']"), communityName));
	}

}
