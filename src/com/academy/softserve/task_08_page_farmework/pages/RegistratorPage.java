package com.academy.softserve.task_08_page_farmework.pages;

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

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getResourcesSearch() {
        return resourcesSearch;
    }

    public void setResourcesSearch(WebElement resourcesSearch) {
        this.resourcesSearch = resourcesSearch;
    }

    public WebElement getSubclassesOfObjects() {
        return subclassesOfObjects;
    }

    public void setSubclassesOfObjects(WebElement subclassesOfObjects) {
        this.subclassesOfObjects = subclassesOfObjects;
    }

    public WebElement getProcuration() {
        return procuration;
    }

    public void setProcuration(WebElement procuration) {
        this.procuration = procuration;
    }

    public WebElement getProcurationEnteringData() {
        return procurationEnteringData;
    }

    public void setProcurationEnteringData(WebElement procurationEnteringData) {
        this.procurationEnteringData = procurationEnteringData;
    }

    public WebElement getProcurationExtractFromRegister() {
        return procurationExtractFromRegister;
    }

    public void setProcurationExtractFromRegister(WebElement procurationExtractFromRegister) {
        this.procurationExtractFromRegister = procurationExtractFromRegister;
    }

    public WebElement getAddNewResource() {
        return addNewResource;
    }

    public void setAddNewResource(WebElement addNewResource) {
        this.addNewResource = addNewResource;
    }
}
