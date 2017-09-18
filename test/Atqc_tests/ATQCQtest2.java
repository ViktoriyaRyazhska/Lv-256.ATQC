package Atqc_tests;

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
import org.testng.annotations.Test;

/**
 * Those tests are verifying that Administrator can choose any of three
 * available forms of coowners registration
 * 
 * @author Taras Savula
 *
 */

public class ATQCQtest2 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void loginAsAdmin() {
		driver.get("http://regres.herokuapp.com/");

		// change localization to English
		new Select(driver.findElement(By.id("changeLanguage"))).selectByValue("en");

		// wait till page refreshes
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("header"), "Decentralized registry of"));

		// login as Administrator
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).submit();
	}
	public void loginAsCommisioner() {
		// login as Administrator
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("qwerty");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).submit();
	}
	public void SignOut() {
		//signout through dropdown
	driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();
	driver.findElement(By.partialLinkText("Sign out")).click();
	wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.titleContains("Login"));
	}
	public void SignOut2() {
		//cancel registration of new user
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains("Login"));
	}
	@Test
	public void choosePersonalRegistration() {
		loginAsAdmin();
		// navigate to Settings page
		driver.findElement(By.xpath("//div[2]/ul/li[3]/a")).click();

		// wait until page loads
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.panel-body.panel30")));

		// click on Personal registration radiobutton
		driver.findElement(By.xpath("//input[@name='registrationMethod' and @value='PERSONAL']")).click();
		
		//submit changes
		driver.findElement(By.id("confirmRegistrationMethod")).submit();
		
		//verify message that changes where successful
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-success span")).getText(),
				"Settings was successfully saved!");
		SignOut();
		
		//verify user can navigate to registration through button on the main page
		driver.findElement(By.cssSelector("a.btn.btn-success")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains("Register new user"));
		Assert.assertEquals("Register new user", driver.getTitle());
		SignOut2();
	}

	@Test
	public void chooseCommisionerRegistration() {
		loginAsAdmin();
		// navigate to Settings page
		driver.findElement(By.xpath("//div[2]/ul/li[3]/a")).click();

		// wait until page loads
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.panel-body.panel30")));

		// click on Commisioner registration radiobutton
		driver.findElement(By.xpath("//input[@name='registrationMethod' and @value='MANUAL']")).click();
		
		//submit changes
		driver.findElement(By.id("confirmRegistrationMethod")).submit();
		
		//verify message that changes where successful
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-success span")).getText(),
				"Settings was successfully saved!");
		SignOut();
		loginAsCommisioner();
		
		//navigate to registration page in Commisioner navigation bar
		driver.findElement(By.xpath("//a[@href='/manualregistration']")).click();
		
		// wait until page loads
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register_container")));
		
		//verify Commisioner will see registration form for new user
		Assert.assertTrue(driver.findElement(By.id("register_container")) != null);
		SignOut();
		
	}

	@Test
	public void chooseMixedRegistration() {
		loginAsAdmin();
		// navigate to Settings page
		driver.findElement(By.xpath("//div[2]/ul/li[3]/a")).click();

		// wait until page loads
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.panel-body.panel30")));

		// click on Mixed registration radiobutton
		driver.findElement(By.xpath("//input[@name='registrationMethod' and @value='MIXED']")).click();
		
		//submit changes
		driver.findElement(By.id("confirmRegistrationMethod")).submit();
		
		//verify message that changes where successful
		Assert.assertEquals(driver.findElement(By.cssSelector("div.alert.alert-success span")).getText(),
				"Settings was successfully saved!");
				SignOut();
				
		//verify user can navigate to registration through button on the main page
		driver.findElement(By.cssSelector("a.btn.btn-success")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains("Register new user"));
		Assert.assertEquals("Register new user", driver.getTitle());
		SignOut2();
		
		//verify user can navigate to registration as a Commisioner through his navigation bar
		loginAsCommisioner();
		
		//click Register new user
		driver.findElement(By.xpath("//a[@href='/manualregistration']")).click();
		
		// wait until page loads
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register_container")));
		
		//verify Commisioner will see registration form for new user
		Assert.assertTrue(driver.findElement(By.id("register_container")) != null);
		SignOut();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}