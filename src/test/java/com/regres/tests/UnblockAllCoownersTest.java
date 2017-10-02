package com.regres.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.UserContainer;



public class UnblockAllCoownersTest {
	private WebDriver driver;
	private String baseURL;
	AdminHomePage adminhomepage;
	Application app;
	

	@BeforeClass
	public void setUp() {
		/*System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseURL = "http://localhost:8080/resources/";
		driver.get(baseURL);*/
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuLocalhost());
		
		LoginPage loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		
	}

	@AfterClass
	public void tearDown() {
		
		adminhomepage.clickLogout();
		driver.close();
	}

	@Test(dataProvider="langProvider")
	public void checkUnblockAllCoowners(ChangeLanguageFields language,String message) {
		adminhomepage=adminhomepage.setLanguage(language);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		adminhomepage.clickUnblockAllCoowners();
		Assert.assertTrue(adminhomepage.getConfirmMessageUnblockAllCoownersText().equals(message));
		adminhomepage = adminhomepage.clickOkButtonOnConfirmUnblockAllCoowners();
	
	}
	
	@DataProvider
	public Object[] langProvider() {
		
		return new Object[][] {{ChangeLanguageFields.UKRAINIAN,"Ви успішно розблокували всіх співвласників"},{ChangeLanguageFields.ENGLISH,"Youve successfully unblocked all coowners!"},{ChangeLanguageFields.RUSSIAN,"Вы успешно разблокировали всех совладельцев!"}};
	
	}
	
	
	
	
}

