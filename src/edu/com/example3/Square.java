package edu.com.example3;

public class Square {
	private IRectangle rectangle;

	public Square(double width) {
		rectangle = new Rectangle(width, width);
	}

	// For testing
	public void setSquare(IRectangle rectangle) {
		this.rectangle = rectangle;
	}

	public double Perimeter(int multiply) {
		double p = 1;
		for (int i = 0; i < multiply; i++) {
			p = p * rectangle.Perimeter();
		}
		return p;
	}
}
