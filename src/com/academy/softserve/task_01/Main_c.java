package com.academy.softserve.task_01;

import java.util.Scanner;

public class Main_c {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter error code:");
        int codeNumber = sc.nextInt();
        for (HTTPError err : HTTPError.values()) {
            if (err.getNumber() == codeNumber) {
                System.out.println(err.getMessage());
            }
        }
    }

    enum HTTPError {
        HTTP_ERROR_400(400, "Bad Request"),
        HTTP_ERROR_401(401, "Unauthorized"),
        HTTP_ERROR_402(402, "Payment Required"),
        HTTP_ERROR_403(403, "Forbidden"),
        HTTP_ERROR_404(404, "Not Found"),
        HTTP_ERROR_405(405, "Method Not Allowed"),
        HTTP_ERROR_406(406, "Not Acceptable"),
        HTTP_ERROR_407(407, "Proxy Authentication Required"),
        HTTP_ERROR_408(408, "Request Timeout"),
        HTTP_ERROR_409(409, "Conflict"),
        HTTP_ERROR_410(410, "Gone"),
        HTTP_ERROR_411(411, "Length Required"),
        HTTP_ERROR_412(412, "Precondition Failed");

        private int number;
        private String message;

        HTTPError(int number, String message) {
            this.number = number;
            this.message = message;
        }

        public int getNumber() {
            return number;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return "HTTPError{" +
                    "number=" + number +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}
