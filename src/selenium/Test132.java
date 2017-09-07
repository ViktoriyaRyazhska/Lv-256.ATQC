package selenium;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test132 {
	WebDriver driver;

	@Before
	public void Set() {
		System.setProperty("webdriver.gecko.driver", "D:\\Downloads\\111\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/");

	}

	@Test
	public void CheckResetPassword() {
		driver.findElement(By.className("forgot-password")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("khrystynaterletska@gmail.com");
		driver.findElement(By.cssSelector("button.btn-primary.btn-block")).click();
		assertEquals("Повідомлення відравленне на вашу адресу", driver.findElement(By.cssSelector("strong")).getText());
		driver.quit();

		driver.quit();
	}
}
