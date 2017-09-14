package Atqc_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * This test class is verifying that after unblocking all coowners Administrator
 * can close prompt about that by clicking OK button and Close button
 * 
 * @author Taras Savula
 *
 */

public class ATQCQ162test {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/");

		// change localization to English
		new Select(driver.findElement(By.id("changeLanguage"))).selectByValue("en");

		// wait till page refreshes
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("header"), "Decentralized registry of"));

		// login as Administrator
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).submit();
	}

	@Test
	public void unblockUsersWithOKclick() {

		// click in Unblock all coowners button
		driver.findElement(By.id("unlockUsers")).click();

		// wait until prompt appears
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bootbox-body")));

		// verify prompts message
		Assert.assertEquals(driver.findElement(By.cssSelector("div.bootbox-body")).getText(),
				"Youve successfully unblocked all coowners!");

		// click OK button
		driver.findElement(By.cssSelector("div.modal-footer>button.btn.btn-primary")).click();

		// wait until prompt disappears
		WebElement element = driver.findElement(By.cssSelector("div.bootbox-body"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.stalenessOf(element));

		// verify that prompt is not present by finding unique element on
		// previous page
		Assert.assertTrue(driver.findElement(By.id("menuForAdmin")) != null);
	}

	@Test
	public void unblockUsersWithClosedPrompt() {
		// click in Unblock all coowners button
		driver.findElement(By.id("unlockUsers")).click();

		// wait until prompt appears
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bootbox-body")));

		// click Close (X) button
		driver.findElement(By.cssSelector("div.modal-body>button.bootbox-close-button.close")).click();

		// wait until prompt disappears
		wait = new WebDriverWait(driver, 30);
		WebElement element = driver.findElement(By.cssSelector("div.bootbox-body"));
		wait.until(ExpectedConditions.stalenessOf(element));

		// verify that prompt is not present by finding unique element on
		// previous page
		Assert.assertTrue(driver.findElement(By.id("menuForAdmin")) != null);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}