package edu.com.junit.homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The MaxAndMinNumbers program implements an application that read 3 integer
 * numbers and and write max and min of them;
 *
 * @version 1.0
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
		Arrays.sort(numArr);
		return numArr[numArr.length - 1];
	}

	/**
	 * Get array of integer numbers and return min number
	 * 
	 * @param numArr
	 * @return min
	 */
	public int getMin(int[] numArr) {
		Arrays.sort(numArr);
		return numArr[0];
	}

	public static void main(String[] args) {
		MaxAndMinNumbers maxMinNumbers = new MaxAndMinNumbers();
		int[] numArr = maxMinNumbers.readIntegerNumbers();

		System.out.println("Max number in arrey: " + maxMinNumbers.getMax(numArr));
		System.out.println("Min number in arrey: " + maxMinNumbers.getMin(numArr));

	}

}
