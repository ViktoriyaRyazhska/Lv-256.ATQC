package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This page appears when timezone(Admin->Settings->set timezone)
 * is set in the incorrect format
 * @author PETYAggg
 *
 */
public class OhErrorPage {
	
	private WebDriver driver;
	private WebElement errorTitle;
	private WebElement errorDescription;
	private WebElement goToHomePageButton;
	
	public OhErrorPage(WebDriver driver) {
		
		this.driver= driver;
		this.errorTitle = driver.findElement(By.xpath("//div[@class='alert alert-danger']/h3"));
		this.errorDescription = driver.findElement(By.xpath("//div[@class='alert alert-danger']/p"));
		this.goToHomePageButton = driver.findElement(By.className("btn"));
	}

	public WebElement getErrorTitle() {
		return errorTitle;
	}

	public WebElement getErrorDescription() {
		return errorDescription;
	}

	public WebElement getGoToHomePageButton() {
		return goToHomePageButton;
	}
	
	public String getErrorTitleText() {
		return errorTitle.getText();
	}

	public String getErrorDescriptionText() {
		return errorDescription.getText();
	}

	public String getGoToHomePageButtonText() {
		return goToHomePageButton.getText();
	}
	
	public AdminHomePage clickGoToHomePageButton() {
		
		goToHomePageButton.click();
		return new AdminHomePage(driver);
	}
	
}
