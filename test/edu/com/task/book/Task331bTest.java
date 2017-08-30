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

	@Test
	public void TestNegativeNumberInput() {

		ByteArrayInputStream in = new ByteArrayInputStream("-1".getBytes()); // setting
																				// input
																				// stream
		System.setIn(in);
		instance.resolve();

		Assert.assertTrue(outContent.toString().contains("It is not natural number!"));
		System.setIn(System.in);

	}

	@Test
	public void TestBadNumberInput() {

		ByteArrayInputStream in = new ByteArrayInputStream("6".getBytes()); // setting
																			// input
																			// stream
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
