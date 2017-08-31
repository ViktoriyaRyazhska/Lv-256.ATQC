package edu.com.homework.main;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import edu.com.homework.tasksbook.Task108;
import edu.com.homework.tasksbook.Task178b;
import edu.com.homework.tasksbook.Task178w;
import edu.com.homework.tasksbook.Task322;
import edu.com.homework.tasksbook.Task330;
import edu.com.homework.tasksbook.Task331a;
import edu.com.homework.tasksbook.Task331b;
import edu.com.homework.tasksbook.Task86a;
import edu.com.homework.tasksbook.Task86b;
import edu.com.homework.tasksbook.Task88a;
import edu.com.homework.tasksbook.Task88b;
import edu.com.homework.tasksbook.TaskBook178d;
import edu.com.homework.tasksbook.TaskBook178g;
import edu.com.homework.tasksbook.TaskBook555;
import edu.com.homework.tasksbook.Task182;
import edu.com.homework.tasksbook.Task323;
import edu.com.homework.tasksbook.Task560;
import edu.com.homework.tasksbook.Task88w;
import edu.com.homework.tasksbook.Task88g;
import edu.com.homework.tasksbook.Task332;
import edu.com.homework.tasksbook.Task554;

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
			return new TaskBook178g();
		case "178d":
			return new TaskBook178d();
		case "555":
			return new TaskBook555();
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
