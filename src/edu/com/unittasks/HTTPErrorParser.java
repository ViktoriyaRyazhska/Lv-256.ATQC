package edu.com.unittasks;

import java.util.Scanner;

public class HTTPErrorParser {

	public static void main(String[] args) {
		try (Scanner keyboard = new Scanner(System.in)) {
			System.out.println("Please input error code: ");
			Integer code = keyboard.nextInt();
			System.out.println(String.format("Http Error description: %s", parseErrorCode(code)));
		}
	}

	public static String parseErrorCode(int code) {
		for (HTTPError error : HTTPError.values()) {
			if (error.value() == code) {
				return error.getReasonPhrase();
			}
		}
		return "Unknown code!";
	}

	public enum HTTPError {
	// @formatter:off
	BAD_REQUEST(400, "Bad Request"),
	UNAUTHORIZED(401, "Unauthorized"),
	PAYMENT_REQUIRED(402, "Payment Required"),
	FORBIDDEN(403, "Forbidden"),
	NOT_FOUND(404, "Not Found"),
	METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
	NOT_ACCEPTABLE(406, "Not Acceptable"),
	PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
	REQUEST_TIMEOUT(408, "Request Timeout"),
	CONFLICT(409, "Conflict"),
	GONE(410, "Gone"),
	LENGTH_REQUIRED(411, "Length Required"),
	PRECONDITION_FAILED(412, "Precondition Failed"),
	PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
	REQUEST_ENTITY_TOO_LARGE(413, "Request Entity Too Large"),
	URI_TOO_LONG(414, "URI Too Long"),
	REQUEST_URI_TOO_LONG(414, "Request-URI Too Long"),
	UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
	REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested range not satisfiable"),
	EXPECTATION_FAILED(417, "Expectation Failed"),
	I_AM_A_TEAPOT(418, "I'm a teapot"),
	INSUFFICIENT_SPACE_ON_RESOURCE(419, "Insufficient Space On Resource"),
	METHOD_FAILURE(420, "Method Failure"),
	DESTINATION_LOCKED(421, "Destination Locked"),
	UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),
	LOCKED(423, "Locked"),
	FAILED_DEPENDENCY(424, "Failed Dependency"),
	UPGRADE_REQUIRED(426, "Upgrade Required"),
	PRECONDITION_REQUIRED(428, "Precondition Required"),
	TOO_MANY_REQUESTS(429, "Too Many Requests"),
	REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),
	UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons");
	
	// @formatter:on

		private final int value;

		private final String reasonPhrase;

		HTTPError(int value, String reasonPhrase) {
			this.value = value;
			this.reasonPhrase = reasonPhrase;
		}

		/**
		 * Return the integer value of this status code.
		 */
		public int value() {
			return this.value;
		}

		/**
		 * Return the reason phrase of this status code.
		 */
		public String getReasonPhrase() {
			return this.reasonPhrase;
		}
	}
}
