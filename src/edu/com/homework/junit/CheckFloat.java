package edu.com.homework.junit;

public class CheckFloat {
	public boolean isInRange(float n){
		if(n>=-5 && n<=5) {
			
			System.out.println("Value is in range");
			return true;
		}
		else{
			System.out.println("Value is not in range");
			return false;
		}
	}

}
