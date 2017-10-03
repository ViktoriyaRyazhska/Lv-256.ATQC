package com.regres.pages.manage.coowners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.regres.pages.AdminHomePage;
import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.manage.coowners.actions.InactiveCoownersActionsDropdown;
import com.regres.pages.manage.coowners.actions.NonConfirmedCoownersActionsDropdown;

public class CoownersTable extends AdminHomePage {
	public ConfirmMessagePage confirm;
	String ACTIONS_ID = "dLabel";
	String COUNT_ELEMENTS_CSSSELECTOR = "label>select";
	String SEARCH_BUTTON_ID = "bth-search";
	String PREV_BUTTON_ID = "example_previous";
	String NEXT_BUTTON_ID = "example_next";
	String PAGINATE_CURRENT_BUTTON_CSSSELECTOR = ".paginate_button.current";

	// table hider
	private String TABLE_TITLE_XPATH = "//div[@class = 'dataTable_wrapper']/preceding::h4";

	// table search
	private String LOGIN_INPUT_ID = "inputIndex3";
	private String FIRST_ROW_TABLE_XPATH = "//tbody/tr[1]";

	// table columns first row
	String FIRST_NAME_COLUMN = ".//tbody/tr[1]/td[2]";
	String LAST_NAME_COLUMN = ".//tbody/tr[1]/td[3]";
	String LOGIN_COLUMN = ".//tbody/tr[1]/td[4]";
	String COMMUNITY_COLUMN = ".//tbody/tr[1]/td[5]";
	String EMAIL_COLUMN = ".//tbody/tr[1]/td[6]";
	String ROLE_COLUMN = ".//tbody/tr[1]/td[7]";

	public CoownersTable(WebDriver driver) {
		super(driver);
		getActions();
		getCountElements();
		getSearchButton();
		getPrevButtton();
		getNextButtton();
		getPaginateCurrentButton();
	}

	public WebElement getTitle() {
		return driver.findElement(By.xpath(TABLE_TITLE_XPATH));
	}

	public String getTitleText() {
		return getTitle().getText().trim();
	}

	public WebElement getActions() {
		return driver.findElement(By.id(ACTIONS_ID));
	}

	public WebElement getCountElements() {
		return driver.findElement(By.cssSelector(COUNT_ELEMENTS_CSSSELECTOR));
	}

	public WebElement getSearchButton() {
		return driver.findElement(By.id(ACTIONS_ID));
	}

	public WebElement getPrevButtton() {
		return driver.findElement(By.id(PREV_BUTTON_ID));
	}

	public WebElement getNextButtton() {
		return driver.findElement(By.id(NEXT_BUTTON_ID));
	}

	public WebElement getPaginateCurrentButton() {
		return driver.findElement(By.cssSelector(PAGINATE_CURRENT_BUTTON_CSSSELECTOR));
	}

	// переписати
	public void setNumbeOfItemsInTable() {
		new Select(driver.findElement(By.name("example_length"))).selectByVisibleText("100");
	}

	public WebElement getFirstNameColumn() {
		return driver.findElement(By.xpath(FIRST_NAME_COLUMN));
	}

	public WebElement getLastNameColumn() {
		return driver.findElement(By.xpath(LAST_NAME_COLUMN));
	}

	public WebElement getLoginColumn() {
		return driver.findElement(By.xpath(LOGIN_COLUMN));
	}

	public WebElement getFirstRowTable() {
		return driver.findElement(By.xpath(FIRST_ROW_TABLE_XPATH));
	}

	public WebElement getCommunityColumn() {
		return driver.findElement(By.xpath(COMMUNITY_COLUMN));
	}

	public WebElement getEmailColumn() {
		return driver.findElement(By.xpath(EMAIL_COLUMN));
	}

	public WebElement getRoleColumn() {
		return driver.findElement(By.xpath(ROLE_COLUMN));
	}

	public WebElement getLoginIinputField() {
		return driver.findElement(By.id(LOGIN_INPUT_ID));
	}

	public String getFirstNameColumnText() {
		return getFirstNameColumn().getText().trim();
	}

	public String getLastNameColumnText() {
		return getLastNameColumn().getText().trim();
	}

	public String getLoginColumnText() {
		return getLoginColumn().getText().trim();
	}

	public String getCommunityColumnText() {
		return getCommunityColumn().getText().trim();
	}

	public String getEmailColumnText() {
		return getEmailColumn().getText().trim();
	}

	public String getRoleColumnText() {
		return getRoleColumn().getText().trim();
	}

	// Business Logic
	// search by login name
	public void search(String login) {
		this.getLoginIinputField().clear();
		this.getLoginIinputField().sendKeys(login);
		this.getSearchButton().click();
	}

	public void clickFirstRow() {
		this.getFirstRowTable().click();
	}

	public InactiveCoownersActionsDropdown goToInactiveCoowners() {
		// Return a new page object representing the destination.
		return new InactiveCoownersActionsDropdown(driver);
	}

	public NonConfirmedCoownersActionsDropdown goToNonConfirmedCoowners() {
		// Return a new page object representing the destination.
		return new NonConfirmedCoownersActionsDropdown(driver);
	}
}
