package framework.pages.coowners.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.pages.AdminHomePage;
import org.openqa.selenium.support.ui.Select;

public class CoownersTable extends AdminHomePage {
	WebElement actions;
	WebElement countElements;
	WebElement searchButton;
	WebElement prevButtton;
	WebElement nextButtton;
	WebElement paginateCurrentButton;
	WebElement numbeOfItemsInTable;
	public CoownersTable(WebDriver driver) {
		super(driver);
		actions = driver.findElement(By.id("dLabel"));
		countElements = driver.findElement(By.cssSelector("label>select"));
		searchButton = driver.findElement(By.id("bth-search"));
		prevButtton = driver.findElement(By.id("example_previous"));
		nextButtton = driver.findElement(By.id("example_next"));
		paginateCurrentButton = driver.findElement(By.cssSelector(".paginate_button.current"));
		numbeOfItemsInTable = driver.findElement(By.name("example_length"));
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

}
