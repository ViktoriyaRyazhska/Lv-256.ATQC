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
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.SubclassesOfObjects;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.ValueDB;
import com.regres.testdata.NewSubclassDataContainer;
import com.regres.testdata.UserContainer;

public class AddNewSubclassTest {
	private LoginPage loginpage;
	private RegistratorHomePage registratorpage;
	private SubclassesOfObjects subclassesOfObjects;
	private AddNewSubclassPage addNewSublassPage;
	private Application app;
	public Connection conn;
	public ValueDB valueDB;

	@BeforeClass
	public void setUp() throws ClassNotFoundException, SQLException {
		app = Application.get(ApplicationSourcesRepo.getFirefoxLocalApplicationDB());
		conn = ApplicationSources.createDBConnection();
		loginpage = app.load();
		registratorpage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
		valueDB = new ValueDB();
	}

	@AfterClass
	public void set() throws ClassNotFoundException, SQLException {
		ApplicationSources.closeConnectionDB();
		app.quit();

	}

	@BeforeMethod
	public void setData() {
		registratorpage = loginpage.getRegistratorHomePage();
		subclassesOfObjects = registratorpage.clickSubclassesOfObjects();
		addNewSublassPage = subclassesOfObjects.clickAddNewSubclass();
	}

	@Test(dataProvider = "L10N")
	public void checkEmptyEnterNameField(ChangeLanguageFields language) {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassDataContainer.setInvalidData());
		addNewSublassPage.selectOptionDiscreteParameters();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		addNewSublassPage = addNewSublassPage.clickSaveButt();
		Assert.assertEquals(addNewSublassPage.getValidationMessageText(), "Заповніть будь ласка це поле."); // "Please
																											// fill out
																											// this
																											// field."

	}

	@Test(dataProvider = "L10N")
	public void checkSuccessfulAddedSubclass(ChangeLanguageFields language) throws SQLException {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassDataContainer.setValidData());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
		String actual = valueDB.getSubclassNameFromDb(conn, "Sidney");
		String expected = subclassesOfObjects.getSubclassName(NewSubclassDataContainer.setValidData()).getText();
		Assert.assertEquals(actual, expected);
		subclassesOfObjects = subclassesOfObjects.clickOnDeleteSubclassButton(NewSubclassDataContainer.setValidData());
		Assert.assertNotNull(valueDB.getSubclassNameFromDb(conn, ""));

	}

	@Test(dataProvider = "L10N")
	public void checkAddedSubclassWithExistName(ChangeLanguageFields language) {
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassDataContainer.setExistClassName());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		addNewSublassPage = addNewSublassPage.clickSaveButt();
		Assert.assertEquals(addNewSublassPage.getErrorMessage().getText(),
				AddNewSubclassPageL10n.ERROR_MESSAGE_WHEN_INVALID_DATA_ENTERED.getLocalization(language));
	}

	@Test(dataProvider = "L10N")
	public void checkSuccessfulAddedSubclassClear(ChangeLanguageFields language) {
		addNewSublassPage = addNewSublassPage.setLanguage(language);
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassDataContainer.setValidDataClear());
		addNewSublassPage.selectOptionLinearParameter();

		addNewSublassPage = addNewSublassPage.clickClearButton();

		addNewSublassPage = addNewSublassPage.clickSaveButt();
		Assert.assertTrue(addNewSublassPage.getEnterNameField().getText().isEmpty());
		Assert.assertTrue(addNewSublassPage.getUnitOfMeasurementField().getText().isEmpty());
		Assert.assertTrue(addNewSublassPage.getUnitOfMeasurementField().getText().isEmpty());
		Assert.assertEquals(addNewSublassPage.getDropdownOptionByDefault().getText(),
				AddNewSubclassPageL10n.DROPDOWN_DEFAULT_VALUE.getLocalization(language));
	}

	@Test(dataProvider = "L10N")
	public void verifySubclassAddition(ChangeLanguageFields language) throws SQLException {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassDataContainer.setValidValue());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage = addNewSublassPage.clickButtonAddParameters();
		addNewSublassPage = addNewSublassPage.addedNewField(NewSubclassDataContainer.setAdditionalField());
		addNewSublassPage.selectOptionDiscreteParameters();
		addNewSublassPage = addNewSublassPage.clickButtonDelParameters();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
		Assert.assertTrue(subclassesOfObjects.getSubclassName(NewSubclassDataContainer.setValidValue()).isEnabled());
		Assert.assertTrue(subclassesOfObjects.getSubclassName(NewSubclassDataContainer.setValidValue()).getText()
				.contains("Ivano-Frankivsk"));
		String actual = valueDB.getSubclassNameFromDb(conn, "Ivano-Frankivsk");
		String expected = subclassesOfObjects.getSubclassName(NewSubclassDataContainer.setValidValue()).getText();
		Assert.assertEquals(actual, expected);
		subclassesOfObjects = subclassesOfObjects.clickOnDeleteSubclassButton(NewSubclassDataContainer.setValidValue());
		Assert.assertNotNull(valueDB.getSubclassNameFromDb(conn, ""));
	}

	@DataProvider(name = "L10N")
	public static Object[] localizationProvider() {
		return new Object[][] { { ChangeLanguageFields.UKRAINIAN }, { ChangeLanguageFields.ENGLISH },
				{ ChangeLanguageFields.RUSSIAN } };
	}
}
