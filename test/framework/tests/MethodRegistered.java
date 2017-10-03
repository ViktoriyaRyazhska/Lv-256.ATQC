package framework.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.application.Application;
import framework.application.ApplicationSourcesRepo;
import framework.pages.AdminHomePage;
import framework.pages.AdminSettingsPage;
import framework.pages.CommissionerHomePage;
import framework.pages.LoginPage;
import framework.testdata.UserContainer;

public class MethodRegistered {

	private LoginPage loginpage;
	private AdminHomePage adminpage;
	private AdminSettingsPage settings;
	private Application app;
	private CommissionerHomePage comHomePage;

	//@BeforeMethod
	public void setUp() {

		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		loginpage = app.load();
		adminpage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		settings = adminpage.clickSettings();

	}

	//@Test
	public void checkManualRegistered() {
		settings = settings.manualRegistration();
		settings.clickLogout();
		Assert.assertNull(loginpage.getRegisterButton().isDisplayed());
	}
	
	//@Test
	public void checkPersonalRegistered() {
		settings = settings.personalRegistration();
		settings.clickLogout();

		Assert.assertTrue(loginpage.getRegisterButton().isDisplayed());
		
		comHomePage = loginpage.successfullLoginCommissioner(UserContainer.getCommissioner());

		Assert.assertTrue(comHomePage.getRegisterNewUser().isDisplayed());
	}

	 //@Test
	public void checkMixedRegistered() {
		settings = settings.mixedlRegistration();
		settings.clickLogout();
		Assert.assertTrue(loginpage.getRegisterButton().isDisplayed());
		
	}
	@Test
	public void checkPersonalRegisterNew() {
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		loginpage = app.load();
		comHomePage = loginpage.successfullLoginCommissioner(UserContainer.getCommissioner());

		Assert.assertTrue(comHomePage.getRegisterNewUser().isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		// settings.clickLogout();
		app.quit();
	}

}