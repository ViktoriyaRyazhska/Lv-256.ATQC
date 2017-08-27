package edu.com.test;
import org.testng.annotations.*;

public class TestNGTest2 {
	@Test(expectedExceptions = ArithmeticException.class)
	public void divisionWithException() {
		int i = 1 / 0;
	}
}
