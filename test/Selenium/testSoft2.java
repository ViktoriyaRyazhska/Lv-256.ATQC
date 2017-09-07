package Selenium;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Task - output on console a current course of dollar
 * 
 * @author Kryvenko Yaroslava
 *
 */

class testSoft2 {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void checkCourseDollar() {
		driver.get("https://privatbank.ua/ru/");
		String usd = driver.findElement(By.xpath("//*[@id='selectByPB']/tr[3]/td[2]")).getText();
		System.out.println("current course of dollar " + usd);

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}
}
