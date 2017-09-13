package Selenium;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This test case verify that Commissioner see co-owners from his community only
 * 
 * @author Kryvenko Yaroslava
 *
 */

public class Atqcq191 {
	private WebDriver driver;

	@DataProvider
	public Object[][] commisionerLoggin() {
		return new Object[][] { { "andriy", "andriy" } };
	}

	/**
	 * In this method author sets up driver and logging in
	 */
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		// driver sets up
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
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();// Sign in button
		// open Active user list:
		driver.findElement(By.xpath("//a[@href=\"#\" and @data-toggle=\"dropdown\"]")).click();// 'Community' item
		driver.findElement(By.partialLinkText("Активні")).click();
	}

	/**
	 * This method find Commissioner community
	 */
	@Test(dataProvider = "commisionerLoggin")
	public void verifyCommisionerCommunity(String login, String password) throws Exception {
		// Search commissioner in table
		driver.findElement(By.id("inputIndex3")).click();
		driver.findElement(By.id("inputIndex3")).clear();
		driver.findElement(By.id("inputIndex3")).sendKeys(login);
		driver.findElement(By.id("bth-search")).click();// Search button
		// String commisionerCommnuityName = driver.findElement(By.className("territorialCommunity_name")).getText();
		String commisionerCommnuityName = driver.findElement(By.xpath(".//*[@id='example']/tbody/tr[1]/td[5]"))
				.getText();

		// Refresh Active co-owners table
		driver.findElement(By.id("inputIndex3")).clear();
		driver.findElement(By.id("bth-search")).click();
		
		// for every page of table
		List<WebElement> tablePages = driver.findElements(By.cssSelector(".paginate_button"));
		for (WebElement tablePage : tablePages) {
			// Verify every row with commissioner community name
			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("edit")));
			List<WebElement> tableRows = driver.findElements(By.xpath("//tbody/tr"));
			for (WebElement tableRow : tableRows) {
				// assertTrue(true,tableRow.findElements(By.className("territorialCommunity_name")).contains(commisionerCommnuityName));
				assertEquals(tableRow.findElement(By.className("territorialCommunity_name")).getText(),
						commisionerCommnuityName);// community name of all users should have the same name with
													// community of commissioner
			}
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}
}
