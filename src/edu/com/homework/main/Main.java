package edu.com.homework.main;

import edu.com.homework.tasksbook.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter method number: ");
		String methodName = null;
		methodName = scan.next();
		while (!methodName.equals("exit")) {
			Object obj = null;
			try {
			obj = setValue(methodName);
			obj.getClass().getMethod("resolve", null).invoke(obj, null);}catch (NullPointerException e) {
				System.out.println("Non existing method");
			}
			System.out.print("Enter method number: ");
			methodName = scan.next();
		} 

		

	}

	public static Object setValue(String value) {
		switch (value) {
		case "86a":
			return new Task86a();
		case "86b":
			return new Task86b();
		case "330":
			return new Task330();
		case "87":
			return new Task87();
		case "226":
			return new Task226();
		case "559":
			return new Task559();
		case "88a":
			return new Task88a();
		case "88b":
			return new Task88b();
		case "322":
			return new Task322();
		case "88w":
			return new Task88w();
		case "88g":
			return new Task88g();
		case "332":
			return new Task332();
		case "107":
			return null;
		case "243a":
			return null;
		case "243b":
			return null;
		case "108":
			return new Task108();
		case "331a":
			return new Task331a();
		case "331b":
			return new Task331b();
		case "178b":
			return new Task178b();
		case "178w":
			return new Task178w();
		case "178g":
			return new Task178g();
		case "178d":
			return new Task178d();
		case "555":
			return new Task555();
		case "554":
			return new Task554();
		case "182":
			return new Task182();
		case "323":
			return new Task323();
		case "560":
			return new Task560();
		default:
			return null;
		}

	}
}
