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

public class SoftServeScheduleTest {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver", "D:\\stuff_for_testng_firefox\\geckodriver.exe");
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}
  
  
	@Test
	public void findGroup() {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.google.com.ua/");
		driver.findElement(By.id("lst-ib")).sendKeys("softserve.academy");
		driver.findElement(By.id("lst-ib")).submit();
		driver.findElement(By.linkText("SoftServe IT Academy. Learning Management System")).click();
		//switch to
		driver.get("https://softserve.academy/mod/resource/view.php?id=5001&redirect=1");

		driver.findElement(By.xpath("//*[contains(text(),'September')]/../..//tr/td/a[text()='5']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Lv-256 ATQC')]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//tr/td[3][@class='ffffcc']")) != null);

	}

}
