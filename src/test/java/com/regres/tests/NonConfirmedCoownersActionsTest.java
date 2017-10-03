package com.regres.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.GoogleEmailPage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.actions.NonConfirmedCoownersActionsDropdown;
import com.regres.testdata.UserContainer;

public class NonConfirmedCoownersActionsTest {
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private ConfirmMessagePage confirmMessage;
	private NonConfirmedCoownersActionsDropdown nonConfirmed;
	private GoogleEmailPage email;

	@BeforeClass
	public void setUp() {
		app = app.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		nonConfirmed = adminhomepage.goToNonConfirmedCoowners();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		app.quit();
	}

	 @Test
	// this test verify that when in actions dropdown by clicking on 'Delete'
	// link confirm message appears when not chosen co owner
	public void checkClickDeleteWhenNotChosenCoowner() {
		nonConfirmed.clickActionsDropdown();
		nonConfirmed.clickDelete();
		confirmMessage = nonConfirmed.getConfMessage();
		assertEquals(confirmMessage.getConfirmMessageText(),
				"Для виконання даної операції спочатку потрібно вибрати співвласників,"
						+ " натиснувши на відповідні стрічки в таблиці");
		confirmMessage.clickCloseButton();
	}

	 @Test(priority = 1)
	// this test verify that when in actions dropdown by clicking on 'Send Email'
	// link confirm message appears when not chosen co owner
	public void checkClickSendEmailWhenNotChosenCoowner() {
		nonConfirmed.clickActionsDropdown();
		nonConfirmed.clickSendEmail();
		confirmMessage = nonConfirmed.getConfMessage();
		assertEquals(confirmMessage.getConfirmMessageText(),
				"Для виконання даної операції спочатку потрібно вибрати співвласників,"
						+ " натиснувши на відповідні стрічки в таблиці");
		confirmMessage.clickCloseButton();
	}

	 @Test
	// this test verify that when we choose coowner in table and click actions
	// dropdown by clicking on 'Send Email Again'
	// link confirm message appears
	public void checkClickSendEmail() {
		nonConfirmed.search("bzhyvko");
		nonConfirmed.clickFirstRow();
		nonConfirmed.clickActionsDropdown();
		nonConfirmed.clickSendEmail();
		confirmMessage = nonConfirmed.getConfMessage();
		assertEquals(confirmMessage.getConfirmMessageText(), "Листи успішно надіслано");
		confirmMessage.clickCloseButton();
		assertEquals(nonConfirmed.getTitleText(), "Непідтверджені співвласники");
	}

	 @Test
	// this test verify that when we choose coowner in table and click actions
	// dropdown by clicking on 'Send Email Again'
	// link confirm message appears
	public void checkClickSendEmailOK() {
		nonConfirmed.search("bzhyvko");
		nonConfirmed.clickFirstRow();
		nonConfirmed.clickActionsDropdown();
		nonConfirmed.clickSendEmail();
		confirmMessage = nonConfirmed.getConfMessage();
		confirmMessage.clickOkButton();
		assertEquals(nonConfirmed.getTitleText(), "Непідтверджені співвласники");
	}

	@Test(dependsOnMethods = { "checkClickSendEmailOK"})
	// this test verify that coowner get Email
	public void checkEmail() {
		email = nonConfirmed.goToEmail();
		email.switchToNewTab();
		email.signIn("bzhyvko90@gmail.com", "19902712");
		email.search("l:unread", "Заявка на реєстрацію");
		assertTrue(email.getEmail().size() > 0);
		email.openEmail();
		assertEquals(email.getLoginName(), "bzhyvko");
		email.logout();
		email.switchBackToMainAndCloseOldTab();
	}

}
