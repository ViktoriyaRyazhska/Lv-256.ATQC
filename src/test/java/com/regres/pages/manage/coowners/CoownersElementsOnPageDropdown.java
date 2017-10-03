package com.regres.pages.manage.coowners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CoownersElementsOnPageDropdown extends CoownersTable {

	private WebElement elementsOnPageDropdown;
	private WebElement elementsInfo;
	private WebElement pageOne;
	private WebElement pageTwo;
	private WebElement pageThree;
	private WebElement pageFour;
	private WebElement pageFive;
	private WebElement pageSix;
	private WebElement pageSeven;
	private WebElement pageEight;
	private WebElement pageNine;
	private WebElement pageTen;

	// locators
	String ELEMENTS_ON_PAGE_DROPDOWN_NAME = "example_length";
	String ELEMENTS_ON_PAGE_INFO_ID = "example_info";

	// add pagination
	String PAGE_ONE_XPATH = "//*[@id=\"example_paginate\"]/span/a[1]";
	String PAGE_TWO_XPATH = "//*[@id=\"example_paginate\"]/span/a[2]";
	String PAGE_THREE_XPATH = "//*[@id=\"example_paginate\"]/span/a[3]";
	String PAGE_FOUR_XPATH = "//*[@id=\"example_paginate\"]/span/a[4]";
	String PAGE_FIVE_XPATH = "//*[@id=\"example_paginate\"]/span/a[5]";
	String PAGE_SIX_XPATH = "//*[@id=\"example_paginate\"]/span/a[6]";
	String PAGE_SEVEN_XPATH = "//*[@id=\"example_paginate\"]/span/a[7]";
	String PAGE_EIGHT_XPATH = "//*[@id=\"example_paginate\"]/span/a[8]";
	String PAGE_NINE_XPATH = "//*[@id=\"example_paginate\"]/span/a[9]";
	String PAGE_TEN_XPATH = "//*[@id=\"example_paginate\"]/span/a[10]";

	public CoownersElementsOnPageDropdown(WebDriver driver) {
		super(driver);
		getElementsOnPageDropdown();
		getElementsInfo();

	}

	public WebElement getPageOne() {
		return pageOne = driver.findElement(By.xpath(PAGE_ONE_XPATH));
	}

	public WebElement getPageTwo() {
		return pageTwo = driver.findElement(By.xpath(PAGE_TWO_XPATH));
	}

	public WebElement getPageThree() {
		return pageThree = driver.findElement(By.xpath(PAGE_THREE_XPATH));
	}

	public WebElement getPageFour() {
		return pageFour = driver.findElement(By.xpath(PAGE_FOUR_XPATH));
	}

	public WebElement getPageFive() {
		return pageFive = driver.findElement(By.xpath(PAGE_FIVE_XPATH));
	}

	public WebElement getPageSix() {
		return pageSix = driver.findElement(By.xpath(PAGE_SIX_XPATH));
	}

	public WebElement getPageSeven() {
		return pageSeven = driver.findElement(By.xpath(PAGE_SEVEN_XPATH));
	}

	public WebElement getPageEight() {
		return pageEight = driver.findElement(By.xpath(PAGE_EIGHT_XPATH));
	}

	public WebElement getPageNine() {
		return pageNine = driver.findElement(By.xpath(PAGE_NINE_XPATH));
	}

	public WebElement getPageTen() {
		return pageTen = driver.findElement(By.xpath(PAGE_TEN_XPATH));
	}

	public WebElement getElementsOnPageDropdown() {
		return elementsOnPageDropdown = driver.findElement(By.name(ELEMENTS_ON_PAGE_DROPDOWN_NAME));
	}

	public WebElement getElementsInfo() {
		return elementsInfo = driver.findElement(By.id(ELEMENTS_ON_PAGE_INFO_ID));
	}

	public void setElementsOnPageDropdown(WebElement elementsOnPageDropdown) {
		this.elementsOnPageDropdown = elementsOnPageDropdown;
	}

	public void setElementsInfo(WebElement elementsInfo) {
		this.elementsInfo = elementsInfo;
	}
// select
	public void selectTenElementsOnPage() {
		new Select(elementsOnPageDropdown).selectByVisibleText("10");
	}

	public void selectTwentyFiveElementsOnPage() {
		new Select(elementsOnPageDropdown).selectByVisibleText("25");
	}

	public void selectFiftyElementsOnPage() {
		new Select(elementsOnPageDropdown).selectByVisibleText("50");
	}

	public void selectHundredElementsOnPage() {
		new Select(elementsOnPageDropdown).selectByVisibleText("100");
	}
//get text
	public String getElementsInfoText() {
		return getElementsInfo().getText().trim();
	}

	public String getPageOneText() {
		return getPageOne().getText().trim();
	}

	public String getPageTwoText() {
		return getPageTwo().getText().trim();
	}

	public String getPageThreeText() {
		return getPageThree().getText().trim();
	}

	public String getPageFourText() {
		return getPageFour().getText().trim();
	}

	public String getPageFiveText() {
		return getPageFive().getText().trim();
	}

	public String getPageSixText() {
		return getPageSix().getText().trim();
	}

	public String getPageSevenText() {
		return getPageOne().getText().trim();
	}

	public String getPageEightText() {
		return getPageEight().getText().trim();
	}

	public String getPageNineText() {
		return getPageNine().getText().trim();
	}

	public String getPageTenText() {
		return getPageTen().getText().trim();
	}
	// click
	public void clickPageOne() {
		this.getPageOne().click();
		
	}
	
	public void  clickPageTwo() {
		getPageTwo().click();
		
	}
	// click
	public void  clickPageThree() {
		getPageThree().click();
		
	}
	
	public void  clickPageFour() {
		getPageFour().click();
		
	}
	public void  clickPageFive() {
		getPageFive().click();
		
	}
	public void  clickPageSix() {
		getPageSix().click();
	}
	public void  clickPageSeven() {
		getPageSeven().click();
		
	}
	public void  clickPageEight() {
		getPageEight().click();
		
	}
	public void  clickPageNine() {
		getPageNine().click();
		
	}
	public void clickPageTen() {
		getPageTen().click();
		
	}
	public  void clickPreviousButton() {
		getPrevButtton().click();
	}
public void clickNextButton() {
	  getNextButtton().click();
}
}
