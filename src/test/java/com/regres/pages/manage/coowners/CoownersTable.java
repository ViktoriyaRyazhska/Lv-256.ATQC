package com.regres.pages.manage.coowners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.regres.pages.AdminHomePage;
import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.manage.coowners.actions.InactiveCoownersActionsDropdown;
import org.openqa.selenium.support.ui.Select;

public class CoownersTable extends AdminHomePage {
	public ConfirmMessagePage confirm;
	WebElement actions;
	WebElement countElements;
	WebElement searchButton;
	WebElement prevButtton;
	WebElement nextButtton;
	WebElement paginateCurrentButton;
	
	//table columns first row
	By firstNameColumn = By.xpath(".//tbody/tr[1]/td[2]"); 
	By lastNameColumn = By.xpath(".//tbody/tr[1]/td[3]"); 
	By loginColumn = By.xpath(".//tbody/tr[1]/td[4]"); 
	By communityColumn = By.xpath(".//tbody/tr[1]/td[5]"); 
	By emailColumn = By.xpath(".//tbody/tr[1]/td[6]"); 
	By roleColumn = By.xpath(".//tbody/tr[1]/td[7]");
	
	

	public CoownersTable(WebDriver driver) {
		super(driver);
		actions = driver.findElement(By.id("dLabel"));
		countElements = driver.findElement(By.cssSelector("label>select"));
		searchButton = driver.findElement(By.id("bth-search"));
		prevButtton = driver.findElement(By.id("example_previous"));
		nextButtton = driver.findElement(By.id("example_next"));
		paginateCurrentButton = driver.findElement(By.cssSelector(".paginate_button.current"));
	}

	public WebElement getActions() {
		return actions;
	}
	public void setActions(WebElement actions) {
		this.actions = actions;
	}
	public WebElement getCountElements() {
		return countElements;
	}
	public void setCountElements(WebElement countElements) {
		this.countElements = countElements;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	public void setSearchButton(WebElement searchButton) {
		this.searchButton = searchButton;
	}
	public WebElement getPrevButtton() {
		return prevButtton;
	}
	public void setPrevButtton(WebElement prevButtton) {
		this.prevButtton = prevButtton;
	}
	public WebElement getNextButtton() {
		return nextButtton;
	}
	public void setNextButtton(WebElement nextButtton) {
		this.nextButtton = nextButtton;
	}
	public WebElement getPaginateCurrentButton() {
		return paginateCurrentButton;
	}
	public void setPaginateCurrentButton(WebElement paginateCurrentButton) {
		this.paginateCurrentButton = paginateCurrentButton;
	}

	//переписати
	public void setNumbeOfItemsInTable() {
		new Select(driver.findElement(By.name("example_length"))).selectByVisibleText("100");
	}
	
	// Business Logic
	
	public InactiveCoownersActionsDropdown goToInactiveCoowners() {
		// Return a new page object representing the destination.
		return new InactiveCoownersActionsDropdown(driver);
	}

	public WebElement getFirstNameColumn() {
		return driver.findElement(firstNameColumn);
	}
	public WebElement getLastNameColumn() {
		return driver.findElement(lastNameColumn);
	}
	public WebElement getLoginColumn() {
		return driver.findElement(loginColumn);
	}
	public WebElement getCommunityColumn() {
		return driver.findElement(communityColumn);
	}
	public WebElement getEmailColumn() {
		return driver.findElement(emailColumn);
	}
	public WebElement getRoleColumn() {
		return driver.findElement(roleColumn);
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

	
}
