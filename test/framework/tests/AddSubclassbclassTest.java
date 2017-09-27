package framework.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

	@BeforeMethod
	public void setUp() {

		app = Application.get(ApplicationSourcesRepo.getChromeHerokuApplication());
		loginpage = app.load();
		registratorpage = loginpage.successfullLoginRegistrator(UserContainer.getRegistrator());
		subclassesOfObjects = registratorpage.clickSubclassesOfObjects();
		addNewSublassPage = subclassesOfObjects.clickAddNewSubclass();
	}

	@AfterClass
	public void tearDown() {

		// clickLogout();
		app.quit();
	}

	@Test
	public void checkUnSuccessfulAddedSubclass() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getInvalidEmptyData());
		addNewSublassPage.selectOptionDiscreteParameters();
		addNewSublassPage.buttonHideParameters.click();
		addNewSublassPage.saveButton.click();

	}

	//@Test
	public void checkSuccessfulAddedSubclass() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getValidData());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage.buttonHideParameters.click();
		subclassesOfObjects = addNewSublassPage.clickSaveButton();
	}

	//@Test
	public void checkAddedSubclassWithExistName() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getSameClassName());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage.buttonHideParameters.click();
		addNewSublassPage.saveButton.click();
		Assert.assertTrue(
				addNewSublassPage.getErrorMessage().getText().contains("Підклас з вказаним іменем вже існує"));
	}
	//@Test
	public void checkSuccessfulAddedSubclassClear() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getValidDataClear());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage.clickClearButton();
		
		addNewSublassPage.clickSaveButt();
	}
	//@Test
	public void checkAddSubclassField() {
		addNewSublassPage.clickButtonShowParameters();
		addNewSublassPage.addedNewSubclass(NewSubclassContainer.getValData());
		addNewSublassPage.selectOptionLinearParameter();
		addNewSublassPage.clickButtonAddParameters();
		addNewSublassPage.addedNewField(NewSubclassContainer.getAddedField());
		//addNewSublassPage.selectOptionDiscreteParameters();
		//addNewSublassPage.buttonDelParameters.click();
		//addNewSublassPage.buttonHideParameters.click();
		//subclassesOfObjects = addNewSublassPage.clickSaveButton();
	
}
}
