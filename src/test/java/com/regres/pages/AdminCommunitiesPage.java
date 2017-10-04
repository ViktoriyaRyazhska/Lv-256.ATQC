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

public class AdminCommunitiesPage extends AdminHomePage {

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
	WebDriverWait wait;
	Properties property;

	public AdminCommunitiesPage(WebDriver driver) {
		super(driver);

	}

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

	public AdminCommunitiesPage deleteCommunity(String string) {

		driver.findElement(
				By.xpath("//tr[@class='commun']//*[text()='" + string + "']/following::a[@id='deletecommunity']"))
				.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getNotificationOkButton());
		return new AdminCommunitiesPage(driver);
	}

	public boolean verifyCommunityPresence(String CommunityName) throws TimeoutException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.navigate().refresh();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//tr[@class='commun']//*[text()='" + CommunityName + "']"), CommunityName));
		return true;

	}

	public boolean verifyNotActiveCommunitiesAreShown() throws TimeoutException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tr[@class='commun' and @type='0']")));
		return true;

	}

	/**
	 * Sets the language for the app
	 */
	@Override
	public AdminCommunitiesPage setLanguage(ChangeLanguageFields language) {

		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		return new AdminCommunitiesPage(driver);
	}

	public void loadLocalizationFile(ChangeLanguageFields language) throws IOException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getCommunitiesLabel()));
		if (language.toString().equalsIgnoreCase("english"))
			loadEnglishPropertiesFile();
		else if (language.toString().equalsIgnoreCase("русский"))
			loadRussianPropertiesFile();
		else if (language.toString().equalsIgnoreCase("українська"))
			loadUkrainianPropertiesFile();

	}

	public void loadEnglishPropertiesFile() throws IOException {
		property = new Properties();
		File fs = new File(System.getProperty("user.dir") + "\\resources\\English.properties");
		FileReader obj = new FileReader(fs);
		property.load(obj);
	}

	public void loadRussianPropertiesFile() throws IOException {
		property = new Properties();
		File fs2 = new File(System.getProperty("user.dir") + "\\resources\\Russian.properties");
		FileReader obj2 = new FileReader(fs2);
		property.load(obj2);

	}

	public void loadUkrainianPropertiesFile() throws IOException {
		property = new Properties();
		File fs3 = new File(System.getProperty("user.dir") + "\\resources\\Ukrainian.properties");
		FileReader obj3 = new FileReader(fs3);
		property.load(obj3);

	}

	public String getObject(String Data) throws IOException {
		String data = property.getProperty(Data);
		return data;
	}
	
	public EditCommunityPage clickEditOnCreatedCommunity(String name) {

		driver.findElement(
				By.xpath("//tr[@class='commun']//*[text()='" + name + "']/following::a[@id='editcommunity']"))
				.click();
		return new EditCommunityPage(driver);
	}
	
	public boolean verifyEditedCommunityPresence(String name2) throws TimeoutException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.navigate().refresh();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//tr[@class='commun']//*[text()='" + name2 + "']"), name2));
		return true;
	}
	public boolean verifyEditedCommunityAbsence(String name) throws TimeoutException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.navigate().refresh();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//tr[@class='commun']//*[text()='" + name + "']"), name));
		return true;
	}
	
}
