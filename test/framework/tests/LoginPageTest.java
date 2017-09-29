package framework.tests;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.application.Application;
import framework.application.ApplicationSourcesRepo;
import framework.pages.AdminHomePage;
import framework.pages.LoginPage;
import framework.pages.TitleLocalFooter.ChangeLanguageFields;
import framework.testdata.UserContainer;


public class LoginPageTest {

	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	
	
	@BeforeClass
	public void setUp() {
		app=app.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
	}

	@AfterClass
	public void tearDown() {
		app.quit();
	}

	@Test
	public void checkValidLoginAdmin() {
		
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		Assert.assertEquals(adminhomepage.getUserNameText(), UserContainer.getAdmin().getLogin());
		adminhomepage.clickLogout();
	}
	
	@Test
	public void checkInvalidLogin() {
		loginpage = loginpage.setLanguage(ChangeLanguageFields.ENGLISH);
		loginpage = loginpage.unSuccessfullLogin(UserContainer.getInvalidData());
		Assert.assertTrue(loginpage.getErrorMessage().getText().contains("Wrong login or password"));
	
	}
	
	
	
	
}
