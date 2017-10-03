package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminCommunitiesPage extends AdminHomePage {
	private WebElement addNewCommunityButton;
	private WebElement communitiesLabel;
	private WebElement inactiveCheckbox;
	private WebElement inactiveCheckboxLabel;
	private WebElement tableWithCommunities;
	private WebElement territorialCommunityHeader;
	private WebElement registrationNumberHeader;
	private WebElement actionsHeader;
	private WebElement editCommunityButton;
	private WebElement deleteCommunityButton;
	private WebElement activeCommunityButton;

	public AdminCommunitiesPage(WebDriver driver) {
		super(driver);
		addNewCommunityButton = driver.findElement(By.cssSelector("a.btn.btn-success"));
		communitiesLabel = driver.findElement(By.xpath("//h4"));
		inactiveCheckbox = driver.findElement(By.id("inactiveCheckbox"));
		inactiveCheckboxLabel = driver.findElement(By.xpath("//div[2]/label"));
		tableWithCommunities = driver
				.findElement(By.cssSelector("table.table.table-striped.table-bordered.table-hover"));
		territorialCommunityHeader = driver
				.findElement(By.xpath("//thead//th[1]"));
		registrationNumberHeader = driver
				.findElement(By.xpath("//thead//th[2]"));
		actionsHeader = driver.findElement(By.xpath("//thead//th[3]"));
		editCommunityButton = driver.findElement(By.id("editcommunity"));
		deleteCommunityButton = driver.findElement(By.id("deletecommunity"));
		activeCommunityButton = driver.findElement(By.id("activecommunity"));
	}

	public WebElement getAddNewCommunityButton() {
		return addNewCommunityButton;
	}

	public WebElement getCommunitiesLabel() {
		return communitiesLabel;
	}

	public WebElement getInactiveCheckbox() {
		return inactiveCheckbox;
	}

	public WebElement getInactiveCheckboxLabel() {
		return inactiveCheckboxLabel;
	}

	public WebElement getTableWithCommunities() {
		return tableWithCommunities;
	}

	public WebElement getTerritorialCommunityHeader() {
		return territorialCommunityHeader;
	}

	public WebElement getRegistrationNumberHeader() {
		return registrationNumberHeader;
	}

	public WebElement getActionsHeader() {
		return actionsHeader;
	}

	public WebElement getEditCommunityButton() {
		return editCommunityButton;
	}

	public WebElement getDeleteCommunityButton() {
		return deleteCommunityButton;
	}

	public WebElement getActiveCommunityButton() {
		return activeCommunityButton;
	}

	public String getAddNewCommunityButtonText() {
		return addNewCommunityButton.getText().trim();
	}

	public String getCommunitiesLabelText() {
		return communitiesLabel.getText().trim();
	}

	public String getInactiveCheckboxLabelText() {
		return inactiveCheckboxLabel.getText().trim();
	}

	public String geTterritorialCommunityHeaderText() {
		return territorialCommunityHeader.getText().trim();
	}

	public String getRegistrationNumberHeaderText() {
		return registrationNumberHeader.getText().trim();
	}

	public String getActionsHeaderText() {
		return actionsHeader.getText().trim();
	}

	public String getEditCommunityButtonText() {
		return editCommunityButton.getText().trim();
	}

	public String getDeleteCommunityButtonText() {
		return deleteCommunityButton.getText().trim();
	}

	public String getActiveCommunityButtonText() {
		return activeCommunityButton.getText().trim();
	}

	public void clickAddNewCommunityButton() {
		getAddNewCommunityButton().click();
	}

	public void clickInactiveCheckbox() {
		getInactiveCheckbox().click();
	}

	public void clickEditCommunityButton() {
		getEditCommunityButton().click();
	}

	public void clickDeleteCommunityButton() {
		getDeleteCommunityButton().click();
	}

	public void clickActiveCommunityButton() {
		getActiveCommunityButton().click();
	}

}
