package com.regres.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
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

	@BeforeClass
	public void setUp() {
		// start application with firefox browser
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		// app =
		// Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		// go to login page
		loginpage = app.load();
		// login as administrator
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		
	}


	// check option 25 in dropdown list
	@Test(dataProvider = "L10N")
	public void dropdownTwentyFiveTest(ChangeLanguageFields language) {
		adminhomepage = adminhomepage.setLanguage(language);
		elements = adminhomepage.selectNonConfirmedCoowners();
		elements.selectTwentyFiveElementsOnPage();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO25.getLocalization(language));
		Assert.assertEquals(elements.getTableBodyRowsCount(), 25);
		adminhomepage = new AdminHomePage(app.getDriver());
	}

	// check option 50 in dropdown list
	@Test(dataProvider = "L10N")
	public void dropdownFiftyTest(ChangeLanguageFields language) {
		adminhomepage = adminhomepage.setLanguage(language);
		elements = adminhomepage.selectNonConfirmedCoowners();
		elements = elements.selectFiftyElementsOnPage();
		elements = new CoownersElementsOnPageDropdown(app.getDriver());
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO50.getLocalization(language));
		Assert.assertEquals(elements.getTableBodyRowsCount(), 50);
		adminhomepage = new AdminHomePage(app.getDriver());
	}

	// check option 100 in dropdown list
	@Test(dataProvider = "L10N")
	public void dropdownHundredTest(ChangeLanguageFields language) {
		adminhomepage = adminhomepage.setLanguage(language);
		elements = adminhomepage.selectNonConfirmedCoowners();
		elements.selectHundredElementsOnPage();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO100.getLocalization(language));
		Assert.assertEquals(elements.getTableBodyRowsCount(), 52);
		adminhomepage = new AdminHomePage(app.getDriver());

	}

	// check paginate buttons
	@Test(dataProvider = "L10N")
	public void checkPaginateButtons(ChangeLanguageFields language) {
		adminhomepage = adminhomepage.setLanguage(language);
		elements = adminhomepage.selectNonConfirmedCoowners();
		elements.selectTenElementsOnPage();
		// elements = new CoownersElementsOnPageDropdown(app.getDriver());
		elements = elements.checkPenultimatePaginateButton();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO50.getLocalization(language));
		Assert.assertEquals(elements.getTableBodyRowsCount(), 10);
		elements.checkFirstPaginateButton();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO10.getLocalization(language));
		Assert.assertEquals(elements.getTableBodyRowsCount(), 10);
		elements.checkLastPaginateButton();
		adminhomepage = new AdminHomePage(app.getDriver());
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO100.getLocalization(language));
		Assert.assertEquals(elements.getTableBodyRowsCount(), 2);
	}

	// check previous and next button
	@Test(dataProvider = "L10N")
	public void previousNextButtonTest(ChangeLanguageFields language) {
		adminhomepage = adminhomepage.setLanguage(language);
		elements = adminhomepage.selectNonConfirmedCoowners();
		elements = elements.selectTenElementsOnPage();
		elements.checkLastPaginateButton();
		elements.clickPreviousButton();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO50.getLocalization(language));
		Assert.assertEquals(elements.getTableBodyRowsCount(), 10);
		elements.checkFirstPaginateButton();
		elements.clickNextButton();
		Assert.assertEquals(elements.getElementsInfoText(), pageL10n.EXAMPLE_INFO20.getLocalization(language));
		Assert.assertEquals(elements.getTableBodyRowsCount(), 10);
		adminhomepage = new AdminHomePage(app.getDriver());
	}

	// logout and quit browser after tests
	@AfterClass
	public void tearDown() {
		elements.clickLogout();
		app.quit();
	}

	// localization data provider
	@DataProvider(name = "L10N")
	public static Object[] localizationProvider() {
		return new Object[][] { { ChangeLanguageFields.UKRAINIAN }
				 , { ChangeLanguageFields.RUSSIAN },
				 { ChangeLanguageFields.ENGLISH }
		};
	}

}