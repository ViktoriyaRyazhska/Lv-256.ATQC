package com.regres.tests;

import com.mysql.jdbc.PreparedStatement;
import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.CoownerHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegisterNewUserPage;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.manage.coowners.CoownersElementsOnPageDropdown;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.testdata.DB.UserDB;
import com.regres.testdata.NewSubclass;
import com.regres.testdata.NewSubclassDataContainer;
import com.regres.testdata.ReadUsersFromEcxel;
import com.regres.testdata.RegisteredUserContainer;
import com.regres.testdata.RegisteredUsers;
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
import java.util.concurrent.TimeUnit;

public class RegisterNewUserTest {
	private Application app;
	private AdminHomePage adminhomepage;
	Connection conn;
	RegisterNewUserPage registerNewUserPage;
	UserForRegisterNewUser userForRegisterNewUser;
	CoownersElementsOnPageDropdown coownersElementOnPageDropdown;
	private String sheet = "sheet1";
	private File file = new File("UsersForRegisteredTest.xlsx");

	@BeforeClass
	public void setUp() {
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplicationDB());
		// conn = ApplicationSources.createDBConnection();
		LoginPage loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		registerNewUserPage = adminhomepage.clickRegisterNewUser();
	}

	@AfterClass
	public void afterTest() {
		// ApplicationSources.closeConnectionDB();
		app.quit();
	}

	@Test
	public void searchInTableByFirstName() {

		List<RegisteredUsers> users = RegisteredUserContainer.getValidData();
		for (RegisteredUsers validUser : users) {
			registerNewUserPage.registerNewUser(validUser);
			coownersElementOnPageDropdown = registerNewUserPage.clickButtonSend();
			registerNewUserPage = adminhomepage.clickRegisterNewUser();

		}
	}
}
