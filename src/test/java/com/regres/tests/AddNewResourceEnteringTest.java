package com.regres.tests;

import java.util.concurrent.TimeUnit;

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
import com.regres.pages.ResourceDetailPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.AddNewResourceLocalization;
import com.regres.testdata.Coordinates;
import com.regres.testdata.User;
import com.regres.testdata.UserContainer;

public class AddNewResourceEnteringTest {
	private AddNewResourceLocalization localization;
	private Application app;
	private User user = UserContainer.getRegistrator();
	private LoginPage loginpage;
	private RegistratorHomePage registratorHomePage;
	private AddNewResourcePage addNewResourcePage;
	private ResourceDetailPage resourceDetailPage;
	String testRes = AddNewResourceLocalization.TEST_RESOURCE.getMessage();

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
		addNewResourcePage.clickLogout();
		app.quit();
	}

	@Test(dataProvider = "CheckError")
	public void checkErrorMessages(ChangeLanguageFields language, AddNewResourceLocalization localization) {
		addNewResourcePage = addNewResourcePage.setLanguage(language);
		addNewResourcePage = addNewResourcePage.clickPointsNavTab();
		addNewResourcePage.clickPointsTab();
		setTeretory();
		addNewResourcePage.selectObjSubclass();
		addNewResourcePage.getObjectNameField().click();
		// JavascriptExecutor js = (JavascriptExecutor)app.getDriver();
		// js.executeScript("arguments[0].click();",
		// addNewResourcePage.getShowOnMapButton());
		addNewResourcePage = addNewResourcePage.clickShowOnMapButton();
		addNewResourcePage.clickPointsTab();
		addNewResourcePage.getObjectNameField().click();
		// js.executeScript("arguments[0].click();",
		// addNewResourcePage.getSaveButton());
		addNewResourcePage.getObjectNameField().sendKeys("іфвфві");
		addNewResourcePage.getObjectNameField().clear();
		app.getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		addNewResourcePage = addNewResourcePage.saveResource();
		addNewResourcePage.getNameErrorMessage();
		addNewResourcePage.getReasoneErrorMessage();
		Assert.assertEquals(addNewResourcePage.getNameErrorMessageText(), localization.getMessage());
		Assert.assertEquals(addNewResourcePage.getReasoneErrorMessageText(), localization.getMessage());
		addNewResourcePage = addNewResourcePage.clickPointsNavTab();
		addNewResourcePage.clickPointsTab();
		addNewResourcePage.clickClearButton();

	}

	@Test()
	public void checkSucces() {
		addNewResourcePage = addNewResourcePage.clickPointsNavTab();
		addNewResourcePage.clickPointsTab();
		setTeretory();
		addNewResourcePage.selectObjSubclass();
		addNewResourcePage.getObjectNameField().click();
		addNewResourcePage.getProcurationsCheckBox().click();
		addNewResourcePage = addNewResourcePage.clickShowOnMapButton();
		addNewResourcePage.clickPointsTab();
		addNewResourcePage.getObjectNameField().sendKeys(testRes);
		resourceDetailPage = addNewResourcePage.saveResourceSucces();
		Assert.assertEquals(resourceDetailPage.getResourceNameText(), testRes);
		registratorHomePage = resourceDetailPage.deleteRes();
		addNewResourcePage = registratorHomePage.clickAddNewResourceNavTab();

	}

	@DataProvider(name = "CheckError")
	public Object[] checkError() {

		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, localization.UA_EMPTY },
				{ ChangeLanguageFields.ENGLISH, localization.EN_EMPTY },
				{ ChangeLanguageFields.RUSSIAN, localization.RU_EMPTY } };

	}

	public void setTeretory() {
		addNewResourcePage.setCoordinates(Coordinates.FIRST_POINT);
		addNewResourcePage.addSecondPoint();
		addNewResourcePage.setCoordinates(Coordinates.SECOND_POINT);
		addNewResourcePage.addThirdPoint();
		addNewResourcePage.setCoordinates(Coordinates.THIRD_POINT);

	}

}
