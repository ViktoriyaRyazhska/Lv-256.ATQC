package edu.com.test;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGTest10 {
	@Test
	public void method1() {
		System.out.println("This is method 1");
		// Assert.assertTrue(1 ==2);
	}

	@Test(dependsOnMethods = { "method1" })
	public void method2() {
		System.out.println("This is method 2");
	}
}