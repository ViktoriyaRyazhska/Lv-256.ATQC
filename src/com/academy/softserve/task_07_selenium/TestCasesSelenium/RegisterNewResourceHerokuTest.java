package com.academy.softserve.task_07_selenium.TestCasesSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterNewResourceHerokuTest {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "E:\\Sofserve\\Selenium drivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://regres.herokuapp.com/login");
        new Select(driver.findElement(By.id("changeLanguage"))).selectByVisibleText("english");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("registrator");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("registrator");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    }

    /**
     * This test verifies that registrator can add resource and delete resource
     */
    @Test(description = "Tests a new resource registration")
    public void addNewResourseHeroku() {
        driver.findElement(By.linkText("Add new resource")).click();
        driver.findElement(By.id("owner_search")).clear();
        driver.findElement(By.id("owner_search")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("strong")).click();
        driver.findElement(By.id("w-input-search")).clear();
        driver.findElement(By.id("w-input-search")).sendKeys("зірка");// add new resource name
        new Select(driver.findElement(By.id("resourcesTypeSelect"))).selectByVisibleText("земельний");
        driver.findElement(By.id("pass")).click();
        addPointsToMap();
        driver.findElement(By.id("submitForm")).click();
        driver.findElement(By.linkText("Resources search")).click();
        driver.findElement(By.id("searchByParameterButton")).click();
        driver.findElement(By.id("search")).click();
        driver.findElement(By.cssSelector("input[type=\"search\"]")).clear();
        driver.findElement(By.cssSelector("input[type=\"search\"]")).sendKeys("зірка");
        driver.findElement(By.linkText("More")).click();
        driver.findElement(By.id("deleteResource")).click();
        driver.findElement(By.cssSelector("div.modal-footer > button.btn.btn-primary")).click();
        driver.findElement(By.xpath("//div[@id='header']/div[2]/div/div/button[2]")).click();
        driver.findElement(By.linkText("Sign out")).click();
    }

    public void addPointsToMap(){
        driver.findElement(By.linkText("Points")).click();
        driver.findElement(By.id("myparam1")).clear();
        driver.findElement(By.id("myparam1")).sendKeys("49");
        driver.findElement(By.id("myparam2")).clear();
        driver.findElement(By.id("myparam2")).sendKeys("49");
        driver.findElement(By.id("myparam3")).clear();
        driver.findElement(By.id("myparam3")).sendKeys("20");
        driver.findElement(By.id("myparam4")).clear();
        driver.findElement(By.id("myparam4")).sendKeys("23");
        driver.findElement(By.id("myparam5")).clear();
        driver.findElement(By.id("myparam5")).sendKeys("59");
        driver.findElement(By.id("myparam6")).clear();
        driver.findElement(By.id("myparam6")).sendKeys("6");
        driver.findElement(By.id("btnAddAreaPoint")).click();
        driver.findElement(By.name("resourceArea.poligons[0].points[1].latitudeDegrees")).clear();
        driver.findElement(By.name("resourceArea.poligons[0].points[1].latitudeDegrees")).sendKeys("49");
        driver.findElement(By.name("resourceArea.poligons[0].points[1].latitudeMinutes")).clear();
        driver.findElement(By.name("resourceArea.poligons[0].points[1].latitudeMinutes")).sendKeys("58");
        driver.findElement(By.name("resourceArea.poligons[0].points[1].latitudeSeconds")).clear();
        driver.findElement(By.name("resourceArea.poligons[0].points[1].latitudeSeconds")).sendKeys("26");
        driver.findElement(By.name("resourceArea.poligons[0].points[1].longitudeDegrees")).clear();
        driver.findElement(By.name("resourceArea.poligons[0].points[1].longitudeDegrees")).sendKeys("24");
        driver.findElement(By.name("resourceArea.poligons[0].points[1].longitudeMinutes")).clear();
        driver.findElement(By.name("resourceArea.poligons[0].points[1].longitudeMinutes")).sendKeys("17");
        driver.findElement(By.name("resourceArea.poligons[0].points[1].longitudeSeconds")).clear();
        driver.findElement(By.name("resourceArea.poligons[0].points[1].longitudeSeconds")).sendKeys("19");
        driver.findElement(By.id("btnAddAreaPoint")).click();
        driver.findElement(By.name("resourceArea.poligons[0].points[2].latitudeDegrees")).clear();
        driver.findElement(By.name("resourceArea.poligons[0].points[2].latitudeDegrees")).sendKeys("49");
        driver.findElement(By.name("resourceArea.poligons[0].points[2].latitudeMinutes")).clear();
        driver.findElement(By.name("resourceArea.poligons[0].points[2].latitudeMinutes")).sendKeys("53");
        driver.findElement(By.name("resourceArea.poligons[0].points[2].latitudeSeconds")).clear();
        driver.findElement(By.name("resourceArea.poligons[0].points[2].latitudeSeconds")).sendKeys("55");
        driver.findElement(By.name("resourceArea.poligons[0].points[2].longitudeDegrees")).clear();
        driver.findElement(By.name("resourceArea.poligons[0].points[2].longitudeDegrees")).sendKeys("24");
        driver.findElement(By.name("resourceArea.poligons[0].points[2].longitudeMinutes")).clear();
        driver.findElement(By.name("resourceArea.poligons[0].points[2].longitudeMinutes")).sendKeys("8");
        driver.findElement(By.name("resourceArea.poligons[0].points[2].longitudeSeconds")).clear();
        driver.findElement(By.name("resourceArea.poligons[0].points[2].longitudeSeconds")).sendKeys("42");
        driver.findElement(By.id("addPointsToMap")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
