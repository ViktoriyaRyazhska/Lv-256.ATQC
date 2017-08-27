package homework_classes;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class IntNumTest {

	@Test
	public void TestInput(){
		
		IntNum intnum = new IntNum();
		
		intnum.input("3"); 
		
		Set<Integer> testset = new HashSet<Integer>();
		testset.add(3);
		
		
		Assert.assertEquals(testset, intnum.numberset);
	}
	
	@Test
	public void TestInputNotInteger() {
		
		IntNum intnum = new IntNum();
		intnum.input("s"); 
		
		Set<Integer> testset = new HashSet<Integer>();
		
		Assert.assertEquals(testset, intnum.numberset); //test that nothing is added
		
		
	}
	
	@Test
	public void TestFindBoundaryMin() {
		
		IntNum intnum = new IntNum();
		intnum.numberset.add(1);
		intnum.numberset.add(2);
		intnum.numberset.add(3);
		intnum.findBoundary();
		
		int expectedMin=1;
		
		Assert.assertEquals(expectedMin, intnum.getMin());
		
		
	}
	
	@Test
	public void TestFindBoundaryMax() {
		
		IntNum intnum = new IntNum();
		intnum.numberset.add(1);
		intnum.numberset.add(2);
		intnum.numberset.add(3);
		intnum.findBoundary();
		
		int expectedMax=3;
		
		Assert.assertEquals(expectedMax, intnum.getMin());
		
		
	}
	
	

}
