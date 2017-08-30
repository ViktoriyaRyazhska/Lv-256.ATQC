package edu.com.homework.tasksbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task330 {
	

	public List<Integer> perfectNumbers(int number) {
		List<Integer> perfectValues = new ArrayList<>();
		for (int i = 1; i < number; i++) {
			int sum = 0;
			for (int n = 1; n < i; n++) {
				if (i % n == 0)
					sum += n;
			}
			if (i == sum) {
				perfectValues.add(i);
			}
		}

		return perfectValues;

	}
	public void resolve() {
		System.out.println("This method calculates total som of digits in a number");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int methodName = scan.nextInt();
		System.out.println("Sum of digits : "+perfectNumbers(methodName));
	}

	

}
