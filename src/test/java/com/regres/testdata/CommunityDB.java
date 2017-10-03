package com.regres.testdata;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class CommunityDB {
	private static Connection conn;
	private String nameCommunity;

	public CommunityDB(String nameCommunity) {
		this.nameCommunity = nameCommunity;
	}

	public String getNameCommunity() {
		return nameCommunity;
	}

	public void setNameCommunity(String nameCommunity) {
		this.nameCommunity = nameCommunity;
	}

	public static void createCommunityinDB(String nameCommunity)
			throws SQLException, ClassNotFoundException {
		// the mysql insert statement
		String createCommunity = "Insert into registrator_db.territorial_community(name) values (?);";
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(createCommunity);

		// Statement allows you to send inquiries database
		st.setString(1, nameCommunity);
		st.executeUpdate();
	}

}
