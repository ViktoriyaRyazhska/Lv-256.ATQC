package tests.selenium;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import java.util.List;

/**
 *Task: Verify that Administrator can clear data from the 'Add new territorial community' form.
 */
public class ATQCQ159 {
 
	WebDriver driver;

	/**
	 * Logging in as admin.
	 */
  @BeforeClass
  public void logInAsAdmin() {
	  
	  System.setProperty("webdriver.gecko.driver","D:\\stuff_for_testng_firefox\\geckodriver.exe");   
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
   * Quiting the driver
   */
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  /**
   * This test verifies 'Clear form' button 
   * on Communities/Add new community page
   * After entering any data in Community name, Community number fields
   * and clicking on Clear form, both fields must become blank
   */
  @Test
  public void testClearButton(){
	  
	  driver.findElement(
				By.xpath("//*[@class='nav navbar-nav']//a[contains(@href,'show-all-communities')]"))
				.click(); 
	  driver.findElement(By.xpath("//p[@class='pull-left']/*[@class='btn btn-success']")).click();
	 
	  driver.findElement(By.name("name")).clear();
	  driver.findElement(By.name("name")).sendKeys("anyletters");
	  
	  driver.findElement(By.name("registrationNumber")).clear();
	  driver.findElement(By.name("registrationNumber")).sendKeys("123456789");
	   
	  driver.findElement(By.xpath("//div[@class='button']/button[@type='reset']")).click();
	  
	  Assert.assertEquals(driver.findElement(By.name("name")).getText().length(),0); // Check if 'Community name' field is empty	
	  Assert.assertEquals(driver.findElement(By.name("registrationNumber")).getText().length(), 0); //Check if 'Community number' field is empty
	  
  }

}
