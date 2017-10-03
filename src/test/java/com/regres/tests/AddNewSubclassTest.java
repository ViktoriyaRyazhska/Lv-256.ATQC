package com.regres.tests;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AddNewSubclassPage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.SubclassesOfObjects;
import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.testdata.NewSubclassContainer;
import com.regres.testdata.UserContainer;

public class AddNewSubclassTest {
	private LoginPage loginpage;
	private RegistratorHomePage registratorpage;
	private SubclassesOfObjects subclassesOfObjects;
	private AddNewSubclassPage addNewSublassPage;
	private Application app;

	@BeforeClass
	public void setUp() {
		app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		loginpage = loginpage.setLanguage(ChangeLanguageFields.UKRAINIAN);
		registratorpage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
	}

	@BeforeMethod
	public void setData() {
		registratorpage = loginpage.getRegistratorHomePage();
		subclassesOfObjects = registratorpage.clickSubclassesOfObjects();
		addNewSublassPage = subclassesOfObjects.clickAddNewSubclass();
	}

	@AfterClass
	public void closeApp() {
		app.quit();
	}

	@Test
	public void checkEmptyEnterNameField() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getInvalidEmptyData());
		addNewSublassPage.selectOptionDiscreteParameters();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		addNewSublassPage = addNewSublassPage.clickSaveButt();
		String resultValidation = addNewSublassPage.getEnterNameField().getAttribute("validationMessage");
		Assert.assertEquals(resultValidation, "Заповніть будь ласка це поле."); // "Please fill out this field."

	}

	
	@Test
	public void checkSuccessfulAddedSubclass() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getValidData());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
		Assert.assertTrue(subclassesOfObjects.getSubclassName(NewSubclassContainer.getValidData()).isEnabled());
		Assert.assertTrue(subclassesOfObjects.getSubclassName(NewSubclassContainer.getValidData()).getText().contains("Sidney"));
		subclassesOfObjects=subclassesOfObjects.clickOnDeleteSubclassButton(NewSubclassContainer.getValidData());

	}

	@Test
	public void checkAddedSubclassWithExistName() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getSameClassName());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage = addNewSublassPage.clickButtonHideParameters();
		addNewSublassPage.clickSaveButt();
		Assert.assertTrue(
				addNewSublassPage.getErrorMessage().getText().contains("Підклас з вказаним іменем вже існує"));

	}

	@Test
	public void checkSuccessfulAddedSubclassClear() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getValidDataClear());
		addNewSublassPage.selectOptionLinearParameter();

		addNewSublassPage = addNewSublassPage.clickClearButton();

		addNewSublassPage = addNewSublassPage.clickSaveButt();
		Assert.assertTrue(addNewSublassPage.getEnterNameField().getText().isEmpty());
		Assert.assertTrue(addNewSublassPage.getUnitOfMeasurementField().getText().isEmpty());
		Assert.assertTrue(addNewSublassPage.getUnitOfMeasurementField().getText().isEmpty());
		Assert.assertTrue(addNewSublassPage.getDropdownButtonText().contains("Виберіть тип параметру"));
	}

	@Test
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
		Assert.assertTrue(subclassesOfObjects.getSubclassName(NewSubclassContainer.getValData()).isEnabled());
		Assert.assertTrue(subclassesOfObjects.getSubclassName(NewSubclassContainer.getValData()).getText().contains("Ivano-Frankivsk"));
		subclassesOfObjects=subclassesOfObjects.clickOnDeleteSubclassButton(NewSubclassContainer.getValData());
	}
}
