package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Error {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of error: ");
		int a = Integer.parseInt(br.readLine());
		HTTPError error;
		switch(a){
		case 400:
			error = HTTPError.Bad_Request;
			System.out.println(error);
			break;
		case 401:
			error = HTTPError.Unauthorized;
			System.out.println(error);
			break;
		case 402:
			error = HTTPError.Payment_Required;
			System.out.println(error);
			break;
		case 403:
			error = HTTPError.Forbidden;
			System.out.println(error);
			break;	
		case 404:
			error = HTTPError.Not_Found;
			System.out.println(error);
			break;	
			
		}

	}

}
