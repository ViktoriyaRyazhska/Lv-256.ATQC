package edu.com.homework.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestCheckInt {
	private CheckInt checkInt= new CheckInt();
	

	@Test
	public void testFindMinAndMax() {
		List<Integer> integers = new ArrayList<>();
		integers.add(5);
		integers.add(26);
		integers.add(1);
		checkInt.setValues(integers);
		int actual = checkInt.findMin();
		int expectedTrue = 1;
		int expectedFalse = 5;
		assertTrue(expectedTrue==actual);
		assertTrue(expectedFalse!=actual);
	}

	@Test
	public void testFindMax() {
		List<Integer> integers = new ArrayList<>();
		integers.add(5);
		integers.add(26);
		integers.add(1);
		checkInt.setValues(integers);
		int actual = checkInt.findMax();
		int expectedTrue = 26;
		int expectedFalse = 5;
		assertTrue(expectedTrue==actual);
		assertTrue(expectedFalse!=actual);
	}

}
