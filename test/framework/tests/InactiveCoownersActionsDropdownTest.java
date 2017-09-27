package framework.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import framework.application.Application;
import framework.application.ApplicationSourcesRepo;
import framework.pages.AdminHomePage;
import framework.pages.LoginPage;
import framework.pages.coowners.actions.CoownersTable;
import framework.pages.coowners.actions.InactiveCoownersActionsDropdown;
import framework.testdata.UserContainer;

public class InactiveCoownersActionsDropdownTest {
	private Application app;
	private LoginPage loginpage;
	private AdminHomePage adminhomepage;
	private CoownersTable coownerstable;
	private InactiveCoownersActionsDropdown inactivecoowners;

	@BeforeClass
	public void setUp() {
		app = app.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
		loginpage = app.load();
		adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
		coownerstable = adminhomepage.goToInactiveCoowners();
		inactivecoowners = coownerstable.goToInactiveCoowners();

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		app.quit();
	}

	@Test
	// this test verify that when in action dropdown by clicking on 'Set as Active'
	// link confirm message appears when not chosen co owner
	public void verifyThatErrorMessageAppearsWhenNotChosenCoownerByClickingOnSetActive() {
		inactivecoowners.clickActionsDropdown();
		inactivecoowners.clickUnblock();
		assertEquals(inactivecoowners.getConfirmMessage().getConfirmMessageText(),
				"Для виконання даної операції спочатку потрібно вибрати співвласників, "
				+ "натиснувши на відповідні стрічки в таблиці");
		inactivecoowners.getConfirmMessage().clickCloseButton();
	}

	@Test
	// this test verify that when in action dropdown by clicking on 'Block' link
	// confirm message appears when not chosen co-owner
	public void verifyThatErrorMessageAppearsWhenNotChosenCoownerByClickingOnBlock() {
		inactivecoowners.clickActionsDropdown();
		inactivecoowners.clickBlock();
		assertEquals(inactivecoowners.getConfirmMessage().getConfirmMessageText(),
				"Для виконання даної операції спочатку потрібно вибрати співвласників, "
				+ "натиснувши на відповідні стрічки в таблиці");
		inactivecoowners.getConfirmMessage().clickCloseButton();
	}

	@Test
	// this test verify that when in action dropdown by clicking on 'Set community'
	// link confirm message appears when not chosen co-owner
	public void verifyThatErrorMessageAppearsWhenNotChosenCoownerByClickingOnSetCommunity() {
		inactivecoowners.clickActionsDropdown();
		inactivecoowners.clickSetCommunityButNotSelectedCoowners();
		assertEquals(inactivecoowners.getConfirmMessage().getConfirmMessageText(),
				"Для виконання даної операції спочатку потрібно вибрати співвласників, "
				+ "натиснувши на відповідні стрічки в таблиці");
		inactivecoowners.getConfirmMessage().clickCloseButton();
	}

}
