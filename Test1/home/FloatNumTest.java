package home;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class FloatNumTest {

	@Test
	public void testSetNumbersPositive() {
		FloatNum floatNum = new FloatNum();
		Float[] expected = {(float) 3,(float) 5,(float) 9};
        floatNum.setNumbers();        
        Float[] actual= floatNum.getNumbers();
        Assert.assertEquals(expected, actual);	
		
	}

	@Test
	public void testCheckBelongToRangePositive() {
		Float[] values = {(float) 3,(float) 5,(float) 9};
		FloatNum floatNum = new FloatNum(values);
    	float expected = 3;
    	Float[] actual= floatNum.checkBelongToRangePositive();
    	Assert.assertEquals(expected, actual);
	}

}
