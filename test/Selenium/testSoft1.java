package Selenium;

import java.util.Iterator;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Tasks:
 * 1) find the site of Softserve Academy (softserve.academy), move to page with schedule of courses 
 * and verify if there is entering of ATQC group
 * 2) find your schedule on the site softserve.academy and verify that you have a class today*/

class testSoft1{
	private WebDriver driver;
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	  @Test
	  public void checkATQC()  {
	    driver.get("https://softserve.academy/");
	    //driver.findElement(By.xpath("//a[contains(span, 'Lviv')]")).click();
	    driver.findElement(By.partialLinkText("Lviv")).click();
	    Iterator<String> windowIter = driver.getWindowHandles().iterator();
	    windowIter.next();
	    String nextWindow=windowIter.next();
	    driver.switchTo().window(nextWindow);
	    driver.findElement(By.linkText("6")).click();	    
	    assertEquals(driver.findElement(By.linkText("Lv-256 ATQC")).getText(), "Lv-256 ATQC");// 1task from presentation
	    driver.findElement(By.linkText("Lv-256 ATQC")).click();
	    assertEquals(driver.findElement(By.linkText("Lv-256 ATQC")).getText(), "Lv-256 ATQC");// 2task from presentation

	   
	  }
		@AfterClass(alwaysRun = true)
		  public void tearDown() throws Exception {
		    driver.quit();
		    }
}

