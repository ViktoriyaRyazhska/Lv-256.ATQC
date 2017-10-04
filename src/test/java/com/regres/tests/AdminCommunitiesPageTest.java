package com.regres.tests;

import org.testng.annotations.Test;
import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.EditCommunityPage;
import com.regres.pages.LoginPage;
import com.regres.testdata.UserContainer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import com.regres.pages.AddNewCommunitiesPage;
import com.regres.pages.AdminCommunitiesPage;

public class AdminCommunitiesPageTest {
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private AdminCommunitiesPage compage;
	private AddNewCommunitiesPage addcompage;
	private EditCommunityPage editpage;
	private String emptyField = "";

	@BeforeClass
	public void setUp() {
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		compage = adminhomepage.clickCommunities();

	}

	@DataProvider
	public Object[][] communityNameAndNumber() {
		return new Object[][] { { "ddddd2", "111:11:11:111:11115" } };
	}
	@DataProvider
	public Object[][] communityNameAndNumber2() {
		return new Object[][] { { "ddddd2", "111:11:11:111:11115" } };
	}

	@DataProvider
	public Object[][] editCommunityNameAndNumber() {
		return new Object[][] { { "ddddd3", "ddddd5", "111:11:11:111:11116", "111:11:11:111:11188" } };
	}
	
	@DataProvider
	public Object[][] incorrectRegNumberData() {
		return new Object[][] { { "aaaaa", "4545" } };
	}
	
	@DataProvider
	public Object[][] RegNumberData() {
		return new Object[][] { { "111:11:11:111:11116" } };
	}

	@Test(dataProvider = "communityNameAndNumber", expectedExceptions = WebDriverException.class)
	public void deleteCreatedCommunitiesAndVerifyPresence(String name, String number) {
		addcompage = compage.clickAddNewCommunityButton();
		compage = addcompage.createNewCommunities(name, number);
		compage = compage.deleteCommunity(name);
		compage.verifyCommunityPresence(name);
	}

	@Test
	public void notActiveCommunitiesAreShownAfterCheckboxClick() {
		compage.clickInactiveCheckbox();
		Assert.assertEquals(compage.verifyNotActiveCommunitiesAreShown(), true);
	}

	@Test(dataProvider = "editCommunityNameAndNumber", expectedExceptions = WebDriverException.class)
	public void editExistedComminities(String name, String name2, String number, String number2) {
		addcompage = compage.clickAddNewCommunityButton();
		compage = addcompage.createNewCommunities(name, number);
		editpage = compage.clickEditOnCreatedCommunity(name);
		compage = editpage.editCreatedCommunities(name2, number2);
		Assert.assertEquals(compage.verifyEditedCommunityPresence(name2), true);
		compage = compage.deleteCommunity(name2);
		compage.verifyEditedCommunityAbsence(name);
	}
	@Test(dataProvider = "incorrectRegNumberData")
	public void regNumberFieldAcceptsOnlyCorrectFormatData(String name, String number) {
		addcompage = compage.clickAddNewCommunityButton();
		addcompage.inputIncorrectDataInRegNumber(name, number);
		Assert.assertTrue(addcompage.getRegError().isDisplayed());
	}
		@Test(dataProvider = "communityNameAndNumber2")
		public void verifyClearFormButton(String name, String number) {
			addcompage = compage.clickAddNewCommunityButton();
			addcompage.fillInNameandRegNumber(name, number);
			addcompage.clickClearFormButton();
			Assert.assertEquals(addcompage.getCommunitiesNameText(), emptyField);
			Assert.assertEquals(addcompage.getRegistrationNumberText(), emptyField);
				}
	
	@Test(dataProvider = "RegNumberData")
	public void verifyCommunityIsNotCreatedWithoutName(String number) {
		addcompage = compage.clickAddNewCommunityButton();
		addcompage.clearNameAndfillIndRegNumber(number);
		addcompage.clickSubmitButton();
		Assert.assertEquals(addcompage.getAddNewCommunitiesPageLabelText(), "Додати нову територіальну громаду");
		
	}
		
	@AfterClass
	public void tearDown() {
		app.quit();
	}

}
