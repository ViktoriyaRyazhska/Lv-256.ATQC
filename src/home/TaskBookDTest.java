package home;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskBookDTest {

	@Test
	public void test—heckConditionPositive() {
		TaskBookD taskBookD = new TaskBookD();
		String expected = "The number doesn't satisfy condition";
		void actual = taskBookD.checkCondition(10);
	}
	
	@Test
	public void testFactorialPositive() {
		TaskBookD taskBookD = new TaskBookD();
		int expexted = 6;
		int actual = taskBookD.factorial(3);
	}
}
