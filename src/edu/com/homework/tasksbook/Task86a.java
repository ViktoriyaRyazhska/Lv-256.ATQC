package edu.com.homework.tasksbook;

import java.util.Scanner;

public class Task86a {

	public Integer quantity(int number) {
		return Integer.toString(number).length();
	}
	
	public void resolve() {
		System.out.println("This method calculates quantity of digits in a number");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int methodName = scan.nextInt();
		System.out.println("This number contain "+quantity(methodName) + " digits");
	}

	

	

}
