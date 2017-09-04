package tests.selenium;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

public class ATQCQ158 {
 
	WebDriver driver;
 
 
 @BeforeMethod
  public void beforeMethod() {
	   
	  driver.findElement(By.xpath("//*[@class='nav navbar-nav']//a[@href='/administrator/communities/show-all-communities']")).click();
	  driver.findElement(By.xpath("//p[@class='pull-left']/*[@class='btn btn-success']")).click();
  }

  @AfterMethod
  public void afterMethod() {
	  
  }

  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.gecko.driver","D:\\stuff_for_testng_firefox\\geckodriver.exe");   
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.get("http://regres.herokuapp.com/");
	  driver.findElement(By.id("login")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("admin");
	  driver.findElement(By.xpath("//*[@type='submit']")).click();
  }

  @AfterClass
  public void afterClass() {
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
  public void findGroup(String comun_name, String comun_number){
	  

	  
	  driver.findElement(By.name("name")).sendKeys(comun_name);
	  driver.findElement(By.name("registrationNumber")).sendKeys(comun_number);
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  
		Assert.assertTrue((driver
				.findElement(By.xpath(
						"//tr[@class='commun']//*[text()='" + comun_name + "']/../../td[text()='" + comun_number + "']"))!=null));
		
		
		
//		driver.findElement(By.xpath("//tr[@class='commun']//*[text()='" + comun_name + "']/../../td[text()='"
//				+ comun_number + "']/..//*[@id='deletecommunity']")).click();
//		driver.findElement(By.xpath("//*[@data-bb-handler='confirm']")).click();                    //delete
//		
  }

}
