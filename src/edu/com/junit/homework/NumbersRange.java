package edu.com.junit.homework;

import java.util.Scanner;

/**
 * The FloatNumbersRange program implements an application that read 3 float
 * numbers and check: they all belong to the range [-5,5];
 *
 * @version 1.0
 * @author Bohdan Zhyvko
 */
public class NumbersRange {

	/**
	 * Get float number and check if it belong to the range [-5.5]
	 * 
	 * @param num
	 *            is float number
	 * @return boolean
	 */
	public boolean isRange(float num) {
		if ((num >= -5) && (num <= 5)) {
			return true;
		}
		return false;
	}

	/**
	 * Read 3 float number from command-line input and return they
	 * 
	 * @return array of float numbers
	 */
	public float[] readFloatNumbers() {

		float[] floatNum = { 0, 0, 0 };
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter float number: ");
			try {
				// create a scanner for read the command-line input
				floatNum[i] = new Scanner(System.in).nextFloat();
			} catch (Exception e) {
				System.out.println("Please provide correct input");
				i--;
			}
		}
		return floatNum;
	}

	/**
	 * Get float numbers and check they are in the range
	 * @param floatNumArr 
	 */
	public void checkNumbersAreInTheRange(float[] floatNumArr) {
		// Initialize variable
		boolean bool = true;

		for (float n : floatNumArr) {
			// check is number belong to the range [-5,5]
			bool = bool && isRange(n);
			// print if number is not belong to the range [-5,5]
			if (!isRange(n)) {
				System.out.println(n + " isn`t belong to the range [-5,5];");
			}
		}
		// print if all numbers belong to the range [-5,5]
		if (bool) {
			System.out.println("All numbers are belong to the range [-5,5];");
		}

	}

	public static void main(String[] args) {
		System.out.println("Read 3 float numbers and check: they all belong to the range [-5,5];");
		NumbersRange numRange = new NumbersRange();
		// get 3 float numbers and check
		numRange.checkNumbersAreInTheRange(numRange.readFloatNumbers());
	}
}
