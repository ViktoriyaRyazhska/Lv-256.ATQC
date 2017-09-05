package edu.com.homework.tasksbook;

import java.util.Scanner;

/**
 * TaskBook
 * Task 555
 * Given a natural n. Find n lines of Pascal triangle
 * 
 * @author Kryvenko Yaroslava
 *
 */

public class Task555 {
	public int lines = 0;
	
	/** Method resolve
	 * Provides input of number from the console.
	 * Calls calculation test method and outputs lines of Pascal triangle
	 */
	
	public void resolve() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of lines for Pascal Triangle and press enter: ");
		if (scan.hasNextInt()) {
			lines=scan.nextInt();
			doCalculation(lines);			
		} else {
        		System.out.println("You didn't enter a number ");
        		}
		}

	/** Calculation method
	 * @param Number of lines.
	 * @return Returns lines of Pascal triangle.
	 */
	
	public void doCalculation(int lines) {	
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
//	public static void main(String[] args) {
//		Task555 trianglePaskal = new Task555();
//		trianglePaskal.resolve();
//		trianglePaskal.doCalculation(7);		
//	}
}
