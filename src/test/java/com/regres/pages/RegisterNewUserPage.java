package com.regres.pages;

import com.regres.pages.TitleLocalFooter.ChangeLanguageFields;
import com.regres.pages.manage.coowners.CoownersElementsOnPageDropdown;
import com.regres.testdata.RegisteredUsers;
import com.regres.testdata.UserForRegisterNewUser;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public final class RegisterNewUserPage extends AdminHomePage{
    //Basic information
    private String FIRST_NAME_XPATH = "firstName";// must be
    private String SECOND_NAME_XPATH = ".//*[@id='lastName']";// must be
    private String MIDDLE_NAME_XPATH = ".//*[@id='middleName']";
    private String EMAIL_XPATH = ".//*[@id='email']";// must be
    private String LOGIN_XPATH = ".//*[@id='login']";// must be
    private String PASSWORD_XPATH = ".//*[@id='password']";// must be
    private String CONFIRM_PASSWORD_XPATH = ".//*[@id='confirmPassword']";
    //Address infomation
    private String CITY_XPATH = ".//*[@id='city']";
    private String REGION_XPATH = ".//*[@id='region']";
    private String DISTRICT_XPATH = ".//*[@id='district']";
    private String STREET_XPATH = ".//*[@id='street']";
    private String BUILDING_XPATH = ".//*[@id='building']";
    private String FLAT_XPATH = ".//*[@id='flat']";
    private String POSTCODE_XPATH = ".//*[@id='postcode']";
    //Passport information
    private String PASSPORT_SERIA_XPATH = ".//*[@id='passport_seria']";
    private String PASSPORT_NUMBER_XPATH = ".//*[@id='passport_number']";
    private String PASSPORT_PUBLISHED_BY_XPATH = ".//*[@id='published_by_data']";
    //Other data
    private String PHONE_NUMBER_XPATH = ".//*[@id='phone_number']";
    private String COMMUNITY_XPATH = ".//*[@id='territorial_Community']";// must be
    private String DATE_OF_ACCESSION_XPATH = ".//*[@id='datepicker']";// must be
    //Buttons
    private String BUTTON_SEND_XPATH=".//*[@id='submit']";
    private String BUTTON_CLEAR_XPATH=".//*[@id='registrationForm']/div[2]/button[2]";
    private String BUTTON_CANCEL_XPATH=".//*[@id='registrationForm']/div[2]/button[3]";

    //Basic information
    private WebElement firstName;
    private WebElement secondName;
    private WebElement middleName;
    private WebElement email;
    private WebElement login;
    private WebElement password;
    private WebElement confirmPassword;
    //Address infomation
    private WebElement city;
    private WebElement region;
    private WebElement district;
    private WebElement street;
    private WebElement building;
    private WebElement flat;
    private WebElement postcode;
    ////Passport information
    private WebElement passportSeria;
    private WebElement passportNumber;
    private WebElement passportPublishedBy;
    //Other data
    private WebElement phoneNumber;
    private WebElement community; //Select
    private WebElement dateOfAccession; //Calendar
    //Buttons
    private WebElement buttonSend;
    private WebElement buttonClear;
    private WebElement buttonCancel;


    private static volatile RegisterNewUserPage instance = null;

    protected RegisterNewUserPage(WebDriver driver) {
        super(driver);
    }

    public static RegisterNewUserPage get(WebDriver driver) {
        if (instance == null) {
            synchronized (RegisterNewUserPage.class) {
                if (instance == null) {
                    instance = new RegisterNewUserPage(driver);
                }
            }
        }
        return instance;
    }

    //GETTERS
    public WebElement getFirstName() {
        return driver.findElement(By.id(FIRST_NAME_XPATH));
    }

    public WebElement getSecondName() {
        return driver.findElement(By.xpath(SECOND_NAME_XPATH));
    }

    public WebElement getMiddleName() {
        return driver.findElement(By.xpath(MIDDLE_NAME_XPATH));
    }

    public WebElement getEmail() {
        return driver.findElement(By.xpath(EMAIL_XPATH));
    }

    public WebElement getLogin() {
        return driver.findElement(By.xpath(LOGIN_XPATH));
    }

    public WebElement getPassword() {
        return driver.findElement(By.xpath(PASSWORD_XPATH));
    }

    public WebElement getConfirmPassword() {
        return driver.findElement(By.xpath(CONFIRM_PASSWORD_XPATH));
    }

    public WebElement getCity() {
        return driver.findElement(By.xpath(CITY_XPATH));
    }

    public WebElement getRegion() {
        return driver.findElement(By.xpath(REGION_XPATH));
    }

    public WebElement getDistrict() {
        return driver.findElement(By.xpath(DISTRICT_XPATH));
    }

    public WebElement getStreet() {
        return driver.findElement(By.xpath(STREET_XPATH));
    }

    public WebElement getBuilding() {
        return driver.findElement(By.xpath(BUILDING_XPATH));
    }

    public WebElement getFlat() {
        return driver.findElement(By.xpath(FLAT_XPATH));
    }

    public WebElement getPostcode() {
        return driver.findElement(By.xpath(POSTCODE_XPATH));
    }

    public WebElement getPassportSeria() {
        return driver.findElement(By.xpath(PASSPORT_SERIA_XPATH));
    }

    public WebElement getPassportNumber() {
        return driver.findElement(By.xpath(PASSPORT_NUMBER_XPATH));
    }

    public WebElement getPassportPublishedBy() {
        return driver.findElement(By.xpath(PASSPORT_PUBLISHED_BY_XPATH));
    }

    public WebElement getPhoneNumber() {
        return driver.findElement(By.xpath(PHONE_NUMBER_XPATH));
    }

    public WebElement getCommunity() {
        return driver.findElement(By.xpath(COMMUNITY_XPATH));
    }

    public WebElement getDateOfAccession() {
        return driver.findElement(By.xpath(DATE_OF_ACCESSION_XPATH));
    }

    // SETTERS
    public void setFirstName(String firstName) {
        getFirstName().clear();
        getFirstName().sendKeys(firstName);
    }

    public void setSecondName(String secondName) {
    	getSecondName().clear();
        getSecondName().sendKeys(secondName);
    }

    public void setMiddleName(String middleName) {
    	getMiddleName().clear();
        getMiddleName().sendKeys(middleName);
    }

    public void setEmail(String email) {
    	getEmail().clear();
        getEmail().sendKeys(email);
    }

    public void setLogin(String login) {
    	getLogin().clear();
        getLogin().sendKeys(login);
    }

    public void setPassword(String password) {
    	getPassword().clear();
        getPassword().sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
    	getConfirmPassword().clear();
        getConfirmPassword().sendKeys(confirmPassword);
    }

    public void setCity(String city) {
    	getCity().clear();
        getCity().sendKeys(city);
    }

    public void setRegion(String region) {
    	 getRegion().clear();
    	 getRegion().sendKeys(region);
    }

    public void setDistrict(String district) {
    	getDistrict().clear();
        getDistrict().sendKeys(district);
    }

    public void setStreet(String street) {
    	getStreet().clear();
        getStreet().sendKeys(street);
    }

    public void setBuilding(String building) {
    	getBuilding().clear();
        getBuilding().sendKeys(building);
    }

    public void setFlat(String flat) {
    	getFlat().clear();
        getFlat().sendKeys(flat);
    }

    public void setPostcode(String postcode) {
    	getPostcode().clear();
        getPostcode().sendKeys(postcode);
    }

    public void setPassportSeria(String passportSeria) {
    	getPassportSeria().clear();
        getPassportSeria().sendKeys(passportSeria);
    }

    public void setPassportNumber(String passportNumber) {
    	getPassportNumber().clear();
        getPassportNumber().sendKeys(passportNumber);
    }

    public void setPassportPublishedBy(String passportPublishedBy) {
    	getPassportPublishedBy().clear();
        getPassportPublishedBy().sendKeys(passportPublishedBy);
    }

    public void setPhoneNumber(String phoneNumber) {
    	getPhoneNumber().clear();
        getPhoneNumber().sendKeys(phoneNumber);
    }

    public void setCommunity(String communityName) {
        new Select(getCommunity()).selectByVisibleText(communityName);
    }

    public void setDateOfAccession(String dateOfAccession) {
        getDateOfAccession().sendKeys(dateOfAccession);
    }

    //Buttons click
    public CoownersElementsOnPageDropdown clickButtonSend() {
        driver.findElement(By.xpath(BUTTON_SEND_XPATH)).click();
        return new CoownersElementsOnPageDropdown(driver);
    }

    public void clickButtonClear() {
        driver.findElement(By.xpath(BUTTON_CLEAR_XPATH)).click();
    }

    public void clickButtonCancel() {
        driver.findElement(By.xpath(BUTTON_CANCEL_XPATH)).click();
    }

    public void registerNewUser(RegisteredUsers registeredUsers){
        setFirstName(registeredUsers.getFirstName());
        setSecondName(registeredUsers.getSecondName());
        setMiddleName(registeredUsers.getMiddleName());
        setEmail(registeredUsers.getEmail());
        setLogin(registeredUsers.getLogin());
        setPassword(registeredUsers.getPassword());
        setConfirmPassword(registeredUsers.getConfirmPassword());
        setCity(registeredUsers.getCity());
        setRegion(registeredUsers.getRegion());
        setDistrict(registeredUsers.getDistrict());
        setStreet(registeredUsers.getStreet());
        setBuilding(registeredUsers.getBuilding());
        setFlat(registeredUsers.getFlat());
        setPostcode(registeredUsers.getPostcode());
        setPassportSeria(registeredUsers.getPassportSeria());
        setPassportNumber(registeredUsers.getPassportNumber());
        setPassportPublishedBy(registeredUsers.getPassportPublishedBy());
        setPhoneNumber(registeredUsers.getPhoneNumber());
        setCommunity(registeredUsers.getCommunity());
       // clickButtonSend();
    }
	public static enum RegisterNewUserPageL10n {
	ERROR_MESSAGE_WHEN_INVALID_DATA_ENTERED("Підклас з вказаним іменем вже існує",
			"Подкласс с указаным наименованием уже существует",
				"The subclass with the specified name already exists"), DROPDOWN_DEFAULT_VALUE("Виберіть тип параметру",
						"Выберите тип параметра", "Choose type parameters");

		private HashMap<ChangeLanguageFields, String> field; // is different for every language

		private RegisterNewUserPageL10n(String... localization) {
			this.field = new HashMap<ChangeLanguageFields, String>();
			int i = 0;
			for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
				this.field.put(language, localization[i]);
				i++;
			}
		}

		public String getLocalization(ChangeLanguageFields language) {
			return this.field.get(language).trim();
		}
	}
}

