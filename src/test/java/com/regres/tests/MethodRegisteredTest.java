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

public class MethodRegisteredTest {
		private LoginPage loginpage;
		private AdminHomePage adminpage;
		private AdminSettingsPage settings;
		private Application app;
		private CommissionerHomePage comHomePage;

		@BeforeMethod
		public void setUp() {
			app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
			loginpage = app.load();
			adminpage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
			settings = adminpage.clickSettings();

		}
			

		@Test
		public void checkManualRegistered() {
			settings = settings.manualRegistration();
			settings.clickLogout();
			Assert.assertNull(loginpage.getRegisterButton().isDisplayed());
		}
		
	//	@Test
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
		

		@AfterMethod
		public void tearDown() {
			// settings.clickLogout();
			app.quit();
		}


}
