package edu.com.example1;

import org.junit.Assert;
import org.junit.Test;

public class CalcAddTest {
	Calc calc = new Calc();

	@Test
	public void testEquals() {
		Assert.assertEquals(4, 2 + 2);
		Assert.assertTrue(0 == calc.add(-3, 3));
	}

	@Test
	public void testNotEquals() {
		Assert.assertFalse(5 == calc.add(1, 5));
		Assert.assertNotEquals(5, calc.add(2, 2));
	}
}