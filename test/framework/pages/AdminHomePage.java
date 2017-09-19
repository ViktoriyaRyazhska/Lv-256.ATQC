package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Class representation of a Administrator home page with navigation bar.
 * 
 * @author Bohdan Zhyvko
 *
 */
public class AdminHomePage extends CommissionerWithRegistrationHomePage {
	//these elements are for navigate on admin pages
	private WebElement settings;
	private WebElement communities;
	private WebElement unblockAllCoowners;
	//these elements are on confirm unblock all coowners
	private WebElement confirmMessageUnblockAllCoowners;
	private WebElement closeButtonUnblockAllCoowners;
	private WebElement okButtonUnblockAllCoowners;
		
	/**
	 * Constructor initialize the WebDriver and navigation bar
	 * on the Administrator home page
	 *  
	 * @param driver
	 */
	public AdminHomePage(WebDriver driver) {
		//initialize these elements
		super(driver);
		this.communities = driver.findElement(By.cssSelector("[href $= 'show-all-communities']"));
		this.settings = driver.findElement(By.cssSelector("[href $= 'settings']"));
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
	
	/**
	 * @return the confirmMessageUnblockAllCoowners
	 */
	public WebElement getConfirmMessageUnblockAllCoowners() {
		return confirmMessageUnblockAllCoowners;
	}
	/**
	 * @return the closeButtonUnblockAllCoowners
	 */
	public WebElement getCloseButtonUnblockAllCoowners() {
		return closeButtonUnblockAllCoowners;
	}
	/**
	 * @return the okButtonUnblockAllCoowners
	 */
	public WebElement getOkButtonUnblockAllCoowners() {
		return okButtonUnblockAllCoowners;
	}
	
	// Functional
	/**
	 * @return the settings tab text
	 */
	public String getSettingsText() {
		return settings.getText().trim();
	}
	/**
	 * @return the communities tab text
	 */
	public String getCommunitiesText() {
		return communities.getText().trim();
	}
	/**
	 * @return the Unblock all coowners button text
	 */
	public String getUnblockAllCoownersText() {
		return unblockAllCoowners.getText().trim();
	}
	/**
	 * @return the confirm message text appears when click on 'Unblock all coowners' button
	 */
	public String getConfirmMessageUnblockAllCoownersText() {
		return confirmMessageUnblockAllCoowners.getText().trim();
	}
	
	//click on 'Settings' tab
	public AdminSettingsPage clickSettings() {
		this.settings.click();
		return new AdminSettingsPage(driver);
	}
	//click on 'Communities' tab
	public void clickCommunities() {
		this.communities.click();
	}
	//click on 'Unblock all coowners' button
	public void clickUnblockAllCoowners() {
		this.unblockAllCoowners.click();
		//initialize these elements on confirm Unblock all coowners
		this.okButtonUnblockAllCoowners = driver.findElement(By.cssSelector(".modal-footer > button"));
		this.closeButtonUnblockAllCoowners = driver.findElement(By.className("close"));
		this.confirmMessageUnblockAllCoowners = driver.findElement(By.className("bootbox-body"));
		
	}
	//click on 'Close' button Unblock all coowners
	public void clickCloseButtonOnConfirmUnblockAllCoowners() {
		this.closeButtonUnblockAllCoowners.click();
	}
	//click on 'OK' button on confirm Unblock all coowners
	public void clickOkButtonOnConfirmUnblockAllCoowners() {
		this.okButtonUnblockAllCoowners.click();
	}
	
	// Business Logic
	public AdminHomePage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown()); 
		lang.selectByVisibleText(language.toString()); 
		// Return a new page object representing the destination.
		return new AdminHomePage(driver);
	}
}
