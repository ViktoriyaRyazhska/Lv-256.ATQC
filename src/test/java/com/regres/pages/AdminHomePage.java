package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.regres.pages.manage.coowners.CoownersElementsOnPageDropdown;
import com.regres.pages.manage.coowners.actions.InactiveCoownersActionsDropdown;
import com.regres.pages.manage.coowners.actions.NonConfirmedCoownersActionsDropdown;

/**
 * Class representation of a Administrator home page with navigation bar.
 */
public class AdminHomePage extends CommissionerWithRegistrationHomePage {
	// these elements are for navigate on admin pages
	private WebElement settings;
	private WebElement communities;
	private WebElement unblockAllCoowners;
	// these elements are on confirm unblock all coowners
	private WebElement confirmMessageUnblockAllCoowners;
	private WebElement closeButtonUnblockAllCoowners;
	private WebElement okButtonUnblockAllCoowners;
	private String COMUNITIES_LOCATOR = "[href $= 'show-all-communities']";
	private String SETTINGS_LOCATOR = "[href $= 'settings']";
	private String UNBLOCK_ALL_COOWNERS_LOCATOR = "unlockUsers";
	private String OK_BUTTON_UNBLOCK_ALL_COOWNERS_LOCATOR = ".modal-footer > button";
	private String CLOSE_BUTTON_UNBLOCK_ALL_COOWNERS_LOCATOR = "close";
	private String CONFIRM_MESSAGE_UNBLOCK_ALL_COOWNERS_LOCATOR = "bootbox-body";

	/**
	 * Constructor initialize the WebDriver and navigation bar on the Administrator
	 * home page
	 * 
	 * @param driver
	 */
	public AdminHomePage(WebDriver driver) {
		// initialize these elements
		super(driver);
		this.communities = driver.findElement(By.cssSelector(COMUNITIES_LOCATOR));
		this.settings = driver.findElement(By.cssSelector(SETTINGS_LOCATOR));
		this.unblockAllCoowners = driver.findElement(By.id(UNBLOCK_ALL_COOWNERS_LOCATOR));
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
	 * @return the confirm message text appears when click on 'Unblock all coowners'
	 *         button
	 */
	public String getConfirmMessageUnblockAllCoownersText() {
		return confirmMessageUnblockAllCoowners.getText().trim();
	}

	// click on 'Settings' tab
	public AdminSettingsPage clickSettings() {
		this.settings.click();
		return new AdminSettingsPage(driver);
	}

	// click on 'Unblock all coowners' button
	public void clickUnblockAllCoowners() {
		this.unblockAllCoowners.click();
		// initialize these elements on confirm Unblock all coowners
		this.okButtonUnblockAllCoowners = driver.findElement(By.cssSelector(OK_BUTTON_UNBLOCK_ALL_COOWNERS_LOCATOR));
		this.closeButtonUnblockAllCoowners = driver
				.findElement(By.className(CLOSE_BUTTON_UNBLOCK_ALL_COOWNERS_LOCATOR));
		this.confirmMessageUnblockAllCoowners = driver
				.findElement(By.className(CONFIRM_MESSAGE_UNBLOCK_ALL_COOWNERS_LOCATOR));

	}

	// click on 'Close' button Unblock all coowners
	public void clickCloseButtonOnConfirmUnblockAllCoowners() {
		this.closeButtonUnblockAllCoowners.click();
	}

	// click on 'OK' button on confirm Unblock all coowners
	public AdminHomePage clickOkButtonOnConfirmUnblockAllCoowners() {
		this.okButtonUnblockAllCoowners.click();
		return new AdminHomePage(driver);
	}
  //click on 'Communities' tab
		public AdminCommunitiesPage clickCommunities() {
			this.communities.click();
			return new AdminCommunitiesPage(driver);
		}

	// Business Logic
	@Override
	public AdminHomePage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new AdminHomePage(driver);
	}

	public InactiveCoownersActionsDropdown goToInactiveCoowners() {
		this.clickCoowners();
		this.clickInactiveCoowners();
		// Return a new page object representing the destination.
		return new InactiveCoownersActionsDropdown(driver);
	}

	public NonConfirmedCoownersActionsDropdown goToNonConfirmedCoowners() {
		this.clickCoowners();
		this.clickNonConfirmedCoowners();
		// Return a new page object representing the destination.
		return new NonConfirmedCoownersActionsDropdown(driver);
	}
    public CoownersElementsOnPageDropdown selectInactiveCoowners() {
		this.clickCoowners();
		this.clickInactiveCoowners();
		// Return a new page object representing the destination.
		return new CoownersElementsOnPageDropdown(driver);
	}
	public CoownersElementsOnPageDropdown selectNonConfirmedCoowners() {
		this.clickCoowners();
		this.clickNonConfirmedCoowners();
		// Return a new page object representing the destination.
		return new CoownersElementsOnPageDropdown(driver);
	}
}
