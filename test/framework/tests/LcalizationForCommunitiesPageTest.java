package framework.tests;

import org.testng.annotations.Test;

import framework.application.Application;
import framework.application.ApplicationSourcesRepo;
import framework.pages.AdminCommunitiesPage;
import framework.pages.AdminHomePage;
import framework.pages.AdminSettingsPage;
import framework.pages.LoadPropertiesFile;
import framework.pages.LoginPage;
import framework.testdata.UserContainer;

import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LcalizationForCommunitiesPageTest extends LoadPropertiesFile {

	private LoginPage loginpage;
	private AdminHomePage adminpage;
	private Application app;
	@BeforeClass
	public void beforeClass() {
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		adminpage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		adminpage.clickCommunities();
	}

	@Test
	public void f() throws IOException {
		String Communities_Label = getObject("Communities_label");
		Assert.assertEquals(AdminCommunitiesPage.getCommunitiesLabelText(), Communities_Label);
		String Add_new_community = getObject("Add_new_community");
		Assert.assertEquals(AdminCommunitiesPage.getAddNewCommunityButtonText(), Add_new_community);

	}

	@AfterClass
	public void afterClass() {
		app.quit();
	}

}
