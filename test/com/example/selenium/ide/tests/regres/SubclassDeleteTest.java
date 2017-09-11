package com.example.selenium.ide.tests.regres;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class SubclassDeleteTest {
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setUpClass() {
		// initial property
		System.setProperty("webdriver.gecko.driver", "resources//geckodriver.exe");// "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);

		// go to RegRes LogIn page
		driver.get("http://regres.herokuapp.com/");
		logIn();
	}

	@BeforeMethod
	public void setUpMethod() {

		driver.findElement(By.partialLinkText("Subclasses of objects")).click();
		addSubclass();

	}

	// @Test
	public void testConfirmMessageAppear() {
		driver.findElement(By.xpath("//td[text() = 'Test']/following::a")).click();

		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"Do you really want to delete this class?");
	}

	//@Test
	public void testCancelDelettingByCloseButton() {
		driver.findElement(By.xpath("//td[text() = 'Test']/following::a")).click();
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"Do you really want to delete this class?");
		driver.findElement(By.cssSelector(".close")).click();
		assertNotNull(driver.findElement(By.xpath("//td[text() = 'Test']")));
	}

	@Test
	public void testCancelDelettingByCancelButton() {
		driver.findElement(By.xpath("//td[text() = 'Test']/following::a")).click();
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"Do you really want to delete this class?");

		// 'Cancel' - button
		driver.findElement(By.cssSelector(".btn.btn-default")).click();

		assertNotNull(driver.findElement(By.xpath("//td[text() = 'Test']")));
	}

	@Test
	public void testDeleteByOkButton() {

		driver.findElement(By.xpath("//td[text() = 'Test']/following::a")).click();
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"Do you really want to delete this class?");
		// 'OK' - button
		driver.findElement(By.xpath("//button[@data-bb-handler='confirm']")).click();

		assertEquals(driver.findElement(By.xpath("//td[text() = 'Test']")).getText(), "Test");
	}

	//@Test // existing class is not deleted if resources already exist
	public void testCancelDelettingBySystemConfirmByOKButton() {
		driver.findElement(By.xpath("//td[text() = 'Water']/following::a")).click();
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"Do you really want to delete this class?");
		// 'OK' - button
		driver.findElement(By.xpath("//button[@data-bb-handler='confirm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"This subclass cannot be deleted because resources already exist");
		// 'OK' - button
		driver.findElement(By.xpath("//button[@data-bb-handler='ok']")).click();
		assertNotNull(driver.findElement(By.xpath("//td[text()='Water']")));
	}
	
	//@Test // existing class is not deleted if resources already exist
	public void testCancelDelettingBySystemConfirmByCloseButton() {
		driver.findElement(By.xpath("//td[text() = 'Water']/following::a")).click();
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"Do you really want to delete this class?");
		// 'OK' - button
		driver.findElement(By.xpath("//button[@data-bb-handler='confirm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"This subclass cannot be deleted because resources already exist");
		// 'Close' - button
		driver.findElement(By.cssSelector(".close")).click();
		assertNotNull(driver.findElement(By.xpath("//td[text() = 'Water']")));
	}

	@AfterMethod
	public void deleteTestData() {
		System.out.println("---"+driver.findElement(By.xpath("//td[text() = 'Test']")).isDisplayed());
		//driver.navigate().refresh();
		driver.get(driver.getCurrentUrl());
		System.out.println("---"+driver.findElement(By.xpath("//td[text() = 'Test']")).isEnabled());
		if (driver.findElement(By.xpath("//td[text() = 'Test']")).isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text() = 'Test']/following::a"))).click();
			// 'OK' - button
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-bb-handler='confirm']"))).click();
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	/*
	 * Log In to RegRes
	 */
	public void logIn() {
		// choose English localization
		new Select(driver.findElement(By.id("changeLanguage"))).selectByValue("en");
		// clear login input field
		driver.findElement(By.id("login")).clear();
		// write login
		driver.findElement(By.id("login")).sendKeys("registrator");
		// clear password input field
		driver.findElement(By.id("password")).clear();
		// write password
		driver.findElement(By.id("password")).sendKeys("registrator");
		driver.findElement(By.id("password")).submit();
		// click on 'Sign In'
	}

	/*
	 * Add new Subclass
	 */
	public void addSubclass() {
		// add new subclass
		driver.findElement(By.linkText("Add new subclass")).click();
		driver.findElement(By.name("typeName")).clear();
		driver.findElement(By.name("typeName")).sendKeys("Test");
		driver.findElement(By.id("clickmeshow")).click();
		driver.findElement(By.id("myparam0")).clear();
		driver.findElement(By.id("myparam0")).sendKeys("123450");
		driver.findElement(By.id("myparam1")).clear();
		driver.findElement(By.id("myparam1")).sendKeys("123450");
		new Select(driver.findElement(By.id("myparam2"))).selectByValue("linearParameters");
		driver.findElement(By.id("valid")).click();
	}
}
