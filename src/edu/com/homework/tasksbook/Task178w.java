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
import java.util.Set;

public class Task178w {
	public void resolve() {
		Set<Integer> numbers = new HashSet<Integer>();
		numbers.add(3);
		numbers.add(4);
		numbers.add(9);
		numbers.add(12);
		numbers.add(16);
		numbers.add(34);
		numbers.add(36);
		numbers.add(37);
		numbers.add(38);
		numbers.add(39);
		numbers.add(64);

		

		System.out.println(checkNumber2(numbers)); 

	}

	public int checkNumber2(Set<Integer> numbers) {

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
