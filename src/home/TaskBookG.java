package home;

public class TaskBookG {
	Integer[] num = {1, 3, 7, 10, 36, 59, 0, 46};
	public void checkCondition(int i) {
		if (i==0 && i==num.length-1) {
			System.out.println( "try next one");
		}
		else if (num[i]< (num[i-1]+num[i-1])/2) {
			System.out.println( "The number satisfies condition");
		} 
		else {
			System.out.println( "The number doesn't satisfy condition");
		}
	}
public static void main (String	[]args) {
	TaskBookG g = new TaskBookG();
	g.checkCondition(3);
	g.checkCondition(6);			
}
}
