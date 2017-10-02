package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoownerHomePage {
	WebDriver driver;
	WebElement resourcesSearch;
	WebElement procuration;
	WebElement procurationEnteringData;
	WebElement procurationExtractFromRegister;

	public CoownerHomePage(WebDriver driver) {
		this.driver = driver;
		resourcesSearch = driver.findElement(By.cssSelector(".dropdown>a"));
		procuration = driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/a"));
		procurationEnteringData = driver.findElement(By.xpath(".//*[@id='menuForUser']"));
		procurationExtractFromRegister = driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/ul/li[2]/a"));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getResourcesSearch() {
		return resourcesSearch;
	}

	public WebElement getProcuration() {
		return procuration;
	}

	public WebElement getProcurationEnteringData() {
		return procurationEnteringData;
	}

	public WebElement getProcurationExtractFromRegister() {
		return procurationExtractFromRegister;
	}
}