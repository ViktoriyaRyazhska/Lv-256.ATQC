package edu.com.unittasks;

import java.util.Scanner;

public class IntNumbers {
	public static void main(String[] args) {
		try (Scanner keyboard = new Scanner(System.in)) {
			readAndCompare(keyboard);
		}
	}

	public static Integer[] readAndCompare(Scanner keyboard) {
		System.out.println("Please input 3 integer numbers: ");
		Integer[] values = readNumbers(keyboard);
		Integer[] minAndMax = findMinAndMaxValues(values);
		System.out.println(String.format("Min value: %d ; max values %d", (Object[]) minAndMax));
		return minAndMax;
	}
	
	public static Integer[] readNumbers(Scanner keyboard) {
		Integer[] values = new Integer[3];
		for (int i = 0; i < 3; i++) {
			values[i] = keyboard.nextInt();
		}
		return values;
	}

	public static Integer[] findMinAndMaxValues(Integer[] values) {
		Integer[] results = new Integer[2];
		results[0] = Integer.MAX_VALUE;
		results[1] = Integer.MIN_VALUE;
		for (int i = 0; i < values.length; i++) {
			if (values[i] < results[0]) {
				results[0] = values[i];
			}
			if (values[i] > results[1]) {
				results[1] = values[i];
			}
		}
		return results;
	}
}
