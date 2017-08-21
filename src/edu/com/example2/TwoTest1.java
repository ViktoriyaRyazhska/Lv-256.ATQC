package edu.com.example2;

import org.junit.Assert;
import org.junit.Test;

public class TwoTest1 {
	@Test
	public void TestResume() {
		IOne one = new StubOne();
		one.setText(" Unit Test ");
		Two two = new Two(one);
		// TODO Initialize to an appropriate value
//		String expected = " Unit Test_"; // Result !!!
		 String expected = "_0";
		String actual;
		actual = two.resume();
		Assert.assertEquals(expected, actual);
	}
}