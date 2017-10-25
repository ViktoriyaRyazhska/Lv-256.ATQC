package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regres.testdata.AddNewResourceLocalization;

public class ResourceDetailPage extends RegistratorHomePage{
	
	private WebElement deleteResource;
	private WebElement resourceName;
	private WebElement okButton;
	String OK_BUTTON_LOCATOR = "[data-bb-handler='confirm']";
	String DELETE_RESOURCE_LOCATOR = "deleteResource";
	String RESOURCE_NAME_LOCATOR = "//td[text()=\'"+AddNewResourceLocalization.TEST_RESOURCE.getMessage()+"\']";
	
	public ResourceDetailPage(WebDriver driver) {
		super(driver);
		resourceName = driver.findElement(By.xpath(RESOURCE_NAME_LOCATOR));
		deleteResource = driver.findElement(By.id(DELETE_RESOURCE_LOCATOR));
	}

	public WebElement getResourceName() {
		return resourceName;
	}

	public WebElement getDeleteResource() {
		return deleteResource;
	}

	public void setDeleteResource(WebElement deleteResource) {
		this.deleteResource = deleteResource;
	}

	public void setResourceName(WebElement resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceNameText() {
		return resourceName.getText().trim();
	}
	public RegistratorHomePage deleteRes() {
		deleteResource.click();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		okButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OK_BUTTON_LOCATOR)));
		okButton.click();
		return new RegistratorHomePage(driver);
	}
}
