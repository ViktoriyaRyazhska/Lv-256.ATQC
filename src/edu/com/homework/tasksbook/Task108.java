package edu.com.homework.tasksbook;
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
	 * Get a natural number n. Return the smallest number that corresponds to 2^r
	 * and exceeds n
	 * 
	 * @param naturalNum
	 *            Set natural number n
	 * @return the smallest number that corresponds to 2^r and exceeds n
	 */
	public int getTheSmallestNumber(int naturalNum) {
		int pow = 1; // initial 2^1

		while (pow <= naturalNum) {
			pow = pow * 2; // 2 ^ r
		}
		return pow;
	}

	/**
	 * This method outputs the smallest number that corresponds to 2^r and
	 *  exceeds N;
	 */
	public void resolve() {

		System.out.println("Given a natural number n. Get the smallest number that corresponds to 2^r and exceeds n");
		Scanner scanner = new Scanner(System.in);
		
		int nutN = 0;
		System.out.println("Enter natural number N: ");
		try {
			// create a scanner for read the command-line input
			nutN = scanner.nextInt();
			if (nutN < 0) {
				System.out.println("It is not natural number!");
			} else {
				
				System.out.println("The smallest number is: " + getTheSmallestNumber(nutN));
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Please provide correct input");
		}
	}
}
