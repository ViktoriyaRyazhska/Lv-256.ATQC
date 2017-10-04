package com.regres.tests.coownerTable;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;
import com.regres.testdata.UserContainer;
import com.regres.testdata.DB.CommunityDB;
import com.regres.testdata.DB.CommunityDBRepo;
import com.regres.testdata.DB.UserDB;
import com.regres.testdata.DB.UserDBRepo;

public class SetCommunityActiveCoownersActionTest {

	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private Connection conn;
	private UserDB userDB;
	private CommunityDB communityDB;
	private CommunityDB communityDB2;
	private ActiveCoownersActionsDropdown activecoowners;

	@BeforeMethod
	public void beforeTest() throws ClassNotFoundException, SQLException {
		// Select browser
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
		// Cronnect to DB
		conn = ApplicationSources.createDBConnection();
		// Fill User
		userDB = UserDBRepo.getUser1();
		// Create new User in DB
		UserDB.createUserInDB(conn, userDB);
		// Fill community
		communityDB = CommunityDBRepo.getCommunity1();
		// Create new community in DB
		CommunityDB.createCommunityinDB(conn, communityDB);
		// Load app
		loginpage = app.load();
		// Login in system as administrator
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		// Click on Co-owners item
		adminhomepage.clickCoowners();
	}

	@AfterMethod
	public void afterTest() throws ClassNotFoundException, SQLException {
		// Delete user from db
		UserDB.deleteUserInDB(conn, userDB);
		// Delete community from db
		CommunityDB.deleteCommunityinDB(conn, communityDB);
		// Close connection to DB
		ApplicationSources.closeConnectionDB();
		// Close browser
		app.quit();
	}

	/**
	 * Check that community changed if enter existing community
	 */
//	@Test
	public void checkUserCommunityChange() throws ClassNotFoundException, SQLException {
		// Click on "active co-owners" item
		activecoowners = adminhomepage.clickActiveCoowners();
		// Find user in table
		activecoowners.FindAndClickUserInTable(userDB.getLogin());
		// CLick on "Actions" button
		activecoowners.clickActionsDropdown();
		// CLick on "Set community" item
		activecoowners.clickSetCommunity();
		// Enter name of existing community
		activecoowners.sendValueInInputField(communityDB.getNameCommunity());
		// Click "Confirm" button
		activecoowners.ClickConfirmButton();

		// Find user in table
		activecoowners.FindAndClickUserInTable(userDB.getLogin());
		// Verify that users community changed
		Assert.assertEquals(activecoowners.getCommunityNameFirstRow().getText(), communityDB.getNameCommunity());
	}

	/**
	 * Check that community didn't change if enter non exist community
	 */
	@Test
	public void checkUserInvalidCommunity() throws ClassNotFoundException, SQLException {

		// Fill invalid community
		communityDB2 = CommunityDBRepo.getInvalidCommunity();
		// Click on "active co-owners" item
		activecoowners = adminhomepage.clickActiveCoowners();
		// Find user in table
		activecoowners.FindAndClickUserInTable(userDB.getLogin());
		// CLick on "Actions" button
		activecoowners.clickActionsDropdown();
		// CLick on "Set community" item
		activecoowners.clickSetCommunity();
		// Enter name of non existent community
		activecoowners.sendInvalidValueInInputField(communityDB2.getNameCommunity());
		// Click "Confirm" button
		activecoowners.ClickConfirmButton();
		// Verify that users community changed
		Assert.assertEquals(activecoowners.confirm.getConfirmMessageText(),
				userDB.getEmptyCommunityMes());
		// Click "OK" button
		activecoowners.confirm.clickOkButton();

		// Find user in table
		activecoowners.FindAndClickUserInTable(userDB.getLogin());
		// Verify that users community did not chang
		Assert.assertEquals(activecoowners.getCommunityNameFirstRow().getText(), userDB.getNameCommunity());
	}

}
