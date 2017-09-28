package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.User;
import data.UserRepo;
import pages.AdminHomePage;
import pages.LoginPage;

public class LoginAdminTest {
	private WebDriver driver;
	private String baseURL;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		baseURL = "http://ssu-oms.training.local:8280/oms5";
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	private Object[][] user(){
		return new Object[][]{
			{UserRepo.inValidAdmin()},
			{UserRepo.validAdmin2()}
		};
		
	}
	@Test(dataProvider="user")
	public void checkValidLogin(User user) {
		driver.get(baseURL);
		LoginPage loginPage = new LoginPage(driver);
		AdminHomePage adminHomePage = loginPage.successAdminLogin(user);
		Assert.assertEquals(user.getName(), adminHomePage.getFirstname().getText());
		adminHomePage.logout();
	}

	@Test
	public void checkInvalidLogin() {
		driver.get(baseURL);
		LoginPage loginpage = new LoginPage(driver);
		loginpage = loginpage.unsuccesfulLogin(UserRepo.inValidAdmin());
		Assert.assertNotNull(loginpage.getLoginName());
	}
}