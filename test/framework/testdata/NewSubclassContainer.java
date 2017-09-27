package framework.testdata;

public class NewSubclassContainer {

	public static NewSubclass getInvalidEmptyData() {

		return new NewSubclass().setnameClasses("").setParameterDescription("Lviv").setUnitOfMeasurement("m2");
	}

	public static NewSubclass getSameClassName() {

		return new NewSubclass().setnameClasses("Italy").setParameterDescription("").setUnitOfMeasurement("");
	}

	public static NewSubclass getValidData() {

		return new NewSubclass().setnameClasses("Sidney").setParameterDescription("Vik").setUnitOfMeasurement("m4");
	}

	public static NewSubclass getValidDataClear() {

		return new NewSubclass().setnameClasses("Volyn").setParameterDescription("Nov").setUnitOfMeasurement("m2");
	}
	
	public static NewSubclass getAddedField() {
		return new NewSubclass().setParameterDescription1("Zhyk").setUnitOfMeasurement1("m5");
		
	}
	
	public static NewSubclass getValData() {

		return new NewSubclass().setnameClasses("Ivano-Frankivsk").setParameterDescription("Galych").setUnitOfMeasurement("m3");
	}
	
}
