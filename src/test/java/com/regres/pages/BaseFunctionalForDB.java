package com.regres.pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;

/**
 * The class that provides the basic functionality for working with the database
 */
public class BaseFunctionalForDB {

	/**
	 * Method which takes Connection for the database and the name "Subclass of
	 * objects" Method returns a record from the database if it finds such a record
	 * otherwise empty tape
	 */

	public String getSubclassNameFromDb(Connection conn, String name) throws SQLException {
		String verifyValue = "select type_name from registrator_db.resource_types where type_name=(?)";
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(verifyValue);
		// Insert the query instead of the question mark parameters
		st.setString(1, name);
		// Request is executed
		ResultSet rs = st.executeQuery();
		String typeName = "";
		if (rs.next()) {
			// From the result of the query we get the field type_name from the database
			typeName = rs.getString("type_name");
		}
		// Close the objects that work with the database
		rs.close();
		if (st != null)
			st.close();

		return typeName;

	}

}
