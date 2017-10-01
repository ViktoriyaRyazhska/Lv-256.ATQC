package com.regres.testdata;

public class UserDB {
	
	private String date_of_accession;
	private String email;	
	private String enabled;
	private String first_Name;
	private String last_Name;
	private String login;
	private String password;
	private String status;
	private String role_id;
	private String territorialCommunity_id;

	public UserDB(String date_of_accession, String email, String enabled, String first_Name, String last_Name, String login,
			String password, String status, String role_id, String territorialCommunity_id) {
		super();
		this.date_of_accession = date_of_accession;
		this.email = email;
		this.enabled = enabled;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.login = login;
		this.password = password;
		this.status = status;
		this.role_id = role_id;
		this.territorialCommunity_id = territorialCommunity_id;
	}
	
	public String getLogin() {
		return login;
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

	public String getLast_Name() {
		return last_Name;
	}

	public String getPassword() {
		return password;
	}

	public String getTerritorialCommunity_id() {
		return territorialCommunity_id;
	}

	public String getStatus() {
		return status;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	public void setDate_of_accession(String date_of_accession) {
		this.date_of_accession = date_of_accession;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTerritorialCommunity_id(String territorialCommunity_id) {
		this.territorialCommunity_id = territorialCommunity_id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

}
	

