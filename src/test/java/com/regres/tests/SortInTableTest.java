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

import java.util.Collections;
import java.util.List;

public class SortInTableTest {
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
     * choose non-confirmed co-owners and set option items on page = 100
     */
    @BeforeMethod
    public void beforeTest() {
        coownerstable = adminhomepage.goToNonConfirmedCoowners();
        coownerstable.setNumbeOfItemsInTable();
        coownerstable.waitWhileScriptsExecute();
    }

    /**
     * test verify that sort in table by "First Name" work correct
     */
    @Test
    public void sortInTableByFirstName() {
        //find all users from table write to list and sort by first name in ASC
        List<UserForSerchTableTest> allUsers = coownerstable.getListOfUsersFromTable();
        Collections.sort(allUsers, UserForSerchTableTest.userFirstNameComparatorASC);
        //sets sorting by first name and reads all table
        coownerstable.sortByFirstName();
        List<UserForSerchTableTest> sortedUsers = coownerstable.getListOfUsersFromTable();
        Assert.assertTrue(coownerstable.compareListsByFirstName(allUsers, sortedUsers));
    }

    /**
     * test verify that sort in table by "Community" work correct
     */
    @Test
    public void sortInTableByCommunity() {
        //find all users from table write to list and sort by community in ASC
        List<UserForSerchTableTest> allUsers = coownerstable.getListOfUsersFromTable();
        Collections.sort(allUsers, UserForSerchTableTest.userCommunityNameComparatorASC);
        //sets sorting by community and reads all table
        coownerstable.sortByCommunity();
        List<UserForSerchTableTest> sortedUsers = coownerstable.getListOfUsersFromTable();
        Assert.assertTrue(coownerstable.compareListsByCommunityName(allUsers, sortedUsers));
    }

    /**
     * test verify that sort in table by "Last Name" work correct
     */
    @Test
    public void sortInTableByLastName() {
        //find all users from table write to list and sort by last name in ASC
        List<UserForSerchTableTest> allUsers = coownerstable.getListOfUsersFromTable();
        Collections.sort(allUsers, UserForSerchTableTest.userLastNameComparatorASC);
        //sets sorting by last name and reads all table
        coownerstable.sortByLastName();
        List<UserForSerchTableTest> sortedUsers = coownerstable.getListOfUsersFromTable();
        Assert.assertTrue(coownerstable.compareListsByLastName(allUsers, sortedUsers));
    }
}

