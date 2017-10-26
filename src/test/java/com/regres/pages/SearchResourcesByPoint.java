package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResourcesByPoint extends ResourcesSearchPage {

	String SEARCH_BUTTON_ID = "searchOnMapButton";
	String LATITUDE_DEGREES_INPUT_SELECTOR = "input.latitudeDegrees.form-control";
	String LATITUDE_MINUTES_INPUT_SELECTOR = "input.latitudeMinutes.form-control";
	String LATITUDE_SECONDS_INPUT_SELECTOR = "input.latitudeSeconds.form-control";
	String LONGITUDE_DEGREES_INPUT_SELECTOR = "input.longitudeDegrees.form-control.pikaso";
	String LONGITUDE_MINUTES_INPUT_SELECTOR = "input.longitudeMinutes.form-control.pikaso";
	String LONGITUDE_SECONDS_INPUT_SELECTOR = "input.longitudeSeconds.form-control.pikaso";

	private WebElement searchButton;
	private WebElement latitudeDegreesInput;
	private WebElement latitudeMinutesInput;
	private WebElement latitudeSecondsInput;
	private WebElement longitudeDegreesInput;
	private WebElement longitudeMinutesInput;
	private WebElement longitudeSecondsInput;

	public SearchResourcesByPoint(WebDriver driver) {
		super(driver);
		searchButton = driver.findElement(By.id(SEARCH_BUTTON_ID));
		latitudeDegreesInput = driver.findElement(By.cssSelector(LATITUDE_DEGREES_INPUT_SELECTOR));
		latitudeMinutesInput = driver.findElement(By.cssSelector(LATITUDE_MINUTES_INPUT_SELECTOR));
		latitudeSecondsInput = driver.findElement(By.cssSelector(LATITUDE_SECONDS_INPUT_SELECTOR));
		longitudeDegreesInput = driver.findElement(By.cssSelector(LONGITUDE_DEGREES_INPUT_SELECTOR));
		longitudeMinutesInput = driver.findElement(By.cssSelector(LONGITUDE_DEGREES_INPUT_SELECTOR));
		longitudeSecondsInput = driver.findElement(By.cssSelector(LONGITUDE_DEGREES_INPUT_SELECTOR));
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getLatitudeDegreesInput() {
		return latitudeDegreesInput;
	}

	public WebElement getLatitudeMinutesInput() {
		return latitudeMinutesInput;
	}

	public WebElement getLatitudeSecondsInput() {
		return latitudeSecondsInput;
	}

	public WebElement getLongitudeDegreesInput() {
		return longitudeDegreesInput;
	}

	public WebElement getLongitudeMinutesInput() {
		return longitudeMinutesInput;
	}

	public WebElement getLongitudeSecondsInput() {
		return longitudeSecondsInput;
	}

	public void inputLatitudeDegreesInput(String degrees) {
		getLatitudeDegreesInput().sendKeys(degrees);
	}
	
	public void inputLatitudeMinutesInput(String minutes) {
		getLatitudeMinutesInput().sendKeys(minutes);
	}
	
	public void inputLatitudeSecondsInput(String seconds) {
		getLatitudeDegreesInput().sendKeys(seconds);
	}
	
	public void inputLongitudeDegreesInput(String degrees) {
		getLongitudeDegreesInput().sendKeys(degrees);
	}
	
	public void inputLongitudeMinutesInput(String minutes) {
		getLongitudeMinutesInput().sendKeys(minutes);
	}
	
	public void inputLongitudeSecondsInput(String seconds) {
		getLongitudeSecondsInput().sendKeys(seconds);
	}

	// click
	public SearchResourcesByPoint clickSearchButton() {
		getSearchButton().click();
		return new SearchResourcesByPoint(driver);
	}

}
