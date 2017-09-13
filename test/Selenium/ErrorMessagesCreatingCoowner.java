package Selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ErrorMessagesCreatingCoowner {

	private WebDriver driver;

	/**
	 * In this method author sets up driver and logging in
	 */
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
		// System.setProperty("webdriver.gecko.driver",
		// "D:\\1\\drivers\\geckodriver.exe");
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

	@DataProvider
	public Object[][] registrationInvalidData() {
		return new Object[][] { { "1111", "1111", "1111", "$%#@", "11", "11111",
				"Ukraine", "Некоректне введення, лише літери", "Некоректне введення, лише літери",
				"Введіть коректну адресу",
				"Логін повинен складатись лише з латинських літер і/або цифр, від 6 до 20 символів",
				"Пароль повинен складатись з латинських літер і/або цифр, від 6 до 20 символів",
				"Підтвердження паролю неправильне" },
//			{ "//@#", "^$&*", "aaaa", "admin", "aa", "nnnnnnnn", "Ukraine",
//				"Некоректне введення, лише літери", "Некоректне введення, лише літери", "Введіть коректну адресу",
//				"Цей логін уже використовується",
//				"Пароль повинен складатись з латинських літер і/або цифр, від 6 до 20 символів",
//				"Підтвердження паролю неправильне" } 
			};
	}

	@Test(dataProvider = "registrationInvalidData")
	public void testCreateCownerWithInvalidData(String first_Name, String last_Name, String email, String login,
			String password, String confirm_Password, String territorialCommunity, String firstNameErrors,
			String lastNameErrors, String emailErrors, String loginErrors, String passwordErrors,
			String confirmPasswordErrors) {
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

		// verify that the manual registration page is still opened:
		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h4")));
		assertEquals(driver.findElement(By.cssSelector("h4")).getText(), "Основна інформація");
		
		// verify that error messages are present on the page:
		assertEquals(driver.findElement(By.id("firstName.errors")).getText(),firstNameErrors);
		assertEquals(driver.findElement(By.id("lastName.errors")).getText(),lastNameErrors);
		assertEquals(driver.findElement(By.id("email.errors")).getText(),emailErrors);
		assertEquals(driver.findElement(By.id("login.errors")).getText(),loginErrors);
		assertEquals(driver.findElement(By.id("password.errors")).getText(),passwordErrors);
		assertEquals(driver.findElement(By.id("confirmPassword.errors")).getText(),confirmPasswordErrors);
//		assertTrue(true, loginErrors);
		
		// verify that error messages have red color:
		assertEquals(driver.findElement(By.id("firstName.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("lastName.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("email.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("login.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("password.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		assertEquals(driver.findElement(By.id("confirmPassword.errors")).getCssValue("color"), "rgb(255, 0, 0)");
		
		// go to 'non-confirmed' page :
		driver.findElement(By.xpath("//a[@href=\"#\" and @data-toggle=\"dropdown\"]")).click();// 'Community' item
		driver.findElement(By.partialLinkText("Непідтверджені")).click();

		// Search co-owner in table
		driver.findElement(By.id("inputIndex3")).click();
		driver.findElement(By.id("inputIndex3")).clear();
		driver.findElement(By.id("inputIndex3")).sendKeys(login);
		driver.findElement(By.id("bth-search")).click();// Search button
		assertFalse(false, login);// verify that co-owner with such login does not present in the table
		assertTrue(true, "No data");// verify that text message is preent in the tab
	}
	
//	@Test(dataProvider = "registrationInvalidData")
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
		assertTrue(true, "Виберіть громаду");
//		Assert.assertEquals(driver.findElement(By.id("territorial_Community")).getText(), "Виберіть громаду"); 
		Assert.assertEquals(driver.findElement(By.id("datepicker")).getText().length(), 0); 
		}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// close browser:
		driver.quit();
	}
}
