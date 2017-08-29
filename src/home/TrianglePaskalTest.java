package home;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TrianglePaskalTest {

	@Test
    public void testSetNumberOfLines(){   
		TrianglePaskal trianglePaskal=new TrianglePaskal();
        int expected = 3;
        int actual= trianglePaskal.setNumberOfLines();
        Assert.assertEquals(expected, actual);
    }

}
