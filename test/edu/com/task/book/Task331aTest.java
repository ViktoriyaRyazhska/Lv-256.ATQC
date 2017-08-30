package edu.com.task.book;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.InputMismatchException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class Task331aTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	Task331a instance;
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent)); //setting outstream
	    instance = new Task331a();						
	    
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void TestValidInput() {
		
		ThreeSquareNaturalNumbers threenum = instance.getThreeSquareNumbers(12);
		String expected = "x = 2, y = 2, z = 2";
		Assert.assertEquals(expected , threenum.toString());
		
		threenum = instance.getThreeSquareNumbers(48);
		expected = "x = 4, y = 4, z = 4";
		Assert.assertEquals(expected , threenum.toString());
		
		threenum = instance.getThreeSquareNumbers(3000);
		expected = "x = 4, y = 22, z = 50";
		Assert.assertEquals(expected , threenum.toString());
		
	}
	
	@Test
	public void TestNegativeNumberInput() {
		
		ByteArrayInputStream in = new ByteArrayInputStream("-1".getBytes());	//setting input stream
		System.setIn(in);
		instance.resolve();
			
		Assert.assertTrue(outContent.toString().contains("It is not natural number!"));
		System.setIn(System.in);
	
	}
	
	
	
	@Test
	public void TestBadNumberInput() {
		
		ByteArrayInputStream in = new ByteArrayInputStream("6".getBytes());	//setting input stream
		System.setIn(in);
		instance.resolve();
			
		Assert.assertTrue(outContent.toString().contains("There aren't three squares for the entered natural number!"));
		System.setIn(System.in);
	
	}
	

	
	@Test(expected=InputMismatchException.class)
	public void TestInvalidInput() {
		
		ByteArrayInputStream in = new ByteArrayInputStream("asd".getBytes());	//setting input stream
		System.setIn(in);
		instance.resolve();
		
	}

}
