package com.regres.tests;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AddNewSubclassPage;
import com.regres.pages.AddNewSubclassPage.AddNewSubclassPageL10n;
import com.regres.pages.BaseFunctionalForDB;
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.SubclassesOfObjects;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.NewSubclassDataContainer;
import com.regres.testdata.UserContainer;

/**
 * In this test verify that created by registrator subclass with valid and 
 * invalid data stored in DB, verify validation error message and localization 
 * verify validation error message and localization 
 */ 

public class AddNewSubclassTest {
	private LoginPage loginpage;
	private RegistratorHomePage registratorpage;
	private SubclassesOfObjects subclassesOfObjects;
	private AddNewSubclassPage addNewSublassPage;
	private Application app;
	public Connection conn;
	public BaseFunctionalForDB baseFunctionalForDB;

	@BeforeClass
	public void setUp() throws ClassNotFoundException, SQLException {
		//Select browser
		app = Application.get(ApplicationSourcesRepo.getFirefoxLocalApplicationDB());
		//set connection with DB
		conn = ApplicationSources.createDBConnection();
		loginpage = app.load();
		// login as admin 
		registratorpage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
		baseFunctionalForDB = new BaseFunctionalForDB();
	}

	@AfterClass
	public void set() throws ClassNotFoundException, SQLException {
		//close connection with DB
		ApplicationSources.closeConnectionDB();
		//close browser
		app.quit();

	}

	@BeforeMethod
	public void setData() {
		registratorpage = loginpage.getRegistratorHomePage();
		//click on  SubclassesOfObjects on registrator navigation bar
		subclassesOfObjects = registratorpage.clickSubclassesOfObjects();
		//click on AddNewSubclass on Subclasses of Object page
		addNewSublassPage = subclassesOfObjects.clickAddNewSubclass();
	}
	
