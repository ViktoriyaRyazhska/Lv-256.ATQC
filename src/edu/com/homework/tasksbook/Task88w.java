package edu.com.homework.tasksbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task88w {
	public String replaceFirstLast(int n) {
		String s1 = Integer.toString(n);
		String[] arr = s1.split("");

		String tmp = arr[0];
		arr[0] = arr[arr.length - 1];
		arr[arr.length - 1] = tmp;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		String s = Arrays.toString(arr);
		return s;
	}

	public void resolve() {
		System.out.println("Replace first and last digit of number");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter natural number:");
		int n = 0;
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.err.println("You can enter only integer numbers");
		} catch (IOException e) {
			System.err.println("IO Exception");
		}
		System.out.println(replaceFirstLast(n));
	}
}
