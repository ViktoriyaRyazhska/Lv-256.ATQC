import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebElement loginName;
	private WebElement password;
	private WebElement submit;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// Check Page Exist
		if (!driver.getTitle().toLowerCase().startsWith("oms")) {
			throw new RuntimeException("This is not the login page");
		}
		loginName = driver.findElement(By.name("j_username"));
		password = driver.findElement(By.name("j_password"));
		submit = driver.findElement(By.name("submit"));
	}

	private void setLoginData(String login, String password) {
		this.loginName.clear();
		this.loginName.sendKeys(login);
		this.password.clear();
		this.password.sendKeys(password);
		this.submit.click();
	}

	public WebElement getLoginName() {
		return loginName;
	}

	public AdminHomePage successAdminLogin(String validLogin, String password) {
		setLoginData(validLogin, password);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(loginName));
		return new AdminHomePage(driver);
	}

	public LoginPage unsuccesfulLogin(String invalidLogin, String password) {
		setLoginData(invalidLogin, password);
		return new LoginPage(driver); // return this;
	}
}