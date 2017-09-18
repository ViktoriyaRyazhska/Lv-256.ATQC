package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.testdata.User;

public class LoginPage extends TitleLocalFooter {

	private WebDriver driver;
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
		this.driver=driver;
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
	
	
	

	@Override
	public LoginPage setLanguage(int index) {
		
		Select lang = new Select(getLocalizationDropdown()); 
		lang.selectByIndex(index); 
		return new LoginPage(driver);
	}
	
	
	public void signIn(User user) {
		loginField.clear();
		loginField.sendKeys(user.getLogin());
		passwordField.clear();
		passwordField.sendKeys(user.getPassword());
		signInButton.click();
	}
	
	public AdminHomePage successfullLogin(User validuser){
		
		signIn(validuser);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(loginLabel));
		return new AdminHomePage(driver);
	}
	
	public LoginPage unSuccessfullLogin(User invaliduser) {
		
		signIn(invaliduser);
		return new LoginPage(driver);
	}
	
	public WebElement getErrorMessage() {
		
		errormessage = driver.findElement(By.xpath("//form[@id='loginForm']/div[contains(@style,'color: red;')]"));
		return errormessage;
		
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

	public WebElement getRegisterButton() {
		return registerButton;
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
	
	
}