package home.JUnitTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import home.HTTPError;

public class HTTPErrorTest {

	@Test
	public void testSetValue() {
		HTTPError hTTPError = HTTPError.HTTP418;
		System.out.println();
		Assert.assertEquals("I'm a teapot", hTTPError.setValue(418));	
	}

	@Test
	public void testSetErrors1() {
		HTTPError hTTPError = HTTPError.HTTP418;
		System.out.println("I'm a teapot");
		Assert.assertEquals(418, hTTPError.setErrors());	
	}
	@Test
	public void testSetErrors2() {
		HTTPError hTTPError = HTTPError.HTTP418;
		System.out.println("I'm a teapot");
		Assert.assertEquals(404, hTTPError.setErrors());	
	}
	@Test
	public void testSetErrors3() {
		HTTPError hTTPError = HTTPError.HTTP0;
		System.out.println(666);
		Assert.assertEquals("No such error", hTTPError.toString());	
	}
}
