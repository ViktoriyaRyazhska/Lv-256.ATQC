package com.regres.testdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class NewSubclassDataContainer {

	public static NewSubclass getInvalidData() {
		Properties properties = readProperties("resources/new_subclass.properties");
		NewSubclass newSubclass = new NewSubclass();
		newSubclass.setNameClasses(properties.getProperty("INVALID_NAME_SUBCLASSES"));
		newSubclass.setParameterDescription(properties.getProperty("INVALID_PARAMETER_DESCRIPTION"));
		newSubclass.setUnitOfMeasurement(properties.getProperty("INVALID_UNIT_OF_MEASUREMENT"));
		return newSubclass;
	}

	public static NewSubclass getExistClassName() {
		Properties properties = readProperties("resources/new_subclass.properties");
		NewSubclass newSubclass = new NewSubclass();
		newSubclass.setNameClasses(properties.getProperty("EXIST_NAME_SUBCLASSES"));
		newSubclass.setParameterDescription(properties.getProperty("EXIST_PARAMETER_DESCRIPTION"));
		newSubclass.setUnitOfMeasurement(properties.getProperty("EXIST_UNIT_OF_MEASUREMENT"));
		return newSubclass;
	}

	public static NewSubclass getValidData() {
		Properties properties = readProperties("resources/new_subclass.properties");
		NewSubclass newSubclass = new NewSubclass();
		newSubclass.setNameClasses(properties.getProperty("VALID_NAME_SUBCLASSES"));
		newSubclass.setParameterDescription(properties.getProperty("VALID_PARAMETER_DESCRIPTION"));
		newSubclass.setUnitOfMeasurement(properties.getProperty("VALID_UNIT_OF_MEASUREMENT"));
		return newSubclass;
	}

	public static NewSubclass getValidDataClear() {
		Properties properties = readProperties("resources/new_subclass.properties");
		NewSubclass newSubclass = new NewSubclass();
		newSubclass.setNameClasses(properties.getProperty("VALID_DATA_NAME_SUBCLASSES"));
		newSubclass.setParameterDescription(properties.getProperty("VALID_DATA_PARAMETER_DESCRIPTION"));
		newSubclass.setUnitOfMeasurement(properties.getProperty("VALID_DATA_UNIT_OF_MEASUREMENT"));
		return newSubclass;

	}

	public static NewSubclass getAdditionalField() {
		Properties properties = readProperties("resources/new_subclass.properties");
		NewSubclass newSubclass = new NewSubclass();
		newSubclass.setParameterDescription1(properties.getProperty("ADDITIONAL_PARAMETER_DESCRIPTION"));
		newSubclass.setUnitOfMeasurement1(properties.getProperty("ADDITIONAL_UNIT_OF_MEASUREMENT"));
		return newSubclass;

	}

	public static NewSubclass getValidValue() {
		Properties properties = readProperties("resources/new_subclass.properties");
		NewSubclass newSubclass = new NewSubclass();
		newSubclass.setNameClasses(properties.getProperty("VALUE_DATA_NAME_SUBCLASSES"));
		newSubclass.setParameterDescription(properties.getProperty("VALUE_PARAMETER_DESCRIPTION"));
		newSubclass.setUnitOfMeasurement(properties.getProperty("VALUE_UNIT_OF_MEASUREMENT"));
		return newSubclass;

	}

	private static Properties readProperties(String fileName) {
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(fileName);
			properties.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}
}
