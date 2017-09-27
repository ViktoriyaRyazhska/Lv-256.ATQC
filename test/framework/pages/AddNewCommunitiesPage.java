/**
 * 
 */
package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewCommunitiesPage extends AdminCommunitiesPage{
	protected WebElement communitiesName;
	protected WebElement communitiesRegistrationNumber;
	protected WebElement submitButton;
	private WebElement clearFormButton;
	protected WebElement communitiesNameLabel;
	protected WebElement communitiesRegistrationNumberLabel;
	private WebElement addNewCommunitiesPageLabel;
	
	public AddNewCommunitiesPage(WebDriver driver) {
		super(driver);
		communitiesName = driver.findElement(By.name("name"));
		communitiesRegistrationNumber = driver.findElement(By.name("registrationNumber"));
		submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		clearFormButton = driver.findElement(By.xpath("//button[@type='reset']"));
		communitiesNameLabel = driver.findElement(By.xpath("//div[1]/label"));
		communitiesRegistrationNumberLabel = driver.findElement(By.xpath("//div[2]/label"));
		addNewCommunitiesPageLabel = driver.findElement(By.xpath("//h2"));
	}
	
	public WebElement getCommunitiesName() {
		return communitiesName;
	}

	public WebElement getCommunitiesRegistrationNumber() {
		return communitiesRegistrationNumber;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getClearFormButton() {
		return clearFormButton;
	}

	public WebElement getCommunitiesNameLabel() {
		return communitiesNameLabel;
	}

	public WebElement getCommunitiesRegistrationNumberLabel() {
		return communitiesRegistrationNumberLabel;
	}

	public WebElement getAddNewCommunitiesPageLabel() {
		return addNewCommunitiesPageLabel;
	}
	public String getSubmitButtonText() {
		return submitButton.getText().trim();
	}
	public String getClearFormButtonText() {
		return clearFormButton.getText().trim();
	}
	public String getCommunitiesNameLabelText() {
		return communitiesNameLabel.getText().trim();
	}
	public String getCommunitiesRegistrationNumberLabelText() {
		return communitiesRegistrationNumberLabel.getText().trim();
	}
	public String getAddNewCommunitiesPageLabelText() {
		return addNewCommunitiesPageLabel.getText().trim();
	}
	
	

}
