package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import framework.pages.TitleLocalFooter.ChangeLanguageFields;

/**
 * Class representation of a Commissioner home page.
 *
 * @author Kryvenko Yaroslava
 *
 */
public class CommissionerHomePage extends DropdownHomePage {
	public WebElement registerNewUser;
	public WebElement coowners;
	public WebElement activeCoowners;
	public WebElement inactiveCoowners;
	public WebElement nonConfirmedCoowners;
	public WebElement blockedCoowners;

	public CommissionerHomePage(WebDriver driver) {
		super(driver);
		coowners = driver.findElement(By.xpath("//a[@data-toggle=\"dropdown\"]"));
	}

	public void clickCoowners() {
		clickUserName();
		coowners.click();
		activeCoowners = driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
		inactiveCoowners = driver
				.findElement(By.xpath("//a[@data-toggle='dropdown']/following::a[contains(@href, 'inactive')]"));
		nonConfirmedCoowners = driver.findElement(By.xpath("//a[contains(@href,\"notcomfirmed\")]"));
		blockedCoowners = driver.findElement(By.xpath("//a[contains(@href,\"block\")]"));
		registerNewUser = driver.findElement(By.xpath("//a[contains(@href,\"manualregistration\")]"));
	}

	public WebElement getCoowners() {
		return coowners;
	}

	public void setCoowners(WebElement coowners) {
		this.coowners = coowners;
	}

	public WebElement getActiveCoowners() {
		return activeCoowners;
	}

	public void setActiveCoowners(WebElement activeCoowners) {
		this.activeCoowners = activeCoowners;
	}

	public WebElement getInactiveCoowners() {
		return inactiveCoowners;
	}

	public void setInactiveCoowners(WebElement inactiveCoowners) {
		this.inactiveCoowners = inactiveCoowners;
	}

	public WebElement getNonConfirmedCoowners() {
		return nonConfirmedCoowners;
	}

	public void setNonConfirmedCoowners(WebElement nonConfirmedCoowners) {
		this.nonConfirmedCoowners = nonConfirmedCoowners;
	}

	public WebElement getBlockedCoowners() {
		return blockedCoowners;
	}

	public void setBlockedCoowners(WebElement blockedCoowners) {
		this.blockedCoowners = blockedCoowners;
	}

	public String getCoownersText() {
		return getCoowners().getText().trim();
	}

	public String getActiveCoownersText() {
		return getActiveCoowners().getText().trim();
	}

	public String getInactiveCoownersText() {
		return getInactiveCoowners().getText().trim();
	}

	public String getNonConfirmedCoownersText() {
		return getNonConfirmedCoowners().getText().trim();
	}

	public String getBlockedCoownersText() {
		return getBlockedCoowners().getText().trim();
	}

	public void clickActiveCoowners() {
		getActiveCoowners().click();
	}

	public void clickInactiveCoowners() {
		getInactiveCoowners().click();
	}

	public void clickNonConfirmedCoowners() {
		getNonConfirmedCoowners().click();
	}

	public void clickBlockedCoowners() {
		getBlockedCoowners().click();

	}

	public WebElement getRegisterNewUser() {
		return registerNewUser;
	}

	public void setRegisterNewUser(WebElement registerNewUser) {
		this.registerNewUser = registerNewUser;
	}

	public String getRegisterNewUserText() {
		return getRegisterNewUser().getText().trim();
	}

	@Override
	public CommissionerHomePage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new CommissionerHomePage(driver);
	}
}