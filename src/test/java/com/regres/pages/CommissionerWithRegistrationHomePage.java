package com.regres.pages;

import java.sql.Connection;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.PreparedStatement;
import com.regres.testdata.UserDB;

public class CommissionerWithRegistrationHomePage extends CommissionerHomePage {
	String REGISTRATION_CSSSELECTOR = "[href=\"/manualregistration\"]";
	private Connection conn;

	public CommissionerWithRegistrationHomePage(WebDriver driver) {
		super(driver);
	}

	public WebElement getRegistration() {
		return driver.findElement(By.cssSelector(REGISTRATION_CSSSELECTOR));
	}

	public void clickRegistration() {
		getRegistration().click();
	}

//	// Method for creating new Use in DD
//	public void createUserInDB(UserDB userDB) throws SQLException, ClassNotFoundException {
//
//		String createUser = "Insert into registrator_db.users (account_non_expired,account_non_locked,attempts,credentials_non_expired,date_of_accession,email,enabled,first_name,last_modified,last_name,locked_till,login,middle_name,password,phonenumber,status,role_id,territorialCommunity_id)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
//		PreparedStatement st = (PreparedStatement) conn.prepareStatement(createUser);
//
//		// Statement allows to send inquiries database
//		st.setString(1, userDB.getAccount_non_expired());
//		st.setString(2, userDB.getAccount_non_locked());
//		st.setString(3, userDB.getAttempts());
//		st.setString(4, userDB.getCredentials_non_expired());
//		st.setString(5, userDB.getDate_of_accession());
//		st.setString(6, userDB.getEmail());
//		st.setString(7, userDB.getEnabled());
//		st.setString(8, userDB.getFirst_Name());
//		st.setString(9, userDB.getLast_modified());
//		st.setString(10, userDB.getLast_Name());
//		st.setString(11, userDB.getLocked_till());
//		st.setString(12, userDB.getLogin());
//		st.setString(13, userDB.getMiddle_name());
//		st.setString(14, userDB.getPassword());
//		st.setString(15, userDB.getPhonenumber());
//		st.setString(16, userDB.getStatus());
//		st.setString(17, userDB.getRole_id());
//		st.setString(18, userDB.getTerritorialCommunity_id());
//		st.executeUpdate();
//	}
//
//	public void deleteUserInDB(UserDB userDB) throws SQLException, ClassNotFoundException {
//		String deleteUser = "Delete from registrator_db.users where login=(?)";
//		PreparedStatement st = (PreparedStatement) conn.prepareStatement(deleteUser);
//		st.setString(1, userDB.getLogin());
//		st.executeUpdate();
//	}

	// Business Logic
	@Override
	public CommissionerWithRegistrationHomePage setLanguage(ChangeLanguageFields language) {
		Select lang = new Select(getLocalizationDropdown());
		lang.selectByVisibleText(language.toString());
		// Return a new page object representing the destination.
		return new CommissionerWithRegistrationHomePage(driver);
	}
}
