package framework.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import framework.application.Application;
import framework.application.ApplicationSourcesRepo;
import framework.pages.LoginPage;
import framework.pages.RegistratorHomePage;
import framework.pages.SubclassesOfObjects;
import framework.subclassesOfObjectsPage.AddNewSubclassPage;
import framework.testdata.NewSubclassContainer;
import framework.testdata.UserContainer;

public class AddSubclassbclassTest {

	private WebDriver driver;
	private LoginPage loginpage;
	private RegistratorHomePage registratorpage;
	private SubclassesOfObjects subclassesOfObjects;
	private AddNewSubclassPage addNewSublassPage;
	private Application app;

	@BeforeClass
	public void setUp() {
		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		loginpage = app.load();
	}

	@BeforeMethod
	public void SignInRegistr() {
		registratorpage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
		subclassesOfObjects = registratorpage.clickSubclassesOfObjects();
		addNewSublassPage = subclassesOfObjects.clickAddNewSubclass();
	}

	@AfterClass
	public void closeApp() {
		app.quit();
	}

	@AfterMethod
	public void logOut() {
		subclassesOfObjects.clickLogout();
	}

	@Test
	public void checkUnSuccessfulAddedSubclass() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getInvalidEmptyData());
		addNewSublassPage.selectOptionDiscreteParameters();
		addNewSublassPage.buttonHideParameters.click();
		addNewSublassPage.saveButton.click();

	}

	@Test
	public void checkSuccessfulAddedSubclass() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getValidData());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage.buttonHideParameters.click();
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
		Assert.assertEquals(subclassesOfObjects.getNameSubclas().isEnabled(), true);
		Assert.assertTrue(subclassesOfObjects.getNameSubclas().getText().contains("Sidney"));
	}

	@Test
	public void checkAddedSubclassWithExistName() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getSameClassName());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage.buttonHideParameters.click();
		addNewSublassPage.saveButton.click();
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
