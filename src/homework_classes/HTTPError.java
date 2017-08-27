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

	public HTTPError setValue(int value) {
		switch (value) {

		case 400:
			return HTTPError.HTTP400;
		case 401:
			return HTTPError.HTTP401;
		case 402:
			return HTTPError.HTTP402;
		case 403:
			return HTTPError.HTTP403;
		case 404:
			return HTTPError.HTTP404;
		case 405:
			return HTTPError.HTTP405;
		case 406:
			return HTTPError.HTTP406;
		case 407:
			return HTTPError.HTTP407;
		case 408:
			return HTTPError.HTTP408;
		case 409:
			return HTTPError.HTTP409;
		case 410:
			return HTTPError.HTTP410;
		case 411:
			return HTTPError.HTTP411;
		case 412:
			return HTTPError.HTTP412;
		case 413:
			return HTTPError.HTTP413;
		case 414:
			return HTTPError.HTTP414;
		case 415:
			return HTTPError.HTTP415;
		case 416:
			return HTTPError.HTTP416;
		case 417:
			return HTTPError.HTTP417;
		case 418:
			return HTTPError.HTTP418;
		case 419:
			return HTTPError.HTTP419;
		case 420:
			return HTTPError.HTTP420;
		case 422:
			return HTTPError.HTTP422;
		case 423:
			return HTTPError.HTTP423;
		case 424:
			return HTTPError.HTTP424;
		case 428:
			return HTTPError.HTTP428;
		case 429:
			return HTTPError.HTTP429;
		case 431:
			return HTTPError.HTTP431;
		case 440:
			return HTTPError.HTTP440;
		case 444:
			return HTTPError.HTTP444;
		case 449:
			return HTTPError.HTTP449;
		case 450:
			return HTTPError.HTTP450;
		case 451:
			return HTTPError.HTTP451;
		default:
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
