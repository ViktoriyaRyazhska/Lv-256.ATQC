package homework_classes;

import java.awt.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class IntNum {

	private Integer MaxNumber = null;
	private Integer MinNumber = null;
	Set<Integer> numberset;

	public IntNum() {
		numberset = new HashSet<Integer>();

	}

	public int getMax() {
		return MaxNumber;
	}

	public int getMin() {

		return MinNumber;
	}

	public void input(String s) {

		Integer temp = null;

		try {

			temp = Integer.parseInt(s);
			numberset.add(temp);

		} catch (Exception e) {
			System.out.println("Input error");
		}

		if (MinNumber == null) {
			MinNumber = temp;
		}

		if (MaxNumber == null) {
			MaxNumber = temp;
		}

	}

	public void findBoundary() {

		for (Integer i : numberset) {
			if (i <= MinNumber) {
				MinNumber = i;
			}

			if (i >= MaxNumber) {
				MaxNumber = i;
			}
		}

	}

	public String toString() {

		if (MaxNumber == null | MinNumber == null) {

			return "No numbers were input";
		}

		else {

			return "Max number is: " + MaxNumber + " Min number is: " + MinNumber;
		}
	}

	public static void main(String[] args) {

		IntNum i = new IntNum();

		for (int k = 0; k < 3; k++) {
			System.out.println("Enter number1: ");
			Scanner scanner = new Scanner(System.in);
			i.input(scanner.nextLine());
		}
		i.findBoundary();
		System.out.println(i);

	}

}