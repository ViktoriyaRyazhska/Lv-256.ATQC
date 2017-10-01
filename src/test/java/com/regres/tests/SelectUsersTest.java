package com.regres.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mysql.jdbc.Statement;
import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;

public class SelectUsersTest {
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private Connection conn;
	
	@Test
	public void checkUserCreating() throws SQLException {
		Statement st = (Statement) conn.createStatement ();
		String showUser = "Select * From registrator_db.users;";
		ResultSet rs = st.executeQuery(showUser);
		int x = rs.getMetaData().getColumnCount();
		while (rs.next ()) {
		       for (int i = 1; i <= x; i++) {
		         System.out.print (rs.getString (i) + "\t");
		       }
		       System.out.println ();
		     }
		     System.out.println ();
		     if (rs != null) rs.close ();
		     if (st != null) st.close ();
	}

	@BeforeClass
	public Connection beforeClass() throws ClassNotFoundException, SQLException {
//		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
		conn = ApplicationSources.createDBConnection();
//		loginpage = app.load();
//		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
//		adminhomepage.clickCoowners();
		return conn;
	}

	@AfterClass
	public void afterClass() throws ClassNotFoundException, SQLException {
			ApplicationSources.closeConnectionDB(conn);
//			app.quit();
	}

}
