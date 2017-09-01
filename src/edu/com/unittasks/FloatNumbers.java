package edu.com.unittasks;

import java.util.Scanner;

public class FloatNumbers {
	public static void main(String[] args) {
		try (Scanner keyboard = new Scanner(System.in)) {
			readAndCheck(keyboard);
		}
	}

	public static boolean readAndCheck(Scanner keyboard) {
		System.out.println("Please input 3 float numbers: ");
		Float[] values = readFloatNumbers(keyboard);
		boolean result = belongToRange(values, -5F, 5F);
		System.out.println(String.format("Are all numbers from range? - %s", result));
		return result;
	}

	public static Float[] readFloatNumbers(Scanner keyboard) {
		Float[] values = new Float[3];
		for (int i = 0; i < 3; i++) {
			values[i] = keyboard.nextFloat();
		}
		return values;
	}

	public static boolean belongToRange(Float[] values, Float min, Float max) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] < min || values[i] > max) {
				return false;
			}
		}
		return true;
	}
}
