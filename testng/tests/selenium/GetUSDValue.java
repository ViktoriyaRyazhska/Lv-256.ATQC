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

public class GetUSDValue {
 
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
  
  
  @Test
  public void findGroup(){
	  WebDriver driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  driver.get("https://www.google.com.ua/");
	  driver.findElement(By.id("lst-ib")).clear();
	  driver.findElement(By.id("lst-ib")).sendKeys("Курс валют");
	  driver.findElement(By.id("lst-ib")).submit();
	  
	  //using xpath because of cyrillic chars problem By.linktext
	  driver.findElement(By.xpath("//*[@href='https://finance.i.ua/']")).click();
	  
	  String dollarBuy = driver.findElement(By.xpath("//div[@class='widget-currency_bank']//table[@class='table table-data -important']//th[text()='USD']/../td[1]/span//span[1]")).getText();
	  String dollarSell = driver.findElement(By.xpath("//div[@class='widget-currency_bank']//table[@class='table table-data -important']//th[text()='USD']/../td[2]/span//span[1]")).getText();
	  String dollarNbu = driver.findElement(By.xpath("//div[@class='widget-currency_bank']//table[@class='table table-data -important']//th[text()='USD']/../td[3]/span//span[1]")).getText();
	  System.out.println("Курс доллара:");
	  System.out.println("Купівля:"+dollarBuy);
	  System.out.println("Продаж:"+dollarSell);
	  System.out.println("НБУ:"+dollarNbu);
  }

}
