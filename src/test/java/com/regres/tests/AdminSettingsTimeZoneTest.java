package com.regres.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.AdminSettingsPage;
import com.regres.pages.LoginPage;
import com.regres.testdata.UserContainer;

/**
 * This test verifies that Admin can set time zone for the app.
 * 
 * @author PETYAggg
 *
 */
public class AdminSettingsTimeZoneTest {

	private LoginPage loginpage;
	private AdminHomePage adminpage;
	private AdminSettingsPage settings;
	private Application app;

	/**
	 * Sign in as admin. Go to settings.
	 */
	@BeforeClass
	public void setUp() {

		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		loginpage = app.load();
		adminpage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		settings = adminpage.clickSettings();
	}

	/**
	 * Sign out. Close the app.
	 */
	@AfterClass
	public void tearDown() {

		settings.clickLogout();
		app.quit();
	}

	/**
	 * Data provider that has two fields: Search value - appropriate timezone
	 * 
	 */
	@DataProvider
	public Object[][] value_timezone() {
		return new Object[][] { { "London", "Europe/London" }, { "+2", "Etc/GMT+2" }, { "Kiev", "Europe/Kiev" },
				{ "+3", "Etc/GMT+3" } };
	}

	/**
	 * Verifies that admin can set time zone.
	 * 
	 * @param value
	 *            - search value
	 * @param timezone
	 *            - appropriate time zone that concerns our search value
	 */
	@Test(dataProvider = "value_timezone")
	public void TestTimeZoneSet(String value, String timezone) {

		settings = settings.setTimeZone(value);
		Assert.assertTrue(settings.getTimeZoneFieldText().contains(timezone));
		settings = settings.clickSettings();

	}

}
