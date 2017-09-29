package com.regres.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.pages.manage.coowners.actions.InactiveCoownersActionsDropdown;
import com.regres.pages.manage.coowners.actions.InactiveCoownersActionsDropdown.LoginPageL10n;
import com.regres.testdata.UserContainer;

public class InactiveCoownersActionsDropdownTest {
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private CoownersTable coownerstable;
	private InactiveCoownersActionsDropdown inactivecoowners;
	private ChangeLanguageFields language;

	@BeforeTest
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
	
	@Factory(dataProvider = "L10N")
	public InactiveCoownersActionsDropdownTest(ChangeLanguageFields language) {
		this.language = language;
		
		app = app.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		coownerstable = adminhomepage.goToInactiveCoowners();
		inactivecoowners = coownerstable.goToInactiveCoowners();
		inactivecoowners = inactivecoowners.setLanguage(language);
	}
	

	@Test
	// this test verify that when in action dropdown by clicking on 'Set as Active'
	// link confirm message appears when not chosen co owner
	public void checkClickOnSetActiveMessageAppearsWhenNotChosenCoowner() {
		inactivecoowners.clickActionsDropdown();
		inactivecoowners.clickUnblock();
		assertEquals(inactivecoowners.getConfirmMessage().getConfirmMessageText(),
				LoginPageL10n.CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER.getLocalization(language));
		inactivecoowners.getConfirmMessage().clickCloseButton();
	}

	@Test
	// this test verify that when in action dropdown by clicking on 'Block' link
	// confirm message appears when not chosen co-owner
	public void checkClickOnBlockMessageAppearsWhenNotChosenCoowner() {
		inactivecoowners.clickActionsDropdown();
		inactivecoowners.clickBlock();
		assertEquals(inactivecoowners.getConfirmMessage().getConfirmMessageText(),
				LoginPageL10n.CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER.getLocalization(language));
		inactivecoowners.getConfirmMessage().clickCloseButton();
	}

	@Test
	// this test verify that when in action dropdown by clicking on 'Set community'
	// link confirm message appears when not chosen co-owner
	public void checkClickOnSetCommunityMessageAppearsWhenNotChosenCoowner() {
		inactivecoowners.clickActionsDropdown();
		inactivecoowners.clickSetCommunityButNotSelectedCoowners();
		assertEquals(inactivecoowners.getConfirmMessage().getConfirmMessageText(),
				LoginPageL10n.CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER.getLocalization(language));
		inactivecoowners.getConfirmMessage().clickCloseButton();
	}

	@DataProvider(name = "L10N")
	public static Object[] localizationProvider() {
		return new Object[][] { { ChangeLanguageFields.UKRAINIAN }, { ChangeLanguageFields.ENGLISH },
				{ ChangeLanguageFields.RUSSIAN } };
	}

}
