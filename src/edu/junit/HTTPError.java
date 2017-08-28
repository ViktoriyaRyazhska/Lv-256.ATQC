package edu.junit;

public enum HTTPError {
	
	HTTP_ERROR_Continue(100),
	HTTP_ERROR_OK(200),
	HTTP_ERROR_Accepted(202),
	HTTP_ERROR_Switch_Proxy(306),
	HTTP_ERROR_Use_Proxy(305), 
	HTTP_ERROR_Conflict(409),
	HTTP_ERROR_Gone(410),
	HTTP_ERROR_Forbidden(403),
	HTTP_ERROR_Not_Found(404),
	HTTP_ERROR_Bad_Gateway(502);
	
	
	private int value;

	HTTPError(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
