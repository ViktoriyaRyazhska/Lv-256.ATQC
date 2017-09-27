package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHomePageImpl extends DropdownHomePage {
	private WebElement message;

	public DropdownHomePageImpl(WebDriver driver) {
		super(driver);
		homeButton=driver.findElement(By.xpath("//*[@id=\"navigationbar\"]//following::a"));
		userName = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm"));
		menuDownButton = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle"));	
	}
	public DropdownHomePageImpl(WebDriver driver, WebElement message) {
		super(driver);
		homeButton=driver.findElement(By.xpath("//*[@id=\"navigationbar\"]//following::a"));
		userName = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm"));
		menuDownButton = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle"));	
		this.message=message;
	}
	
public WebElement getSuccesMessage() {
	message = driver.findElement(By.cssSelector("strong"));
	return message;
	
}
public String getMessageText() {
	return message.getText().trim();
}
	@Override
	public DropdownHomePageImpl setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		return new DropdownHomePageImpl(driver);
	}

}
