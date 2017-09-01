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

import edu.com.homework.tasksbook.Task331a;
import edu.com.homework.tasksbook.task331.ThreeSquareNaturalNumbers;



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

	
	/**
	 * Tests method getThreeSquareNumbers from Task331a class.
	 * Verifies that after setting correct value in parameter,
	 * method returns correctly created object.
	 */
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
	
	
	/**
	 * Tests method resolve from Task331a class.
	 * Verifies that after entering negative number,
	 * program prints "It is not natural number!" message into console.
	 */
	@Test
	public void TestNegativeNumberInput() {
		
		ByteArrayInputStream in = new ByteArrayInputStream("-1".getBytes());	//setting input stream
		System.setIn(in);
		instance.resolve();
			
		Assert.assertTrue(outContent.toString().contains("It is not natural number!"));
		System.setIn(System.in);
	
	}
	
	
	/**
	 * Tests method resolve from Task331a class.
	 * Verifies that after entering number that can not be presented as a three squares,
	 * program prints "There aren't three squares for the entered natural number!" message into console.
	 */
	@Test
	public void TestBadNumberInput() {
		
		ByteArrayInputStream in = new ByteArrayInputStream("6".getBytes());	//setting input stream
		System.setIn(in);
		instance.resolve();
			
		Assert.assertTrue(outContent.toString().contains("There aren't three squares for the entered natural number!"));
		System.setIn(System.in);
	
	}
	

	/**
	 * Tests method resolve from Task331a class.
	 * Verifies that after entering string into console,
	 * program prints "Please provide correct input" message into console.
	 */
	@Test
	public void TestInvalidInput() {
		
		ByteArrayInputStream in = new ByteArrayInputStream("string".getBytes());	//setting input stream
		System.setIn(in);
		instance.resolve();
		Assert.assertTrue(outContent.toString().contains("Please provide correct input"));
		System.setIn(System.in);
		
	}
	
	
	/**
	 * Tests method resolve from Task331a class.
	 * Verifies that after entering a number which can be presented as a sum of three squared numbers,
	 * program prints that three numbers into console.
	 */
	@Test
	public void TestValidInputResolve() {
		
		ByteArrayInputStream in = new ByteArrayInputStream("17".getBytes());	//setting input stream
		System.setIn(in);
		instance.resolve();
		Assert.assertTrue(outContent.toString().contains("x = 2, y = 2, z = 3"));
		Assert.assertTrue(outContent.toString().contains("x = 2, y = 3, z = 2"));
		Assert.assertTrue(outContent.toString().contains("x = 3, y = 2, z = 2"));
		System.setIn(System.in);
		
	}


}
