package com.regres.tests;

import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.TitleLocalFooter;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.testdata.DB.UserDB;
import com.regres.testdata.ReadUsersFromEcxel;
import com.regres.testdata.UserContainer;
import com.regres.testdata.UserForSerchTableTest;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SearchInTableDBTest {
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
     * test verify that search in table by "First Name" work correct
     */
    @Test
    public void searchInTableByFirstName() {
        //find all users from table and chose random user's last name for future search in table
        List<UserForSerchTableTest> allUsers = coownerstable.getListOfUsersFromTable();
        String searchParam = coownerstable.getSearchParameter(allUsers).getFirstName();
        //select users from all user list by search parameter
        List<UserForSerchTableTest> expectFilteredUsers = coownerstable.searchByFirstName(allUsers, searchParam);
        //set search parameter in table search field and press button search
        //read table and write searched users to list
        coownerstable.setFirstNameSearch(searchParam);
        coownerstable.getSearchButton().click();
        List<UserForSerchTableTest> actualFilteredUsers = coownerstable.getListOfUsersFromTable();
        //compare to lists
        Assert.assertTrue(coownerstable.compareLists(expectFilteredUsers, actualFilteredUsers));
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
        List<UserForSerchTableTest> actualFilteredUsers = coownerstable.getListOfUsersFromTable();
        //compare to lists
        Assert.assertTrue(coownerstable.compareLists(expectFilteredUsers, actualFilteredUsers));
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
        List<UserForSerchTableTest> actualFilteredUsers = coownerstable.getListOfUsersFromTable();
        //compare to lists
        Assert.assertTrue(coownerstable.compareLists(expectFilteredUsers, actualFilteredUsers));
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
        List<UserForSerchTableTest> actualFilteredUsers = coownerstable.getListOfUsersFromTable();
        //compare to lists
        Assert.assertTrue(coownerstable.compareLists(expectFilteredUsers, actualFilteredUsers));
    }

    //check if message appear when result search table empty and if message correct
    @Test(dataProvider = "L10N")
    public void searchInEmptyTable(TitleLocalFooter.ChangeLanguageFields language) {
        coownerstable = coownerstable.setLanguage(language);
        coownerstable.setFirstNameSearch("ahsgdlajhsdgkads");
        coownerstable.getSearchButton().click();
        //Assert.assertEquals(coownerstable.waitWhileEmptyTableAppear(), "В таблиці немає даних");
        Assert.assertEquals(coownerstable.waitWhileEmptyTableAppear(), CoownersTable.LoginPageL10n.MESSAGE_WHEN_TABLE_EMPTY.getLocalization(language));
    }

    @DataProvider(name = "L10N")
    public static Object[] localizationProvider() {
        return new Object[][]{{TitleLocalFooter.ChangeLanguageFields.UKRAINIAN}, {TitleLocalFooter.ChangeLanguageFields.ENGLISH},
                {TitleLocalFooter.ChangeLanguageFields.RUSSIAN}};
    }
}