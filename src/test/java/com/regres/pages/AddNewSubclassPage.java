package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.regres.testdata.NewSubclass;

public class AddNewSubclassPage {

	public WebDriver driver;
	// Fields
	String TITLE_ADD_NEW_SUBCLASS_XPATH = "//*[@id='body']/h2";
	String ENTER_NAME_FIELD_NAME = "typeName";
	String BUTTON_SHOW_PARAMETERS_ID = "clickmeshow";
	String BUTTON_HIDE_PARAMETERS_ID = "clickmeshow";
	String BUTTON_ADD_PARAMETERS_ID = "btnAdd";
	String BUTTON_DEL_PARAMETERS_ID = "btnDel";
	String PARAMETER_DESCRIPTION_FIELD_NAME = "parameters[0].description";
	String UNIT_OF_MEASUREMENT_FIELD_ID = "myparam1";
	String SAVE_BUTTON_ID = "valid";
	String CLEAR_BUTTON_CSSSELECTOR = "button.btn.btn-default";
	String DROPDOWN_BUTTON_XPATH = "//*[@id='myparam2']";
	String OPTION_LINEAR_PARAMETER_XPATH = "//*[@id='myparam2']/option[2]";
	String OPTION_DISCRETE_PARAMETERS_XPATH = "//*[@id='myparam2']/option[3]";

	public AddNewSubclassPage(WebDriver driver) {
		this.driver = driver;
	}
    // getData
	public WebElement gettitleAddNewSubclass() {
		return driver.findElement(By.xpath(TITLE_ADD_NEW_SUBCLASS_XPATH));
	}

	public String getTitleAddNewSubclass() {
		return driver.findElement(By.xpath(TITLE_ADD_NEW_SUBCLASS_XPATH)).getText().trim();
	}

	public WebElement getEnterNameField() {
		return driver.findElement(By.name(ENTER_NAME_FIELD_NAME));
	}

	public WebElement getButtonShowParameters() {
		return driver.findElement(By.id(BUTTON_SHOW_PARAMETERS_ID));
	}

	public WebElement getButtonHideParameters() {
		return driver.findElement(By.id(BUTTON_HIDE_PARAMETERS_ID));
	}

	public WebElement getButtonDelParameters() {
		return driver.findElement(By.id(BUTTON_DEL_PARAMETERS_ID));
	}

	public WebElement getParameterDescriptionField() {
		return driver.findElement(By.name(PARAMETER_DESCRIPTION_FIELD_NAME));
	}

	public WebElement getParameterDescriptionField1() {
		String PARAMETER_DESCRIPTION_FIELD1_NAME = "parameters[1].description";
		return driver.findElement(By.name(PARAMETER_DESCRIPTION_FIELD1_NAME));
	}

	public WebElement getUnitOfMeasurementField() {
		return driver.findElement(By.id(UNIT_OF_MEASUREMENT_FIELD_ID));
	}

