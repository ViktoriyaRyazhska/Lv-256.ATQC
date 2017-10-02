package com.regres.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.CommissionerHomePage;
import com.regres.pages.CoownerHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.UserContainer;

/**
 * Tests login page's main functionalities.
 * @author PETYAggg
 *
 */
public class LoginPageTest {

	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private CommissionerHomePage commissionerhomepage;
	private RegistratorHomePage registratorhomepage;
	private CoownerHomePage coownerhomepage;

	/**
	 * Open browser and login page.
	 */
	@BeforeClass
	public void setUp() {
		app = app.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
	}

	/**
	 * Close the browser.
	 */
	@AfterClass
	public void tearDown() {
		app.quit();
	}

	/**
	 * Checks if administrator can log in.
	 */
	@Test
	public void checkValidLoginAdmin() {

		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		Assert.assertEquals(adminhomepage.getUserNameText(), UserContainer.getAdmin().getLogin());
		loginpage = adminhomepage.clickLogout();
	}
	
	/**
	 * Checks if commissioner can log in.
	 */
	@Test
	public void checkValidLoginCommissioner() {

		commissionerhomepage = loginpage.successfullLoginCommissioner(UserContainer.getCommissioner());
		Assert.assertEquals(commissionerhomepage.getUserNameText(), UserContainer.getCommissioner().getLogin());
		loginpage = commissionerhomepage.clickLogout();
	}
	
	/**
	 * Checks if registrator can log in.
	 */
	@Test
	public void checkValidLoginRegistrator() {

		registratorhomepage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
		Assert.assertEquals(registratorhomepage.getUserNameText(), UserContainer.getRegistrator().getLogin());
		loginpage = registratorhomepage.clickLogout();
	}

	/**
	 * Checks that user with invalid credentials can't log in.
	 * Checks if error message appears.
	 */
	@Test(priority=1)
	public void checkInvalidLogin() {
		loginpage = loginpage.setLanguage(ChangeLanguageFields.ENGLISH);
		loginpage = loginpage.unSuccessfullLogin(UserContainer.getInvalidData());
		Assert.assertTrue(loginpage.getErrorMessage().getText().contains("Wrong login or password"));

	}

}
