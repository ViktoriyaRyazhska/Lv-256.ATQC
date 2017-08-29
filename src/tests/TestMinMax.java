package tests;

import org.junit.Assert;
import org.junit.Test;

import homework.MinMax;

public class TestMinMax {
	MinMax m = new MinMax();

	@Test
	public void 
	testMaximum() {
		Assert.assertEquals("a max number", m.maximum(145, 6, 0));
		Assert.assertEquals("b max number", m.maximum(123, 456, 12));
		Assert.assertEquals("c max number", m.maximum(234, 123, 500));
	}
	@Test 
	public void testMaximumNeg() {
		Assert.assertNotEquals("a max number", m.maximum(6, 145, 0));
		Assert.assertNotEquals("b min number", m.maximum(6, 145, 0));
		Assert.assertNotEquals("c max number", m.maximum(6, 145, 0));
		
	}
	@Test
	public void testMinimum() {
		Assert.assertEquals("c min number", m.minimum(145, 6, 0));
		Assert.assertEquals("a min number", m.minimum(11, 456, 12));
		Assert.assertEquals("b min number", m.minimum(234, 123, 500));
	}
	public void testMinimumNeg() {
		Assert.assertNotEquals("c min number", m.minimum(145, 6, 10));
		Assert.assertNotEquals("a max number", m.minimum(11, 456, 12));
		Assert.assertEquals("b min number", m.minimum(234, 1123, 500));
	}
}
