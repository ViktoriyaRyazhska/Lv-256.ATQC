package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminSettingsPage extends AdminHomePage {
	
	private WebElement timeZoneBlockTitle;
	private WebElement timeZoneLabel;
	private WebElement timeZoneField;
	private WebElement confirmChangesButton;
	private WebElement searchResult;
	public AdminSettingsPage(WebDriver driver) {
		super(driver);
		timeZoneBlockTitle = driver.findElement(By.xpath("//form[@id='сhangeReg']/div[2]//h3[@class='panel-title']"));
		timeZoneLabel = driver.findElement(By.xpath("//form[@id='сhangeReg']/div[2]//p"));
		timeZoneField = driver.findElement(By.xpath("//form[@id='сhangeReg']/div[2]//input"));
		confirmChangesButton = driver.findElement(By.id("confirmRegistrationMethod"));
	}

	public WebElement getTimeZoneBlockTitle() {
		return timeZoneBlockTitle;
	}

	public WebElement getTimeZoneLabel() {
		return timeZoneLabel;
	}

	public WebElement getTimeZoneField() {
		return timeZoneField;
	}

	public WebElement getConfirmChangesButton() {
		return confirmChangesButton;
	}
	
	public String getTimeZoneBlockTitleText() {
		return timeZoneBlockTitle.getText().trim();
	}

	public String getTimeZoneLabelText() {
		return timeZoneLabel.getText().trim();
	}
	
	public String getTimeZoneFieldText() {
		
		return timeZoneField.getAttribute("value");
	}
	
	public AdminSettingsPage setTimeZone(String timezone) {
		timeZoneField.clear();
		timeZoneField.sendKeys(timezone);
		(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.className("autocomplete-suggestion")));
		searchResult = driver.findElement(By.xpath("//*[@data-index='0']"));
		searchResult.click();
		confirmChangesButton.click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.stalenessOf(timeZoneBlockTitle));
		return new AdminSettingsPage(driver);
	}

}
