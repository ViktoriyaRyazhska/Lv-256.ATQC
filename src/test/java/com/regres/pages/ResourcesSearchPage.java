package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResourcesSearchPage extends RegistratorHomePage {
   

	String BY_PARAMETERS_BUTTON_ID = "searchByParameterButton";
	String BY_AREA_BUTTON_ID = "searchByAreaButton";
	String BY_COORDINATE_BUTTON_ID = "searchByPointButton";
	String MAP_ID = "openMap";
	String ZOOM_IN_CLASS = "leaflet-control-zoom-in";
	String ZOOM_OUT_CLASS = "leaflet-control-zoom-out";
	String SELECT_POINT_SELECTOR = "#openMap > div.leaflet-control-container > div.leaflet-top.leaflet-left > div:nth-child(2) > a";
	String SELECT_AREA_SELECTOR = "#openMap > div.leaflet-control-container > div.leaflet-top.leaflet-left > div:nth-child(3) > a";
	
	
	private WebElement searchByParameterButton;
	private WebElement searchByAreaButton;
	private WebElement searchByPointButton;
	private WebElement map;
	private WebElement zoomIn;
	private WebElement zoomOut;
	private WebElement selectPoint;
	private WebElement selectArea;
	
    public ResourcesSearchPage(WebDriver driver) {
    	super(driver);
    	searchByParameterButton = driver.findElement(By.id(BY_PARAMETERS_BUTTON_ID));
    	searchByAreaButton = driver.findElement(By.id(BY_AREA_BUTTON_ID));
    	searchByPointButton = driver.findElement(By.id(BY_COORDINATE_BUTTON_ID));
    	map = driver.findElement(By.id(MAP_ID));
    	zoomIn = driver.findElement(By.className(ZOOM_IN_CLASS));
    	zoomOut = driver.findElement(By.className(ZOOM_OUT_CLASS));
    	selectPoint = driver.findElement(By.cssSelector(SELECT_POINT_SELECTOR));
    	selectArea = driver.findElement(By.cssSelector(SELECT_AREA_SELECTOR));
    	
    }

	public WebElement getSearchByParameterButton() {
		return searchByParameterButton;
	}

	public WebElement getSearchByAreaButton() {
		return searchByAreaButton;
	}

	public WebElement getSearchByPointButton() {
		return searchByPointButton;
	}

	public WebElement getMap() {
		return map;
	}

	public WebElement getZoomIn() {
		return zoomIn;
	}

	public WebElement getZoomOut() {
		return zoomOut;
	}

	public WebElement getSelectPoint() {
		return selectPoint;
	}

	public WebElement getSelectArea() {
		return selectArea;
	}
	
	//get text
	public String getSearchByParameterButtonText() {
		return getSearchByParameterButton().getText().trim();
	}
	
	public String getSearchByAreaButtonText() {
		return getSearchByAreaButton().getText().trim();
	}
	
	public String getSearchByPointButtonText() {
		return getSearchByPointButton().getText().trim();
	}
	
	//click
	public SearchResourcesByParameters clickSearchByParameterButton() {
		getSearchByParameterButton().click();
		return new SearchResourcesByParameters(driver);
	}
	
	public SearchResourcesByArea clickSearchByAreaButton() {
		getSearchByAreaButton().click();
		return new SearchResourcesByArea(driver);
	}
	
	public SearchResourcesByPoint clickSearchByPointButton() {
		getSearchByPointButton().click();
		return new SearchResourcesByPoint(driver);
	}
	

}
