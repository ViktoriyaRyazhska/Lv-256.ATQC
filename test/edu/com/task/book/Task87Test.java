package edu.com.task.book;

import org.testng.annotations.Test;

import edu.com.homework.tasksbook.Task87;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class Task87Test {
	private Task87 task87 = new Task87();

	@Test(dataProvider = "NaturalNumberProvider")
	public void testCheckIfNumberNatural(Integer n) {
		assertTrue(n == task87.checkIfNumberNatural());
	}
	@Test(dataProvider="SumOfLastDigitsInNumberNProvider")
	public void testSumOfLastDigitsInNumberN(Integer numberOfLastDigits, Integer number, Integer sum) {
		System.out.println(task87.sumOfLastDigitsInNumberN(numberOfLastDigits, number));
		assertTrue(task87.sumOfLastDigitsInNumberN(numberOfLastDigits, number)==sum );
	}

	@DataProvider(name = "NaturalNumberProvider")
	public Integer[] naturalNumberProvider() {
		return new Integer[] { 123, 1234, 12345, 123456 };
	}

	@DataProvider(name = "SumOfLastDigitsInNumberNProvider")
	public Integer[][] sumOfLastDigitsInNumberNProvider() {
		return new Integer[][] { { 2, 123, 5 }, { 3, 1234, 9 }, { 4, 12345, 14 } };
	}
}
