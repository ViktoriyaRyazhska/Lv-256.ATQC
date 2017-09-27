package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditCommunityPage extends AddNewCommunitiesPage{
	private WebElement EditNewCommunitiesPageLabel;
		
	public EditCommunityPage(WebDriver driver) {
		super(driver);
		EditNewCommunitiesPageLabel = driver.findElement(By.xpath("//h2"));
		}

	public WebElement getEditNewCommunitiesPageLabel() {
		return EditNewCommunitiesPageLabel;
	}
	
	public String getEditNewCommunitiesPageLabelText() {
		return EditNewCommunitiesPageLabel.getText().trim();
	}
}
