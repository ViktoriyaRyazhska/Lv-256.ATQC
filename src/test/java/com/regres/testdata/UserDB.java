package com.regres.testdata;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class UserDB {
	private String account_non_expired;
	private String account_non_locked;
	private String attempts;

	private String credentials_non_expired;
	private String date_of_accession;
	private String email;
	private String enabled;
	private String first_Name;
	private String last_modified;
	private String last_Name;
	private String locked_till;
	private String login;
	private String middle_name;
	private String password;
	private String phonenumber;
	private String status;
	private String role_id;
	private String territorialCommunity_id;

	private Connection conn;

	public UserDB(String account_non_expired, String account_non_locked, String attempts,
			String credentials_non_expired, String date_of_accession, String email, String enabled, String first_Name,
			String last_modified, String last_Name, String locked_till, String login, String middle_name,
			String password, String phonenumber, String status, String role_id, String territorialCommunity_id) {
		this.account_non_expired = account_non_expired;
		this.account_non_locked = account_non_locked;
		this.attempts = attempts;
		this.credentials_non_expired = credentials_non_expired;
		this.date_of_accession = date_of_accession;
		this.email = email;
		this.enabled = enabled;
		this.first_Name = first_Name;
		this.last_modified = last_modified;
		this.last_Name = last_Name;
		this.locked_till = locked_till;
		this.login = login;
		this.middle_name = middle_name;
		this.password = password;
		this.phonenumber = phonenumber;
		this.status = status;
		this.role_id = role_id;
		this.territorialCommunity_id = territorialCommunity_id;
	}

	public String getAccount_non_expired() {
		return account_non_expired;
	}

	public String getAccount_non_locked() {
		return account_non_locked;
	}

	public String getAttempts() {
		return attempts;
	}

	public String getCredentials_non_expired() {
		return credentials_non_expired;
	}

	public String getDate_of_accession() {
		return date_of_accession;
	}

	public String getEmail() {
		return email;
	}

	public String getEnabled() {
		return enabled;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public String getLast_modified() {
		return last_modified;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public String getLocked_till() {
		return locked_till;
	}

	public String getLogin() {
		return login;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public String getPassword() {
		return password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getStatus() {
		return status;
	}

	public String getRole_id() {
		return role_id;
	}

	public String getTerritorialCommunity_id() {
		return territorialCommunity_id;
	}

	public void setAccount_non_expired(String account_non_expire) {
		this.account_non_expired = account_non_expired;
	}

	public void setAccount_non_locked(String account_non_locked) {
		this.account_non_locked = account_non_locked;
	}

	public void setAttempts(String attempts) {
		this.attempts = attempts;
	}

	public void setCredentials_non_expired(String credentials_non_expired) {
		this.credentials_non_expired = credentials_non_expired;
	}

	public void setDate_of_accession(String date_of_accession) {
		this.date_of_accession = date_of_accession;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public void setLast_modified(String last_modified) {
		this.last_modified = last_modified;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public void setLocked_till(String locked_till) {
		this.locked_till = locked_till;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public void setTerritorialCommunity_id(String territorialCommunity_id) {
		this.territorialCommunity_id = territorialCommunity_id;
	}

	// Method for creating new Use in DD
	public void createUserInDB(Connection conn, UserDB userDB) throws SQLException, ClassNotFoundException {
		String createUser = "Insert into registrator_db.users (account_non_expired,account_non_locked,attempts,credentials_non_expired,date_of_accession,email,enabled,first_name,last_modified,last_name,locked_till,login,middle_name,password,phonenumber,status,role_id,territorialCommunity_id)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(createUser);

		// Statement allows to send inquiries database
		st.setString(1, userDB.getAccount_non_expired());
		st.setString(2, userDB.getAccount_non_locked());
		st.setString(3, userDB.getAttempts());
		st.setString(4, userDB.getCredentials_non_expired());
		st.setString(5, userDB.getDate_of_accession());
		st.setString(6, userDB.getEmail());
		st.setString(7, userDB.getEnabled());
		st.setString(8, userDB.getFirst_Name());
		st.setString(9, userDB.getLast_modified());
		st.setString(10, userDB.getLast_Name());
		st.setString(11, userDB.getLocked_till());
		st.setString(12, userDB.getLogin());
		st.setString(13, userDB.getMiddle_name());
		st.setString(14, userDB.getPassword());
		st.setString(15, userDB.getPhonenumber());
		st.setString(16, userDB.getStatus());
		st.setString(17, userDB.getRole_id());
		st.setString(18, userDB.getTerritorialCommunity_id());
		st.executeUpdate();
		st.close();
	}

	public void deleteUserInDB(Connection conn, UserDB userDB) throws SQLException, ClassNotFoundException {
		String deleteUser = "Delete from registrator_db.users where login=(?)";
		PreparedStatement st = (PreparedStatement) conn.prepareStatement(deleteUser);
		st.setString(1, userDB.getLogin());
		st.executeUpdate();
	}

	
}