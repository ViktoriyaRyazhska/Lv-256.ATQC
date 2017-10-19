package com.regres.tests;

import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.testdata.DB.UserDB;
import com.regres.testdata.ReadUsersFromEcxel;
import com.regres.testdata.UserContainer;
import com.regres.testdata.UserForSerchTableTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class SortInTableTestBD {
    private Application app;
    private LoginPage loginpage;
    private AdminHomePage adminhomepage;
    private Connection dbConnector;
    private CoownersTable coownerstable;
    private String sheet = "sheet1";
    private File file = new File("UsersBD.xlsx");


    @BeforeClass
    public void setUp() throws SQLException, ClassNotFoundException, IOException {
        app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
        dbConnector = ApplicationSources.createDBConnection();
        List<UserDB> userDBList = new ReadUsersFromEcxel().addUserFromEcxelToList(file, sheet);
        for (UserDB u : userDBList) {
            UserDB.createUserInDB(dbConnector, u);
        }
        loginpage = app.load();
        adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
    }

    @BeforeMethod
    public void beforeMethod(){
        coownerstable = adminhomepage.goToActiveCoowners();
        coownerstable.setNumbeOfItemsInTable();
        coownerstable.waitWhileScriptsExecute();
    }

    @AfterClass
    public void afterTest() throws ClassNotFoundException, SQLException, IOException {
        for (UserDB u : new ReadUsersFromEcxel().addUserFromEcxelToList(file, sheet)) {
            UserDB.deleteUserInDB(dbConnector, u);
        }
        ApplicationSources.closeConnectionDB();
        app.quit();
    }

    /**
     * test verify that sort in table by "First Name" work correct
     */
    @Test
    public void sortInTableByFirstName() {
        //find all users from table write to list and sort by first name in ASC
        List<UserForSerchTableTest> allUsers = coownerstable.getListOfUsersFromTable();
        allUsers.sort(UserForSerchTableTest.userFirstNameComparatorASC);
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
        allUsers.sort(UserForSerchTableTest.userCommunityNameComparatorASC);
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
        allUsers.sort(UserForSerchTableTest.userLastNameComparatorASC);
        //sets sorting by last name and reads all table
        coownerstable.sortByLastName();
        List<UserForSerchTableTest> sortedUsers = coownerstable.getListOfUsersFromTable();
        Assert.assertTrue(coownerstable.compareListsByLastName(allUsers, sortedUsers));
    }
}

