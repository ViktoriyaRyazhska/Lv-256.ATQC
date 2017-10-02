package com.regres.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regres.testdata.NewSubclass;

public class AddNewSubclassPage {

	public WebDriver driver;
	public WebElement titleAddNewSubclass;
	public WebElement enterNameField;
	public WebElement buttonShowParameters;
	public WebElement buttonHideParameters;
	public WebElement buttonAddParameters;
	public WebElement buttonDelParameters;
	public WebElement parameterDescriptionField;
	public WebElement parameterDescriptionField1;
	public WebElement unitOfMeasurementField;
	public WebElement unitOfMeasurementField1;
	public WebElement saveButton;
	public WebElement clearButton;
	public WebElement dropdownButton;
	public WebElement optionLinearParameter;
	public WebElement optionDiscreteParameters;
	private WebElement errorMessage;

	String TITLE_ADD_NEW_SUBCLASS_XPATH = "//*[@id='body']/h2";
	String ENTER_NAME_FIELD_NAME = "typeName";
	String BUTTON_SHOW_PARAMETERS_ID = "clickmeshow";
	String BUTTON_HIDE_PARAMETERS_ID = "clickmehide";
	String BUTTON_ADD_PARAMETERS_ID = "btnAdd";
	String BUTTON_DEL_PARAMETERS_ID = "btnDel";
	String PARAMETER_DESCRIPTION_FIELD_NAME = "parameters[0].description";
	String PARAMETER_DESCRIPTION_FIELD1_NAME = "parameters[1].description";
	String UNIT_OF_MEASUREMENT_FIELD1_NAME = "parameters[1].unitName";
	String UNIT_OF_MEASUREMENT_FIELD_ID = "myparam1";
	String SAVE_BUTTON_XPATH = "//*[@type='submit']";
	String CLEAR_BUTTON_XPATH = "//*[@type='reset']";
	String DROPDOWN_BUTTON_XPATH = "//*[@id='myparam2']";
	String OPTION_BY_DEFAULT_XPATH = "";
	String OPTION_LINEAR_PARAMETER_XPATH = "//*[@id='myparam2']/option[2]";
	String OPTION_DISCRETE_PARAMETERS_XPATH = "//*[@id='myparam2']/option[3]";
	String ERROR_MESSAGE_XPATH = "//*[@id='typeName.errors']";

	public AddNewSubclassPage(WebDriver driver) {
		this.driver = driver;
		titleAddNewSubclass = driver.findElement(By.xpath(TITLE_ADD_NEW_SUBCLASS_XPATH));
		enterNameField = driver.findElement(By.name(ENTER_NAME_FIELD_NAME));
		buttonShowParameters = driver.findElement(By.id(BUTTON_SHOW_PARAMETERS_ID));
		buttonHideParameters = driver.findElement(By.id(BUTTON_HIDE_PARAMETERS_ID));
		buttonAddParameters = driver.findElement(By.id(BUTTON_ADD_PARAMETERS_ID));
		buttonDelParameters = driver.findElement(By.id(BUTTON_DEL_PARAMETERS_ID));
		parameterDescriptionField = driver.findElement(By.name(PARAMETER_DESCRIPTION_FIELD_NAME));
		unitOfMeasurementField = driver.findElement(By.id(UNIT_OF_MEASUREMENT_FIELD_ID));
		dropdownButton = driver.findElement(By.xpath(DROPDOWN_BUTTON_XPATH));
		optionLinearParameter = driver.findElement(By.xpath(OPTION_LINEAR_PARAMETER_XPATH));
		optionDiscreteParameters = driver.findElement(By.xpath(OPTION_DISCRETE_PARAMETERS_XPATH));
		//saveButton = driver.findElement(By.xpath(SAVE_BUTTON_XPATH));
	}

	// getData
	public WebElement gettitleAddNewSubclass() {
		return titleAddNewSubclass;
	}

	public String getTitleAddNewSubclass() {
		return gettitleAddNewSubclass().getText().trim();
	}

	public WebElement getEnterNameField() {
		return enterNameField;
	}

	public WebElement getButtonShowParameters() {
		return buttonShowParameters;
	}

	public WebElement getButtonHideParameters() {
		return buttonHideParameters;
	}

	public AddNewSubclassPage clickButtonHideParameters() {
		getButtonHideParameters().click();
		return new AddNewSubclassPage(driver);
	}

	public WebElement getButtonDelParameters() {
		return buttonDelParameters;
	}

	public AddNewSubclassPage clickButtonDelParameters() {
		getButtonDelParameters().click();
		return new AddNewSubclassPage(driver);
	}

	public WebElement getParameterDescriptionField() {
		return parameterDescriptionField;
	}

	public WebElement getParameterDescriptionField1() {
		parameterDescriptionField1 = driver.findElement(By.name(PARAMETER_DESCRIPTION_FIELD1_NAME));
		return parameterDescriptionField1;
	}

	public WebElement getUnitOfMeasurementField() {
		return unitOfMeasurementField;
	}

	public WebElement getUnitOfMeasurementField1() {
		unitOfMeasurementField1 = driver.findElement(By.name(UNIT_OF_MEASUREMENT_FIELD1_NAME));
		return unitOfMeasurementField1;
	}

	public WebElement getSaveButton() {
		saveButton = driver.findElement(By.xpath(SAVE_BUTTON_XPATH));
		return saveButton;
	}

	public SubclassesOfObjects clickSaveButton() {
		getSaveButton().click();
		// Return a new page object representing the destination
		return new SubclassesOfObjects(driver);
	}

	public WebElement getClearButton() {
		clearButton = driver.findElement(By.xpath(CLEAR_BUTTON_XPATH));
		return clearButton;
	}

	public WebElement getOptionLinearParameter() {
		return optionLinearParameter;
	}

	public WebElement getOptionDiscreteParameters() {
		return optionDiscreteParameters;
	}

	public void clickOptionDiscreteParameters() {
		getOptionDiscreteParameters().click();
	}

	public void clickOptionLinearParameter() {
		getOptionLinearParameter().click();
	}

	public WebElement getButtonAddParameters() {
		return buttonAddParameters;
	}

	public AddNewSubclassPage clickButtonAddParameters() {
		getButtonAddParameters().click();
		return new AddNewSubclassPage(driver);
	}

	public AddNewSubclassPage clickClearButton() {
		getClearButton().click();
		return new AddNewSubclassPage(driver);
	}

	public AddNewSubclassPage clickSaveButt() {
		getSaveButton().click();
		return new AddNewSubclassPage(driver);
	}

	public WebElement getDropdownButton() {
		return dropdownButton;
	}

	public void clickDropdownButton() {
		getDropdownButton().click();
	}

	public String getDropdownButtonText() {
		return dropdownButton.getText().trim();
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
		errorMessage = driver.findElement(By.xpath(ERROR_MESSAGE_XPATH));
		return errorMessage;
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

	public AddNewSubclassPage addedNewField(NewSubclass newSubclass) {
		inputParameterDescriptionClear1(newSubclass.getParameterDescription1());
		inputUnitOfMeasurementClear1(newSubclass.getUnitOfMeasurement1());
		return new AddNewSubclassPage(driver);
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
