package edu.com.homework.tasksbook;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// дано натуральне число n, Знайдіть всі натуральні числа менші n і взаємно прості з ним.
public class Task323 {
	public void resolve() throws NumberFormatException, IOException {
		System.out.println("Task: We have natural number N, so find all natural numbers less than N which are simple");
		System.out.println();
		System.out.println("Please, input natural number from which you want to see simple numbers:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.print("Simple numbers are: "); 
		for (int i = 2; i < n; i++) {
			boolean a = true;
			int q = (int) Math.sqrt(i);
			for (int j = 2; j <= q; j++) {
				if ((i % j) == 0) {
					a = false;
					break;
				}
			}
			if (a) {
				System.out.print(i + ", ");
			}
		}
	}
}