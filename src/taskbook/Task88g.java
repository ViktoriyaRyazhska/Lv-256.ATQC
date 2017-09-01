package taskbook;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	public class Task88g {
		public static String addOne(String n) {
			return "1" + n + "1";
		}

		public void resolve() {
			System.out.println("Adding 1 at begin and end of number");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter natural number:");
			int n = 0;
			try {
				n = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				System.err.println("You can enter only numbers");
			} catch (IOException e) {
				System.err.println("IO Exception");
			}
			System.out.println(addOne(n));
		}
	
	public static void main (String[] args) {
		Task88g task88g = new Task88g();
		task88g.resolve();
}
}
