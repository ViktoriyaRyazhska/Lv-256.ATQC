package edu.com.homework.tasksbook;
/**
 * TaskBook
 * Task 178w  
 * Дані натуральні числа n, a_1...a_n. Визначити кількість членів a_k  послідовності a_1...a_n, які є квадратами парних чисел.
 *
 * @author Khrystyna Terletska
 *
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task178w {

	public void resolve() {
		Task178w task178w = new Task178w();
		System.out.println("Determine the number of members of a sequence that are squares of even numbers");
		System.out.println("Please enter the numbers (When you type 'quit' word counting numbers to stop)");

		Scanner scan = new Scanner(System.in);
		Set<Integer> numbers = new HashSet<Integer>();

		boolean shouldStopReading = false;
		while (!shouldStopReading) {
			try {
				String text = scan.next();
				if (text.equals("quit")) {
					shouldStopReading = true;
				} else {
					int number = Integer.parseInt(text);
					numbers.add(number);
				}
			} catch (Exception e) {
				System.out.println("Incorrect input value");
			}
		}
	}

	public int getNaturalNumberCount(Set<Integer> numbers) {
		if (numbers == null || numbers.isEmpty()) {
			throw new IllegalArgumentException("You didn't entered value. Please enter digital value greater than 0");
		}

		int totalCount = 0;

		for (int n : numbers) {
			int value = n;

			if (Math.sqrt(value) % 2 == 0) {

				System.out.println("Value is - " + value);
				totalCount++;
			}
		}
		System.out.println("Total count " + totalCount);
		return totalCount;
	}
}
