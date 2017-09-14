package selenium;

import java.util.concurrent.TimeUnit;
import org.testng.Reporter;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * This TC verifies that after clicking on ‘Communities’ button on main menu of
 * Administrators session User able to activate the community.
 * 
 * @author Khrystyna Terletska
 *
 */

public class CheckActiveButton {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "D:\\Downloads\\111\\geckodriver.exe");
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// login:
		driver.get("http://regres.herokuapp.com/" + "/login?logout");
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}

	@BeforeMethod
	public void set() {
		driver.findElement(By.linkText("Громади")).click();
		// display inactive users
		List<WebElement> checkbox = driver.findElements(By.xpath(".//*[@id='inactiveCheckbox']"));

		if (!checkbox.get(0).isSelected()) {
			checkbox.get(0).click();
		}
	}

	@Test
	public void verifyCloseButton() {
		Reporter.log("Running VerifyCloseButton"); // create report
		driver.findElement(By.xpath("//tr[@class='commun']//*[text()='Siberia']/following::a[@id='activecommunity']"))
				.click();
		// Verify that message is appeared after clicking "Active" button
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"Ви впевнені, що хочете активувати цю громаду?");

		driver.findElement(By.className("close")).click();
		// Verify that communities display in "Inactive communities" table
		assertNotNull(driver.findElement(By.xpath("//tr[@class='commun']//*[text()='Siberia']")));

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='inactiveCheckbox']"));

		boolean isSelected = checkBoxElement.isSelected();
		checkBoxElement.click();
		isSelected = checkBoxElement.isSelected();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait when the community disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Siberia']")));
		// check that the community does not appear in active communities
		List<WebElement> elements = driver.findElements((By.xpath("//tr[@class='commun']//*[text()='Siberia']")));

		assertTrue(elements.size() < 1);
	}

	@Test
	public void verifyCancelButton() {
		Reporter.log("Running VerifyCancelButton"); // create report
		driver.findElement(By.xpath("//tr[@class='commun']//*[text()='Siberia']/following::a[@id='activecommunity']"))
				.click();
		// Verify that message is appeared after clicking "Active" button
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"Ви впевнені, що хочете активувати цю громаду?");

		driver.findElement(By.xpath("//button[@data-bb-handler='cancel']")).click();

		assertNotNull(driver.findElement(By.xpath("//tr[@class='commun']//*[text()='Siberia']")));

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='inactiveCheckbox']"));

		boolean isSelected = checkBoxElement.isSelected();
		checkBoxElement.click();
		isSelected = checkBoxElement.isSelected();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait when the community disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Siberia']")));
		// check that the community does not appear in active communities
		List<WebElement> elements = driver.findElements((By.xpath("//tr[@class='commun']//*[text()='Siberia']")));
		assertTrue(elements.size() < 1);

	}

	@Test
	public void verifyOKButton() {
		Reporter.log("Running VerifyOkButton"); // create report
		driver.findElement(By.xpath("//tr[@class='commun']//*[text()='Siberia']/following::a[@id='activecommunity']"))
				.click();
		// Verify that message is appeared after clicking "Active" button
		assertEquals(driver.findElement(By.className("bootbox-body")).getText(),
				"Ви впевнені, що хочете активувати цю громаду?");

		driver.findElement(By.xpath("//button[@data-bb-handler='confirm']")).click();
		// Verify that message is appeared after clicking "Active" button
		assertNotNull(driver.findElement(By.xpath(
				"//tr[@class='commun']//*[text()='Siberia']/following::a[@id='activecommunity' and @disabled='disabled']")));

		WebElement checkBoxElement = driver.findElement(By.xpath(".//*[@id='inactiveCheckbox']"));

		System.out.println("Checkbox is displayed " + checkBoxElement.isDisplayed());

		boolean isSelected = checkBoxElement.isSelected();
		checkBoxElement.click();
		isSelected = checkBoxElement.isSelected();

		driver.navigate().refresh();
		// Verify that community is saved the table with active communities
		assertNotEquals(driver.findElement(By.className("communName")).getText(), "Siberia");

	}

	@AfterClass
	public void tearDown() {
		// close browser:
		driver.quit();
	}
}
/**
 * WebElement checkBoxElement =
 * driver.findElement(By.xpath(".//*[@id='inactiveCheckbox']"));
 * 
 * checkBoxElement.click();
 * 
 * WebDriverWait wait = new WebDriverWait(driver, 10); WebElement element =
 * wait.until(ExpectedConditions.elementToBeClickable(checkBoxElement.click));
 * assertEquals(true, checkBoxElement.isSelected()); elementToBeSelected
 * wait.until(ExpectedConditions.elementToBeSelected(checkBoxElement.click));
 */

/**
 * List<WebElement> checkbox =driver.findElements(By.id("inactiveCheckbox"));
 * 
 * WebElement checkBoxElement = checkbox.get(0);
 * 
 * assertEquals(true, checkBoxElement.isSelected()); checkBoxElement.click();
 * WebElement checkBoxElement = driver.findElements(By.id("inactiveCheckbox"));
 * List<WebElement> checkbox =driver.findElements(By.id("inactiveCheckbox"));
 * 
 * if(checkbox.get(0).isSelected()) { checkbox.get(0).click(); } }
 */
