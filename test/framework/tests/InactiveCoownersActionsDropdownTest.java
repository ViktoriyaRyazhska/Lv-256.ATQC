package framework.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.pages.AdminHomePage;
import framework.pages.LoginPage;
import framework.pages.coowners.actions.CoownersTable;
import framework.pages.coowners.actions.InactiveCoownersActionsDropdown;
import framework.testdata.UserContainer;

public class InactiveCoownersActionsDropdownTest {
	private WebDriver driver;
	private String baseURL;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseURL = "http://regres.herokuapp.com";
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@Test
	// this test verify that confirm message appears when not chosen coowner
	public void verifyThatErrorMessageAppearsWhenNotChosenCoowner() {
		driver.get(baseURL);
		LoginPage loginpage = new LoginPage(driver);
		AdminHomePage adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		CoownersTable coowners = adminhomepage.goToInactiveCoowners();
		InactiveCoownersActionsDropdown inactiveActions = coowners.goToInactiveCoowners();
		
		inactiveActions.clickActionsDropdown();
		inactiveActions.clickUnblock();
		Assert.assertEquals(inactiveActions.confirm.getConfirmMessageText(), "Для виконання даної операції спочатку потрібно вибрати співвласників, натиснувши на відповідні стрічки в таблиці");
	}
}
