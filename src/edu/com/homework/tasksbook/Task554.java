package edu.com.homework.tasksbook;
 /**
 * TaskBook
 * Task 178w  
 * Дано натуральне число n. Отримати всі піфагорові трійки натуральних чисел, кожне з яких не перевищує n. Всі такі натуральні трійки чисел а, b, c, де а^2+b^2=c^2  a≤b≤c≤n
 *
 * @author Khrystyna Terletska
 *
 */


import java.util.Scanner;

public class Task554 {

		public void rezolve() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scan.nextInt();
		Task554 pythagoreanTriple = new Task554();
		pythagoreanTriple.checkPythagoreanTriple(number);
	}

	public void checkPythagoreanTriple(int n) {

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
