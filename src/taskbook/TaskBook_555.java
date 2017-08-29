package taskbook;

import java.util.Scanner;
	/*
	 * Find n lines of Pascal triangle
	 * */

public class TaskBook_555 {
	private int lines = 0;;
	public int setNumberOfLines() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of lines for Pascal Triangle: ");
		int lines = scan.nextInt();
		return this.lines = lines;
		}
	public void doCalculation() {	
		int[][] p = new int[lines][];
		p[0] = new int[1];
		p[1] = new int[2];
		p[1][0] = p[1][1] = 1;
		System.out.println(p[0][0] = 1);
		System.out.println(p[1][0] + " " + p[1][1]);

		for (int i = 2; i < lines; i++) {
			p[i] = new int[i + 1];
			System.out.print((p[i][0] = 1) + " ");
			for (int j = 1; j < i; j++) {
				System.out.print((p[i][j] = p[i - 1][j - 1] + p[i - 1][j]) + " ");
			}
			System.out.println(p[i][i] = 1);
		}

	}
	public static void main(String[] args) {
		TaskBook_555 trianglePaskal = new TaskBook_555();
		trianglePaskal.setNumberOfLines();
		trianglePaskal.doCalculation();
		
	}
}
