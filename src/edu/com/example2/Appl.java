package edu.com.example2;

public class Appl {
	public static void main(String[] args) {
		One one = new One();
		one.setText("data");
		Two two = new Two(one);
		System.out.println(two.resume());
		// etc
	}
}
