package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class CommissionerWithRegistrationHomePage extends CommissionerHomePage {
	public WebElement registration;

	public CommissionerWithRegistrationHomePage(WebDriver driver) {
		super(driver);
		registration=driver.findElement(By.cssSelector("[href*='manualregistration']"));
	}

	public WebElement getRegistration() {
		return registration;
	}

	public void setRegistration(WebElement registration) {
		this.registration = registration;
	}
	public void clickRegistration() {getRegistration().click();}
	
//	public LoginPage successLogout() {
//		clickMenuDownButton(driver);	
//		clickRegistration();
//		// Return a new page object representing the destination.
//		return new RegistrationTablePage(driver);
//	}
}
