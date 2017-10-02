package com.regres.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import com.regres.testdata.User;
import com.regres.testdata.UserContainer;



public class ChangePasswordTest {
	private WebDriver driver ;
	private String baseURL;
	AdminHomePage adminhomepage;
	ChangePasswordPage changePasswordPage;
	User user = UserContainer.getRegistrator();
	LoginPage loginpage;
	DropdownHomePageImpl dropdownHomePage ;
	private Application app;
		
		
	

	@BeforeClass
	public void setUp() {
		
		/*System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseURL = "http://localhost:8080/resources/";
		driver.get(baseURL);*/
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuLocalhost());
		loginpage = app.load();
		changePasswordPage = loginpage.successfullLoginRegistrator(user).clickChangePassword();;

	}

	@AfterClass
	public void tearDown() {
		changePasswordPage.clickLogout();
		driver.close();
	}

	@Test(dataProvider = "WrongPassword")
	public void checkWrongPasswordMessage(ChangeLanguageFields language, String message) {
		changePasswordPage = changePasswordPage.setLanguage(language);
		changePasswordPage.getWrongPasswordMessage(UserContainer.getRegistrator().getPassword());
		Assert.assertEquals(changePasswordPage.getMessageText(), message);
		changePasswordPage = new ChangePasswordPage(driver);

	}
	@Test(dataProvider = "WrongNewPassword")
	public void checkWrongNewPasswordMessage(ChangeLanguageFields language, String message) {
		changePasswordPage = changePasswordPage.setLanguage(language);
		changePasswordPage.getWrongNewPasswordMessage(UserContainer.getRegistrator().getPassword());
		Assert.assertEquals(changePasswordPage.getMessageText(), message);
		changePasswordPage = new ChangePasswordPage(driver);

	}
	@Test(dataProvider = "WrongConfirmPassword")
	public void checkWrongConfirmPasswordMessage(ChangeLanguageFields language, String message) {
		changePasswordPage = changePasswordPage.setLanguage(language);
		changePasswordPage.getWrongConfirmMessage(UserContainer.getRegistrator().getPassword());
		Assert.assertEquals(changePasswordPage.getMessageText(), message);
		changePasswordPage = new ChangePasswordPage(driver);

	}
	
	@Test
	public void checkCancelButton() {
		dropdownHomePage = changePasswordPage.clickCancelButton();
		loginpage = dropdownHomePage.clickLogout();
		changePasswordPage= loginpage.successfullLoginRegistrator(user).clickChangePassword();
		Assert.assertEquals(changePasswordPage.getUserName().getText(), user.getLogin());
		
		
	}
	@Test(dataProvider = "Succes")
	public void checkOkButton(ChangeLanguageFields language, String message) {
		changePasswordPage = changePasswordPage.setLanguage(language);
		dropdownHomePage = changePasswordPage.getSuccesMessage(user.getPassword());
		Assert.assertEquals(dropdownHomePage.getMessageText(), message);
		dropdownHomePage.clickMenuDownButton();
		changePasswordPage=dropdownHomePage.changePassword();
		
	}
	@Test
	public void checkEmptyFieldsMessage() {
		changePasswordPage.getEmptyFieldsMessage();
		Assert.assertEquals(changePasswordPage.getEmptyFieldMessageText(),"Заполните это поле.");
		changePasswordPage = new ChangePasswordPage(driver);
	}
	
	

	@DataProvider(name="WrongPassword")
	public Object[] langProvider() {

		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, "Неправильний пароль" },
				{ ChangeLanguageFields.ENGLISH, "Wrong password" },
				{ ChangeLanguageFields.RUSSIAN, "Неправильний пароль" } };

	}
	@DataProvider(name="WrongNewPassword")
	public Object[] lang_Provider() {

		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, "Введіть коректний пароль [a-zA-Z0-9].{6,20}" },
				{ ChangeLanguageFields.ENGLISH, "Incorrect password [a-zA-Z0-9].{6,20}" },
				{ ChangeLanguageFields.RUSSIAN, "Введите корректный пароль [a-zA-Z0-9].{6,20}" } };

	}
	@DataProvider(name="WrongConfirmPassword")
	public Object[] lang1Provider() {

		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, "Підтвердження паролю неправильне" },
				{ ChangeLanguageFields.ENGLISH, "Bad confirmation" },
				{ ChangeLanguageFields.RUSSIAN, "Подтверждение пароля неправильное" } };

	}
	
	@DataProvider(name="Succes")
	public Object[] lang2Provider() {
		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, "Пароль успішно змінено" },
				{ ChangeLanguageFields.ENGLISH, "Your password has been successfully updated" },
				{ ChangeLanguageFields.RUSSIAN, "Пароль успешно изменен" } };

	}

}
