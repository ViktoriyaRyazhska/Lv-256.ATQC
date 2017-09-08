package com.softserve.edu.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium1Waits {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		// Preconditions
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");

		// Steps
		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));
		// Enter something to search for
		element.sendKeys("Cheese!");
		element.submit();

		// Check
		// Check the title of the page
		System.out.println("Page title is: " + driver.getTitle());
		// Google's search is rendered dynamically with JavaScript.
		// Wait for the page to load, timeout after 10 seconds
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});
		// Should see: "cheese! - Google Search"
		System.out.println("Page title is: " + driver.getTitle());
		// Close the browser
		driver.quit();
	}
}
