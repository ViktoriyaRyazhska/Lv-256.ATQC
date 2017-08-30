


import java.util.Scanner;

public class PythagoreanTriple {

		public void rezolve() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scan.nextInt();
		PythagoreanTriple pythagoreanTriple = new PythagoreanTriple();
		pythagoreanTriple.checkPythagoreanTriple(number);
	}

	public void checkPythagoreanTriple(int n) {

		for (int a = 1; a <= n; a++) { 
			for (int b = a + 1; b <= n; b++) { 
				for (int c = b + 1; c <= n; c++) { 
					if (a <= b && b <= c) { 
						if ((a * a + b * b) == c * c) { 
							System.out.println("a = " + a + " " + "b = " + b + " " + " c= " + c);
						}
					}
				}
			}
		}
	}
}
