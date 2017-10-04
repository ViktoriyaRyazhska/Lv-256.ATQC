
package com.regres.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.LoginPage;
import com.regres.pages.LoginPage.LoginPageL10n;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.reports.Reports;

/**
 * Tests localization of the login page.
 * 
 * @author PETYAggg
 *
 */
public class LoginPageLocalizationTest extends Reports {

	private Application app;
	private LoginPage loginpage;
	private ExtentTest test;

	/**
	 * Open browser. Open login page.
	 */
	@BeforeClass
	public void setUp() {
		test = report.createTest("LoginPageLocalizationTest");
		test.log(Status.INFO, "Opening browser.");
		app = app.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		test.log(Status.INFO, "Opening 'Login' page");
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
	}

	/**
	 * Close the browser.
	 */
	@AfterClass
	public void tearDown() {
		test.log(Status.INFO, "Closing browser.");
		app.quit();
	}

	/**
	 * Languages to be tested.
	 */
	@DataProvider
	public Object[][] localization() {
		return new Object[][] { { ChangeLanguageFields.RUSSIAN }, { ChangeLanguageFields.UKRAINIAN },
				{ ChangeLanguageFields.ENGLISH } };
	}

	/**
	 * Verifies that labels labels on our page have appropriate spelling. Al the
	 * values are compared to the enum, specified in the LoginPage class.
	 * 
	 * @param language
	 *            - current language.
	 */
	@Test(dataProvider = "localization")
	public void checkLoginPageLocalization(ChangeLanguageFields language) {
		
		test.log(Status.INFO, "Setting language to " + language);
		loginpage = loginpage.setLanguage(language);
		
		Assert.assertEquals(loginpage.getTitleText(), LoginPageL10n.TITLE_LABEL.getLocalization(language));
		test.log(Status.PASS, "Checked title label spelling.");
		
		Assert.assertEquals(loginpage.getFooterText(), LoginPageL10n.FOOTER_LABEL.getLocalization(language));
		test.log(Status.PASS, "Checked footer label spelling.");
		
		Assert.assertEquals(loginpage.getLoginLabelText(), LoginPageL10n.LOGIN_LABEL.getLocalization(language));
		test.log(Status.PASS, "Checked login label spelling.");
		
		Assert.assertEquals(loginpage.getPasswordLabelText(), LoginPageL10n.PASSWORD_LABEL.getLocalization(language));
		test.log(Status.PASS, "Checked password label spelling.");
		
		Assert.assertEquals(loginpage.getSignInButtonText(), LoginPageL10n.SUBMIT_BUTTON.getLocalization(language));
		test.log(Status.PASS, "Checked sign in button label spelling.");
		
		Assert.assertEquals(loginpage.getForgotPasswordLinkText(),
				LoginPageL10n.FORGOT_PASSWORD_LINK.getLocalization(language));
		test.log(Status.PASS, "Checked forgot password link label spelling.");

	}
	
	@AfterSuite(alwaysRun = true)
	public void getREPORT() {
		report.flush();
	}

}
