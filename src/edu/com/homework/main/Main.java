package edu.com.homework.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Does not work (((
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter method number: ");
			String methodName = scan.next();
			Methods m = Methods.mNull;
			m = m.setValue(methodName);
			Object clazz = m.getClazz();
			Class cl = clazz.getClass();
			System.out.println(clazz);
			String met="";
			try {
				Method method= cl.getMethod(m.getMethodName(), null);
				try {
					 met = (String) method.invoke(clazz, null);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(met);
			
			
			
			
			
	}

}
