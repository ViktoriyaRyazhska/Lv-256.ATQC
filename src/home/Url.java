package home;
public class Url{
	public static void main (String[] args) {
		boolean number = true;
		String inputData = ("http://localhost/index.html");
		number=isValidUrl(inputData);
		}
	 public static boolean isValidUrl(String number) {
		 String regexExpression = "(https?://)?(([\\w-_%\\.]+\\.)+[\\w-_%\\.]+|localhost)(:\\d{2,5})?(/[\\w-_%\\.]+)*/?";
		 if (number.matches(regexExpression)) {
			 return true;
			 }else {
				 return false;
				 }
		 }
}
