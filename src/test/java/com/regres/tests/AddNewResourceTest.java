package com.regres.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AddNewResourcePage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.AddNewResourceLocalization;
import com.regres.testdata.User;
import com.regres.testdata.UserContainer;

public class AddNewResourceTest {
	private AddNewResourceLocalization localization;
	private Application app;
	private User user = UserContainer.getRegistrator();
	private LoginPage loginpage;
	private RegistratorHomePage registratorHomePage;
	private AddNewResourcePage addNewResourcePage;

	@BeforeClass
	public void setUp() {
		// setting up parameters
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		// getting on login page
		loginpage = app.load();
		// loging in as Registrator and redirecting for changePassword page
		registratorHomePage = loginpage.successfullLoginRegistrator(user);
		addNewResourcePage = registratorHomePage.clickAddNewResourceNavTab();

	}

	@AfterClass
	public void tearDown() {
		addNewResourcePage.clickLogout();
		app.quit();
	}

	@Test(dataProvider = "AddPoint")
	public void checkAddPointErrorMessage(ChangeLanguageFields language, AddNewResourceLocalization localization) {
		addNewResourcePage = addNewResourcePage.setLanguage(language);
		assertEquals(localization.getMessage(), addNewResourcePage.getAddPointMessageText());
	}

	@Test(dataProvider = "AddFirstPoint")
	public void checkAddFirstPointErrorMessage(ChangeLanguageFields language, AddNewResourceLocalization localization) {
		addNewResourcePage = addNewResourcePage.setLanguage(language);
		assertEquals(localization.getMessage(), addNewResourcePage.getAddFirstPointMessageText());
	}

	@Test(dataProvider = "AddThreePoint")
	public void checkAddThreePointsMessageText(ChangeLanguageFields language, AddNewResourceLocalization localization) {
		addNewResourcePage = addNewResourcePage.setLanguage(language);
		assertEquals(localization.getMessage(), addNewResourcePage.getAddThreePointsMessageText());
	}
	
	@Test(dataProvider = "DeletePoint")
	public void checkDeletePointMessageText(ChangeLanguageFields language, AddNewResourceLocalization localization) {
		addNewResourcePage = addNewResourcePage.setLanguage(language);
		assertEquals(localization.getMessage(), addNewResourcePage.getAddThreePointsMessageText());
	}
	
	@DataProvider(name = "DeletePoint")
	public Object[] deletePoint() {

		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, localization.UA_DELETE_POINT },
				{ ChangeLanguageFields.ENGLISH, localization.EN_DELETE_POINT },
				{ ChangeLanguageFields.RUSSIAN, localization.RU_DELETE_POINT } };

	}
	

	@DataProvider(name = "AddFirstPoint")
	public Object[] addFirstPoint() {

		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, localization.UA_ADD_POINT },
				{ ChangeLanguageFields.ENGLISH, localization.EN_ADD_POINT },
				{ ChangeLanguageFields.RUSSIAN, localization.RU_ADD_POINT } };

	}

	@DataProvider(name = "AddPoint")
	public Object[] addPoint() {

		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, localization.UA_SAVE },
				{ ChangeLanguageFields.ENGLISH, localization.EN_SAVE },
				{ ChangeLanguageFields.RUSSIAN, localization.RU_SAVE } };

	}

	@DataProvider(name = "AddThreePoint")
	public Object[] addThreePoint() {

		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, localization.UA_THREE_POINTS },
				{ ChangeLanguageFields.ENGLISH, localization.EN_THREE_POINTS },
				{ ChangeLanguageFields.RUSSIAN, localization.RU_THREE_POINTS } };

	}

}
