package edu.junit;

public class FloatRange {
	public static void main(String[] array) {
		float a = 4.3f;
		float b = 3.2f;
		float c = -1.9f;

		FloatRange floatRange = new FloatRange();

		floatRange.isInRange(a);
		floatRange.isInRange(b);
		floatRange.isInRange(c);
	}

	public boolean isInRange(float value) {
		if (value <= 5 && value >= -5) {
			System.out.println("Value " + value + " is in range");
			return true;
		} else {
			System.out.println("Value " + value + " isn't in range");
			return false;
		}
	}

}
