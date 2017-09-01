package home.home;

import org.testng.annotations.Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewTest {
	private WebDriver driver;
	// private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Test
	public void testFace() {
		System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.google.com.ua/");
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("facebook");
		driver.findElement(By.id("lst-ib")).submit();
		driver.findElement((By.xpath("//*[@name='btnK']"))).click();
		driver.findElement(By.linkText("Facebook� ������ ��� �������������")).click();
		Assert.assertEquals(driver.getTitle(), "Facebook � ������ ��� �������������");
		driver.quit();
	}																																																																			

	@AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    }
}
