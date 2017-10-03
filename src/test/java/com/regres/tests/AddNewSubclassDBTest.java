package com.regres.tests;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSources;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AddNewSubclassPage;
import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.SubclassesOfObjects;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.ValueDB;
import com.regres.testdata.NewSubclassContainer;
import com.regres.testdata.UserContainer;

public class AddNewSubclassDBTest {
	private LoginPage loginpage;
	private RegistratorHomePage registratorpage;
	private SubclassesOfObjects subclassesOfObjects;
	private AddNewSubclassPage addNewSublassPage;
	private Application app;
	public Connection conn;
	public ValueDB valueDB;

	@BeforeClass
	public void setUp() throws ClassNotFoundException, SQLException {
		app = Application.get(ApplicationSourcesRepo.getChromeLocalApplicationDb());
		conn = ApplicationSources.createDBConnection();
		loginpage = app.load();
		loginpage = loginpage.setLanguage(ChangeLanguageFields.UKRAINIAN);
		registratorpage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
		valueDB = new ValueDB();
	}

	@AfterClass
	public void set() throws ClassNotFoundException, SQLException {
		ApplicationSources.closeConnectionDB();
		app.quit();

	}

	@BeforeMethod
	public void setData() {
		registratorpage = loginpage.getRegistratorHomePage();
		subclassesOfObjects = registratorpage.clickSubclassesOfObjects();
		addNewSublassPage = subclassesOfObjects.clickAddNewSubclass();
	}

	@Test
	public void checkSuccessfulAddedSubclassDB() throws ClassNotFoundException, SQLException {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getDataDB());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
		Assert.assertEquals(subclassesOfObjects.getNameSubclassDB(NewSubclassContainer.getDataDB()).isEnabled(), true);
		Assert.assertTrue(
				subclassesOfObjects.getNameSubclassDB(NewSubclassContainer.getDataDB()).getText().contains("Lviv"));
		Assert.assertEquals(valueDB.comparisonValueInDB(conn),"Lviv");
	}
}
