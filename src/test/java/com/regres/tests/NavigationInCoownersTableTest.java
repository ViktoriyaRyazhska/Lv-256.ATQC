package com.regres.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.CoownersElementsOnPageDropdown;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;
import com.regres.testdata.UserContainer;

public class NavigationInCoownersTableTest {
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private CoownersElementsOnPageDropdown elements;
	// private CoownersTable coownerstable;

	@BeforeMethod
	public void setUp() {
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		// app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
	}

	@Test
	public void dropdownTenTest() {
		elements = adminhomepage.selectNonConfirmedCoowners();
		elements.selectTenElementsOnPage();
		Assert.assertEquals(elements.getElementsInfoText(), "10 із 50");
	}

	@Test
	public void dropdownTwentyFiveTest() {
		elements = adminhomepage.selectNonConfirmedCoowners();
		elements.selectTwentyFiveElementsOnPage();
		Assert.assertEquals(elements.getElementsInfoText(), "25 із 50");
	}

	@Test
	public void dropdownFiftyTest() {
		elements = adminhomepage.selectNonConfirmedCoowners();
		elements.selectFiftyElementsOnPage();
		Assert.assertEquals(elements.getElementsInfoText(), "50 із 50");
	}
	@Test
	public void previousNextButtoneTest() {
		elements = adminhomepage.selectNonConfirmedCoowners();
		elements.selectTwentyFiveElementsOnPage();
		elements.clickNextButton();
		Assert.assertEquals(elements.getElementsInfoText(), "50 із 50");
		elements.clickPreviousButton();
		Assert.assertEquals(elements.getElementsInfoText(),  "25 із 50");
	}
	@Test
public void paginateTest() {
		elements = adminhomepage.selectNonConfirmedCoowners();
		elements.selectFiftyElementsOnPage();
		elements.clickPageFour();
		Assert.assertEquals(elements.getElementsInfoText(),  "40 із 50");
		elements.clickPageTwo();
		Assert.assertEquals(elements.getElementsInfoText(),  "20 із 50");
	}
	@AfterMethod
	public void tearDown() {
	elements.clickLogout();
		app.quit();
	}
}