    //Method verify that user can't create new subclass with invalid data
	@Test(dataProvider = "L10N")
	public void checkEmptyEnterNameField(ChangeLanguageFields language) {
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		//click button show parameters
		addNewSublassPage.clickButtonShowParameters();
		//fill fields invalid data (leave the enter name field empty)
		addNewSublassPage.addedNewSubclass(NewSubclassDataContainer.setInvalidData());
		//select option discrete parameters
		addNewSublassPage.selectOptionDiscreteParameters();
		//click button hide parameters
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		//save modifications
		addNewSublassPage = addNewSublassPage.clickSave();
		//verify validation error message
		Assert.assertEquals(addNewSublassPage.getValidationMessageText(), "Please fill out this field."); 
	}
    //This method verify that created new subclass with valid data saved in List of Subclass table and DB 
	@Test(dataProvider = "L10N")
	public void checkSuccessfulAddedSubclass(ChangeLanguageFields language) throws SQLException {
		//set language
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		//click on button show parameter
		addNewSublassPage.clickButtonShowParameters();
		//fill field with valid data
		addNewSublassPage.addedNewSubclass(NewSubclassDataContainer.setValidData());
		//select option linear parameters
		addNewSublassPage.selectOptionLinearParameter();
		//click button hide parameters
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		//save modifications
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
		//new subclass created in List of subclass table 
		String actual = subclassesOfObjects.getSubclassName(NewSubclassDataContainer.setValidData()).getText();
		//expected that name of subclass created in DB
		String expected =baseFunctionalForDB.getSubclassNameFromDb(conn, "Sidney"); 
		//compare the actual and expected result
		Assert.assertEquals(actual, expected);
		//delete test data
		subclassesOfObjects = subclassesOfObjects.clickOnDeleteSubclassButton(NewSubclassDataContainer.setValidData());
		//verify that name of subclass delete from DB
		Assert.assertNotNull(baseFunctionalForDB.getSubclassNameFromDb(conn, ""));

	}
//This test verify that registrator can create subclass with existing name of subclass
	@Test(dataProvider = "L10N")
	public void checkAddedSubclassWithExistName(ChangeLanguageFields language) {
		//set language
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		//click button show parameters
		addNewSublassPage.clickButtonShowParameters();
		//fill the fields with the existing name
		addNewSublassPage.addedNewSubclass(NewSubclassDataContainer.setExistClassName());
		//select linear parameter
		addNewSublassPage.selectOptionLinearParameter();
		//click button hide parameters
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		//save modifications
		addNewSublassPage = addNewSublassPage.clickSave();
		//verify localization error message
		Assert.assertEquals(addNewSublassPage.getErrorMessage().getText(),
				AddNewSubclassPageL10n.ERROR_MESSAGE_WHEN_INVALID_DATA_ENTERED.getLocalization(language));
	}
//This test verify that all fields are cleared after the button is pressed
	@Test(dataProvider = "L10N")
	public void checkSuccessfulAddedSubclassClear(ChangeLanguageFields language) {
		//set language
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		//click button show parameters
		addNewSublassPage.clickButtonShowParameters();
		//fill field with valid data
		addNewSublassPage.addedNewSubclass(NewSubclassDataContainer.setValidDataClear());
		//select option linear parameter
		addNewSublassPage.selectOptionLinearParameter();
        //click clear button
		addNewSublassPage = addNewSublassPage.clickClearButton();
        //click save button
		addNewSublassPage = addNewSublassPage.clickSave();
		//verify that all field is empty
		Assert.assertTrue(addNewSublassPage.getEnterNameField().getText().isEmpty());
		Assert.assertTrue(addNewSublassPage.getUnitOfMeasurementField().getText().isEmpty());
		Assert.assertTrue(addNewSublassPage.getUnitOfMeasurementField().getText().isEmpty());
		//check that the selected default value is in dropdown
		Assert.assertEquals(addNewSublassPage.getDropdownOptionByDefault().getText(),
				AddNewSubclassPageL10n.DROPDOWN_DEFAULT_VALUE.getLocalization(language));
	}
  //This test verify that registrator can create new subclass with additional parameters
	@Test(dataProvider = "L10N")
	public void verifySubclassAddition(ChangeLanguageFields language) throws SQLException {
		//set language
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		//click button show parameters
		addNewSublassPage.clickButtonShowParameters();
		//fill field with valid data
		addNewSublassPage.addedNewSubclass(NewSubclassDataContainer.setValidValue());
		//select option linear parameters
		addNewSublassPage.selectOptionLinearParameter();
		//click button add parameters
		addNewSublassPage = addNewSublassPage.clickButtonAddParameters();
		//fill additional field with valid data
		addNewSublassPage = addNewSublassPage.addedNewField(NewSubclassDataContainer.setAdditionalField());
		//select option discrete parameters
		addNewSublassPage.selectOptionDiscreteParameters();
		//click delete additional parameters
		addNewSublassPage = addNewSublassPage.clickButtonDelParameters();
		//click hide parameters
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		//save modification
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
		Assert.assertTrue(subclassesOfObjects.getSubclassName(NewSubclassDataContainer.setValidValue()).isEnabled());
		Assert.assertTrue(subclassesOfObjects.getSubclassName(NewSubclassDataContainer.setValidValue()).getText()
				.contains("Ivano-Frankivsk"));
		//new subclass created in List of subclass table 
		String actual = subclassesOfObjects.getSubclassName(NewSubclassDataContainer.setValidValue()).getText();
		//expected that name of subclass created in DB
		String expected = baseFunctionalForDB.getSubclassNameFromDb(conn, "Ivano-Frankivsk");
		Assert.assertEquals(actual, expected);
		subclassesOfObjects = subclassesOfObjects.clickOnDeleteSubclassButton(NewSubclassDataContainer.setValidValue());
		Assert.assertNotNull(baseFunctionalForDB.getSubclassNameFromDb(conn, ""));
	}
	/**
	 * Languages to be tested.
	 */
	@DataProvider(name = "L10N")
	public static Object[] localizationProvider() {
		return new Object[][] { { ChangeLanguageFields.UKRAINIAN }, { ChangeLanguageFields.ENGLISH },
				{ ChangeLanguageFields.RUSSIAN } };
	}
}
