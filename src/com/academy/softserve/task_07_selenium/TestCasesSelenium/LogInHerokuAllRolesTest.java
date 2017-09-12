package com.academy.softserve.task_07_selenium.TestCasesSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogInHerokuAllRolesTest {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "E:\\Sofserve\\Selenium drivers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * This test verifies that registered user(any role) can log in
     */
    @Test(description = "Tests a successful login", dataProvider = "userValidLoginPasswordProvider")
    public void logInHerokuWithValidData(String userLogin, String UserPassword) {
        driver.get("http://regres.herokuapp.com/login");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(userLogin);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(UserPassword);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        //LogOut
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'logout')]")));
        driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
    }

    @DataProvider(name = "userValidLoginPasswordProvider")
    public Object[][] userValidLoginPasswordProvider() {
        return new Object[][]{
                {"registrator", "registrator"},
                {"admin", "admin"},
                {"qwerty", "qwerty"},
                {"andriy97", "andriy97"}
        };
    }

    /**
     * This test verifies that Unregistered user can't log in
     * and Error message 'Wrong username or password' shown.
     */
    @Test(description = "Tests a unsuccessful login", dataProvider = "userInvalidLoginPasswordProvider")
    public void logInHerokuWithInvalidData(String userLogin, String UserPassword) {
        driver.get("http://regres.herokuapp.com/login");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(userLogin);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(UserPassword);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='loginForm']/div[1]")));
        Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='loginForm']/div[1]")).getText(), "Неправильний логін або пароль");
    }

    @DataProvider(name = "userInvalidLoginPasswordProvider")
    public Object[][] userInvalidLoginPasswordProvider() {
        return new Object[][]{
                {"admin", "x"},
                {"x", "x"},
                {"", ""},
                {"x", ""},
                {"", "y"},
                {"x", "admin"}
        };
    }

    /**
     * This test verifies that user blocked if log in with correct login but incorrect password three times
     * and Error message 'Wrong username or password' shown
     */
    @Test(description = "Tests a blocking login if incorrect password", dataProvider = "userInvalidPasswordProvider", dependsOnMethods = {"logInHerokuWithValidData","logInHerokuWithInvalidData"})
    public void logInHerokuWithInvalidPassword(String userLogin, String UserPassword) {
        driver.get("http://regres.herokuapp.com/login");
        //blocked after 3 log in with incorrect password
        for (int i = 1; i < 3; i++) {
            driver.findElement(By.id("login")).clear();
            driver.findElement(By.id("login")).sendKeys(userLogin);
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(UserPassword);
            driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        }
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='loginForm']/div[1]")));
        driver.findElement(By.xpath(".//*[@id='loginForm']/div[1]")).getText().contains("Акаунт недоступний,\n" +
                "повторіть спробу через 5 хвилин");
    }

    @DataProvider(name = "userInvalidPasswordProvider")
    public Object[][] userInvalidPasswordProvider() {
        return new Object[][]{
                // {"registrator", ""},
                {"qwerty", ""}
        };
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
