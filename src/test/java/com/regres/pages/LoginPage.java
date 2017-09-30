package com.regres.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regres.testdata.User;

/**
 * Class representation of a Login page.
 * @author PETYAggg
 *
 */
public class LoginPage extends TitleLocalFooter {
	
	private WebElement loginLabel;
	private WebElement loginField;
	private WebElement passwordLabel;
	private WebElement passwordField;
	private WebElement rememberMeCheckBox;
	private WebElement rememberMeLabel;
	private WebElement signInButton;
	private WebElement registerButton;
	private WebElement forgotPasswordLink;
	private WebElement helpLink;
	private WebElement feedbackLink;
	private WebElement errormessage;
	
	String LOGIN_LABEL_XPATH = "//label[@for='inputEmail']";
	String LOGIN_FIELD_NAME = "login";
	String PASSWORD_LABEL_XPATH = "//label[@for='inputPassword']";
	String PASSWORD_FIELD_NAME = "password";
	String REMEMBER_ME_CHECKBOX_ID = "_spring_security_remember_me";
	String REMEMBER_ME_LABEL_XPATH= "//div[@class='checkbox']/label";
	String SIGN_IN_BUTTON_XPATH = "//*[@type='submit']";
	String FORGOT_PASSWORD_LINK_CLASSNAME = "forgot-password";
	String HELP_LINK_XPATH = "//div[@id='footer']//a[contains(@href,'faq')]";
	String FEEDBACK_LINK_XPATH = "//div[@id='footer']//a[contains(@href,'help')]";
	String REGISTER_BUTTON_XPATH = "//*[contains(@href,'register')]";
	String ERROR_MESSAGE_XPATH = "//form[@id='loginForm']/div[contains(@style,'color: red;')]";

	public LoginPage(WebDriver driver) {

		super(driver);
		loginLabel = driver.findElement(By.xpath(LOGIN_LABEL_XPATH));
		loginField = driver.findElement(By.name(LOGIN_FIELD_NAME));
		passwordLabel = driver.findElement(By.xpath(PASSWORD_LABEL_XPATH ));
		passwordField = driver.findElement(By.name(PASSWORD_FIELD_NAME));
		rememberMeCheckBox = driver.findElement(By.id(REMEMBER_ME_CHECKBOX_ID));
		rememberMeLabel = driver.findElement(By.xpath(REMEMBER_ME_LABEL_XPATH));
		signInButton = driver.findElement(By.xpath(SIGN_IN_BUTTON_XPATH));
		forgotPasswordLink = driver.findElement(By.className(FORGOT_PASSWORD_LINK_CLASSNAME));
		helpLink = driver.findElement(By.xpath(HELP_LINK_XPATH));
		feedbackLink = driver.findElement(By.xpath(FEEDBACK_LINK_XPATH));

	}

	// getters
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

	public String getLoginLabelText() {
		return loginLabel.getText().trim();
	}

	public String getPasswordLabelText() {
		return passwordLabel.getText().trim();
	}

	public String getSignInButtonText() {
		return signInButton.getText().trim();
	}

	public String getRememberMeLabelText() {
		return rememberMeLabel.getText().trim();
	}

	public String getForgotPasswordLinkText() {
		return forgotPasswordLink.getText().trim();
	}

