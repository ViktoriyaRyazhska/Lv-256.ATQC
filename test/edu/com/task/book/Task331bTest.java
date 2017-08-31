package edu.com.task.book;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.com.homework.tasksbook.Task331b;
import edu.com.homework.tasksbook.ThreeSquareNaturalNumbers;

public class Task331bTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	Task331b instance;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent)); // setting outstream
		instance = new Task331b();

	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}	
	
	
	/**
	 * Tests method getThreeSquareNumbers from Task331b class.
	 * Verifies that after setting correct value in parameter,
	 * method returns list with appropriate values.
	 */
	@Test
	public void TestValidInput() {

		List<ThreeSquareNaturalNumbers> actual = instance.getThreeSquareNumbers(17);

		List<ThreeSquareNaturalNumbers> expected = new ArrayList<>();
		ThreeSquareNaturalNumbers threenum = new ThreeSquareNaturalNumbers(2, 2, 3);
		expected.add(threenum);
		threenum = new ThreeSquareNaturalNumbers(2, 3, 2);
		expected.add(threenum);
		threenum = new ThreeSquareNaturalNumbers(3, 2, 2);
		expected.add(threenum);

		Assert.assertEquals(expected.toString(), actual.toString());

	}

	/**
	 * Tests method resolve from Task331b class.
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
	 * Tests method resolve from Task331b class.
	 * Verifies that after entering number that can not be presented as a three squares,
	 * program prints "There aren't three squares for the entered natural number!" message into console.
	 */
	@Test
	public void TestBadNumberInputResolve() {

		ByteArrayInputStream in = new ByteArrayInputStream("6".getBytes()); // setting
																			// input
																			// stream
		System.setIn(in);
		instance.resolve();

		Assert.assertTrue(outContent.toString().contains("There aren't three squares for the entered natural number!"));
		System.setIn(System.in);

	}
	
	/**
	 * Tests method resolve from Task331b class.
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
	
	/**
	 * Tests method resolve from Task331b class.
	 * Verifies that after entering a number which can be presented as a sum of three squared numbers
	 * program prints all possible variations of that three numbers.
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
