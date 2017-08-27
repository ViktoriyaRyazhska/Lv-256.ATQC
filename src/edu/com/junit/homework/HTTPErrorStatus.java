package edu.com.junit.homework;

import java.util.Scanner;

/**
 * The HTTPErrorStatus program implements an application that read number of
 * HTTP Error (400, 401,402, ...) and write the name of this error (Declare enum
 * HTTPError);
 *
 * @version 1.0
 * @author Bohdan Zhyvko
 */
public class HTTPErrorStatus {

	public enum StatusCode {
		HTTPStatus400(400, "Bad Request"),
		HTTPStatus401(401, "Unauthorized"),
		HTTPStatus402(402, "Payment Required"),
		HTTPStatus403(403, "Forbidden"),
		HTTPStatus404(404, "Not Found"),
		HTTPStatus405(405, "Method Not Allowed"),
		HTTPStatus406(406, "Not Acceptable"),
		HTTPStatus407(407, "Proxy Authentication Required"),
		HTTPStatus408(408, "Request Timeout"),
		HTTPStatus409(409, "Conflict"), 
		HTTPStatus410(410, "Gone"),
		HTTPStatus411(411, "Length Required"),
		HTTPStatus412(412, "Precondition Failed"),
		HTTPStatus413(413, "Request Entity Too Large"),
		HTTPStatus414(414, "Request-URI Too Long"),
		HTTPStatus415(415, "Unsupported Media Type"),
		HTTPStatus416(416, "Requested Range Not Satisfiable"),
		HTTPStatus417(417, "Expectation Failed"),
		
		HTTPStatus418(418, "I'm a teapot"),
		HTTPStatus419(419, "Authentication Timeout"),
		HTTPStatus420(420, "Method Failure"),
		HTTPStatus422(422, "Unprocessable Entity"),
		HTTPStatus423(423, "Locked"),
		HTTPStatus424(424, "Failed Dependency"),
		HTTPStatus426(426, "Upgrade Required"),
		HTTPStatus428(428, "Precondition Required"),
		HTTPStatus429(429, "Too Many Requests"),
		HTTPStatus431(431, "Request Header Fields Too Large"),
		HTTPStatus440(440, "Login Timeout"),
		HTTPStatus444(444, "No Response"),
		HTTPStatus449(449, "Retry With"),
		HTTPStatus450(450, "Blocked by Windows Parental Controls"),
		HTTPStatus451(451, "Unavailable For Legal Reasons");

		private int code;
		private String desc;

		StatusCode(int code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		/**
		 * Get the HTTP status code
		 * 
		 * @return the status code number
		 */
		public int getCode() {
			return code;
		}

		/**
		 * Get the description
		 * 
		 * @return the description of the status code
		 */
		public String getDesc() {
			return desc;
		}

		/**
		 * Get Status code and description from name element
		 * 
		 * @param code the HTTP error status code   
		 * @return status element or null if status false
		 */
	    public static StatusCode getElementFromName(int code) {
	    	String name = "HTTPStatus" + code;
	        for(StatusCode status : StatusCode.values()) {
	            if(status.toString().equalsIgnoreCase(name)) {
	                return status;
	            }
	        }
	        return null;
	    }
	}
	
	/**
	 * Read integer number from command-line input and return that
	 * 
	 * @return  integer number
	 */
	public int read() {
		System.out.println("Enter HTTPError status code: ");
		int code = 0;	
		try {
			// create a scanner for read the command-line input
			code = new Scanner(System.in).nextInt();
		} catch (Exception e) {
			System.out.println("Please provide correct input");
		}
		return code;
	}

	public static void main(String[] args) {
		
		HTTPErrorStatus status = new HTTPErrorStatus();
		StatusCode statusCode = StatusCode.getElementFromName(status.read());
		try {
			System.out.println(statusCode.getDesc());
		}catch (Exception e) {
			System.out.println("It is not HTTP Error status code");
		}
	}
}
