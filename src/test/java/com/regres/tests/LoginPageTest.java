package com.regres.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.CommissionerHomePage;
import com.regres.pages.CoownerHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.reports.Reports;
import com.regres.testdata.UserContainer;

/**
 * Tests login page's main functionalities.
 * 
 * @author PETYAggg
 *
 */
public class LoginPageTest extends Reports {

	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private CommissionerHomePage commissionerhomepage;
	private RegistratorHomePage registratorhomepage;
	private CoownerHomePage coownerhomepage;
	private ExtentTest test;

	/**
	 * Opens browser and login page.
	 */
	@BeforeClass
	public void setUp() {
		app = app.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());

	}

	/**
	 * Opens login page.
	 */
	@BeforeMethod
	public void goToLoginPage() {
		loginpage = app.load();
	}

	/**
	 * Getting test result and writing it to report
	 * 
	 * @param result
	 *            - object with test results
	 */
	@AfterMethod(alwaysRun = true)
	public void reportresults(ITestResult result) {
		getResult(result, test);
		
		if (result.getStatus() == ITestResult.FAILURE) {
			loginpage = app.logout();
		}
	}

	/**
	 * Closes the browser.
	 */
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		app.quit();

	}

	/**
	 * Checks if administrator can log in.
	 */
	@Test
	public void checkValidLoginAdmin() {
		test = report.createTest("CheckValidLoginAdmin");
		
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		test.log(Status.INFO, "Signed in");
		
		Assert.assertEquals(adminhomepage.getUserNameText(), UserContainer.getAdmin().getLogin());
		test.log(Status.PASS, "Checked if the right page is opened.");
		
		loginpage = adminhomepage.clickLogout();
		test.log(Status.INFO, "Signed off");
	}

	/**
	 * Checks if commissioner can log in.
	 */
	@Test
	public void checkValidLoginCommissioner() {
		test = report.createTest("CheckValidLoginCommissioner");
		
		commissionerhomepage = loginpage.successfullLoginCommissioner(UserContainer.getCommissioner());
		test.log(Status.INFO, "Signed in");
		
		Assert.assertEquals(commissionerhomepage.getUserNameText(), UserContainer.getCommissioner().getLogin());
		test.log(Status.PASS, "Checked if the right page is opened.");
		
		loginpage = commissionerhomepage.clickLogout();
		test.log(Status.INFO, "Signed off");
	}

	/**
	 * Checks if registrator can log in.
	 */
	@Test
	public void checkValidLoginRegistrator() {
		test = report.createTest("CheckValidLoginRegistrator");
		
		registratorhomepage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
		test.log(Status.INFO, "Signed in");
		
		Assert.assertEquals(registratorhomepage.getUserNameText(), UserContainer.getRegistrator().getLogin());
		test.log(Status.PASS, "Checked if the right page is opened.");
		
		loginpage = registratorhomepage.clickLogout();
		test.log(Status.INFO, "Signed off");
	}

	/**
	 * Checks that user with invalid credentials can't log in. Checks if error
	 * message appears.
	 */
	@Test(priority = 1)
	public void checkInvalidLogin() {
		test = report.createTest("CheckInvalidLogin");
		
		loginpage = loginpage.setLanguage(ChangeLanguageFields.ENGLISH);
		test.log(Status.INFO, "Set language");
		
		loginpage = loginpage.unSuccessfullLogin(UserContainer.getInvalidData());
		test.log(Status.INFO, "Filled in invalid credentials and clicked 'Sig in'");
		
		Assert.assertTrue(loginpage.getErrorMessage().getText().contains("Wrong login or password"));
		test.log(Status.PASS, "Verified error message is correct");
	}

}
