package edu.com.homework.tasksbook;

/**
 * TaskBook
 * Task 178b  
 * Дані натуральні числа n, a_1...a_n. Визначити кількість членів a_k  послідовності a_1...a_n кратних 3 і некратних 5.
 * 
 * @author Khrystyna Terletska
 *
 **/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task178b {
	public void resolve() {
		Task178b task = new Task178b();
		System.out.println("Determine the number of sequence members that are multiples of 3 and not multiple 5");
		System.out.println("Please enter the numbers (When you type 'quit' word counting numbers to stop)");

		Scanner scan = new Scanner(System.in);
		Set<Integer> numbers = new HashSet<Integer>();

		// вводимо змінну для того щоб знати чи ще зчитувати дані з консолі чи вже ні
		boolean shouldStopReading = false;
		// поки не зупинено читання то пробуємо
		while (!shouldStopReading) {
			try {
				// читаємо введений текст
				String text = scan.next();
				// перевіряємо чи той текст рівний слову quit
				if (text.equals("quit")) {
					shouldStopReading = true; // ставимо значення змінної в тру щоб зупитини зчитування, бо в нас цикл
												// поки це значення false то він біжить постійно
				} else {
					// переводимо введений текст в ціле значення
					int number = Integer.parseInt(text);
					// додаємо зчитане переведене число в колекцію
					numbers.add(number);
				}
			} catch (Exception e) {
				System.out.println("Incorrect input value");
			}
		}

		int result = task.getNaturalNumberCount(numbers);
	}

	public int getNaturalNumberCount(Set<Integer> numbers) {
		if (numbers == null || numbers.isEmpty()) {
			throw new IllegalArgumentException("You didn't entered value. Please enter digital value greater than 0");
		}
		int totalCount = 0; // Створюємо змінну totalCount, яка буде підраховувати кількість чисел, які
		// задовільняють умову

		for (int n : numbers) {
			int value = n; // Перебираємо всі елементи із множини і вибираємо елемент

			if ((value % 3 == 0) && !(value % 5 == 0)) {

				System.out.println("Value is - " + value);

				totalCount = totalCount + 1; // Збільшуємо лічильник елементів, які задовільняють умову
			}

		}
		System.out.println("Total count " + totalCount);

		return totalCount;
	}
}
