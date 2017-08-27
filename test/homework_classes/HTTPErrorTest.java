package homework_classes;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class HTTPErrorTest {

	
	

	
	@Test
	public void TestInput() {
		
		HTTPError http = HTTPError.HTTPnone;
		//input number 5
		System.out.println("*Input number 5*");
		Assert.assertEquals(5, http.input());
	
	}
	
	@Test
	public void TestInvalidInput() {
		HTTPError http = HTTPError.HTTPnone;
		//input not number
		System.out.println("*Input not number*");
		Assert.assertEquals(0, http.input());
	}
	
	@Test
	public void TestSetValue() {
		HTTPError http = HTTPError.HTTPnone;
		http=http.setValue(404);
		
		Assert.assertEquals("Error 404 Not Found", http.toString());
		
	}
	
	@Test
	public void TestSetValueNotInRange() {
		HTTPError http = HTTPError.HTTPnone;
		http.setValue(489);
		
		Assert.assertEquals("No such error in db", http.toString());
		
	}

}
