package com.regres.tests;

import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.CoownerHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegisterNewUserPage;
import com.regres.testdata.UserContainer;
import com.regres.testdata.UserForRegisterNewUser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegisterNewUserTest {
    private Application app;
    private AdminHomePage adminhomepage;
    Connection conn;
    RegisterNewUserPage registerNewUserPage;
    UserForRegisterNewUser userForRegisterNewUser;
    private String sheet = "sheet1";
    private File file = new File("UsersForRegisteredTest.xlsx");

    @BeforeClass
    public void setUp() throws SQLException, ClassNotFoundException, IOException {
        app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
        conn = ApplicationSources.createDBConnection();
        LoginPage loginpage = app.load();
        adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
        registerNewUserPage = adminhomepage.clickRegisterNewUser();
        userForRegisterNewUser=new UserForRegisterNewUser();
    }

    @AfterClass
    public void afterTest() throws ClassNotFoundException, SQLException, IOException {
        for (UserForRegisterNewUser u : userForRegisterNewUser.addUserFromExcelToList(file, sheet)) {
            UserForRegisterNewUser.deleteUserInDB(conn, u);
        }
        ApplicationSources.closeConnectionDB();
        app.quit();
    }

    @Test
    public void searchInTableByFirstName() throws SQLException, IOException {
        app.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        List<UserForRegisterNewUser> userDBList = userForRegisterNewUser.addUserFromExcelToList(file, sheet);
        for (UserForRegisterNewUser u : userDBList) {
            registerNewUserPage.registerNewUser(u);
            registerNewUserPage.clickButtonSend();
            registerNewUserPage = adminhomepage.clickRegisterNewUser();
        }
    }
}
