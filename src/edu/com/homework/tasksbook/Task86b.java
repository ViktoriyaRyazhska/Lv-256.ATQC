package edu.com.homework.tasksbook;

import java.util.Scanner;

public class Task86b {
	public Integer sumOfDigits(int number) {
		Integer sum = 0;
		for (int i = 0; i < Integer.toString(number).length(); i++) {
			sum += Integer.parseInt(String.valueOf(Integer.toString(number).charAt(i)));
		}
		return sum;
	}
	public void resolve() {
		System.out.println("This method calculates total som of digits in a number");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int methodName = scan.nextInt();
		System.out.println("Sum of digits : "+sumOfDigits(methodName));
	}

}
