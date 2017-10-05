package com.regres.tests;

import org.testng.annotations.Test; 
import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.EditCommunityPage;
import com.regres.pages.LoginPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.UserContainer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import com.regres.pages.AddNewCommunitiesPage;
import com.regres.pages.AdminCommunitiesPage;

public class AdminCommunitiesPageTest {

	String EMPTY_FILED = "";

	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private AdminCommunitiesPage compage;
	private AddNewCommunitiesPage addcompage;
	private EditCommunityPage editpage;

	//This before class loads our website and goes to Community page
	@BeforeClass
	public void setUp() {
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		compage = adminhomepage.clickCommunities();
	}

	//this data provider is for successful creation of community
	@DataProvider
	public Object[][] communityNameAndNumber() {
		return new Object[][] { { "ddddd2", "111:11:11:111:11115" } };
	}

	//this data provider gives correct data for test with editing community
	@DataProvider
	public Object[][] editCommunityNameAndNumber() {
		return new Object[][] { { "ddddd3", "ddddd5", "111:11:11:111:11116", "111:11:11:111:11188" } };
	}

	//provides correct community name and incorrect reg number
	@DataProvider
	public Object[][] incorrectRegNumberData() {
		return new Object[][] { { "aaaaa", "4545" } };
	}

	//provides correct reg number and language for error message test
	@DataProvider
	public Object[][] RegNumberData() {
		return new Object[][] { { "111:11:11:111:11116", ChangeLanguageFields.ENGLISH } };
	}

	//this test verifies that after deletion of community it is not present in table
	@Test(dataProvider = "communityNameAndNumber", expectedExceptions = WebDriverException.class)
	public void deleteCreatedCommunitiesAndVerifyPresence(String communityName, String regNumber) {
		addcompage = compage.clickAddNewCommunityButton();
		compage = addcompage.createNewCommunities(communityName, regNumber);
		compage = compage.deleteCommunity(communityName);
		compage.verifyCommunityPresence(communityName);
	}

	//this test verifies that if click checkbox not activated communities are shown in table
	@Test
	public void notActiveCommunitiesAreShownAfterCheckboxClick() {
		compage.clickInactiveCheckbox();
		Assert.assertEquals(compage.verifyNotActiveCommunitiesAreShown(), true);
	}

	//this test verifies that it is possible to rename community and correct data is shown in table
	@Test(dataProvider = "editCommunityNameAndNumber", expectedExceptions = WebDriverException.class)
	public void editExistedComminities(String communityName, String communityName2, String regNumber,
			String regNumber2) {
		addcompage = compage.clickAddNewCommunityButton();
		compage = addcompage.createNewCommunities(communityName, regNumber);
		editpage = compage.clickEditOnCreatedCommunity(communityName);
		compage = editpage.editCreatedCommunities(communityName2, regNumber2);
		Assert.assertEquals(compage.verifyEditedCommunityPresence(communityName2), true);
		compage = compage.deleteCommunity(communityName2);
		compage.verifyEditedCommunityAbsence(communityName);
	}

	//this test verifies that Clear form button clears data in communities fileds
	@Test(dataProvider = "communityNameAndNumber")
	public void verifyClearFormButton(String communityName, String regNumber) {
		addcompage = compage.clickAddNewCommunityButton();
		addcompage.fillInNameandRegNumber(communityName, regNumber);
		addcompage.clickClearFormButton();
		Assert.assertEquals(addcompage.getCommunitiesNameText(), EMPTY_FILED);
		Assert.assertEquals(addcompage.getRegistrationNumberText(), EMPTY_FILED);

	}

	//this test verifies that it's not possible to create community without name
	@Test(dataProvider = "RegNumberData")
	public void verifyCommunityIsNotCreatedWithoutName(String regNumber, ChangeLanguageFields language)
			throws IOException {
		compage = compage.setLanguage(language);
		compage.setLanguageFileToBeLoaded(language);
		addcompage = compage.clickAddNewCommunityButton();
		addcompage.clearNameAndfillIndRegNumber(regNumber);
		addcompage.clickSubmitButton();
		Assert.assertEquals(addcompage.getAddNewCommunitiesPageLabelText(),
				compage.getLocalizationValue("Add_new_community_label"));
	}

	//this test verifies that reg number field can accept only data of correct format
	@Test(dataProvider = "incorrectRegNumberData")
	public void regNumberFieldAcceptsOnlyCorrectFormatData(String communityName, String regNumber) {
		addcompage = compage.clickAddNewCommunityButton();
		addcompage.createNewCommunities(communityName, regNumber);
		Assert.assertTrue(addcompage.getRegError().isDisplayed());
	}

	@AfterClass
	public void tearDown() {
		app.quit();
	}

}
