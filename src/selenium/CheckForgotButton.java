package selenium;

import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * The test case checks that user can recover the password after clicking the
 * "Forgot password button" on login page
 * 
 * @author Khrystyna Terletska
 */
public class CheckForgotButton {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\Downloads\\111\\geckodriver.exe");
		driver = new FirefoxDriver();
		// Adding wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Launching the browser application
		driver.get("http://regres.herokuapp.com/");

	}

	/**
	 * This method verify that success message is appeared when user enter valid
	 * email address in email field on Forgot page .
	 */
	@Test
	public void checkResetPassword() {
		Reporter.log("Running checkResetPassword"); // create report
		driver.findElement(By.className("forgot-password")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("khrystynaterletska@gmail.com");
		driver.findElement(By.cssSelector("button.btn-primary.btn-block")).click();

		// Verify that massage "Повідомлення відравленне на вашу адресу" is appeared
		// after clicking "Reset password"
		Assert.assertEquals("Повідомлення відравленне на вашу адресу",
				driver.findElement(By.cssSelector("strong")).getText());
		driver.quit();

	}

	/**
	 * This method verify that error message" is appeared when user leave email
	 * field empty on Forgot page .
	 */
	@Test
	public void checkEmptyEmailField() {
		Reporter.log("Running checkEmptyEmailField"); // create report
		driver.findElement(By.className("forgot-password")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.cssSelector("button.btn-primary.btn-block")).click();

		// The field value is retrieved by the getAttribute("value") and assigned to the
		// String object
		String message = driver.findElement(By.id("email")).getAttribute("validationMessage");
		// Verify that message "Заповніть будь ласка це поле" is printed when email
		// address field is empty
		Assert.assertEquals(message, "Заповніть будь ласка це поле.");
		driver.quit();

	}
}