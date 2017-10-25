package com.regres.pages;

import java.io.File; 
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.regres.testdata.CommunitiesTable;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;

/**
 * Class represents Community page which contains all created communities where
 * administrator can manage them by deleting, activating, creating new and
 * editing previously created.
 */

public class AdminCommunitiesPage extends AdminHomePage {

	WebDriverWait wait;
	Properties property;

	String TABLE_BODY_ROWS = "//tbody/tr";
	String TABLE_BODY_CELL = TABLE_BODY_ROWS + "/td";
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
	String NOT_ACTIVATED_COMUNITY_XPATH = "//tr[@class='commun' and @type='0']//*[text()='";
	String ENGLISH_LANGUAGE = "english";
	String RUSSIAN_LANGUAGE = "русский";
	String UKRAINIAN_LANGUAGE = "українська";
	String USER_REPO = "user.dir";
	static String ENGLISH_FILE_PATH = "\\resources\\English.properties";
	static String RUSSIAN_FILE_PATH = "\\resources\\Russian.properties";
	static String UKRAINIAN_FILE_PATH = "\\resources\\Ukrainian.properties";
	String COOWNERS_XPATH = "//a[@data-toggle=\"dropdown\"]";
	String ACTIVE_COOWNERS_XPATH = "//a[contains(@href,\"get-all-users\")]";

	private static volatile AdminCommunitiesPage instance = null;

	public AdminCommunitiesPage(WebDriver driver) {
		super(driver);
	}

	public static AdminCommunitiesPage get(WebDriver driver) {
		if (instance == null) {
			synchronized (AdminCommunitiesPage.class) {
				if (instance == null) {
					instance = new AdminCommunitiesPage(driver);
				}
			}
		}
		return instance;
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

	public WebElement getCoowners() {
		return driver.findElement(By.xpath(COOWNERS_XPATH));
	}

	public WebElement getActiveCoowners() {
		return driver.findElement(By.xpath(ACTIVE_COOWNERS_XPATH));
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

	public void clickCoowners() {
		getCoowners().click();
		getActiveCoowners();
	}

	public ActiveCoownersActionsDropdown clickActiveCoowners() {
		getActiveCoowners().click();
		return new ActiveCoownersActionsDropdown(driver);
	}

	/** Methods for getting information from table of communities */
	public List<WebElement> getAllTableBodyRows() {
		List<WebElement> rows_collection = driver.findElements(By.xpath(TABLE_BODY_ROWS));
		return rows_collection;
	}

	public List<WebElement> getAlltableBodyCell() {
		List<WebElement> cell_collection = driver.findElements(By.xpath(TABLE_BODY_CELL));
		return cell_collection;
	}

	public int getTableBodyRowsCount() {
		return getAllTableBodyRows().size();
	}

	public int getTableBodyCellsCount() {
		return getAlltableBodyCell().size();
	}

	/** refreshes the page and waits */
	public void refreshAndWait() {
		waitWhileScriptsExecute();
		driver.navigate().refresh();
	}

	/** method that click and deletes community by name */
	public AdminCommunitiesPage deleteCommunity(String communityName) {
		driver.findElement(By.xpath(ROWS_IN_TABLE_XPATH + communityName + DELETE_IN_ROW_BUTTON_XPATH)).click();
		((JavascriptExecutor) driver).executeScript(JS_CLICK, getNotificationOkButton());
		return new AdminCommunitiesPage(driver);
	}

	/**
	 * method that not activated communities are shown if click on appropriate
	 * checkbox
	 */
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
		return AdminCommunitiesPage.get(driver);
	}

	/** Set enum for getting language path */
	public static enum LanguagePath {
		UKR_PATH(UKRAINIAN_FILE_PATH), RUS_PATH(RUSSIAN_FILE_PATH), ENG_PATH(ENGLISH_FILE_PATH);
		private String path;

		private LanguagePath(String path) {
			this.path = path;
		}

		public String toString() {
			return this.path;
		}
	}

	/**
	 * method that calls appropriate Language properties files loadings in
	 * dependence from language that is set
	 */
	public void setLanguageFileToBeLoaded(ChangeLanguageFields language) throws IOException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(getCommunitiesLabel()));
		if (language.toString().equalsIgnoreCase(ENGLISH_LANGUAGE))
			loadLanguagePropertiesFile(LanguagePath.ENG_PATH);
		else if (language.toString().equalsIgnoreCase(RUSSIAN_LANGUAGE))
			loadLanguagePropertiesFile(LanguagePath.RUS_PATH);
		else if (language.toString().equalsIgnoreCase(UKRAINIAN_LANGUAGE))
			loadLanguagePropertiesFile(LanguagePath.UKR_PATH);
	}

	/** method that loads language properties file */
	public void loadLanguagePropertiesFile(LanguagePath path) throws IOException {
		property = new Properties();
		File fs = new File(System.getProperty(USER_REPO) + path);
		FileReader obj = new FileReader(fs);
		property.load(obj);
	}

	/** method that gets needed value by key from appropriate properties file */
	public String getLocalizationValue(String value) throws IOException {
		String data = property.getProperty(value);
		return data;
	}

	/** method that opens edit page for community from table by its name */
	public EditCommunityPage clickEditOnCreatedCommunity(String communityName) {
		driver.findElement(By.xpath(ROWS_IN_TABLE_XPATH + communityName + EDIT_IN_ROW_BUTTON_XPATH)).click();
		return new EditCommunityPage(driver);
	}

	/** method that verifies if renamed community is present in table */
	public boolean verifyEditedCommunityPresence(String communityName2) throws TimeoutException {
		refreshAndWait();
		wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(ROWS_IN_TABLE_XPATH + communityName2 + "']"), communityName2));
	}

	/** method that verifies deleted community presence */
	public boolean verifyDeletedCommunityPresence(String communityName) throws TimeoutException {
		wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath(ROWS_IN_TABLE_XPATH + communityName + "']"), communityName));
	}
	
	/** method that verifies deleted community becomes NotActive as it had users assigned */
	public boolean verifyDeletedCommunityIsNowNotActive(String communityName) throws TimeoutException {
		wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath(NOT_ACTIVATED_COMUNITY_XPATH + communityName + "']"), communityName));
	}
	
	/** method that verifies that renamed community is not present in table */
	public boolean verifyEditedCommunityAbsence(String communityName) throws TimeoutException {
		refreshAndWait();
		wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions
				.textToBePresentInElementLocated(By.xpath(ROWS_IN_TABLE_XPATH + communityName + "']"), communityName));
	}

	/** method that gets list of communities from the table */
	public List<CommunitiesTable> getListOfCommunitiesFromTable() {
		List<CommunitiesTable> comList = new ArrayList<>();
		if (waitWhileScriptsExecute()) {
			List<WebElement> celllist = getAlltableBodyCell();
			int count = getTableBodyCellsCount();
			for (int j = 0; j <= count - 3; j = j + 3) {
				comList.add(new CommunitiesTable(celllist.get(j + 0).getText(), celllist.get(j + 1).getText()));
			}
		} else {
			getListOfCommunitiesFromTable();
		}
		return comList;
	}

	/** method that compares two lists of communities taken from the table */
	public boolean compareLists(List<CommunitiesTable> userList1, List<CommunitiesTable> userList2) {
		return userList1.equals(userList2);
	}

	/** method that waits while table with communities is properly loaded */
	public boolean waitWhileScriptsExecute() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
			}
		};
		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

}