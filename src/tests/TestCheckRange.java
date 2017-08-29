package tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import homework.CheckRange;

public class TestCheckRange {
    CheckRange check = new CheckRange();
     @Test
     public void testCheckA() {
    	 Assert.assertEquals("a belong to the range",check.CheckA(5));
    	 Assert.assertEquals("a don't belong to the range",check.CheckA(27));
     }
     @Test
     public void testCheckANegative() {
    	 Assert.assertNotEquals("a don't belong to the rang",check.CheckA(37));
     }
     @Test
     public void testCheckB() {
    	 Assert.assertEquals("b belong to the range",check.CheckB(5));
    	 Assert.assertEquals("b don't belong to the range",check.CheckB(27));
     }
     @Test
     public void testCheckBNegative() {
    	 Assert.assertNotEquals("dfgdfg",check.CheckA(37));
     }
     @Test
     public void testCheckC() {
    	 Assert.assertEquals("c belong to the range",check.CheckC(5));
    	 Assert.assertEquals("c don't belong to the range",check.CheckC(27));
     }
     @Test
     public void testCheckCNegative() {
    	 Assert.assertNotEquals("karpaty lviv",check.CheckC(37));
     }
     @Test
     public void testCheckAll() throws NumberFormatException, IOException {
    	Assert.assertEquals("all numbers belong to the range", check.CheckAll(1, 0, 0));
    	Assert.assertEquals("all numbers don't belong to the range",check.CheckAll(-50, 201, 45));
     }
     
    
}
