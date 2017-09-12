package selenium;

import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

/**
 * This TC verifies that after clicking on ‘Communities’ button on main menu of
 * Administrators session User able to activate the community.
 * 
 * @author Khrystyna Terletska
 *
 */

public class CheckActiveButton {
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\Downloads\\111\\geckodriver.exe");
		// Create a new instance of the Firefox driver
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
		
		@BeforeMethod(alwaysRun = true)
		public void set() {
		driver.findElement(By.linkText("Громади")).click();
		//display inactive users
		List<WebElement> checkbox = driver.findElements((By.xpath("//input[@type='checkbox']")));
		((WebElement) checkbox.get(0)).click();
	}

	@Test
	public void verifyCloseButton() {
		Reporter.log("Running VerifyCloseButton"); // create report
		driver.findElement(By.xpath(
				"//tr[@class='commun']//*[text()='Siberia']/../../td[text()='000:00:00:000:00001']/..//*[@id='activecommunity']"))
				.click();
		//Verify that message is appeared after clicking "Active" button 
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"Ви впевнені, що хочете активувати цю громаду?");

		driver.findElement(By.cssSelector("button.bootbox-close-button.close")).click();
        //update the page 
		driver.navigate().refresh();
		
        //Verify that community isn't save the table with active communities   
		assertNotEquals(driver.findElement(By.className("communName")).getText(), "Siberia");

	}

	@Test
	public void verifyCanselButton() {
		Reporter.log("Running VerifyCanselButton"); // create report
		driver.findElement(By.xpath(
				"//tr[@class='commun']//*[text()='Siberia']/../../td[text()='000:00:00:000:00001']/..//*[@id='activecommunity']"))
				.click();
		//Verify that message is appeared after clicking "Active" button 
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"Ви впевнені, що хочете активувати цю громаду?");

		driver.findElement(By.xpath("//button[@data-bb-handler='cancel']")).click();

		driver.navigate().refresh();
		//Verify that community isn't save the table with active communities   
		assertNotEquals(driver.findElement(By.className("communName")).getText(), "Siberia");

	}

	@Test
	public void verifyOKButton() {
		Reporter.log("Running VerifyOkButton"); // create report
		driver.findElement(By.xpath(
				"//tr[@class='commun']//*[text()='Siberia']/../../td[text()='000:00:00:000:00001']/..//*[@id='activecommunity']"))
				.click();
		//Verify that message is appeared after clicking "Active" button  
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"Ви впевнені, що хочете активувати цю громаду?");

		driver.findElement(By.xpath("//button[@data-bb-handler='confirm']")).click();

		driver.navigate().refresh();
		//Verify that community is saved the table with active communities
		assertEquals(driver.findElement(By.className("communName")).getText(), "Siberia");

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// close browser:
		driver.quit();
	}
}
