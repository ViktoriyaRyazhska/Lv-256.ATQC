package framework.testdata;

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

		return new User().setLogin("admin").setPassword("admin");
	}

	/**
	 * 
	 * @return Instance of class User with Registrator's credentials
	 */
	public static User getRegistrator() {

		return new User().setLogin("registrator").setPassword("registrator");
	}

	/**
	 * 
	 * @return Instance of class User with Co-owner's credentials
	 */
	public static User getCoowner() {

		return new User().setLogin("qwerty").setPassword("qwerty");
	}

	/**
	 * 
	 * @return Instance of class User with Commissioner credentials
	 */
	public static User getCommissioner() {

		return new User().setLogin("a123").setPassword("qwerty");
	}

	/**
	 * 
	 * @return Instance of class User with invalid credentials.
	 */
	public static User getInvalidData() {

		return new User().setLogin("%^/?!").setPassword("%^/?!");
	}

	/**
	 * Creates User by given parameters.
	 * 
	 * @param login
	 *            Login name of desired User
	 * @param password
	 *            Password of desired User
	 * @return Instance of class User with credentials given in parameters.
	 */
	public User setUser(String login, String password) {

		return new User().setLogin(login).setPassword(password);
	}

}
