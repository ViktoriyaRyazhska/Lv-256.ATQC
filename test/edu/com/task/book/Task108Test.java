package edu.com.task.book;



import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.com.homework.tasksbook.Task108;



public class Task108Test {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	Task108 instance;
	
	@Before
	public  void setUpBefore()  {
		instance = new Task108();
		System.setOut(new PrintStream(outContent)); // setting outstream
	}

	
	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}	
	
	
	/**
	 * Tests getTheSmallestNumber method from Task108 class.
	 * Verifies that method works correct for natural number set in the parameter.
	 */
	@Test
	public void testNaturalNumbersParam() {
		
		Assert.assertEquals(2, instance.getTheSmallestNumber(1));
		Assert.assertEquals(16, instance.getTheSmallestNumber(10));
		
	}
	
	/**
	 * Tests getTheSmallestNumber method from Task108 class.
	 * Verifies that method works correct for not natural number set in the parameter.
	 */
	@Test
	public void testNotNaturalNumbersParam() {
		
		Assert.assertEquals(1, instance.getTheSmallestNumber(-5));
		Assert.assertEquals(1, instance.getTheSmallestNumber(0));
		
	}
	
	
	/**
	 * Tests method resolve from Task108 class.
	 * Verifies that after entering negative number,
	 * program prints "It is not natural number!" message into console.
	 */
	@Test
	public void TestNegativeNumberInputResolve() {

		ByteArrayInputStream in = new ByteArrayInputStream("-1".getBytes()); // setting
																				// input
																				// stream
		System.setIn(in);
		instance.resolve();

		Assert.assertTrue(outContent.toString().contains("It is not natural number!"));
		System.setIn(System.in);

	}
	
	/**
	 * Tests method resolve from Task108 class.
	 * Verifies that after entering valid number,
	 * program outputs valid result into console.
	 */
	@Test
	public void TestValidInputResolve() {

		ByteArrayInputStream in = new ByteArrayInputStream("10".getBytes()); // setting
																				// input
																				// stream
		System.setIn(in);
		instance.resolve();

		Assert.assertTrue(outContent.toString().contains("The smallest number is: 16"));
		System.setIn(System.in);

	}
	
	
	/**
	 * Tests method resolve from Task108 class.
	 * Verifies that after entering string into console,
	 * program prints "Please provide correct input" message into console.
	 */
	@Test
	public void TestInvalidInputResolve() {
		
		ByteArrayInputStream in = new ByteArrayInputStream("string".getBytes());	//setting input stream
		System.setIn(in);
		instance.resolve();
		Assert.assertTrue(outContent.toString().contains("Please provide correct input"));
		System.setIn(System.in);
		
	}
	

}
