package tests_selenium;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {
	private WebDriver driver;

	@BeforeClass
	public void before() {
		System.setProperty("webdriver.gecko.driver", "E:\\webdriver\\geckodriver\\geckodriver.exe");
		// driver = new FirefoxDriver();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		// System.setProperty("webdriver.gecko.driver",
		// "E:\\webdriver\\geckodriver\\geckodriver.exe");
		// System.setProperty("webdriver.gecko.driver",
		// "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Go to http://regres.herokuapp.com/
		driver.get("http://regres.herokuapp.com/");

		// login as Administrator
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

		// Click on ‘Settings’ tab
		driver.findElement(By.xpath("//a[contains(@href,'/administrator/settings')]")).click();
	}

	@Test
	public void testATQCQ135() {
		// Choose ‘Personal registration’ radiobutton in ‘Method of registering new
		// users’ block
		driver.findElement(By.xpath("(//input[@value='PERSONAL'])")).click();

		// Choose ‘Personal registration’ radiobutton in ‘Method of registering new
		// users’ block
		driver.findElement(By.id("confirmRegistrationMethod")).click();

		// Click on ‘Admin’ dropdown list
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();

		// Click ‘Sign out’
		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();

		// verify that register link is present
		assertTrue(isElementPresent(By.xpath("//a[contains(@href,'/register')]")));
	}

	@Test
	public void testATQCQ136() {
		// Choose ‘Only commissioner can register new co-owner’ radiobutton in ‘Method
		// of registering new users’ block
		driver.findElement(By.xpath("(//input[@value='MANUAL'])")).click();

		// Click on ‘Confirm changes’ button
		driver.findElement(By.id("confirmRegistrationMethod")).click();

		// Click on ‘Admin’ dropdown list
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();

		// Click ‘Sign out’
		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();

		// verify that register link is absent
		assertFalse(isElementPresent(By.xpath("//a[contains(@href,'/register')]")));

		// login as comissioner
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("qwerty");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

		// verify that 'register new co-owner’ link appears
		assertTrue(isElementPresent(By.xpath("//a[contains(@href,'manualregistration')]")));
	}

	@Test
	public void testATQCQ137() {
		// Choose ‘Both registration method are available’
		// radiobutton in ‘Method of registering new users’ block
		driver.findElement(By.xpath("(//input[@value='MIXED'])")).click();

		// Click on ‘Confirm changes’ button
		driver.findElement(By.id("confirmRegistrationMethod")).click();

		// Click on ‘Admin’ dropdown list
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();

		// Click ‘Sign out’
		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();

		// verify that register link is present
		assertTrue(isElementPresent(By.xpath("//a[contains(@href,'/register')]")));

		// login as comissioner
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("qwerty");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

		// verify that 'register new co-owner’ link appears
		assertTrue(isElementPresent(By.xpath("//a[contains(@href,'manualregistration')]")));
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// close browser
		driver.quit();
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
