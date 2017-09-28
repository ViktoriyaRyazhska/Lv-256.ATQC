package com.regres.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.AdminSettingsPage;
import com.regres.pages.LoginPage;
import com.regres.pages.OhErrorPage;
import com.regres.testdata.UserContainer;

public class AdminSettingsTimeZoneInvalidData {

	private LoginPage loginpage;
	private AdminHomePage adminpage;
	private AdminSettingsPage settings;

	private Application app;

	@BeforeClass
	public void setUp() {

		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		adminpage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		settings = adminpage.clickSettings();
	}

	@AfterClass
	public void tearDown() {

		settings.clickLogout();
		app.quit();
	}

	@Test
	public void checkInvalidTimeZoneSet() {

		String presetTimeZone = settings.getTimeZoneFieldText();
		OhErrorPage errorPage = settings.setInvalidTimeZone("InvalidData");
		adminpage = errorPage.clickGoToHomePageButton();
		settings = adminpage.clickSettings();
		Assert.assertEquals(settings.getTimeZoneFieldText(), presetTimeZone);
	}

}
