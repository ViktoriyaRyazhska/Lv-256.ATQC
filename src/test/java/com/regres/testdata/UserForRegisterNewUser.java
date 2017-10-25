package com.regres.testdata;

import com.mysql.jdbc.PreparedStatement;
import com.regres.testdata.DB.UserDB;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserForRegisterNewUser {
    String firstName;
    String secondName;
    String middleName;
    String email;
    String login;
    String password;
    String confirmPassword;
    String city;
    String region;
    String district;
    String street;
    String building;
    String flat;
    String postcode;
    String passportSeria;
    String passportNumber;
    String passportPublishedBy;
    String phoneNumber;
    String community;

    public UserForRegisterNewUser() {
    }

    public UserForRegisterNewUser(String firstName, String secondName, String middleName, String email, String login, String password, String confirmPassword, String city, String region, String district, String street, String building, String flat, String postcode, String passportSeria, String passportNumber, String passportPublishedBy, String phoneNumber, String community) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.city = city;
        this.region = region;
        this.district = district;
        this.street = street;
        this.building = building;
        this.flat = flat;
        this.postcode = postcode;
        this.passportSeria = passportSeria;
        this.passportNumber = passportNumber;
        this.passportPublishedBy = passportPublishedBy;
        this.phoneNumber = phoneNumber;
        this.community = community;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportPublishedBy() {
        return passportPublishedBy;
    }

    public void setPassportPublishedBy(String passportPublishedBy) {
        this.passportPublishedBy = passportPublishedBy;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public List<UserForRegisterNewUser> addUserFromExcelToList(File excelFile, String sheetName) throws IOException {
        List<UserForRegisterNewUser> userDBList = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(excelFile));
        XSSFSheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("No sheet exists with name " + sheetName);
        }
        for (int r = 1; r < sheet.getLastRowNum(); r++) {
            XSSFRow row = sheet.getRow(r);
            if (row != null) {
                userDBList.add(new UserForRegisterNewUser(
                        ecxelEnumToStringConverter(row.getCell(0)),
                        ecxelEnumToStringConverter(row.getCell(1)),
                        ecxelEnumToStringConverter(row.getCell(2)),
                        ecxelEnumToStringConverter(row.getCell(3)),
                        ecxelEnumToStringConverter(row.getCell(4)),
                        ecxelEnumToStringConverter(row.getCell(5)),
                        ecxelEnumToStringConverter(row.getCell(6)),
                        ecxelEnumToStringConverter(row.getCell(7)),
                        ecxelEnumToStringConverter(row.getCell(8)),
                        ecxelEnumToStringConverter(row.getCell(9)),
                        ecxelEnumToStringConverter(row.getCell(10)),
                        ecxelEnumToStringConverter(row.getCell(11)),
                        ecxelEnumToStringConverter(row.getCell(12)),
                        ecxelEnumToStringConverter(row.getCell(13)),
                        ecxelEnumToStringConverter(row.getCell(14)),
                        ecxelEnumToStringConverter(row.getCell(15)),
                        ecxelEnumToStringConverter(row.getCell(16)),
                        ecxelEnumToStringConverter(row.getCell(17)),
                        ecxelEnumToStringConverter(row.getCell(18))
                ));
            }
        }
        workbook.close();
        return userDBList;
    }

    public String ecxelEnumToStringConverter(XSSFCell cell) {
        String s;
        switch (cell.getCellTypeEnum()) {
            case STRING:
                s = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell))
                    s = cell.getDateCellValue().toString();
                else
                    s = NumberToTextConverter.toText(cell.getNumericCellValue());
                break;
            case BOOLEAN:
                s = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                s = cell.getCellFormula();
                break;
            case BLANK:
                s = "";
                break;
            default:
                s = "";
        }
        return s;
    }


    //DB
    public static void deleteUserInDB(Connection conn, UserForRegisterNewUser userDB) throws SQLException, ClassNotFoundException {
        Statement s = conn.createStatement();
        String foreignCheckNull = "SET FOREIGN_KEY_CHECKS=0";
        s.execute(foreignCheckNull);
        if (s != null) s.close();

        String deleteUser = "Delete from registrator_db.users where login=(?)";
        PreparedStatement st = (PreparedStatement) conn.prepareStatement(deleteUser);
        st.setString(1, userDB.getLogin());
        st.executeUpdate();
        if (st != null) st.close();
    }

    public static int usersInDBQuantity(Connection conn) throws SQLException, ClassNotFoundException {
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select count(*) from registrator_db.users");
        int count = 0;
        while (rs.next()) {
            count = rs.getInt("count(*)");
        }
        return count;
    }
}





