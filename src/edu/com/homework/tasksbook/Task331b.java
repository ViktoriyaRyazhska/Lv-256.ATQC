package edu.com.homework.tasksbook;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.com.homework.tasksbook.task331.ThreeSquareNaturalNumbers;

/**
 * TaskBook
 * Task 331
 * Given a natural number n. If it can possible to represent a number as a sum of 3 squares of natural numbers.
 * If it possible then:
 * a) Specify a triple X, Y, Z for which n = x2 + y2 + z2.
 * b) Specify all triples X, Y, Z for which n = x2 + y2 + z2.
 * 
 * @author Bohdan Zhyvko
 *
 */
public class Task331b {
	/**
	 * Given a natural number n, and return all triple X, Y, Z for which n = x2 + y2 + z2.
	 * @param naturalNum
	 * @return Returns a list of objects 'ThreeSquareNaturalNumbers'
	 */
	public List<ThreeSquareNaturalNumbers> getThreeSquareNumbers(int naturalNum) {
		int sum = 0;
		List<ThreeSquareNaturalNumbers> squares = new ArrayList<>();
		int n = (int) Math.sqrt(naturalNum);
		
		for (int x = 1; x < n; x++) {
			for (int y = 1; y < n; y++) {
				for (int z = 1; z < n; z++) {
					sum = (x * x) + (y * y) + (z * z);
					if (naturalNum == sum) {
						squares.add( new ThreeSquareNaturalNumbers (x,y,z));
					}
				}
			}
		}
		return squares;
	}
	
	/**
	 * This method outputs all triples X, Y, Z for which n = x2 + y2 + z2.
	 */
	public void resolve() {
		System.out.println("Given a natural number n. "
				+ "If it can possible to represent a number as a sum of 3 squares of natural numbers. "
				+ "nIf it possible then:"
				+ "\n b) Specify all triples X, Y, Z for which n = x2 + y2 + z2.");
		
		Scanner scanner = new Scanner(System.in);
		ThreeSquareNaturalNumbers squareXYZ = new ThreeSquareNaturalNumbers();
		List<ThreeSquareNaturalNumbers> squares = new ArrayList<>();
		int nutN = 0;
		
		System.out.println("Enter natural number N: ");
		try {
			// create a scanner for read the command-line input
			nutN = scanner.nextInt();
			if (nutN < 0) {
				System.out.println("It is not natural number!");
			} else {
				squares = getThreeSquareNumbers(nutN);
				if(!squares.isEmpty()) {
	 				for(ThreeSquareNaturalNumbers squarXYZ : squares) {
	 					System.out.println(squarXYZ.toString());
	 				}
	 			} else {
	 				System.out.println("There aren't three squares for the entered natural number!");
	 			}
			}

		} catch (InputMismatchException e) { // catch inconsistency with the type of input value;
			System.out.println("Please provide correct input");
		}
	}
}