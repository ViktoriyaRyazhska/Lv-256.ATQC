package edu.com.homework.tasksbook;
import java.util.Scanner;
/**
 * TaskBook
 * Task 88 b  
 * Reverse order of digits of integer number.
 * 
 * @author Petro Hlukhovets'kyi
 *
 */
public class Task88b {
	
	/** Method reverser
	 * @param Any integer number.
	 * @return Returns given number with the reversed order of digits.
	 * Method checks if reversed number doesn't exceed max size of Integer.
	 * @throws If reversed number is bigger that max size of integer method throws IllegalArgumentException
	 * 
	 */
	private Integer reverser(int n) {

		long result = 0;
		long number = n;

		while (number != 0) {
			result = result * 10 + number % 10;
			number = number / 10;
		}

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			throw new IllegalArgumentException();
		}
		return (int) result;

	}

	/** Method resolve
	 * Provides input of numbers from the console.
	 * Triggers method reverser and outputs the reversed number
	 * 
	 */
	public void resolve() {

		System.out.println("Enter integer");
		Scanner scanner = new Scanner(System.in);
		try {

			System.out.println("Reversed integer is: " + reverser(scanner.nextInt()));

		} catch (Exception e) {

			if (e instanceof IllegalArgumentException) {
				System.out.println("Result number is not in Int range");
			}

			else {
				System.out.println("input error");
			}
		}

	}

}
