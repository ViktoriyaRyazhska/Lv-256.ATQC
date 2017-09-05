package Selenium;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Atqcq194 {

	  private WebDriver driver;
	  
	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testAtq() throws Exception {
	    driver.get("http://regres.herokuapp.com/" + "/login");
	    driver.findElement(By.id("login")).clear();
	    driver.findElement(By.id("login")).sendKeys("admin");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("admin");
	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	    driver.findElement(By.linkText("Співвласники")).click();////li[contains(a, 'Coowners')]"))
	    driver.findElement(By.linkText("Неактивні")).click(); ////li[contains(a, 'Inactive')]
	    driver.findElement(By.xpath("//*[@id='example']/tbody/tr[3]/td[1]")).click();
//	    driver.findElement(By.cssSelector("td..firstName")).click();
	    driver.findElement(By.id("dLabel")).click();
	    driver.findElement(By.linkText("Зробити активними")).click();
	    driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
	    driver.findElement(By.xpath("//div[@id='header']/div[2]/div/div/button[2]")).click();
	    driver.findElement(By.linkText("Вихід")).click();
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    }

	 }

