package com.regres.tests;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AddNewCommunitiesPage2;
import com.regres.pages.AdminCommunitiesPage2;
import com.regres.pages.AdminHomePage;
import com.regres.pages.EditCommunityPage2;
import com.regres.pages.LoginPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;
import com.regres.reports.Reports;
import com.regres.testdata.CommunitiesTable;
import com.regres.testdata.UserContainer;

public class AdminCommunitiesPageTest2 extends Reports {

	String EMPTY_FILED = "";

	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private AdminCommunitiesPage2 compage;
	private AddNewCommunitiesPage2 addcompage;
	private ActiveCoownersActionsDropdown coowActionpage;
	private EditCommunityPage2 editpage;
	SoftAssert softAssert = new SoftAssert();
	private ExtentTest test;
	public static WebDriver driver;

	/** This before class loads our browser */
	@BeforeClass
	public void setUp() {
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
	}

	/**
	 * This before method loads our loginpage, sign in as Admin and navigates to
	 * Communities tab for all tests
	 */
	@BeforeMethod
	public void setBeforeTest() {
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		compage = adminhomepage.clickCommunities();
	}

	/** this data provider is for successful creation of community */
	@DataProvider
	public Object[][] communityNameAndNumber() {
		return new Object[][] { { "ddddd4", "111:11:11:111:11115" } };
	}

	/** this data provider gives correct data for test with editing community */
	@DataProvider
	public Object[][] editCommunityNameAndNumber() {
		return new Object[][] { { "ddddd3", "ddddd8", "111:11:11:111:11116", "111:11:11:111:11188" } };
	}

	/** provides correct community name and incorrect reg number */
	@DataProvider
	public Object[][] incorrectRegNumberData() {
		return new Object[][] { { "aaaaa", "4545" } };
	}

	/** provides correct reg number and language for error message test */
	@DataProvider
	public Object[][] RegNumberData() {
		return new Object[][] { { "111:11:11:111:11116", ChangeLanguageFields.ENGLISH } };
	}

	/** This test verifies that deleted community is not present on the table */
	@Test(dataProvider = "communityNameAndNumber")
	public void deleteCreatedCommunitiesAndVerifyPresence(String communityName, String regNumber) {
		test = report.createTest("deleteCreatedCommunitiesAndVerifyPresence");
		List<CommunitiesTable> expectFilteredUsers = compage.getListOfCommunitiesFromTable();
		test.log(Status.INFO, "Communities table readed");
		addcompage = compage.clickAddNewCommunityButton();
		compage = addcompage.createNewCommunities(communityName, regNumber);
		test.log(Status.INFO, "New Community created");
		compage.deleteCommunity(communityName);
		test.log(Status.INFO, "New Community deleted");
		List<CommunitiesTable> actualFilteredUsers = compage.getListOfCommunitiesFromTable();
		Assert.assertTrue(compage.compareLists(expectFilteredUsers, actualFilteredUsers));
		test.log(Status.PASS, "Verified two lists of Communities");
	}

	/**
	 * this test verifies that if click checkbox not activated communities are
	 * shown in table
	 */
	@Test
	public void notActiveCommunitiesAreShownAfterCheckboxClick() {
		test = report.createTest("notActiveCommunitiesAreShownAfterCheckboxClick");
		compage.clickInactiveCheckbox();
		test.log(Status.INFO, "Inactive Communities checkbox clicked");
		Assert.assertEquals(compage.verifyNotActiveCommunitiesAreShown(), true);
		test.log(Status.PASS, "Verified that not active communities are visible in table");
	}

	/**
	 * this test verifies that it is possible to rename community and correct
	 * data is shown in table
	 */
	@Test(dataProvider = "editCommunityNameAndNumber", expectedExceptions = WebDriverException.class)
	public void editExistedComminities(String communityName, String communityName2, String regNumber,
			String regNumber2) {
		test = report.createTest("editExistedComminities");
		addcompage = compage.clickAddNewCommunityButton();
		compage = addcompage.createNewCommunities(communityName, regNumber);
		test.log(Status.INFO, "Created new Community");
		editpage = compage.clickEditOnCreatedCommunity(communityName);
		compage = editpage.editCreatedCommunities(communityName2, regNumber2);
		test.log(Status.INFO, "Created Community edited");
		softAssert.assertEquals(compage.verifyEditedCommunityPresence(communityName2), true);
		compage.deleteCommunity(communityName2);
		compage.verifyEditedCommunityAbsence(communityName);
		test.log(Status.INFO, "Delete edited community and verify it is not in the table");
		softAssert.assertAll();
		test.log(Status.PASS, "Edited community is present in the table");
	}

