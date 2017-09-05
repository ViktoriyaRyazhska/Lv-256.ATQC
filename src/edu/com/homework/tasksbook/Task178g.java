package edu.com.homework.tasksbook;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * TaskBook
 * Task 178
 * Given natural numbers n, a1,...an. Find quantity of members 
 * ak of sequence a1, ...an:
 * g)  which satisfy condition - ak<(a(k-1)+a(k+1)/2
 * 
 * @author Kryvenko Yaroslava
 *
 */

public class Task178g {
	
	/** Method resolve
	 * Provides input of numbers from the console.
	 * Calls condition test method and outputs the quantity of numbers.
	 */
	
	public void resolve() {		
		ArrayList<Integer> num = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter some numbers through a space between them and press enter: ");

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
			if (num.get(i) < ((num.get(i - 1) + num.get(i - 1)) / 2)) {
				count += 1;			
				} 			
			} 
		System.out.println("The quantity of numbers which satisfy condition is "+count);
		
		if (count==0) {
			System.out.println("Number doesn't satisfy condition");
			}
		}

//	public static void main(String[] args) {
//		Task178g taskBookG = new Task178g();
//		taskBookG.resolve();
//	}
}
