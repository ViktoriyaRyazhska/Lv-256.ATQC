package com.softserve.edu;

public class Rectangle {

	int width;
	int height;

	public Rectangle(int weight, int heigh) {
		super();
		this.width = weight;
		this.height = heigh;
	}

	public int perimeter() {
		return 2 * (width + height);
	}

}
