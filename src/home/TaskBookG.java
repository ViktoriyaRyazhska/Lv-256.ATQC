package home;

public class TaskBookG {
	Integer[] num = { 1, 3, 7, 10, 36, 59, 0, 46 };

	public int checkCondition(int i) {
		if (i==0 && i==num.length-1) {
			System.out.println( "try next one");
			} 
		else if (num[i]< (num[i-1]+num[i-1])/2) {
			System.out.println( "The number" +num[i] +"satisfies condition");
			}
		else {
			System.out.println( "The number" +i +" doesn't satisfy condition");
			}
		return i; 
		}
	

	public static void main(String[] args) {
		TaskBookG taskBookG = new TaskBookG();
		taskBookG.checkCondition(3);
		taskBookG.checkCondition(6);
	}
}
