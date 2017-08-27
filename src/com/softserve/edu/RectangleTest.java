package com.softserve.edu;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class RectangleTest {
	@Test
	public void Perimeter() {
		Rectangle rectangle = new Rectangle(2, 3);
		int expected = 10;
		int actual;
		actual = rectangle.perimeter();
		System.out.println(actual);
		AssertJUnit.assertEquals(expected, actual);
		// throw new RuntimeException("Test not implemented");
	}
}
