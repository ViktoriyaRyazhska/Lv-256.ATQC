package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class TitleLocalFooter {
	
	
	public static enum ChangeLanguageFields {
		  UKRAINIAN("українська"), RUSSIAN("русский"), ENGLISH("english");

		private String field;

		private ChangeLanguageFields(String field) {
		    this.field = field;
		}

		public String toString() { return this.field; }
		}

	protected WebDriver driver;
	private WebElement titleFirstPart;
	private WebElement titleSecondPart;
	private WebElement localization_dropdown;
	private WebElement footer;
	
	public TitleLocalFooter(WebDriver driver) {		
		this.driver=driver;
		titleFirstPart = driver.findElement(By.xpath("//div[@class='col-md-7 col-xs-12']/h3[1]"));
		titleSecondPart = driver.findElement(By.xpath("//div[@class='col-md-7 col-xs-12']/h3[2]"));
		localization_dropdown= driver.findElement(By.id("changeLanguage"));
		footer= driver.findElement(By.xpath("//div[@id='footer']//span"));
	}
		
	public String getTitleText(){
		
		return titleFirstPart.getText().trim()+titleSecondPart.getText().trim();
	}
	
	/**
	 * 
	 * Select lang = new Select(getLocalizationDropdown()); 
		lang.selectByVisibleText(language.toString()); 
		return new 'Current page'(driver);
	 * 
	 */
	public abstract < T extends TitleLocalFooter> T setLanguage(ChangeLanguageFields language);
	
	public WebElement getFooter() {
		
		return footer;
	}
	
	public WebElement getLocalizationDropdown(){
		
		return localization_dropdown;
	}
	
	
	
	
}
