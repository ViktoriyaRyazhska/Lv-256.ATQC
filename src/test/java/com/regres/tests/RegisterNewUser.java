package com.regres.tests;

import com.mysql.jdbc.PreparedStatement;
import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegisterNewUserPage;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.testdata.UserContainer;
import com.regres.testdata.UserForSerchTableTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegisterNewUser {
    private Application app;
    private AdminHomePage adminhomepage;
    Connection conn;
    RegisterNewUserPage registerNewUserPage;

    @BeforeClass
    public void setUp() throws SQLException, ClassNotFoundException, IOException {
        app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
        conn = ApplicationSources.createDBConnection();
        LoginPage loginpage = app.load();
        adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
        registerNewUserPage = adminhomepage.clickRegisterNewUser();
    }

    @AfterClass
    public void afterTest() throws ClassNotFoundException, SQLException, IOException {
        ApplicationSources.closeConnectionDB();
        app.quit();
    }

    @Test
    public void searchInTableByFirstName() throws SQLException {
        app.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        registerNewUserPage.registerNewUser("firstname","secondname","","asdasd@mail.com","gogidze","000000","000000","","","","","","","","","","","","Україна");
    }
}
