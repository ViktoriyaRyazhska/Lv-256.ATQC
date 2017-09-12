package selenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test144 {
	WebDriver driver;

	@Before
	public void Set() {
		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/");
		driver.findElement(By.className("forgot-password")).click();
	}

	@Test
	public void checkRegisterLink() {
		driver.findElement(By.xpath(".//*[@id='login_fieldset']/div/span[2]/a")).click();
		Assert.assertEquals(driver.getTitle(), "Register new user");
		System.out.println("Page title is: " + driver.getTitle());
	
		driver.quit();
	}

	@Test
	public void checkLoginLink() {
		driver.findElement(By.xpath(".//*[@id='login_fieldset']/div/span[1]/a")).click();
		Assert.assertEquals(driver.getTitle(), "Login");
		System.out.println("Page title is: " + driver.getTitle());

		driver.quit();
	}
}
