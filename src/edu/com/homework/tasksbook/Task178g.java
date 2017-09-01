package edu.com.homework.tasksbook;

import java.util.ArrayList;
import java.util.Scanner;

public class Task178g {
	/*
	 * Find quantity of numbers which satisfy condition - ak<(a(k-1)+a(k+1)/2
	 */
	public void resolve() {
		ArrayList<Integer> num = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.println(" Find quantity of numbers which satisfy condition - ak<(a(k-1)+a(k+1)/2");
        System.out.print("Enter some numbers: ");
        try{
        	while ( scan.hasNextInt() ) {
        		num.add(scan.nextInt());      
        		checkCondition(num);
        		}
        	} catch (NumberFormatException ex){
        		System.out.println("You didn't enter a number ");
        		resolve();
	}
        
	}
    
	public void checkCondition(ArrayList<Integer> num) {	
		int count = 0;
		for (int i = 1; i < num.size()-1; i++) {
			if (num.get(i) < ((num.get(i - 1) + num.get(i - 1)) / 2)) {
				count += 1;			
				} 			
			} 
		System.out.println("The quantity of numbers which satisfy condition is "+count);
		
		if (count==0) {
			System.out.println("The numbers doesn't satisfy condition");
			}
		}

//	public static void main(String[] args) {
//		TaskBook178g taskBookG = new TaskBook178g();
//		taskBookG.resolve();
//	}
}
