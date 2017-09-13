package Selenium;

public class User {
	private String first_Name;
	private String last_Name;
	private String email;
	private String login;
	private String password;
	private String confirm_Password;
	private String territorialCommunity;
	private String firstNameErrors;
	private String lastNameErrors;
	private String emailErrors;
	private String loginErrors;
	private String passwordErrors;
	private String confirmPasswordErrors;

	
	public User(String first_Name, String last_Name, String email, String login,
			String password, String confirm_Password, String territorialCommunity, String firstNameErrors,
			String lastNameErrors, String emailErrors, String loginErrors, String passwordErrors,
			String confirmPasswordErrors) {		
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.email = email;
		this.login = login;
		this.password = password;
		this.confirm_Password = confirm_Password;
		this.territorialCommunity = territorialCommunity;
		this.firstNameErrors = firstNameErrors;
		this.lastNameErrors = lastNameErrors;
		this.emailErrors = emailErrors;
		this.loginErrors = loginErrors;
		this.passwordErrors = passwordErrors;
		this.confirmPasswordErrors = confirmPasswordErrors;		
	}


	public String getFirst_Name() {
		return first_Name;
	}


	public String getLast_Name() {
		return last_Name;
	}


	public String getEmail() {
		return email;
	}


	public String getLogin() {
		return login;
	}


	public String getPassword() {
		return password;
	}


	public String getConfirm_Password() {
		return confirm_Password;
	}


	public String getTerritorialCommunity() {
		return territorialCommunity;
	}


	public String getFirstNameErrors() {
		return firstNameErrors;
	}


	public String getLastNameErrors() {
		return lastNameErrors;
	}


	public String getEmailErrors() {
		return emailErrors;
	}


	public String getLoginErrors() {
		return loginErrors;
	}


	public String getPasswordErrors() {
		return passwordErrors;
	}


	public String getConfirmPasswordErrors() {
		return confirmPasswordErrors;
	}


	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}


	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setConfirm_Password(String confirm_Password) {
		this.confirm_Password = confirm_Password;
	}


	public void setTerritorialCommunity(String territorialCommunity) {
		this.territorialCommunity = territorialCommunity;
	}


	public void setFirstNameErrors(String firstNameErrors) {
		this.firstNameErrors = firstNameErrors;
	}


	public void setLastNameErrors(String lastNameErrors) {
		this.lastNameErrors = lastNameErrors;
	}


	public void setEmailErrors(String emailErrors) {
		this.emailErrors = emailErrors;
	}


	public void setLoginErrors(String loginErrors) {
		this.loginErrors = loginErrors;
	}


	public void setPasswordErrors(String passwordErrors) {
		this.passwordErrors = passwordErrors;
	}


	public void setConfirmPasswordErrors(String confirmPasswordErrors) {
		this.confirmPasswordErrors = confirmPasswordErrors;
	}
	
	


//	public static void getInvalidUser1(user) {
//		return user;		
//	}


//	public class User {
//		private WebElement first_Name;
//		private WebElement last_Name;
//		private WebElement email;
//		private WebElement login;
//		private WebElement password;
//		private WebElement confirm_Password;
//		private WebElement territorialCommunity;
//		private WebElement firstNameErrors;
//		private WebElement lastNameErrors;
//		private WebElement emailErrors;
//		private WebElement loginErrors;
//		private WebElement passwordErrors;
//		private WebElement confirmPasswordErrors;
//		private WebDriver driver;
//		
//		public User() {		
//			
//			this.first_Name = driver.findElement(By.id("firstName"));
//			this.last_Name = driver.findElement(By.id("lastName"));;
//			this.email = driver.findElement(By.id("email"));;
//			this.login = driver.findElement(By.id("login"));;
//			this.password = driver.findElement(By.id("password"));;
//			this.confirm_Password = driver.findElement(By.id("confirm_Password"));;
//			this.territorialCommunity = driver.findElement(By.id("territorialCommunity"));;
//			this.firstNameErrors = driver.findElement(By.id("firstNameErrors"));;
//			this.lastNameErrors = driver.findElement(By.id("lastNameErrors"));;
//			this.emailErrors = driver.findElement(By.id("emailErrors"));;
//			this.loginErrors = driver.findElement(By.id("loginErrors"));;
//			this.passwordErrors = driver.findElement(By.id("passwordErrors"));;
//			this.confirmPasswordErrors = driver.findElement(By.id("confirmPasswordErrors"));;		
//		}
}
