package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.pages.TitleLocalFooter.ChangeLanguageFields;
import framework.testdata.User;

public class LoginPage extends TitleLocalFooter {

	
	private WebElement loginLabel;
	private WebElement loginField;
	private WebElement passwordLabel;
	private WebElement passwordField;
	private WebElement rememberMeCheckBox;
	private WebElement rememberMeLabel;
	private WebElement signInButton;
	private WebElement registerButton;
	private WebElement forgotPasswordLink ;
	private WebElement helpLink;
	private WebElement feedbackLink;
	private WebElement errormessage;
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		loginLabel = driver.findElement(By.xpath("//label[@for='inputEmail']"));
		loginField = driver.findElement(By.name("login"));
		passwordLabel = driver.findElement(By.xpath("//label[@for='inputPassword']"));
		passwordField = driver.findElement(By.name("password"));
		rememberMeCheckBox= driver.findElement(By.id("_spring_security_remember_me"));
		rememberMeLabel = driver.findElement(By.xpath("//div[@class='checkbox']/label"));
		signInButton = driver.findElement(By.xpath("//*[@type='submit']"));
		forgotPasswordLink = driver.findElement(By.className("forgot-password"));
		helpLink = driver.findElement(By.xpath("//div[@id='footer']//a[contains(@href,'faq')]"));
		feedbackLink = driver.findElement(By.xpath("//div[@id='footer']//a[contains(@href,'help')]"));
		
	}
	
	public WebElement getLoginLabel() {

		return loginLabel;
	}

	public WebElement getLoginField() {
		return loginField;
	}

	public WebElement getPasswordLabel() {
		return passwordLabel;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}

	public WebElement getRememberMeLabel() {
		return rememberMeLabel;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getHelpLink() {
		return helpLink;
	}

	public WebElement getFeedbackLink() {
		return feedbackLink;
	}
	
	public WebElement getErrorMessage() {
		
		errormessage = driver.findElement(By.xpath("//form[@id='loginForm']/div[contains(@style,'color: red;')]"));
		return errormessage;	
	}
	
	public WebElement getRegisterButton() {
		
		registerButton = driver.findElement(By.xpath("//*[contains(@href,'register')]"));
		return registerButton;
	}
	
	public void checkRememberMeCheckBox() {
		
		if(!rememberMeCheckBox.isSelected()) {
			rememberMeCheckBox.click();
		}
	}
	
	public void unCheckRememberMeCheckBox() {
		
		if(rememberMeCheckBox.isSelected()) {
			rememberMeCheckBox.click();
		}
	}
	
	@Override
	public LoginPage setLanguage(ChangeLanguageFields language) {
		
		Select lang = new Select(getLocalizationDropdown()); 
		lang.selectByVisibleText(language.toString()); 
		return new LoginPage(driver);
	}
	
	public void inputLogin(String login) {
		loginField.sendKeys(login);
	}
	
	public void inputPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void inputLoginClear(String login) {
		
		loginField.clear();
		inputLogin(login);
	}
	
	public void inputPasswordClear(String password) {
		
		passwordField.clear();
		inputPassword(password);
	}
	
	public void signIn(User user) {
		
		inputLoginClear(user.getLogin());
		inputPasswordClear(user.getPassword());
		signInButton.click();
	}
	
	public AdminHomePage successfullLoginAdmin(User validuser){
		
		signIn(validuser);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(loginLabel));
		return new AdminHomePage(driver);
	}
	public RegistratorHomePage successfullLoginRegistrator(User validuser) {
		signIn(validuser);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(loginLabel));
		return new RegistratorHomePage(driver);
		
	
	}
	
	
	public LoginPage unSuccessfullLogin(User invaliduser) {
		
		signIn(invaliduser);
		return new LoginPage(driver);
	}
	
	
	
	
	
	
	
	
}