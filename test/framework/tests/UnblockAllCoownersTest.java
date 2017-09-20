package framework.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.pages.AdminHomePage;
import framework.pages.LoginPage;
import framework.pages.TitleLocalFooter.ChangeLanguageFields;
import framework.testdata.UserContainer;

public class UnblockAllCoownersTest {
	private WebDriver driver;
	private String baseURL;
	AdminHomePage adminhomepage;
	

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseURL = "http://regres.herokuapp.com";
		driver.get(baseURL);
		LoginPage loginpage = new LoginPage(driver);
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		
	}

	@AfterClass
	public void tearDown() {
		adminhomepage.clickLogout();
		driver.close();
	}

	@Test(dataProvider="langProvider")
	public void checkValidLoginAdmin(ChangeLanguageFields language,String message) {
		adminhomepage.setLanguage(language);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		adminhomepage.clickUnblockAllCoowners();
		Assert.assertTrue(adminhomepage.getConfirmMessageUnblockAllCoownersText().equals(message));
		adminhomepage.clickOkButtonOnConfirmUnblockAllCoowners();
		Assert.assertTrue(adminhomepage.getConfirmMessageUnblockAllCoownersText()==null);
		adminhomepage.clickUnblockAllCoowners();
		adminhomepage.clickCloseButtonOnConfirmUnblockAllCoowners();
		Assert.assertTrue(adminhomepage.getConfirmMessageUnblockAllCoownersText()==null);
	}
	
	@DataProvider
	public Object[] langProvider() {
		
		return new Object[][] {{ChangeLanguageFields.UKRAINIAN,"Ви успішно розблокували всіх співвласників"},{ChangeLanguageFields.ENGLISH,"Youvesuccessfullyunblockedallcoowners!"},{ChangeLanguageFields.RUSSIAN,"Выуспешноразблокироваливсехсовладельцев!"}};
	
	}
	
	
	
	
}

