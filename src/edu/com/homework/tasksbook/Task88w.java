package edu.com.homework.tasksbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task88w {
	public String replaceFirstLast(int n) {
		String s1 = Integer.toString(n);
		StringBuilder sb = new StringBuilder(s1);
		char last = sb.charAt(sb.length() - 1);
		char first = sb.charAt(0);
		sb.setCharAt(0, last);
		sb.setCharAt(sb.length() - 1, first);
		return sb.toString();
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
		if (n >= 0) {
			System.out.println(replaceFirstLast(n));
		} else {
			System.out.println("You can enter only natural number. Can not enter negative number");
		}
	}
}