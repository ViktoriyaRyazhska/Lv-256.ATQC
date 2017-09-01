package edu.com.booktasks;

import java.util.Scanner;

public class Calculate {
	public static void main(String[] args) {
		int n = 1;
		int k = 0;
		int m = readM();
		findK(n, k, m);
	}

	public static int findK(int n, int k, int m) {
		while ((n = n * 4) < m) {
			k++;
		}
		System.out.println("k =" + k);
		return k;
	}

	public static int readM() {
		System.out.println("Please input m: ");
		try (Scanner keyboard = new Scanner(System.in)) {
			Integer m = keyboard.nextInt();
			if (m <= 1) {
				throw new RuntimeException("m should be greater than 1!");
			}
			return m;
		}
	}

}
