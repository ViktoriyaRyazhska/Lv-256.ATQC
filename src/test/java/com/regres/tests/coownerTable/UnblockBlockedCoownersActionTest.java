package com.regres.tests.coownerTable;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;
import com.regres.pages.manage.coowners.actions.BlockedCoownersActionsDropdown;
import com.regres.pages.manage.coowners.actions.InactiveCoownersActionsDropdown;
import com.regres.testdata.UserContainer;
import com.regres.testdata.DB.UserDB;
import com.regres.testdata.DB.UserDBRepo;

public class UnblockBlockedCoownersActionTest {

	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private Connection conn;
	private UserDB userDB;
	private InactiveCoownersActionsDropdown inactivecoowners;
	private CoownersTable coownerstable;
	private BlockedCoownersActionsDropdown blockedcoowners;
	private ActiveCoownersActionsDropdown activecoowners;

	@BeforeTest
	public void beforeTest() throws ClassNotFoundException, SQLException {
		// Select browser
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
		// Cronnect to DB
		conn = ApplicationSources.createDBConnection();
		// Fill User
		userDB = UserDBRepo.getUserInactive();
		// Create new User in DB
		UserDB.createUserInDB(conn, userDB);
		// Load app
		loginpage = app.load();
		// Login in system as administrator
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		// Click on Coowners item
		adminhomepage.clickCoowners();

	}

	@AfterTest
	public void afterTest() throws ClassNotFoundException, SQLException {
		// UserDB.deleteUserInDB(conn, userDB);
		ApplicationSources.closeConnectionDB();
		app.quit();
	}

	/**
	 * Convert inactive user into bloked
	 */
	public void convertInactiveCoownerBloked() {
		adminhomepage.clickInactiveCoowners();
		coownerstable.FindAndClickUserInTable(userDB.getLogin());
		inactivecoowners.clickActionsDropdown();
		inactivecoowners.clickBlock();
	}

	/**
	 * Check that user role changed after select it in Action dropdown list
	 */
//	@Test
	public void checkUserRoleChanged() throws ClassNotFoundException, SQLException {
		convertInactiveCoownerBloked();
		adminhomepage.clickCoowners();
		adminhomepage.clickBlockedCoowners();
		activecoowners.FindAndClickUserInTable(userDB.getLogin());
		// Click on 'Active Co-owner' item
		blockedcoowners.clickActionsDropdown();
		blockedcoowners.clickUnblock();

	}
}
