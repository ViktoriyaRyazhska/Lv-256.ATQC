package Selenium;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This TC verifies possibility of administrator register new co-owner('Register
 * new user' button) after entering correct data.
 * 
 * @author Kryvenko Yaroslava
 *
 */

public class CreateCoowner {
	private WebDriver driver;

	/**
	 * In this method author sets up driver and logging in
	 */
	@BeforeClass(alwaysRun = true)
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
	public Object[][] mainRegistrationData() {
		return new Object[][] { { "yara", "yara", "111@111.com", "1111", "qwerty", "qwerty", "Італія" } };
	}

	/**
	 * In this method author create co-owner
	 */

	@Test(dataProvider = "mainRegistrationData")
	public void testCreateCowner(String first_Name, String last_Name, String email, String login, String password,
			String confirm_Password, String territorialCommunity) {
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		driver.findElement(By.partialLinkText("Зареєструвати співвласника")).click();
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(first_Name);
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(last_Name);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(login);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmPassword")).clear();
		driver.findElement(By.id("confirmPassword")).sendKeys(confirm_Password);
		new Select(driver.findElement(By.id("territorial_Community"))).selectByVisibleText(territorialCommunity);
		driver.findElement(By.id("submit")).click();
		
		Assert.assertEquals((By.id("login.errors")),("Цей логін уже використовується"), territorialCommunity;
				

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// logout:
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'logout')]")));
		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
		driver.quit();
	}
}
