package com.academy.softserve.task_07_selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Tasks: 1) find the site of Softserve Academy (softserve.academy), move to
 * page with schedule of courses and verify if there is entering of ATQC group
 * 2) find your schedule on the site softserve.academy and verify that you have
 * a class today
 */
public class SeleniumIDE_2 {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "E:\\Sofserve\\Selenium drivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void loginTestSofservwAcademy() {
        driver.get("https://www.google.com.ua/");
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("softserve.academy");
        driver.findElement(By.name("btnK")).click();
        driver.findElement(By.linkText("SoftServe IT Academy. Learning Management System")).click();
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("username")).sendKeys("mmandrtc");
        driver.findElement(By.id("password")).sendKeys("Nf-0}i..");
        driver.findElement(By.id("loginbtn")).click();
        driver.findElement(By.partialLinkText("Lviv")).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.findElement(By.partialLinkText(currentDay())).click();
        /** Task 1
         * find the site of Softserve Academy (softserve.academy), move to page with schedule of courses and
         * verify if there is entering of ATQC group
         */
        Assert.assertEquals(driver.findElement(By.linkText("Lv-256 ATQC")).getText(), "Lv-256 ATQC");
        /** Task 2
         * find your schedule on the site softserve.academy and verify that you have a class today
         */
        driver.findElement(By.linkText("Lv-256 ATQC")).click();

//        List<WebElement> elements2 = driver.findElements(By.xpath("html/body/font/center/font/table/tbody/tr[2]"));
//        for (WebElement webEl : elements2) {
//            System.out.println(webEl.getText());
//        }
//        driver.findElement(By.xpath("html/body/font/center/font/table/tbody/tr[2])"));

        List<WebElement> elements = driver.findElements(By.xpath("html/body/font/center/font/table/tbody/*/td[3]"));
        for (WebElement webEl : elements) {
            System.out.println(webEl.getText());
        }

    }

    public String currentMonth() {
        Date date = new Date();
        Locale locale = new Locale("en", "UK");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMMM", locale);
        String currentMonth = monthFormat.format(date);
        return currentMonth;
    }

    public String currentDay() {
        Date date = new Date();
        Locale locale = new Locale("en", "UK");
        SimpleDateFormat monthFormat = new SimpleDateFormat("d", locale);
        String currentDay = monthFormat.format(date);
        return currentDay;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
