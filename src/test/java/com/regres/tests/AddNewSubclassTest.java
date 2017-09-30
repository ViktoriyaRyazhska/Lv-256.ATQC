package com.regres.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AddNewSubclassPage;
import com.regres.pages.LoginPage;
import com.regres.pages.RegistratorHomePage;
import com.regres.pages.SubclassesOfObjects;
import com.regres.testdata.NewSubclassContainer;
import com.regres.testdata.UserContainer;

public class AddNewSubclassTest {
		private LoginPage loginpage;
		private RegistratorHomePage registratorpage;
		private SubclassesOfObjects subclassesOfObjects;
		private AddNewSubclassPage addNewSublassPage;
		private Application app;

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

		@Test
		public void checkUnSuccessfulAddedSubclass() {
			addNewSublassPage.clickButtonShowParameters();
			addNewSublassPage.addedNewSubclass(NewSubclassContainer.getInvalidEmptyData());
			addNewSublassPage.selectOptionDiscreteParameters();
			addNewSublassPage.getButtonHideParameters().click();
			addNewSublassPage.getSaveButton().click();

		}

		@Test
		public void checkSuccessfulAddedSubclass() {
			addNewSublassPage.clickButtonShowParameters();
			addNewSublassPage.addedNewSubclass(NewSubclassContainer.getValidData());
			addNewSublassPage.selectOptionLinearParameter();
			addNewSublassPage.getButtonHideParameters().click();
			subclassesOfObjects = addNewSublassPage.clickSaveButton();
			Assert.assertEquals(subclassesOfObjects.getNameSubclas().isEnabled(), true);
			Assert.assertTrue(subclassesOfObjects.getNameSubclas().getText().contains("Sidney"));
		}

		@Test
		public void checkAddedSubclassWithExistName() {
			addNewSublassPage.clickButtonShowParameters();
			addNewSublassPage.addedNewSubclass(NewSubclassContainer.getSameClassName());
			addNewSublassPage.selectOptionLinearParameter();
			addNewSublassPage.getButtonHideParameters().click();
			addNewSublassPage.getSaveButton().click();
			Assert.assertTrue(
					addNewSublassPage.getErrorMessage().getText().contains("Підклас з вказаним іменем вже існує"));
		}

		@Test
		public void checkSuccessfulAddedSubclassClear() {
			addNewSublassPage.clickButtonShowParameters();
			addNewSublassPage.addedNewSubclass(NewSubclassContainer.getValidDataClear());
			addNewSublassPage.selectOptionLinearParameter();
			addNewSublassPage.clickClearButton();

			addNewSublassPage.clickSaveButt();
			boolean resultNameSub = addNewSublassPage.getEnterNameField().getText().isEmpty();
			Assert.assertEquals(resultNameSub, true);
			boolean resultUnitOfMeas = addNewSublassPage.getUnitOfMeasurementField().getText().isEmpty();
			Assert.assertEquals(resultUnitOfMeas, true);
			boolean resultParameterDes = addNewSublassPage.getParameterDescriptionField().getText().isEmpty();
			Assert.assertEquals(resultParameterDes, true);
		}

		// @Test
		public void checkAddSubclassField() {
			addNewSublassPage.clickButtonShowParameters();
			addNewSublassPage.addedNewSubclass(NewSubclassContainer.getValData());
			addNewSublassPage.selectOptionLinearParameter();
			addNewSublassPage.clickButtonAddParameters();
			addNewSublassPage.addedNewField(NewSubclassContainer.getAddedField());
			// addNewSublassPage.selectOptionDiscreteParameters();
			// addNewSublassPage.buttonDelParameters.click();
			// addNewSublassPage.buttonHideParameters.click();
			// subclassesOfObjects = addNewSublassPage.clickSaveButton();

		}
	}


