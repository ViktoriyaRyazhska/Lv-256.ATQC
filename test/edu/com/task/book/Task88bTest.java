package edu.com.task.book;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.com.homework.tasksbook.Task88a;

public class Task88bTest {
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

}
