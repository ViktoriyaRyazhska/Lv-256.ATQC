package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResourcesByArea  extends ResourcesSearchPage {

	String SEARCH_BUTTON_ID = "searchOnMapButton";
	String COORDINATE_ONE_LATITUDE_DEGREES_INPUT = "//input[@type='text'][7]";
	String COORDINATE_ONE_LATITUDE_MINUTES_INPUT = "//input[@type='text'][8]";
	String COORDINATE_ONE_LATITUDE_SECONDS_INPUT = "//input[@type='text'][9]";
	String COORDINATE_ONE_LONGITUDE_DEGREES_INPUT = "//input[@type='text'][10]";
	String COORDINATE_ONE_LONGITUDE_MINUTES_INPUT = "//input[@type='text'][11]";
	String COORDINATE_ONE_LONGITUDE_SECONDS_INPUT = "//input[@type='text'][12]";
	String COORDINATE_TWO_LATITUDE_DEGREES_INPUT = "//input[@type='text'][13]";
	String COORDINATE_TWO_LATITUDE_MINUTES_INPUT = "//input[@type='text'][14]";
	String COORDINATE_TWO_LATITUDE_SECONDS_INPUT = "//input[@type='text'][15]";
	String COORDINATE_TWO_LONGITUDE_DEGREES_INPUT = "//input[@type='text'][16]";
	String COORDINATE_TWO_LONGITUDE_MINUTES_INPUT = "//input[@type='text'][17]";
	String COORDINATE_TWO_LONGITUDE_SECONDS_INPUT = "//input[@type='text'][18]";
	
	private WebElement searchButton;
	private WebElement coordinateOneLatitudeDegreesInput;
	private WebElement coordinateOneLatitudeMinutesInput;
	private WebElement coordinateOneLatitudeSecondsInput;
	private WebElement coordinateOneLongitudeDegreesInput;
	private WebElement coordinateOneLongitudeMinutesInput;
	private WebElement coordinateOneLongitudeSecondsInput;
	private WebElement coordinateTwoLatitudeDegreesInput;
	private WebElement coordinateTwoLatitudeMinutesInput;
	private WebElement coordinateTwoLatitudeSecondsInput;
	private WebElement coordinateTwoLongitudeDegreesInput;
	private WebElement coordinateTwoLongitudeMinutesInput;
	private WebElement coordinateTwoLongitudeSecondsInput;
	
	public SearchResourcesByArea(WebDriver driver) {
		super(driver);
		searchButton = driver.findElement(By.id(SEARCH_BUTTON_ID));
		coordinateOneLatitudeDegreesInput = driver.findElement(By.xpath(COORDINATE_ONE_LATITUDE_DEGREES_INPUT));
		coordinateOneLatitudeMinutesInput = driver.findElement(By.xpath(COORDINATE_ONE_LATITUDE_MINUTES_INPUT));
		coordinateOneLatitudeSecondsInput = driver.findElement(By.xpath(COORDINATE_ONE_LATITUDE_SECONDS_INPUT));
		coordinateOneLongitudeDegreesInput = driver.findElement(By.xpath(COORDINATE_ONE_LONGITUDE_DEGREES_INPUT));
		coordinateOneLongitudeMinutesInput = driver.findElement(By.xpath(COORDINATE_ONE_LONGITUDE_MINUTES_INPUT));
		coordinateOneLongitudeSecondsInput = driver.findElement(By.xpath(COORDINATE_ONE_LONGITUDE_SECONDS_INPUT));
		coordinateTwoLatitudeDegreesInput = driver.findElement(By.xpath(COORDINATE_TWO_LATITUDE_DEGREES_INPUT));
		coordinateTwoLatitudeMinutesInput = driver.findElement(By.xpath(COORDINATE_TWO_LATITUDE_MINUTES_INPUT));
		coordinateTwoLatitudeSecondsInput = driver.findElement(By.xpath(COORDINATE_TWO_LATITUDE_SECONDS_INPUT));
		coordinateTwoLongitudeDegreesInput = driver.findElement(By.xpath(COORDINATE_TWO_LONGITUDE_DEGREES_INPUT));
		coordinateTwoLongitudeMinutesInput = driver.findElement(By.xpath(COORDINATE_TWO_LONGITUDE_MINUTES_INPUT));
		coordinateTwoLongitudeSecondsInput = driver.findElement(By.xpath(COORDINATE_TWO_LONGITUDE_SECONDS_INPUT));
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getCoordinateOneLatitudeDegreesInput() {
		return coordinateOneLatitudeDegreesInput;
	}

	public WebElement getCoordinateOneLatitudeMinutesInput() {
		return coordinateOneLatitudeMinutesInput;
	}

	public WebElement getCoordinateOneLatitudeSecondsInput() {
		return coordinateOneLatitudeSecondsInput;
	}

	public WebElement getCoordinateOneLongitudeDegreesInput() {
		return coordinateOneLongitudeDegreesInput;
	}

	public WebElement getCoordinateOneLongitudeMinutesInput() {
		return coordinateOneLongitudeMinutesInput;
	}

	public WebElement getCoordinateOneLongitudeSecondsInput() {
		return coordinateOneLongitudeSecondsInput;
	}

	public WebElement getCoordinateTwoLatitudeDegreesInput() {
		return coordinateTwoLatitudeDegreesInput;
	}

	public WebElement getCoordinateTwoLatitudeMinutesInput() {
		return coordinateTwoLatitudeMinutesInput;
	}

	public WebElement getCoordinateTwoLatitudeSecondsInput() {
		return coordinateTwoLatitudeSecondsInput;
	}

	public WebElement getCoordinateTwoLongitudeDegreesInput() {
		return coordinateTwoLongitudeDegreesInput;
	}

	public WebElement getCoordinateTwoLongitudeMinutesInput() {
		return coordinateTwoLongitudeMinutesInput;
	}

	public WebElement getCoordinateTwoLongitudeSecondsInput() {
		return coordinateTwoLongitudeSecondsInput;
	}
	
	public void clickSearchButton() {
		getSearchButton().click();
	}
	
     // input
	// coordinate one latitude
	public void getInputCoordinateOneLatitudeDegreesInput(String degrees) {
		getCoordinateOneLatitudeDegreesInput().sendKeys(degrees);
	}
	
	public void getInputCoordinateOneLatitudeMinutesInput(String minutes) {
		getCoordinateOneLatitudeMinutesInput().sendKeys(minutes);
	}
	
	public void getInputCoordinateOneLatitudeSecondsInput(String seconds) {
		getCoordinateOneLatitudeSecondsInput().sendKeys(seconds);
	}
	
	//coordinate one longitude
	public void getInputCoordinateOneLongitudeDegreesInput(String degrees) {
		getCoordinateOneLongitudeDegreesInput().sendKeys(degrees);
	}
	
	public void getInputCoordinateOneLongitudeMinutesInput(String minutes) {
		getCoordinateOneLongitudeMinutesInput().sendKeys(minutes);
	}
	
	public void getInputCoordinateOneLongitudeSecondsInput(String seconds) {
		getCoordinateOneLongitudeSecondsInput().sendKeys(seconds);
	}
	// coordinate two latitude
	public void getInputCoordinateTwoLatitudeDegreesInput(String degrees) {
		getCoordinateTwoLatitudeDegreesInput().sendKeys(degrees);
	}
	
	public void getInputCoordinateTwoLatitudeMinutesInput(String minutes) {
		getCoordinateTwoLatitudeMinutesInput().sendKeys(minutes);
	}
	
	public void getInputCoordinateTwoLatitudeSecondsInput(String seconds) {
		getCoordinateOneLatitudeSecondsInput().sendKeys(seconds);
	}
	// coordinate two longitude
	public void getInputCoordinateTwoLongitudeDegreesInput(String degrees) {
		getCoordinateTwoLongitudeDegreesInput().sendKeys(degrees);
	}
	
	public void getInputCoordinateTwoLongitudeMinutesInput(String minutes) {
		getCoordinateTwoLongitudeMinutesInput().sendKeys(minutes);
	}
	
	public void getInputCoordinateTwoLongitudeSecondsInput(String seconds) {
		getCoordinateTwoLongitudeSecondsInput().sendKeys(seconds);
	}
}
