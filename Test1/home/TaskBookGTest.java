package home;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskBookGTest {

	@Test
	public void testCheckCondition1() {
		TaskBookG taskBookG = new TaskBookG();
		int expexted = 6;
		int actual = taskBookG.factorial(3);		
	}
	
	@Test
	public void testCheckCondition2() {
		TaskBookG taskBookG = new TaskBookG();
		Integer[] expected = {1,46};
		string actual = taskBookG.checkCondition("try next one");
	}
}
