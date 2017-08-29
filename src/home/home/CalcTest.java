package home.home;

import org.testng.Assert;
import org.testng.annotations.Test;

import edu.com.example1.Calc;

public class CalcTest {
	Calc calc = new Calc();  
	
    @Test
    public void test1() {
    int actual = calc.div(10,2);
    int expected = 5;
    Assert.assertEquals(actual,expected);
  }
        @Test
        public void test2() {
        	double actual = calc.div((double)10,(double)2);
        	double expected = 5.5;
        	Assert.assertEquals(actual,expected, 3);
      }
}
