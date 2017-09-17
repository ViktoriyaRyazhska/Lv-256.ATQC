package com.academy.softserve.task_08_page_farmework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class CoownerPageTest {
    private String baseURL;
    private WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        // driver sets up
        System.setProperty("webdriver.gecko.driver", "E:\\\\Sofserve\\\\Selenium drivers\\\\geckodriver-v0.18.0-win64\\\\geckodriver.exe\"");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baseURL = "http://regres.herokuapp.com/";
        // login as coowner:
        logIn();
    }

    public void logIn() {
        // login as coowner:
        driver.get(baseURL + "/login?logout");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("qwerty");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();//Click on 'Sign in' button
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}