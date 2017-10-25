package com.regres.tests;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.ResourcesSearchPage;
import com.regres.pages.ResourcesTable;
import com.regres.pages.SearchResourcesByParameters;
import com.regres.testdata.UserContainer;

public class SearchResourcesByParametersTest {
	// fields declaration
	private Application app;
	private LoginPage loginpage;
	private RegistratorHomePage reghomepage;
	private ResourcesSearchPage search;
	private SearchResourcesByParameters res;

	@BeforeClass
	public void setUp() {
		// start application with firefox browser
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		// app =
		// Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		// go to login page
		loginpage = app.load();
		// login as registrator
		reghomepage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());	
	}
	
	@Test
	public void firstTest(){
		search = reghomepage.clickResourcesSearch();
		res = search.clickSearchByParameterButton();
		res.selectItalyResources();
		res.clickSearchButton();
		//List<ResourcesTable> table = res.getListOfResourcesFromTable();
		
	
	}
	
	@AfterClass
	public void tearDown() {
		//res.clickLogout();
		app.quit();
	}

}
