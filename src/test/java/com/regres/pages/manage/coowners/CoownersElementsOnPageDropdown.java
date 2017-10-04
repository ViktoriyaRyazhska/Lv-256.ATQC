package com.regres.pages.manage.coowners;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regres.application.ApplicationSources;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.manage.coowners.actions.InactiveCoownersActionsDropdown;

public class CoownersElementsOnPageDropdown extends CoownersTable {
	ApplicationSources app;
	// locators
	String ELEMENTS_ON_PAGE_DROPDOWN_NAME = "example_length";
	String ELEMENTS_ON_PAGE_INFO_ID = "example_info";
	String PAGINATION_LIST_XPATH = "//*[@id=\"example_paginate\"]/span/a";

	private WebElement elementsOnPageDropdown;
	private WebElement elementsInfo;
	private List<WebElement> pagination;

	// constructor from superclass
	public CoownersElementsOnPageDropdown(WebDriver driver) {
		super(driver);
		getElementsOnPageDropdown();
		getElementsInfo();
	}

	// getters and setters
	public WebElement getElementsOnPageDropdown() {
		return elementsOnPageDropdown = driver.findElement(By.name(ELEMENTS_ON_PAGE_DROPDOWN_NAME));
	}

	public WebElement getElementsInfo() {
		(new WebDriverWait(driver, 10000)).until(ExpectedConditions.visibilityOf(driver.findElement(By.id(ELEMENTS_ON_PAGE_INFO_ID))));
		return elementsInfo = driver.findElement(By.id(ELEMENTS_ON_PAGE_INFO_ID));
	}

	public List<WebElement> getPagination() {
		return pagination = driver.findElements(By.xpath(PAGINATION_LIST_XPATH));
	}

	public void setElementsOnPageDropdown(WebElement elementsOnPageDropdown) {
		this.elementsOnPageDropdown = elementsOnPageDropdown;
	}

	public void setElementsInfo(WebElement elementsInfo) {
		this.elementsInfo = elementsInfo;
	}

	public void setPagination(List<WebElement> pagination) {
		this.pagination = pagination;
	}

	// select options of elemets on page dropdown
	// select option ten
	public CoownersElementsOnPageDropdown selectTenElementsOnPage() {
		new Select(elementsOnPageDropdown).selectByVisibleText("10");
		return new CoownersElementsOnPageDropdown(driver);
	}

	// select option twenty five
	public CoownersElementsOnPageDropdown selectTwentyFiveElementsOnPage() {
		new Select(elementsOnPageDropdown).selectByVisibleText("25");
		return new CoownersElementsOnPageDropdown(driver);
	}

	// select option fifty
	public CoownersElementsOnPageDropdown selectFiftyElementsOnPage() {
		new Select(elementsOnPageDropdown).selectByVisibleText("50");
		return new CoownersElementsOnPageDropdown(driver);
	}

	// select option hundred
	public CoownersElementsOnPageDropdown selectHundredElementsOnPage() {
		new Select(elementsOnPageDropdown).selectByVisibleText("100");
		return new CoownersElementsOnPageDropdown (driver);
	}

	// get text of element which show count of elements on page
	public String getElementsInfoText() {
		this.clickUserName();
		(new WebDriverWait(driver, 10000)).until(ExpectedConditions.visibilityOf(driver.findElement(By.id(ELEMENTS_ON_PAGE_INFO_ID))));
		return getElementsInfo().getText().trim();
	}

	// get pagination size
	public int getPaginationSize() {
		return getPagination().size();
	}

	// click on button that choose previous paginate button
	public void clickPreviousButton() {
		(new WebDriverWait(driver, 10000)).until(ExpectedConditions.visibilityOf(driver.findElement(By.id(PREV_BUTTON_ID))));
		getPrevButtton().click();
	}

	// click on button that choose next paginate button
	public void clickNextButton() {
		(new WebDriverWait(driver, 10000)).until(ExpectedConditions.visibilityOf(driver.findElement(By.id(NEXT_BUTTON_ID))));
		getNextButtton().click();
	}

	// choose first paginate button
	public CoownersElementsOnPageDropdown  checkFirstPaginateButton() {
		for (int i = 0; i < getPaginationSize(); i++) {
			getPagination().get(0).click();
		}
		return new CoownersElementsOnPageDropdown(driver);
	}

	// choose last paginate button
	public CoownersElementsOnPageDropdown checkLastPaginateButton() {
		for (int i = 0; i < getPaginationSize(); i++) {
			getPagination().get(getPaginationSize()-1).click();
		}
		return new CoownersElementsOnPageDropdown(driver);
	}

	// choose penultimate paginate button
	public CoownersElementsOnPageDropdown checkPenultimatePaginateButton() {
		for (int i = 0; i < getPaginationSize(); i++) {
			getPagination().get(getPaginationSize() - 2).click();
		}
		return new CoownersElementsOnPageDropdown(driver);
	}

	// change language
	@Override
	public CoownersElementsOnPageDropdown setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new CoownersElementsOnPageDropdown(driver);
	}

	// Localization enum
	public static enum pageL10n {
		DROPDOWN_LABEL("елементів на сторінку", "элементов на страницу", "elements on page"), 
		EXAMPLE_INFO10("10 із 52","10 из 52", "10 of 52"), 
		EXAMPLE_INFO20("20 із 52", "20 из 52", "20 of 52"), 
		EXAMPLE_INFO30("30 із 52","30 из 52", "30 of 52"), 
		EXAMPLE_INFO40("40 із 52", "40 из 52", "40 of 52"), 
		EXAMPLE_INFO50("50 із 52", "50 из 52","50 of 52"), 
		EXAMPLE_INFO25("25 із 52", "25 из 52", "25 of 52"), 
		EXAMPLE_INFO100("52 із 52", "52 из 52", "52 of 52"), 
		PREVIOUS_BUTTON("Попер.", "Пред.","Prev"),
		NEXT_BUTTON("Наст.", "След.", "Next");

		private HashMap<ChangeLanguageFields, String> field;

		private pageL10n(String... localization) {
			this.field = new HashMap<ChangeLanguageFields, String>();
			int i = 0;
			for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
				this.field.put(language, localization[i]); // initialization of the field HashMap(sets all values for
															// current language)
				i++;
			}
		}

		public String getLocalization(ChangeLanguageFields language) {
			return this.field.get(language).trim();
		}
	}
}
