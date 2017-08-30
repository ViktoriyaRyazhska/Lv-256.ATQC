

/**
 * TaskBook
 * Task 178b  
 * Дані натуральні числа n, a_1...a_n. Визначити кількість членів a_k  послідовності a_1...a_n кратних 3 і некратних 5.
 * 
 * @author Khrystyna Terletska
 *
 **/

import java.util.HashSet;
import java.util.Set;

public class Task178b {
	public void resolve() {
		// Створюємо Set і додаємо в нього числа
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

		checkNumber(numbers); // Викликаємо метод checkNumber і передаємо в нього Set з числами
	}

	public int checkNumber(Set<Integer> numbers) {

		int totalCount = 0; // Створюємо змінну totalCount, яка буде підраховувати кількість чисел, які
							// задовільняють умову

		for (int n : numbers) {
			int value = n; // Перебираємо всі елементи із множини і вибираємо елемент

			if ((value % 3 == 0) && !(value % 5 == 0)) {

				System.out.println("Value is - " + value);

				totalCount = totalCount + 1; // Збідбшуємо лічильник елементів, які задовільняють умову
			}

		}
		System.out.println("Total count " + totalCount);

		return totalCount;
	}
}
