package homework_classes;

import java.util.Scanner;

public enum HTTPError {

	HTTP400(400, "Bad Request"), 
	HTTP401(401, "Unauthorized"), 
	HTTP402(402, "Payment Required"), 
	HTTP403(403, "Forbidden"), 
	HTTP404(404, "Not Found"), 
	HTTP405(405, "Method Not Allowed"),
	HTTP406(406, "Not Acceptable"),
	HTTP407(407, "Proxy Authentication Required"), 
	HTTP408(408, "Request Timeout"), 
	HTTP409(409, "Conflict"), 
	HTTP410(410, "Gone"), 
	HTTP411(411,"Length Required"),
	HTTP412(412, "Precondition Failed"), 
	HTTP413(413, "Payload Too Large"), 
	HTTP414(414, "Request-URI Too Long"), 
	HTTP415(415, "Unsupported Media Type"), 
	HTTP416(416, "Requested Range Not Satisfiable"), 
	HTTP417(417, "Expectation Failed"), 
	HTTP418(418, "I'm a teapot"),
	HTTP419(419,"Authentication Timeout"),
	HTTP420(420,"Method Failure"), 
	HTTP422(422,"Unprocessable Entity"),
	HTTP423(423, "Locked"), 
	HTTP424(424,"Failed Dependency"), 
	HTTP426(426,"Upgrade Required"),
	HTTP428(428, "Precondition Required"),
	HTTP429(429, "Too Many Requests"),
	HTTP431(431,"Request Header Fields Too Large"), 
	HTTP440(440,"Login Timeout"), 
	HTTP444(444, "No Response"),
	HTTP449(449, "Retry With"), 
	HTTP450(450, "Blocked by Windows Parental Controls"), 
	HTTP451(451,"Unavailable For Legal Reasons"), 
	HTTPnone(0,"No such error in db");
	int code;
	String message;

	HTTPError(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public HTTPError setValue(Integer value) {

		try {

			String error = "HTTP" + value.toString();
			return HTTPError.valueOf(error.toString());

		} catch (Exception ex) {
			return HTTPError.HTTPnone;
		}

	}

	public String toString() {
		if (code == 0) {
			return message;
		} else {

			return "Error " + code + " " + message;
		}

	}

	public int input() {

		Integer temp = 0;

		try {
			System.out.println("Enter number: ");
			Scanner scanner = new Scanner(System.in);
			temp = scanner.nextInt();

		} catch (Exception e) {
			System.out.println("Input error");
		}

		return temp;

	}

	public static void main(String[] args) {

		HTTPError e = HTTPError.HTTPnone;
		e = e.setValue(e.input());
		System.out.println(e);

	}

}
