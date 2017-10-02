package com.regres.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;
import com.regres.testdata.UserContainer;


public class ActionActiveCoownersTest {
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;

	@BeforeClass
	public void setUp() {
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		adminhomepage.clickCoowners();
	}

	@AfterClass
	public void tearDown() {
		app.quit();
	}

	@DataProvider
	public Object[][] userChange() {
		return new Object[][] { { "a", "a", "a123", "Ukraine", "Commissioner" } };
	}

	/**
	 * Check appearing of message when no one row is selected
	 */
	 @Test
	public void checkConfirmMessageSetCommunity() {
		ActiveCoownersActionsDropdown actions = adminhomepage.clickActiveCoowners();
		actions.clickActionsDropdown();
		actions.clickSetCommunityNotSelected();
		Assert.assertEquals(actions.confirm.getConfirmMessageText(),
				"Для виконання даної операції спочатку потрібно вибрати співвласників, натиснувши на відповідні стрічки в таблиці");
		actions.confirm.clickCloseButton();
	}
	
	/**
	 * Check that role changes
	 */
	@Test
	public void checkSetRole() {
		ActiveCoownersActionsDropdown actions = adminhomepage.clickActiveCoowners();
		actions.getFirstNameColumn();
		actions.clickActionsDropdown();
		actions.clickSetRole();
		actions.clickCoownerRole();
		actions.confirm.clickOkButton();
		Assert.assertEquals(actions.getRoleColumnText(), "Співвласник");
	}
}
