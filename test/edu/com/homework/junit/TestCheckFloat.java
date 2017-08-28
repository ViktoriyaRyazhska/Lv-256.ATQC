package edu.com.homework.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCheckFloat {
	public CheckFloat checkFloat = new CheckFloat();

	@Test
	public void testIsInRange() {
		assertTrue(checkFloat.isInRange(-4));
		assertTrue(checkFloat.isInRange(5));
		assertTrue(checkFloat.isInRange(0));
		
		assertTrue(!checkFloat.isInRange(-5.1f));
		assertTrue(!checkFloat.isInRange(5.25f));
		assertTrue(!checkFloat.isInRange(6));
	}

}
