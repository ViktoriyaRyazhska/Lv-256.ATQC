package com.regres.tests;

import com.regres.application.Application;
import com.regres.application.ApplicationSourcesRepo;
import com.regres.pages.AdminHomePage;
import com.regres.pages.LoginPage;
import com.regres.pages.manage.coowners.CoownersTable;
import com.regres.testdata.UserContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchInTable {
    private Application app;
    private LoginPage loginpage;
    private AdminHomePage adminhomepage;
    private CoownersTable coownerstable;

    @BeforeClass
    public void setUp() {
        app = Application.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
        loginpage = app.load();
        adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
        coownerstable = adminhomepage.goToNonConfirmedCoowners();
        coownerstable.getNonConfirmedCoowners();//вивести непідтверджених юзерів
        //coownersTable.setNumbeOfItemsInTable(); //вивести 100 позицій в таблиці, поставити вейтер
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        app.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        app.getDriver().close();
    }

    @Test
    public void searchInTable() {
        System.out.println(getListOfUsersFromTable(app.getDriver()));
        System.out.println(searchByFirstName("coo"));
        System.out.println(searchByFirstName("coo").size());
        System.out.println(searchByLastName("yarayar"));
        System.out.println(searchByLastName("yarayar").size());
        System.out.println(searchByLogin("12345"));
        System.out.println(searchByLogin("12345").size());
        System.out.println(searchByTerritorialCommunityName("Ukr"));
        System.out.println(searchByTerritorialCommunityName("Ukr").size());
        System.out.println(searchByFirstName(""));
        System.out.println(searchByFirstName("").size());

    }

    public List<User> searchByFirstName(String firstName) {
        List<User> userList = new ArrayList<User>();
        for (User u : getListOfUsersFromTable(app.getDriver())) {
            if (u.getFirstName().contains(firstName)) {
                userList.add(u);
            }
        }
        return userList;
    }

    public List<User> searchByLastName(String lastName) {
        List<User> userList = new ArrayList<User>();
        for (User u : getListOfUsersFromTable(app.getDriver())) {
            if (u.getLastName().contains(lastName)) {
                userList.add(u);
            }
        }
        return userList;
    }

    public List<User> searchByLogin(String login) {
        List<User> userList = new ArrayList<User>();
        for (User u : getListOfUsersFromTable(app.getDriver())) {
            if (u.getLogin().contains(login)) {
                userList.add(u);
            }
        }
        return userList;
    }

    public List<User> searchByTerritorialCommunityName(String TerritorialCommunityName) {
        List<User> userList = new ArrayList<User>();
        for (User u : getListOfUsersFromTable(app.getDriver())) {
            if (u.getTerritorialCommunityName().contains(TerritorialCommunityName)) {
                userList.add(u);
            }
        }
        return userList;
    }

    public List<User> getListOfUsersFromTable(WebDriver driver) {
        List<User> userList = new ArrayList<User>();
        List<WebElement> celllist = coownerstable.getALL_TABLE_BODY_CELL();//вибираємо всі комірки тіля таблиці
        int count = coownerstable.getTABLE_BODY_CELL_COUNT();//вирараховуємо кількість комірок
        for (int j = 0; j <= count - 8; j = j + 8) {//оскільки в рядку по 8 комірок втчитуємо коженя рядок
            userList.add(new User(
                    celllist.get(j + 0).getText(),
                    celllist.get(j + 1).getText(),
                    celllist.get(j + 2).getText(),
                    celllist.get(j + 3).getText(),
                    celllist.get(j + 4).getText(),
                    celllist.get(j + 5).getText(),
                    celllist.get(j + 6).getText(),
                    celllist.get(j + 7).getText()
            ));
        }
        return userList;
    }

    class User {
        String status;
        String firstName;
        String lastName;
        String login;
        String territorialCommunityName;
        String email;
        String role_type;
        String button;


        @Override
        public String toString() {
            return "User{" +
                    "status='" + status + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", login='" + login + '\'' +
                    ", territorialCommunity_name='" + territorialCommunityName + '\'' +
                    ", email='" + email + '\'' +
                    ", role_type='" + role_type + '\'' +
                    ", button='" + button + '\'' +
                    '}';
        }

        public User(String status, String firstName, String lastName, String login, String territorialCommunityName, String email, String role_type, String button) {
            this.status = status;
            this.firstName = firstName;
            this.lastName = lastName;
            this.login = login;
            this.territorialCommunityName = territorialCommunityName;
            this.email = email;
            this.role_type = role_type;
            this.button = button;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getTerritorialCommunityName() {
            return territorialCommunityName;
        }

        public void setTerritorialCommunity_name(String territorialCommunity_name) {
            this.territorialCommunityName = territorialCommunity_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRole_type() {
            return role_type;
        }

        public void setRole_type(String role_type) {
            this.role_type = role_type;
        }

        public String getButton() {
            return button;
        }

        public void setButton(String button) {
            this.button = button;
        }

    }
}

