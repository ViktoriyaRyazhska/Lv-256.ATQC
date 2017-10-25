package com.regres.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.regres.testdata.UserForSerchTableTest;

public class SearchResourcesByParameters extends ResourcesSearchPage {

	// already on page
	String SELECT_SUBCLASS_DROPDOWN_ID = "resourcesTypeSelect";
	String SEARCH_BUTTON_ID = "search";
	String SHOW_ALL_BUTTON_ID = "showAllResources";
	String PERIMETER_DROPDOWN_XPATH = "//div[@id='discreteParameters']/div/span/select";
	String PERIMETER_INPUT_XPATH = "//div[@id='discreteParameters']/div/span[2]/input";
	String AREA_DROPDOWN_XPATH = "//div[@id='discreteParameters']/div[2]/span/select";
	String AREA_INPUT_XPATH = "//div[@id='discreteParameters']/div[2]/span[2]/input";

	// dropdown click
	String HARES_DROPDOWN_XPATH = "//div[@id='discreteParameters']/div/span/select";
	String HARES_INPUT_XPATH = "//div[@id='discreteParameters']/div/span[2]/input";

	String ITALY_INPUT_XPATH = "//div[@id='linearParameters']/div/span/input";

	String WATER_VOLUME_DROPDOWN_XPATH = "//div[@id='discreteParameters']/div/span/select";
	String WATER_VOLUME_INPUT_XPATH = "//div[@id='discreteParameters']/div/span[2]/input";
	String WATER_AREA_DROPDOWN_XPATH = "//div[@id='discreteParameters']/div[2]/span/select";
	String WATER_AREA_INPUT_XPATH = "//div[@id='discreteParameters']/div[2]/span[2]/input";

	String SHOW_ENTRIES_DROPDOWN_ID = "datatable_length";
	String SEARCH_IN_TABLE_INPUT = "//input[@type='search']";
	String NEXT_BUTTON = "datatable_next";
	String PREVIOUS_BUTTON = "datatable_previous";

	// table sorting
	String RESOURCE_DESCRIPTION_HEAD = "//table[@id='datatable']/thead/tr/th";
	String SUBCLASS_HEAD = "//table[@id='datatable']/thead/tr/th[2]";
	String IDENTIFICATOR_HEAD = "//table[@id='datatable']/thead/tr/th[3]";
	String INPUT_DATE_HEAD = "//table[@id='datatable']/thead/tr/th[4]";
	String MORE_HEAD = "//table[@id='datatable']/thead/tr/th[5]";

	String TABLE_BODY_ROWS = "//table[@id='datatable']/tbody/tr";
	String TABLE_BODY_CELL = TABLE_BODY_ROWS + "/td";

	private WebElement selectSubclassDropdown;
	private WebElement searchButton;
	private WebElement showAllButton;
	private WebElement perimeterDropdown;
	private WebElement perimeterInput;
	private WebElement areaDropdown;
	private WebElement areaInput;

	private WebElement haresDropdown;
	private WebElement haresInput;

	private WebElement italyInput;

	private WebElement waterVolumeDropdown;
	private WebElement waterVolumeInput;
	private WebElement waterAreaDropdown;
	private WebElement waterAreaInput;
	//
	private WebElement showEntriesDropdown;
	private WebElement searchInTableInput;
	private WebElement nextButton;
	private WebElement previousButton;

	public SearchResourcesByParameters(WebDriver driver) {
		super(driver);

		getSelectSubclassDropdown(); // =
										// driver.findElement(By.id(SELECT_SUBCLASS_DROPDOWN_ID));
		searchButton = driver.findElement(By.id(SEARCH_BUTTON_ID));
		showAllButton = driver.findElement(By.id(SHOW_ALL_BUTTON_ID));
		perimeterDropdown = driver.findElement(By
				.xpath(PERIMETER_DROPDOWN_XPATH));
		perimeterInput = driver.findElement(By.xpath(PERIMETER_INPUT_XPATH));
		areaDropdown = driver.findElement(By.xpath(AREA_DROPDOWN_XPATH));
		areaInput = driver.findElement(By.xpath(AREA_INPUT_XPATH));
	}

