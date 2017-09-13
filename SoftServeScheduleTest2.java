package Atqc_tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.util.ArrayList;

public class SoftServeScheduleTest {

	WebDriver driver;
	WebDriverWait wait;
	WebDriverWait wait2;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "C:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://softserve.academy/");

	}

	@Test
	public void findSchedule() {
		Assert.assertEquals("SoftServe IT Academy. Learning Management System", driver.getTitle());

		String oldTab = driver.getWindowHandle();
		driver.findElement(By.xpath("//li[7]/div/div/div[2]/div/a/span[contains(text(),'Lviv: schedule')]")).click();
		

		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		// change focus to new tab
		driver.switchTo().window(newTab.get(0));
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Mimosa Scheduling Software"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertEquals("Schedules - Softserve University - by Mimosa Scheduling Software", driver.getTitle());

		driver.findElement(By.xpath("//*[contains(text(),'September 2017')]/../..//tr/td/a[text()='12']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Lv-256 ATQC')]")).click();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		wait2 = new WebDriverWait(driver, 15);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[4]/td[3][@class='ffffcc']")));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//tr[4]/td[3][@class='ffffcc']")) != null);
	}

	@AfterClass
    public void tearDown() {
        driver.quit();
	}

}