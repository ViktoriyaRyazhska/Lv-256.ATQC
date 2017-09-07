package Selenium;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * This TC verifies that after clicking on *‘Unblock all co-owners’* button on
 * main menu of Administrators session User able to unblock all co-owners.
 * 
 * @author Kryvenko Yaroslava
 *
 */
public class Atqcq161 {

	private WebDriver driver;
	/**
	 * In this method author sets up driver and logging in
	 */
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//login:
		driver.get("http://regres.herokuapp.com/");
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}
	/**
	 * In this method author unblocks co-owners
	 */
	@Test
	public void unblockCoowners() throws Exception {
		driver.findElement(By.id("unlockUsers")).click();
		assertEquals(driver.findElement(By.cssSelector("div.bootbox-body")).getText(),
				"Âè óñï³øíî ðîçáëîêóâàëè âñ³õ ñï³ââëàñíèê³â");
		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
		// logout:
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'logout')]")));
		driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}

}
