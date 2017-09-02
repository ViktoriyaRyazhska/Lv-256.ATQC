package BookTasks;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PythagoreanTriple {

	public static void main(String[] array) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Get all the Pythagorean triples of natural numbers than a^ 2 + b ^ 2 = c ^ 2 a≤b≤c≤n");
		System.out.println("Enter a number: ");

		try {
			int number = scan.nextInt();
			PythagoreanTriple pythagoreanTriple = new PythagoreanTriple();
			pythagoreanTriple.printPythagoreanTriple(number);

		} catch (InputMismatchException e) {
			System.out.println("Please provide correct input. The correct format of numbers does not contain letters");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void printPythagoreanTriple(int n) {

		if (n <= 0) {
			throw new IllegalArgumentException("Please enter number greater than 0");
		}

		for (int a = 1; a <= n; a++) {
			for (int b = a + 1; b <= n; b++) {
				for (int c = b + 1; c <= n; c++) {
					if (a <= b && b <= c) {
						if ((a * a + b * b) == c * c) {
							System.out.println("a = " + a + " " + "b = " + b + " " + " c= " + c);
						}
					}
				}
			}
		}
	}

}
