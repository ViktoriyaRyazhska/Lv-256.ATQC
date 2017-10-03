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
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.UnblockAllCoownersMessageLocalization;
import com.regres.testdata.UserContainer;
/**
 * UnblockAllCoowners test 
 * @author Юрій
 *
 */
public class UnblockAllCoownersTest {
	//fields declaration;
	UnblockAllCoownersMessageLocalization localization;
	AdminHomePage adminhomepage;
	Application app;
	// setup test
	@BeforeClass
	public void setUp() {
		// setting up parameters
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		// getting on login page
		LoginPage loginpage = app.load();
		//logging in as admin
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());

	}
// quit after end of tests
	@AfterClass
	public void tearDown() {
		// logging out
		adminhomepage.clickLogout();
		// quiting marionette
		app.quit();
	}
//checking UnblickAllCoowners
	@Test(dataProvider = "langProvider")
	public void checkUnblockAllCoowners(ChangeLanguageFields language, UnblockAllCoownersMessageLocalization localization) {
		//changing localization
		adminhomepage = adminhomepage.setLanguage(language);
		//clicking unblockAllCoowners
		adminhomepage.clickUnblockAllCoowners();
		//asserting succes message
		Assert.assertEquals(adminhomepage.getConfirmMessageUnblockAllCoownersText(), localization.getMessage());
		//clicking ok button
		adminhomepage = adminhomepage.clickOkButtonOnConfirmUnblockAllCoowners();
		adminhomepage = new AdminHomePage(app.getDriver());

	}
//Data provider
	@DataProvider
	public Object[] langProvider() {

		return new Object[][] { { ChangeLanguageFields.UKRAINIAN, localization.UA_MESSAGE },
				{ ChangeLanguageFields.ENGLISH, localization.EN_MESSAGE },
				{ ChangeLanguageFields.RUSSIAN,localization.RU_MESSAGE } };

	}

}
