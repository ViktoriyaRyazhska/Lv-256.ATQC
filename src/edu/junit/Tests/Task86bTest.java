package edu.junit.Tests;

import org.junit.Test;
import org.testng.Assert;

public class Task86bTest {
	Task86b task86bTest = new Task86b();

	@Test
	public void checkSum() {
		int sum = task86bTest.sumOfDigits(123);
		Assert.assertEquals(sum, 6);

	}

	@Test
	public void checkSum1() {
		int sum = task86bTest.sumOfDigits(-123);
		Assert.assertNotEquals(sum, 4);

	}

	@Test
	public void checkMaxSum2() {
		int sum = task86bTest.sumOfDigits(2147483647);
		Assert.assertEquals(sum, 46);

	}

	@Test
	public void checkNumber0() {
		int sum = task86bTest.sumOfDigits(0);
		Assert.assertEquals(sum, 0);
}
	
}
