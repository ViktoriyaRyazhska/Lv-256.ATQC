package edu.com.task.book;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import taskbook.Task88g;

public class Task88gTest {
  @Test
  public void f() {
  }
  Task88g task = new Task88g();
	 @Test(dataProvider = "numberStringTestProvider")
	 public void testAddOneToNumberR(String iner, String n) {
	  Assert.assertEquals(n, task.addOne(iner));
	 }

		@Test
		public void testAddOneToNumber() {
			Task88g task88g = new Task88g();
			int expexted = 1101;
			String actual = task88g.addOne("10");		
		}
		
//		@Test( expectedExceptions = NumberFormatException.class)
//		public void testAddOneToSomething() {
//			Task88g task88g = new Task88g();
//			String actual = task88g.resolve("f");		
//		}
		
//	 @Test(dataProvider = "somethingStringTestProvider")
//	 public void testAddOneToSomthing1(int Task88gTest,  int n) throws Exception{
//	  Assert.assertEquals(n, Task88g.addOne(Task88gTest));
//	 }
	 
	 @DataProvider(name = "numberStringTestProvider")
	 public String[][] numberStringTestProvider() {
	  return new String[][] {
		  {"10","1101"},
		  {"56","1561"},{"000","10001"}};
	 }
	 @DataProvider(name = "somethingStringTestProvider")
	 public Object[][] somethingStringTestProvider() {
	  return new Object[][] {
		  { "a", "You can enter only numbers" }};
	 }
	 
}
