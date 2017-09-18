package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class RegistratorPage extends DropdownHomePage {
    // Fields
    WebElement resourcesSearch;//винести окремою сторінкою
    WebElement subclassesOfObjects;
    WebElement procuration;
    WebElement addNewResource;
    //
    WebElement procurationEnteringData;
    WebElement procurationExtractFromRegister;

    public RegistratorPage(WebDriver driver) {
        super(driver);
        resourcesSearch = driver.findElement(By.cssSelector(".dropdown>a"));
        subclassesOfObjects = driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/a"));
        procuration = driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/a"));
        //procurationEnteringData = driver.findElement(By.xpath(".//*[@id='menuForUser']"));
        //procurationExtractFromRegister = driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/ul/li[2]/a"));
        addNewResource = driver.findElement(By.linkText("Add new resource"));
    }

    public WebElement getResourcesSearch() {
        return resourcesSearch;
    }

    public String getResourcesSearchText() {
        return getResourcesSearch().getText();
    }

    public ResourcesSearchPage clickResourcesSearch() {
        getResourcesSearch().click();
        return new ResourcesSearchPage(driver);
    }

    public WebElement getSubclassesOfObjects() {
        return subclassesOfObjects;
    }

    public String getSubclassesOfObjectsText() {
        return getSubclassesOfObjects().getText();
    }

    public void clickSubclassesOfObjects() {
        getSubclassesOfObjects().click();
    }

    public WebElement getProcuration() {
        return procuration;
    }

    public String getProcurationText() {
        return getProcuration().getText();
    }

    public void clickProcuration() {
        getProcuration().click();
    }

    public WebElement getAddNewResource() {
        return addNewResource;
    }

    public String getAddNewResourceText() {
        return getAddNewResource().getText();
    }

    public void clickAddNewResource() {
        getAddNewResource().click();
    }
}