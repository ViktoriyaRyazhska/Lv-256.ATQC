package framework.testdata;

public class UserContainer {

	private static User user= new User();
	
	
	
	
	public static User getAdmin() {
		
		return user.setLogin("admin").setPassword("admin");
	}
	
	public static User getRegistrator() {
		
		return user.setLogin("registrator").setPassword("registrator");
	}
	
	public static User getCommisioner() {
		
		return user.setLogin("qwerty").setPassword("qwerty");
	}
	
	public static User getInvalidData() {
		
		return user.setLogin("%^/?!").setPassword("%^/?!");
	}
	
	public User setUser(String login, String password) {
		
		return user.setLogin(login).setPassword(password);
	}

}
