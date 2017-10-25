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
import com.aventstack.extentreports.Status;
import com.regres.application.Application;
import com.regres.reports.Reports;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.dao.ResourceTypeDAO;
import com.regres.pages.AddNewSubclassPage;
import com.regres.pages.AddNewSubclassPage.AddNewSubclassPageL10n;
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.SubclassesOfObjects;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.NewSubclass;
import com.regres.testdata.NewSubclassDataContainer;
import com.regres.testdata.UserContainer;

/**
 * In this test verify that created by registrator subclass with valid and
 * invalid data stored in DB, verify validation error message and localization
 * verify validation error message and localization
 */

public class AddNewSubclassTest extends Reports {
	private LoginPage loginpage;
	private RegistratorHomePage registratorpage;
	private SubclassesOfObjects subclassesOfObjects;
	private AddNewSubclassPage addNewSublassPage;
	private Application app;
	private ResourceTypeDAO resourseTypeDao;
	private ExtentTest test;

	/**
	 * Opens browser and registrator page.
	 */
	@BeforeClass
	public void setUp() {
		test = report.createTest("AddNewSubclassTest");

		test.log(Status.INFO, "Opening browser.");
		app = Application.get(ApplicationSourcesRepo.getFirefoxLocalApplicationDB());

		test.log(Status.INFO, "Opening 'Login page'.");
		loginpage = app.load();

		test.log(Status.INFO, "Signing in as Registrator.");
		registratorpage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
		resourseTypeDao = new ResourceTypeDAO();
	}

	/**
	 * Getting test result and writing it to report
	 * 
	 * @param result
	 *            - object with test results
	 */

	@AfterMethod(alwaysRun = true)
	public void reportresults(ITestResult result) {
		getResult(result, test);
	}

	@AfterClass(alwaysRun = true)
	public void getREPORT() {
		report.flush();
	}

	/**
	 * Closes browser and connection with DB.
	 */

	@AfterClass
	public void set() throws ClassNotFoundException, SQLException {
		ApplicationSources.closeConnectionDB();
		test.log(Status.INFO, "Closed connection to DB.");

		app.quit();
		test.log(Status.INFO, "Closed browser.");

	}

	@BeforeMethod
	public void setData() {

		test.log(Status.INFO, "Opening 'Registrator page'.");
		registratorpage = loginpage.getRegistratorHomePage();

		test.log(Status.INFO, "Opening 'Subclasses of Objects page'.");
		subclassesOfObjects = registratorpage.clickSubclassesOfObjects();

		test.log(Status.INFO, "Opening 'Add new Subclass page'.");
		addNewSublassPage = subclassesOfObjects.clickAddNewSubclass();
	}

	/*
	 * This method verify that user can't create new subclass without entering the
	 * name of the subclass in the mandatory field
	 */
	@Test(dataProvider = "L10N")
	public void checkEmptyEnterNameField(ChangeLanguageFields language) {
		// click button show parameters
		addNewSublassPage.clickButtonShowParameters();
		test.log(Status.INFO, "Show parameters");
		// fill fields invalid data (leave the enter name field empty)
		addNewSublassPage.addedNewSubclass(NewSubclassDataContainer.getInvalidData());
		test.log(Status.INFO, "Settings invalid credential for name of subclass");
		// select option discrete parameters
		addNewSublassPage.selectOptionDiscreteParameters();
		test.log(Status.INFO, "Select option discrete parameter on dropdown menu.");

		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		test.log(Status.INFO, "Hide peremeters");

		addNewSublassPage = addNewSublassPage.clickSave();
		test.log(Status.INFO, "Save new subclass with invalid credential ");
		// verify validation error message
		Assert.assertEquals(addNewSublassPage.getValidationMessageText(),
				NewSubclassDataContainer.getAttributeValue().getNameClasses());
		test.log(Status.INFO, "Verify error massage");
		Assert.assertTrue(resourseTypeDao.hasEmptyField(NewSubclassDataContainer.getInvalidData().getNameClasses()));
		test.log(Status.PASS, "Verified that did not Save.");// Please fill out this field.

	}

