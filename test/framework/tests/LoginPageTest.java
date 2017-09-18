package framework.tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.pages.AdminHomePage;
import framework.pages.LoginPage;
import framework.pages.TitleLocalFooter.ChangeLanguageFields;
import framework.testdata.UserContainer;

import java.util.concurrent.TimeUnit;


public class LoginPageTest {

	private WebDriver driver;
	private String baseURL;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		baseURL = "http://regres.herokuapp.com";
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test
	public void checkValidLogin() {
		driver.get(baseURL);
		LoginPage loginpage = new LoginPage(driver);
		AdminHomePage adminhomepage = loginpage.successfullLogin(UserContainer.getAdmin());
		Assert.assertEquals(adminhomepage.getUserName().getText().trim(), UserContainer.getAdmin().getLogin());
		adminhomepage.clickLogout();
	}
	
	@Test
	public void checkInvalidLogin() {
		
		driver.get(baseURL);
		LoginPage loginpage = new LoginPage(driver);
		loginpage = loginpage.setLanguage(ChangeLanguageFields.ENGLISH);
		loginpage = loginpage.unSuccessfullLogin(UserContainer.getInvalidData());
		Assert.assertTrue(loginpage.getErrorMessage().getText().contains("Wrong"));
	
	}
}
