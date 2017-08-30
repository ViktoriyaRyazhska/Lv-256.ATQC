package edu.com.homework.main;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import edu.com.homework.tasksbook.Task322;
import edu.com.homework.tasksbook.Task330;
import edu.com.homework.tasksbook.Task86a;
import edu.com.homework.tasksbook.Task86b;
import edu.com.homework.tasksbook.Task88a;
import edu.com.homework.tasksbook.Task88b;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter method number: ");
			String methodName = scan.next();
			Object obj = setValue(methodName);
			obj.getClass().getMethod("resolve", null).invoke(obj, null);
			
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
			return null;
		case "226":
			return null;
		case "559":
			return null;
		case "88a":
			return new Task88a();
		case "88b":
			return new Task88b();
		case "322":
			return new Task322();
		case "88w":
			return null;
		case "88g":
			return null;
		case "332":
			return null;
		case "107":
			return null;
		case "243a":
			return null;
		case "243b":
			return null;
		case "108":
			return null;
		case "331a":
			return null;
		case "331b":
			return null;
		case "178b":
			return null;
		case "178w":
			return null;
		case "554":
			return null;
		default:
			return null;
		}

}
}
