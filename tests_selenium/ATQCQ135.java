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

public class ATQCQ135 {
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		//System.setProperty("webdriver.gecko.driver", "D:\\1\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Go to http://regres.herokuapp.com/
		driver.get("http://regres.herokuapp.com/");

		// choose English localization
		// driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		new Select(driver.findElement(By.id("changeLanguage"))).selectByValue("en");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath("(//option[@value='en'])")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// login as Administrator
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

		// Click on �Settings� tab
		driver.findElement(By.partialLinkText("Settings")).click();
	}

	@Test
	public void testATQCQ135() {
		// Choose �Personal registration� radiobutton in �Method of registering
		// new users� block
		driver.findElement(By.xpath("(//input[@value='PERSONAL'])")).click();
		
		// confirm changes and sign out
		confirmationAndSignOut(driver);

		// verify that register link is present
		assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Register"))) != null);
		// new WebDriverWait(driver,
		// 10).until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// close browser
		driver.quit();
	}

	public void confirmationAndSignOut(WebDriver driver) {
		// Click on �Confirm changes� button
		driver.findElement(By.id("confirmRegistrationMethod")).click();

		// Click on �Admin� dropdown list
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();

		// Click �Sign out�
		driver.findElement(By.partialLinkText("Sign out")).click();
	}

	// public boolean isElementPresent(By by) {
	// try {
	// driver.findElement(by);
	// return true;
	// } catch (NoSuchElementException e) {
	// return false;
	// }
	// }

}
