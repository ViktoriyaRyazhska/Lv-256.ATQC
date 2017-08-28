package edu.com.homework.junit;

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
	HTTP411(411, "Length Required"), 
	HTTP412(412, "Precondition Failed"), 
	HTTP413(413, "Payload Too Large"), 
	HTTP414(414, "Request-URI Too Long"), 
	HTTP415(415, "Unsupported Media Type"), 
	HTTP416(416, "Requested Range Not Satisfiable"), 
	HTTP417(417, "Expectation Failed"), 
	HTTP418(418, "I'm a teapot"), 
	HTTP421(421, "Misdirected Request"), 
	HTTP423(423, "Locked"), 
	HTTP424(424, "Failed Dependency"), 
	HTTP426(426, "Upgrade Required"), 
	HTTP428(428, "Precondition Required"), 
	HTTP429(429, "Too Many Requests"), 
	HTTP431(431, "Request Header Fields Too Large"), 
	HTTP440(440, "Login Timeout"), 
	HTTP451(451, "Unavailable For Legal Reasons"), 
	HTTP0(0, "No such error");

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
		case 451:
			return HTTPError.HTTP451;
		default:
			return HTTPError.HTTP0;
		}

	}

	public int setErrors() {
		int error = 0;
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter code error: ");
			error = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Input error");
		}
		return error;
	}

}
