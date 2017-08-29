package home.JUnitTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import home.FloatNum;

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
	public void testCheckBelongToRange() {
		Float[] values = {(float) 3,(float) 5,(float) 9};
		FloatNum floatNum = new FloatNum(values);
    	String expected = "j";
    	Float[] actual= floatNum.checkBelongToRange();
    	Assert.assertFalse(false);
	}
	
	public void testCheckBelongToRange2() {
		Float[] values = {(float) 3,(float) 5,(float) 9};
		FloatNum floatNum = new FloatNum(values);
    	float expected = 3;
    	Float[] actual= floatNum.checkBelongToRange();
    	Assert.assertEquals(expected, actual);
	}
}
