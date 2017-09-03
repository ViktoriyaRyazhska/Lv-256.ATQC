package edu.com.booktasks;

import java.util.ArrayList;
import java.util.List;

public class Task243 {

	public static List<Pair> find(long n, boolean findSymmetricPairs) {
		List<Pair> pairs = new ArrayList<>();
		for (long x = 0; x < Long.MAX_VALUE; x++) {
			long tempX = x * x;
			if (tempX > n) {
				break;
			}
			long y = findSymmetricPairs ? 0 : x ;
			for (; y < Long.MAX_VALUE; y++) {
				long temp = tempX + y * y;
				if (temp == n) {
					pairs.add(new Pair(x, y));
				} else if (temp > n) {
					break;
				}
			}
		}
		return pairs;
	}

	public static void main(String[] args) {
		System.out.println("Task a:");
		System.out.println(find(10000l,true));
		System.out.println("Task b:");
		System.out.println(find(10000l,false));
	}
}
