package edu.junit.tests;

import org.junit.Assert;
import org.junit.Test;

import edu.junit.FloatRange;

public class FloatRangeTest {
	FloatRange floatRange = new FloatRange();

	@Test
	public void floatRangePositive() {
		boolean actual = floatRange.isInRange(4.3f);
		Assert.assertEquals(actual, true);
	}

	@Test
	public void floatRange() {
		boolean actual = floatRange.isInRange(4.3f);
		Assert.assertNotEquals(actual, false);
	}

	@Test
	public void floatgeInvalid() {
		boolean actual = floatRange.isInRange(-6.1f);
		Assert.assertNotEquals(actual, true);
	}

	@Test
	public void floatRangeInvalid() {
		boolean actual = floatRange.isInRange(6.1f);
		Assert.assertNotEquals(actual, true);
	}

}
