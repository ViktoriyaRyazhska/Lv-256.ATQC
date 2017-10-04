package com.regres.tests;

import org.testng.annotations.Test;
import com.regres.pages.AdminCommunitiesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.UserContainer;
import java.io.IOException;

public class LocalizationForCommunitiesPageTest {

	private LoginPage loginpage;
	private AdminHomePage adminpage;
	private Application app;
	private AdminCommunitiesPage compage;
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws IOException {
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		loginpage = app.load();
		adminpage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		compage = adminpage.clickCommunities();
	}

	@DataProvider
	public Object[][] localization() {
		return new Object[][] { { ChangeLanguageFields.ENGLISH }, { ChangeLanguageFields.RUSSIAN },
				{ ChangeLanguageFields.UKRAINIAN } };
	}

	@Test(dataProvider = "localization")
	public void checkCommunitiesStaticPageLocalization(ChangeLanguageFields language) throws IOException {
		compage = compage.setLanguage(language);
		compage.loadLocalizationFile(language);
		Assert.assertEquals(compage.getCommunitiesLabelText(), compage.getObject("Communities_label"));
		Assert.assertEquals(compage.getAddNewCommunityButtonText(), compage.getObject("Add_new_community"));
		Assert.assertEquals(compage.getDeleteCommunityButtonText(), compage.getObject("Delete_Community_Button"));
		Assert.assertEquals(compage.getEditCommunityButtonText(), compage.getObject("Edit_Community_Button"));
		Assert.assertEquals(compage.getActionsHeaderText(), compage.getObject("Actions_Header_Text"));
		Assert.assertEquals(compage.getRegistrationNumberHeaderText(), compage.getObject("Registration_Number_Header"));
		Assert.assertEquals(compage.getTerritorialCommunityHeaderText(),compage.getObject("Territorial_Community_Header"));
		Assert.assertEquals(compage.getInactiveCheckboxLabelText(), compage.getObject("Inactive_Checkbox_Label"));
	}

	@Test(dataProvider = "localization")
	public void checkActivateButtonLocalization(ChangeLanguageFields language) throws IOException {
		compage = compage.setLanguage(language);
		compage.loadLocalizationFile(language);
		compage.clickInactiveCheckbox();
		Assert.assertEquals(compage.getActiveCommunityButtonText(), compage.getObject("Active_Community_Button"));
	}

	@AfterClass
	public void afterClass() {
		app.quit();
	}

}