	public WebElement getUnitOfMeasurementField1() {
		String UNIT_OF_MEASUREMENT_FIELD1_NAME = "parameters[1].unitName";
		return driver.findElement(By.name(UNIT_OF_MEASUREMENT_FIELD1_NAME));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id(SAVE_BUTTON_ID));
	}
    
	public SubclassesOfObjects clickSaveButton() {
		getSaveButton().click();
		// Return a new page object representing the destination
		return new SubclassesOfObjects(driver);
	}

	public WebElement getClearButton() {
		return driver.findElement(By.cssSelector(CLEAR_BUTTON_CSSSELECTOR));
	}

	public WebElement getOptionLinearParameter() {
		return driver.findElement(By.xpath(OPTION_LINEAR_PARAMETER_XPATH));
	}

	public WebElement getOptionDiscreteParameters() {
		return driver.findElement(By.xpath(OPTION_DISCRETE_PARAMETERS_XPATH));
	}

	public void clickOptionDiscreteParameters() {
		getOptionDiscreteParameters().click();
	}

	public void clickOptionLinearParameter() {
		getOptionLinearParameter().click();
	}

	public WebElement getButtonAddParameters() {
		return driver.findElement(By.id(BUTTON_ADD_PARAMETERS_ID));
	}

	public AddNewSubclassPage clickButtonAddParameters() {
		getButtonAddParameters().click();
		return new AddNewSubclassPage(driver);
	}

	public AddNewSubclassPage clickClearButton() {
		getSaveButton().click();
		return new AddNewSubclassPage(driver);
	}

	public AddNewSubclassPage clickSaveButt() {
		getSaveButton().click();
		return new AddNewSubclassPage(driver);
	}

	public WebElement getDropdownButton() {
		return driver.findElement(By.xpath(DROPDOWN_BUTTON_XPATH));
	}

	public void clickDropdownButton() {
		getDropdownButton().click();
	}

	public void clickButtonShowParameters() {
		getButtonShowParameters().click();
	}

	public void inputNameClass(String nameClass) {
		getEnterNameField().sendKeys(nameClass);
	}

	public void inputUnitOfMeasurement(String unitOfMeasurement) {
		getUnitOfMeasurementField().sendKeys(unitOfMeasurement);
	}

	public void inputUnitOfMeasurement1(String unitOfMeasurement1) {
		getUnitOfMeasurementField1().sendKeys(unitOfMeasurement1);
	}

	public void inputParameterDescription(String parameterDescription) {
		getParameterDescriptionField().sendKeys(parameterDescription);
	}

	public void inputParameterDescription1(String parameterDescription1) {
		getParameterDescriptionField1().sendKeys(parameterDescription1);
	}

	public WebElement getErrorMessage() {
		String ERROR_MESSAGE_XPATH = "//*[@id='typeName.errors']";
		return driver.findElement(By.xpath(ERROR_MESSAGE_XPATH));
	}

	public void inputNameClassClear(String nameClass) {

		getEnterNameField().clear();
		inputNameClass(nameClass);
	}

	public void inputParameterDescriptionClear(String parameterDescription) {

		getParameterDescriptionField().clear();
		inputParameterDescription(parameterDescription);
	}

	public void inputParameterDescriptionClear1(String parameterDescription1) {

		getParameterDescriptionField1().clear();
		inputParameterDescription1(parameterDescription1);
	}

	public void inputUnitOfMeasurementClear(String unitOfMeasurement) {

		getUnitOfMeasurementField().clear();
		inputUnitOfMeasurement(unitOfMeasurement);
	}

	public void inputUnitOfMeasurementClear1(String unitOfMeasurement1) {

		getUnitOfMeasurementField1().clear();
		inputUnitOfMeasurement1(unitOfMeasurement1);
	}

	public void addedNewField(NewSubclass newSubclass) {
		inputParameterDescriptionClear1(newSubclass.getParameterDescription1());
		inputUnitOfMeasurementClear1(newSubclass.getUnitOfMeasurement1());
	}

	public void addedNewSubclass(NewSubclass newSubclass) {
		inputNameClassClear(newSubclass.getnameClasses());
		getButtonShowParameters().click();
		inputParameterDescriptionClear(newSubclass.getParameterDescription());
		inputUnitOfMeasurementClear(newSubclass.getUnitOfMeasurement());
	}

	public AddNewSubclassPage selectOptionLinearParameter() {
		clickDropdownButton();
		if (!getOptionLinearParameter().isSelected()) {
			clickOptionLinearParameter();
		}
		return new AddNewSubclassPage(driver);
	}

	public AddNewSubclassPage selectOptionDiscreteParameters() {
		clickDropdownButton();
		if (!getOptionDiscreteParameters().isSelected()) {
			clickOptionDiscreteParameters();
		}
		return new AddNewSubclassPage(driver);

	}
}
