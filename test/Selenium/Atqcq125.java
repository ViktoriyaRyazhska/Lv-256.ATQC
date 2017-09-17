package Selenium;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * First test case verify that error messages are shown when creating new user
 * with invalid data. Second test case verify that after click on ‘Clear form’
 * button on 'Register new user' page makes all fields empty.
 * 
 * @author Kryvenko Yaroslava
 *
 */

public class Atqcq125 {
	private WebDriver driver;

	/**
	 * This method sets up driver
	 */
	@BeforeClass()
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logIn();
	}

	/**
	 * This method login into system as Administrator
	 */
	public void logIn() {
		// login as Administrator:
		driver.get("http://regres.herokuapp.com/" + "/login?logout");
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();//Click on 'Sign in' button
	}

	@DataProvider
	public Object[][] registrationInvalidData() {
		return new Object[][] { { UserRepo.getInvalidUser1() }, { UserRepo.getInvalidUser2() } };
	}

	/**
	 * This method fills registration form
	 */
	public void fillRegistrationForm(User user) {
		driver.findElement(By.partialLinkText("Зареєструвати співвласника")).click();
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(user.getFirst_Name());
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(user.getLast_Name());
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(user.getEmail());
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(user.getLogin());
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(user.getPassword());
		driver.findElement(By.id("confirmPassword")).clear();
		driver.findElement(By.id("confirmPassword")).sendKeys(user.getConfirm_Password());
		new Select(driver.findElement(By.id("territorial_Community")))
				.selectByVisibleText(user.getTerritorialCommunity());
	}

	/**
	 * This test verify that error messages are shown when trying create new user
	 * with invalid data.
	 */
	@Test(dataProvider = "registrationInvalidData")
	public void testAppearingErrorMessages(User user) {
		Reporter.log("Running Testing testAppearingErrorMessages");

		fillRegistrationForm(user);
		driver.findElement(By.id("submit")).click();//Click on 'Send' button

		// check that error messages are present on the page:
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName.errors")));
		assertEquals(driver.findElement(By.id("firstName.errors")).getText(), user.getFirstNameErrors());
		assertEquals(driver.findElement(By.id("lastName.errors")).getText(), user.getLastNameErrors());
		assertEquals(driver.findElement(By.id("email.errors")).getText(), user.getEmailErrors());
		assertEquals(driver.findElement(By.id("login.errors")).getText(), user.getLoginErrors());
		assertEquals(driver.findElement(By.id("password.errors")).getText(), user.getPasswordErrors());
		assertEquals(driver.findElement(By.id("confirmPassword.errors")).getText(), user.getConfirmPasswordErrors());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		checkColorErrorMessages();
		checkCoownerInTable(user);
	}

	/**
	 * This method check that error messages have red color
	 */
	public void checkColorErrorMessages() {
		assertEquals(driver.findElement(By.id("firstName.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("lastName.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("email.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("login.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("password.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("confirmPassword.errors")).getCssValue("color"), "rgb(255, 0, 0)");
	}

	/**
	 * This method check if a co-owner with invalid registration data is not
	 * created.
	 */
	public void checkCoownerInTable(User user) {
		// go to 'non-confirmed' page :
		driver.findElement(By.xpath("//a[@href=\"#\" and @data-toggle=\"dropdown\"]")).click();// 'Community' item
		driver.findElement(By.partialLinkText("Непідтверджені")).click();

		// Search co-owner in table
		driver.findElement(By.id("inputIndex3")).click();
		driver.findElement(By.id("inputIndex3")).clear();
		driver.findElement(By.id("inputIndex3")).sendKeys(user.getLogin());
		driver.findElement(By.id("bth-search")).click();// Search button

		// verify that text message is present in the tab
		assertEquals(driver.findElement(By.cssSelector(".dataTables_empty")).getText(), "В таблиці немає даних");
	}

	/**
	 * This test check that after click on ‘Clear form’ button registration form
	 * makes empty.
	 */
	@Test(dataProvider = "registrationInvalidData")
	public void testClearRegistrationForm(User user) {
		Reporter.log("Running Testing testClearRegistrationForm");
		fillRegistrationForm(user);
		driver.findElement(By.cssSelector(".btn.btn-warning.reset")).click(); // click on 'Reset' button

		// check that manual registration page is still opened::
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn.btn-warning.reset")));

		// Check if fields are empty
		Assert.assertEquals(driver.findElement(By.id("firstName")).getText().length(), 0);
		Assert.assertEquals(driver.findElement(By.id("lastName")).getText().length(), 0);
		Assert.assertEquals(driver.findElement(By.id("email")).getText().length(), 0);
		Assert.assertEquals(driver.findElement(By.id("login")).getText().length(), 0);
		Assert.assertEquals(driver.findElement(By.id("password")).getText().length(), 0);
		Assert.assertEquals(driver.findElement(By.id("confirmPassword")).getText().length(), 0);
		Assert.assertEquals(driver.findElement(By.id("datepicker")).getText().length(), 0);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// close browser:
		driver.quit();
	}
}
