package edu.com.task.book;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class Task108Test {
	Task108 instance;
	
	@Before
	public  void setUpBefore()  {
		instance = new Task108();
	}

	

	@Test
	public void testNaturalNumbers() {
		
		Assert.assertEquals(2, instance.getTheSmallestNumber(1));
		Assert.assertEquals(16, instance.getTheSmallestNumber(10));
		
	}
	
	@Test
	public void testNotNaturalNumbers() {
		
		Assert.assertEquals(1, instance.getTheSmallestNumber(-5));
		Assert.assertEquals(1, instance.getTheSmallestNumber(0));
		
	}
	

}
