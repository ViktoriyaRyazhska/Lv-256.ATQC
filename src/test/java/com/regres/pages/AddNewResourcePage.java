package com.regres.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewResourcePage {
	WebDriver driver;
	// add another fields
	private WebElement selectCoownerField;
	private WebElement objectNameField;
	private WebElement objectSubclassDropdown;
	private WebElement registrNumbOfObjectField;
	private WebElement editButton;
	private WebElement reasonForInclusionTextArea;
	private WebElement procurationsCheckBox;
	private WebElement dataField;
	private WebElement mapNavTab;
	private WebElement pointsNavTab;
	private WebElement perimeterNavTab;
	private WebElement zoomInButton;
	private WebElement zoomOutButton;
	private WebElement pointsButton;
	private WebElement closeButton;
	private WebElement saveButton;
	private WebElement clearButton;
	private WebElement resourceActsUkrCheckBox;
	private WebElement latitudeDegreeField;
	private WebElement latitudeMinuteField;
	private WebElement latitudeSecondField;
	private WebElement longitudeDegreeField;
	private WebElement longitudeMinuteField;
	private WebElement longitudeSecondField;
	private WebElement latitudeDegreeField2;
	private WebElement latitudeMinuteField2;
	private WebElement latitudeSecondField2;
	private WebElement longitudeDegreeField2;
	private WebElement longitudeMinuteField2;
	private WebElement longitudeSecondField2;
	private WebElement latitudeDegreeField3;
	private WebElement latitudeMinuteField3;
	private WebElement latitudeSecondField3;
	private WebElement longitudeDegreeField3;
	private WebElement longitudeMinuteField3;
	private WebElement longitudeSecondField3;
	private WebElement showOnMapButton;
	private WebElement addPointButton;
	private WebElement addTerritoryButton;
	private WebElement deleteAllPointsButton;

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
	String CLOSE_BUTTON_LOCATOR = "";
	String LATITUDE_DEGREE_FIELD_LOCATOR = "[name*='poligons[0].points[0].latitudeDegrees'";
	String LATITUDE_MINUTE_FIELD_LOCATOR = "[name*='poligons[0].points[0].latitudeMinutes'";
	String LATITUDE_SECOND_FIELD_LOCATOR = "[name*='poligons[0].points[0].latitudeSeconds'";
	String LONGITUDE_DEGREE_FIELD_LOCATOR = "[name*='poligons[0].points[0].longitudeDegrees'";
	String LONGITUDE_MINUTE_FIELD_LOCATOR = "[name*='poligons[0].points[0].longitudeMinutes'";
	String LONGITUDE_SECOND_FIELD_LOCATOR = "[name*='poligons[0].points[0].longitudeSeconds'";
	String LATITUDE_DEGREE_FIELD2_LOCATOR = "[name*='poligons[0].points[1].latitudeDegrees'";
	String LATITUDE_MINUTE_FIELD2_LOCATOR = "[name*='poligons[0].points[1].latitudeMinutes'";
	String LATITUDE_SECOND_FIELD2_LOCATOR = "[name*='poligons[0].points[1].latitudeSeconds'";
	String LONGITUDE_DEGREE_FIELD2_LOCATOR = "[name*='poligons[0].points[1].longitudeDegrees'";
	String LONGITUDE_MINUTE_FIELD2_LOCATOR = "[name*='poligons[0].points[1].longitudeMinutes'";
	String LONGITUDE_SECOND_FIELD2_LOCATOR = "[name*='poligons[0].points[1].longitudeSeconds'";
	String LATITUDE_DEGREE_FIELD3_LOCATOR = "[name*='poligons[0].points[2].latitudeDegrees'";
	String LATITUDE_MINUTE_FIELD3_LOCATOR = "[name*='poligons[0].points[2].latitudeMinutes'";
	String LATITUDE_SECOND_FIELD3_LOCATOR = "[name*='poligons[0].points[2].latitudeSeconds'";
	String LONGITUDE_DEGREE_FIELD3_LOCATOR = "[name*='poligons[0].points[2].longitudeDegrees'";
	String LONGITUDE_MINUTE_FIELD3_LOCATOR = "[name*='poligons[0].points[2].longitudeMinutes'";
	String LONGITUDE_SECOND_FIELD3_LOCATOR = "[name*='poligons[0].points[2].longitudeSeconds'";
	String SHOW_ON_MAP_BUTTON_LOCATOR = "showOnMapButton";
	String ADD_POINT_BUTTON_LOCATOR = "btnAddAreaPoint";
	String ADD_TERRITORY_BUTTON_LOCATOR = "addPolygon";
	String DELETE_ALL_POINTS_LOCATOR = "clearAllPoints";
    
	public void setSelectCoownersText(String coowner) {
		selectCoownerField.clear();
		selectCoownerField.sendKeys(coowner);
	}
	public void setObjectNameText(String object) {
		objectNameField.clear();
		objectNameField.sendKeys(object);
	}
	/*public void selectSubclass(){
		objectSubclassDropdown.click();
		
	}*/
	public void checkProcurationCheckBox() {
		procurationsCheckBox.click();
	}
	public void clickEditButton() {
		editButton.click();
	}
	public void changeRegNumber(String regNumb) {
		clickEditButton();
		registrNumbOfObjectField.clear();
		registrNumbOfObjectField.sendKeys(regNumb);
	}
	public void clickPointsNavTab() {
		pointsNavTab.click();
		latitudeDegreeField = driver.findElement(By.cssSelector(LATITUDE_DEGREE_FIELD_LOCATOR));
		latitudeMinuteField = driver.findElement(By.cssSelector(LATITUDE_MINUTE_FIELD_LOCATOR));
		latitudeSecondField = driver.findElement(By.cssSelector(LATITUDE_SECOND_FIELD_LOCATOR));
		longitudeDegreeField = driver.findElement(By.cssSelector(LONGITUDE_DEGREE_FIELD_LOCATOR));
		longitudeMinuteField = driver.findElement(By.cssSelector(LONGITUDE_MINUTE_FIELD_LOCATOR));
		longitudeSecondField = driver.findElement(By.cssSelector(LONGITUDE_SECOND_FIELD_LOCATOR));
		showOnMapButton = driver.findElement(By.id(SHOW_ON_MAP_BUTTON_LOCATOR));
		addPointButton = driver.findElement(By.id(ADD_POINT_BUTTON_LOCATOR));
		addTerritoryButton = driver.findElement(By.id(ADD_TERRITORY_BUTTON_LOCATOR));
		deleteAllPointsButton = driver.findElement(By.id(DELETE_ALL_POINTS_LOCATOR));
	}
	public void setLatitudeDegreeField(String laD) {
		latitudeDegreeField.clear();
		latitudeDegreeField.sendKeys(laD);
	}
	public void setLatitudeMinutesField(String laM) {
		latitudeMinuteField.clear();
		latitudeMinuteField.sendKeys(laM);
	}
	public void setLatitudeSecondsField(String laS) {
		latitudeSecondField.clear();
		latitudeSecondField.sendKeys(laS);
	}
	public void setLongitudeDegreeField(String loD) {
		longitudeDegreeField.clear();
		longitudeDegreeField.sendKeys(loD);
	}
	public void setLongitudeMinutesField(String loM) {
		longitudeMinuteField.clear();
		longitudeMinuteField.sendKeys(loM);
	}
	public void setLongitudeSecondsField(String loS) {
		longitudeSecondField.clear();
		longitudeSecondField.sendKeys(loS);
	}
	public void clickShowOnMapButton() {
		showOnMapButton.click();
	}
	public void clickAddPointButton() {
		addPointButton.click();
	}
	public void clickAddTerritotyButton() {
		addTerritoryButton.click();
	}
	public void clickDeleteAllPointsButton() {
		deleteAllPointsButton.click();
	}
	public void clickSaveButton() {
		saveButton.click();
	}
	public void clickClearButton() {
		clearButton.click();
	}
	public AddNewResourcePage(WebDriver driver) {
		this.driver = driver;
		selectCoownerField = driver.findElement(By.id(SELECT_COOWNER_INPUTFIELD_ID));
		objectNameField = driver.findElement(By.id(OBJECT_NAME_INPUTFIELD_ID));
		objectSubclassDropdown = driver.findElement(By.id(OBJECT_SUBCLASS_DROPDOWN_ID));
		registrNumbOfObjectField = driver.findElement(By.id(REGISTRNUMB_OBJ_ID));
		editButton = driver.findElement(By.id(EDIT_BUTTON_ID));
		reasonForInclusionTextArea = driver.findElement(By.id(REASON_FOR_INCLUSION_ID));
		procurationsCheckBox = driver.findElement(By.id(PROCURATIONS_CHECKBOX_ID));
		dataField = driver.findElement(By.id(DATE_ID));
		mapNavTab = driver.findElement(By.id(MAP_NAV_TAB_ID));
		pointsNavTab = driver.findElement(By.id(POINTS_NAV_TAB_ID));
		perimeterNavTab = driver.findElement(By.id(PERIMETER_NAV_TAB_ID));
		zoomInButton = driver.findElement(By.className(ZOOM_IN_CLASS));
		zoomOutButton = driver.findElement(By.className(ZOOM_OUT_CLASS));
		pointsButton = driver.findElement(By.id(POINTS_NAV_TAB_ID));
		closeButton = driver.findElement(By.id(CLOSE_BUTTON_LOCATOR));
		saveButton = driver.findElement(By.id(SAVE_BUTTON_ID));
		clearButton = driver.findElement(By.id(CLEAR_FORM_BUTTON_ID));
		resourceActsUkrCheckBox = driver.findElement(By.id(RESORCE_ACTS_UKRAINE_ID));

	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSelectCoownerField() {
		return selectCoownerField;
	}

	public WebElement getObjectNameField() {
		return objectNameField;
	}

	public WebElement getObjectSubclassDropdown() {
		return objectSubclassDropdown;
	}

	public WebElement getRegistrNumbOfObjectField() {
		return registrNumbOfObjectField;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getReasonForInclusionTextArea() {
		return reasonForInclusionTextArea;
	}

	public WebElement getProcurationsCheckBox() {
		return procurationsCheckBox;
	}

	public WebElement getDataField() {
		return dataField;
	}

	public WebElement getMapNavTab() {
		return mapNavTab;
	}

	public WebElement getPointsNavTab() {
		return pointsNavTab;
	}

	public WebElement getPerimeterNavTab() {
		return perimeterNavTab;
	}

	public WebElement getZoomInButton() {
		return zoomInButton;
	}

	public WebElement getZoomOutButton() {
		return zoomOutButton;
	}

	public WebElement getPointsButton() {
		return pointsButton;
	}

	// public WebElement getCloseButton() {
	// return closeButton;
	// }
	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getClearButton() {
		return clearButton;
	}

	public WebElement getResourceActsUkrCheckBox() {
		return resourceActsUkrCheckBox;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setSelectCoownerField(WebElement selectCoowner) {
		this.selectCoownerField = selectCoowner;
	}

	public void setObjectNameField(WebElement objectName) {
		this.objectNameField = objectName;
	}

	public void setObjectSubclassDropdown(WebElement objectSubclass) {
		this.objectSubclassDropdown = objectSubclass;
	}

	public void setRegistrNumbOfObjectField(WebElement registrNumbOfObject) {
		this.registrNumbOfObjectField = registrNumbOfObject;
	}

	public void setEditButton(WebElement edit) {
		this.editButton = edit;
	}

	public void setReasonForInclusionTextArea(WebElement reasonForInclusion) {
		this.reasonForInclusionTextArea = reasonForInclusion;
	}

	public void setProcurationsCheckBox(WebElement procurations) {
		this.procurationsCheckBox = procurations;
	}

	public void setDataField(WebElement data) {
		this.dataField = data;
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

	public void setSaveButton(WebElement save) {
		this.saveButton = save;
	}

	public void setClearButton(WebElement clear) {
		this.clearButton = clear;
	}

	public void setResourceActsUkrCheckBox(WebElement resourceActsUkr) {
		this.resourceActsUkrCheckBox = resourceActsUkr;
	}


	public WebElement getCloseButton() {
		return closeButton;
	}

	public WebElement getLatitudeDegreeField() {
		return latitudeDegreeField;
	}

	public WebElement getLatitudeMinuteField() {
		return latitudeMinuteField;
	}

	public WebElement getLatitudeSecondField() {
		return latitudeSecondField;
	}

	public WebElement getLongitudeDegreeField() {
		return longitudeDegreeField;
	}

	public WebElement getLongitudeMinuteField() {
		return longitudeMinuteField;
	}

	public WebElement getLongitudeSecondField() {
		return longitudeSecondField;
	}

	public WebElement getLatitudeDegreeField2() {
		return latitudeDegreeField2;
	}

	public WebElement getLatitudeMinuteField2() {
		return latitudeMinuteField2;
	}

	public WebElement getLatitudeSecondField2() {
		return latitudeSecondField2;
	}

	public WebElement getLongitudeDegreeField2() {
		return longitudeDegreeField2;
	}

	public WebElement getLongitudeMinuteField2() {
		return longitudeMinuteField2;
	}

	public WebElement getLongitudeSecondField2() {
		return longitudeSecondField2;
	}

	public WebElement getLatitudeDegreeField3() {
		return latitudeDegreeField3;
	}

	public WebElement getLatitudeMinuteField3() {
		return latitudeMinuteField3;
	}

	public WebElement getLatitudeSecondField3() {
		return latitudeSecondField3;
	}

	public WebElement getLongitudeDegreeField3() {
		return longitudeDegreeField3;
	}

	public WebElement getLongitudeMinuteField3() {
		return longitudeMinuteField3;
	}

	public WebElement getLongitudeSecondField3() {
		return longitudeSecondField3;
	}

	public WebElement getShowOnMapButton() {
		return showOnMapButton;
	}

	public WebElement getAddPointButton() {
		return addPointButton;
	}

	public WebElement getAddTerritoryButton() {
		return addTerritoryButton;
	}

	public WebElement getDeleteAllPointsButton() {
		return deleteAllPointsButton;
	}


	public void setLatitudeDegreeField(WebElement latitudeDegreeField) {
		this.latitudeDegreeField = latitudeDegreeField;
	}

	public void setLatitudeMinuteField(WebElement latitudeMinuteField) {
		this.latitudeMinuteField = latitudeMinuteField;
	}

	public void setLatitudeSecondField(WebElement latitudeSecondField) {
		this.latitudeSecondField = latitudeSecondField;
	}

	public void setLongitudeDegreeField(WebElement longitudeDegreeField) {
		this.longitudeDegreeField = longitudeDegreeField;
	}

	public void setLongitudeMinuteField(WebElement longitudeMinuteField) {
		this.longitudeMinuteField = longitudeMinuteField;
	}

	public void setLongitudeSecondField(WebElement longitudeSecondField) {
		this.longitudeSecondField = longitudeSecondField;
	}

	public void setLatitudeDegreeField2(WebElement latitudeDegreeField2) {
		this.latitudeDegreeField2 = latitudeDegreeField2;
	}

	public void setLatitudeMinuteField2(WebElement latitudeMinuteField2) {
		this.latitudeMinuteField2 = latitudeMinuteField2;
	}

	public void setLatitudeSecondField2(WebElement latitudeSecondField2) {
		this.latitudeSecondField2 = latitudeSecondField2;
	}

	public void setLongitudeDegreeField2(WebElement longitudeDegreeField2) {
		this.longitudeDegreeField2 = longitudeDegreeField2;
	}

	public void setLongitudeMinuteField2(WebElement longitudeMinuteField2) {
		this.longitudeMinuteField2 = longitudeMinuteField2;
	}

	public void setLongitudeSecondField2(WebElement longitudeSecondField2) {
		this.longitudeSecondField2 = longitudeSecondField2;
	}

	public void setLatitudeDegreeField3(WebElement latitudeDegreeField3) {
		this.latitudeDegreeField3 = latitudeDegreeField3;
	}

	public void setLatitudeMinuteField3(WebElement latitudeMinuteField3) {
		this.latitudeMinuteField3 = latitudeMinuteField3;
	}

	public void setLatitudeSecondField3(WebElement latitudeSecondField3) {
		this.latitudeSecondField3 = latitudeSecondField3;
	}

	public void setLongitudeDegreeField3(WebElement longitudeDegreeField3) {
		this.longitudeDegreeField3 = longitudeDegreeField3;
	}

	public void setLongitudeMinuteField3(WebElement longitudeMinuteField3) {
		this.longitudeMinuteField3 = longitudeMinuteField3;
	}

	public void setLongitudeSecondField3(WebElement longitudeSecondField3) {
		this.longitudeSecondField3 = longitudeSecondField3;
	}

	public void setShowOnMapButton(WebElement showOnMapButton) {
		this.showOnMapButton = showOnMapButton;
	}

	public void setAddPointButton(WebElement addPointButton) {
		this.addPointButton = addPointButton;
	}

	public void setAddTerritoryButton(WebElement addTerritoryButton) {
		this.addTerritoryButton = addTerritoryButton;
	}

	public void setDeleteAllPointsButton(WebElement deleteAllPointsButton) {
		this.deleteAllPointsButton = deleteAllPointsButton;
	}

}
