package home;

public class TaskBookD {
	Integer[] num = { 1, 3, 7, 10, 36, 69, 0, 46 };

	public void checkCondition(int i) {

		if ((Math.pow(2, i) < num[i]) && (num[i] < factorial(i))) {
			System.out.println("The number satisfies condition");
		} else {
			System.out.println("The number doesn't satisfy condition");
		}
	}

	public int factorial(int j) {
		int y = 1;
		for (int i = 1; i <= j; i++) {
			y = y * i;
		}
		return y;
	}

	public static void main(String[] args) {
		TaskBookD g = new TaskBookD();
		g.checkCondition(3);
		g.checkCondition(6);
	}
}
