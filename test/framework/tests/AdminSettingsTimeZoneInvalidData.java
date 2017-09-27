package framework.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.application.Application;
import framework.application.ApplicationSourcesRepo;
import framework.pages.AdminHomePage;
import framework.pages.AdminSettingsPage;
import framework.pages.LoginPage;
import framework.pages.OhErrorPage;
import framework.testdata.UserContainer;

public class AdminSettingsTimeZoneInvalidData {

	private WebDriver driver;
	private LoginPage loginpage;
	private AdminHomePage adminpage;
	private AdminSettingsPage settings;

	private Application app;

	@BeforeClass
	public void setUp() {

		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		adminpage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		settings = adminpage.clickSettings();
	}

	@AfterClass
	public void tearDown() {

		settings.clickLogout();
		app.quit();
	}

	@Test
	public void checkInvalidTimeZoneSet() {

		String presetTimeZone = settings.getTimeZoneFieldText();
		OhErrorPage errorPage = settings.setInvalidTimeZone("InvalidData");
		adminpage = errorPage.clickGoToHomePageButton();
		settings = adminpage.clickSettings();
		Assert.assertEquals(settings.getTimeZoneFieldText(), presetTimeZone);
	}

}
