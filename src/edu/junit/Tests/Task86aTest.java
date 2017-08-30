package edu.junit.Tests;

import org.junit.Test;
import org.testng.Assert;

public class Task86aTest {
	Task86a task86aTest = new Task86a();

	@Test
	public void checkLenght() {
		int value = task86aTest.quantity(100);
		Assert.assertEquals(value, 3);
	}
	
	@Test
	public void checkLenght1() {
		int value = task86aTest.quantity(100);
		Assert.assertNotEquals(value, 4);
	}
	@Test
	public void checkLenght2() {
		int value = task86aTest.quantity(-3);
		Assert.assertEquals(value, 2);
	}

}
