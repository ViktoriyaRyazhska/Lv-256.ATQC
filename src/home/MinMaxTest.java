package home;

import org.junit.Assert;
import org.junit.Test;


public class MinMaxTest {
    @SuppressWarnings("deprecation")
	@Test
    public void testSetNumbersPositive() throws Exception {   
    	MinMax minMax=new MinMax();
        Integer[] expected = {3,5,9};
        minMax.setNumbers();
        Integer[] actual= minMax.getNumbers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindMinPositive() {  
        Integer[] values = {3,5,9};
    	MinMax minMax=new MinMax(values);
    	int expected = 3;
    	int actual= minMax.findMin();
    	Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxPositive() {
    	Integer[] values = {3,5,9};
    	MinMax minMax=new MinMax(values);
    	int expected = 9;
    	int actual= minMax.findMax();
    	Assert.assertEquals(expected, actual);
    }

}