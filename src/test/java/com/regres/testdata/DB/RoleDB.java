package com.regres.testdata.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class RoleDB {
	private String roleName;
	private String roleID;

	public RoleDB(String roleName, String roleID) {
		this.roleName = roleName;
		this.roleID=roleID;
	}

	public String getRoleName() {
		return roleName;
	}
	public String getRoleID() {
		return roleID;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleNameFromDb(Connection conn, RoleDB roleDB) throws SQLException {
		  String selectRole = "select type from registrator_db.roles where type=(?)";
		  PreparedStatement st = (PreparedStatement) conn.prepareStatement(selectRole);
		  st.setString(1, roleDB.getRoleName());
		  ResultSet rs = st.executeQuery();
		  String role = "";
		  
		  if (rs.next()) {
		   // From the result of the query we get the field type_name from the database
			  role = rs.getString("type");
		  }
		  // Close the objects that work with the database
		  rs.close();
		  if (st != null)
		   st.close();
		  return role;
	}
}
