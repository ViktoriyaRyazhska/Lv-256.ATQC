package taskbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Task332Test {
	
	@Test
	public void testNaturalNumbers() {
		Task332Test task=Task332Test.resolve();
		String expected = "x = 9 y = 2 z = 1 t = 1";
		Assert.assertEquals(expected , task.toString());
//		Assert.assertTrue(1, Task332.resolve());
//		Assert.assertEquals(16, Task332.resolve());
		
	}
}
