package com.regres.tests.coownerTable;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown;
import com.regres.pages.manage.coowners.actions.ActiveCoownersActionsDropdown.LoginPageL10n;
import com.regres.testdata.UserContainer;

public class NotSelectedActiveCoownersActionTest {
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private ActiveCoownersActionsDropdown activecoowners;

	@BeforeTest
	public void beforeMethod() throws ClassNotFoundException, SQLException {
		// Select browser
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
		// Load app
		loginpage = app.load();
		// Login in system as administrator
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		// Click on Co-owners item
		adminhomepage.clickCoowners();
		// Click on "Inactive co-owners" item
		activecoowners = adminhomepage.clickActiveCoowners();
	}

	@AfterTest
	public void afterTest() throws ClassNotFoundException, SQLException {
		app.quit();
	}

	@DataProvider(name = "L10N")
	public static Object[] localizationProvider() {
		return new Object[][] { { ChangeLanguageFields.UKRAINIAN }, { ChangeLanguageFields.ENGLISH },
				{ ChangeLanguageFields.RUSSIAN } };
	}

	/**
	 * Check appearing of message and correctness that depends on l10n when no one
	 * row is selected
	 */
	@Test(dataProvider = "L10N")
	public void checkConfirmMessageSetCommunity(ChangeLanguageFields language) {
		// Choose language
		activecoowners = activecoowners.setLanguage(language);
		// Click on 'Actions' button
		activecoowners.clickActionsDropdown();
		// Click on "Set community" item
		activecoowners.clickSetCommunityNotSelected();
		// Verify that message has correct text
		Assert.assertEquals(activecoowners.confirm.getConfirmMessageText(),
				LoginPageL10n.CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER.getLocalization(language));
		// Close window with message
		activecoowners.confirm.clickCloseButton();
	}

	/**
	 * Check appearing of message and correctness that depends on l10n when no one
	 * row is selected
	 */
	@Test(dataProvider = "L10N")
	public void checkConfirmMessageSetRole(ChangeLanguageFields language) {
		// Choose language
		activecoowners = activecoowners.setLanguage(language);
		// Click on 'Actions' button
		activecoowners.clickActionsDropdown();
		// Click on "Set role" item
		activecoowners.clickSetRole();
		// Select role
		activecoowners.clickCoownerRole();
		// Verify that message has correct text
		Assert.assertEquals(activecoowners.confirm.getConfirmMessageText(),
				LoginPageL10n.CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER.getLocalization(language));
		// Close window with message
		activecoowners.confirm.clickCloseButton();
	}

	/**
	 * Check appearing of message and correctness that depends on l10n when no one
	 * row is selected
	 */
	@Test(dataProvider = "L10N")
	public void checkConfirmMessageResetPassword(ChangeLanguageFields language) {
		// Choose language
		activecoowners = activecoowners.setLanguage(language);
		// Click on 'Actions' button
		activecoowners.clickActionsDropdown();
		// Click on "Reset password" item
		activecoowners.clickResetPassword();
		// Verify that message has correct text
		Assert.assertEquals(activecoowners.confirm.getConfirmMessageText(),
				LoginPageL10n.CONFIRM_MESSAGE_WHEN_DONOT_CHOSEN_COOWNER.getLocalization(language));
		// Close window with message
		activecoowners.confirm.clickCloseButton();
	}
}
