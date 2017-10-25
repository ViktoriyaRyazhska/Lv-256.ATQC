package com.regres.tests;

import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegisterNewUserPage;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.testdata.UserContainer;
import com.regres.testdata.UserForRegisterNewUser;
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
import java.util.List;

public class RegisterNewUserTest {
    private Application app;
    private AdminHomePage adminhomepage;
    private Connection conn;
    private RegisterNewUserPage registerNewUserPage;
    private UserForRegisterNewUser userForRegisterNewUser;
    private CoownersTable coownerstable;
    private String sheet = "sheet1";
    private File validDataAllFields = new File("UsersForRegisteredTest.xlsx");
    private File validDataMatadoryFields = new File("UsersForRegisterTestMatadoryValid.xlsx");


    @BeforeClass
    public void setUp() throws SQLException, ClassNotFoundException, IOException {
        app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
        conn = ApplicationSources.createDBConnection();
        LoginPage loginpage = app.load();
        adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
    }

    @BeforeMethod
    public void beforeMethod() throws SQLException, ClassNotFoundException, IOException {
        registerNewUserPage = adminhomepage.clickRegisterNewUser();
        userForRegisterNewUser = new UserForRegisterNewUser();
    }

    @AfterClass
    public void afterTest() throws ClassNotFoundException, SQLException, IOException {
        ApplicationSources.closeConnectionDB();
        app.quit();
    }

    //test verify that registerNewUser work correctly with valid data and filled all fields
    @Test
    public void registerNewUsersSetAllFieldsValidDataTest() throws SQLException, IOException, ClassNotFoundException {
        //read users from excel and write to list
        List<UserForRegisterNewUser> excelUserList = userForRegisterNewUser.addUserFromExcelToList(validDataAllFields, sheet);
        //register user from list
        for (UserForRegisterNewUser user : excelUserList) {
            registerNewUserPage.registerNewUser(user);
            registerNewUserPage.clickButtonSend();
            registerNewUserPage = adminhomepage.clickRegisterNewUser();
        }
        //get list of users from DB
        List<UserForRegisterNewUser> userInDB = UserForRegisterNewUser.getListOfUsersInDB(conn);
        //verify that users from excel files adds and displayed on UI
        boolean b = checkRegisterNewUserOnUI(excelUserList);
        //clear DB from testdata
        for (UserForRegisterNewUser u : userForRegisterNewUser.addUserFromExcelToList(validDataAllFields, sheet)) {
            UserForRegisterNewUser.deleteUserInDB(conn, u);
        }
        //verify that users from excel files adds and displayed on UI
        Assert.assertTrue(b);
        //verify that users from excel files adds correctly to DB
        Assert.assertTrue(userInDB.containsAll(excelUserList));
    }

    //test verify that registerNewUser work correctly with valid data and filled only matadory fields
    @Test
    public void registerNewUsersSetMatadoryFieldsValidDataTest() throws SQLException, IOException, ClassNotFoundException {
        //read users from excel and write to list
        List<UserForRegisterNewUser> excelUserList = userForRegisterNewUser.addUserFromExcelToList(validDataMatadoryFields, sheet);
        //register user from list
        for (UserForRegisterNewUser user : excelUserList) {
            registerNewUserPage.registerNewUser(user);
            registerNewUserPage.clickButtonSend();
            registerNewUserPage = adminhomepage.clickRegisterNewUser();
        }
        //get list of users from DB
        List<UserForRegisterNewUser> userInDB = UserForRegisterNewUser.getListOfUsersInDB(conn);
        //verify that users from excel files adds and displayed on UI
        boolean b = checkRegisterNewUserOnUI(excelUserList);
        //clear DB from testdata
        for (UserForRegisterNewUser u : userForRegisterNewUser.addUserFromExcelToList(validDataAllFields, sheet)) {
            UserForRegisterNewUser.deleteUserInDB(conn, u);
        }
        //verify that users from excel files adds and displayed on UI
        Assert.assertTrue(b);
        //verify that users from excel files adds correctly to DB
        Assert.assertTrue(userInDB.containsAll(excelUserList));
    }

    public boolean checkRegisterNewUserOnUI(List<UserForRegisterNewUser> excelList){
        coownerstable = adminhomepage.goToNonConfirmedCoowners();
        coownerstable.setNumbeOfItemsInTable();
        coownerstable.waitWhileScriptsExecute();
        List<UserForSerchTableTest> usersFromUi = coownerstable.getListOfUsersFromTable();
        int count=0;
        for(UserForRegisterNewUser uEx:excelList){
            for(UserForSerchTableTest uUi:usersFromUi){
                if(uEx.getLogin().equalsIgnoreCase(uUi.getLogin())){
                    count++;
                }
            }
        }
        return count==excelList.size();
    }


}
