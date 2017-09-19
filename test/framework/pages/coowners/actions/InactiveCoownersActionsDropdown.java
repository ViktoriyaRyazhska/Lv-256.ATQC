package framework.pages.coowners.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.pages.CoownersTable;

/**
 * Class representation of 'Actions' dropdown on 'Inactive coowners' page for Administrator home page or Commisioner Home Page
 * 
 */
public class InactiveCoownersActionsDropdown extends CoownersTable {
	// these elements are in 'Actions' dropdown
	private WebElement unblock;
	private WebElement block;
	private WebElement setCommunity;

	// confirm message
	private WebElement confirmMessage;
	private WebElement closeButton;
	private WebElement okButton;

	// set community confirm message
	private WebElement titleMessage;
	private WebElement communityLabel;
	private WebElement communityInput;
	private WebElement cancelSetCommunityButton;

	/**
	 * Constructor initialize the WebDriver on 'Inactive coowners' page for 'Actions' dropdown
	 * 
	 * @param driver
	 */
	public InactiveCoownersActionsDropdown(WebDriver driver) {
		super(driver);
	}

	// PageObject
	// get Data	
	/**
	 * @return the unblock
	 */
	public WebElement getUnblock() {
		return unblock;
	}

	/**
	 * @return the block
	 */
	public WebElement getBlock() {
		return block;
	}

	/**
	 * @return the setCommunity
	 */
	public WebElement getSetCommunity() {
		return setCommunity;
	}

	/**
	 * @return the confirmMessage
	 */
	public WebElement getConfirmMessage() {
		return confirmMessage;
	}

	/**
	 * @return the closeButton
	 */
	public WebElement getCloseButton() {
		return closeButton;
	}

	/**
	 * @return the okButton
	 */
	public WebElement getOkButton() {
		return okButton;
	}

	/**
	 * @return the titleMessage
	 */
	public WebElement getTitleMessage() {
		return titleMessage;
	}

	/**
	 * @return the communityLabel
	 */
	public WebElement getCommunityLabel() {
		return communityLabel;
	}

	/**
	 * @return the communityInput
	 */
	public WebElement getCommunityInput() {
		return communityInput;
	}

	/**
	 * @return the cancelSetCommunityButton
	 */
	public WebElement getCancelSetCommunityButton() {
		return cancelSetCommunityButton;
	}

	// Functional
	/**
	 * @return String the unblock Text
	 */
	public String getUnblockText() {
		return unblock.getText().trim();
	}

	/**
	 * @return String the block Text
	 */
	public String getBlockText() {
		return block.getText().trim();
	}

	/**
	 * @return String the setCommunity Text
	 */
	public String getSetCommunityText() {
		return setCommunity.getText().trim();
	}
	/**
	 * @return String the confirmMessage Text
	 */
	public String getConfirmMessageText() {
		return confirmMessage.getText().trim();
	}
	
	/**
	 * @return String the okButton Text
	 */
	public String getOkButtonText() {
		return okButton.getText().trim();
	}

	/**
	 * @return String the titleMessage Text
	 */
	public String getTitleMessageText() {
		return titleMessage.getText().trim();
	}

	/**
	 * @return String the communityLabel Text
	 */
	public String getCommunityLabelText() {
		return communityLabel.getText().trim();
	}

	/**
	 * @return String the cancelSetCommunityButton Text
	 */
	public String getCancelSetCommunityButtonText() {
		return cancelSetCommunityButton.getText().trim();
	}
	
	// click on "Action" dropdown
	public void clickActionsDropdown() {
		this.getActions().click();
		// initialize these elements in 'Action' dropdown
		this.unblock = driver.findElement(By.className("unblock"));
		this.block = driver.findElement(By.className("block"));
		this.setCommunity = driver.findElement(By.className("set-community"));
	}

	// click on "Unblock"
	public void clickUnblock() {
		this.unblock.click();
		// initialize these elements on 'Unblock' confirm message
		simpleConfirmMessage();
	}

	// click on "Block"
	public void clickBlock() {
		this.block.click();
		// initialize these elements on 'Block' confirm message
		simpleConfirmMessage();
	}
	
	/**
	 *  click on "Set community" but you can`t select coowners 
	 *  by clicking on the rows in the table
	 */
	public void clickSetCommunityButNotSelectedCoowners() {
		this.setCommunity.click();
		// initialize these elements on 'Set community' Don`t selected confirm message
		simpleConfirmMessage();
	}

	/**
	 *  click on "Set community" before that you must select coowners 
	 *  by clicking on the rows in the table
	 */
	public void clickSetCommunity() {
		this.setCommunity.click();
		// initialize these elements on 'Set community' confirm message
		this.okButton = driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
		this.closeButton = driver.findElement(By.className("close"));
		this.cancelSetCommunityButton = driver.findElement(By.cssSelector(".btn.btn-info"));
		this.titleMessage = driver.findElement(By.className("modal-title"));
		this.communityLabel = driver.findElement(By.className("control-label"));
		this.communityInput = driver.findElement(By.id("tc_search"));
	}
	
	//click on 'Confirm' on "Set community"
	public void clickConfirmOnSetCommunityMessage() {
		this.okButton.click();
		// initialize these elements on 'Confirm' confirm message after 'Set community' confirm message
		simpleConfirmMessage();
	}
	
	/**
	 * initialize elements on the 'Confirm message':
	 *  - confirm message
	 *  - 'OK' button
	 *  - close button
	 */
	public void simpleConfirmMessage() {
		// initialize these elements for all confirm message 
		//but only without 'Set community' confirm message 
		//when choose coowners on the table
		this.confirmMessage = driver.findElement(By.className("bootbox-body"));
		this.okButton = driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
		this.closeButton = driver.findElement(By.className("close"));
	}
}
