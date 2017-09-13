package tests.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Task: Verify that Administrator can't add new community with the same name.
 */
public class ATQCQ157 {

	WebDriver driver;

	/**
	 * Logging in as admin.
	 */
	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", "D:\\stuff_for_testng_firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/");
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
	
	
	/**
	 * In beforeMethod we're opening 'Add new community' page
	 * And create new Community for further testing
	 * 
	 */
	@BeforeMethod
	public void beforeMethod() {

		driver.findElement(
 				By.xpath("//*[@class='nav navbar-nav']//a[contains(@href,'show-all-communities')]"))
 				.click();
		driver.findElement(By.xpath("//p[@class='pull-left']/*[@class='btn btn-success']")).click();
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("registrationNumber")).clear();
		driver.findElement(By.name("name")).sendKeys("SameName");
		driver.findElement(By.name("registrationNumber")).sendKeys("000:00:00:000:00001");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	/**
	 * In this method we delete the community after our test.
	 */
	@AfterMethod
	public void deleteCommunity() {

		driver.findElement(
				By.xpath("//*[@class='nav navbar-nav']//a[@href='/administrator/communities/show-all-communities']"))
				.click(); // open Communities tab

		driver.findElement(By
				.xpath("//tr[@class='commun']//*[text()='SameName']/following::a[@id='deletecommunity']"))
				.click(); // Locating recently created Community
							// and clicking on delete
		driver.findElement(By.xpath("//*[@data-bb-handler='confirm']")).click(); // Confirmation
																					// window

	}
	
	/**
	 * Quiting the driver
	 */
	@AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
	
	/**
	 * This test is created to verify that two communities with the same name
	 * couldn't be created.
	 * In this method we're attempting to create the same community as we created in the BeforeMethod.
	 * By using Assert methods we verify that error message appears and the same community is not created. 
	 */
	@Test
	public void testCreationWithSameName(){
		
		driver.findElement(
				By.xpath("//*[@class='nav navbar-nav']//a[@href='/administrator/communities/show-all-communities']"))
				.click();
		driver.findElement(By.xpath("//p[@class='pull-left']/*[@class='btn btn-success']")).click();
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("registrationNumber")).clear();
		driver.findElement(By.name("name")).sendKeys("SameName");
		driver.findElement(By.name("registrationNumber")).sendKeys("000:00:00:000:00001");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Assert.assertNotNull(driver.findElement(By.id("name.errors"))); //verify that error message has appeared
		
		driver.get("http://regres.herokuapp.com/administrator/communities/show-all-communities"); //get back to the 'all communities' tab
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//tr[@class='commun']//*[text()='SameName']")) //verify that new community
				.size() == 1);                                                                                          //is not created
	}
	
}
