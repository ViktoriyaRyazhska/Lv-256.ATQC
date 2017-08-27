package homework_classes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;



public class FloatNumTest {

	
	@Test
	public void TestIsInRangeTrue(){
		
		FloatNum floatnum= new FloatNum();
		
		Assert.assertTrue(floatnum.isInRange(-5));
		Assert.assertTrue(floatnum.isInRange(0));
		Assert.assertTrue(floatnum.isInRange(5));
		
		
	}
	

	@Test
	public void TestIsInRangeFalse() {

		FloatNum floatnum = new FloatNum();

		Assert.assertFalse(floatnum.isInRange(-5.1f));
		Assert.assertFalse(floatnum.isInRange(5.1f));

	}
	


}
