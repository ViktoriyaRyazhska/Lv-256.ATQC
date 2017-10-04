package com.regres.testdata.DB;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

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

}
