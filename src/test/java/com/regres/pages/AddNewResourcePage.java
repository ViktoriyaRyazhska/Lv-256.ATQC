package com.regres.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.Coordinates;

/**
 * Add new Resource Page Object
 * 
 * @author Юрій
 *
 */
public class AddNewResourcePage extends RegistratorHomePage {
	// Web elements of Page Object
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
	private WebElement showOnMapButton;
	private WebElement addPointButton;
	private WebElement addTerritoryButton;
	private WebElement deleteAllPointsButton;
	private WebElement addPointErrorMessage;
	private WebElement addPointMessageOKButton;
	private WebElement deletePointButton;
	private String errorMessage;
	private WebElement resourceNameError;
	private WebElement reasonError;
	// Locators
	String RESOURCE_NAME_ERROR_LOCATOR = "description.errors";
	String REASON_ERROR_LOCATOR = "reasonInclusion.errors";
	String SELECT_COOWNER_INPUTFIELD_ID = "owner_search";
	String OBJECT_NAME_INPUTFIELD_ID = "w-input-search";
	String OBJECT_SUBCLASS_DROPDOWN_ID = "resourcesTypeSelect";
	String REASON_FOR_INCLUSION_ID = "reasonInclusion";
	String DATE_ID = "datepicker";
	String REGISTRNUMB_OBJ_ID = "identifier";
	String EDIT_BUTTON_ID = "editNumber";
	String PROCURATIONS_CHECKBOX_ID = "delivery";
	String MAP_NAV_TAB_ID = "map";
	String POINTS_NAV_TAB_LOCATOR = "[data-target*='points']";
	String PERIMETER_NAV_TAB_ID = "calculatedParams";
	String ZOOM_IN_CLASS = "leaflet-control-zoom-in";
	String ZOOM_OUT_CLASS = "leaflet-control-zoom-out";
	String RESORCE_ACTS_UKRAINE_ID = "allUkraine";
	String SAVE_BUTTON_ID = "submitForm";
	String CLEAR_FORM_BUTTON_ID = "resetForm";
	// String CLOSE_BUTTON_LOCATOR = "";
	String LATITUDE_DEGREE_FIELD_LOCATOR = "[name*='poligons[0].points[0].latitudeDegrees']";
	String LATITUDE_MINUTE_FIELD_LOCATOR = "[name*='poligons[0].points[0].latitudeMinutes']";
	String LATITUDE_SECOND_FIELD_LOCATOR = "[name*='poligons[0].points[0].latitudeSeconds']";
	String LONGITUDE_DEGREE_FIELD_LOCATOR = "[name*='poligons[0].points[0].longitudeDegrees']";
	String LONGITUDE_MINUTE_FIELD_LOCATOR = "[name*='poligons[0].points[0].longitudeMinutes']";
	String LONGITUDE_SECOND_FIELD_LOCATOR = "[name*='poligons[0].points[0].longitudeSeconds']";
	String LATITUDE_DEGREE_FIELD2_LOCATOR = "[name*='poligons[0].points[1].latitudeDegrees']";
	String LATITUDE_MINUTE_FIELD2_LOCATOR = "[name*='poligons[0].points[1].latitudeMinutes']";
	String LATITUDE_SECOND_FIELD2_LOCATOR = "[name*='poligons[0].points[1].latitudeSeconds']";
	String LONGITUDE_DEGREE_FIELD2_LOCATOR = "[name*='poligons[0].points[1].longitudeDegrees']";
	String LONGITUDE_MINUTE_FIELD2_LOCATOR = "[name*='poligons[0].points[1].longitudeMinutes']";
	String LONGITUDE_SECOND_FIELD2_LOCATOR = "[name*='poligons[0].points[1].longitudeSeconds']";
	String LATITUDE_DEGREE_FIELD3_LOCATOR = "[name*='poligons[0].points[2].latitudeDegrees']";
	String LATITUDE_MINUTE_FIELD3_LOCATOR = "[name*='poligons[0].points[2].latitudeMinutes']";
	String LATITUDE_SECOND_FIELD3_LOCATOR = "[name*='poligons[0].points[2].latitudeSeconds']";
	String LONGITUDE_DEGREE_FIELD3_LOCATOR = "[name*='poligons[0].points[2].longitudeDegrees']";
	String LONGITUDE_MINUTE_FIELD3_LOCATOR = "[name*='poligons[0].points[2].longitudeMinutes'";
	String LONGITUDE_SECOND_FIELD3_LOCATOR = "[name*='poligons[0].points[2].longitudeSeconds'";
	String SHOW_ON_MAP_BUTTON_LOCATOR = "addPointsToMap";
	String ADD_POINT_BUTTON_LOCATOR = "btnAddAreaPoint";
	String ADD_TERRITORY_BUTTON_LOCATOR = "addPolygon";
	String DELETE_ALL_POINTS_LOCATOR = "clearAllPoints";
	String ADD_POINT_ERROR_MESSAGE_LOCATOR = "bootbox-body";
	String ADD_POINT_MESSAGE_OK_BUTTON_LOCATOR = "[data-bb-handler = 'ok']";
	String DELETE_POINT_BUTTON_LOCATOR = ".delPoint";

