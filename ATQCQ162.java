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

public class ATQCQ162 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "C:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/");
		new Select(driver.findElement(By.id("changeLanguage"))).selectByValue("en");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).submit();
	}

	@Test
	public void unblockUsers() {
		driver.findElement(By.id("unlockUsers")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bootbox-body")));
		Assert.assertEquals(driver.findElement(By.cssSelector("div.bootbox-body")).getText(),
				"Youve successfully unblocked all coowners!");

		driver.findElement(By.cssSelector("div.modal-footer>button.btn.btn-primary")).click();
		// Assert.assertNotEquals(driver.findElement(By.cssSelector("div.bootbox-body")).getText(),
		// "Youve successfully unblocked all coowners!");
		driver.findElement(By.id("unlockUsers")).click();
		driver.findElement(By.cssSelector("div.modal-body>button.bootbox-close-button.close")).click();
		// Assert.assertNotEquals(driver.findElement(By.cssSelector("div.bootbox-body")).getText(),
		// "Youve successfully unblocked all coowners!");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}