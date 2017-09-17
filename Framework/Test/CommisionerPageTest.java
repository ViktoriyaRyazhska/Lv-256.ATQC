package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.CommisionerPage;

public class CommisionerPageTest {
	private String baseURL;
	private WebDriver driver;

	@Test
	public void clickCoowners() throws InterruptedException {
		CommisionerPage commisionerPage = new CommisionerPage(driver);
//		commisionerPage.coowners.click();
//		commisionerPage.active.click();
		commisionerPage.registration.click();
	}

	@BeforeClass
	public void beforeClass() {
		// driver sets up
		System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		baseURL = "http://regres.herokuapp.com/";
		// login as commissioner:
		
		logIn();
	}
	public void logIn() {
		// login as Comissioner:
		driver.get(baseURL + "/login?logout");
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("qwerty");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();//Click on 'Sign in' button
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
