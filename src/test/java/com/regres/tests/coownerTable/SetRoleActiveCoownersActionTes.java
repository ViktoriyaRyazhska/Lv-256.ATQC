package com.regres.tests.coownerTable;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;
import com.regres.reports.Reports;
import com.regres.testdata.UserContainer;
import com.regres.testdata.DB.RoleDBRepo;
import com.regres.testdata.DB.UserDB;
import com.regres.testdata.DB.UserDBRepo;

public class SetRoleActiveCoownersActionTes extends Reports {

	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private Connection conn;
	private ExtentTest test;
	private UserDB userDB;
	private ActiveCoownersActionsDropdown activecoowners;

	/**
	 * Sign in as admin. Go to settings.
	 */
	@BeforeTest
	public void beforeTest() throws ClassNotFoundException, SQLException {

		test = report.createTest("AdminSettingsInvalidTimeZoneTest");

		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
		test.log(Status.INFO, "Opened browser");

		conn = ApplicationSources.createDBConnection();
		test.log(Status.INFO, "Connect to DB");

		userDB = UserDBRepo.getUser1();
		test.log(Status.INFO, "Fill User");

		UserDB.createUserInDB(conn, userDB);
		test.log(Status.INFO, "Fill User");

		loginpage = app.load();
		test.log(Status.INFO, "Opened 'Login page'");

		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		test.log(Status.INFO, "Signed in as Administrator");

		adminhomepage.clickCoowners();
		test.log(Status.INFO, "Opened 'Coowners' dropdownlist");

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
	@AfterTest
	public void afterTest() throws ClassNotFoundException, SQLException {
		UserDB.deleteUserInDB(conn, userDB);
		test.log(Status.INFO, "Delete User in DB");

		ApplicationSources.closeConnectionDB();
		test.log(Status.INFO, "Closed connection to DB");

		app.quit();
		test.log(Status.INFO, "Closed firefox");
	}

	@AfterClass(alwaysRun = true)
	public void getREPORT() {
		report.flush();
	}

	/**
	 * Check that user role changed after select it in Action dropdown list
	 */
	@Test
	public void checkUserRoleChanged() throws ClassNotFoundException, SQLException {

		activecoowners = adminhomepage.clickActiveCoowners();
		test.log(Status.INFO, "Click on 'Active Co-owner' item");

		// Check Co-owner Role
		activecoowners.findAndClickUserInTable(userDB.getLogin());
		test.log(Status.INFO, "Find User in table and click on it");

		activecoowners.clickActionsDropdown();
		test.log(Status.INFO, "Click on 'Actions' button");

		activecoowners.clickSetRole();
		test.log(Status.INFO, "Click on 'Set Role' item");

		activecoowners.clickCoownerRole();
		test.log(Status.INFO, "Click on 'Co-owner Role'");

		activecoowners.confirm.clickOkButton();
		test.log(Status.INFO, "Click 'OK'");

		Assert.assertEquals(activecoowners.getRoleFirstRowText(), RoleDBRepo.getRoleCoowner().getRoleName());
		test.log(Status.PASS, "Verified that User has role, that we select previously.");

		// Check Commissioner Role
		activecoowners.findAndClickUserInTable(userDB.getLogin());
		activecoowners.clickActionsDropdown();
		activecoowners.clickSetRole();
		activecoowners.clickCommissionerRole();
		activecoowners.confirm.clickOkButton();
		Assert.assertEquals(activecoowners.getRoleFirstRowText(), RoleDBRepo.getRoleCommissioner().getRoleName());
		test.log(Status.PASS, "Verified that User has role, that we select previously.");

		// Check Registrator Role
		// BUG in program
		// Find User in table and click on it
		// activecoowners.FindAndClickUserInTable(userDB.getLogin());
		// activecoowners.clickActionsDropdown();
		// activecoowners.clickSetRole();
		// activecoowners.clickRegistratorRole();
		// Assert.assertEquals(activecoowners.getRoleFirstRowText(),RoleDBRepo.getRoleRegistrator().getRoleName());

		// Check Administrator Role
		activecoowners.findAndClickUserInTable(userDB.getLogin());
		activecoowners.clickActionsDropdown();
		activecoowners.clickSetRole();
		activecoowners.clickAdministratorRole();
		activecoowners.confirm.clickOkButton();
		Assert.assertEquals(activecoowners.getRoleFirstRowText(), RoleDBRepo.getRoleAdmin().getRoleName());
		test.log(Status.PASS, "Verified that User has role, that we select previously.");
	}

}