	/*
	 * This method verify that created new subclass with valid data saved in List of
	 * Subclass table and DB
	 */
	@Test(dataProvider = "L10N")
	public void checkSuccessfulAddedSubclass(ChangeLanguageFields language) {
		// set language
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		test.log(Status.INFO, "Set language");

		List<NewSubclass> subclasses = NewSubclassDataContainer.getValidData();
		for (NewSubclass validSubclassNames : subclasses) {
			addNewSublassPage.clickButtonShowParameters();
			// fill field with valid data
			addNewSublassPage.addedNewSubclass(validSubclassNames);
			test.log(Status.INFO, "Settings valid credential for name of subclass");
			// select option linear parameters
			addNewSublassPage.selectOptionLinearParameter();
			test.log(Status.INFO, "Select option discrete parameter on dropdown menu.");
			addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
			subclassesOfObjects = addNewSublassPage.clickSaveButton();
			test.log(Status.INFO, "Save changes");
			// Verify that element NameSubclass is displayed in table
			Assert.assertTrue(subclassesOfObjects.getSubclassName(validSubclassNames).isDisplayed());
			test.log(Status.PASS, "Verify that element is displayed.");
			// Verify that the data that was saved in the table corresponds to the data that
			// was saved in the databases database
			Assert.assertEquals(subclassesOfObjects.getSubclassName(validSubclassNames).getText(),
					resourseTypeDao.getSubclassNameFromDb(validSubclassNames.getNameClasses()));
			test.log(Status.PASS, "Verify that the same data is saved in table and DB.");
			// delete test data
			subclassesOfObjects = subclassesOfObjects.clickOnDeleteSubclassButton(validSubclassNames);
			// verify that name of subclass delete from DB
			Assert.assertFalse(resourseTypeDao.hasSubclassNameInDb(validSubclassNames.getNameClasses()));
			test.log(Status.PASS, "Delete test data.");
			addNewSublassPage = subclassesOfObjects.clickAddNewSubclass();
			test.log(Status.PASS, "Verify that the test data is deleted in DB.");

		}

	}

	/*
	 * This test verify that user cann't create new subclass with existing name of
	 * subclass
	 */
	@Test(dataProvider = "L10N")
	public void checkAddedSubclassWithExistName(ChangeLanguageFields language) {
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		test.log(Status.INFO, "Set language");
		NewSubclass validData = NewSubclassDataContainer.getExistClassName();
		addNewSublassPage.clickButtonShowParameters();
		test.log(Status.INFO, "Show all parameters");
		// fill the field already existing in the database name
		addNewSublassPage.addedNewSubclass(validData);
		test.log(Status.INFO, "Settings invalid credential for name of subclass");
		// select linear parameter
		addNewSublassPage.selectOptionLinearParameter();
		test.log(Status.INFO, "Select option linear parameter on dropdown menu.");

		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		test.log(Status.INFO, "Hide parameters");

		addNewSublassPage = addNewSublassPage.clickSave();
		test.log(Status.INFO, "Save changes");
		// verify localization error message
		Assert.assertEquals(addNewSublassPage.getErrorMessage().getText(),
				AddNewSubclassPageL10n.ERROR_MESSAGE_WHEN_INVALID_DATA_ENTERED.getLocalization(language));
		test.log(Status.INFO, "Verify error message");
		// return to List of subclasses table
		subclassesOfObjects = addNewSublassPage.clickSubclassesOfObjects();
		test.log(Status.INFO, "Return to Subclasses of Object page ");
		// verify if the name of the existing class is unique in the table
		Assert.assertTrue(subclassesOfObjects.hasUniqueSubclassName(validData));
		test.log(Status.PASS, "Verified that did not Save in table.");
		// verify that there is no duplicate subclass with a unique name in the database
		Assert.assertFalse(resourseTypeDao.hasDuplicateSubclass(validData.getNameClasses()));
		test.log(Status.PASS, "Verified that did not Save in DB.");

	}