	/**
	 * Select subclass of object
	 */
	public void selectObjSubclass() {
		Select select = new Select(objectSubclassDropdown);
		select.selectByVisibleText("земельний");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

	}

	/**
	 * Get error message
	 * 
	 * @return -errorMessage
	 */
	public String getAddPointMessageText() {
		clickSaveButton();
		addPointErrorMessage = driver.findElement(By.className(ADD_POINT_ERROR_MESSAGE_LOCATOR));
		addPointMessageOKButton = driver.findElement(By.cssSelector(ADD_POINT_MESSAGE_OK_BUTTON_LOCATOR));
		errorMessage = addPointErrorMessage.getText().trim();
		clickAddPointMessageButton();
		return errorMessage;

	}

	/**
	 * Get object name error message
	 */
	public void getNameErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		resourceNameError = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(RESOURCE_NAME_ERROR_LOCATOR)));

	}

	/**
	 * Get reason for including error message
	 */
	public void getReasoneErrorMessage() {
		reasonError = driver.findElement(By.id(REASON_ERROR_LOCATOR));
	}

	/**
	 * Get error text
	 * 
	 * @return error text
	 */
	public String getNameErrorMessageText() {
		return resourceNameError.getText().trim();
	}

	/**
	 * Get error text
	 * 
	 * @return error text
	 */
	public String getReasoneErrorMessageText() {
		return reasonError.getText().trim();
	}

	/**
	 * Set up points coordinates
	 * 
	 * @param coordinates
	 *            -coordinates enum
	 */
	public void setCoordinates(Coordinates coordinates) {
		latitudeDegreeField.clear();
		latitudeDegreeField.sendKeys(coordinates.getLatitudeDegreeField());
		latitudeMinuteField.clear();
		latitudeMinuteField.sendKeys(coordinates.getLatitudeMinuteField());
		latitudeSecondField.clear();
		latitudeSecondField.sendKeys(coordinates.getLatitudeSecondField());
		longitudeDegreeField.clear();
		longitudeDegreeField.sendKeys(coordinates.getLongitudeDegreeField());
		longitudeMinuteField.clear();
		longitudeMinuteField.sendKeys(coordinates.getLongitudeMinuteField());
		longitudeSecondField.clear();
		longitudeSecondField.sendKeys(coordinates.getLongitudeSecondField());

	}

	/**
	 * Add second nav point
	 */
	public void addSecondPoint() {
		clickAddPointButton();
		latitudeDegreeField = driver.findElement(By.cssSelector(LATITUDE_DEGREE_FIELD2_LOCATOR));
		latitudeMinuteField = driver.findElement(By.cssSelector(LATITUDE_MINUTE_FIELD2_LOCATOR));
		latitudeSecondField = driver.findElement(By.cssSelector(LATITUDE_SECOND_FIELD2_LOCATOR));
		longitudeDegreeField = driver.findElement(By.cssSelector(LONGITUDE_DEGREE_FIELD2_LOCATOR));
		longitudeMinuteField = driver.findElement(By.cssSelector(LONGITUDE_MINUTE_FIELD2_LOCATOR));
		longitudeSecondField = driver.findElement(By.cssSelector(LONGITUDE_SECOND_FIELD2_LOCATOR));

	}

	/**
	 * Add third nav point
	 */
	public void addThirdPoint() {
		clickAddPointButton();
		latitudeDegreeField = driver.findElement(By.cssSelector(LATITUDE_DEGREE_FIELD3_LOCATOR));
		latitudeMinuteField = driver.findElement(By.cssSelector(LATITUDE_MINUTE_FIELD3_LOCATOR));
		latitudeSecondField = driver.findElement(By.cssSelector(LATITUDE_SECOND_FIELD3_LOCATOR));
		longitudeDegreeField = driver.findElement(By.cssSelector(LONGITUDE_DEGREE_FIELD3_LOCATOR));
		longitudeMinuteField = driver.findElement(By.cssSelector(LONGITUDE_MINUTE_FIELD3_LOCATOR));
		longitudeSecondField = driver.findElement(By.cssSelector(LONGITUDE_SECOND_FIELD3_LOCATOR));
	}

	/**
	 * Get error message
	 * 
	 * @return errorMessage
	 */
	public String getAddLastPointMessageText() {
		clickDeletePointButton();
		addPointErrorMessage = driver.findElement(By.className(ADD_POINT_ERROR_MESSAGE_LOCATOR));
		addPointMessageOKButton = driver.findElement(By.cssSelector(ADD_POINT_MESSAGE_OK_BUTTON_LOCATOR));
		errorMessage = addPointErrorMessage.getText().trim();
		clickAddPointMessageButton();
		return errorMessage;
	}

	/**
	 * Get Error message
	 */
	public void getErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		addPointErrorMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className(ADD_POINT_ERROR_MESSAGE_LOCATOR)));// driver.findElement(By.className(ADD_POINT_ERROR_MESSAGE_LOCATOR));
		addPointMessageOKButton = driver.findElement(By.cssSelector(ADD_POINT_MESSAGE_OK_BUTTON_LOCATOR));

	}

	/**
	 * Get Error text
	 * 
	 * @return error text
	 */
	public String getErrorMessageText() {
		return addPointErrorMessage.getText().trim();
	}

	/**
	 * Get error message
	 * 
	 * @return errorMessage
	 */
	public String getAddThreePointsMessageText() {
		clickAddTerritotyButton();
		addPointErrorMessage = driver.findElement(By.className(ADD_POINT_ERROR_MESSAGE_LOCATOR));
		addPointMessageOKButton = driver.findElement(By.cssSelector(ADD_POINT_MESSAGE_OK_BUTTON_LOCATOR));
		errorMessage = addPointErrorMessage.getText().trim();
		clickAddPointMessageButton();
		return errorMessage;
	}

	/**
	 * Click Ok
	 */
	public void clickAddPointMessageButton() {
		addPointMessageOKButton.click();
	}

	/**
	 * Set coowners
	 * 
	 * @param coowner
	 */
	public void setSelectCoownersText(String coowner) {
		selectCoownerField.clear();
		selectCoownerField.sendKeys(coowner);
	}

	/**
	 * Set object name
	 * 
	 * @param object
	 */
	public void setObjectNameText(String object) {
		objectNameField.clear();
		objectNameField.sendKeys(object);
	}

	/**
	 * Check procuration
	 */
	public void checkProcurationCheckBox() {
		procurationsCheckBox.click();
	}

	/**
	 * Click Edit
	 */
	public void clickEditButton() {
		editButton.click();
	}

	/**
	 * Change registration number
	 * 
	 * @param regNumb
	 */
	public void changeRegNumber(String regNumb) {
		clickEditButton();
		registrNumbOfObjectField.clear();
		registrNumbOfObjectField.sendKeys(regNumb);
	}

	/**
	 * Click delete
	 */
	public void clickDeletePointButton() {
		deletePointButton.click();
	}

	/**
	 * initializing web elements on "Point" tab
	 */
	public void clickPointsTab() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		showOnMapButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SHOW_ON_MAP_BUTTON_LOCATOR)));
		latitudeDegreeField = driver.findElement(By.cssSelector(LATITUDE_DEGREE_FIELD_LOCATOR));
		latitudeMinuteField = driver.findElement(By.cssSelector(LATITUDE_MINUTE_FIELD_LOCATOR));
		latitudeSecondField = driver.findElement(By.cssSelector(LATITUDE_SECOND_FIELD_LOCATOR));
		longitudeDegreeField = driver.findElement(By.cssSelector(LONGITUDE_DEGREE_FIELD_LOCATOR));
		longitudeMinuteField = driver.findElement(By.cssSelector(LONGITUDE_MINUTE_FIELD_LOCATOR));
		longitudeSecondField = driver.findElement(By.cssSelector(LONGITUDE_SECOND_FIELD_LOCATOR));
		deletePointButton = driver.findElement(By.cssSelector(DELETE_POINT_BUTTON_LOCATOR));

		addPointButton = driver.findElement(By.id(ADD_POINT_BUTTON_LOCATOR));
		addTerritoryButton = driver.findElement(By.id(ADD_TERRITORY_BUTTON_LOCATOR));
		deleteAllPointsButton = driver.findElement(By.id(DELETE_ALL_POINTS_LOCATOR));
	}

	// Seting up coordinates
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

	/**
	 * Click show on map
	 * 
	 * @return add new resource page
	 */
	public AddNewResourcePage clickShowOnMapButton() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		showOnMapButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SHOW_ON_MAP_BUTTON_LOCATOR)));
		showOnMapButton.click();
		return new AddNewResourcePage(driver);
	}

	/**
	 * Click Add point
	 */
	public void clickAddPointButton() {
		addPointButton.click();
	}

	/**
	 * Click Add territory
	 */
	public void clickAddTerritotyButton() {
		addTerritoryButton.click();
	}

	/**
	 * Delete all points
	 */
	public void clickDeleteAllPointsButton() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		deleteAllPointsButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(DELETE_ALL_POINTS_LOCATOR)));
		deleteAllPointsButton.click();
	}

	/**
	 * Click Save
	 */
	public void clickSaveButton() {
		saveButton.click();
	}

	/**
	 * Save resource
	 * 
	 * @return add new resource page
	 */
	public AddNewResourcePage saveResource() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(SAVE_BUTTON_ID)));
		saveButton.click();
		return new AddNewResourcePage(driver);
	}

	/**
	 * Successfully save resource
	 * 
	 * @return resource detail page
	 */
	public ResourceDetailPage saveResourceSucces() {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(SAVE_BUTTON_ID)));
		saveButton.click();
		return new ResourceDetailPage(driver);
	}

	/**
	 * Switch to "Points" nav tab
	 * 
	 * @return add new resource page
	 */
	public AddNewResourcePage clickPointsNavTab() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		pointsNavTab = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(POINTS_NAV_TAB_LOCATOR)));
		pointsNavTab.click();
		return new AddNewResourcePage(driver);
	}

	/**
	 * Click clear fields button
	 */
	public void clickClearButton() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		clearButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CLEAR_FORM_BUTTON_ID)));
		clearButton.click();
	}

	// Constructors and getters/setters
	public AddNewResourcePage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		selectCoownerField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id(SELECT_COOWNER_INPUTFIELD_ID)));
		// selectCoownerField = driver.findElement(By.id(SELECT_COOWNER_INPUTFIELD_ID));
		objectNameField = driver.findElement(By.id(OBJECT_NAME_INPUTFIELD_ID));
		objectSubclassDropdown = driver.findElement(By.id(OBJECT_SUBCLASS_DROPDOWN_ID));
		registrNumbOfObjectField = driver.findElement(By.id(REGISTRNUMB_OBJ_ID));
		editButton = driver.findElement(By.id(EDIT_BUTTON_ID));
		reasonForInclusionTextArea = driver.findElement(By.id(REASON_FOR_INCLUSION_ID));
		procurationsCheckBox = driver.findElement(By.id(PROCURATIONS_CHECKBOX_ID));
		dataField = driver.findElement(By.id(DATE_ID));
		mapNavTab = driver.findElement(By.id(MAP_NAV_TAB_ID));
		pointsNavTab = driver.findElement(By.cssSelector(POINTS_NAV_TAB_LOCATOR));
		perimeterNavTab = driver.findElement(By.id(PERIMETER_NAV_TAB_ID));
		// zoomInButton = driver.findElement(By.className(ZOOM_IN_CLASS));
		// zoomOutButton = driver.findElement(By.className(ZOOM_OUT_CLASS));
		// closeButton = driver.findElement(By.id(CLOSE_BUTTON_LOCATOR));
		saveButton = driver.findElement(By.id(SAVE_BUTTON_ID));
		clearButton = driver.findElement(By.id(CLEAR_FORM_BUTTON_ID));
		// resourceActsUkrCheckBox = driver.findElement(By.id(RESORCE_ACTS_UKRAINE_ID));

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

	@Override
	public AddNewResourcePage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		return new AddNewResourcePage(driver);
	}

}
