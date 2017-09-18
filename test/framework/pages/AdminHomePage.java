package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class representation of a Administrator home page with navigation bar.
 * 
 * @author Bohdan Zhyvko
 *
 */
public abstract class AdminHomePage extends CommissionerWithRegistrationHomePage {
	
	public WebElement settings;
	public WebElement communities;
	public WebElement unblockAllCoowners;
	
	/**
	 * Constructor initialize the WebDriver and navigation bar
	 * on the Administrator home page
	 *  
	 * @param driver
	 */
	public AdminHomePage(WebDriver driver) {
		//initialize these elements
		super(driver);
		this.settings = driver.findElement(By.cssSelector("[$href $= 'show-all-communities']");
		this.communities = driver.findElement(By.cssSelector("[href $= 'settings']"));
		this.unblockAllCoowners = driver.findElement(By.id("unlockUsers"));
	}
	// PageObject
	// get Data
	/**
	 * @return the settings
	 */
	public WebElement getSettings() {
		return settings;
	}
	/**
	 * @return the communities
	 */
	public WebElement getCommunities() {
		return communities;
	}
	/**
	 * @return the unblockAllCoowners
	 */
	public WebElement getUnblockAllCoowners() {
		return unblockAllCoowners;
	}
	
	// Functional
	public String get
	
	
	/**
	 * @param settings the settings to set
	 */
	public void setSettings(WebElement settings) {
		this.settings = settings;
	}
	/**
	 * @param communities the communities to set
	 */
	public void setCommunities(WebElement communities) {
		this.communities = communitiesTab;
	}
	/**
	 * @param unblockAllCoowners the unblockAllCoowners to set
	 */
	public void setUnblockAllCoowners(WebElement unblockAllCoowners) {
		this.unblockAllCoowners = unblockAllCoowners;
	}
}
