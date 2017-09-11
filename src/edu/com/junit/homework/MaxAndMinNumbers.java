package edu.com.junit.homework;

import java.util.Scanner;

/**
 * The MaxAndMinNumbers program implements an application that read 3 integer
 * numbers and and write max and min of them;
 *
 * @author Bohdan Zhyvko
 */
public class MaxAndMinNumbers {

	/**
	 * Read 3 integer number from command-line input and return that
	 * 
	 * @return array of integer numbers
	 */
	public int[] readIntegerNumbers() {
		System.out.println("Enter 3 integer numbers ");
		int[] intNum = { 0, 0, 0 };
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter integer number: ");
			try {
				// create a scanner for read the command-line input
				intNum[i] = new Scanner(System.in).nextInt();
			} catch (Exception e) {
				System.out.println("Please provide correct input");
				// rewrite number
				i--;
			}
		}
		return intNum;
	}

	/**
	 * Get array of integer numbers and return max number
	 * 
	 * @param numArr
	 * @return max
	 */
	public int getMax(int[] numArr) {
		int max = numArr[0];
		for (int i = 1; i < numArr.length; i++) {
			if (numArr[i] > max) {
				max = numArr[i];
			}
		}
		return max;
	}

	/**
	 * Get array of integer numbers and return min number
	 * 
	 * @param numArr
	 * @return min
	 */
	public int getMin(int[] numArr) {
		int min = numArr[0];
		for (int i = 1; i < numArr.length; i++) {
			if (numArr[i] < min) {
				min = numArr[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		MaxAndMinNumbers maxMinNumbers = new MaxAndMinNumbers();
		int[] numArr = maxMinNumbers.readIntegerNumbers();

		System.out.println("Max number in arrey: " + maxMinNumbers.getMax(numArr));
		System.out.println("Min number in arrey: " + maxMinNumbers.getMin(numArr));

	}

}
