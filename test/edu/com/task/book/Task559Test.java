package edu.com.task.book;

import org.testng.annotations.Test;

import edu.com.homework.tasksbook.Task559;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class Task559Test {
	private Task559 task559 = new Task559();
	
  @Test(dataProvider = "PrimeProvider")
  public void testIsPrime(Integer prime,boolean prime_b, Integer noprime, boolean noprime_b) {
	  assertEquals(task559.isPrime(prime), prime_b);
	  assertEquals(task559.isPrime(noprime), noprime_b);
  }
  
  @Test(dataProvider="MersennePrimesProvider")
  public void testMersennePrimes(Integer numb,Integer[] primes) {
	  List<Integer> integ = new ArrayList<>();
	  for(Integer i : primes) {
		  integ.add(i);
	  }
	  assertEquals(task559.mersennePrimes(numb), integ);
	  
  }

  @DataProvider(name="PrimeProvider")
  public Object[][] primeProvider() {
    return new Object[][] {{3,true,4,false},{5,true,6,false},{7,true,8,false},{11,true,15,false}};
  }
  
  @DataProvider(name="MersennePrimesProvider")
  public Object[][] mersennePrimesProvider() {
    return new Object[][] {{35,new Integer[] {3,7,31}},{130,new Integer[] {3,7,31,127}},{10,new Integer[] {3,7}}};
  }
}
