package Selenium;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * This TC verify that Administrator can make Inactive coowners active in
 * 'Inactive coowners' list after clicking on 'Actions' menu item and 'Set as
 * Active' submenu.
 * 
 * @author Kryvenko Yaroslava
 *
 */

public class Atqcq194 {

	private WebDriver driver;

	/**
	 * In this method author sets up driver and logging in
	 */
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {		
		System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//Set the wndow size
		driver.manage().window().setSize(new Dimension(1920,1080));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/" + "/login");
		// login
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}

	/**
	 * In this method author makes inactive co-owner active
	 */
	@Test
	public void setInactiveCownerActive() throws Exception {
		driver.findElement(By.xpath("//a[@href=\"#\" and @data-toggle=\"dropdown\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"/administrator/users/get-all-users?statusType=inactive\"]")).click(); 
		driver.findElement(By.xpath("//*[@id='example']/tbody/tr[3]/td[1]")).click();// select co-owner
		driver.findElement(By.id("dLabel")).click();
		driver.findElement(By.className("unblock")).click();
		driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();// OK button
		
//		Assert.assertTrue((
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}
}
