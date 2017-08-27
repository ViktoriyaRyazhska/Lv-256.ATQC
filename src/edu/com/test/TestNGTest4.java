package edu.com.test;

import org.testng.annotations.*;

public class TestNGTest4 {
	@Test(timeOut = 1000)
	public void infinity() {
		while (true);
	}
}