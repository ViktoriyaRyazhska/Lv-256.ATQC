package com.regres.tests;

import java.util.List;

import org.testng.Assert;
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
		// go to login page
		loginpage = app.load();
		// login as registrator
		reghomepage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
		search = reghomepage.clickResourcesSearch();
		res = search.clickSearchByParameterButton();
	}

	@Test
	public void perimeterTest() {
		res.selectPerimeterEquals();
		res.setPerimeter("45");
		res.clickSearchButton();
		List<ResourcesTable> table = res.getListOfResourcesFromTable();
		String field = res.getFirstElement(table).getIdentificator();
		Assert.assertEquals(field, "000:10:00:111:10000:1010");
	}

	@Test
	public void areaTest() {
		res.selectAreaEquals();
		res.setArea("100");
		res.clickSearchButton();
		List<ResourcesTable> table = res.getListOfResourcesFromTable();
		String field = res.getFirstElement(table).getIdentificator();
		Assert.assertEquals(field, "000:10:00:111:10000:1010");
	}

	@Test
	public void perimeterAreaTest() {
		res.selectPerimeterEquals();
		res.setPerimeter("45");
		res.selectAreaEquals();
		res.setArea("100");
		res.clickSearchButton();
		List<ResourcesTable> table = res.getListOfResourcesFromTable();
		String field = res.getFirstElement(table).getIdentificator();
		Assert.assertEquals(field, "000:10:00:111:10000:1010");
	}

	@Test
	public void perimeterAreaLessTest() {
		res.selectPerimeterLess();
		res.setPerimeter("45");
		res.selectAreaLess();
		res.setArea("100");
		res.clickSearchButton();
		List<ResourcesTable> table = res.getListOfResourcesFromTable();
		String field = res.getFirstElement(table).getIdentificator();
		Assert.assertEquals(field, "000:10:00:111:10111:1010");
	}

	@Test
	public void perimeterAreaGreaterTest() {
		res.selectPerimeterGreater();
		res.setPerimeter("45");
		res.selectAreaGreater();
		res.setArea("100");
		res.clickSearchButton();
		List<ResourcesTable> table = res.getListOfResourcesFromTable();
		String field1 = res.getFirstElement(table).getIdentificator();
		String field5 = res.getFiveElement(table).getIdentificator();
		String fieldLast = res.getLastElement(table).getIdentificator();
		Assert.assertEquals(field1, "000:10:00:111:10111:1450");
		Assert.assertEquals(field5, "011:10:00:111:10111:9990");
		Assert.assertEquals(fieldLast, "210:10:00:210:38067/3:0001");
	}

	@Test
	public void perimeterGreaterAreaLessTest() {
		res.selectPerimeterGreater();
		res.setPerimeter("45");
		res.selectAreaLess();
		res.setArea("100");
		res.clickSearchButton();
		List<ResourcesTable> table = res.getListOfResourcesFromTable();
		String field1 = res.getFirstElement(table).getIdentificator();
		String fieldLast = res.getLastElement(table).getIdentificator();
		Assert.assertEquals(field1, "000:10:00:111:10000:1011");
		Assert.assertEquals(fieldLast, "111:22:33:444:55555:6666");
	}
	

	@AfterClass
	public void tearDown() {
		res.clickLogout();
		app.quit();
	}

}
