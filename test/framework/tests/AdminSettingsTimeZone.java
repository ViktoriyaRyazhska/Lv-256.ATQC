package framework.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.pages.AdminHomePage;
import framework.pages.AdminSettingsPage;
import framework.pages.LoginPage;
import framework.testdata.UserContainer;

public class AdminSettingsTimeZone {

	private WebDriver driver;
	private String baseURL;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseURL = "http://regres.herokuapp.com";
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void checktime(){
		driver.get(baseURL);
		LoginPage loginpage = new LoginPage(driver);
		AdminHomePage adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		AdminSettingsPage settings = adminhomepage.clickSettings();
		
		settings = settings.setTimeZone("London");
		Assert.assertTrue(settings.getTimeZoneFieldText().contains("London"));
		
		settings.clickMenuDownButton();
		settings.clickLogout();
	}

}
