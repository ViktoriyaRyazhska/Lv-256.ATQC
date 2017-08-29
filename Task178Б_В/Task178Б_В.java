package Task178Á_Â;

public class Task178Á_Â {
	public static void main(String[] array) {
		int[] list = { 3, 4, 9, 12, 16, 34, 35, 36, 37, 38, 39, 64 };

		Task178Á_Â task178Á_Â = new Task178Á_Â();
		task178Á_Â.loopTest(list);
		task178Á_Â.loopTest2(list);

	}

	public void loopTest(int[] list) {

		int totalCount = 0;

		for (int i = 1; i < list.length; i++) {

			int value = list[i];

			if ((value % 3 == 0) && !(value % 5 == 0)) {

				System.out.println("Value is - " + value);

				totalCount = totalCount + 1;
			}

		}
		System.out.println("Total count " + totalCount);
	}

	public void loopTest2(int[] list) {

		int totalCount = 0;

		for (int i = 1; i < list.length; i++) {
			int value = list[i];

			if (Math.sqrt(value) % 2 == 0) {

				System.out.println("Value is - " + value);
				totalCount++;
			}
		}
		System.out.println("Total count " + totalCount);
	}
}
