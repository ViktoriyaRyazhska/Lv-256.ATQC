package edu.com.homework.main;


import edu.com.homework.tasksbook.NaturalNumb;
import edu.com.homework.tasksbook.PerfectNumb;
public enum Methods {
	m86a(NaturalNumb.class, "quantity"), 
	m86b(NaturalNumb.class, "sumOfDigits"), 
	m330(PerfectNumb.class, "perfectNumbers"),
	m87(null,null),
	m226(null,null),
	m559(null,null),
	m88a(null,null),
	m88b(null,null),
	m322(null,null),
	m88w(null,null),
	m88g(null,null),
	m332(null,null),
	m107(null,null),
	m243a(null,null),
	m243b(null,null),
	m108(null,null),
	m331a(null,null),
	m331b(null,null),
	m178b(null,null),
	m178w(null,null),
	m554(null,null),
	mNull(null,null)
	;

	private Object clazz;
	private String methodName;

	Methods(Object clazz, String methodName) {
		this.clazz = clazz;
		this.methodName = methodName;
	}
	public Methods setValue(String value) {
		switch (value) {
		case "86a":
			return Methods.m86a;
		case "86b":
			return Methods.m86b;
		case "330":
			return Methods.m330;
		case "87":
			return Methods.m87;
		case "226":
			return Methods.m226;
		case "559":
			return Methods.m559;
		case "88a":
			return Methods.m88a;
		case "88b":
			return Methods.m88b;
		case "322":
			return Methods.m322;
		case "88w":
			return Methods.m88w;
		case "88g":
			return Methods.m88g;
		case "332":
			return Methods.m332;
		case "107":
			return Methods.m107;
		case "243a":
			return Methods.m243a;
		case "243b":
			return Methods.m243b;
		case "108":
			return Methods.m108;
		case "331a":
			return Methods.m331a;
		case "331b":
			return Methods.m331b;
		case "178b":
			return Methods.m178b;
		case "178w":
			return Methods.m178w;
		case "554":
			return Methods.m554;
		default:
			return null;
		}

	}

	public Object getClazz() {
		return clazz;
	}

	public void setClazz(Object clazz) {
		this.clazz = clazz;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	

}