	/**
	 * Initializes errormessage field and returns it.
	 */
	public WebElement getErrorMessage() {
		errormessage = driver.findElement(By.xpath(ERROR_MESSAGE_XPATH));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(errormessage));
		return errormessage;
	}

	/**
	 * Initializes registerbutton field and returns it.
	 */
	public WebElement getRegisterButton() {

		registerButton = driver.findElement(By.xpath(REGISTER_BUTTON_XPATH ));
		return registerButton;
	}
	
	/**
	 * Verifies if register button is present on the LoginPage
	 * @return True - if register button is present.
	 * @return False - if register button is NOT present.
	 */
	public boolean checkRegisterButtonExists() {
		 return !driver.findElements(By.xpath(REGISTER_BUTTON_XPATH)).isEmpty();
	}

	/**
	 * Checks 'Remember me' checkbox.
	 * If it is already checked, does nothing.
	 */
	public void checkRememberMeCheckBox() {

		if (!rememberMeCheckBox.isSelected()) {
			rememberMeCheckBox.click();
		}
	}

	/**
	 * Unchecks 'Remember me' checkbox.
	 * If it is already unchecked, does nothing.
	 */
	public void unCheckRememberMeCheckBox() {

		if (rememberMeCheckBox.isSelected()) {
			rememberMeCheckBox.click();
		}
	}

	/**
	 * Sets the language for the app
	 */
	@Override
	public LoginPage setLanguage(ChangeLanguageFields language) {

		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		return new LoginPage(driver);
	}

	/**
	 * Fills login field with given value
	 * @param login - value to be set.
	 */
	public void inputLogin(String login) {
		loginField.sendKeys(login);
	}

	/**
	 * Fills password field with given value
	 * @param password - value to be set.
	 */
	public void inputPassword(String password) {
		passwordField.sendKeys(password);
	}

	/**
	 * Clears login field and fills it with given value.
	 * @param login - value to be set.
	 */
	public void inputLoginClear(String login) {

		loginField.clear();
		inputLogin(login);
	}

	/**
	 * Clears password field and fills it with given value.
	 * @param password - value to be set.
	 */
	public void inputPasswordClear(String password) {

		passwordField.clear();
		inputPassword(password);
	}

	/**
	 * Signs in to the application.
	 * @param user - credentials for sign in.
	 */
	private void signIn(User user) {

		inputLoginClear(user.getLogin());
		inputPasswordClear(user.getPassword());
		signInButton.click();
	}

	/**
	 * Signs in as Administrator
	 * @param validuser - valid credentials for administrator.
	 * @return new AdminHomePage.
	 */
	public AdminHomePage successfullLoginAdmin(User validuser) {

		signIn(validuser);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(loginLabel));
		return new AdminHomePage(driver);
	}

	/**
	 * Signs in as Registrator
	 * @param validuser - valid credentials for Registrator.
	 * @return new RegistratorHomePage.
	 */
	public RegistratorHomePage successfullLoginRegistrator(User validuser) {

		signIn(validuser);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(loginLabel));
		return new RegistratorHomePage(driver);
	}

	/**
	 * Signs in as Commissioner
	 * @param validuser - valid credentials for commissioner.
	 * @return new CommissionerHomePage.
	 */
	public CommissionerHomePage successfullLoginCommissioner(User validuser) {

		signIn(validuser);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(loginLabel));
		return new CommissionerHomePage(driver);
	}
	
	/**
	 * Signs in as Coowner
	 * @param validuser - valid credentials for coowner.
	 * @return new CoownerHomePage.
	 */
	public CoownerHomePage successfullLoginCoowner(User validuser) {

		signIn(validuser);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(loginLabel));
		return new CoownerHomePage(driver);
	}

	/**
	 * Unsuccesfull login attempt.
	 * @param invaliduser - invalid credentials
	 * @return LoginPage with error message.
	 */
	public LoginPage unSuccessfullLogin(User invaliduser) {

		signIn(invaliduser);
		return new LoginPage(driver);
	}

	/**
	 * This enum is made for further localization testing.
	 * Has text of each label on the page in every available language.
	 * @author PETYAggg
	 *
	 */
	public static enum LoginPageL10n {
		LOGIN_LABEL("Логін", "Логин", "Login"), PASSWORD_LABEL("Пароль", "Пароль", "Password"), SUBMIT_BUTTON("Увійти",
				"Войти", "Sign in"), REMEMBER_ME_LABEL("Запам'ятати мене", "Запомнить меня",
						"Remember me"), FORGOT_PASSWORD_LINK("Забули пароль?", "Забыли пароль?",
								"Forgot the password?"), TITLE_LABEL(
										"Децентралізований майновий реєстрприродних ресурсів України",
										"Децентрализированный имущественный реестрприродных ресурсов Украины",
										"Decentralized registry ofUkrainian natural resources"), FOOTER_LABEL(
												"©2017 ІТ Академія Софтсерв", "©2017 ИТ Академия Софтсерв",
												"©2017 Softserve IT Academy");
		
		private HashMap<ChangeLanguageFields, String> field; // is different for every language.

		private LoginPageL10n(String... localization) {
			this.field = new HashMap<ChangeLanguageFields, String>(); 
			int i = 0;
			for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
				this.field.put(language, localization[i]); //initialization of the field HashMap(sets all values for current language)
				i++;
			}
		}

		public String getLocalization(ChangeLanguageFields language) {
			return this.field.get(language).trim();
		}
	}

}