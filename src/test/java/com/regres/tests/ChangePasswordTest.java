package com.regres.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.ChangePasswordPage;
import com.regres.pages.DropdownHomePageImpl;
import com.regres.pages.LoginPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.ChangePasswordPageLocalization;
import com.regres.testdata.User;
import com.regres.testdata.UserContainer;
/**
 * ChangePassword Tests
 * @author Юрій
 *
 */
public class ChangePasswordTest {
	//fields declaration
	ChangePasswordPageLocalization localization;
	AdminHomePage adminhomepage;
	ChangePasswordPage changePasswordPage;
	LoginPage loginpage;
	DropdownHomePageImpl dropdownHomePage;
	// initializing of temporary users
	User user = UserContainer.getRegistrator();
	User newUser = UserContainer.getRegistrator();
	private Application app;

	// setup test
	@BeforeClass
	public void setUp() {
		// setting up parameters
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		// getting on login page
		loginpage = app.load();
		// loging in as Registrator and redirecting for changePassword page
		changePasswordPage = loginpage.successfullLoginRegistrator(user).clickChangePassword();
		;

	}

	// quit after end of tests
	@AfterClass
	public void tearDown() {
		// logging out
		changePasswordPage.clickLogout();
		// quiting marionette
		app.quit();
	}

	// checking wrongpassword
	@Test(dataProvider = "WrongPassword")
	public void checkWrongPasswordMessage(ChangeLanguageFields language, ChangePasswordPageLocalization localization) {
		// setting language
		changePasswordPage = changePasswordPage.setLanguage(language);
		// changing password with wrong password parameter
		changePasswordPage.getWrongPasswordMessage(UserContainer.getRegistrator().getPassword());
		// asserting error message
		Assert.assertEquals(changePasswordPage.getMessageText(), localization.getMessage());
		// reinitializing page
		changePasswordPage = new ChangePasswordPage(app.getDriver());

	}

	// checking wrongNewPassowr
	@Test(dataProvider = "WrongNewPassword")
	public void checkWrongNewPasswordMessage(ChangeLanguageFields language,
			ChangePasswordPageLocalization localization) {
		// setting language
		changePasswordPage = changePasswordPage.setLanguage(language);
		// changing password with wrong new password parameter
		changePasswordPage.getWrongNewPasswordMessage(UserContainer.getRegistrator().getPassword());
		// asserting error message
		Assert.assertEquals(changePasswordPage.getMessageText(), localization.getMessage());
		// reinitializing page
		changePasswordPage = new ChangePasswordPage(app.getDriver());

	}

	// checking wrongConfirmPassword
	@Test(dataProvider = "WrongConfirmPassword")
	public void checkWrongConfirmPasswordMessage(ChangeLanguageFields language,
			ChangePasswordPageLocalization localization) {
		// setting language
		changePasswordPage = changePasswordPage.setLanguage(language);
		// changing password with wrong confirm password parameter
		changePasswordPage.getWrongConfirmMessage(UserContainer.getRegistrator().getPassword());
		// asserting error message
		Assert.assertEquals(changePasswordPage.getMessageText(), localization.getMessage());
		// reinitializing page
		changePasswordPage = new ChangePasswordPage(app.getDriver());

	}

	// checking cancel button
	@Test
	public void checkCancelButton() {
		// clicking cancelButton on changePasswordPage
		dropdownHomePage = changePasswordPage.clickCancelButton();
		// logging out
		loginpage = dropdownHomePage.clickLogout();
		// logging in as registrator
		changePasswordPage = loginpage.successfullLoginRegistrator(user).clickChangePassword();
		// checking if logged in as registrator
		Assert.assertEquals(changePasswordPage.getUserName().getText(), user.getLogin());

	}

	// checking ok button clicking
	@Test(dataProvider = "Succes")
	public void checkOkButton(ChangeLanguageFields language, ChangePasswordPageLocalization localization) {
		// setting language
		changePasswordPage = changePasswordPage.setLanguage(language);
		// changing password with valid parameters
		dropdownHomePage = changePasswordPage.getSuccesMessage(user.getPassword());
		// asserting succes message
		Assert.assertEquals(dropdownHomePage.getMessageText(), localization.getMessage());
		// clicking on dropdown menu
		dropdownHomePage.clickMenuDownButton();
		// redirecting on changePassword page
		changePasswordPage = dropdownHomePage.changePassword();

	}

	// checking emptyFields message
	@Test
	public void checkEmptyFieldsMessage() {
		// changing password with empty fields
		changePasswordPage.getEmptyFieldsMessage();
		// asserting error message
		Assert.assertEquals(changePasswordPage.getEmptyFieldMessageText(),
				localization.EMPTY_FIELDS_MESSAGE.getMessage());
		// reinitializing page
		changePasswordPage = new ChangePasswordPage(app.getDriver());
	}

	// checking logging in with new passowrd
	@Test
	public void checkNewPassword() {
		// changing password
		dropdownHomePage = changePasswordPage.setNewPassword(user.getPassword());
		// setting password in temporary user
		newUser.setPassword(changePasswordPage.getPassword());
		// logging out
		loginpage = dropdownHomePage.clickLogout();
		// logging in with new password
		changePasswordPage = loginpage.successfullLoginRegistrator(newUser).clickChangePassword();
		// checking if logged in as registrator
		Assert.assertEquals(changePasswordPage.getUserName().getText(), user.getLogin());
		// changing password to old one
		dropdownHomePage = changePasswordPage.returnOldPassword(newUser.getPassword());
		// clicking on dropdown menu
		dropdownHomePage.clickMenuDownButton();
		// redirecting to changePassword page
		changePasswordPage = dropdownHomePage.changePassword();
		// reinitializing page
		changePasswordPage = new ChangePasswordPage(app.getDriver());

	}

	// Data Providers
	@DataProvider(name = "WrongPassword")
	public Object[] wrongProvider() {

		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, localization.UA_WRONG_PASSWORD },
				{ ChangeLanguageFields.ENGLISH, localization.EN_WRONG_PASSWORD },
				{ ChangeLanguageFields.RUSSIAN, localization.RU_WRONG_PASSWORD } };

	}

	@DataProvider(name = "WrongNewPassword")
	public Object[] wrongNewProvider() {

		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, localization.UA_WRONG_NEW_PASSWORD },
				{ ChangeLanguageFields.ENGLISH, localization.EN_WRONG_NEW_PASSWORD },
				{ ChangeLanguageFields.RUSSIAN, localization.RU_WRONG_NEW_PASSWORD } };

	}

	@DataProvider(name = "WrongConfirmPassword")
	public Object[] wrongConfirmProvider() {

		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, localization.UA_WRONG_CONFIRM_PASSWORD },
				{ ChangeLanguageFields.ENGLISH, localization.EN_WRONG_CONFIRM_PASSWORD },
				{ ChangeLanguageFields.RUSSIAN, localization.RU_WRONG_CONFIRM_PASSWORD } };

	}

	@DataProvider(name = "Succes")
	public Object[] succesProvider() {
		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, localization.UA_SUCCES_MESSAGE },
				{ ChangeLanguageFields.ENGLISH, localization.EN_SUCCES_MESSAGE },
				{ ChangeLanguageFields.RUSSIAN, localization.RU_SUCCES_MESSAGE } };

	}

}
