package com.regres.tests;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.testdata.UserContainer;
import com.regres.testdata.UserForSerchTableTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchInTable {
    private Application app;
    private LoginPage loginpage;
    private AdminHomePage adminhomepage;
    //private CoownersTable coownerstable;


    @BeforeClass
    public void setUp() {
        app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
        loginpage = app.load();
        adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
//        coownerstable=adminhomepage.goToNonConfirmedCoowners();//вивести непідтверджених юзерів
//        coownerstable.setNumbeOfItemsInTable(); //вивести 100 позицій в таблиці
//        coownerstable.waitWhileTableAppear();
    }

    @AfterClass
    public void tearDown() {
        app.quit();
    }

    /**
     * choose non-confirmed co-owners and set option items on page = 100
     */
//    @BeforeMethod
//    public void beforeTest() {
//        CoownersTable coownerstable=adminhomepage.goToNonConfirmedCoowners();//вивести непідтверджених юзерів
//        coownerstable.setNumbeOfItemsInTable(); //вивести 100 позицій в таблиці
//        coownerstable.waitWhileTableAppear();
//    }


    /**
     * This test verify that seatch in table by "First Name" work correct
     */
    @Test
    public void searchInTableByFirstName() {
        CoownersTable coownerstable=adminhomepage.goToNonConfirmedCoowners();//вивести непідтверджених юзерів
        coownerstable.setNumbeOfItemsInTable(); //вивести 100 позицій в таблиці
        coownerstable.waitWhileTableAppear();
        //read full table and write to list users whose first name contains "ya"
        List<UserForSerchTableTest> userList1 = coownerstable.searchByFirstName("ya");
        //set value in search field "First Name"
        coownerstable.setFIRST_NAME_SEARCH("ya");
        coownerstable.getSearchButton().click();
        //read new table with search result and write user to new list
        List<UserForSerchTableTest> userList2 = coownerstable.getListOfUsersFromTable();
        coownerstable.compareLists(userList1, userList2);
        coownerstable.getFirstNameColumn().clear();
    }

    @Test
    public void searchInTableByLogin() {
        CoownersTable coownerstable=adminhomepage.goToNonConfirmedCoowners();//вивести непідтверджених юзерів
        coownerstable.setNumbeOfItemsInTable(); //вивести 100 позицій в таблиці
        coownerstable.waitWhileTableAppear();
        List<UserForSerchTableTest> userList1 = coownerstable.searchByLogin("in");
        coownerstable.setLOGIN_SEARCH("in");
        coownerstable.getSearchButton().click();
        List<UserForSerchTableTest> userList2 = coownerstable.getListOfUsersFromTable();
        coownerstable.compareLists(userList1, userList2);
    }
//
//    //@Test
//    public void searchInTableByCommunity() {
//        List<UserForSerchTableTest> userList1 = coownerstable.searchByTerritorialCommunityName("Ukr");
//        coownerstable.setCOMMUNITY_SEARCHN("Ukr");
//        coownerstable.getSearchButton().click();
//        List<UserForSerchTableTest> userList2 = coownerstable.getListOfUsersFromTable();
//        coownerstable.compareLists(userList1, userList2);
//    }
//
//    //@Test
//    public void searchInTableByLastName() {
//        List<UserForSerchTableTest> userList1 = coownerstable.searchByLastName("aa");
//        coownerstable.setLAST_NAME_SEARCH("aa");
//        coownerstable.getSearchButton().click();
//        List<UserForSerchTableTest> userList2 = coownerstable.getListOfUsersFromTable();
//        coownerstable.compareLists(userList1, userList2);
//    }
}

