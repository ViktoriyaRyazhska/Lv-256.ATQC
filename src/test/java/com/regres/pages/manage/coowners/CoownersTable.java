package com.regres.pages.manage.coowners;

import com.regres.testdata.UserForSerchTableTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.regres.pages.AdminHomePage;
import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.manage.coowners.actions.InactiveCoownersActionsDropdown;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoownersTable extends AdminHomePage {
    public ConfirmMessagePage confirm;
    private String ACTIONS_ID = "dLabel";
    private String COUNT_ELEMENTS_CSSSELECTOR = "label>select";
    private String SEARCH_BUTTON_ID = "bth-search";
    private String PREV_BUTTON_ID = "example_previous";
    private String NEXT_BUTTON_ID = "example_next";
    private String PAGINATE_CURRENT_BUTTON_CSSSELECTOR = ".paginate_button.current";
    private String NUMBERS_OF_ROWN_IN_TABLE_NAME = "example_length";

    //table sorting rows
    private String FIRST_NAME_SORT_XPATH = ".//*[@id='example']/thead/tr/th[2]";
    private String LAST_NAME_SORT_XPATH = ".//*[@id='example']/thead/tr/th[3]";
    private String LOGIN_SORT_XPATH = ".//*[@id='example']/thead/tr/th[4]";
    private String COMMUNITY_SORT_XPATH = ".//*[@id='example']/thead/tr/th[5]";
    private String EMAIL_SORT_XPATH = ".//*[@id='example']/thead/tr/th[6]";
    private String ROLE_SORT_XPATH = ".//*[@id='example']/thead/tr/th[7]";

    //table search row
    private String FIRST_NAME_COLUMN_ID = "inputIndex1";
    private String LAST_NAME_COLUMN_ID = "inputIndex2";
    private String LOGIN_COLUMN_ID = "inputIndex3";
    private String COMMUNITY_COLUMN_ID = "inputIndex4";
    private String EMAIL_COLUMN_ID = "inputIndex5";
    private String ROLE_COLUMN_ID = "inputIndex6";

    // table columns second row search
    String FIRST_NAME_FIRST_XPATH = ".//tbody/tr[5]/td[2]";
    String LAST_NAME_SEARCH_FIRST_XPATH = ".//tbody/tr[1]/td[3]";
    String LOGIN_SEARCH_FIRST_XPATH = ".//tbody/tr[1]/td[4]";
    String COMMUNITY_SEARCHN_FIRST_XPATH = ".//tbody/tr[1]/td[5]";
    String EMAIL_SEARCH_FIRST_XPATH = ".//tbody/tr[1]/td[6]";
    String ROLE_SEARCH_FIRST_XPATH = ".//tbody/tr[1]/td[7]";

    //table body
    private String TABLE_BODY_ROWS = "//*[@id='example']/tbody/tr";
    private String TABLE_BODY_CELL = TABLE_BODY_ROWS + "/td";
    private String EMPTY_TABLE_CSS = ".dataTables_empty";

    // table hider
    private String TABLE_TITLE_XPATH = "//div[@class = 'dataTable_wrapper']/preceding::h4";
    private String FIRST_ROW_TABLE_XPATH = "//tbody/tr[1]";

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

    public void ClickSearchButton() {
        getSearchButton().click();
    }

    public WebElement getTitleTableName() {
        return driver.findElement(By.xpath(TABLE_TITLE_XPATH));
    }

    public String getTitleTableNameText() {
        return getTitleTableName().getText().trim();
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

    public WebElement getFirstNameFirstRow() {
        return driver.findElement(By.xpath(FIRST_NAME_FIRST_XPATH));
    }

    public WebElement getLastNameFirstRow() {
        return driver.findElement(By.xpath(LAST_NAME_SEARCH_FIRST_XPATH));
    }

    public WebElement getLoginFirstRow() {
        return driver.findElement(By.xpath(LOGIN_SEARCH_FIRST_XPATH));
    }

    public WebElement getCommunityNameFirstRow() {
        return driver.findElement(By.xpath(COMMUNITY_SEARCHN_FIRST_XPATH));
    }

    public WebElement getEmailFirstRow() {
        return driver.findElement(By.xpath(EMAIL_SEARCH_FIRST_XPATH));
    }

    public WebElement getRoleFirstRow() {
        return driver.findElement(By.xpath(ROLE_SEARCH_FIRST_XPATH));
    }

    public String getRoleFirstRowText() {
        return getRoleFirstRow().getText().trim();
    }

    // Business Logic
    public InactiveCoownersActionsDropdown goToInactiveCoowners() {
        // Return a new page object representing the destination.
        return new InactiveCoownersActionsDropdown(driver);
    }

    //table sorting by first name
    public void sortByFirstName() {
        driver.findElement(By.xpath(FIRST_NAME_SORT_XPATH)).click();
        waitWhileScriptsExecute();
    }

    //table sorting by last name
    public void sortByLastName() {
        driver.findElement(By.xpath(LAST_NAME_SORT_XPATH)).click();
        waitWhileScriptsExecute();
    }

    //table sorting by login
    public void sortByLogin() {
        driver.findElement(By.xpath(LOGIN_SORT_XPATH)).click();
        waitWhileScriptsExecute();
    }

    //table sorting by community
    public void sortByCommunity() {
        driver.findElement(By.xpath(COMMUNITY_SORT_XPATH)).click();
        waitWhileScriptsExecute();
    }

    //table sorting by email
    public void sortByEmail() {
        driver.findElement(By.xpath(EMAIL_SORT_XPATH)).click();
    }

    //table sorting by role
    public void sortByRole() {
        driver.findElement(By.xpath(ROLE_SORT_XPATH)).click();
    }

    //table search row getters
    public WebElement getFirstNameColumn() {
        return driver.findElement(By.id(FIRST_NAME_COLUMN_ID));
    }

    public WebElement getLastNameColumn() {
        return driver.findElement(By.id(LAST_NAME_COLUMN_ID));
    }

    public WebElement getLoginColumn() {
        return driver.findElement(By.id(LOGIN_COLUMN_ID));
    }

    public void ClickLoginColumn() {
        getLoginColumn().click();
    }

    public WebElement getCommunityColumn() {
        return driver.findElement(By.id(COMMUNITY_COLUMN_ID));
    }

    public WebElement getEmailColumn() {
        return driver.findElement(By.id(EMAIL_COLUMN_ID));
    }

    public WebElement getRoleColumn() {
        return driver.findElement(By.id(ROLE_COLUMN_ID));
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

    public WebElement getFirstRowTable() {
        return driver.findElement(By.xpath(FIRST_ROW_TABLE_XPATH));
    }

    public String getRoleColumnText() {
        return getRoleColumn().getText().trim();
    }

    public void setFirstNameSearch(String firstNameSearch) {
        getFirstNameColumn().sendKeys(firstNameSearch);
    }

    public void setLastNameSearch(String lastNameSearch) {
        getLastNameColumn().sendKeys(lastNameSearch);
    }

    public void setLoginSearch(String loginSearch) {
        getLoginColumn().sendKeys(loginSearch);
    }

    public void setCommunitySearch(String communitySearch) {
        getCommunityColumn().sendKeys(communitySearch);
    }

    public void setEmailSearch(String emailSearch) {
        getEmailColumn().sendKeys(emailSearch);
    }

    public void setRoleSearch(String roleSearch) {
        getRoleColumn().sendKeys(roleSearch);
    }

    public WebElement getLoginIinputField() {
        return driver.findElement(By.id(LOGIN_COLUMN_ID));
    }

    //work with table
    public List<WebElement> getAllTableBodyRows() {
        List<WebElement> rows_collection = driver.findElements(By.xpath(TABLE_BODY_ROWS));
        return rows_collection;
    }

    public List<WebElement> getAlltableBodyCell() {
        List<WebElement> cell_collection = driver.findElements(By.xpath(TABLE_BODY_CELL));
        return cell_collection;
    }

    public int getTableBodyRowsCount() {
        return getAllTableBodyRows().size();
    }

    public int getTableBodyCellsCount() {
        return getAlltableBodyCell().size();
    }

    public String waitWhileEmptyTableAppear() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TABLE_BODY_CELL)));
        return driver.findElement(By.cssSelector(EMPTY_TABLE_CSS)).getText();
    }

    public boolean waitWhileScriptsExecute() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    /**
     * search in table by any field
     *
     * @param - "searchParamether"
     * @return list of searched users
     */
    public List<UserForSerchTableTest> searchByUserField(List<UserForSerchTableTest> userList, UserSearchField searchField, String searchParamether) {
        List<UserForSerchTableTest> filteredList = new ArrayList<UserForSerchTableTest>();
        for (UserForSerchTableTest u : userList) {
            if (checkContainingTextInField(u,searchField,searchParamether)) {
                filteredList.add(u);
            }
        }
        return filteredList;
    }

    /**
     * method verify that userfield contains text(searchParamether) and return true
     * @param user
     * @param searchField
     * @param searchParamether
     * @return
     */
    private boolean checkContainingTextInField(UserForSerchTableTest user, UserSearchField searchField,String searchParamether ){
        Boolean containing=null;
        switch (searchField){
            case STATUS:
                containing=user.getStatus().contains(searchParamether);
                break;
            case FIRST_NAME:
                containing=user.getFirstName().contains(searchParamether);
                break;
            case LAST_NAME:
                containing=user.getLastName().contains(searchParamether);
                break;
            case LOGIN:
                containing=user.getLogin().contains(searchParamether);
                break;
            case COMMUNITY:
                containing=user.getTerritorialCommunityName().contains(searchParamether);
                break;
            case EMAIL:
                containing=user.getEmail().contains(searchParamether);
                break;
            case ROLE_TYPE:
                containing=user.getRole_type().contains(searchParamether);
                break;
        }
        return containing;
    }

    /**
     *
     */
    public enum UserSearchField {
        STATUS, FIRST_NAME, LAST_NAME, LOGIN, COMMUNITY, EMAIL, ROLE_TYPE
    }

    public UserForSerchTableTest getSearchParameter(List<UserForSerchTableTest> userList) {
        return userList.get((int) (Math.random() * (userList.size())));
    }

    /**
     * read all table and write users to list, one row - one user
     * one row contains 8 cells
     *
     * @return list of users from table
     */
    public List<UserForSerchTableTest> getListOfUsersFromTable() {
        if (waitWhileScriptsExecute()) {
            List<UserForSerchTableTest> userList = new ArrayList<>();
            List<WebElement> celllist = getAlltableBodyCell();
            int count = getTableBodyCellsCount();
            for (int j = 0; j <= count - 8; j = j + 8) {
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
        } else {
            getListOfUsersFromTable();
        }
        return null;
    }

    // compares equality of two user lists
    public boolean compareLists(List<UserForSerchTableTest> userList1, List<UserForSerchTableTest> userList2) {
        return userList1.equals(userList2);
    }

    public void clickFirstNameFirstRow() {
        (new WebDriverWait(driver, 40))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_NAME_FIRST_XPATH)));
        getFirstNameFirstRow().click();
    }

    public void findAndClickUserInTable(String value) {
        ClickLoginColumn();
        getLoginColumn().sendKeys(value);
        ClickSearchButton();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id(PREV_BUTTON_ID)));
        getLoginColumn().clear();
        clickFirstNameFirstRow();
    }

    //methods to compare two object lists by FirstName
    public boolean compareListsByFirstName(List<UserForSerchTableTest> userList1, List<UserForSerchTableTest> userList2) {
        for (int i = 0; i <= userList1.size() - 1; i++) {
            if (!(userList1.get(i).getFirstName().equalsIgnoreCase(userList2.get(i).getFirstName()))) {
                System.out.println(userList1.get(i).getFirstName() + " " + userList2.get(i).getFirstName());
                return false;
            }
        }
        return true;
    }

    //methods to compare two object lists by Login
    public boolean compareListsByLogin(List<UserForSerchTableTest> userList1, List<UserForSerchTableTest> userList2) {
        for (int i = 0; i <= userList1.size() - 1; i++) {
            if (!(userList1.get(i).getLogin().equalsIgnoreCase(userList2.get(i).getLogin()))) {
                System.out.println(userList1.get(i).getLogin() + " " + userList2.get(i).getLogin());
                return false;
            }
        }
        return true;
    }

    //methods to compare two object lists by CommunityName
    public boolean compareListsByCommunityName(List<UserForSerchTableTest> userList1, List<UserForSerchTableTest> userList2) {
        for (int i = 0; i <= userList1.size() - 1; i++) {
            if (!(userList1.get(i).getTerritorialCommunityName().equalsIgnoreCase(userList2.get(i).getTerritorialCommunityName()))) {
                System.out.println(userList1.get(i).getTerritorialCommunityName() + " " + userList2.get(i).getTerritorialCommunityName());
                return false;
            }
        }
        return true;
    }

    //methods to compare two object lists by LastName
    public boolean compareListsByLastName(List<UserForSerchTableTest> userList1, List<UserForSerchTableTest> userList2) {
        for (int i = 0; i <= userList1.size() - 1; i++) {
            if (!(userList1.get(i).getLastName().equalsIgnoreCase(userList2.get(i).getLastName()))) {
                System.out.println(userList1.get(i).getLastName() + " " + userList2.get(i).getLastName());
                return false;
            }
        }
        return true;
    }

    //sets the number of visible rows in table 100
    public void setNumbeOfItemsInTable() {
        new Select(driver.findElement(By.name(NUMBERS_OF_ROWN_IN_TABLE_NAME))).selectByVisibleText("100");
    }

    //sets the number of visible rows in table 10
    public void setNumbeOfItemsInTable10() {
        new Select(driver.findElement(By.name(NUMBERS_OF_ROWN_IN_TABLE_NAME))).selectByVisibleText("10");
    }

    // search by login name
    public void search(String login) {
        this.getLoginIinputField().clear();
        this.getLoginIinputField().sendKeys(login);
        this.getSearchButton().click();
    }

    public void clickFirstRow() {
        this.clickUserName();
        this.getFirstRowTable().click();
    }

    @Override
    public CoownersTable setLanguage(ChangeLanguageFields language) {
        Select lang = new Select(getLocalizationDropdown());
        lang.selectByVisibleText(language.toString());
        // Return a new page object representing the destination.
        return new CoownersTable(driver);
    }

    public enum LoginPageL10n {
        MESSAGE_WHEN_TABLE_EMPTY(
                "В таблиці немає даних",
                "В таблице нет данных",
                "No data");

        private HashMap<ChangeLanguageFields, String> field;

        private LoginPageL10n(String... localization) {
            this.field = new HashMap<ChangeLanguageFields, String>();
            int i = 0;
            for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
                this.field.put(language, localization[i]);
                i++;
            }
        }

        public String getLocalization(ChangeLanguageFields language) {
            return this.field.get(language).trim();
        }
    }
}
