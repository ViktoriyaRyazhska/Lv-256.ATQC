package com.regres.tests.coownerTable;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
import com.regres.testdata.DB.CommunityDB;
import com.regres.testdata.DB.CommunityDBRepo;
import com.regres.testdata.DB.UserDB;
import com.regres.testdata.DB.UserDBRepo;

public class SetCommunityActiveCoownersActionTest extends Reports {

	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private Connection conn;
	private UserDB userDB;
	private ExtentTest test;
	private CommunityDB communityDB;
	private CommunityDB communityDB2;
	private ActiveCoownersActionsDropdown activecoowners;

	@BeforeMethod
	public void beforeMethod() throws ClassNotFoundException, SQLException {

		test = report.createTest("AdminSettingsInvalidTimeZoneTest");

		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
		test.log(Status.INFO, "Opened browser");

		conn = ApplicationSources.createDBConnection();
		test.log(Status.INFO, "Connect to DB");

		userDB = UserDBRepo.getUser1();
		test.log(Status.INFO, "Fill User");

		UserDB.createUserInDB(conn, userDB);
		test.log(Status.INFO, "Fill User");

		communityDB = CommunityDBRepo.getCommunity1();
		test.log(Status.INFO, "Fill community");
		
		CommunityDB.createCommunityinDB(conn, communityDB);
		test.log(Status.INFO, "Create new community in DB");
		
		loginpage = app.load();
		test.log(Status.INFO, "Opened 'Login page'");

		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		test.log(Status.INFO, "Signed in as Administrator");

		adminhomepage.clickCoowners();
		test.log(Status.INFO, "Opened 'Coowners' dropdownlist");

	}
	@AfterMethod(alwaysRun = true)
	public void reportresults(ITestResult result) {
		getResult(result, test);
	}
	
	@AfterMethod
	public void afterTest() throws ClassNotFoundException, SQLException {
		
		UserDB.deleteUserInDB(conn, userDB);
		test.log(Status.INFO, "Delete User in DB");
		
		CommunityDB.deleteCommunityinDB(conn, communityDB);
		test.log(Status.INFO, "Delete community from db");
		
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
	 * Check that community changed if enter existing community
	 */
	 @Test
	public void checkUserCommunityChange() throws ClassNotFoundException, SQLException {
		activecoowners = adminhomepage.clickActiveCoowners();
		test.log(Status.INFO, "Click on 'Active Co-owner' item");
		
		activecoowners.findAndClickUserInTable(userDB.getLogin());
		test.log(Status.INFO, "Find User in table and click on it");
		activecoowners.clickActionsDropdown();
		test.log(Status.INFO, "Click on 'Actions' button");
	
		activecoowners.clickSetCommunity();
		test.log(Status.INFO, "Click on 'Set community' item");
		
		activecoowners.sendValueInInputField(communityDB.getNameCommunity());
		test.log(Status.INFO, "Enter name of existing community");		

		activecoowners.clickConfirmButton();
		test.log(Status.INFO, "Click on 'Сonfirm' button");

		activecoowners.findAndClickUserInTable(userDB.getLogin());
		test.log(Status.INFO, "Find User in table and click on it");

		Assert.assertEquals(activecoowners.getCommunityNameFirstRow().getText(), communityDB.getNameCommunity());
		test.log(Status.PASS, "Verified that users community changed.");
		Assert.assertEquals(communityDB.getNameCommunityFromDb(conn, communityDB),communityDB.getNameCommunity());
	}

	/**
	 * Check that community didn't change if enter non exist community
	 */
//	@Test
	public void checkUserInvalidCommunity() throws ClassNotFoundException, SQLException {
		communityDB2 = CommunityDBRepo.getInvalidCommunity();
		test.log(Status.INFO, "Fill invalid community");
		
		activecoowners = adminhomepage.clickActiveCoowners();
		test.log(Status.INFO, "Click on 'Active Co-owner' item");

		activecoowners.findAndClickUserInTable(userDB.getLogin());
		test.log(Status.INFO, "Find User in table and click on it");

		activecoowners.clickActionsDropdown();
		test.log(Status.INFO, "Click on 'Actions' button");

		activecoowners.clickSetCommunity();
		test.log(Status.INFO, "Click on 'Set community' item");

		activecoowners.sendInvalidValueInInputField(communityDB2.getNameCommunity());
		test.log(Status.INFO, "Enter name of non existent community");	

		activecoowners.clickConfirmButton();
		test.log(Status.INFO, "Click on 'Сonfirm' button");
		
		Assert.assertEquals(activecoowners.confirm.getConfirmMessageText(), userDB.getEmptyCommunityMes());
		test.log(Status.INFO, "Verified message.");

		activecoowners.confirm.clickOkButton();
		test.log(Status.INFO, "Click on 'OK' button");

		activecoowners.findAndClickUserInTable(userDB.getLogin());
		test.log(Status.INFO, "Find User in table and click on it");

		Assert.assertEquals(activecoowners.getCommunityNameFirstRow().getText(), userDB.getNameCommunity());
		test.log(Status.PASS, "Verified that users community did not change.");
		Assert.assertEquals(communityDB.getNameCommunityFromDb(conn, communityDB),userDB.getNameCommunity());
	}

}
