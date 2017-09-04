package com.softserve.edu;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class BrowsersTest {

	WebDriver driver;

	// @Test
	public void findChromeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\ATQC_new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Cheese!");
		driver.findElement(By.name("q")).submit();
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				System.out.println("running apply");
				return d.getTitle().contains("Cheese!");
			}
		});
		Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("cheese!"));
		driver.quit();
	}

	// @Test
	public void findChromeCustomiseTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\ATQC_new\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--start-maximized");
		// driver = new ChromeDriver(options);

		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		// options.setBinary("C:\\WINDOWS\\notepad.exe");

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(capabilities);

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
		Assert.assertTrue(driver.getTitle().contains("Cheese"));
		driver.quit();
	}

	// @Test
	public void findEdgeTest() {
		System.setProperty("webdriver.edge.driver", "D:\\ATQC_new\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Cheese!");
		driver.findElement(By.name("q")).submit();

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});
		Assert.assertTrue(driver.getTitle().contains("Cheese"));
		driver.quit();
	}

//	@Test
	public void findHTMLUnitTest() {

		WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		// ((HtmlUnitDriver) driver).setJavascriptEnabled(true);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("\tdriver.get http://www.google.com DONE");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		System.out.println("\telement.sendKeys Cheese! DONE");
		System.out.println("\tPage title is: " + driver.getTitle());
		element.submit();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleContains("Cheese"));
		System.out.println("\tPage title is: " + driver.getTitle());

		driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
		System.out.println("\tELEMENT IS " + driver.findElement(By.id("firstHeading")).getText());
		Assert.assertEquals(driver.findElement(By.id("firstHeading")).getText(), "Cheese");
		driver.quit();
	}

//	@Test
	public void runHTMLDriver() throws Exception {
		// WebDriver driver = new HtmlUnitDriver();
		// ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
		WebDriver driver = new HtmlUnitDriver(true);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("\tdriver.get http://www.google.com DONE");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		System.out.println("\telement.sendKeys Cheese! DONE");
		System.out.println("\tPage title is: " + driver.getTitle());
		element.submit();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleContains("Cheese"));
		System.out.println("\tPage title is: " + driver.getTitle());

		driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
		System.out.println("\tELEMENT IS " + driver.findElement(By.id("firstHeading")).getText());
		Assert.assertEquals(driver.findElement(By.id("firstHeading")).getText(), "Cheese");
		driver.quit();
	}

	 @Test
	public void remoteDriver() throws Exception {
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("D:\\ATQC_new\\chromedriver.exe")).usingPort(8181).build();
		// .usingAnyFreePort()

		service.start();
		System.out.println("Service Start");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--ignore-certificate-errors");
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new RemoteWebDriver(service.getUrl(), capabilities);
		System.out.println("WebDriver Start");
		System.out.println("Port = " + service.getUrl());

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Cheese!");
		driver.findElement(By.name("q")).submit();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.titleContains("Cheese"));
		System.out.println("\tPage title is: " + driver.getTitle());

		driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
		System.out.println("\tELEMENT IS " + driver.findElement(By.id("firstHeading")).getText());
		Assert.assertEquals(driver.findElement(By.id("firstHeading")).getText(), "Cheese");
		service.stop();
		System.out.println("Service Stop");
	}

	// @AfterTest
	public void closeDriver() {
		driver.close();

	}
}
