package selenium;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
/**
 * The test case checks that user can recover the password after 
 *  clicking the "Forgot password button" on login page
 * @author Khrystyna Terletska
 */
public class CheckForgotButton {
	private WebDriver driver;

	@BeforeClass
	public void Set() {
		System.setProperty("webdriver.gecko.driver", "D:\\Downloads\\111\\geckodriver.exe");
		driver = new FirefoxDriver();
		// Adding wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Launching the browser application
		driver.get("http://regres.herokuapp.com/");

	}
	/**
	 * This method verify that success message is appeared when user enter valid email address in email field on Forgot page .
	 */
	@Test
	public void checkResetPassword() {
		Reporter.log("CheckResetPassword"); //create report
		driver.findElement(By.className("forgot-password")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("khrystynaterletska@gmail.com");
		driver.findElement(By.cssSelector("button.btn-primary.btn-block")).click();
		
		//Verify that massage "Повідомлення відравленне на вашу адресу" is appeared after clicking "Reset password"
		Assert.assertEquals("Повідомлення відравленне на вашу адресу",
				driver.findElement(By.cssSelector("strong")).getText());

	}

	/**
	 * This method verify that error message" is appeared when user leave email field empty on Forgot page .
	 */
	@Test
	public void checkEmptyEmailField() {
		Reporter.log("checkEmptyEmailField");  //create report
		driver.findElement(By.className("forgot-password")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.cssSelector("button.btn-primary.btn-block")).click();
		//Declare JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String message = (String) js.executeScript("return arguments[0].validationMessage;",
				driver.findElement(By.id("email")));
		
		//Verify that message "Заповніть будь ласка це поле" is printed when email address field is empty
		System.out.println("Message is " + message);

	}


@AfterClass(alwaysRun = true)
public void tearDown() throws Exception {
	// close browser:
	driver.quit();
}
}