package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistratorPage {
    WebDriver driver;
    WebElement resourcesSearch;//винести окремою сторінкою
    WebElement subclassesOfObjects;
    WebElement procuration;
    WebElement procurationEnteringData;
    WebElement procurationExtractFromRegister;
    WebElement addNewResource;

    public RegistratorPage(WebDriver driver) {
        this.driver = driver;
        resourcesSearch = driver.findElement(By.cssSelector(".dropdown>a"));
        subclassesOfObjects=driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/a"));
        procuration = driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/a"));
        procurationEnteringData = driver.findElement(By.xpath(".//*[@id='menuForUser']"));
        procurationExtractFromRegister = driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/ul/li[2]/a"));
        addNewResource=driver.findElement(By.linkText("Add new resource"));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getResourcesSearch() {
        return resourcesSearch;
    }

    public WebElement getSubclassesOfObjects() {
        return subclassesOfObjects;
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

    public WebElement getAddNewResource() {
        return addNewResource;
    }
}