package com.regres.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;
import com.regres.testdata.UserContainer;
import com.regres.testdata.UserDB;
import com.regres.testdata.UserDBRepo;

public class ActionActiveCoownersTest {
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;

	@BeforeClass
	public void setUp() throws ClassNotFoundException, SQLException {
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
		ApplicationSources.createDBConnection();
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		adminhomepage.clickCoowners();
	}
	
	@DataProvider
	public Object[][] userChange() {
		return new Object[][] { { UserDBRepo.getUser1() } };
	}
	
	@AfterClass
	public void tearDown(Connection conn) throws ClassNotFoundException, SQLException {
		ApplicationSources.closeConnectionDB(conn);
		app.quit();
	}
		
	public void createUserInDB(Connection conn, UserDB userDB)
			throws SQLException, ClassNotFoundException {
		// the mysql insert statement
		conn = ApplicationSources.createDBConnection();

		String createUser = "Insert into registrator_db.users (date_of_accession,email,first_name,last_name,login,password,status,role_id,territorialCommunity_id)  values(?,?,?, ?,?,?, ?,?,?);";
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(createUser);
		
		// Statement allows you to send inquiries database
		st.setString(1, userDB.getDate_of_accession());				
		st.setString(2, userDB.getEmail());		
		st.setString(3, userDB.getFirst_Name());
		st.setString(4, userDB.getLast_Name());
		st.setString(5, userDB.getLogin());
		st.setString(6, userDB.getPassword());
		st.setString(7, userDB.getStatus());
		st.setString(8, userDB.getRole_id());
		st.setString(9, userDB.getTerritorialCommunity_id());
		st.executeUpdate();
	}

	
	@Test(dataProvider="userChange")
	public void checkUserCreating(Connection conn,UserDB userDB) throws ClassNotFoundException, SQLException {
		//call method for creating new user
		createUserInDB(conn, userDB);
		
	}
	
	/**
	 * Check appearing of message when no one row is selected
	 */
//	@Test
	public void checkConfirmMessageSetCommunity() {
		ActiveCoownersActionsDropdown actions = adminhomepage.clickActiveCoowners();
		actions.clickActionsDropdown();
		actions.clickSetCommunityNotSelected();
		Assert.assertEquals(actions.confirm.getConfirmMessageText(),
				"Для виконання даної операції спочатку потрібно вибрати співвласників, натиснувши на відповідні стрічки в таблиці");
		actions.confirm.clickCloseButton();
	}

	/**
	 * Check that role changes
	 */
//	@Test
	public void checkSetRole() {
		ActiveCoownersActionsDropdown actions = adminhomepage.clickActiveCoowners();
		actions.getFirstNameColumn();
		actions.clickActionsDropdown();
		actions.clickSetRole();
		actions.clickCoownerRole();
		actions.confirm.clickOkButton();
		Assert.assertEquals(actions.getRoleColumnText(), "Співвласник");
	}
}
