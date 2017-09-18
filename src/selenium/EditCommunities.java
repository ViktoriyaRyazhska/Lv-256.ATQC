package selenium;

import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This TC verifies that after clicking on �Communities� button on main menu of
 * Administrators session User able to edit territorial community and
 * registration number after clicking "Edit" on Communities page .
 * 
 * @author Khrystyna Terletska
 *
 */
public class EditCommunities {
	private WebDriver driver;

	@DataProvider
	public Object[][] EditData() {
		return new Object[][] { { "Crotia", "112:12:11:111:16548" } };
	}

	@DataProvider
	public Object[][] InvalidEditData() {
		return new Object[][] { { "Ukraine", "112:12:11:111:1656" } };
	}

	/**
	 * This method checks the driver settings and logging in
	 */
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// login:
		driver.get("http://regres.herokuapp.com/" + "/login?logout");
		// clear login input field
		driver.findElement(By.id("login")).clear();
		// Enter login
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		// click on 'Sign In'
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}

	/**
	 * This method edit correct information in territorial community and
	 * registration number fields.
	 */

	@Test(dataProvider = "EditData")
	public void testEditCommunities(String Name_community, String Registration_number) {
		Reporter.log("Running testEditCommunities"); // create report
		driver.findElement(By.linkText("")).click(); // find button "Communities" on main navigation tab
		driver.findElement(By.xpath("//tr[@class='commun']//*[text()='Croti']/following::a[@id='editcommunity']"))
				.click(); // driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys(Name_community);
		driver.findElement(By.name("registrationNumber")).clear();
		driver.findElement(By.name("registrationNumber")).sendKeys(Registration_number);
		driver.findElement(By.cssSelector("input.btn.btn-success")).click();

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		(new WebDriverWait(driver, 10)).until(
				ExpectedConditions.presenceOfElementLocated((By.xpath("//tr[@class='commun']//*[text()='Crotia']"))));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Verify that changes have been saved in the table "Communities"

		assertNotNull(driver.findElement(By.xpath("//tr[@class='commun']//*[text()='Crotia']")));

	}

	/**
	 * This method verify that error message is appeared when user enter invalid
	 * information in territorial community and registration number fields.
	 */
	@Test(dataProvider = "InvalidEditData")
	public void testInvalidEditCommunities(String Name_community, String Registration_number) {
		Reporter.log("Running testInvalidEditCommunities"); // create report
		driver.findElement(By.linkText("")).click();
		driver.findElement(By.xpath("//tr[@class='commun']//*[text()='Sri Lanka']/following::a[@id='editcommunity']"))
				.click(); //
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys(Name_community);
		driver.findElement(By.name("registrationNumber")).clear();
		driver.findElement(By.name("registrationNumber")).sendKeys(Registration_number);
		driver.findElement(By.cssSelector("input.btn.btn-success")).click();

		// Verify that error massages appears when enter existing community name and

		// invalid format registration number Please fill out this field.
		Assert.assertEquals(driver.findElement(By.id("name.errors")).getText(), "Підклас з вказаним іменем вже існує");
		Assert.assertEquals(driver.findElement(By.id("registrationNumber.errors")).getText(), "Невірний формат");

		// invalid format registration number
		Assert.assertEquals(driver.findElement(By.id("name.errors")).getText(), "");
		Assert.assertEquals(driver.findElement(By.id("registrationNumber.errors")).getText(), "");


	}

	@AfterClass
	public void tearDown() {
		// close browser:
		driver.quit();
	}
}