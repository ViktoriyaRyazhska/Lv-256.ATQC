package edu.com.homework.tasksbook;

import java.util.Objects;

/**
 * TaskBook Task 331 Given a natural number n. If it can possible to represent a
 * number as a sum of 3 squares of natural numbers. If it possible then: a)
 * Specify a triple X, Y, Z for which n = x2 + y2 + z2. b) Specify all triples
 * X, Y, Z for which n = x2 + y2 + z2.
 * 
 * @author Bohdan Zhyvko
 *
 */
public class ThreeSquareNaturalNumbers {
	private int x;
	private int y;
	private int z;

	/**
	 * Set X, Y, Z Square of natural numbers
	 * 
	 * @param x
	 *            the square x
	 * @param y
	 *            the square y
	 * @param z
	 *            the square z
	 */
	public ThreeSquareNaturalNumbers(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public ThreeSquareNaturalNumbers() {
	}

	/**
	 * @return the square x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the square y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the square z
	 */
	public int getZ() {
		return z;
	}

	@Override
	public String toString() {
		return "x = " + x + ", y = " + y + ", z = " + z;
	}

	/**
	 * Override equal
	 */
	@Override
	public boolean equals(Object obj) {
		// self check
		if (this == obj)
			return true;
		// null check
		if (obj == null)
			return false;
		// type check and cast
		if (getClass() != obj.getClass())
			return false;
		ThreeSquareNaturalNumbers squares = (ThreeSquareNaturalNumbers) obj;
		// field comparison
		return Objects.equals(x, squares.x) && Objects.equals(y, squares.y) && Objects.equals(z, squares.z);
	}
	/**
	 * Equals three numbers to three-square numbers
	 * @param x get integer number
	 * @param y get integer number
	 * @param z get integer number
	 * @return  Return Boolean: - 'true' if are equals, 'false' if are not equals
	 */
	public boolean equals(int x, int y, int z) {
		// field comparison
		return (this.x == x) && (this.y == y) && (this.z == z);
	}

}
