package com.regres.tests;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.Reporter;
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
	}

	@AfterClass
	public void tearDown() {
		app.quit();
	}

	@DataProvider
	public Object[][] userChange() {
		return new Object[][] { { "a", "a", "a123", "Ukraine", "Commissioner" } };
	}

	@Test
	public void checkConfirmMessageSetCommunity() {
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		adminhomepage.clickCoowners();
		ActiveCoownersActionsDropdown actions = adminhomepage.clickActiveCoowners();

		actions.clickActionsDropdown();
		actions.clickSetCommunityNotSelected();
		Assert.assertEquals(actions.confirm.getConfirmMessageText(),
				"Для виконання даної операції спочатку потрібно вибрати співвласників, натиснувши на відповідні стрічки в таблиці");
		 actions.confirm.clickCloseButton();
		// adminhomepage.clickLogout();
	}

	/**
	 * Check the presents of confirm message when no user is selected
	 */
	// @Test
	public void checkConfirmMessageResetPassword() {
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		adminhomepage.clickCoowners();
		AdminHomePage adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		adminhomepage.clickCoowners();
		ActiveCoownersActionsDropdown activeActions = adminhomepage.clickActiveCoowners();
		activeActions.clickActionsDropdown();

		activeActions.clickResetPassword();
		Assert.assertEquals(activeActions.confirm.getConfirmMessageText(),
				"Для виконання даної операції спочатку потрібно вибрати співвласників, натиснувши на відповідні стрічки в таблиці");
		activeActions.confirm.clickOkButton();
		activeActions.clickLogout();
	}

	@DataProvider
	public Object[][] userForChange() {
		return new Object[][] { { "registrator1", "Ukraine", "Co-owner" } };
	}

	// @Test(dataProvider = "userForChange")
	public void checkUserChangeCommunity() {
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		adminhomepage.clickCoowners();
		AdminHomePage adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		adminhomepage.clickCoowners();

		ActiveCoownersActionsDropdown activeActions = adminhomepage.clickActiveCoowners();
		activeActions.clickActionsDropdown();

		activeActions.clickSetCommunity();
		Assert.assertEquals(activeActions.confirm.getConfirmMessageText(),
				"Для виконання даної операції спочатку потрібно вибрати співвласників, натиснувши на відповідні стрічки в таблиці");
		activeActions.confirm.clickOkButton();
		activeActions.clickLogout();
	}

}
