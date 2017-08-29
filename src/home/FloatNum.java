package home;
import java.util.Arrays;
import java.util.Scanner;

public class FloatNum {
	private Float[] numbers = null;

	public FloatNum() {
		super();
	}

	public FloatNum(Float[] numbers) {
		this.numbers = numbers;
	}

	public Float[] getNumbers() {
		return numbers;
	}

	public void setNumbers() {
		try {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter 3 numbers: ");
		float number1 = scan.nextFloat();
		float number2 = scan.nextFloat();
		float number3 = scan.nextFloat();
		Float[] numbers = { number1, number2, number3 };
		this.numbers = numbers;
		} catch (Exception err) {
			System.out.println("Input error");
		}		
	}

	public Float[] checkBelongToRange() {
		for (int i = 0; i < this.numbers.length; i++) {
			if (this.numbers[i] >= -5 && this.numbers[i] <= 5) {
				System.out.println(" Float number " + numbers[i] + " belong to the range [-5,5]");
			} else {
				System.out.println(" Float number " + numbers[i] + " not belong to the range [-5,5]");
			}
		}
		return numbers;
	}
}
