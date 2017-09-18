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
	//
	public WebElement confirmMessageUnblockAllCoowners;
	public WebElement closeButtonUnblockAllCoowners;
	public WebElement okButtonUnblockAllCoowners;
		
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
	/**
	 * @return the settings tab text
	 */
	public String getSettingsText(){
		return settings.getText().trim();
	}
	/**
	 * @return the communities tab text
	 */
	public String getCommunitiesText(){
		return communities.getText().trim();
	}
	/**
	 * @return the Unblock all coowners button text
	 */
	public String getUnblockAllCoownersText(){
		return unblockAllCoowners.getText().trim();
	}
	
	//click on Settings tab
	public void clickSettings(){
		settings.click();
	}
	//click on Communities tab
	public void clickCommunities(){
		communities.click();
	}
	//click on Unblock all coowners tab
	public void clickUnblockAllCoowners(){
		unblockAllCoowners.click();
	}
	
	
}
