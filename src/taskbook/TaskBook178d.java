package taskbook;
	/*
	 * Find quantity of numbers which satisfy condition - 2^k<ak<k!
	 * */

import java.util.ArrayList;
import java.util.Scanner;

public class TaskBook178d {

	public void resolve() {
		ArrayList<Integer> num = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.println(" Find quantity of numbers which satisfy condition - 2^k<ak<k! ");
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
			if ((Math.pow(2, i) < num.get(i) && (num.get(i) < factorial(i)))) {
				count += 1;			
				} 			
			} 
		System.out.println("The quantity of numbers which satisfy condition is "+count);
		
		if (count==0) {
			System.out.println("The numbers doesn't satisfy condition");
			}
		}

	
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