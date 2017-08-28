package edu.junit;

public class MinMaxNumber {
	public static void main(String[] array) {
		int[] listNumber = { 20, 30, 60 };

		MinMaxNumber minMaxNumber = new MinMaxNumber();
		minMaxNumber.getMaxNumber(listNumber);
		minMaxNumber.getMinNumber(listNumber);

	}

	public int getMaxNumber(int[] listNumber) {
		int MaxNumber = listNumber[0];
		for (int i = 0; i < listNumber.length; i++) {
			int number = listNumber[i];
			if (MaxNumber < number) {
				MaxNumber = listNumber[i];
			}
		}

		System.out.println("Максимальне число в масиві: " + MaxNumber);
		return MaxNumber;
	}

	public int getMinNumber(int[] listNumber) {
		int MinNumber = listNumber[0];
		for (int i = 0; i < listNumber.length; i++) {
			int number = listNumber[i];
			if (MinNumber > number) {
				MinNumber = listNumber[i];
			}
		}
		System.out.println("Мінімальне число в масиві: " + MinNumber);

		return MinNumber;
	}
}
