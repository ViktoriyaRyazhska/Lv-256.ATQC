package com.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TitleLocalFooter {

	protected WebDriver driver;
	private WebElement titleFirstPart;
	private WebElement titleSecondPart;
	private WebElement localization_dropdown;
	private WebElement footer;

	String TITLE_FIRST_PART_XPATH = "//div[@class='col-md-7 col-xs-12']/h3[1]";
	String TITLE_SECOND_PART_XPATH = "//div[@class='col-md-7 col-xs-12']/h3[2]";
	String LOCALIZATION_DROPDOWN_ID = "changeLanguage";
	String FOOTER_XPATH = "//div[@id='footer']//span";
	
	public TitleLocalFooter(WebDriver driver) {		
		this.driver=driver;
		titleFirstPart = driver.findElement(By.xpath(TITLE_FIRST_PART_XPATH));
		titleSecondPart = driver.findElement(By.xpath(TITLE_SECOND_PART_XPATH));
		//localization_dropdown= driver.findElement(By.id(LOCALIZATION_DROPDOWN_ID));
		footer= driver.findElement(By.xpath(FOOTER_XPATH));
	}

	public WebElement getFooter() {
		footer = driver.findElement(By.xpath(FOOTER_XPATH));
		return footer;
	}

	public WebElement getLocalizationDropdown() {
		return driver.findElement(By.id(LOCALIZATION_DROPDOWN_ID));
	}

	/**
	 * 
	 * @return Text of the title(composed from two parts)
	 */
	public String getTitleText() {
		titleFirstPart = driver.findElement(By.xpath(TITLE_FIRST_PART_XPATH));
		titleSecondPart = driver.findElement(By.xpath(TITLE_SECOND_PART_XPATH));
		return titleFirstPart.getText().trim() + titleSecondPart.getText().trim();
	}

	/**
	 * 
	 * @return Text of the footer.
	 */
	public String getFooterText() {
		return footer.getText().trim();
	}

	/**
	 * This method sets language for the app.
	 * 
	 * @param language
	 *            - language to be set
	 * @return page, on which this method is executed.
	 */
	public abstract <T extends TitleLocalFooter> T setLanguage(ChangeLanguageFields language);

	/**
	 * Enum that represents available languages.
	 * 
	 * @author PETYAggg
	 *
	 */
	public static enum ChangeLanguageFields {
		UKRAINIAN("українська"), RUSSIAN("русский"), ENGLISH("english");

		private String field;

		/**
		 * Set language value.
		 * 
		 * @param field
		 *            - value of the language(shown in Localization dropdown)
		 */
		private ChangeLanguageFields(String field) {
			this.field = field;
		}

		public String toString() {
			return this.field;
		}
	}

}
