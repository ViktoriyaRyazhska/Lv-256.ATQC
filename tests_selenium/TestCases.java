package tests_selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCases {
	private WebDriver driver;

	@BeforeClass
	public void before() {
		// System.setProperty("webdriver.gecko.driver",
		// "D:\\1\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "E:\\webdriver\\geckodriver\\geckodriver.exe");
		// System.setProperty("webdriver.gecko.driver",
		// "D:\\1\\drivers\\geckodriver.exe");
		// driver = new FirefoxDriver();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// wait = new WebDriverWait(driver, 20);

	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Go to http://regres.herokuapp.com/
		driver.get("http://regres.herokuapp.com/");
		// choose English localization
		new Select(driver.findElement(By.id("changeLanguage"))).selectByValue("en");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		new WebDriverWait(driver, 80)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//option[@value='en'])")));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
	public void testATQCQ135() {
		// Choose ‘Personal registration’ radiobutton in ‘Method of registering
		// new
		// users’ block
		driver.findElement(By.xpath("(//input[@value='PERSONAL'])")).click();

		confirmationAndSignOut(driver);
		// driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		// verify that register link is present
		// assertTrue(isElementPresent(By.partialLinkText("Register")));
		// assertTrue(new WebDriverWait
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Çàðåºñòðóâàòèñÿ")))
		// != null);
		assertTrue(new WebDriverWait(driver, 10)
				.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Register"))) != null);

	}

	@Test
	public void testATQCQ136() {
		// Choose ‘Only commissioner can register new co-owner’ radiobutton in
		// ‘Method
		// of registering new users’ block
		driver.findElement(By.xpath("(//input[@value='MANUAL'])")).click();

		confirmationAndSignOut(driver);

		// verify that register link is absent
		// assertFalse(isElementPresent(By.partialLinkText("Register")));
		// assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Register")))
		// != null);
		assertFalse(driver.findElements(By.partialLinkText("Register")).size()> 1);

		// login as comissioner
		loginAsComissioner(driver);

		// verify that 'register new user’ link appears
		// assertTrue(isElementPresent(By.partialLinkText("Register new user")));
		assertTrue(new WebDriverWait(driver, 10)
				.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Register new user"))) != null);
	}

	@Test
	public void testATQCQ137() {
		// Choose ‘Both registration method are available’
		// radiobutton in ‘Method of registering new users’ block
		driver.findElement(By.xpath("(//input[@value='MIXED'])")).click();

		confirmationAndSignOut(driver);

		// verify that register link is present
		assertTrue(new WebDriverWait(driver, 10)
				.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Register"))) != null);

		// login as comissioner
		loginAsComissioner(driver);

		// verify that 'register new co-owner’ link appears
		assertTrue(new WebDriverWait(driver, 10)
				.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Register new user"))) != null);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// close browser
		driver.quit();
	}

	public void confirmationAndSignOut(WebDriver driver) {
		// Click on ‘Confirm changes’ button
		driver.findElement(By.id("confirmRegistrationMethod")).click();

		// Click on ‘Admin’ dropdown list
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();

		// Click "Sign out"
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		new WebDriverWait(driver, 80)
				.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Sign out")));
		driver.findElement(By.partialLinkText("Sign out")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// driver.findElement(By.partialLinkText("Sign out")).click();
	}

	public void loginAsComissioner(WebDriver driver) {
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("qwerty");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}

	// @DataProvider
	// public Object[][] methodsOfRegistrations() {
	// return new Object[][] {
	// { driver.findElement(By.xpath("(//input[@value='PERSONAL'])")) },
	// { driver.findElement(By.xpath("(//input[@value='MANUAL'])")) },
	// { driver.findElement(By.xpath("(//input[@value='MIXED'])")) } };
	// }

	// private boolean isElementPresent(By by) {
	// try {
	// driver.findElement(by);
	// return true;
	// } catch (NoSuchElementException e) {
	// return false;
	// }
	// }
}
