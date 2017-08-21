package edu.com.example2;

import org.junit.Assert;
import org.junit.Test;

public class TwoTest {
	@Test
	public void TestResume() {
		One one = new One();
		one.setText("Integration Test");
		Two two = new Two(one);
		// TODO Initialize to an appropriate value
		String expected = "Integration Test_...";
		// Result ???
		String actual;
		actual = two.resume();
		Assert.assertEquals(expected, actual);
	}
}
