package com.regres.tests;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.testdata.UserContainer;
import com.regres.testdata.UserForSerchTableTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchInTable {
    private Application app;
    private LoginPage loginpage;
    private AdminHomePage adminhomepage;
    private CoownersTable coownerstable;

    @BeforeClass
    public void setUp() {
        app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
        loginpage = app.load();
        adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
    }

    @AfterClass
    public void tearDown() {
        app.quit();
    }

    /**
     * choose non-confirmed co-owners
     */
    @BeforeMethod
    public void beforeTest() {
        coownerstable = adminhomepage.goToNonConfirmedCoowners();
        coownerstable.setNumbeOfItemsInTable();
        coownerstable.waitWhileTableAppear();
    }

    /**
     * test verify that seatch in table by "First Name" work correct
     */
    @Test
    public void searchInTableByFirstName() {
        //find all users from table and chose random user's last name for future search in table
        List<UserForSerchTableTest> allUsers = coownerstable.getListOfUsersFromTable();
        String searchParam = coownerstable.getSearchParameter(allUsers).getFirstName();
        //select users from all user list by search parameter
        List<UserForSerchTableTest> expectFilteredUsers = coownerstable.searchByFirstName(allUsers, searchParam);
        //set search parameter in table search field and press button search
        // read table and write searched users to list
        coownerstable.setLastNameSearch(searchParam);
        coownerstable.getSearchButton().click();
        List<UserForSerchTableTest> actualFilteredUsersBy = coownerstable.getListOfUsersFromTable();
        //compare to lists
        Assert.assertTrue(coownerstable.compareLists(expectFilteredUsers, actualFilteredUsersBy));
    }

    /**
     * test verify that seatch in table by "Login" work correct
     */
    @Test
    public void searchInTableByLogin() {
        //find all users from table and chose random user's last name for future search in table
        List<UserForSerchTableTest> allUsers = coownerstable.getListOfUsersFromTable();
        String searchParam = coownerstable.getSearchParameter(allUsers).getLogin();
        //select users from all user list by search parameter
        List<UserForSerchTableTest> expectFilteredUsers = coownerstable.searchByLogin(allUsers, searchParam);
        //set search parameter in table search field and press button search
        // read table and write searched users to list
        coownerstable.setLoginSearch(searchParam);
        coownerstable.getSearchButton().click();
        List<UserForSerchTableTest> actualFilteredUsersBy = coownerstable.getListOfUsersFromTable();
        //compare to lists
        Assert.assertTrue(coownerstable.compareLists(expectFilteredUsers, actualFilteredUsersBy));
    }

    /**
     * test verify that seatch in table by "Community" work correct
     */
    @Test
    public void searchInTableByCommunity() {
        //find all users from table and chose random user's last name for future search in table
        List<UserForSerchTableTest> allUsers = coownerstable.getListOfUsersFromTable();
        String searchParam = coownerstable.getSearchParameter(allUsers).getTerritorialCommunityName();
        //select users from all user list by search parameter
        List<UserForSerchTableTest> expectFilteredUsers = coownerstable.searchByCommunity(allUsers, searchParam);
        //set search parameter in table search field and press button search
        // read table and write searched users to list
        coownerstable.setCommunitySearch(searchParam);
        coownerstable.getSearchButton().click();
        List<UserForSerchTableTest> actualFilteredUsersBy = coownerstable.getListOfUsersFromTable();
        //compare to lists
        Assert.assertTrue(coownerstable.compareLists(expectFilteredUsers, actualFilteredUsersBy));
    }

    /**
     * test verify that seatch in table by "Last Name" work correct
     */
    @Test
    public void searchInTableByLastName() {
        //find all users from table and chose random user's last name for future search in table
        List<UserForSerchTableTest> allUsers = coownerstable.getListOfUsersFromTable();
        String searchParam = coownerstable.getSearchParameter(allUsers).getLastName();
        //select users from all user list by search parameter
        List<UserForSerchTableTest> expectFilteredUsers = coownerstable.searchByLastName(allUsers, searchParam);
        //set search parameter in table search field and press button search
        // read table and write searched users to list
        coownerstable.setLastNameSearch(searchParam);
        coownerstable.getSearchButton().click();
        List<UserForSerchTableTest> actualFilteredUsersBy = coownerstable.getListOfUsersFromTable();
        //compare to lists
        Assert.assertTrue(coownerstable.compareLists(expectFilteredUsers, actualFilteredUsersBy));
    }


}

