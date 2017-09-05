package edu.com.task.book;

import org.testng.annotations.Test;

import edu.com.homework.tasksbook.Task226;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class Task226Test {
	private Task226 task226 = new Task226();
  @Test(dataProvider = "CommonMultipleNProvider")
  public void testCommonMultiple(Integer numberN, Integer numberM , Integer[] commonMult) {
	  List<Integer> integ = new ArrayList<>();
	  for(Integer i:commonMult) {
		  integ.add(i);
	  }
	  
	  assertEquals(task226.commonMultiple(numberN, numberM), integ);
	  
  }


  @DataProvider(name = "CommonMultipleNProvider")
	public Object[][] commonMultipleNProvider() {
	  return new Object[][] { { 25, 10, new Integer[]{50,100,150,200} }, { 76, 12, new Integer[]{228, 456, 684} }, { 15, 26, new Integer[]{} } };
	}
}
