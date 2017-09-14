package tests_selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATQCQ136 {
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		// System.setProperty("webdriver.gecko.driver",
		// "D:\\1\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Go to http://regres.herokuapp.com/
		driver.get("http://regres.herokuapp.com/");

		// choose English localization
		new Select(driver.findElement(By.id("changeLanguage"))).selectByValue("en");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//option[@value='en'])")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// login as Administrator
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

		// Click on ‘Settings’ tab
		driver.findElement(By.partialLinkText("Settings")).click();
	}

	@Test
	public void testATQCQ136() {
		// Choose ‘Only commissioner can register new co-owner’ radiobutton in
		// ‘Method
		// of registering new users’ block
		driver.findElement(By.xpath("(//input[@value='MANUAL'])")).click();

		// confirm changes and sign out
		confirmationAndSignOut(driver);

		// verify that register link is absent
		// assertFalse(isElementPresent(By.partialLinkText("Register")));
		// assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Register")))
		// == null);
		// assertNull(driver.findElements(By.partialLinkText("Register")));
		assertTrue(driver.findElements(By.partialLinkText("Register")).size() == 0);

		// login as comissioner
		loginAsComissioner(driver);

		// verify that 'register new user’ link appears
		// assertTrue(isElementPresent(By.partialLinkText("Register new
		// user")));
		assertTrue(wait
				.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Register new user"))) != null);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// close browser
		driver.quit();
	}

	public void loginAsComissioner(WebDriver driver) {
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("qwerty");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}

	public void confirmationAndSignOut(WebDriver driver) {
		// Click on ‘Confirm changes’ button
		driver.findElement(By.id("confirmRegistrationMethod")).click();

		// Click on ‘Admin’ dropdown list
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();

		// Click ‘Sign out’
		driver.findElement(By.partialLinkText("Sign out")).click();
	}
}
