package com.regres.tests;

import org.testng.annotations.Test;
import com.regres.pages.AdminCommunitiesPage2;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.reports.Reports;
import com.regres.testdata.UserContainer;
import java.io.IOException;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;

public class LocalizationForCommunitiesPageTest2 extends Reports {

	private LoginPage loginpage;
	private AdminHomePage adminpage;
	private Application app;
	private AdminCommunitiesPage2 compage;
	private ExtentTest test;

	/**
	 * This before class loads our loginpage, signs in as Admin and navigates to
	 * Communities tab for all tests
	 */
	@BeforeClass
	public void beforeClass() throws IOException {
		test = report.createTest("LoginPageLocalizationTest");
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		loginpage = app.load();
		test.log(Status.INFO, "Load the app");
		adminpage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		compage = adminpage.clickCommunities();
		test.log(Status.INFO, "Login as Admin and navigate to Communities tab");
	}

	/**
	 * provides us with languages for the localization
	 */
	@DataProvider
	public Object[][] localization() {
		return new Object[][] { { ChangeLanguageFields.ENGLISH }, { ChangeLanguageFields.RUSSIAN },
				{ ChangeLanguageFields.UKRAINIAN } };
	}

	/**
	 * this test verifies all static elements on communities page
	 */
	@Test(dataProvider = "localization")
	public void checkCommunitiesStaticPageLocalization(ChangeLanguageFields language) throws IOException {
		compage = compage.setLanguage(language);
		compage.setLanguageFileToBeLoaded(language);
		test.log(Status.INFO, "Set language to " + language);
		Assert.assertEquals(compage.getCommunitiesLabelText(), compage.getLocalizationValue("Communities_label"));
		test.log(Status.PASS, "Check CommunitiesLabelText");
		Assert.assertEquals(compage.getAddNewCommunityButtonText(), compage.getLocalizationValue("Add_new_community"));
		test.log(Status.PASS, "Check AddNewCommunityButtonText");
		Assert.assertEquals(compage.getDeleteCommunityButtonText(),
				compage.getLocalizationValue("Delete_Community_Button"));
		test.log(Status.PASS, "Check DeleteCommunityButtonText");
		Assert.assertEquals(compage.getEditCommunityButtonText(),
				compage.getLocalizationValue("Edit_Community_Button"));
		test.log(Status.PASS, "Check EditCommunityButtonText");
		Assert.assertEquals(compage.getActionsHeaderText(), compage.getLocalizationValue("Actions_Header_Text"));
		test.log(Status.PASS, "Check ActionsHeaderText");
		Assert.assertEquals(compage.getRegistrationNumberHeaderText(),
				compage.getLocalizationValue("Registration_Number_Header"));
		test.log(Status.PASS, "Check RegistrationNumberHeaderText");
		Assert.assertEquals(compage.getTerritorialCommunityHeaderText(),
				compage.getLocalizationValue("Territorial_Community_Header"));
		test.log(Status.PASS, "Check TerritorialCommunityHeaderText");
		Assert.assertEquals(compage.getInactiveCheckboxLabelText(),
				compage.getLocalizationValue("Inactive_Checkbox_Label"));
		test.log(Status.PASS, "Check InactiveCheckboxLabelText");
	}

	/**
	 * This test verifies activate button localization
	 */
	@Test(dataProvider = "localization")
	public void checkActivateButtonLocalization(ChangeLanguageFields language) throws IOException {
		compage = compage.setLanguage(language);
		compage.setLanguageFileToBeLoaded(language);
		test.log(Status.INFO, "Set language to " + language);
		compage.clickInactiveCheckbox();
		test.log(Status.INFO, "Click show inactive communities");
		Assert.assertEquals(compage.getActiveCommunityButtonText(),
				compage.getLocalizationValue("Active_Community_Button"));
		test.log(Status.PASS, "Check ActiveCommunityButtonText");
	}

	/** This after class quits from reports and browser */
	@AfterClass
	public void afterClass() {
		report.flush();
		app.quit();
	}
}
