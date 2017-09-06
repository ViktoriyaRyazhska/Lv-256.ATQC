package Selenium;

import org.testng.annotations.Test;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Atqcq161 {

	  private WebDriver driver;

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void test161() throws Exception {
	    driver.get("http://regres.herokuapp.com/");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("admin");
	    driver.findElement(By.id("login")).clear();
	    driver.findElement(By.id("login")).sendKeys("admin");
	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	    driver.findElement(By.id("unlockUsers")).click();   
	    assertEquals(driver.findElement(By.cssSelector("div.bootbox-body")).getText(), "Ви успішно розблокували всіх співвласників");
	    driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
//	    driver.findElement(By.className("btn btn-primary btn-sm dropdown-toggle")).click();
//	    driver.findElement(By.linkText("Вихід")).click();
	    driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
	    driver.findElement(By.xpath("//a[text()='Вихід']")).click();
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	  }

	}

