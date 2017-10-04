package com.regres.pages;

import java.util.HashMap;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.regres.testdata.NewSubclass;

/**
 * Class representation of a Add New Subclass page.
 * 
 * @author Khrystyna Terletska
 */

public class AddNewSubclassPage extends RegistratorHomePage {

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
	private WebElement dropdownOptionByDefault;

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
	String DROPDOWN_OPTION_BY_DEFAULT_XPATH = "//*[@id='myparam2']/option[1]";
	String OPTION_LINEAR_PARAMETER_XPATH = "//*[@id='myparam2']/option[2]";
	String OPTION_DISCRETE_PARAMETERS_XPATH = "//*[@id='myparam2']/option[3]";
	String ERROR_MESSAGE_XPATH = "//*[@id='typeName.errors']";

	public AddNewSubclassPage(WebDriver driver) {
		super(driver);
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
		saveButton = driver.findElement(By.xpath(SAVE_BUTTON_XPATH));
		clearButton = driver.findElement(By.xpath(CLEAR_BUTTON_XPATH));
	}

	// getters
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

	public WebElement getClearButton() {
		return clearButton;
	}

	public WebElement getOptionLinearParameter() {
		return optionLinearParameter;
	}

	public WebElement getOptionDiscreteParameters() {
		return optionDiscreteParameters;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getUnitOfMeasurementField() {
		return unitOfMeasurementField;
	}

	public WebElement getButtonDelParameters() {
		return buttonDelParameters;
	}

	public WebElement getParameterDescriptionField() {
		return parameterDescriptionField;
	}

	public WebElement getDropdownButton() {
		return dropdownButton;
	}

	public void clickDropdownButton() {
		getDropdownButton().click();
	}

	public AddNewSubclassPage clickButtonHideParameters() {
		getButtonHideParameters().click();
		return new AddNewSubclassPage(driver);
	}

	public AddNewSubclassPage clickButtonDelParameters() {
		getButtonDelParameters().click();
		return new AddNewSubclassPage(driver);
	}

	public WebElement getParameterDescriptionField1() {
		parameterDescriptionField1 = driver.findElement(By.name(PARAMETER_DESCRIPTION_FIELD1_NAME));
		return parameterDescriptionField1;
	}

	public WebElement getUnitOfMeasurementField1() {
		unitOfMeasurementField1 = driver.findElement(By.name(UNIT_OF_MEASUREMENT_FIELD1_NAME));
		return unitOfMeasurementField1;
	}

	public SubclassesOfObjects clickSaveButton() {
		getSaveButton().click();
		// Return a new page object representing the destination
		return new SubclassesOfObjects(driver);
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

	public String getValidationMessageText() {
		return getEnterNameField().getAttribute("validationMessage");
	}

	public void clickButtonShowParameters() {
		getButtonShowParameters().click();
	}

	public void inputNameClass(String nameClass) {
		getEnterNameField().sendKeys(nameClass);
	}

	/**
	 * clicks on add parameters button
	 * 
	 * @return new AddNewSubclassPage
	 */

	public AddNewSubclassPage clickButtonAddParameters() {
		getButtonAddParameters().click();
		return new AddNewSubclassPage(driver);
	}

	/**
	 * clicks on clear button
	 * 
	 * @return new AddNewSubclassPage
	 */
	public AddNewSubclassPage clickClearButton() {
		getClearButton().click();
		return new AddNewSubclassPage(driver);
	}

	/**
	 * clicks on save button
	 * 
	 * @return new AddNewSubclassPage
	 */
	public AddNewSubclassPage clickSave() {
		getSaveButton().click();
		return new AddNewSubclassPage(driver);
	}

	/**
	 * Initializes DropdownOption field and returns it.
	 */
	public WebElement getDropdownOptionByDefault() {
		dropdownOptionByDefault = driver.findElement(By.xpath(DROPDOWN_OPTION_BY_DEFAULT_XPATH));
		return dropdownOptionByDefault;
	}

	/**
	 * Fills Unit Of Measurement field with given value
	 * 
	 * @param unitOfMeasurement
	 *            - value to be set.
	 */
	public void inputUnitOfMeasurement(String unitOfMeasurement) {
		getUnitOfMeasurementField().sendKeys(unitOfMeasurement);
	}

	public void inputUnitOfMeasurement1(String unitOfMeasurement1) {
		getUnitOfMeasurementField1().sendKeys(unitOfMeasurement1);
	}

	/**
	 * Fills Parameter Description field with given value
	 * 
	 * @param parameterDescription
	 *            - value to be set.
	 */
	public void inputParameterDescription(String parameterDescription) {
		getParameterDescriptionField().sendKeys(parameterDescription);
	}

	public void inputParameterDescription1(String parameterDescription1) {
		getParameterDescriptionField1().sendKeys(parameterDescription1);
	}

	/**
	 * Initializes errorMessage field and returns it.
	 */
	public WebElement getErrorMessage() {
		errorMessage = driver.findElement(By.xpath(ERROR_MESSAGE_XPATH));
		return errorMessage;
	}

	/**
	 * Clears enter name field and fills it with given value.
	 * 
	 * @param nameClass
	 *            - value to be set.
	 */
	public void inputNameClassClear(String nameClass) {
		getEnterNameField().clear();
		inputNameClass(nameClass);
	}

	/**
	 * Clears parameter description field and fills it with given value.
	 * 
	 * @param parameterDescription
	 *            - value to be set.
	 */

	public void inputParameterDescriptionClear(String parameterDescription) {

		getParameterDescriptionField().clear();
		inputParameterDescription(parameterDescription);
	}

	public void inputParameterDescriptionClear1(String parameterDescription1) {

		getParameterDescriptionField1().clear();
		inputParameterDescription1(parameterDescription1);
	}

	/**
	 * Clears unit of measurement field and fills it with given value.
	 * 
	 * @param unitOfMeasurement
	 *            - value to be set.
	 */
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

	/**
	 * Added New Subclass
	 * 
	 * @param newSubclass
	 *            - valid credentials .
	 */

	public void addedNewSubclass(NewSubclass newSubclass) {
		inputNameClassClear(newSubclass.getNameClasses());
		getButtonShowParameters().click();
		inputParameterDescriptionClear(newSubclass.getParameterDescription());
		inputUnitOfMeasurementClear(newSubclass.getUnitOfMeasurement());
	}

	/**
	 * Checks "Option Linear Parameters" dropdown. If it is already checked, does
	 * nothing.
	 * 
	 * @return new AddNewSubclassPage
	 */
	public AddNewSubclassPage selectOptionLinearParameter() {
		clickDropdownButton();
		if (!getOptionLinearParameter().isSelected()) {
			clickOptionLinearParameter();
		}
		return new AddNewSubclassPage(driver);
	}

	/**
	 * Checks "Option Discrete Parameters" dropdown. If it is already checked, does
	 * nothing.
	 * 
	 * @return new AddNewSubclassPage
	 */
	public AddNewSubclassPage selectOptionDiscreteParameters() {
		clickDropdownButton();
		if (!getOptionDiscreteParameters().isSelected()) {
			clickOptionDiscreteParameters();
		}
		return new AddNewSubclassPage(driver);

	}

	/**
	 * Sets the language for the app
	 */
	@Override
	public AddNewSubclassPage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new AddNewSubclassPage(driver);
	}

	/**
	 * Create enum for further localization testing.
	 */
	public static enum AddNewSubclassPageL10n {
		ERROR_MESSAGE_WHEN_INVALID_DATA_ENTERED("Підклас з вказаним іменем вже існує",
				"Подкласс с указаным наименованием уже существует",
				"The subclass with the specified name already exists"), DROPDOWN_DEFAULT_VALUE("Виберіть тип параметру",
						"Выберите тип параметра", "Choose type parameters");

		private HashMap<ChangeLanguageFields, String> field; // is different for every language

		private AddNewSubclassPageL10n(String... localization) {
			this.field = new HashMap<ChangeLanguageFields, String>();
			int i = 0;
			for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
				this.field.put(language, localization[i]);
				i++;
			}
		}

		public String getLocalization(ChangeLanguageFields language) {
			return this.field.get(language).trim();
		}
	}
}
