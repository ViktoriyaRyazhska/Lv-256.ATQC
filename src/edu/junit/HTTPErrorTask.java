package edu.junit;

public class HTTPErrorTask {
	public static void main(String[] array) {
		HTTPErrorTask Task = new HTTPErrorTask();

		String result = Task.getErrorCodeMessage(202);
		System.out.println("HTTP Error Message is " + result);

		result = Task.getErrorCodeMessage(404);
		System.out.println("HTTP Error Message is " + result);

		result = Task.getErrorCodeMessage(100);
		System.out.println("HTTP Error Message is " + result);

	}

	public String getErrorCodeMessage(int Code) {
		// ћетод values повертаЇ масив елемент≥в enuma
		HTTPError[] HTTPErrorList = HTTPError.values();

		HTTPError error = null;

		for (int i = 0; i < HTTPErrorList.length; i++) {
			HTTPError hTTPError = HTTPErrorList[i];
			if (hTTPError.getValue() == Code) { // ѕерев≥р€Їмо чи код enum сп≥впадаЇ з нашим
				error = hTTPError;// «м≥нн≥й присвоЇюмо код enuma
			}
		}

		String hTTPErrorMessage = "Unknown";

		switch (error) {
		case HTTP_ERROR_Accepted:
			hTTPErrorMessage = "The request has been accepted for processing, but the processing has not been completed";
			break;
		case HTTP_ERROR_Continue:
			hTTPErrorMessage = "The server has received the request headers and the client should proceed to send the request body";
			break;
		case HTTP_ERROR_Bad_Gateway:
			hTTPErrorMessage = "The server was acting as a gateway or proxy and received an invalid response from the upstream server";
			break;
		case HTTP_ERROR_OK:
			hTTPErrorMessage = "Standard response for successful HTTP requests";
			break;
		case HTTP_ERROR_Switch_Proxy:
			hTTPErrorMessage = "No longer used. Subsequent requests should use the specified proxy";
			break;
		case HTTP_ERROR_Use_Proxy:
			hTTPErrorMessage = "The requested resource is available only through a proxy, the address for which is provided in the response";
			break;
		case HTTP_ERROR_Conflict:
			hTTPErrorMessage = "Indicates that the request could not be processed because of conflict in the request, such as an edit conflict between multiple simultaneous updates";
			break;
		case HTTP_ERROR_Gone:
			hTTPErrorMessage = "ndicates that the resource requested is no longer available and will not be available again";
			break;
		case HTTP_ERROR_Forbidden:
			hTTPErrorMessage = "The request was valid, but the server is refusing action";
			break;
		case HTTP_ERROR_Not_Found:
			hTTPErrorMessage = "The requested resource could not be found but may be available in the future";
			break;

		}
		return hTTPErrorMessage;
	}
}
