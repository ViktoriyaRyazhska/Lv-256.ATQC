package edu.com.homework.tasksbook;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TaskBook Task 108 Given a natural number n. Get the smallest number that
 * corresponds to 2^r and exceeds n
 * 
 * @author Bohdan Zhyvko
 *
 */
public class Task108 {
	/**
	 * Get a natural number n. Return the smallest number that corresponds to
	 * 2^r and exceeds n
	 * 
	 * @param naturalNum
	 *            Set natural number n
	 * @return the smallest number that corresponds to 2^r and exceeds n
	 * @throws If given number is bigger than (2^30)-1 value of integer - throws IllegalArgumentException
	 * It is made because we bring given number to the power of 2. We make sure that result number won't exceed integer range.
	 */
	public int getTheSmallestNumber(int naturalNum) throws IllegalArgumentException{
		int pow = 0; // initial
		//check exceed integer range
		if(naturalNum > (Math.pow(2, 30) - 1)) {
			throw new IllegalArgumentException("Number is too big");
			//check is it natural number
		} else if (naturalNum <= 0) {
			System.out.println("It is not natural number!");
		} else {
			// get 2 ^ r
			pow++;
			while (pow <= naturalNum) {
				pow = pow * 2; // 2 ^ r
			}
		}
		return pow;
	}

	/**
	 * This method outputs the smallest number that corresponds to 2^r and
	 * exceeds N;
	 */
	public void resolve() {

		System.out.println("Given a natural number n. Get the smallest number that corresponds to 2^r and exceeds n");
		Scanner scanner = new Scanner(System.in);

		int nutN = 0;
		System.out.println("Enter natural number N: ");
		try {
			// create a scanner for read the command-line input
			nutN = scanner.nextInt();
			System.out.println("The smallest number is: " + getTheSmallestNumber(nutN));

		} catch (InputMismatchException e) { // catch inconsistency with the type of input value;
			System.out.println("Please provide correct input");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
