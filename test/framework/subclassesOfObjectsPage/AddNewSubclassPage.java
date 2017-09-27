package framework.subclassesOfObjectsPage;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import framework.pages.SubclassesOfObjects;
import framework.testdata.NewSubclass;

public class AddNewSubclassPage {
	// Fields
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

	public AddNewSubclassPage(WebDriver driver) {
		this.driver = driver;
		titleAddNewSubclass = driver.findElement(By.xpath("//*[@id='body']/h2"));
		enterNameField = driver.findElement(By.name("typeName"));
		buttonShowParameters = driver.findElement(By.id("clickmeshow"));
		buttonHideParameters = driver.findElement(By.id("clickmeshow"));
		buttonAddParameters = driver.findElement(By.id("btnAdd"));
		buttonDelParameters = driver.findElement(By.id("btnDel"));
		buttonDelParameters = driver.findElement(By.id("btnDel"));
		parameterDescriptionField = driver.findElement(By.name("parameters[0].description"));
		unitOfMeasurementField = driver.findElement(By.id("myparam1"));
		saveButton = driver.findElement(By.id("valid"));
		clearButton = driver.findElement(By.cssSelector("button.btn.btn-default"));
		dropdownButton = driver.findElement(By.xpath("//*[@id='myparam2']"));
		optionLinearParameter = driver.findElement(By.xpath("//*[@id='myparam2']/option[2]"));
		optionDiscreteParameters = driver.findElement(By.xpath("//*[@id='myparam2']/option[3]"));

	}

	public WebElement gettitleAddNewSubclass() {
		return titleAddNewSubclass;
	}

	public void settitleAddNewSubclass(WebElement titleAddNewSubclass) {
		this.titleAddNewSubclass = titleAddNewSubclass;
	}

	public String getTitleAddNewSubclass() {
		return titleAddNewSubclass.getText().trim();
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

	public WebElement getButtonDelParameters() {
		return buttonDelParameters;
	}

	public WebElement getParameterDescriptionField() {
		return parameterDescriptionField;
	}

	public WebElement getParameterDescriptionField1() {
		parameterDescriptionField1 = driver.findElement(By.name("parameters[1].description"));
		return parameterDescriptionField1;
	}

	public WebElement getUnitOfMeasurementField() {
		return unitOfMeasurementField;
	}

	public WebElement getUnitOfMeasurementField1() {
		unitOfMeasurementField1 = driver.findElement(By.name("parameters[1].unitName"));
		return unitOfMeasurementField1;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public SubclassesOfObjects clickSaveButton() {
		saveButton.click();
		return new SubclassesOfObjects(driver);
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

	public void clickOptionDiscreteParameters() {
		optionDiscreteParameters.click();
	}

	public void clickOptionLinearParameter() {
		optionLinearParameter.click();
	}

	public WebElement getButtonAddParameters() {
		return buttonAddParameters;
	}

	public AddNewSubclassPage clickButtonAddParameters() {
		buttonAddParameters.click();
		return new AddNewSubclassPage(driver);
	}

	public AddNewSubclassPage clickClearButton() {
		clearButton.click();
		return new AddNewSubclassPage(driver);
	}

	public AddNewSubclassPage clickSaveButt() {
		saveButton.click();
		return new AddNewSubclassPage(driver);
	}

	public WebElement getDropdownButton() {
		return dropdownButton;
	}

	public void clickDropdownButton() {
		dropdownButton.click();
	}

	public void clickButtonShowParameters() {
		buttonShowParameters.click();
	}

	public void inputNameClass(String nameClass) {
		enterNameField.sendKeys(nameClass);
	}

	public void inputUnitOfMeasurement(String unitOfMeasurement) {
		unitOfMeasurementField.sendKeys(unitOfMeasurement);
	}

	public void inputUnitOfMeasurement1(String unitOfMeasurement1) {
		unitOfMeasurementField1.sendKeys(unitOfMeasurement1);
	}

	public void inputParameterDescription(String parameterDescription) {
		parameterDescriptionField.sendKeys(parameterDescription);
	}

	public void inputParameterDescription1(String parameterDescription1) {
		parameterDescriptionField1.sendKeys(parameterDescription1);
	}

	public WebElement getErrorMessage() {
		errorMessage = driver.findElement(By.xpath("//*[@id='typeName.errors']"));
		return errorMessage;
	}

	public void inputNameClassClear(String nameClass) {

		enterNameField.clear();
		inputNameClass(nameClass);
	}

	public void inputParameterDescriptionClear(String parameterDescription) {

		parameterDescriptionField.clear();
		inputParameterDescription(parameterDescription);
	}

	public void inputParameterDescriptionClear1(String parameterDescription1) {

		parameterDescriptionField1.clear();
		inputParameterDescription1(parameterDescription1);
	}

	public void inputUnitOfMeasurementClear(String unitOfMeasurement) {

		unitOfMeasurementField.clear();
		inputUnitOfMeasurement(unitOfMeasurement);
	}

	public void inputUnitOfMeasurementClear1(String unitOfMeasurement1) {

		unitOfMeasurementField1.clear();
		inputUnitOfMeasurement1(unitOfMeasurement1);
	}

	public void addedNewField(NewSubclass newSubclass) {
		inputParameterDescriptionClear1(newSubclass.getParameterDescription1());
		inputUnitOfMeasurementClear1(newSubclass.getUnitOfMeasurement1());
	}

	public void addedNewSubclass(NewSubclass newSubclass) {
		inputNameClassClear(newSubclass.getnameClasses());
		buttonShowParameters.click();
		inputParameterDescriptionClear(newSubclass.getParameterDescription());
		inputUnitOfMeasurementClear(newSubclass.getUnitOfMeasurement());
	}

	public AddNewSubclassPage selectOptionLinearParameter() {
		clickDropdownButton();
		if (!optionLinearParameter.isSelected()) {
			clickOptionLinearParameter();
		}
		return new AddNewSubclassPage(driver);
	}

	public AddNewSubclassPage selectOptionDiscreteParameters() {
		clickDropdownButton();
		if (!optionDiscreteParameters.isSelected()) {
			clickOptionDiscreteParameters();
		}
		return new AddNewSubclassPage(driver);

	}
}