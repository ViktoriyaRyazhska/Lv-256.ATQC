package tests.selenium;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ATQCQ158 {
	
	WebDriver driver;
	
 /**
  * In beforeMethod we're opening
  * 'Add new community' page
  */
	@BeforeMethod
	public void beforeMethod() {

		driver.findElement(
				By.xpath("//*[@class='nav navbar-nav']//a[@href='/administrator/communities/show-all-communities']"))
				.click();
		driver.findElement(By.xpath("//p[@class='pull-left']/*[@class='btn btn-success']")).click();
	}
/**
 * This method is used to delete recently created Communites,
 * Created by createCommunity test.
 * @param result is used to get parameters of current test run
 * 
 */
	@AfterMethod
	public void deleteCommunity(ITestResult result) {

		driver.findElement(
				By.xpath("//*[@class='nav navbar-nav']//a[@href='/administrator/communities/show-all-communities']"))
				.click(); // open Communities tab

		Object[] parameters = result.getParameters(); // get current parametrs

		
		driver.findElement(By.xpath("//tr[@class='commun']//*[text()='" + parameters[0].toString() 
				+ "']/../../td[text()='" + parameters[1].toString() + "']/..//*[@id='deletecommunity']")).click(); //Locating recently created Community 
																												   //and clicking on delete
		driver.findElement(By.xpath("//*[@data-bb-handler='confirm']")).click(); // Confirmation
																					// window

	}

	/**
	 * Logging in before class
	 */
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.gecko.driver","D:\\1\\drivers\\geckodriver.exe");   
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.get("http://regres.herokuapp.com/");
	  driver.findElement(By.id("login")).clear();
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("login")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("admin");
	  driver.findElement(By.xpath("//*[@type='submit']")).click();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  
  
  @DataProvider
  public Object[][] comun_name_number() {
    return new Object[][] {
    	{"New community 1" , "000:00:00:000:00001"} ,
    	{"New community 2" , "000:00:00:000:00002"} ,
    	{"New community 3" , "000:00:00:000:00003"} ,
    	{"New community 4" , "000:00:00:000:00004"}
    };
  }

  
  
  /**
   * This test verifies possibility of administrator
   * to add new Community (Communities tab/Add new community button)
   * After entering correct data( community name, community number in right format)
   * New community should be created and should appear in the 'Active Communities' table on the 'Communities' page.
   */
  @Test(dataProvider = "comun_name_number")
  public void createCommunity(String comun_name, String comun_number){
	  

	  driver.findElement(By.name("name")).clear();
	  driver.findElement(By.name("registrationNumber")).clear();
	  driver.findElement(By.name("name")).sendKeys(comun_name);
	  driver.findElement(By.name("registrationNumber")).sendKeys(comun_number);
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  
		Assert.assertTrue((driver
				.findElement(By.xpath(
						"//tr[@class='commun']//*[text()='" + comun_name + "']/../../td[text()='" + comun_number + "']"))!=null)); //Creation verification
		
  }
  
  
  
  

}
