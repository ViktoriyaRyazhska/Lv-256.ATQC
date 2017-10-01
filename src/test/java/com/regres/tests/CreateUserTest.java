package com.regres.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.testdata.UserDB;
import com.regres.testdata.UserDBRepo;

public class CreateUserTest {

	private Application app;
	private Connection conn;

	@Test(dataProvider="userChange")
	public void checkUserCreating(UserDB userDB) throws ClassNotFoundException, SQLException {
		// call method for creating new user
		createUserInDB(userDB);
		Statement st = (Statement) conn.createStatement();
		String showUser = "Select * From registrator_db.users;";
		ResultSet rs = st.executeQuery(showUser);
		int x = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= x; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}
		System.out.println();
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
	}


	@DataProvider
	public Object[][] userChange() {
		return new Object[][] { { UserDBRepo.getUser1() } };
	}

	public void createUserInDB(UserDB userDB) throws SQLException, ClassNotFoundException {
		String createUser = "Insert into registrator_db.users (date_of_accession,email,enabled,first_name,last_name,login,password,status,role_id,territorialCommunity_id)  values(?,?,?,?,?,?,?, ?,?,?);";
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(createUser);

		// Statement allows to send inquiries database
		st.setString(1, userDB.getDate_of_accession());
		st.setString(2, userDB.getEmail());
		st.setString(3, userDB.getEnabled());
		st.setString(4, userDB.getFirst_Name());
		st.setString(5, userDB.getLast_Name());
		st.setString(6, userDB.getLogin());
		st.setString(7, userDB.getPassword());
		st.setString(8, userDB.getStatus());
		st.setString(9, userDB.getRole_id());
		st.setString(10, userDB.getTerritorialCommunity_id());
		st.executeUpdate();		
	}

	@BeforeTest
	public Connection beforeTest() throws ClassNotFoundException, SQLException {
		conn = ApplicationSources.createDBConnection();
		return conn;
	}

	@AfterTest
	public void afterTest() throws ClassNotFoundException, SQLException {
		ApplicationSources.closeConnectionDB(conn);

//        Delete from registrator_db.users where user_id=4;
	}

}
