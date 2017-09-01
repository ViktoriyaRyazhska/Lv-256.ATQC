package edu.com.example3;

import org.junit.Assert;
import org.junit.Test;

import edu.com.example3.Square;

public class SquareTest {

	@Test
	public void testPerimeter() {
		Square square = new Square(2);
		double expected = 64; // Result ???
		double actual;
		actual = square.Perimeter(2); // Method with error
		Assert.assertTrue(expected == actual);
		// fail("Not yet implemented"); }

	}

	@Test
		public void testPerimeter2( ) {
		Square square = new Square(2);
		square.setSquare(new RectangleStub( ));
		double expected = 4;
		double actual;
		actual = square.Perimeter(2);
		Assert.assertEquals(expected, actual, .001);
		//fail("Not yet implemented");
		}

}
