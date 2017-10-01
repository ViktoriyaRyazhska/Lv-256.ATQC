package com.regres.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AddNewSubclassPage;
import com.regres.pages.ConfirmMessagePage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.SubclassesOfObjects;
import com.regres.pages.ConnectionDB.ResourceTypes;
import com.regres.testdata.NewSubclassContainer;
import com.regres.testdata.UserContainer;

public class AddNewSubclassTest {
	private LoginPage loginpage;
	private RegistratorHomePage registratorpage;
	private SubclassesOfObjects subclassesOfObjects;
	private AddNewSubclassPage addNewSublassPage;
	private Application app;
	private ConfirmMessagePage confirmMessage;

	@BeforeMethod
	public void setUp() {
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		loginpage = app.load();
		registratorpage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
		subclassesOfObjects = registratorpage.clickSubclassesOfObjects();
		addNewSublassPage = subclassesOfObjects.clickAddNewSubclass();
	}

	@AfterMethod
	public void closeApp() {
		app.quit();
	}

	// @Test
	public void checkEmptyEnterNameField() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getInvalidEmptyData());
		addNewSublassPage.selectOptionDiscreteParameters();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		addNewSublassPage = addNewSublassPage.clickSaveButt();
		String resultValidation = addNewSublassPage.getEnterNameField().getAttribute("validationMessage");
		Assert.assertEquals(resultValidation, "Заполните это поле."); // "Please fill out this field."

	}

	// @Test
	public void checkSuccessfulAddedSubclass() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getValidData());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
		Assert.assertEquals(subclassesOfObjects.getNameSubclass().isEnabled(), true);
		Assert.assertTrue(subclassesOfObjects.getNameSubclass().getText().contains("Sidney"));

		// confirmMessage=subclassesOfObjects.clickDeleteSubclassSidney();

	}

	// @Test
	public void checkAddedSubclassWithExistName() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getSameClassName());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		addNewSublassPage.clickSaveButt();
		Assert.assertTrue(
				addNewSublassPage.getErrorMessage().getText().contains("Підклас з вказаним іменем вже існує"));

	}

	// @Test
	public void checkSuccessfulAddedSubclassClear() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getValidDataClear());
		addNewSublassPage.selectOptionLinearParameter();

		addNewSublassPage = addNewSublassPage.clickClearButton();

		addNewSublassPage = addNewSublassPage.clickSaveButt();
		Assert.assertEquals(addNewSublassPage.getEnterNameField().getText().isEmpty(), true);
		Assert.assertEquals(addNewSublassPage.getUnitOfMeasurementField().getText().isEmpty(), true);
		Assert.assertEquals(addNewSublassPage.getUnitOfMeasurementField().getText().isEmpty(), true);
		Assert.assertTrue(addNewSublassPage.getDropdownButtonText().contains("Виберіть тип параметру"));
	}

	// @Test
	public void checkAddSubclassField() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getValData());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage = addNewSublassPage.clickButtonAddParameters();
		addNewSublassPage = addNewSublassPage.addedNewField(NewSubclassContainer.getAddedField());
		addNewSublassPage.selectOptionDiscreteParameters();
		addNewSublassPage = addNewSublassPage.clickButtonDelParameters();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
		Assert.assertEquals(subclassesOfObjects.getNameSub().isEnabled(), true);
		Assert.assertTrue(subclassesOfObjects.getNameSub().getText().contains("Ivano-Frankivsk"));
	}

}
