package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoownersTable extends AdminHomePage {
	WebElement actions;
	WebElement countElements;
	WebElement searchButton;
	WebElement prevButtton;
	WebElement nextButtton;
	WebElement paginateCurrentButton;
	public CoownersTable(WebDriver driver) {
		super(driver);
		actions = driver.findElement(By.cssSelector("#dLabel"));
		countElements = driver.findElement(By.cssSelector("label>select"));
		searchButton = driver.findElement(By.cssSelector("#bth-search"));
		prevButtton = driver.findElement(By.cssSelector("#example_previous"));
		nextButtton = driver.findElement(By.cssSelector("#example_next"));
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

}
