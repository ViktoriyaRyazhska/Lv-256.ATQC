package framework.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.pages.SubclassesOfObjects;
import framework.pages.RegistratorHomePage;
import framework.subclassesOfObjectsPage.AddNewSubclassPage;

public class SubclassesOfObjects extends RegistratorHomePage {
	public WebElement addNewSubclass;
	public WebElement listOfAllSubclassesTitle;
	public WebElement nameSubclass;
	// Webelement delete;

	public SubclassesOfObjects(WebDriver driver) {
		super(driver);
		addNewSubclass = driver.findElement(By.xpath("//a[contains(@href,\'addrestype\')]"));
		listOfAllSubclassesTitle = driver.findElement(By.xpath("//*[@id='body']/div/h4"));
	}
	public WebElement getNameSubclas() {
		nameSubclass = driver.findElement(By.xpath("//*[@id='datatable']//td[contains(., 'Sidney')]"));
		return nameSubclass;
	}

	public WebElement getlistOfAllSubclassesTitle() {
		return listOfAllSubclassesTitle;
	}

	public WebElement getAddNewSubclass() {
		return addNewSubclass;
	}

	public AddNewSubclassPage clickAddNewSubclass() {
		addNewSubclass.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.stalenessOf(listOfAllSubclassesTitle));
		return new AddNewSubclassPage(driver);
	}

}
