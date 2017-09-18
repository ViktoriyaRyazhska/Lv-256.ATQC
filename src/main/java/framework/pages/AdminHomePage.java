package main.java.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class representation of a Administrator home page with navigation bar.
 * 
 * @author Bohdan Zhyvko
 *
 */
public class AdminHomePage extends CommissionerHomePage {
	
	public WebDriver driver;
	public WebElement settingsTab;
	public WebElement communitiesTab;
	public WebElement unblockAllCoownersButton;
	
	/**
	 * Constructor initialize the WebDriver and navigation bar
	 * but should be English localization on the Administrator home page
	 *  
	 * @param driver
	 */
	public AdminHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.settingsTab = driver.findElement(By.partialLinkText("Settings"));
		this.communitiesTab = driver.findElement(By.partialLinkText("Communities"));
		this.unblockAllCoownersButton = driver.findElement(By.partialLinkText("Unblock all coowners"));
	}
	/**
	 * @param driver the WebDriver to set
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	/**
	 * @param settingsTab the settingsTab to set
	 */
	public void setSettingsTab(WebElement settingsTab) {
		this.settingsTab = settingsTab;
	}
	/**
	 * @param communitiesTab the communitiesTab to set
	 */
	public void setCommunitiesTab(WebElement communitiesTab) {
		this.communitiesTab = communitiesTab;
	}
	/**
	 * @param unblockAllCoownersButton the unblockAllCoownersButton to set
	 */
	public void setUnblockAllCoownersButton(WebElement unblockAllCoownersButton) {
		this.unblockAllCoownersButton = unblockAllCoownersButton;
	}
	
	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}
	/**
	 * @return the settingsTab
	 */
	public WebElement getSettingsTab() {
		return settingsTab;
	}
	/**
	 * @return the communitiesTab
	 */
	public WebElement getCommunitiesTab() {
		return communitiesTab;
	}
	/**
	 * @return the unblockAllCoownersButton
	 */
	public WebElement getUnblockAllCoownersButton() {
		return unblockAllCoownersButton;
	}	
}
