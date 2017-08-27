package homework_classes;

import java.util.Scanner;

public class FloatNum {

	boolean isInRange(float n) {
		if (n >= -5 && n <= 5) {
			return true;
		} else {
			return false;
		}

	}
	
	
	public static void main(String[] args) {
		
		FloatNum f = new FloatNum();
		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("Enter first number: ");
			f.isInRange(scanner.nextFloat());
		} catch (Exception e) {
			System.out.println("Input error");
		}
	}
}