	/*
	 * This test verify that all fields are cleared and don't save in table and DB
	 * after the clear button is pressed
	 */
	@Test(dataProvider = "L10N")
	public void checkSuccessfulAddedSubclassClear(ChangeLanguageFields language) {
		// set language
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		test.log(Status.INFO, "Set language");
		NewSubclass validData = NewSubclassDataContainer.getValidDataClear();
		addNewSublassPage.clickButtonShowParameters();
		test.log(Status.INFO, "Show all parameters");
		// fill field with valid data
		addNewSublassPage.addedNewSubclass(validData);
		test.log(Status.INFO, "Settings valid credential for name of subclass");

		addNewSublassPage.selectOptionLinearParameter();
		test.log(Status.INFO, "Select option linear parameter on dropdown menu.");

		addNewSublassPage = addNewSublassPage.clickClearButton();
		test.log(Status.INFO, "Click in Clear button.");

		addNewSublassPage = addNewSublassPage.clickSave();
		test.log(Status.INFO, "Click on button Save.");
		// verify that all field is empty
		Assert.assertTrue(addNewSublassPage.isEmptyWebElement(addNewSublassPage.getEnterNameField()));
		test.log(Status.PASS, "Verify that name of subclass field is empty.");

		Assert.assertTrue(addNewSublassPage.isEmptyWebElement(addNewSublassPage.getUnitOfMeasurementField()));
		test.log(Status.PASS, "Verify that unit of measurement field is empty.");

		Assert.assertTrue(addNewSublassPage.isEmptyWebElement(addNewSublassPage.getParameterDescriptionField()));
		test.log(Status.PASS, "Verify that parameter description field is empty.");
		// check that the selected default value is in dropdown
		Assert.assertEquals(addNewSublassPage.getDropdownOptionByDefault().getText(),
				AddNewSubclassPageL10n.DROPDOWN_DEFAULT_VALUE.getLocalization(language));
		test.log(Status.PASS, "Verify that default value is selected in dropdown.");
		subclassesOfObjects = addNewSublassPage.clickSubclassesOfObjects();
		test.log(Status.PASS, "Return to Subclass of object page.");
		// verify that the data is not stored in the table
		Assert.assertTrue(subclassesOfObjects.hasNoneSubclassName(validData));
		test.log(Status.PASS, "Verified that did not Save in table.");
		// verify that the data is not stored in DB
		Assert.assertFalse(resourseTypeDao.hasSubclassNameInDb(validData.getNameClasses()));
		test.log(Status.PASS, "Verified that did not Save in DB.");
	}

	/*
	 * This test verify that user can create new subclass with additional
	 * parameters. Verify that entered parameters saved in table and DB
	 */
	@Test(dataProvider = "L10N")
	public void verifySubclassAddition(ChangeLanguageFields language) { // ChangeLanguageFields language
		// set language
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		test.log(Status.INFO, "Set language");
		// click button show parameters
		addNewSublassPage.clickButtonShowParameters();
		test.log(Status.INFO, "Click on show parameters button");
		NewSubclass validSubclass = NewSubclassDataContainer.getValidValue();
		// fill field with valid data
		addNewSublassPage.addedNewSubclass(validSubclass);
		test.log(Status.INFO, "Settings valid credential for new subclass fields");

		addNewSublassPage.selectOptionLinearParameter();
		test.log(Status.INFO, "Select option linear parameter on dropdown menu.");
		// add new parameters
		addNewSublassPage = addNewSublassPage.clickButtonAddParameters();

		// fill additional field with valid data
		addNewSublassPage.addedNewField(NewSubclassDataContainer.getAdditionalField());
		test.log(Status.INFO, "Settings valid credential for additional subclasses fields");
		addNewSublassPage.selectOptionDiscreteParameters();
		test.log(Status.INFO, "Select option discrete parameter parameter on dropdown menu.");
		addNewSublassPage = addNewSublassPage.clickButtonDelParameters();
		test.log(Status.INFO, "Click on delete parameter button.");
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		test.log(Status.INFO, "Click on hide parameter button.");
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
		test.log(Status.INFO, "Save changes.");
		// verify that element is displayed in table
		Assert.assertTrue(subclassesOfObjects.getSubclassName(validSubclass).isDisplayed());
		test.log(Status.PASS, "Verify that element is displayed.");
		// Verify that the data that was saved in the table corresponds to the data that
		// was saved in the databases database
		Assert.assertEquals(subclassesOfObjects.getSubclassName(validSubclass).getText(),
				resourseTypeDao.getSubclassNameFromDb(validSubclass.getNameClasses()));
		test.log(Status.PASS, "Verify that the same data is saved in table and DB.");

		subclassesOfObjects = subclassesOfObjects.clickOnDeleteSubclassButton(validSubclass);
		test.log(Status.PASS, "Delete test data.");

		Assert.assertFalse(resourseTypeDao.hasSubclassNameInDb(validSubclass.getNameClasses()));
		test.log(Status.PASS, "Verify that the test data is deleted in DB.");
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