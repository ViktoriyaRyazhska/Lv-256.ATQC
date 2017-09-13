package tests.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Task: Verify that Administrator can't add new community with Registration number in invalid format.
 */
public class ATQCQ122 {
	
	WebDriver driver;
	
	
	/**
	 * Logging in as admin.
	 */
  @BeforeClass
  public void logInAsAdmin() {
	  
	  System.setProperty("webdriver.gecko.driver","D:\\stuff_for_testng_firefox\\geckodriver.exe");   
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.get("http://regres.herokuapp.com/");
	  driver.findElement(By.id("login")).clear();
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("login")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("admin");
	  driver.findElement(By.xpath("//*[@type='submit']")).click();
  }
  
  
  /**
   * In beforeMethod we're opening
   * 'Add new community' page
   */
 	@BeforeMethod
 	public void openAddNewCommunity() {

 		driver.findElement(
 				By.xpath("//*[@class='nav navbar-nav']//a[contains(@href,'show-all-communities')]"))
 				.click();
 		driver.findElement(By.xpath("//p[@class='pull-left']/*[@class='btn btn-success']")).click();
 	}
 	
 	  @DataProvider
 	  public Object[][] bad_credentials() {
 	    return new Object[][] {
 	    	{"ShortDots" , "00:00:00:00:00"} ,
 	    	{"ShortNoDots" , "0000000000"} ,
 	    	{"LongDots" , "000:000:000:000:00000"} ,
 	    	{"LongNoDots" , "1111111111111111"},
 	    	{"Invalid", "String"},
 	    	{"SpecialChars", "$%/'8@"}
 	    };
 	  }
 	
 	
 	  /**
 	   * This test tests if a community with invalid registration number is not created.
 	   * @param name -  Community name from data provider
 	   * @param number - Community registration number in wrong format(from data provider)
 	   */
 	@Test(dataProvider = "bad_credentials")
 	public void invalidRegistrationNumber(String name, String number) {
 		
 		  driver.findElement(By.name("name")).clear();
		  driver.findElement(By.name("name")).sendKeys(name);				//enter data
 		  driver.findElement(By.name("registrationNumber")).clear();
 		  driver.findElement(By.name("registrationNumber")).sendKeys(number);
 		  
 		  driver.findElement(By.xpath("//input[@type='submit']")).click(); //submit
 		  
 		  Assert.assertNotNull(driver.findElement(By.id("registrationNumber.errors"))); //verify that error message has appeared
 		  
 		 driver.findElement(
  				By.xpath("//*[@class='nav navbar-nav']//a[contains(@href,'show-all-communities')]"))
  				.click(); //get back to the 'all communities' tab
 		 
 		 Assert.assertTrue( driver.findElements(By.xpath("//tr[@class='commun']//*[text()='" + name  //verify that new community
 				+ "']")).size()<1);								                                    // has not been created
 	}
 	
 	/**
	 * Quiting the driver
	 */
 	@AfterClass
 	public void tearDown() {
 		driver.quit();
 	}

}
