package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Class representation of a Commissioner home page.
 *
 * @author Kryvenko Yaroslava
 *
 */
public abstract class CommissionerHomePage extends DropdownHomePage{
    public WebElement coowners;
    public WebElement activeCoowners;
    public WebElement inactiveCoowners;
    public WebElement nonConfirmedCoowners;
    public WebElement blockedCoowners;
    public CommissionerHomePage (WebDriver driver) {
        super(driver);
        coowners=driver.findElement(By.xpath("//a[@data-toggle=\"dropdown\"]"));        
    }
    public void clickCoowners(WebDriver driver) {
    	clickUserName();
    	clickCoowners();
    	activeCoowners=driver.findElement(By.xpath("//a[contains(@href,\"get-all-users\")]"));
        inactiveCoowners=driver.findElement(By.cssSelector(".dropdown-menu [href$='inactive']"));
        nonConfirmedCoowners=driver.findElement(By.xpath("//a[contains(@href,\"notcomfirmed\")]"));
        blockedCoowners=driver.findElement(By.xpath("//a[contains(@href,\"block\")]"));
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
	public void clickCoowners() {
		getCoowners().click();
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
}