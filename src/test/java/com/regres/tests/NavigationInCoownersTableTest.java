package com.regres.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.manage.coowners.CoownersElementsOnPageDropdown;
import com.regres.pages.manage.coowners.CoownersElementsOnPageDropdown.pageL10n;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;
import com.regres.testdata.UserContainer;

public class NavigationInCoownersTableTest {
	// fields declaration
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private CoownersElementsOnPageDropdown elements;

	@BeforeMethod
	public void setUp() {
		// start application with firefox browser
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		// go to login page
		loginpage = app.load();
		// login as administrator
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		// go to nonconfirmed coowners page
		elements = adminhomepage.selectNonConfirmedCoowners();
	}

	// check option 10 in dropdown list
	@Test(dataProvider = "L10N")
	public void dropdownTenTest(ChangeLanguageFields language) {
		elements.selectTenElementsOnPage();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO10.getLocalization(language));
		Assert.assertEquals(elements.getTABLE_BODY_ROWS_COUNT(), 10);
	}

	// check option 25 in dropdown list
	@Test(dataProvider = "L10N")
	public void dropdownTwentyFiveTest(ChangeLanguageFields language) {
		elements.selectTwentyFiveElementsOnPage();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO25.getLocalization(language));
		Assert.assertEquals(elements.getTABLE_BODY_ROWS_COUNT(), 25);
	}

	// check option 50 in dropdown list
	@Test(dataProvider = "L10N")
	public void dropdownFiftyTest(ChangeLanguageFields language) {
		elements.selectFiftyElementsOnPage();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO50.getLocalization(language));
		Assert.assertEquals(elements.getTABLE_BODY_ROWS_COUNT(), 50);
	}

	// check option 100 in dropdown list
	@Test(dataProvider = "L10N")
	public void dropdownHundredTest(ChangeLanguageFields language) {
		elements.selectFiftyElementsOnPage();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO100.getLocalization(language));
		Assert.assertEquals(elements.getTABLE_BODY_ROWS_COUNT(), 51);
	}

	// check paginate buttons
	@Test(dataProvider = "L10N")
	public void checkPaginateButtons(ChangeLanguageFields language) {
		elements.selectTenElementsOnPage();

		elements.checkPenultimatePaginateButton();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO50.getLocalization(language));
		Assert.assertEquals(elements.getTABLE_BODY_ROWS_COUNT(), 10);

		elements.checkFirstPaginateButton();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO10.getLocalization(language));
		Assert.assertEquals(elements.getTABLE_BODY_ROWS_COUNT(), 10);

		elements.checkLastPaginateButton();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO100.getLocalization(language));
		Assert.assertEquals(elements.getTABLE_BODY_ROWS_COUNT(), 1);
	}

	// check previous and next button
	@Test(dataProvider = "L10N")
	public void previousNextButtonTest(ChangeLanguageFields language) {
		elements.selectTwentyFiveElementsOnPage();
		elements.checkLastPaginateButton();

		elements.clickPreviousButton();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO50.getLocalization(language));
		Assert.assertEquals(elements.getTABLE_BODY_ROWS_COUNT(), 25);

		elements.checkFirstPaginateButton();
		elements.clickNextButton();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO50.getLocalization(language));
		Assert.assertEquals(elements.getTABLE_BODY_ROWS_COUNT(), 25);
	}

	// logout and quit browser after tests
	@AfterMethod
	public void tearDown() {
		elements.clickLogout();
		app.quit();
	}

	// localization data provider
	@DataProvider(name = "L10N")
	public static Object[] localizationProvider() {
		return new Object[][] { { ChangeLanguageFields.UKRAINIAN }
				// ,
				// { ChangeLanguageFields.RUSSIAN },
				// { ChangeLanguageFields.ENGLISH }
		};
	}

}