package Selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import home.Dog;

public class ErrorMessagesCreatingCoowner {

	private WebDriver driver;

	/**
	 * In this method author sets up driver and logging in
	 */
	@BeforeClass()
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// login:
		driver.get("http://regres.herokuapp.com/" + "/login?logout");
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}

	@DataProvider
	public Object[][] registrationInvalidData() {
		return new Object[][] { { UserRepo.getInvalidUser1() }, { UserRepo.getInvalidUser2() } };
	}

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

	@Test(dataProvider = "registrationInvalidData")
	public void testAppiaringErrorMessages(User user) {

		fillRegistrationForm(user);
		driver.findElement(By.id("submit")).click();

		// verify that error messages are present on the page:
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName.errors")));
		System.out.println(user.getFirstNameErrors());
		assertEquals(driver.findElement(By.id("firstName.errors")).getText(), user.getFirstNameErrors());
		assertEquals(driver.findElement(By.id("lastName.errors")).getText(), user.getLastNameErrors());
		assertEquals(driver.findElement(By.id("email.errors")).getText(), user.getEmailErrors());
		assertEquals(driver.findElement(By.id("login.errors")).getText(), user.getLoginErrors());
		assertEquals(driver.findElement(By.id("password.errors")).getText(), user.getPasswordErrors());
		assertEquals(driver.findElement(By.id("confirmPassword.errors")).getText(), user.getConfirmPasswordErrors());

		// verify that error messages have red color:
		assertEquals(driver.findElement(By.id("firstName.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("lastName.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("email.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("login.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("password.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("confirmPassword.errors")).getCssValue("color"), "rgb(255, 0, 0)");

		// go to 'non-confirmed' page :
		driver.findElement(By.xpath("//a[@href=\"#\" and @data-toggle=\"dropdown\"]")).click();// 'Community' item
		driver.findElement(By.partialLinkText("Непідтверджені")).click();

		// Search co-owner in table
		driver.findElement(By.id("inputIndex3")).click();
		driver.findElement(By.id("inputIndex3")).clear();
		driver.findElement(By.id("inputIndex3")).sendKeys(user.getLogin());
		driver.findElement(By.id("bth-search")).click();// Search button

		assertEquals(driver.findElement(By.cssSelector(".dataTables_empty")).getText(), "В таблиці немає даних"); 
		// verify that text message is present in the tab
	}

	@Test(dataProvider = "registrationInvalidData")
	public void testClearRegistrationForm(User user) {

		fillRegistrationForm(user);
		driver.findElement(By.cssSelector(".btn.btn-warning.reset")).click(); // click on Reset button

		// verify that manual registration page is still opened::
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
