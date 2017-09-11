package com.example.selenium.ide.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Find the site of Softserve Academy (softserve.academy), move to page with
 * schedule of courses and : 1) verify if there is entering of ATQC group 2)
 * verify that you have a class today
 * 
 * @author Bohdan Zhyvko
 *
 */
public class ScheduleTest {
	// initial WebDriver
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// initial WebDriver
		System.setProperty("webdriver.gecko.driver", "resources//geckodriver.exe");// "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/* Go to schedule page */
	@BeforeMethod
	public void goToSchedule() {
		// go to "SoftServe Academy" web page
		driver.get("https://softserve.academy/");
		// click on "Lviv: schedule"
		driver.findElement(By.partialLinkText("Lviv: schedule")).click();
		// "Lviv: schedule" open on new Tab
		// switch WebDriver to new Tab
		switchToNewTab(driver);
		// click on '09-11' week
		driver.findElement(By.partialLinkText("09-11")).click();
	}

	/*
	 * 1) verify if there is entering of ATQC group
	 */
	@Test
	public void testScheduleAtqcGroup() {
		assertNotNull(driver.findElement(By.partialLinkText("Lv-256 ATQC")));
	}

	/*
	 * 2) verify that you have a class today
	 */
	@Test
	public void testHaveClassToday() {
		// click on 'Lv-256 ATQC' group
		driver.findElement(By.partialLinkText("Lv-256 ATQC")).click();
		assertEquals(driver.findElement(By.xpath("//tr/td[4]//b")).getText(), "Lv-256.ATQC");
	}

	@AfterClass
	public void tearDown() {
		// close WebDriver
		driver.quit();
	}

	/* switch WebDriver to new Tab */
	public void switchToNewTab(WebDriver driver) {
		String winHandle = null;
		for (String newWinHandle : driver.getWindowHandles()) {
			winHandle = newWinHandle;
		}
		driver.switchTo().window(winHandle);
	}

}
