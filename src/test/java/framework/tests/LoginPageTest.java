package framework.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.pages.LoginPage;
import framework.testdata.UserContainer;

public class LoginPageTest {

	private WebDriver driver;
	private String baseURL;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\stuff_for_testng_firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		baseURL = "http://regres.herokuapp.com";
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test
	public void checkInvalidLogin() {
		
		driver.get(baseURL);
		LoginPage loginpage = new LoginPage(driver);
		loginpage = loginpage.setLanguage(2);
		loginpage = loginpage.unSuccessfullLogin(UserContainer.getInvalidData());
		Assert.assertTrue(loginpage.getErrorMessage().getText().contains("Wrong"));
	
	}
}
