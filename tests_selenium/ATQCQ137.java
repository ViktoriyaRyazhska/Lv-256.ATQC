package tests_selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ATQCQ137 {
	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\1\\geckodriver\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", "E:\\webdriver\\geckodriver\\geckodriver.exe");
		// System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		// Go to http://regres.herokuapp.com/
		driver.get("http://regres.herokuapp.com/");

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
	public void testATQCQ137() {
		// Choose ‘Both registration method are available’
		// radiobutton in ‘Method of registering new users’ block
		driver.findElement(By.xpath("(//input[@value='MIXED'])")).click();

		// Click on ‘Confirm changes’ button
		driver.findElement(By.id("confirmRegistrationMethod")).click();

		// Click on ‘Admin’ dropdown list
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();

		// Click ‘Sign out’
		driver.findElement(By.partialLinkText("Sign out")).click();

		// verify that register link is present
		assertTrue(isElementPresent(By.partialLinkText("Register")));

		// login as comissioner
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("qwerty");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

		// verify that 'register new co-owner’ link appears
		assertTrue(isElementPresent(By.partialLinkText("Register new user")));
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
