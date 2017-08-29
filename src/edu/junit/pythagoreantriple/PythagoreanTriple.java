package edu.junit.pythagoreantriple;

public class PythagoreanTriple {

	public static void main(String[] array) {
		PythagoreanTriple pythagoreanTriple = new PythagoreanTriple();
		pythagoreanTriple.checkPythagoreanTriple(20);
	}

	public void checkPythagoreanTriple(int n) {

		for (int a = 1; a <= n; a++) { // ѕерев≥р€Їмо поки a <= n (за умовою)
			for (int b = a + 1; b <= n; b++) { // ѕерев≥р€Їмо поки b <= n (за умовою)
				for (int c = b + 1; c <= n; c++) { //// ѕерев≥р€Їмо поки c <= n (за умовою)
					if (a <= b && b <= c) { // якщо a <= b ≥ b <= c
						if ((a * a + b * b) == c * c) { // якщо а^2+b^2=c^2, то виконуЇтьс€ умова;
							System.out.println("a = " + a + " " + "b = " + b + " " + " c= " + c);
						}
					}
				}
			}
		}
	}
}