	/**
	 * this test verifies that Clear form button clears data in communities
	 * fields
	 */
	@Test(dataProvider = "communityNameAndNumber")
	public void verifyClearFormButton(String communityName, String regNumber) {
		test = report.createTest("verifyClearFormButton");
		addcompage = compage.clickAddNewCommunityButton();
		addcompage.fillInNameandRegNumber(communityName, regNumber);
		test.log(Status.INFO, "Click Edite Community and fill all required fileds");
		addcompage.clickClearFormButton();
		test.log(Status.INFO, "Click Clear the form");
		softAssert.assertEquals(addcompage.getCommunitiesNameText(), EMPTY_FILED);
		softAssert.assertEquals(addcompage.getRegistrationNumberText(), EMPTY_FILED);
		softAssert.assertAll();
		test.log(Status.PASS, "Verify that both fields are empty");
	}

	/**
	 * this test verifies that it's not possible to create community without
	 * name
	 */
	@Test(dataProvider = "RegNumberData")
	public void verifyCommunityIsNotCreatedWithoutName(String regNumber, ChangeLanguageFields language)
			throws IOException {
		test = report.createTest("verifyCommunityIsNotCreatedWithoutName");
		compage.setLanguage(language);
		compage.setLanguageFileToBeLoaded(language);
		test.log(Status.INFO, "Set language");
		addcompage = compage.clickAddNewCommunityButton();
		test.log(Status.INFO, "Click Add community");
		addcompage.clearNameAndfillIndRegNumber(regNumber);
		addcompage.clickSubmitButton();
		test.log(Status.INFO, "Clear name and fill reg number, then submit");
		Assert.assertEquals(addcompage.getAddNewCommunitiesPageLabelText(),
				compage.getLocalizationValue("Add_new_community_label"));
		test.log(Status.PASS, "Verify that community is not created and user stays on the same page");
	}

	/**
	 * this test verifies that reg number field can accept only data of correct
	 * format
	 */
	@Test(dataProvider = "incorrectRegNumberData")
	public void regNumberFieldAcceptsOnlyCorrectFormatData(String communityName, String regNumber) {
		test = report.createTest("regNumberFieldAcceptsOnlyCorrectFormatData");
		addcompage = compage.clickAddNewCommunityButton();
		addcompage.createNewCommunities(communityName, regNumber);
		test.log(Status.INFO, "Create new community");
		Assert.assertTrue(addcompage.getRegError().isDisplayed());
		test.log(Status.PASS, "Verify that error apperas with incorrect format of reg number");
	}

	/**
	 * This test verifies that if community has some member after Admin deletes
	 * it, it becomes Inactive and can be activated later
	 */
	@Test(dataProvider = "communityNameAndNumber", expectedExceptions = WebDriverException.class)
	public void deleteNotActivatedCommunity(String communityName, String regNumber) {
		test = report.createTest("deleteNotActivatedCommunity");
		addcompage = compage.clickAddNewCommunityButton();
		compage = addcompage.createNewCommunities(communityName, regNumber);
		test.log(Status.INFO, "Create new community");
		compage.clickCoowners();
		coowActionpage = compage.clickActiveCoowners();
		test.log(Status.INFO, "Navigate to Active coowners");
		coowActionpage.assignCommunityToFirstUserInRow(communityName);
		test.log(Status.INFO, "Assign created community to coowner");
		compage = adminhomepage.clickCommunities();
		compage.deleteCommunity(communityName);
		compage.refreshAndWait();
		test.log(Status.INFO, "Navigate to Communities page and delete previously created community");
		compage.clickInactiveCheckbox();
		compage.verifyDeletedCommunityPresence(communityName);
		test.log(Status.PASS, "Verify that deleted community is now in Inactive state");
	}

	/** This after method logs out from app */
	@AfterMethod
	public void setAfterMethod() {
		loginpage = app.logout();
	}

	/** This after class quits from app, reports and browser */
	@AfterClass
	public void tearDown() {
		report.flush();
		app.quit();
	}
}
