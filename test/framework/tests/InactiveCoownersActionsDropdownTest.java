package framework.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.application.Application;
import framework.application.ApplicationSourcesRepo;
import framework.pages.AdminHomePage;
import framework.pages.LoginPage;
import framework.pages.TitleLocalFooter.ChangeLanguageFields;
import framework.pages.coowners.actions.CoownersTable;
import framework.pages.coowners.actions.InactiveCoownersActionsDropdown;
import framework.pages.coowners.actions.InactiveCoownersActionsDropdown.LoginPageL10n;
import framework.testdata.UserContainer;

public class InactiveCoownersActionsDropdownTest {
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private CoownersTable coownerstable;
	private InactiveCoownersActionsDropdown inactivecoowners;

	@BeforeClass
	public void setUp() {
		app = app.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		coownerstable = adminhomepage.goToInactiveCoowners();
		inactivecoowners = coownerstable.goToInactiveCoowners();

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		app.quit();
	}

	@Test(dataProvider = "L10N")
	// this test verify that when in action dropdown by clicking on 'Set as Active'
	// link confirm message appears when not chosen co owner
	public void checkClickOnSetActiveMessageAppearsWhenNotChosenCoowner(ChangeLanguageFields language) {
		inactivecoowners = inactivecoowners.setLanguage(language);
		inactivecoowners.clickActionsDropdown();
		inactivecoowners.clickUnblock();
		assertEquals(inactivecoowners.getConfirmMessage().getConfirmMessageText(),
				LoginPageL10n.CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER.getLocalization(language));
		inactivecoowners.getConfirmMessage().clickCloseButton();
	}

	@Test(dataProvider = "L10N")
	// this test verify that when in action dropdown by clicking on 'Block' link
	// confirm message appears when not chosen co-owner
	public void checkClickOnBlockMessageAppearsWhenNotChosenCoowner(ChangeLanguageFields language) {
		inactivecoowners = inactivecoowners.setLanguage(language);
		inactivecoowners.clickActionsDropdown();
		inactivecoowners.clickBlock();
		assertEquals(inactivecoowners.getConfirmMessage().getConfirmMessageText(),
				LoginPageL10n.CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER.getLocalization(language));
		inactivecoowners.getConfirmMessage().clickCloseButton();
	}

	@Test(dataProvider = "L10N")
	// this test verify that when in action dropdown by clicking on 'Set community'
	// link confirm message appears when not chosen co-owner
	public void checkClickOnSetCommunityMessageAppearsWhenNotChosenCoowner(
			ChangeLanguageFields language) {
		inactivecoowners = inactivecoowners.setLanguage(language);
		inactivecoowners.clickActionsDropdown();
		inactivecoowners.clickSetCommunityButNotSelectedCoowners();
		assertEquals(inactivecoowners.getConfirmMessage().getConfirmMessageText(),
				LoginPageL10n.CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER.getLocalization(language));
		inactivecoowners.getConfirmMessage().clickCloseButton();
	}

	@DataProvider(name = "L10N")
	public Object[] localizationProvider() {
		return new Object[][] { 
			{ ChangeLanguageFields.UKRAINIAN }, 
			{ ChangeLanguageFields.ENGLISH },
			{ ChangeLanguageFields.RUSSIAN } 
		};
	}

}
