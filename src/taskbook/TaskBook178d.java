package taskbook;
	/*
	 * Find quantity of numbers which satisfy condition - 2^k<ak<k!
	 * */

public class TaskBook178d {
	
//	public void checkCondition(int i) {
	public void resolve(int i) {
		Integer[] num = { 1, 3, 7, 10, 36, 69, 0, 46 };	
		int count = 0;
		for (i=0; i<num.length; i++) {
			if ((Math.pow(2, i) < num[i]) && (num[i] < factorial(i))) {
				count+=1;				
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
