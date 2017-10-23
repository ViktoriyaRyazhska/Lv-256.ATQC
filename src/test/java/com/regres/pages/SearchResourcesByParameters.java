package com.regres.pages;

import org.openqa.selenium.WebDriver;

public class SearchResourcesByParameters extends ResourcesSearchPage {
	
	String SELECT_THE_OBJECTS_SUBCLASS_DROPDOWN_ID  ="resourcesTypeSelect";
	String SEARCH_BUTTON_ID = "search";
	String SHOW_ALL_BUTTON_ID = "showAllResources";
	
	
	
	public SearchResourcesByParameters(WebDriver driver) {
		super(driver);
	
	}

	
}