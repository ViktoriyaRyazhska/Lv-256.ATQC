package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewResourcePage {
    WebDriver driver;
    //add another fields

    public AddNewResourcePage(WebDriver driver) {
        this.driver = driver;
    }
    
    String SELECT_COOWNER_INPUTFIELD_ID = "#owner_search";
    String OBJECT_NAME_INPUTFIELD_ID = "#w-input-search";
    String OBJECT_SUBCLASS_DROPDOWN_ID = "#resourcesTypeSelect";
    String REASON_FOR_INCLUSION_ID = "#reasonInclusion";
    String DATE_ID = "#datepicker";
    String REGISTRNUMB_OBJ_ID = "#identifier";
    String EDIT_BUTTON_ID = "#editNumber";
    String PROCURATIONS_CHECKBOX_ID = "#delivery";
    String MAP_NAV_TAB_ID = "#map";
    String POINTS_NAV_TAB_ID = "#points";
    String PERIMETER_NAV_TAB_ID = "#calculatedParams";
    String ZOOM_IN_CLASS = ".leaflet-control-zoom-in";
    String ZOOM_OUT_CLASS = ".leaflet-control-zoom-out";
    String RESORCE_ACTS_UKRAINE_ID = "#allUkraine";
    String SAVE_BUTTON_ID = "#submitForm";
    String CLEAR_FORM_BUTTON_ID = "#resetForm";
    private WebElement selectCoowner;
    private WebElement objectName;
    private WebElement objectSubclass ;
    private WebElement registrNumbOfObject;
    private WebElement edit;
    private WebElement reasonForInclusion;
    private WebElement procurations;
    private WebElement data;
    private WebElement mapNavTab;
    private WebElement pointsNavTab;
    private WebElement perimeterNavTab;
    private WebElement zoomInButton;
    private WebElement zoomOutButton;
    private WebElement pointsButton;
    private WebElement closeButton;
    private WebElement save;
    private WebElement clear;
    private WebElement resourceActsUkr;

	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getSelectCoowner() {
		return selectCoowner=driver.findElement(By.id(SELECT_COOWNER_INPUTFIELD_ID));
	}
	public WebElement getObjectName() {
		return objectName=driver.findElement(By.id(OBJECT_NAME_INPUTFIELD_ID));
	}
	public WebElement getObjectSubclass() {
		return objectSubclass=driver.findElement(By.id(OBJECT_SUBCLASS_DROPDOWN_ID));
	}
	public WebElement getRegistrNumbOfObject() {
		return registrNumbOfObject=driver.findElement(By.id(REGISTRNUMB_OBJ_ID));
	}
	public WebElement getEdit() {
		return edit=driver.findElement(By.id(EDIT_BUTTON_ID));
	}
	public WebElement getReasonForInclusion() {
		return reasonForInclusion=driver.findElement(By.id(REASON_FOR_INCLUSION_ID));
	}
	public WebElement getProcurations() {
		return procurations=driver.findElement(By.id(PROCURATIONS_CHECKBOX_ID));
	}
	public WebElement getData() {
		return data=driver.findElement(By.id(DATE_ID));
	}
	public WebElement getMapNavTab() {
		return mapNavTab=driver.findElement(By.id(MAP_NAV_TAB_ID));
	}
	public WebElement getPointsNavTab() {
		return pointsNavTab=driver.findElement(By.id(POINTS_NAV_TAB_ID));
	}
	public WebElement getPerimeterNavTab() {
		return perimeterNavTab=driver.findElement(By.id(PERIMETER_NAV_TAB_ID));
	}
	public WebElement getZoomInButton() {
		return zoomInButton=driver.findElement(By.className(ZOOM_IN_CLASS));
	}
	public WebElement getZoomOutButton() {
		return zoomOutButton=driver.findElement(By.className(ZOOM_OUT_CLASS));
	}
	public WebElement getPointsButton() {
		return pointsButton=driver.findElement(By.id(POINTS_NAV_TAB_ID));
	}
//	public WebElement getCloseButton() {
//		return closeButton=driver.findElement(By.id());
//	}
	public WebElement getSave() {
		return save=driver.findElement(By.id(SAVE_BUTTON_ID));
	}
	public WebElement getClear() {
		return clear=driver.findElement(By.id(CLEAR_FORM_BUTTON_ID));
	}
	public WebElement getResourceActsUkr() {
		return resourceActsUkr=driver.findElement(By.id(RESORCE_ACTS_UKRAINE_ID));
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public void setSelectCoowner(WebElement selectCoowner) {
		this.selectCoowner = selectCoowner;
	}
	public void setObjectName(WebElement objectName) {
		this.objectName = objectName;
	}
	public void setObjectSubclass(WebElement objectSubclass) {
		this.objectSubclass = objectSubclass;
	}
	public void setRegistrNumbOfObject(WebElement registrNumbOfObject) {
		this.registrNumbOfObject = registrNumbOfObject;
	}
	public void setEdit(WebElement edit) {
		this.edit = edit;
	}
	public void setReasonForInclusion(WebElement reasonForInclusion) {
		this.reasonForInclusion = reasonForInclusion;
	}
	public void setProcurations(WebElement procurations) {
		this.procurations = procurations;
	}
	public void setData(WebElement data) {
		this.data = data;
	}
	public void setMapNavTab(WebElement mapNavTab) {
		this.mapNavTab = mapNavTab;
	}
	public void setPointsNavTab(WebElement pointsNavTab) {
		this.pointsNavTab = pointsNavTab;
	}
	public void setPerimeterNavTab(WebElement perimeterNavTab) {
		this.perimeterNavTab = perimeterNavTab;
	}
	public void setZoomInButton(WebElement zoomInButton) {
		this.zoomInButton = zoomInButton;
	}
	public void setZoomOutButton(WebElement zoomOutButton) {
		this.zoomOutButton = zoomOutButton;
	}
	public void setPointsButton(WebElement pointsButton) {
		this.pointsButton = pointsButton;
	}
	public void setCloseButton(WebElement closeButton) {
		this.closeButton = closeButton;
	}
	public void setSave(WebElement save) {
		this.save = save;
	}
	public void setClear(WebElement clear) {
		this.clear = clear;
	}
	public void setResourceActsUkr(WebElement resourceActsUkr) {
		this.resourceActsUkr = resourceActsUkr;
	}
    
}
