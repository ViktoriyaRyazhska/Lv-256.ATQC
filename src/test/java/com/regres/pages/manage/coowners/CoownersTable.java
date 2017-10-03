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

import java.util.ArrayList;
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
    private String FIRST_NAME_COLUMN = ".//*[@id='inputIndex1']";
    private String LAST_NAME_COLUMN = ".//*[@id='inputIndex2']";
    private String LOGIN_COLUMN = ".//*[@id='inputIndex3']";
    private String COMMUNITY_COLUMN = ".//*[@id='inputIndex4']";
    private String EMAIL_COLUMN = ".//*[@id='inputIndex5']";
    private String ROLE_COLUMN = ".//*[@id='inputIndex6']";

    // table columns second row search
    private String FIRST_NAME_FIRST_XPATH = ".//tbody/tr[1]/td[2]";
    private String LAST_NAME_SEARCH_FIRST_XPATH = ".//tbody/tr[1]/td[3]";
    private String LOGIN_SEARCH_FIRST_XPATH = ".//tbody/tr[1]/td[4]";
    private String COMMUNITY_SEARCHN_FIRST_XPATH = ".//tbody/tr[1]/td[5]";
    private String EMAIL_SEARCH_FIRST_XPATH = ".//tbody/tr[1]/td[6]";
    private String ROLE_SEARCH_FIRST_XPATH = ".//tbody/tr[1]/td[7]";

    //table body
    private String TABLE_BODY_ROWS = "//*[@id='example']/tbody/tr";
    private String TABLE_BODY_CELL = TABLE_BODY_ROWS + "/td";//"//*[@id='example']/tbody/tr/td";

    public CoownersTable(WebDriver driver) {
        super(driver);
        getActions();
        getCountElements();
        getSearchButton();
        getPrevButtton();
        getNextButtton();
        getPaginateCurrentButton();
    }

    protected WebElement getActions() {
        return driver.findElement(By.id(ACTIONS_ID));
    }

    private WebElement getCountElements() {
        return driver.findElement(By.cssSelector(COUNT_ELEMENTS_CSSSELECTOR));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.id(SEARCH_BUTTON_ID));
    }

    private WebElement getPrevButtton() {
        return driver.findElement(By.id(PREV_BUTTON_ID));
    }

    private WebElement getNextButtton() {
        return driver.findElement(By.id(NEXT_BUTTON_ID));
    }

    private WebElement getPaginateCurrentButton() {
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

    // Business Logic

    public InactiveCoownersActionsDropdown goToInactiveCoowners() {
        // Return a new page object representing the destination.
        return new InactiveCoownersActionsDropdown(driver);
    }

    //table sorting by first name
    public void sortByFirstName() {
        driver.findElement(By.xpath(FIRST_NAME_SORT_XPATH)).click();
        waitWhileTableAppear();
    }
    //table sorting by last name
    public void sortByLastName() {
        driver.findElement(By.xpath(LAST_NAME_SORT_XPATH)).click();
        waitWhileTableAppear();
    }
    //table sorting by login
    public void sortByLogin() {
        driver.findElement(By.xpath(LOGIN_SORT_XPATH)).click();
        waitWhileTableAppear();
    }
    //table sorting by community
    public void sortByCommunity() {
        driver.findElement(By.xpath(COMMUNITY_SORT_XPATH)).click();
        waitWhileTableAppear();
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

    public void waitWhileTableAppear() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TABLE_BODY_CELL)));
    }

    /**
     * search in table by last Name
     *
     * @param - "searchParamether"
     * @return list of searched users
     */
    public List<UserForSerchTableTest> searchByLastName(List<UserForSerchTableTest> userList, String searchParamether) {
        List<UserForSerchTableTest> filteredList = new ArrayList<UserForSerchTableTest>();
        for (UserForSerchTableTest u : userList) {
            if (u.getLastName().contains(searchParamether)) {
                filteredList.add(u);
            }
        }
        return filteredList;
    }
    /**
     * search in table by community
     *
     * @param - searchParamether
     * @return list of searched users
     */
    public List<UserForSerchTableTest> searchByCommunity(List<UserForSerchTableTest> userList, String searchParamether) {
        List<UserForSerchTableTest> filteredList = new ArrayList<UserForSerchTableTest>();
        for (UserForSerchTableTest u : userList) {
            if (u.getTerritorialCommunityName().contains(searchParamether)) {
                filteredList.add(u);
            }
        }
        return filteredList;
    }

    /**
     * search in table by first name
     *
     * @param - "searchParamether"
     * @return list of searched users
     */
    public List<UserForSerchTableTest> searchByFirstName(List<UserForSerchTableTest> userList, String searchParamether) {
        List<UserForSerchTableTest> filteredList = new ArrayList<UserForSerchTableTest>();
        for (UserForSerchTableTest u : userList) {
            if (u.getFirstName().contains(searchParamether)) {
                filteredList.add(u);
            }
        }
        return filteredList;
    }

    /**
     * search in table by login
     *
     * @param - "searchParamether"
     * @return list of searched users
     */
    public List<UserForSerchTableTest> searchByLogin(List<UserForSerchTableTest> userList, String searchParamether) {
        List<UserForSerchTableTest> filteredList = new ArrayList<UserForSerchTableTest>();
        for (UserForSerchTableTest u : userList) {
            if (u.getLogin().contains(searchParamether)) {
                filteredList.add(u);
            }
        }
        return filteredList;
    }

    public UserForSerchTableTest getSearchParameter(List<UserForSerchTableTest> userList){
        return userList.get((int) (Math.random()*(userList.size()+1)));
    }

    /**
     * read all table and write users to list, one row - one user
     * one row contains 8 cells
     *
     * @return list of users from table
     */
    public List<UserForSerchTableTest> getListOfUsersFromTable() {
        waitWhileTableAppear();
        List<UserForSerchTableTest> userList = new ArrayList<UserForSerchTableTest>();
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
    }

    // compares equality of two user lists
    public boolean compareLists(List<UserForSerchTableTest> userList1, List<UserForSerchTableTest> userList2) {
        if (userList1.equals(userList2)) {
            return true;
        }
        return false;
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
}


