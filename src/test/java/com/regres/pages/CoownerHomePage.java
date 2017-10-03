package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoownerHomePage extends DropdownHomePage {
    private String RESOURSE_SEARCH_CSS = ".dropdown>a";
    private String PROCURATION_XPATH = ".//*[@id='navigationbar']/ul/li[3]/a";
    private String PROCURATION_ENTERING_DATA = ".//*[@id='menuForUser']";
    private String PROCURATION_EXTRACT_FROM_REGISTER = ".//*[@id='navigationbar']/ul/li[3]/ul/li[2]/a";

    public CoownerHomePage(WebDriver driver) {
        super(driver);
        getResourcesSearch();
        getProcuration();
        getProcurationEnteringData();
        getProcurationExtractFromRegister();
    }

    public WebElement getResourcesSearch() {
        return driver.findElement(By.cssSelector(RESOURSE_SEARCH_CSS));
    }

    public WebElement getProcuration() {
        return driver.findElement(By.xpath(PROCURATION_XPATH));
    }

    public WebElement getProcurationEnteringData() {
        return driver.findElement(By.xpath(PROCURATION_ENTERING_DATA));
    }

    public WebElement getProcurationExtractFromRegister() {
        return driver.findElement(By.xpath(PROCURATION_EXTRACT_FROM_REGISTER));
    }
}