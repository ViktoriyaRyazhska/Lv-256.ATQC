package com.regres.tests;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.testdata.UserContainer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;



import org.testng.annotations.AfterClass;

public class ActionActiveSetCommunityTest {

	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;

	
	@BeforeTest
	public void setUp() {
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
//		adminhomepage.clickCoowners();
//		adminhomepage.getCommunities().click();
//		System.out.println(adminhomepage.getCommunities());
	}


	@AfterClass
	public void tearDown() {
		app.quit();
	}
	
//	  @Test(dataProvider = "dp")
	  public void checkCommunity(Boolean n, String s) {
		  
	  }

	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }

}
