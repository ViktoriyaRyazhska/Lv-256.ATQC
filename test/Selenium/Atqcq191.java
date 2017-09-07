package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This test case verify that Commisioner see coowners from his community only
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
		//driver sets up
		System.setProperty("webdriver.gecko.driver", "D:\\QA\\ATQC\\selenium drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Set the wndow size
		driver.manage().window().setSize(new Dimension(1920,1080));
		// login:
		driver.get("http://regres.herokuapp.com/" + "/login?logout");
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("andriy");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("andriy");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		// open Active user list:
		driver.findElement(By.xpath("//a[@href=\"#\" and @data-toggle=\"dropdown\"]")).click();
		driver.findElement(By.partialLinkText("Активні")).click();
	}

	/**
	 * This method counts rows of table Active co-owners
	 */
	 public int count=0;
	@Test
	public int countTableRows() throws Exception {
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("edit")));
		List<WebElement> tableRows = driver.findElements(By.xpath("//tbody/tr"));
		for (WebElement tableRow : tableRows) {
			count++;
		}
		return count;
	}
	/**
	 * This method find Commisioner community 
	 */
	@Test(dataProvider = "commisionerLoggin")
	public void verifyCommisionerCommunity(String login, String password) throws Exception {
		//Serch commisioner in table
		driver.findElement(By.id("inputIndex3")).click();
		driver.findElement(By.id("inputIndex3")).clear();
		driver.findElement(By.id("inputIndex3")).sendKeys(login);
		driver.findElement(By.id("bth-search")).click();
		String commisionerCommnuityName = driver.findElement(By.className("territorialCommunity_name")).getText();
		//Return Active co-owners table
		driver.findElement(By.id("inputIndex3")).clear();
		driver.findElement(By.id("bth-search")).click();
	}
	/**
	 * 
	 * This method checks every table row and verifies their equals 
	 */	
	 @Test
	public void testCommunitiesEqual() throws Exception {
		//Verify every row with commisioner community name
		 for(int row=0; row<count-1; row++){
			 assertEquals(driver.findElement(By.className("territorialCommunity_name")).getText(), "Село");
		 }
	}


	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}
}
