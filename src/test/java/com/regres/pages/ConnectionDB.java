package com.regres.pages;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;

public class ConnectionDB {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		// create a mysql Database connection
		Application application = Application.get(ApplicationSourcesRepo.getChromeLocalApplicationDb());
				
		// DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		// Load the driver
		Connection con = application.createDBConnection();
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
		
		application.closeConnectionDB();

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
