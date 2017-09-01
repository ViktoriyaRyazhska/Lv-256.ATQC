package taskbook;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task332Test {

	Task332 instance;
	
	@Before
	public  void setUpBefore()  {
		instance = new Task332();
	}
	@Test
	public void testNaturalNumbers() {
		
		Assert.assertEquals(1, instance.sumOfFourSquares(1));
		Assert.assertEquals(16, instance.sumOfFourSquares(10));
		
	}
}
