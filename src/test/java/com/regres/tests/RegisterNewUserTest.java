package com.regres.tests;

import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegisterNewUserPage;
import com.regres.testdata.UserContainer;
import com.regres.testdata.UserForRegisterNewUser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
    private String sheet = "sheet1";
    private File file = new File("UsersForRegisteredTest.xlsx");

    @BeforeClass
    public void setUp() throws SQLException, ClassNotFoundException, IOException {
        app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
        conn = ApplicationSources.createDBConnection();
        LoginPage loginpage = app.load();
        adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
        registerNewUserPage = adminhomepage.clickRegisterNewUser();
        userForRegisterNewUser = new UserForRegisterNewUser();
    }

    //@AfterClass
    public void afterTest() throws ClassNotFoundException, SQLException, IOException {
        for (UserForRegisterNewUser u : userForRegisterNewUser.addUserFromExcelToList(file, sheet)) {
            UserForRegisterNewUser.deleteUserInDB(conn, u);
        }
        ApplicationSources.closeConnectionDB();
        app.quit();
    }

    //test verify that registerNewUser work correctly
    @Test
    public void registerNewUserTest() throws SQLException, IOException, ClassNotFoundException {
//        //get number of users from BD before registration
//        int userInDBBefore = UserForRegisterNewUser.usersInDBQuantity(conn);
        //read users from excel and write to list
        List<UserForRegisterNewUser> userList = userForRegisterNewUser.addUserFromExcelToList(file, sheet);
        //register user from list
        for (UserForRegisterNewUser user : userList) {
            registerNewUserPage.registerNewUser(user);
            registerNewUserPage.clickButtonSend();
            registerNewUserPage = adminhomepage.clickRegisterNewUser();
        }
        List<UserForRegisterNewUser> userInDB = UserForRegisterNewUser.getListOfUsersInDB(conn);
        for (UserForRegisterNewUser u:userList){
            System.out.println(u);
        }
        System.out.println("");
        for (UserForRegisterNewUser u:userInDB){
            System.out.println(u);
        }
        System.out.println("");
        boolean actual = userList.containsAll(userInDB);
        System.out.println(actual);

        //get number of users from BD after registration
        //  int userInDBAfter = UserForRegisterNewUser.usersInDBQuantity(conn);
        //verified that quantity of registered users same as userList size
        //Assert.assertEquals(userList.size(), userInDBAfter - userInDBBefore);
    }
}
