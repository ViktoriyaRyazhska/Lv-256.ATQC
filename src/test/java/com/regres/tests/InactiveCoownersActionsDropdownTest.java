package com.regres.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.manage.coowners.actions.InactiveCoownersActionsDropdown;
import com.regres.pages.manage.coowners.actions.InactiveCoownersActionsDropdown.LoginPageL10n;
import com.regres.testdata.UserContainer;

public class InactiveCoownersActionsDropdownTest {
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private InactiveCoownersActionsDropdown inactivecoowners;
	
	@DataProvider(name = "L10N")
	public static Object[] localizationProvider() {
		return new Object[][] {
			{ ChangeLanguageFields.UKRAINIAN },
			{ ChangeLanguageFields.ENGLISH },
			{ ChangeLanguageFields.RUSSIAN } };
	}

	@BeforeClass
	public void setUp() {
		app = app.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		inactivecoowners = adminhomepage.goToInactiveCoowners();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		app.quit();
	}
	
	@Test(dataProvider = "L10N")
	// this test verify that when in actions dropdown by clicking on 'Set as Active'
	// link confirm message appears when not chosen co owner
	public void checkClickUnblockWhenNotChosenCoowner(ChangeLanguageFields language) {
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
	public void checkClickBlockWhenNotChosenCoowner(ChangeLanguageFields language) {
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
	public void checkClickSetCommunityWhenNotChosenCoowner(ChangeLanguageFields language) {
		inactivecoowners = inactivecoowners.setLanguage(language);
		inactivecoowners.clickActionsDropdown();
		inactivecoowners.clickSetCommunityButNotSelectedCoowners();
		assertEquals(inactivecoowners.getConfirmMessage().getConfirmMessageText(),
				LoginPageL10n.CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER.getLocalization(language));
		inactivecoowners.getConfirmMessage().clickCloseButton();
	}
	
	@Test(dataProvider = "L10N")
	// this test verify that when in action dropdown by clicking on 'Set community'
	// link confirm message appears when not chosen co-owner
	public void checkL10NClickSetCommunity(ChangeLanguageFields language) {
		inactivecoowners = inactivecoowners.setLanguage(language);
		inactivecoowners.search("co_owner");
		inactivecoowners.clickFirstRow();
		inactivecoowners.clickActionsDropdown();
		inactivecoowners.clickSetCommunity();
		assertEquals(inactivecoowners.getConfirmMessage().getTitleMessageText(),
				LoginPageL10n.TITLE_SET_COMMUNITY_CONFIRM_MESSAGE.getLocalization(language));
		assertEquals(inactivecoowners.getConfirmMessage().getLabelText(),
				LoginPageL10n.LABEL_SET_COMMUNITY_CONFIRM_MESSAGE.getLocalization(language));
		assertEquals(inactivecoowners.getConfirmMessage().getOkButtonText(),
				LoginPageL10n.CONFIRM_SET_COMMUNITY_CONFIRM_MESSAGE.getLocalization(language));
        assertEquals(inactivecoowners.getConfirmMessage().getCancelButtonText(),
        		LoginPageL10n.CANCEL_SET_COMMUNITY_CONFIRM_MESSAGE.getLocalization(language));
		inactivecoowners.getConfirmMessage().clickOkButton();
		inactivecoowners.simpleConfirmMessage();
		assertEquals(inactivecoowners.getConfirmMessage().getOkButtonText(),
				LoginPageL10n.OK.getLocalization(language));
        assertEquals(inactivecoowners.getConfirmMessage().getConfirmMessageText(),
        		LoginPageL10n.NOT_BE_EMPTY_SET_COMMUNITY_CONFIRM_MESSAGE.getLocalization(language));
        inactivecoowners.getConfirmMessage().clickOkButton();
	}
}
