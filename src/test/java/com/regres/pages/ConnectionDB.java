package com.regres.pages;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDB {
	private static Connection con = null;
	private static String username = "root";
	private static String password = "1234567890";
	private static String URL = "jdbc:mysql://localhost:3306/registrator_db";

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// Load the driver
		con = DriverManager.getConnection(URL, username, password);
		// connect
		if (con != null)
			System.out.println("Connection Successful! \n");
		if (con == null)
			System.exit(0);
		Statement st = con.createStatement();
		// Statement allows you to send inquiries database
		ResultSet rs = st.executeQuery("select resource_type_id, type_name from resource_types where type_name='Sidney'");
		// ResultSet gets the result table
		int x = rs.getMetaData().getColumnCount();
		// Resultset.getMetaData () get the information
		// output file
		List<ResourceTypes> list = new ArrayList<ResourceTypes>();
		ResourceTypes r = new ResourceTypes();
		while (rs.next()) {
			for (int i = 1; i <= x; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			r.setId(Integer.parseInt(rs.getString("resource_type_id")));
			r.setTypeName(rs.getString("type_name"));
			list.add(r);
			System.out.println();
		}
		System.out.println();
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (con != null)
			con.close();

		System.out.println(list);
	}

	public static class ResourceTypes {
		int Id;
		String TypeName;

		public void setId(int id) {
			Id = id;
		}

		public void setTypeName(String typeName) {
			TypeName = typeName;
		}

	}
}
