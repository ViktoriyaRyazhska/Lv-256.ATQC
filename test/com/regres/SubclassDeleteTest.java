package com.regres;

import org.testng.annotations.*;
import com.regres.SubclassesOfObjectsPage;
import static org.testng.Assert.*;

/**
 * This Test Class verify that Registrator can delete existing subclass of
 * objects, can cancel deleting, and cannot delete subclass with exist resources.
 * 
 * @author Bohdan Zhyvko
 *
 */
public class SubclassDeleteTest {
	private SubclassesOfObjectsPage subclass;

	@BeforeClass
	// initial property
	public void setUpClass() {
		subclass = new SubclassesOfObjectsPage();
		subclass.initWebDriver();
		subclass.precondition();
	}

	@BeforeGroups(groups = { "TestData" })
	// create test data for group
	public void setUpTestData() {
		subclass.addSubclass();
	}

	@AfterGroups(groups = { "TestData" }, alwaysRun = true)
	// always delete test data for group
	public void deleteTestData() {
		if (subclass.isSubclassPresent("Test")) {
			subclass.deleteSubclass("Test");
		}
	}

	@AfterClass(alwaysRun = true)
	// always close web driver
	public void tearDown() {
		subclass.quit();
	}

	/*----------------------------------Tests Delete Subclass----------------------------------*/
	/*
	 * Verify that existing class can close deletion and the class and all its’
	 * parameter are not removed.
	 */
	@Test(groups = { "TestData" })
	public void testCancelDelettingByCloseButton() {
		subclass.clickOnDeleteSubclassButton("Test");
		assertEquals(subclass.getConfirmMessageText(), "Do you really want to delete this class?");
		// click on 'Close' - button on confirm message
		subclass.clickOnCloseButton();
		assertTrue(subclass.isSubclassPresent("Test"));
	}

	/*
	 * Verify that existing class can cancel deletion and the class and all its’
	 * parameter are not removed.
	 */
	@Test(groups = { "TestData" })
	public void testCancelDelettingByCancelButton() {
		subclass.clickOnDeleteSubclassButton("Test");
		assertEquals(subclass.getConfirmMessageText(), "Do you really want to delete this class?");
		// 'Cancel' - button
		subclass.clickOnCancelButton();
		assertTrue(subclass.isSubclassPresent("Test"));
	}

	/*
	 * Verify that existing class is deleted after clicking 'OK' button on the
	 * confirmation message.
	 */
	@Test(groups = { "TestData" }, priority = 1)
	public void testDeleteByOkButton() {
		subclass.deleteSubclass("Test");
		assertFalse(subclass.isSubclassPresent("Test"));
	}

	/*
	 * Verify that existing subclass cannot be deleted if resources already exist by
	 * clicking on 'OK' button on the 'Cannot delete subclass' confirmation message.
	 */
	@Test
	public void testCancelDelettingBySystemConfirmByOKButton() {
		subclass.deleteSubclass("Water");
		assertEquals(subclass.getConfirmMessageText(),
				"This subclass cannot be deleted because resources already exist");
		// 'OK' - button
		subclass.clickOnOkButton();
		assertTrue(subclass.isSubclassPresent("Water"));
	}

	/*
	 * Verify that existing subclass cannot be deleted if resources already exist by
	 * clicking on 'Close' button on the 'Cannot delete subclass' confirmation
	 * message.
	 */
	@Test
	public void testCancelDelettingBySystemConfirmByCloseButton() {
		subclass.deleteSubclass("Water");
		assertEquals(subclass.getConfirmMessageText(),
				"This subclass cannot be deleted because resources already exist");
		// click on 'Close' - button on confirm message
		subclass.clickOnCloseButton();
		assertTrue(subclass.isSubclassPresent("Water"));
	}

}
