package home;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskBookGTest {

	@Test
	public void testCheckCondition1() {
		TaskBookG taskBookG = new TaskBookG();
		int expexted = 10;
		int actual = taskBookG.checkCondition(10);		
	}
	
	@Test
	public void testCheckCondition2() {
		TaskBookG taskBookG = new TaskBookG();
		int expected = 1;
		int actual = taskBookG.checkCondition(0);
	}
	
	@Test
	public void testCheckCondition3() {
		TaskBookG taskBookG = new TaskBookG();
		int expected = 7;
		int actual = taskBookG.checkCondition(0);
	}
}
