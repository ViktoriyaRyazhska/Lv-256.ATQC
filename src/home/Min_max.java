package home;
//import java.util.Arrays;
import java.util.Scanner;

public class Min_max {
	private Integer[] numbers = null;

	public Integer[] getNumbers() {
		return numbers;
	}

	public void setNumbers() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter 3 int numbers: ");
		int number1 = scan.nextInt();
		int number2 = scan.nextInt();
		int number3 = scan.nextInt();
		Integer[] numbers = { number1, number2, number3 };
		this.numbers = numbers;
	}

	public void findMin() {
		int minValue = numbers[0];
		for (int i = 0; i < this.numbers.length; i++) {
			if (numbers[i] < minValue) {
				minValue = numbers[i];
			}
		}
		System.out.println("The min of three is: " + minValue);		
	}
	
	public void findMax() {
		int maxValue = numbers[0];
		for (int i = 0; i > this.numbers.length; i++) {
			if (numbers[i] > maxValue) {
				maxValue = numbers[i];
			}
		}
		System.out.println("The min of three is: " + maxValue);		
	}

	/*public static void main(String[] args) {

		Arrays.sort(numbers);
		int maxValue = numbers[numbers.length - 1];
		int minValue = numbers[0];

		System.out.println("The min of three is: " + minValue);
		System.out.println("The max of three is: " + maxValue);
	}*/
}