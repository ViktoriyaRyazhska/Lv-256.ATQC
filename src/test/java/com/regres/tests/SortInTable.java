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
import java.util.Comparator;
import java.util.List;

public class SortInTable {
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
        coownerstable.waitWhileTableAppear();
    }

    /**
     * test verify that sort in table by "First Name" work correct
     */
    @Test
    public void sortInTableByFirstName() {
        List<UserForSerchTableTest> userList1 = coownerstable.getListOfUsersFromTable();
        Collections.sort(userList1, UserForSerchTableTest.userFirstNameComparatorASC);
        coownerstable.clickFIRST_NAME_SORT();
        List<UserForSerchTableTest> userList2 = coownerstable.getListOfUsersFromTable();
        Assert.assertTrue(coownerstable.compareToSortedListsByObjectFirstName(userList1, userList2));
    }

    /**
     * test verify that sort in table by "Login" work correct
     */
    @Test
    public void sortInTableByLogin() {
        List<UserForSerchTableTest> userList1 = coownerstable.getListOfUsersFromTable();
        Collections.sort(userList1, UserForSerchTableTest.userLoginComparatorDESC);
        coownerstable.clickLOGIN_SORT();//one click - desc, because sorted default by login in ASC
        List<UserForSerchTableTest> userList2 = coownerstable.getListOfUsersFromTable();
        Assert.assertTrue(coownerstable.compareToSortedListsByObjectLogin(userList1, userList2));
    }

    /**
     * test verify that sort in table by "Community" work correct
     */
    @Test
    public void sortInTableByCommunity() {
        List<UserForSerchTableTest> userList1 = coownerstable.getListOfUsersFromTable();
        Collections.sort(userList1, UserForSerchTableTest.userCommunityNameComparatorASC);
        coownerstable.clickCOMMUNITY_SORT();
        List<UserForSerchTableTest> userList2 = coownerstable.getListOfUsersFromTable();
        Assert.assertTrue(coownerstable.compareToSortedListsByObjectCommunityName(userList1, userList2));
    }

    /**
     * test verify that sort in table by "Last Name" work correct
     */
    @Test
    public void sortInTableByLastName() {
        List<UserForSerchTableTest> userList1 = coownerstable.getListOfUsersFromTable();
        Collections.sort(userList1, UserForSerchTableTest.userLastNameComparatorASC);
        coownerstable.clickLAST_NAME_SORT();
        List<UserForSerchTableTest> userList2 = coownerstable.getListOfUsersFromTable();
        Assert.assertTrue(coownerstable.compareToSortedListsByObjectLastName(userList1, userList2));
    }
}

