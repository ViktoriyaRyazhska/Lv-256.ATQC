package com.regres.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.AdminSettingsPage;
import com.regres.pages.LoginPage;
import com.regres.pages.OhErrorPage;
import com.regres.reports.Reports;
import com.regres.testdata.UserContainer;

/**
 * Checks if user gets redirected to the error page when invalid timezone is
 * set. Time zone should not be changed.
 * 
 * @author PETYAggg
 *
 */
public class AdminSettingsTimeZoneInvalidDataTest extends Reports {

	private LoginPage loginpage;
	private AdminHomePage adminpage;
	private AdminSettingsPage settings;
	private ExtentTest test;
	private Application app;

	/**
	 * Sign in as admin. Go to settings.
	 */
	@BeforeClass
	public void setUp() {
		test = report.createTest("AdminSettingsInvalidTimeZoneTest");
		
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		test.log(Status.INFO, "Opened browser");
		
		loginpage = app.load();
		test.log(Status.INFO, "Opened 'Login page'");
		
		adminpage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		test.log(Status.INFO, "Signed in as Administrator");
		
		settings = adminpage.clickSettings();
		test.log(Status.INFO, "Opened 'Settings page'");
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
		test.log(Status.INFO, "Signed off");
		app.quit();
		test.log(Status.INFO, "Closed firefox");

	}

	@AfterSuite(alwaysRun = true)
	public void getREPORT() {
		report.flush();
	}

	/**
	 * Checks if user gets redirected to the error page when invalid timezone is
	 * set. Time zone should not be changed.
	 */
	@Test
	public void checkInvalidTimeZoneSet() {

		String presetTimeZone = settings.getTimeZoneFieldText(); // get current
																	// timezone

		test.log(Status.INFO, "Setting invalid credentials for time zone");
		OhErrorPage errorPage = settings.setInvalidTimeZone("InvalidData");

		test.log(Status.INFO, "Getting redirected to the error page and clicking 'Return to homepage button'");
		adminpage = errorPage.clickGoToHomePageButton();

		test.log(Status.INFO, "Open Settings page");
		settings = adminpage.clickSettings();

		Assert.assertEquals(settings.getTimeZoneFieldText(), presetTimeZone);
		test.log(Status.PASS, "Verified that time zone didn't change.");
	}

}
