package com.regres.testdata;

/**
 * This class is made for the Login Page tests.
 * User has two fields : login and password.
 * Instances of this class are stored in UserContainer class.
 * @author PETYAggg
 *
 */
public class User implements Login,Password,BuildUser,IUser{

	private String login;
	private String password;

	private User() {
	}

	public static Login get() {
		
		return new User();
	}
	
	public String getLogin() {
		return login;
	}

	public Password setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public BuildUser setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public User build() {
		
		return this;
	}

}