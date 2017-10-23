package com.regres.testdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RegisteredUserContainer {
	public static List<RegisteredUsers> getValidData() {
		Properties properties = readProperties("resources/registere_new_user.properties");

		String[] validFirstNames = properties.getProperty("FIRST_NAME").split(",");
		String[] validSecondName = properties.getProperty("SECOND_NAME").split(",");
		String[] validMiddleName = properties.getProperty("MIDDLE_NAME").split(",");
		String[] validEmail = properties.getProperty("EMAIL").split(",");
		String[] validLogin = properties.getProperty("LOGIN").split(",");
		String[] validPassword = properties.getProperty("PASSWORD").split(",");
		String[] validConfirmPassword = properties.getProperty("CONFIRM_PASSWORD").split(",");
		String[] validCity = properties.getProperty("CITY").split(",");
		String[] validRegion = properties.getProperty("REGION").split(",");
		String[] validDistrict = properties.getProperty("DISTRICT").split(",");
		String[] validStreet= properties.getProperty("STREET").split(",");
		String[] validBuilding = properties.getProperty("BUILDING").split(",");
		String[] validFlat = properties.getProperty("FLAT").split(",");
		String[] validPostcode = properties.getProperty("POSTCODE").split(",");
		String[] validPassportSeria = properties.getProperty("PASSPORT_SERIA").split(",");
		String[] validPassportNumber = properties.getProperty("PASSPORT_NUMBER").split(",");
		String[] validPassportPublishedBy = properties.getProperty("PASSPORT_PUBLISHED_BY").split(",");
		String[] validPhoneNumber = properties.getProperty("PHONE_NUMBER").split(",");
		String[] validCommunity = properties.getProperty("COMMUNITY").split(",");
		
		

		List<RegisteredUsers> users = new ArrayList<>();

		// Read values and add them to the list
		for (int i = 0; i < validFirstNames.length; i++) {
			RegisteredUsers registerUser = new RegisteredUsers();
			String firstName = validFirstNames[i].trim();
			String secondName = validSecondName[i].trim();
			String middleName = validMiddleName[i].trim();
			String email= validEmail[i].trim();
			String login = validLogin[i].trim();
			String password = validPassword[i].trim();
			String confirmPassword = validConfirmPassword[i].trim();
			String city = validCity[i].trim();
			String region= validRegion[i].trim();
			String district = validDistrict[i].trim();
			String street = validStreet[i].trim();
			String building = validBuilding[i].trim();
			String flat = validFlat[i].trim();
			String postcode = validPostcode[i].trim();
			String passportSeria = validPassportSeria[i].trim();
			String passportNumber= validPassportNumber[i].trim();
			String passportPublishedBy=validPassportPublishedBy[i].trim();  
			String phoneNumber=validPhoneNumber[i].trim(); 
			String community = validCommunity[i].trim();
			
			registerUser.setFirstName(validFirstNames[i].trim());
			registerUser.setSecondName(secondName);
			registerUser.setMiddleName(middleName);
			registerUser.setEmail(email);
			registerUser.setLogin(login);
			registerUser.setPassword(password);
			registerUser.setConfirmPassword(confirmPassword);
			registerUser.setCity(city);
			registerUser.setRegion(region);
			registerUser.setDistrict(district);
			registerUser.setStreet(street);
			registerUser.setBuilding(building);
			registerUser.setFlat(flat);
			registerUser.setPostcode(postcode);
			registerUser.setPassportSeria(passportSeria);
			registerUser.setPassportNumber(passportNumber);
			registerUser.setPassportPublishedBy(passportPublishedBy);
			registerUser.setPhoneNumber(phoneNumber);
			registerUser.setCommunity(community);
			

			users.add(registerUser);
		}

		return users;
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
