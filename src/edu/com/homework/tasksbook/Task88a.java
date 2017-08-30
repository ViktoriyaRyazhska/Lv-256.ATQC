package edu.com.homework.tasksbook;
import java.util.Scanner;

import org.omg.CosNaming.NamingContextExtHolder;

/**
 * TaskBook
 * Task 88 a  
 * Check  if the number 3 is present in the n^2 for Integer n.
 * 
 * @author Petro Hlukhovets'kyi
 *
 */
public class Task88a {

	/** Method Check
	 * @param Any integer number.
	 * @return Returns true if number contains 3. Otherwise returns false.
	 * @throws If given number is bigger than square root of max value of integer - throws IllegalArgumentException
	 *It is made because we bring given number to the power of 2. We make sure that result number won't exceed integer range.
	 * 
	 */
	private boolean check(int n) {
		if (n > Math.sqrt(Integer.MAX_VALUE) || n < Integer.MIN_VALUE) {
			throw new IllegalArgumentException();
		}

		else {
			Integer n2 = (int) Math.pow(n, 2);
			while (n2 != 0) {
				if (n2 % 10 == 3) {
					return true;
				} else {
					n2 = n2 / 10;
				}
			}
			return false;
		}

	}

	/** Method resolve
	 * Provides input of numbers from the console.
	 * Triggers method Check and says if number 3 is included in n^2, where n is given number.
	 * 
	 */
	
	public void resolve() {
		System.out.println("This programm checks  if the number 3 is present in the n^2 for Integer n.");
		System.out.println("Enter number");
		Scanner scanner = new Scanner(System.in);

		try {
			if (check(scanner.nextInt())) {
				System.out.println("Contains 3");
			} else {
				System.out.println("Doesn't contain 3");
			}
		} catch (Exception e) {

			if (e instanceof IllegalArgumentException) {
				System.out.println("Number is not in range");
			}

			else {
				System.out.println("input error");
			}

		}

	}



}