	public WebElement getSelectSubclassDropdown() {
		return selectSubclassDropdown = driver.findElement(By
				.id(SELECT_SUBCLASS_DROPDOWN_ID));
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getShowAllButton() {
		return showAllButton;
	}

	public WebElement getPerimeterDropdown() {
		return perimeterDropdown;
	}

	public WebElement getPerimeterInput() {
		return perimeterInput;
	}

	public WebElement getAreaDropdown() {
		return areaDropdown;
	}

	public WebElement getAreaInput() {
		return areaInput;
	}

	public WebElement getHaresDropdown() {
		return haresDropdown;
	}

	public WebElement getHaresInput() {
		return haresInput;
	}

	public WebElement getItalyInput() {
		return italyInput;
	}

	public WebElement getWaterVolumeDropdown() {
		return waterVolumeDropdown;
	}

	public WebElement getWaterVolumeInput() {
		return waterVolumeInput;
	}

	public WebElement getWaterAreaDropdown() {
		return waterAreaDropdown;
	}

	public WebElement getWaterAreaInput() {
		return waterAreaInput;
	}

	public WebElement getShowEntriesDropdown() {
		return showEntriesDropdown;
	}

	public WebElement getSearchInTableInput() {
		return searchInTableInput;
	}

	public WebElement getNextButton() {
		return nextButton;
	}

	public WebElement getPreviousButton() {
		return previousButton;
	}

	// click
	public void clickSearchButton() {
		getSearchButton().click();
	}

	public void clickShowAllButton() {
		getShowAllButton().click();
	}

	// select
	public void selectGroundResources() {
		new Select(selectSubclassDropdown).selectByVisibleText("земельний");
		// return new SearchResourcesByParameters(driver);
	}

	public void selectHaresResources() {
		new Select(selectSubclassDropdown).selectByVisibleText("зайці");
		// return new SearchResourcesByParameters(driver);
	}

	public void selectItalyResources() {
		new Select(selectSubclassDropdown).selectByVisibleText("Italy");
		// return new SearchResourcesByParameters(driver);
	}

	public void selectWaterResources() {
		new Select(selectSubclassDropdown).selectByVisibleText("Water");
		// return new SearchResourcesByParameters(driver);
	}
	
	public void selectPerimeterLess() {
		new Select(perimeterDropdown).selectByVisibleText("<");
	}

	public void selectPerimeterEquals() {
		new Select(perimeterDropdown).selectByVisibleText("=");
	}

	public void selectPerimeterGreater() {
		new Select(perimeterDropdown).selectByVisibleText(">");
	}

	public void selectAreaLess() {
		new Select(areaDropdown).selectByVisibleText("<");
	}

	public void selectAreaEquals() {
		new Select(areaDropdown).selectByVisibleText("=");
	}

	public void selectAreaGreater() {
		new Select(areaDropdown).selectByVisibleText(">");
	}

	public void clickSelectHaresResources() {
		selectHaresResources();
		haresDropdown = driver.findElement(By.xpath(HARES_DROPDOWN_XPATH));
		haresInput = driver.findElement(By.xpath(HARES_INPUT_XPATH));
	}

	public void selectHareLess() {
		new Select(haresDropdown).selectByVisibleText("<");
	}

	public void selectHareEquals() {
		new Select(haresDropdown).selectByVisibleText("=");
	}

	public void selectHareGreater() {
		new Select(haresDropdown).selectByVisibleText(">");
	}

	public SearchResourcesByParameters clickSelectItalyResources() {
		selectItalyResources();
		italyInput = driver.findElement(By.xpath(ITALY_INPUT_XPATH));
		return new SearchResourcesByParameters(driver);
	}

	public void clickSelectWaterResources() {
		selectWaterResources();
		waterVolumeDropdown = driver.findElement(By
				.xpath(WATER_VOLUME_DROPDOWN_XPATH));
		waterVolumeInput = driver.findElement(By
				.xpath(WATER_VOLUME_INPUT_XPATH));
		waterAreaDropdown = driver.findElement(By
				.xpath(WATER_AREA_DROPDOWN_XPATH));
		waterAreaInput = driver.findElement(By.xpath(WATER_AREA_INPUT_XPATH));
	}

	public void selectWaterVolumeLess() {
		new Select(waterVolumeDropdown).selectByVisibleText("<");
	}

	public void selectWaterVolumeEquals() {
		new Select(waterVolumeDropdown).selectByVisibleText("=");
	}

	public void selectWaterVolumeGreater() {
		new Select(waterVolumeDropdown).selectByVisibleText(">");
	}

	public void selectWaterAreaLess() {
		new Select(waterAreaDropdown).selectByVisibleText("<");
	}

	public void selectWaterAreaEquals() {
		new Select(waterAreaDropdown).selectByVisibleText("=");
	}

	public void selectWaterAreaGreater() {
		new Select(waterAreaDropdown).selectByVisibleText(">");
	}

	public void clickShowAll() {

		clickShowAllButton();
		showEntriesDropdown = driver.findElement(By
				.name(SHOW_ENTRIES_DROPDOWN_ID));
		searchInTableInput = driver
				.findElement(By.xpath(SEARCH_IN_TABLE_INPUT));
		nextButton = driver.findElement(By.id(NEXT_BUTTON));
		previousButton = driver.findElement(By.id(PREVIOUS_BUTTON));
	}

	public void select10EntriesDropdown() {
		new Select(showEntriesDropdown).selectByVisibleText("10");
	}

	public void select25EntriesDropdown() {
		new Select(showEntriesDropdown).selectByVisibleText("25");
	}

	public void select50EntriesDropdown() {
		new Select(showEntriesDropdown).selectByVisibleText("50");
	}

	public void select100EntriesDropdown() {
		new Select(showEntriesDropdown).selectByVisibleText("100");
	}
	

	public List<WebElement> getAllTableBodyRows() {
		List<WebElement> rows_collection = driver.findElements(By
				.xpath(TABLE_BODY_ROWS));
		return rows_collection;
	}

	public List<WebElement> getAlltableBodyCell() {
		List<WebElement> cell_collection = driver.findElements(By
				.xpath(TABLE_BODY_CELL));
		return cell_collection;
	}

	public int getTableBodyCellsCount() {
		return getAlltableBodyCell().size();
	}

	//public ResourcesTable getResourcesField(List<ResourcesTable> resourcesList) {
	 public ResourcesTable getResourcesField(List<ResourcesTable> resourcesList) {
			return resourcesList.get(0);
	}

	public boolean waitWhileScriptsExecute() {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver)
							.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					// no jQuery present
					return true;
				}
			}
		};
		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver)
						.executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	public List<ResourcesTable> getListOfResourcesFromTable() {
		if (waitWhileScriptsExecute()) {
			List<ResourcesTable> resourcesList = new ArrayList<>();
			List<WebElement> celllist = getAlltableBodyCell();
			int count = getTableBodyCellsCount();
			for (int j = 0; j <= count - 8; j = j + 8) {
				resourcesList.add(new ResourcesTable(celllist.get(j + 0)
						.getText(), celllist.get(j + 1).getText(), celllist
						.get(j + 2).getText(), celllist.get(j + 3).getText(),
						celllist.get(j + 4).getText()));
			}
			return resourcesList;
		} else {
			getListOfResourcesFromTable();
		}
		return null;
	}

}