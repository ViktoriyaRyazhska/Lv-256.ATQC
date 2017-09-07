package selenium;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test143 {
	WebDriver driver;

	@Test
	public void CheckLogOutButton() {
		System.setProperty("webdriver.gecko.driver", "D:\\Downloads\\111\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/");
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();
		driver.findElement(By.partialLinkText("Вихід")).click();
		assertEquals("Login", driver.getTitle());
		System.out.println("title of page is: " + driver.getTitle());
		driver.quit();

		driver.quit();

	}
}
