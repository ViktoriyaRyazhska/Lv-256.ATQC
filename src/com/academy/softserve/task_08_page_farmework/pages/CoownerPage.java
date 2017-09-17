package com.academy.softserve.task_08_page_farmework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoownerPage {
    WebDriver driver;
    WebElement resourcesSearch;
    WebElement procuration;
    WebElement procurationEnteringData;
    WebElement procurationExtractFromRegister;

    public CoownerPage(WebDriver driver) {
        this.driver = driver;
        resourcesSearch = driver.findElement(By.cssSelector(".dropdown>a"));
        procuration = driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/a"));
        procurationEnteringData = driver.findElement(By.xpath(".//*[@id='menuForUser']"));
        procurationExtractFromRegister = driver.findElement(By.xpath(".//*[@id='navigationbar']/ul/li[3]/ul/li[2]/a"));
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

    public void setResourcesSearch(WebElement resourseSearch) {
        this.resourcesSearch = resourseSearch;
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
}
