package com.regres.testdata.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.regres.testdata.EnteredNameSubclass;

public class CommunityDB {
	private String communityDB;

	public CommunityDB(String communityDB) {
		this.communityDB = communityDB;
	}

	public String getNameCommunity() {
		return communityDB;
	}

	public void setNameCommunity(String communityDB) {
		this.communityDB = communityDB;
	}

	public static void createCommunityinDB(Connection conn, CommunityDB communityDB)
			throws SQLException, ClassNotFoundException {
		// the mysql insert statement
		String createCommunity = "Insert into registrator_db.territorial_community(name) values (?);";
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(createCommunity);

		// Statement allows you to send inquiries database
		st.setString(1, communityDB.getNameCommunity());
		st.executeUpdate();
	}
	public static void deleteCommunityinDB(Connection conn, CommunityDB communityDB)
			throws SQLException, ClassNotFoundException {
		// the mysql insert statement
		String deleteCommunity = "Delete from registrator_db.territorial_community where name=(?)";
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(deleteCommunity);
		
		st.setString(1, communityDB.getNameCommunity());
		st.executeUpdate();
	}
	public String getNameCommunityFromDb(Connection conn, CommunityDB communityDB) throws SQLException {
		  String selectCommunity = "select name from registrator_db.territorial_community where name=(?)";
		  PreparedStatement st = (PreparedStatement) conn.prepareStatement(selectCommunity);
		  st.setString(1, communityDB.getNameCommunity());
		  ResultSet rs = st.executeQuery();
		  String name = "";
		  
		  if (rs.next()) {
		   // From the result of the query we get the field type_name from the database
			  name = rs.getString("name");
		  }
		  // Close the objects that work with the database
		  rs.close();
		  if (st != null)
		   st.close();
		  return name;
	}
}
