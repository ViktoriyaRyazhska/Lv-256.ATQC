package input_numbers;

import java.util.Scanner;

public class HttpErrorGuess {

	public enum HTTPError {
		
		HTTP400(400,"Bad Request"),
		HTTP401(401,"Unauthorized"),
		HTTP402(402,"Payment Required"),
		HTTP403(403,"Forbidden"),
		HTTP404(404,"Not Found"),
		HTTP405(405,"Method Not Allowed"),
		HTTP406(406,"Not Acceptable"),
		HTTP407(407,"Proxy Authentication Required"),
		HTTP408(408,"Request Timeout"),
		HTTP409(409,"Conflict"),
		HTTP410(410,"Gone"),
		HTTP411(411,"Length Required"),
		HTTP412(412,"Precondition Failed"),
		HTTP413(413,"Payload Too Large"),
		HTTPnone(null,"No such error in db");
		
		Integer code;
		String message;
		
		HTTPError(Integer code, String message) {
			this.code=code;
			this.message=message;
		}
		
		public HTTPError setValue(int value) {
			switch(value) {
			
			case 400: return HTTPError.HTTP400;
			case 401: return HTTPError.HTTP401;
			case 402: return HTTPError.HTTP402;
			case 403: return HTTPError.HTTP403;
			case 404: return HTTPError.HTTP404;
			case 405: return HTTPError.HTTP405;
			case 406: return HTTPError.HTTP406;
			case 407: return HTTPError.HTTP407;
			case 408: return HTTPError.HTTP408;
			case 409: return HTTPError.HTTP409;
			case 410: return HTTPError.HTTP410;
			case 411: return HTTPError.HTTP411;
			case 412: return HTTPError.HTTP412;
			case 413: return HTTPError.HTTP413;
			
			default: return HTTPError.HTTPnone;
			}
			
		}
		
		
		
		public String toString() {
			if(code==null) {
				return message;
			}
			else {
				
				return "Error "+code+" "+message;
			}
			
		}
	
	}
	
	
	
	public Integer input(){
		
		Integer temp=0;
		
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
		e=e.setValue(new HttpErrorGuess().input());
		System.out.println(e);
		
		
	}
	
}
	

	



