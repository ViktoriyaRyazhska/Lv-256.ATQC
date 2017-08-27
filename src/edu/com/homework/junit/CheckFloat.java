package edu.com.homework.junit;

public class CheckFloat {
	void isInRange(float n){
		if(n>=-5 && n<=5) {
			System.out.println("Value is in range");
		}
		else{
			System.out.println("Value is not in range");
		}
	}

}
