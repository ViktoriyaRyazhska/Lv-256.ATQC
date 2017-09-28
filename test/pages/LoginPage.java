package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.User;

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

	private void setLoginData(User user) {
		this.loginName.clear();
		this.loginName.sendKeys(user.getLoginName());
		this.password.clear();
		this.password.sendKeys(user.getPassword());
		this.submit.click();
	}

	public WebElement getLoginName() {
		return loginName;
	}

	public AdminHomePage successAdminLogin(User validUser) {
		setLoginData(validUser);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(loginName));
		return new AdminHomePage(driver);
	}

	public LoginPage unsuccesfulLogin(User user) {
		setLoginData(user);
		return new LoginPage(driver); // return this;
	}
}