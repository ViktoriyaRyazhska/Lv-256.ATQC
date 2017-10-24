package com.regres.tests;

import java.sql.SQLException;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.dao.ResourceTypeDAO;
import com.regres.pages.AddNewSubclassPage;
import com.regres.pages.AddNewSubclassPage.AddNewSubclassPageL10n;
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.SubclassesOfObjects;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.reports.Reports;
import com.regres.testdata.NewSubclass;
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
	SubclassesOfObjects subclassesOfObjects;
	AddNewSubclassPage addNewSublassPage;
	private Application app;
	private ResourceTypeDAO resourseTypeDao;

	@BeforeClass
	public void setUp() {
		// Select browser
		app = Application.get(ApplicationSourcesRepo.getFirefoxLocalApplicationDB());
		loginpage = app.load();
		// login as admin
		registratorpage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
		resourseTypeDao = new ResourceTypeDAO();
	}

	@AfterClass
	public void set() throws ClassNotFoundException, SQLException {
		// close connection with DB
		ApplicationSources.closeConnectionDB();
		// close browser
		app.quit();

	}

	@BeforeMethod
	public void setData() {
		registratorpage = loginpage.getRegistratorHomePage();
		// click on SubclassesOfObjects on registrator navigation bar
		subclassesOfObjects = registratorpage.clickSubclassesOfObjects();
		// click on AddNewSubclass on Subclasses of Object page
		addNewSublassPage = subclassesOfObjects.clickAddNewSubclass();
	}

	// Method verify that user can't create new subclass with invalid data
	@Test(dataProvider = "L10N")
	public void checkEmptyEnterNameField(ChangeLanguageFields language) {
		// click button show parameters
		addNewSublassPage.clickButtonShowParameters();
		// fill fields invalid data (leave the enter name field empty)
		addNewSublassPage.addedNewSubclass(NewSubclassDataContainer.getInvalidData());
		// select option discrete parameters
		addNewSublassPage.selectOptionDiscreteParameters();
		// click button hide parameters
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		addNewSublassPage = addNewSublassPage.clickSave();
		// verify validation error message
		Assert.assertEquals(addNewSublassPage.getValidationMessageText(),
				NewSubclassDataContainer.getAttributeValue().getNameClasses()); // Please fill out this field.
	}

	/*
	 * This method verify that created new subclass with valid data saved in List of
	 * Subclass table and DB
	 */
	@Test(dataProvider = "L10N")
	public void checkSuccessfulAddedSubclass(ChangeLanguageFields language) {
		// set language
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		List<NewSubclass> subclasses = NewSubclassDataContainer.getValidData();
		for (NewSubclass validSubclassNames : subclasses) {
			// click on button show parameter
			addNewSublassPage.clickButtonShowParameters();
			// fill field with valid data
			addNewSublassPage.addedNewSubclass(validSubclassNames);
			// select option linear parameters
			addNewSublassPage.selectOptionLinearParameter();
			// click button hide parameters
			addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
			// save modifications
			subclassesOfObjects = addNewSublassPage.clickSaveButton();
			// Verify that element is present in table
			// Assert.assertTrue(subclassesOfObjects.getSubclassName(validSubclass).isDisplayed());
			// actual text of subclass
			Assert.assertEquals(subclassesOfObjects.getSubclassName(validSubclassNames).getText(),
					resourseTypeDao.getSubclassNameFromDb(validSubclassNames.getNameClasses()));
			// String actual = subclassesOfObjects.getSubclassName(validSubclass).getText();
			// expected that name of subclass created in DB
			// String expected =
			// baseFunctionalForDB.getSubclassNameFromDb(validSubclass.getNameClasses());
			// compare the actual and expected result
			// Assert.assertEquals(actual, expected);
			// delete test data
			subclassesOfObjects = subclassesOfObjects.clickOnDeleteSubclassButton(validSubclassNames);
			// verify that name of subclass delete from DB
			Assert.assertFalse(resourseTypeDao.hasSubclassNameInDb(validSubclassNames.getNameClasses()));
			addNewSublassPage = subclassesOfObjects.clickAddNewSubclass();

		}

	}

	// This test verify that registrator can create subclass with existing name of
	// subclass
	@Test(dataProvider = "L10N")
	public void checkAddedSubclassWithExistName(ChangeLanguageFields language) {
		// set language
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		// click button show parameters
		NewSubclass validData = NewSubclassDataContainer.getExistClassName();
		addNewSublassPage.clickButtonShowParameters();
		// fill the fields with the existing name
		addNewSublassPage.addedNewSubclass(validData);
		// select linear parameter
		addNewSublassPage.selectOptionLinearParameter();
		// click button hide parameters
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		// save modifications
		addNewSublassPage = addNewSublassPage.clickSave();
		// verify localization error message
		Assert.assertEquals(addNewSublassPage.getErrorMessage().getText(),
				AddNewSubclassPageL10n.ERROR_MESSAGE_WHEN_INVALID_DATA_ENTERED.getLocalization(language));
		subclassesOfObjects = addNewSublassPage.clickSubclassesOfObjects();
		Assert.assertTrue(subclassesOfObjects.hasUniqueSubclassName(validData));
		Assert.assertFalse(resourseTypeDao.hasDuplicateSubclass(validData.getNameClasses()));

	}

	// // This test verify that all fields are cleared after the button is pressed
	@Test(dataProvider = "L10N")
	public void checkSuccessfulAddedSubclassClear(ChangeLanguageFields language) {
		// set language
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		NewSubclass validData = NewSubclassDataContainer.getValidDataClear();

		addNewSublassPage.clickButtonShowParameters();
		// fill field with valid data
		addNewSublassPage.addedNewSubclass(validData);
		// select option linear parameter
		addNewSublassPage.selectOptionLinearParameter();
		// click clear button
		addNewSublassPage = addNewSublassPage.clickClearButton();
		// click save button
		addNewSublassPage = addNewSublassPage.clickSave();
		// verify that all field is empty
		Assert.assertTrue(addNewSublassPage.isEmptyWebElement(addNewSublassPage.getEnterNameField()));
		Assert.assertTrue(addNewSublassPage.isEmptyWebElement(addNewSublassPage.getUnitOfMeasurementField()));
		Assert.assertTrue(addNewSublassPage.isEmptyWebElement(addNewSublassPage.getParameterDescriptionField()));
		// check that the selected default value is in dropdown
		Assert.assertEquals(addNewSublassPage.getDropdownOptionByDefault().getText(),
				AddNewSubclassPageL10n.DROPDOWN_DEFAULT_VALUE.getLocalization(language));
		subclassesOfObjects = addNewSublassPage.clickSubclassesOfObjects();
		Assert.assertTrue(subclassesOfObjects.hasNoneSubclassName(validData));
		Assert.assertFalse(resourseTypeDao.hasSubclassNameInDb(validData.getNameClasses()));
	}

	// This test verify that registrator can create new subclass with additional
	// parameters
	@Test(dataProvider = "L10N")
	public void verifySubclassAddition(ChangeLanguageFields language) {
		// set language
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		// click button show parameters
		addNewSublassPage.clickButtonShowParameters();

		NewSubclass validSubclass = NewSubclassDataContainer.getValidValue();
		// fill field with valid data
		addNewSublassPage.addedNewSubclass(validSubclass);
		// select option linear parameters
		addNewSublassPage.selectOptionLinearParameter();
		// click button add parameters
		addNewSublassPage = addNewSublassPage.clickButtonAddParameters();
		// fill additional field with valid data
		addNewSublassPage.addedNewField(NewSubclassDataContainer.getAdditionalField());
		// select option discrete parameters
		addNewSublassPage.selectOptionDiscreteParameters();
		// click delete additional parameters
		addNewSublassPage = addNewSublassPage.clickButtonDelParameters();
		// click hide parameters
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		// save modification
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
		//
		Assert.assertTrue(subclassesOfObjects.getSubclassName(validSubclass).isDisplayed());
		// new subclass created in List of subclass table
		// String actual =
		subclassesOfObjects.getSubclassName(validSubclass).getText();
		// expected that name of subclass created in DB
		// String expected =
		// baseFunctionalForDB.getSubclassNameFromDb(validSubclass.getNameClasses());
		Assert.assertEquals(subclassesOfObjects.getSubclassName(validSubclass).getText(),
				resourseTypeDao.getSubclassNameFromDb(validSubclass.getNameClasses()));
		subclassesOfObjects = subclassesOfObjects.clickOnDeleteSubclassButton(validSubclass);
		Assert.assertFalse(resourseTypeDao.hasSubclassNameInDb(validSubclass.getNameClasses()));
	}

	/**
	 * // * Languages to be tested. //
	 */
	@DataProvider(name = "L10N")
	public static Object[] localizationProvider() {
		return new Object[][] { { ChangeLanguageFields.UKRAINIAN }, { ChangeLanguageFields.ENGLISH },
				{ ChangeLanguageFields.RUSSIAN } };
	}
}