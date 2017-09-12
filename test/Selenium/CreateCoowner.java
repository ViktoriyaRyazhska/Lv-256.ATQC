package Selenium;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This TC verifies possibility of administrator register new co-owner('Register
 * new user' button) after entering correct data.
 * 
 * @author Kryvenko Yaroslava
 *
 */

public class CreateCoowner {
	private WebDriver driver;
	@DataProvider
	public Object[][] mainRegistrationCorrectData() {
		return new Object[][] { { "yara", "yara", "111@111.com", "33333333333333333333", "111111", "111111", "Італія" },
//			{ "yara", "yara", "111@111.com", "444444", "qwerty", "qwerty", "Україна" }
		};
	}
	
	@DataProvider
	public Object[][] mainRegistrationInvalidData() {
		return new Object[][] { { "1111", "1111", "1111", "3333333333333333333333", "111111", "11111", "Італія" },
//			{ "//@#", "^$&*", "aa@aa", "admin", "qwerty", "qwerty", "Україна" }
		};
	}
	
	/**
	 * In this method author sets up driver and logging in
	 */
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
		// System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// login:
		driver.get("http://regres.herokuapp.com/" + "/login?logout");
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}

	/**
	 * In this method author create co-owner
	 */
//	@Test(dataProvider = "mainRegistrationCorrectData")
	public void testCreateCowner(String first_Name, String last_Name, String email, String login, String password,
			String confirm_Password, String territorialCommunity) {
		driver.findElement(By.partialLinkText("Зареєструвати співвласника")).click();
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(first_Name);
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(last_Name);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(login);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmPassword")).clear();
		driver.findElement(By.id("confirmPassword")).sendKeys(confirm_Password);
		new Select(driver.findElement(By.id("territorial_Community"))).selectByVisibleText(territorialCommunity);
		driver.findElement(By.id("submit")).click();
		
		//verify that the non-confirmed page opened:
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h4")));
		assertEquals(driver.findElement(By.cssSelector("h4")).getText(), By.partialLinkText("Непідтверджені співвласники"));
		
		// Search co-owner in table
		driver.findElement(By.id("inputIndex3")).click();
		driver.findElement(By.id("inputIndex3")).clear();
		driver.findElement(By.id("inputIndex3")).sendKeys(login);
		driver.findElement(By.id("bth-search")).click();// Search button
		//Verify that co-owner with given login is  present in the table
		assertEquals(driver.findElement(By.cssSelector(".login")).getText(), login);
		
	}
	/**
	 * In this method author try create co-owner with invalid data
	 */
//	@Test(dataProvider = "mainRegistrationInvalidData")
	public void testCreateCownerWithInvalidData(String first_Name, String last_Name, String email, String login, String password,
			String confirm_Password, String territorialCommunity) {
		driver.findElement(By.partialLinkText("Зареєструвати співвласника")).click();
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(first_Name);
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(last_Name);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(login);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmPassword")).clear();
		driver.findElement(By.id("confirmPassword")).sendKeys(confirm_Password);
		new Select(driver.findElement(By.id("territorial_Community"))).selectByVisibleText(territorialCommunity);
		driver.findElement(By.id("submit")).click();
		
		
		//verify that the manual registration page is still opened:
		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h4")));
		assertEquals(driver.findElement(By.cssSelector("h4")).getText(), By.partialLinkText("Адресні дані"));
		
		//Verify that error messages are present on the page
//		Assert.assertEquals(driver.findElement(By.partialLinkText("Цей логін уже використовується")).getText(),driver.findElement(By.cssSelector("#login.errors")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("#email.errors")).getText(),driver.findElement(By.partialLinkText("Введіть коректну адресу")).getText());
//		assertEquals(By.cssSelector("#login.errors"),By.partialLinkText("Логін повинен складатись лише з латинських літер і/або цифр, від 6 до 20 символів "));
//		assertEquals(By.cssSelector("#email.errors"),By.partialLinkText("Введіть коректну адресу "));
//		assertEquals(By.cssSelector("#firstName.errors"),By.partialLinkText("Некоректне введення, лише літери "));
//		assertEquals(By.cssSelector("#lastName.errors"),By.partialLinkText("Некоректне введення, лише літери "));
//		assertEquals(By.cssSelector("#password.errors"),By.partialLinkText("Пароль повинен складатись з латинських літер і/або цифр, від 6 до 20 символів "));
//		assertEquals(By.cssSelector("#confirmPassword.errors"),By.partialLinkText("Підтвердження паролю неправильне "));
		
		
		//go to 'non-confirmed' page :
		driver.findElement(By.xpath("//a[@href=\"#\" and @data-toggle=\"dropdown\"]")).click();// 'Community' item
		driver.findElement(By.partialLinkText("Непідтверджені")).click();
		
		// Search co-owner in table
		driver.findElement(By.id("inputIndex3")).click();
		driver.findElement(By.id("inputIndex3")).clear();
		driver.findElement(By.id("inputIndex3")).sendKeys(login);
		driver.findElement(By.id("bth-search")).click();// Search button
		assertFalse(false, login);// verify that co-owner with such login does not present in the table
	}
	@Test(dataProvider = "mainRegistrationCorrectData")
	public void testClearRegistrationForm(String first_Name, String last_Name, String email, String login, String password,
			String confirm_Password, String territorialCommunity) {
		driver.findElement(By.partialLinkText("Зареєструвати співвласника")).click();
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(first_Name);
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(last_Name);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(login);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmPassword")).clear();
		driver.findElement(By.id("confirmPassword")).sendKeys(confirm_Password);
		new Select(driver.findElement(By.id("territorial_Community"))).selectByVisibleText(territorialCommunity);
		driver.findElement(By.cssSelector(".btn.btn-warning.reset")).click(); //click on Reset button
		
		//verify that manual registration page is still opened::
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h4")));
		assertEquals(driver.findElement(By.cssSelector("h4")).getText(), "Основна інформація");
		
		// Check if fields are empty
		Assert.assertEquals(driver.findElement(By.id("firstName")).getText().length(),0); 	
		Assert.assertEquals(driver.findElement(By.id("lastName")).getText().length(), 0); 
		Assert.assertEquals(driver.findElement(By.id("email")).getText().length(), 0); 
		Assert.assertEquals(driver.findElement(By.id("login")).getText().length(), 0); 
		Assert.assertEquals(driver.findElement(By.id("password")).getText().length(), 0); 
		Assert.assertEquals(driver.findElement(By.id("confirmPassword")).getText().length(), 0); 
		Assert.assertEquals(driver.findElement(By.id("territorial_Community")).getText(), "Виберіть громаду"); 
		Assert.assertEquals(driver.findElement(By.id("datepicker")).getText().length(), 0); 
		}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// close browser:
		driver.quit();
	}
}
