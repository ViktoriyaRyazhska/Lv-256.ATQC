
package com.regres.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.LoginPage;
import com.regres.pages.LoginPage.LoginPageL10n;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;

public class LoginPageLocalizationTest {

	private Application app;
	private LoginPage loginpage;

	@BeforeClass
	public void setUp() {
		// System.setProperty("file.encoding","UTF-8");
		app = app.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		loginpage = app.load();
	}

	@AfterClass
	public void tearDown() {
		app.quit();
	}

	@DataProvider
	public Object[][] localization() {
		return new Object[][] { { ChangeLanguageFields.RUSSIAN }, { ChangeLanguageFields.UKRAINIAN },
				{ ChangeLanguageFields.ENGLISH } };
	}

	@Test(dataProvider = "localization")
	public void checkLoginPageLocalization(ChangeLanguageFields language) {

		loginpage = loginpage.setLanguage(language);
		Assert.assertEquals(loginpage.getTitleText(), LoginPageL10n.TITLE_LABEL.getLocalization(language));
		Assert.assertEquals(loginpage.getFooterText(), LoginPageL10n.FOOTER_LABEL.getLocalization(language));
		Assert.assertEquals(loginpage.getLoginLabelText(), LoginPageL10n.LOGIN_LABEL.getLocalization(language));
		Assert.assertEquals(loginpage.getPasswordLabelText(), LoginPageL10n.PASSWORD_LABEL.getLocalization(language));
		Assert.assertEquals(loginpage.getSignInButtonText(), LoginPageL10n.SUBMIT_BUTTON.getLocalization(language));
		Assert.assertEquals(loginpage.getForgotPasswordLinkText(),
				LoginPageL10n.FORGOT_PASSWORD_LINK.getLocalization(language));

	}

}