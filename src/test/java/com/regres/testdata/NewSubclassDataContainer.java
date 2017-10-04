package com.regres.testdata;

public class NewSubclassDataContainer {

	public static NewSubclass setInvalidData() {

		return new NewSubclass().setNameClasses("").setParameterDescription("Lviv").setUnitOfMeasurement("m2");
	}

	public static NewSubclass setExistClassName() {

		return new NewSubclass().setNameClasses("Italy").setParameterDescription("").setUnitOfMeasurement("");
	}

	public static NewSubclass setValidData() {

		return new NewSubclass().setNameClasses("Sidney").setParameterDescription("Vik").setUnitOfMeasurement("m4");
	}

	public static NewSubclass setValidDataClear() {

		return new NewSubclass().setNameClasses("Volyn").setParameterDescription("Nov").setUnitOfMeasurement("m2");
	}

	public static NewSubclass setAdditionalField() {
		return new NewSubclass().setParameterDescription1("Zhyk").setUnitOfMeasurement1("m5");
	}

	public static NewSubclass setValidValue() {

		return new NewSubclass().setNameClasses("Ivano-Frankivsk").setParameterDescription("Galych")
				.setUnitOfMeasurement("m3");
	}
}
