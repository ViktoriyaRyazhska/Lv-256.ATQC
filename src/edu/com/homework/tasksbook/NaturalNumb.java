package edu.com.homework.tasksbook;

public class NaturalNumb {
	private Integer number;

	public NaturalNumb() {
	}

	public NaturalNumb(Integer number) {
		if (number > 0) {
			this.number = number;
		}
	}

	public Integer quantity() {
		return Integer.toString(this.number).length();
	}

	public Integer sumOfDigits() {
		Integer sum = 0;
		for (int i = 0; i < Integer.toString(this.number).length(); i++) {
			sum += Integer.parseInt(String.valueOf(Integer.toString(this.number).charAt(i)));
		}
		return sum;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		if (number > 0) {
			this.number = number;
		}
	}

}
