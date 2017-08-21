package edu.com.example1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcDivTest {
	Calc calc = new Calc();

	@Test
	public void testAdd() {
		assertTrue(calc.add(1, 5) == 6);
	}

	@Test
	public void testDivPositive() {
		int actual = 4;
		int expected = calc.div(9, 2);
		assertEquals(actual, expected);
	}

	@Test(expected = Exception.class)
	public void testDivZero() {
		int actual = calc.div(23, 0);
	}
}