package com.regres.testdata;

public class User {

	private String login;
	private String password;

	public User() {
	}

	public String getLogin() {
		return login;
	}

	public User setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

}