package com.regres.testdata;

/**
 * This class was designed to easily return users with particular role. By using
 * this class you can return the instance of class User. Available roles:
 * -Administrator -Commissioner -Registrator -Co-Owner
 * 
 * @author PETYAggg
 *
 */
public class UserContainer {

	/**
	 * 
	 * @return Instance of class User with Admin's credentials
	 */
	public static User getAdmin() {
		
		return  User.get().setLogin("admin").setPassword("admin").build();
	}

	/**
	 * 
	 * @return Instance of class User with Registrator's credentials
	 */
	public static User getRegistrator() {

		return User.get().setLogin("registrator").setPassword("registrator").build();
	}

	/**
	 * 
	 * @return Instance of class User with Co-owner's credentials
	 */
	public static User getCoowner() {

		return User.get().setLogin("qwerty").setPassword("qwerty").build();
	}

	/**
	 * 
	 * @return Instance of class User with Commissioner credentials
	 */
	public static User getCommissioner() {

		return User.get().setLogin("a123").setPassword("qwerty").build();
	}

	/**
	 * 
	 * @return Instance of class User with invalid credentials.
	 */
	public static User getInvalidData() {

		return User.get().setLogin("%^/?!").setPassword("%^/?!").build();
	}

	

}
