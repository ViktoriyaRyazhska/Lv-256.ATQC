package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task88V {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter natural number:");
		int n = 0;
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.err.println("You can enter only numbers");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO Exception");
			e.printStackTrace();
		}

		String s1 = Integer.toString(n);
		String[] arr = s1.split("");
		String tmp = arr[0];
		arr[0] = arr[arr.length - 1];
		arr[arr.length - 1] = tmp;

		for (String s2 : arr) {
			System.out.print(s2);
		}
	}

}
