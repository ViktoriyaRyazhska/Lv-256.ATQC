package edu.junit.Tests;

import java.util.List;

import org.junit.Test;
import org.testng.Assert;

public class Task330Test {
	Task330 task330Test = new Task330();

	@Test
	public void checkPerfectNumber() {
		List<Integer> list = task330Test.perfectNumbers(0);
		Assert.assertEquals(list.isEmpty(), true);

	}

	@Test
	public void checkPerfectNumber1() {
		List<Integer> list = task330Test.perfectNumbers(-100);
		Assert.assertEquals(list.isEmpty(), true);

	}

	@Test
	public void checkPerfectNumber2() {
		List<Integer> list = task330Test.perfectNumbers(10);
		Assert.assertNotEquals(list.isEmpty(), true);

		int listSize = list.size();
		Assert.assertEquals(listSize, 1);

		int actual = list.get(0);
		Assert.assertEquals(actual, 6);
	}

	@Test
	public void checkPerfectNumber3() {
		List<Integer> list = task330Test.perfectNumbers(100);

		int listSize = list.size();
		Assert.assertEquals(listSize, 2);

		int actual = list.get(0);
		Assert.assertEquals(actual, 6);
		
		int act = list.get(1);
		Assert.assertEquals(act, 28);
		

	}
}
