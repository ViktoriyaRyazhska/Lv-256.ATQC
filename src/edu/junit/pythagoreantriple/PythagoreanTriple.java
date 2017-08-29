package edu.junit.pythagoreantriple;

public class PythagoreanTriple {

	public static void main(String[] array) {
		PythagoreanTriple pythagoreanTriple = new PythagoreanTriple();
		pythagoreanTriple.checkPythagoreanTriple(20);
	}

	public void checkPythagoreanTriple(int n) {

		for (int a = 1; a <= n; a++) { // ���������� ���� a <= n (�� ������)
			for (int b = a + 1; b <= n; b++) { // ���������� ���� b <= n (�� ������)
				for (int c = b + 1; c <= n; c++) { //// ���������� ���� c <= n (�� ������)
					if (a <= b && b <= c) { // ���� a <= b � b <= c
						if ((a * a + b * b) == c * c) { // ���� �^2+b^2=c^2, �� ���������� �����;
							System.out.println("a = " + a + " " + "b = " + b + " " + " c= " + c);
						}
					}
				}
			}
		}
	}
}
