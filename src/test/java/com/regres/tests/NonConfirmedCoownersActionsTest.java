package com.regres.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.GoogleEmailPage;
import com.regres.pages.LoginPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.manage.coowners.actions.NonConfirmedCoownersActionsDropdown;
import com.regres.pages.manage.coowners.actions.NonConfirmedCoownersActionsDropdown.LoginPageL10n;
import com.regres.testdata.GoogleEmailSearchRepo;
import com.regres.testdata.UserContainer;
import com.regres.testdata.DB.UserDBRepo;

public class NonConfirmedCoownersActionsTest {
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private ConfirmMessagePage confirmMessage;
	private NonConfirmedCoownersActionsDropdown nonConfirmed;
	private GoogleEmailPage email;
	private GoogleEmailSearchRepo emailSearch; 
	private UserDBRepo user;
	
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
		//app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		nonConfirmed = adminhomepage.goToNonConfirmedCoowners();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		app.quit();
	}

	 @Test(dataProvider = "L10N")
	// this test verify that when in actions dropdown by clicking on 'Delete'
	// link confirm message appears when not chosen co owner
	public void checkClickDeleteWhenNotChosenCoowner(ChangeLanguageFields language) {
		nonConfirmed = nonConfirmed.setLanguage(language);
		nonConfirmed.clickActionsDropdown();
		nonConfirmed.clickDelete();
		confirmMessage = nonConfirmed.getConfMessage();
		assertEquals(confirmMessage.getConfirmMessageText(), 
				LoginPageL10n.CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER
					.getLocalization(language));
		confirmMessage.clickCloseButton();
	}

	 @Test(dataProvider = "L10N")
	// this test verify that when in actions dropdown by clicking on 'Send Email'
	// link confirm message appears when not chosen co owner
	public void checkClickSendEmailWhenNotChosenCoowner(ChangeLanguageFields language) {
		nonConfirmed = nonConfirmed.setLanguage(language);
		nonConfirmed.clickActionsDropdown();
		nonConfirmed.clickSendEmail();
		confirmMessage = nonConfirmed.getConfMessage();
		assertEquals(confirmMessage.getConfirmMessageText(),
				LoginPageL10n.CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER
				.getLocalization(language));
		confirmMessage.clickCloseButton();
	}

	 @Test(dataProvider = "L10N")
	// this test verify that when we choose coowner in table and click actions
	// dropdown by clicking on 'Send Email Again'
	// link confirm message appears
	public void checkClickSendEmail(ChangeLanguageFields language) {
		nonConfirmed = nonConfirmed.setLanguage(language);
		nonConfirmed.search(user.getUserNonConfirmed().getLogin());
		nonConfirmed.clickFirstRow();
		nonConfirmed.clickActionsDropdown();
		nonConfirmed.clickSendEmail();
		confirmMessage = nonConfirmed.getConfMessage();
		assertEquals(confirmMessage.getConfirmMessageText(), 
				LoginPageL10n.SEND_EMAIL_CONFIRM_MESSAGE
					.getLocalization(language));
		confirmMessage.clickCloseButton();
		assertEquals(nonConfirmed.getTitleTableNameText(), 
				LoginPageL10n.TITLE_TABLE_TEXT
					.getLocalization(language));
	}

	 @Test(dataProvider = "L10N")
	// this test verify that when we choose coowner in table and click actions
	// dropdown by clicking on 'Send Email Again'
	// link confirm message appears
	public void checkClickSendEmailOK(ChangeLanguageFields language) {
		nonConfirmed = nonConfirmed.setLanguage(language);
		nonConfirmed.search(user.getUserNonConfirmed().getLogin());
		nonConfirmed.clickFirstRow();
		nonConfirmed.clickActionsDropdown();
		nonConfirmed.clickSendEmail();
		confirmMessage = nonConfirmed.getConfMessage();
		confirmMessage.clickOkButton();
		assertEquals(nonConfirmed.getTitleTableNameText(), 
				LoginPageL10n.TITLE_TABLE_TEXT
					.getLocalization(language));
	}

	@Test(dependsOnMethods = { "checkClickSendEmailOK"})
	// this test verify that coowner get Email
	public void checkEmail() {
		email = nonConfirmed.goToEmail();
		email.switchToNewTab();
		email.signIn(user.getUserNonConfirmed().getEmail(), user.getUserNonConfirmed().getPassword());
		email.search(emailSearch.getGmailSearch().toString());
		assertTrue(email.getEmail().size() > 0);
		email.openEmail();
		assertEquals(email.getLoginName(), user.getUserNonConfirmed().getLogin());
		email.logout();
		email.switchBackToMainAndCloseOldTab();
	}

}
