package com.regres.tests;

import org.testng.annotations.BeforeClass;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.CoownersElementsOnPageDropdown;
import com.regres.testdata.UserContainer;

public class SearchResourcesByParametersTest {
	// fields declaration
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private CoownersElementsOnPageDropdown elements;

	@BeforeClass
	public void setUp() {
		// start application with firefox browser
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		// app =
		// Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		// go to login page
		loginpage = app.load();
		// login as administrator
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		
	}

}
