package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinMax {
	public String maximum(int a, int b, int c) {
		if (a > b && a > c) {
			System.out.println("a  max number");
			return "a max number";
		} else if (b > a && b > c) {
			System.out.println("b  max number");
			return "b max number";
		} else if (c > a && c > b) {
			System.out.println("c  max number");
			return "c max number";
		}
		return "max number";
	}

	public String minimum(int a, int b, int c) {
		if (a < b && a < c) {
			System.out.println("a  min number");
			return "a min number";
		} else if (b < a && b < c) {
			System.out.println("b  min number");
			return "b min number";
		} else if (c < a && c < b) {
			System.out.println("c  min number");
			return "c min number";
		}
		return "min number";
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter a: ");
		int a = Integer.parseInt(br.readLine());

		System.out.println("Enter b: ");
		int b = Integer.parseInt(br.readLine());

		System.out.println("Enter c: ");
		int c = Integer.parseInt(br.readLine());

		MinMax number = new MinMax();
		number.maximum(a, b, c);
		number.minimum(a, b, c);
	}

}
