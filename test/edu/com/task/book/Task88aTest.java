package edu.com.task.book;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.com.homework.tasksbook.Task88a;

public class Task88aTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	Task88a task = new Task88a();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent)); // setting outstream
		task = new Task88a();
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
	
	/**
	 * Tests method resolve from Task88a class.
	 * Verifies that after setting 'Integer.Max_Value - 1' number won't exceed integer range,
	 * method returns correct message.
	 */
	@Test
	public void TestIntegerMaxValue() {
		ByteArrayInputStream in = new ByteArrayInputStream("2147483647".getBytes()); // setting Integer.Max_Value - 1 in input stream 
		System.setIn(in);
		task.resolve();
		
		Assert.assertTrue(outContent.toString().contains("Number is too big"));
	}
	
	/**
	 * Tests method resolve from Task88a class.
	 * Verifies that after setting 'Integer.Min_Value' number won't exceed integer range,
	 * method returns correct message.
	 */
	@Test
	public void TestIntegerMinValue() {
		ByteArrayInputStream in = new ByteArrayInputStream("-2147483648".getBytes()); // setting Integer.Min_Value in input stream
		System.setIn(in);
		task.resolve();
		
		Assert.assertTrue(outContent.toString().contains("Number is too big"));
	}
	
	/**
	 * Tests method resolve from Task88a class.
	 * Verifies that after setting characters,
	 * method returns correct message.
	 */
	@Test
	public void TestInputInvalidValue() {
		ByteArrayInputStream in = new ByteArrayInputStream("test".getBytes()); // setting invalid value in input stream
		System.setIn(in);
		task.resolve();
		
		Assert.assertTrue(outContent.toString().contains("Input error"));
	}
	
	/**
	 * Tests method resolve from Task88a class.
	 * Verifies that after setting valid number 'n' 
	 * and number 3 is present in the n^2 for Integer n. ,
	 * method returns correct message.
	 */
	@Test
	public void TestHasNumberThree() {
		ByteArrayInputStream in = new ByteArrayInputStream("12312".getBytes()); // setting valid value in input stream
		System.setIn(in);
		task.resolve();
		
		Assert.assertTrue(outContent.toString().contains("Contains 3"));
	}
	
	/**
	 * Tests method resolve from Task88a class.
	 * Verifies that after setting valid number 'n'
	 * and number 3 is not present in the n^2 for Integer n. ,
	 * method returns correct message.
	 */
	@Test
	public void TestHasNotNumberThree() {
		ByteArrayInputStream in = new ByteArrayInputStream("99".getBytes()); // setting valid value but with negative result in input stream
		System.setIn(in);
		task.resolve();
		
		Assert.assertTrue(outContent.toString().contains("Doesn't contain 3"));
	}
}
