package com.regres.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.AdminSettingsPage;
import com.regres.pages.CommissionerHomePage;
import com.regres.pages.LoginPage;
import com.regres.testdata.UserContainer;

/**
 * Tests method's of registering new users functionalities.
 *
 */
public class MethodRegistrationTest {
	private LoginPage loginpage;
	private AdminHomePage adminpage;
	private AdminSettingsPage settings;
	private Application app;
	private CommissionerHomePage comHomePage;
    

	/**
	 * Open browser and login as admin.
	 */
	@BeforeMethod
	public void setUp() {
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		loginpage = app.load();
		adminpage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		settings = adminpage.clickSettings();

	}

	@Test
	public void checkManualRegistered() {
		//verify that after manualRegistration option (Only commissioner can register new co-owner) is selected
		settings = settings.manualRegistration();
		//logout and return to Login page
		loginpage = settings.clickLogout();
		//Verify that Register button isn't displayed on Login page
		Assert.assertFalse(loginpage.checkRegisterButtonExists());
		//login as commissioner
		comHomePage = loginpage.successfullLoginCommissioner(UserContainer.getCommissioner());
		//verify that RegisterNewUser button is displayed on Commissioners Home Page;
		Assert.assertTrue(comHomePage.getRegisterNewUser().isDisplayed());

	}

	@Test
	public void checkPersonalRegistered() {
		//verify that after Personal registration  option is selected
		settings = settings.personalRegistration();
		//logout and return to Login page
		loginpage = settings.clickLogout();
		//Verify that Register button is displayed on Login page
		Assert.assertTrue(loginpage.getRegisterButton().isDisplayed());
		//login as commissioner
		comHomePage = loginpage.successfullLoginCommissioner(UserContainer.getCommissioner());
		//verify that RegisterNewUser button isn't displayed on Commissioners Home Page;
		Assert.assertFalse(comHomePage.checkRegisterNewUserButtonExists());
	}

	@Test
	public void checkMixedRegistered() {
		//verify that after Mixed registration (Both registration method are available) option is selected
		settings = settings.mixedlRegistration();
		//logout and return to Login page
		loginpage = settings.clickLogout();
		//Verify that Register button is displayed on Login page
		Assert.assertTrue(loginpage.getRegisterButton().isDisplayed());
		//login as commissioner
		comHomePage = loginpage.successfullLoginCommissioner(UserContainer.getCommissioner());
		//verify that RegisterNewUser button is displayed on Commissioners Home Page;
		Assert.assertTrue(comHomePage.getRegisterNewUser().isDisplayed());

	}

	@AfterMethod
	public void tearDown() {
		// settings.clickLogout();
		app.quit();
	}

}