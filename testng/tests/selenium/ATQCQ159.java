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

public class ATQCQ159 {
 
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.gecko.driver","D:\\stuff_for_testng_firefox\\geckodriver.exe");   
  }

  @AfterClass
  public void afterClass() {
  }
  
  /**
   * This test verifies 'Clear form' button 
   * on Communities/Add new community page
   * After entering any data in Community name, Community number fields
   * and clicking on Clear form, both fields must become blank
   */
  @Test
  public void findGroup(){
	  WebDriver driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.get("http://regres.herokuapp.com/");
	  
	  driver.findElement(By.id("login")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("admin");
	  driver.findElement(By.xpath("//*[@type='submit']")).click();
	  
	  driver.findElement(By.xpath("//*[@class='nav navbar-nav']//a[@href='/administrator/communities/show-all-communities']")).click(); //href???
	  driver.findElement(By.xpath("//p[@class='pull-left']/*[@class='btn btn-success']")).click();
	  
	  driver.findElement(By.name("name")).sendKeys("anyletters");
	  driver.findElement(By.name("registrationNumber")).sendKeys("123456789");
	   
	  driver.findElement(By.xpath("//div[@class='button']/button[@type='reset']")).click();
	  
	  Assert.assertEquals(driver.findElement(By.name("name")).getText().length(),0);
	  Assert.assertEquals(driver.findElement(By.name("registrationNumber")).getText().length(), 0);
	  
  }

}
