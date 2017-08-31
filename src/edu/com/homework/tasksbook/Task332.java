package edu.com.homework.tasksbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task332 {
	public String sumOfFourSquares(int n) {
		int x[] = new int[4];
		for (int i = 0; i < 4; i++) {
			x[i] = (int) (Math.floor(Math.sqrt(n)));
			n = n - x[i] * x[i];
		}
		String s = Arrays.toString(x);
		return "x = " + s;
	}

	public void resolve() {
		System.out.println("n = x1^2 + x2^2 + x3^2 + x4^2 ");
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
			System.out.println(sumOfFourSquares(n));
		} else {
			System.out.println("You can enter only natural number. Can not enter negative number");
		}
	}

}
