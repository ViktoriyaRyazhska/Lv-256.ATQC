package com.regres.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regres.pages.LoginPage;

public class Application {

	private WebDriver driver;
	private ApplicationSources applicationSources;

	private Application(ApplicationSources applicationSources) {
		this.applicationSources = applicationSources;
	}

	public static Application get(ApplicationSources applicationSources) {
		Application instance = new Application(applicationSources);
		instance.driver = instance.getWebDriver();
		instance.driver.manage().timeouts().implicitlyWait(applicationSources.getImplicitTimeOut(), TimeUnit.SECONDS);

		return instance;
	}

	public LoginPage load() {
		driver.get(applicationSources.getLoginUrl());
		return new LoginPage(driver);
	}

	public LoginPage logout() {
		driver.get(applicationSources.getLogoutUrl());
		return new LoginPage(driver);
	}

	public void quit() {
		if (driver != null) {
			driver.quit();
		}
	}

	private WebDriver getWebDriver() {

		if (applicationSources.getBrowserName().toLowerCase().equals("firefox")) {
			return getFirefoxDriver();
		} else if (applicationSources.getBrowserName().toLowerCase().equals("chrome")) {
			return getChromeDriver();
		}
		// Get Default Browser
		return getFirefoxDriver();
	}

	private WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", applicationSources.getDriverPath());
		driver = new FirefoxDriver();
		return driver;
	}

	private WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", applicationSources.getDriverPath());
		driver = new ChromeDriver();
		return driver;
	}

	public Connection createDBConnection() throws ClassNotFoundException, SQLException {
		return applicationSources.createDBConnection();
	}

	public void closeConnectionDB() throws ClassNotFoundException, SQLException {
		applicationSources.closeConnectionDB();
	}
}
