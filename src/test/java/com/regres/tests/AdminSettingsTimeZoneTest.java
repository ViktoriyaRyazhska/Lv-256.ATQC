package com.regres.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.AdminSettingsPage;
import com.regres.pages.LoginPage;
import com.regres.reports.Reports;
import com.regres.testdata.UserContainer;

/**
 * This test verifies that Admin can set time zone for the app.
 * 
 * @author PETYAggg
 *
 */
public class AdminSettingsTimeZoneTest extends Reports{

	private LoginPage loginpage;
	private AdminHomePage adminpage;
	private AdminSettingsPage settings;
	private Application app;
	private ExtentTest test;
	/**
	 * Sign in as admin. Go to settings.
	 */
	@BeforeClass
	public void setUp() {
		test = report.createTest("AdminSettingsTimeZoneTest");
		
		test.log(Status.INFO, "Opening browser.");
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		
		test.log(Status.INFO, "Opening 'Login page'.");
		loginpage = app.load();
		
		test.log(Status.INFO, "Signing in as Administrator.");
		adminpage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		
		test.log(Status.INFO, "Opening 'Settings page'.");
		settings = adminpage.clickSettings();
		
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

	/**
	 * Sign out. Close the app.
	 */
	@AfterClass
	public void tearDown() {

		settings.clickLogout();
		test.log(Status.INFO, "Signed off.");
		
		app.quit();
		test.log(Status.INFO, "Closed browser.");
		
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
		test.log(Status.INFO, "Set value of time zone: "+value+" and clicked confirm.");
		
		Assert.assertTrue(settings.getTimeZoneFieldText().contains(timezone));
		test.log(Status.PASS, "Checked if time zone was set correctly");
		
		settings = settings.clickSettings();
		test.log(Status.INFO, "Opened 'Settings' page.");

	}

}
