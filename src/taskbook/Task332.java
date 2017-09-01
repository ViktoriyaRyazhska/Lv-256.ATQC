package taskbook;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	public class Task332 {
		public static String sumOfFourSquares(int n) {
			int x = (int) (Math.floor(Math.sqrt(n)));
			n = n - x * x;
			int y = (int) (Math.floor(Math.sqrt(n)));
			n = n - y * y;
			int z = (int) (Math.floor(Math.sqrt(n)));
			n = n - z * z;
			int t = (int) (Math.floor(Math.sqrt(n)));
			n = n - z * z;
			return "x = " + x + " y = " + y + " z = " + z + " t = " + t;
		}

		public static void resolve() {
			System.out.println("n = x^2 + y^2 + z^2 + t^2 ");
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
			System.out.println(sumOfFourSquares(n));
		}

	public static void main (String[] args) {
		Task332 Task332 = new Task332();
		Task332.resolve();
}
}
