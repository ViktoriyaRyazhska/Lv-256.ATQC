package edu.com.test;

import org.testng.annotations.*;

public class TestNGTest9 {
	@Test(dataProvider = "Data-Provider-Function")
	public void parameterIntTest(TestNGTest8 clzz) {
		System.out.println("Number is: " + clzz.getMsg());
		System.out.println("Number is: " + clzz.getNumber());
	}

	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() {
		TestNGTest8 obj = new TestNGTest8();
		obj.setMsg("Hello");
		obj.setNumber(123);
		return new Object[][] { { obj } };
	}
}
