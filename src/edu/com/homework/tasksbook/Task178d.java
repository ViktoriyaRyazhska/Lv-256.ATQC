package edu.com.homework.tasksbook;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * TaskBook
 * Task 178
 * Given natural numbers n, a1,...an. Find quantity of members 
 * ak of sequence a1, ...an:
 * d)  which satisfy condition - 2^k<ak<k!
 * 
 * @author Kryvenko Yaroslava
 *
 */

public class Task178d {
	
	/** Method resolve
	 * Provides input of numbers from the console.
	 * Calls condition test method and outputs the quantity of numbers.
	 */
	
	public void resolve() {
		ArrayList<Integer> num = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter some numbers through a space between them and press enter : ");
        if ( scan.hasNextInt() ) {
        	num.add(scan.nextInt());      
    		checkCondition(num);
        } else {
        	System.out.println("You didn't enter a number ");
        }
	}        
	
	/** Condition test method
	 * @param List of integer numbers.
	 * @return Returns count of numbers which satisfy condition.
	 */
	
	public void checkCondition(ArrayList<Integer> num) {	
		int count = 0;
		for (int i = 1; i < num.size()-1; i++) {
			if ((Math.pow(2, i) < num.get(i) && (num.get(i) < factorial(i)))) {
				count += 1;			
				} 			
			} 
		System.out.println("The quantity of numbers which satisfy condition is "+count);		
		if (count==0) {
			System.out.println("The numbers doesn't satisfy condition");
			}
		}

	/** Calculation factorial method
	 * @param Integer number.
	 * @return Returns factorial of number.
	 */
	public int factorial(int j) {
		int y = 1;
		for (int i = 1; i <= j; i++) {
			y = y * i;
		}
		return y;
	}

//	public static void main(String[] args) {
//		TaskBook178d taskBookD = new TaskBook178d();
//		taskBookD.checkCondition(3);
//		taskBookD.checkCondition(6);
//	}
}
