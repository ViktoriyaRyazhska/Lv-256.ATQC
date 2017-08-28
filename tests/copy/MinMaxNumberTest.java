package edu.junit.tests.copy;

import org.junit.Assert;
import org.junit.Test;

import edu.junit.MinMaxNumber;

public class MinMaxNumberTest {
	MinMaxNumber minMaxNumber = new MinMaxNumber();

	@Test
	public void MaxNumber1() {
		int[] numberList = { 12, 15, 18 };
		int MaxNumber = minMaxNumber.getMaxNumber(numberList);
		Assert.assertEquals(18, MaxNumber);
	}

	@Test
	public void MaxNumber2() {
		int[] numberList = { 12, 15, 18 };
		int MaxNumber = minMaxNumber.getMaxNumber(numberList);
		Assert.assertNotEquals(12, MaxNumber);
	}

	@Test
	public void MaxNumber3() {
		int[] numberList = { 12, 15, 18 };
		int MaxNumber = minMaxNumber.getMaxNumber(numberList);
		Assert.assertNotEquals(15, MaxNumber);
	}

	@Test
	public void MinNumber1() {
		int[] numberList = { 12, 15, 18 };
		int MinNumber = minMaxNumber.getMinNumber(numberList);
		Assert.assertEquals(12, MinNumber);
	}

	@Test
	public void MinNumber2() {
		int[] numberList = { 12, 15, 18 };
		int MinNumber = minMaxNumber.getMinNumber(numberList);
		Assert.assertNotEquals(18, MinNumber);
	}

}
