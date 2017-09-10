import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginAdminTest {
	private WebDriver driver;
	private String baseURL;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\ATQC_new\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		baseURL = "http://localhost:8081/OMS";
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test
	public void checkValidLogin() {
		driver.get(baseURL);
		LoginPage loginPage = new LoginPage(driver);
		AdminHomePage adminHomePage = loginPage.successAdminLogin("iva", "qwerty");
		Assert.assertEquals("ivanka", adminHomePage.getFirstname().getText());
		adminHomePage.logout();
	}

	@Test
	public void checkInvalidLogin() {
		driver.get(baseURL);
		LoginPage loginpage = new LoginPage(driver);
		loginpage = loginpage.unsuccesfulLogin("iva", "qwery1111");
		Assert.assertNotNull(loginpage.getLoginName());
	}
}