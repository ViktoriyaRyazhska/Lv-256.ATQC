package edu.com.homework.tasksbook;

public class NaturalNumb {
	private Integer numberr;

	public NaturalNumb() {
	}

	public NaturalNumb(Integer number) {
		if (number > 0) {
			this.numberr = number;
		}
	}

	public Integer quantity() {
		return Integer.toString(this.numberr).length();
	}

	public Integer sumOfDigits() {
		Integer sum = 0;
		for (int i = 0; i < Integer.toString(this.numberr).length(); i++) {
			sum += Integer.parseInt(String.valueOf(Integer.toString(this.numberr).charAt(i)));
		}
		return sum;
	}

	public Integer getNumber() {
		return numberr;
	}

	public void setNumber(Integer number) {
		if (number > 0) {
			this.numberr = number;
		}
	}

}
