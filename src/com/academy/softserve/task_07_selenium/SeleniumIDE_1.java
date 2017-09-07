package com.academy.softserve.task_07_selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SeleniumIDE_1 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver",
        "E:\\Sofserve\\Selenium drivers\\chromedriver_win32\\chromedriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com.ua/";
        driver.manage().timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testTc3Wd() throws Exception {
        driver.get(baseUrl +
                "/?gfe_rd=cr&ei=Jp-hWLq3Hait8weA9I-IDw&gws_rd=ssl");
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib"))
                .sendKeys("eclipse download");
        driver.findElement(By.id("_fZl")).click();
        driver.findElement(By.linkText("Eclipse Downloads")).click();
        assertEquals(driver.findElement(By
                .cssSelector("span.orange.neon"))
                .getText(), "Neon");
        try {
            assertEquals(driver.findElement(By
                    .cssSelector("span.orange.neon"))
                    .getText(), "Neon");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString =
                verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


}
