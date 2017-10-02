package com.regres.tests;

import java.sql.Connection;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mysql.jdbc.PreparedStatement;
import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.CommissionerWithRegistrationHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;
import com.regres.testdata.UserContainer;
import com.regres.testdata.UserDB;
import com.regres.testdata.UserDBRepo;

public class ActionActiveCoownersTest {
	
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private Connection conn;
//	private UserDB DB;
	
	@BeforeMethod
	public Connection beforeTest() throws ClassNotFoundException, SQLException {
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
		conn = ApplicationSources.createDBConnection();
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());

		adminhomepage.clickCoowners();
		return conn;
	}
	
	@AfterMethod
	public void afterTest() throws ClassNotFoundException, SQLException {		
		ApplicationSources.closeConnectionDB();
		app.quit();
	}
	
	@DataProvider
	public Object[][] userChange() {
		return new Object[][] { { UserDBRepo.getUser1() } };
	}
	
	/**
	 * Check that user role changes
	 */
	@Test(dataProvider="userChange")
	public void checkUserRoleChange(UserDB userDB) throws ClassNotFoundException, SQLException {
		// call method for creating new user
//		DB.createUserInDB(userDB);
		createUserInDB(userDB);
		ActiveCoownersActionsDropdown actions = adminhomepage.clickActiveCoowners();
		actions.getFirstNameFirstRow().click();
		actions.clickActionsDropdown();
		actions.clickSetRole();
		actions.clickCoownerRole();
		actions.confirm.clickOkButton();
		Assert.assertEquals(actions.getRoleFirstRow().getText(), "Співвласник");
				
		//delete user
//		DB.deleteUserInDB(userDB);
		deleteUserInDB(userDB);
	}
	
	/**
	 * Check appearing of message when no one row is selected
	 */
	@Test
	public void checkConfirmMessageSetCommunity() {
		ActiveCoownersActionsDropdown actions = adminhomepage.clickActiveCoowners();
		actions.clickActionsDropdown();
		actions.clickSetCommunityNotSelected();
		Assert.assertEquals(actions.confirm.getConfirmMessageText(),
				"Для виконання даної операції спочатку потрібно вибрати співвласників, натиснувши на відповідні стрічки в таблиці");
		actions.confirm.clickCloseButton();
	}	
	
//	@Test
	public void checkUserCommunityChange() {
		ActiveCoownersActionsDropdown actions = adminhomepage.clickActiveCoowners();
		actions.getFirstNameFirstRow().click();
		actions.clickActionsDropdown();
		actions.clickSetCommunity();
		actions.confirm.getInput().sendKeys("Ukr");
	}
	
	public void createUserInDB(UserDB userDB) throws SQLException, ClassNotFoundException {
	
		String createUser = "Insert into registrator_db.users (account_non_expired,account_non_locked,attempts,credentials_non_expired,date_of_accession,email,enabled,first_name,last_modified,last_name,locked_till,login,middle_name,password,phonenumber,status,role_id,territorialCommunity_id)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(createUser);

		// Statement allows to send inquiries database
		st.setString(1, userDB.getAccount_non_expired());
		st.setString(2, userDB.getAccount_non_locked());
		st.setString(3, userDB.getAttempts());
		st.setString(4, userDB.getCredentials_non_expired());
		st.setString(5, userDB.getDate_of_accession());
		st.setString(6, userDB.getEmail());
		st.setString(7, userDB.getEnabled());
		st.setString(8, userDB.getFirst_Name());
		st.setString(9, userDB.getLast_modified());
		st.setString(10, userDB.getLast_Name());
		st.setString(11, userDB.getLocked_till());
		st.setString(12, userDB.getLogin());
		st.setString(13, userDB.getMiddle_name());
		st.setString(14, userDB.getPassword());
		st.setString(15, userDB.getPhonenumber());
		st.setString(16, userDB.getStatus());
		st.setString(17, userDB.getRole_id());
		st.setString(18, userDB.getTerritorialCommunity_id());
		st.executeUpdate();		
	}

	public void deleteUserInDB(UserDB userDB) throws SQLException, ClassNotFoundException {		
		String deleteUser = "Delete from registrator_db.users where login=(?)";
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(deleteUser);
		st.setString(1, userDB.getLogin());
		st.executeUpdate();			
	}

}
