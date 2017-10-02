package com.regres.pages.manage.coowners;

import com.regres.testdata.UserForSerchTableTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.regres.pages.AdminHomePage;
import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.manage.coowners.actions.InactiveCoownersActionsDropdown;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CoownersTable extends AdminHomePage {
    public ConfirmMessagePage confirm;
    String ACTIONS_ID = "dLabel";
    String COUNT_ELEMENTS_CSSSELECTOR = "label>select";
    String SEARCH_BUTTON_ID = "bth-search";
    String PREV_BUTTON_ID = "example_previous";
    String NEXT_BUTTON_ID = "example_next";
    String PAGINATE_CURRENT_BUTTON_CSSSELECTOR = ".paginate_button.current";

    //table columns first row
    String FIRST_NAME_COLUMN = ".//*[@id='inputIndex1']";
    String LAST_NAME_COLUMN = ".//*[@id='inputIndex2']";
    String LOGIN_COLUMN = ".//*[@id='inputIndex3']";
    String COMMUNITY_COLUMN = ".//*[@id='inputIndex4']";
    String EMAIL_COLUMN = ".//*[@id='inputIndex5']";
    String ROLE_COLUMN = ".//*[@id='inputIndex6']";

    //table body
    String TABLE_BODY_ROWS = "//*[@id='example']/tbody/tr";
    String TABLE_BODY_CELL = TABLE_BODY_ROWS + "/td";//"//*[@id='example']/tbody/tr/td";

    public CoownersTable(WebDriver driver) {
        super(driver);
        getActions();
        getCountElements();
        getSearchButton();
        getPrevButtton();
        getNextButtton();
        getPaginateCurrentButton();
    }

    public WebElement getActions() {
        return driver.findElement(By.id(ACTIONS_ID));
    }

    public WebElement getCountElements() {
        return driver.findElement(By.cssSelector(COUNT_ELEMENTS_CSSSELECTOR));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.id(SEARCH_BUTTON_ID));
    }

    public WebElement getPrevButtton() {
        return driver.findElement(By.id(PREV_BUTTON_ID));
    }

    public WebElement getNextButtton() {
        return driver.findElement(By.id(NEXT_BUTTON_ID));
    }

    public WebElement getPaginateCurrentButton() {
        return driver.findElement(By.cssSelector(PAGINATE_CURRENT_BUTTON_CSSSELECTOR));
    }

    //sets the number of visible rows in table 100
    public void setNumbeOfItemsInTable() {
        new Select(driver.findElement(By.name("example_length"))).selectByVisibleText("100");
    }

    //sets the number of visible rows in table 10
    public void setNumbeOfItemsInTable10() {
        new Select(driver.findElement(By.name("example_length"))).selectByVisibleText("10");
    }

    // Business Logic

    public InactiveCoownersActionsDropdown goToInactiveCoowners() {
        // Return a new page object representing the destination.
        return new InactiveCoownersActionsDropdown(driver);
    }

    public WebElement getFirstNameColumn() {
        return driver.findElement(By.xpath(FIRST_NAME_COLUMN));
    }

    public WebElement getLastNameColumn() {
        return driver.findElement(By.xpath(LAST_NAME_COLUMN));
    }

    public WebElement getLoginColumn() {
        return driver.findElement(By.xpath(LOGIN_COLUMN));
    }

    public WebElement getCommunityColumn() {
        return driver.findElement(By.xpath(COMMUNITY_COLUMN));
    }

    public WebElement getEmailColumn() {
        return driver.findElement(By.xpath(EMAIL_COLUMN));
    }

    public WebElement getRoleColumn() {
        return driver.findElement(By.xpath(ROLE_COLUMN));
    }

    public String getFirstNameColumnText() {
        return getFirstNameColumn().getText().trim();
    }

    public String getLastNameColumnText() {
        return getLastNameColumn().getText().trim();
    }

    public String getLoginColumnText() {
        return getLoginColumn().getText().trim();
    }

    public String getCommunityColumnText() {
        return getCommunityColumn().getText().trim();
    }

    public String getEmailColumnText() {
        return getEmailColumn().getText().trim();
    }

    public String getRoleColumnText() {
        return getRoleColumn().getText().trim();
    }

    public void setFIRST_NAME_SEARCH(String FIRST_NAME_SEARCH) {
        getFirstNameColumn().sendKeys(FIRST_NAME_SEARCH);
    }

    public void setLAST_NAME_SEARCH(String LAST_NAME_SEARCH) {
        getLastNameColumn().sendKeys(LAST_NAME_SEARCH);
    }

    public void setLOGIN_SEARCH(String LOGIN_SEARCH) {
        getLoginColumn().sendKeys(LOGIN_SEARCH);
    }

    public void setCOMMUNITY_SEARCHN(String COMMUNITY_SEARCHN) {
        getCommunityColumn().sendKeys(COMMUNITY_SEARCHN);
    }

    public void setEMAIL_SEARCH(String EMAIL_SEARCH) {
        getEmailColumn().sendKeys(EMAIL_SEARCH);
    }

    public void setROLE_SEARCH(String ROLE_SEARCH) {
        getRoleColumn().sendKeys(ROLE_SEARCH);
    }

    //work with table
    public List<WebElement> getALL_TABLE_BODY_ROWS() {
        List<WebElement> rows_collection = driver.findElements(By.xpath(TABLE_BODY_ROWS));
        return rows_collection;
    }

    public List<WebElement> getALL_TABLE_BODY_CELL() {
        List<WebElement> cell_collection = driver.findElements(By.xpath(TABLE_BODY_CELL));
        return cell_collection;
    }

    public int getTABLE_BODY_ROWS_COUNT() {
        return getALL_TABLE_BODY_ROWS().size();
    }

    public int getTABLE_BODY_CELL_COUNT() {
        return getALL_TABLE_BODY_CELL().size();
    }

    public void waitWhileTableAppear(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TABLE_BODY_CELL)));
    }

    public List<UserForSerchTableTest> searchByFirstName(String firstName) {
        List<UserForSerchTableTest> userList = new ArrayList<UserForSerchTableTest>();
        for (UserForSerchTableTest u : getListOfUsersFromTable()) {
            if (u.getFirstName().contains(firstName)) {
                userList.add(u);
            }
        }
        return userList;
    }

    public List<UserForSerchTableTest> searchByLastName(String lastName) {
        List<UserForSerchTableTest> userList = new ArrayList<UserForSerchTableTest>();
        for (UserForSerchTableTest u : getListOfUsersFromTable()) {
            if (u.getLastName().contains(lastName)) {
                userList.add(u);
            }
        }
        return userList;
    }

    public List<UserForSerchTableTest> searchByLogin(String login) {
        List<UserForSerchTableTest> userList = new ArrayList<UserForSerchTableTest>();
        for (UserForSerchTableTest u : getListOfUsersFromTable()) {
            if (u.getLogin().contains(login)) {
                userList.add(u);
            }
        }
        return userList;
    }

    public List<UserForSerchTableTest> searchByTerritorialCommunityName(String TerritorialCommunityName) {
        List<UserForSerchTableTest> userList = new ArrayList<UserForSerchTableTest>();
        for (UserForSerchTableTest u : getListOfUsersFromTable()) {
            if (u.getTerritorialCommunityName().contains(TerritorialCommunityName)) {
                userList.add(u);
            }
        }
        return userList;
    }

    public List<UserForSerchTableTest> getListOfUsersFromTable() {
        waitWhileTableAppear();
        List<UserForSerchTableTest> userList = new ArrayList<UserForSerchTableTest>();
        List<WebElement> celllist = getALL_TABLE_BODY_CELL();//вибираємо всі комірки тіля таблиці
        int count = getTABLE_BODY_CELL_COUNT();//вирараховуємо кількість комірок
        for (int j = 0; j <= count - 8; j = j + 8) {//оскільки в рядку по 8 комірок втчитуємо коженя рядок
            userList.add(new UserForSerchTableTest(
                    celllist.get(j + 0).getText(),
                    celllist.get(j + 1).getText(),
                    celllist.get(j + 2).getText(),
                    celllist.get(j + 3).getText(),
                    celllist.get(j + 4).getText(),
                    celllist.get(j + 5).getText(),
                    celllist.get(j + 6).getText(),
                    celllist.get(j + 7).getText()
            ));
        }
        return userList;
    }

    public void compareLists(List<UserForSerchTableTest> userList, List<UserForSerchTableTest> userList2) {
        System.out.println(userList.equals(userList2));
        Assert.assertTrue(userList.size() == userList2.size());
    }


}
