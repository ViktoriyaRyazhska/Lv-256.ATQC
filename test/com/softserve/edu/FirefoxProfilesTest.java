package com.softserve.edu;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirefoxProfilesTest {
	WebDriver driver;

	@BeforeTest
	public void startDriver() {
		System.setProperty("webdriver.gecko.driver", "D:\\ATQC_new\\geckodriver.exe");
	}

	// @Test
	public void simpleTest() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("Page title is: " + driver.getTitle());
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		System.out.println("Page title is: " + driver.getTitle());
		// WebElement button = driver.findElement(By.id("_fZl"));;
		// button.click();
		// driver.findElement(By.id("_fZl")).click();
		// driver.findElement(By.name("btnK")).click();
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				System.out.println("running apply");
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});
		System.out.println("Page title is: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Cheese! - Пошук Google");

	}

	// @Test
	public void testWithProfile() {
		ProfilesIni profileIni = new ProfilesIni();
		// First verify name of default profile name
		FirefoxProfile profile = profileIni.getProfile("user"); // user_profile
		profile.setAcceptUntrustedCertificates(false);
		profile.setPreference("app.update.enabled", false);
		// driver = new FirefoxDriver(profile);

		FirefoxOptions options = new FirefoxOptions().setProfile(profile);
		driver = new FirefoxDriver(options);

		System.out.println("Driver started");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("Page title is: " + driver.getTitle());
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		System.out.println("Page title is: " + driver.getTitle());
		// WebElement button = driver.findElement(By.id("_fZl"));
		// button.click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				System.out.println("running apply");
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});
		Assert.assertEquals(driver.getTitle(), "Cheese! - Пошук Google");
	}

	@Test
	public void ourSettingsForFireFox() {
		FirefoxProfile profile = new FirefoxProfile();
		System.out.println("Ok1");
		profile.setAcceptUntrustedCertificates(true);
		profile.setPreference("network.http.use-cache", false);
		profile.setPreference("app.update.enabled", false);
		File file = new File("./lib/firebug-2.0.18-fx.xpi");
		System.out.println("Start");
		profile.addExtension(file);
		System.out.println("Ok");
		profile.setPreference("extensions.firebug.currentVersion", "2.0.18");
		profile.setPreference("extensions.firebug.cookies.enableSites", true);
//		driver = new FirefoxDriver(profile);
		
		FirefoxOptions options = new FirefoxOptions().setProfile(profile);
		driver = new FirefoxDriver(options);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("Page title is: " + driver.getTitle());
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		System.out.println("Page title is: " + driver.getTitle());
//		WebElement button = driver.findElement(By.id("_fZl"));
//		button.click();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				System.out.println("running apply");
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});
		Assert.assertEquals(driver.getTitle(), "Cheese! - Пошук Google");
	}

	// @AfterTest
	public void closeDriver() {
		driver.quit();

	}
}
