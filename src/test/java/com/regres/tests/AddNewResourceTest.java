package com.regres.tests;


import org.testng.Assert;
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
		// loging in as Registrator and redirecting for addNewResourcePage
		registratorHomePage = loginpage.successfullLoginRegistrator(user);
		addNewResourcePage = registratorHomePage.clickAddNewResourceNavTab();

	}

	@AfterClass
	public void tearDown() {
		//logging out and exit
		addNewResourcePage.clickLogout();
		app.quit();
	}

	 @Test(dataProvider = "AddPoint")
	public void checkAddPointErrorMessage(ChangeLanguageFields language, AddNewResourceLocalization localization) {
		 //switching localization
		addNewResourcePage = addNewResourcePage.setLanguage(language);
		//switching to "Points" tab
		addNewResourcePage = addNewResourcePage.clickPointsNavTab();
		addNewResourcePage.clickPointsTab();
		//saving resource
		addNewResourcePage.clickSaveButton();
		//asserting error message
		addNewResourcePage.getErrorMessage();
		Assert.assertEquals(addNewResourcePage.getErrorMessageText(), localization.getMessage());
		addNewResourcePage.clickAddPointMessageButton();
	}

	 @Test(dataProvider = "AddFirstPoint")
	public void checkAddFirstPointErrorMessage(ChangeLanguageFields language, AddNewResourceLocalization localization) {
		//switching localization
		 addNewResourcePage = addNewResourcePage.setLanguage(language);
		//switching to "Points" tab
		 addNewResourcePage = addNewResourcePage.clickPointsNavTab();
		addNewResourcePage.clickPointsTab();
		//adding point
		addNewResourcePage.clickAddPointButton();
		//asserting error message
		addNewResourcePage.getErrorMessage();
		Assert.assertEquals(addNewResourcePage.getErrorMessageText(), localization.getMessage());
		addNewResourcePage.clickAddPointMessageButton();
	}

	@Test(dataProvider = "AddThreePoint")
	public void checkAddThreePointsMessageText(ChangeLanguageFields language, AddNewResourceLocalization localization) {
		//switching localization
		addNewResourcePage = addNewResourcePage.setLanguage(language);
		//switching to "Points" tab
		addNewResourcePage = addNewResourcePage.clickPointsNavTab();
		addNewResourcePage.clickPointsTab();
		//adding territory
		addNewResourcePage.clickAddTerritotyButton();
		//asserting error message
		addNewResourcePage.getErrorMessage();
		Assert.assertEquals(addNewResourcePage.getErrorMessageText(), localization.getMessage());
		addNewResourcePage.clickAddPointMessageButton();
	}

	 @Test(dataProvider = "DeletePoint")
	public void checkDeletePointMessageText(ChangeLanguageFields language, AddNewResourceLocalization localization) {
		//switching localization
		 addNewResourcePage = addNewResourcePage.setLanguage(language);
		//switching to "Points" tab
		addNewResourcePage = addNewResourcePage.clickPointsNavTab();
		addNewResourcePage.clickPointsTab();
		//deleting last point
		addNewResourcePage.clickDeletePointButton();
		//asserting error message
		addNewResourcePage.getErrorMessage();
		Assert.assertEquals(addNewResourcePage.getErrorMessageText(), localization.getMessage());
		addNewResourcePage.clickAddPointMessageButton();
		//reloading page
		addNewResourcePage = new AddNewResourcePage(app.getDriver());
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
