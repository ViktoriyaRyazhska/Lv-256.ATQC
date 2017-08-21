package input_numbers;

import java.util.Scanner;

public class FloatNum {

	void isInRange(float n){
		if(n>=-5 && n<=5) {
			System.out.println("Is in range");
		}
		else{
			System.out.println("Is not in range");
		}

	}
	
	public void inputNumbers(){
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Enter first number: ");
		isInRange(scanner.nextFloat());
		
		System.out.println("Enter second number: ");
		isInRange(scanner.nextFloat());
		
		System.out.println("Enter third number: ");
		isInRange(scanner.nextFloat());
		
		
	}
}
