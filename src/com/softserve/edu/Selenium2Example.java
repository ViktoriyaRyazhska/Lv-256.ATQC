package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2Example {
	public static void main(String[] args) {

		// 1 - Ok
		// Simple test
		System.setProperty("webdriver.gecko.driver", "D:\\ATQC_new\\geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();

		// 2 - Bad
		// Test with profile
//		ProfilesIni profileIni = new ProfilesIni();
//		FirefoxProfile profile = profileIni.getProfile("default");
//		// profile.setAcceptUntrustedCertificates(true);
		// profile.setPreference("app.update.enabled", false);
		// WebDriver driver = new FirefoxDriver(profile);

		// 3
		//
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setAcceptUntrustedCertificates(true);
//		profile.setPreference("network.http.use-cache", false);
//		profile.setPreference("app.update.enabled", false);
//		File file = new File("./lib/firebug-2.0.18-fx.xpi");
//		System.out.println("Start");
//		profile.addExtension(file);
//		System.out.println("Ok");
//		profile.setPreference("extensions.firebug.currentVersion", "2.0.18");
//		profile.setPreference("extensions.firebug.console.enableSites", true);
//		profile.setPreference("extensions.firebug.script.enableSites", true);
//		profile.setPreference("extensions.firebug.net.enableSites", true);
//		profile.setPreference("extensions.firebug.cookies.enableSites", true);
//		WebDriver driver = new FirefoxDriver(profile);

		// System.setProperty("webdriver.chrome.driver",
		// "D:\\ATQC_new\\selenium\\chromedriver.exe");
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--ignore-certificate-errors");
		// options.addArguments("--start-maximized");
		// WebDriver driver = new ChromeDriver(options);

		// System.setProperty("webdriver.edge.driver",
		// "D:\\ATQC_new\\selenium\\MicrosoftWebDriver.exe");
		// WebDriver driver = new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("Page title is: " + driver.getTitle());
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		System.out.println("Page title is: " + driver.getTitle());
		element.submit();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				System.out.println("running apply");
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});
		System.out.println("Page title is: " + driver.getTitle());
		 driver.quit();
	}
}
