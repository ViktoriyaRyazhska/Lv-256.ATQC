package com.regres.tests.coownerTable;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;
import com.regres.testdata.UserContainer;
import com.regres.testdata.DB.RoleDBRepo;
import com.regres.testdata.DB.UserDB;
import com.regres.testdata.DB.UserDBRepo;

public class SetRoleActiveCoownersActionTest {

	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private Connection conn;
	private UserDB userDB;
	private ActiveCoownersActionsDropdown activecoowners;

	@BeforeTest
	public void beforeTest() throws ClassNotFoundException, SQLException {
		// Select browser
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
		// Cronnect to DB
		conn = ApplicationSources.createDBConnection();
		// Fill User
		userDB = UserDBRepo.getUser1();
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
		UserDB.deleteUserInDB(conn, userDB);
		ApplicationSources.closeConnectionDB();
		app.quit();
	}

	/**
	 * Check that user role changed after select it in Action dropdown list
	 */
	@Test
	public void checkUserRoleChanged() throws ClassNotFoundException, SQLException {
		// Click on 'Active Co-owner' item
		activecoowners = adminhomepage.clickActiveCoowners();

		// Check Co-owner Role
		// Find User in table and click on it
		activecoowners.FindAndClickUserInTable(userDB.getLogin());
		// Click on 'Actions' button
		activecoowners.clickActionsDropdown();
		// Click on 'Set Role' item
		activecoowners.clickSetRole();
		// Click on 'Co-owner Role'
		activecoowners.clickCoownerRole();
		// Click "OK'
		activecoowners.confirm.clickOkButton();
		// Verify that User has role, that we select previously
		Assert.assertEquals(activecoowners.getRoleFirstRowText(), RoleDBRepo.getRoleCoowner().getRoleName());

		// Check Commissioner Role
		// Find User in table and click on it
		activecoowners.FindAndClickUserInTable(userDB.getLogin());
		// Click on 'Actions' button
		activecoowners.clickActionsDropdown();
		// Click on 'Set Role' item
		activecoowners.clickSetRole();
		// Click on 'Commissioner Role'
		activecoowners.clickCommissionerRole();
		// Click "OK'
		activecoowners.confirm.clickOkButton();
		// Verify that User has role, that we select previously
		Assert.assertEquals(activecoowners.getRoleFirstRowText(), RoleDBRepo.getRoleCommissioner().getRoleName());

		// Check Registrator Role
		// DUG in program
		// // Find User in table and click on it
		// activecoowners.FindAndClickUserInTable(userDB.getLogin());
		// // Click on 'Actions' button
		// activecoowners.clickActionsDropdown();
		// // Click on 'Set Role' item
		// activecoowners.clickSetRole();
		// // Click on 'Registrator Role'
		// activecoowners.clickRegistratorRole();//
		// // Verify that User appeared on home page
		// Assert.assertEquals(activecoowners.getRoleFirstRowText(),RoleDBRepo.getRoleRegistrator().getRoleName());

		// Check Administrator Role
		// Find User in table and click on it
		activecoowners.FindAndClickUserInTable(userDB.getLogin());
		// Click on 'Actions' button
		activecoowners.clickActionsDropdown();
		// Click on 'Set Role' item
		activecoowners.clickSetRole();
		// Click on 'Commissioner Role'
		activecoowners.clickAdministratorRole();
		// Click "OK'
		activecoowners.confirm.clickOkButton();
		// Verify that User has role, that we select previously
		Assert.assertEquals(activecoowners.getRoleFirstRowText(), RoleDBRepo.getRoleAdmin().getRoleName());
	}
}
