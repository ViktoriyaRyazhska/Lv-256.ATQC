package edu.com.example2;

public class Two {
	private IOne one;
	// private One one;

//	public Two(One one) {
	public Two(IOne one) {
		this.one = one;
	}

	public String resume() {
		// Functionality
		return one.getText() + "_" + one.calc();
	}
	// Code
}