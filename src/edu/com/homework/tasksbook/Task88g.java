package edu.com.homework.tasksbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task88g {
	public String addOne(int n) {
		return "1" + n + "1";
	}

	public void resolve() {
		System.out.println("Adding 1 at begin and end of number");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter natural number:");
		int n = 0;
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.err.println("You can enter only numbers");
		} catch (IOException e) {
			System.err.println("IO Exception");
		}
		if (n >= 0) {
			System.out.println(addOne(n));
		} else {
			System.out.println("You can enter only natural number. Can not enter negative number");
		}
	}
}
