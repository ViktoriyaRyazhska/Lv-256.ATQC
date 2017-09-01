package edu.com.homework.tasksbook;

import java.util.Scanner;

/*дано натуральне число n, та цілі числа an.....аn2. Знайти кількість і суму тих членів даної послідовності
 * які діляться на 5 і не діляться на 7*/
public class Task182 {
	public void resolve() {
		System.out.println("Task: We have one N number of integer numbers");
		System.out.println(
				"so we need to find their sum and amount if they can be devided by 5 and can't be devided by 7");
		System.out.println();
		System.out.println("How much integer numbers you want to enter(n)?");
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		if (size == 0) {
			System.out.print("Program has been finished as number with zero value was entered");
		}
		Integer[] sourceNumbers = new Integer[size];
		System.out.print("Enter integer numbers dividing them with free space " + "end then press <Enter>: ");
		for (int i = 0; i < size; i++) {
			sourceNumbers[i] = in.nextInt();
		}
		findNumbers(5, sourceNumbers, 7);
	}

	static int count = 0;
	static int sum = 0;

	private static void findNumbers(int divider, Integer[] sourceNumbers, int divider3) {
		System.out.print("Numbers that can be divided by " + divider + " and cannot be devided by " + divider3 + ": ");
		for (Integer sourceNumber : sourceNumbers) {
			if (sourceNumber % divider == 0 & sourceNumber % divider3 != 0) {
				count++;
				System.out.print(sourceNumber + ", ");

			}

			if (sourceNumber % divider == 0 & sourceNumber % divider3 != 0) {
				sum = sum + sourceNumber;
			}
		}
		System.out.println();
		System.out.println("So amount of such a numbers is: " + count);
		System.out.println("And sum of such a numbers is: " + sum);
	}
}