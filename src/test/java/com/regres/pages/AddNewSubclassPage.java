package com.regres.pages;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regres.application.Application;
import com.regres.application.ApplicationSources;
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
	private Application application;
	private ApplicationSources applicationSourse;

	String TITLE_ADD_NEW_SUBCLASS_XPATH = "//*[@id='body']/h2";
	String ENTER_NAME_FIELD_NAME = "typeName";
	String BUTTON_SHOW_PARAMETERS_CSS_SELECTOR = "#clickmeshow";
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
	private static volatile AddNewSubclassPage instance = null;

	public static AddNewSubclassPage get(WebDriver driver) {
		if (instance == null) {
			synchronized (AddNewSubclassPage.class) {
				if (instance == null) {
					instance = new AddNewSubclassPage(driver);
				}
			}
		}
		return instance;
	}

	private AddNewSubclassPage(WebDriver driver) {
		super(driver);
	}

	// getters
	public WebElement gettitleAddNewSubclass() {
		titleAddNewSubclass = driver.findElement(By.xpath(TITLE_ADD_NEW_SUBCLASS_XPATH));
		return titleAddNewSubclass;
	}

	public String getTitleAddNewSubclass() {
		return gettitleAddNewSubclass().getText().trim();
	}

	public WebElement getEnterNameField() {
		enterNameField = driver.findElement(By.name(ENTER_NAME_FIELD_NAME));
		return enterNameField;
	}

	public WebElement getButtonShowParameters() {
		buttonShowParameters = driver.findElement(By.cssSelector(BUTTON_SHOW_PARAMETERS_CSS_SELECTOR));
		return buttonShowParameters;
	}

	public WebElement getButtonHideParameters() {
		buttonHideParameters = driver.findElement(By.id(BUTTON_HIDE_PARAMETERS_ID));
		return buttonHideParameters;
	}

	public boolean isEmptyWebElement(WebElement element) {
		boolean isEmpty = element.getAttribute("value").isEmpty();
		return isEmpty;
	}

	public WebElement getClearButton() {
		clearButton = driver.findElement(By.xpath(CLEAR_BUTTON_XPATH));
		return clearButton;
	}

	public WebElement getOptionLinearParameter() {
		optionLinearParameter = driver.findElement(By.xpath(OPTION_LINEAR_PARAMETER_XPATH));
		return optionLinearParameter;
	}

	public WebElement getOptionDiscreteParameters() {
		optionDiscreteParameters = driver.findElement(By.xpath(OPTION_DISCRETE_PARAMETERS_XPATH));
		return optionDiscreteParameters;
	}

	public WebElement getSaveButton() {
		saveButton = driver.findElement(By.xpath(SAVE_BUTTON_XPATH));
		return saveButton;
	}

	public WebElement getUnitOfMeasurementField() {
		unitOfMeasurementField = driver.findElement(By.id(UNIT_OF_MEASUREMENT_FIELD_ID));
		return unitOfMeasurementField;
	}

	public WebElement getButtonDelParameters() {
		buttonDelParameters = driver.findElement(By.id(BUTTON_DEL_PARAMETERS_ID));
		return buttonDelParameters;
	}

	public WebElement getParameterDescriptionField() {
		parameterDescriptionField = driver.findElement(By.name(PARAMETER_DESCRIPTION_FIELD_NAME));
		return parameterDescriptionField;
	}

	public WebElement getDropdownButton() {
		dropdownButton = driver.findElement(By.xpath(DROPDOWN_BUTTON_XPATH));
		return dropdownButton;
	}

	public void clickDropdownButton() {
		getDropdownButton().click();
	}

	public AddNewSubclassPage clickButtonHideParameters() {
		getButtonHideParameters().click();
		return AddNewSubclassPage.get(driver);
	}

	public AddNewSubclassPage clickButtonDelParameters() {
		getButtonDelParameters().click();
		return AddNewSubclassPage.get(driver);
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
		return SubclassesOfObjects.get(driver);
	}

	public void clickOptionDiscreteParameters() {
		getOptionDiscreteParameters().click();
	}

	public void clickOptionLinearParameter() {
		getOptionLinearParameter().click();
	}

	public WebElement getButtonAddParameters() {
		buttonAddParameters = driver.findElement(By.id(BUTTON_ADD_PARAMETERS_ID));
		return buttonAddParameters;
	}

	public String getValidationMessageText() {
		return getEnterNameField().getAttribute("validationMessage");
	}

	public AddNewSubclassPage clickButtonShowParameters() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(getButtonShowParameters()));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		getButtonShowParameters().click();
		return AddNewSubclassPage.get(driver);

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
		return AddNewSubclassPage.get(driver);
	}

	/**
	 * clicks on clear button
	 * 
	 * @return new AddNewSubclassPage
	 */
	public AddNewSubclassPage clickClearButton() {
		getClearButton().click();
		return AddNewSubclassPage.get(driver);
	}

	/**
	 * clicks on save button
	 * 
	 * @return new AddNewSubclassPage
	 */
	public AddNewSubclassPage clickSave() {
		getSaveButton().click();
		return AddNewSubclassPage.get(driver);
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

	public void addedNewField(NewSubclass newSubclass) {
		inputParameterDescriptionClear1(newSubclass.getParameterDescription1());
		inputUnitOfMeasurementClear1(newSubclass.getUnitOfMeasurement1());

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
		return AddNewSubclassPage.get(driver);
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
		return AddNewSubclassPage.get(driver);

	}

	/**
	 * Sets the language for the app
	 */
	@Override
	public AddNewSubclassPage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(getLocalizationDropdown()));
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return AddNewSubclassPage.get(driver);
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