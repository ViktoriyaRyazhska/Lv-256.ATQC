package edu.com.task.book;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import edu.com.homework.tasksbook.Task108;
import edu.com.homework.tasksbook.Task332;

public class Task332Test {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	Task332 task = new Task332();
	
	
	@Before
	public  void setUpBefore()  {
		Task332 task = new Task332();
		System.setOut(new PrintStream(outContent)); // setting outstream
	}

	
	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}	
	


//	@Test
//	public void testNaturalNumbers() {
//		Task332 task = new Task332();
//		task=Task332.resolve(88);
//		String expected = "9, 2, 1, 1";
//		Assert.assertEquals(expected , task.resolve());
//		Assert.assertTrue(1, Task332.resolve());
//		Assert.assertEquals(16, Task332.resolve());}
		
	
  
	
//	  @Test(dataProvider = "dp")
//	  public void f(String n, String s) {
//		  Assert.assertEquals(s, Task332.resolve());
//	  }
	  
		@Test
		public void TestNumberInputResolve() {

			ByteArrayInputStream in = new ByteArrayInputStream("aaass".getBytes()); 
			System.setIn(in);
			task.resolve();

			Assert.assertTrue(outContent.toString().contains("You can enter only numbers"));
			System.setIn(System.in);
					}	  

//	  @DataProvider
//	  public Object[][] dp() {
//	    return new Object[][] {
//	      new Object[] { "9, 2, 1, 1", "88"}
//	    };
//	  }
//	  
}
