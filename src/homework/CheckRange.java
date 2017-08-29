package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckRange {

	public String CheckA(float a) {
		if (a >= -5 && a <= 5) {
			System.out.println("a belong to the range");
			return "a belong to the range";
		} else
			System.out.println("a don't belong to the range");
		return "a don't belong to the range";
	}

	public String CheckB(float b) {
		if (b >= -5 && b <= 5) {
			System.out.println("b belong to the range");
			return "b belong to the range";
		} else
			System.out.println("b don't belong to the range");
		return "b don't belong to the range";
	}

	public String CheckC(float c) {
		if (c >= -5 && c <= 5) {
			System.out.println("c belong to the range");
			return "c belong to the range";
		} else
			System.out.println("c don't belong to the range");
		return "c don't belong to the range";
	}

	public String CheckAll(float a, float b, float c) throws NumberFormatException, IOException {
		if (a >= -5 && a <= 5 && b >= -5 && b <= 5 && c >= -5 && c <= 5) {
			return "all numbers belong to the range";
		} else {
			return "all numbers don't belong to the range";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a: ");
		float a = Float.parseFloat(br.readLine());
		System.out.println("Enter b: ");
		float b = Float.parseFloat(br.readLine());
		System.out.println("Enter c: ");
		float c = Float.parseFloat(br.readLine());
		CheckRange ch = new CheckRange();
		ch.CheckA(a);
		ch.CheckB(b);
		ch.CheckC(c);
		ch.CheckAll(a, b, c);
	}
}