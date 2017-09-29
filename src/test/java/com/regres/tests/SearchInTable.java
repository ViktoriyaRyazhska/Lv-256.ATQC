package com.regres.tests;

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
    private WebDriver driver;
    private String baseURL;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        baseURL = "http://regres.herokuapp.com";
        driver.get(baseURL);
        LoginPage loginpage = new LoginPage(driver);
        AdminHomePage adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
        CoownersTable coownersTable = adminhomepage.goToNonConfirmedCoowners();
        coownersTable.getNonConfirmedCoowners();
        coownersTable.setNumbeOfItemsInTable();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @Test
    public void searchInTable() {
//        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//        List<WebElement> tr_collection = driver.findElements(By.xpath("//table/tbody/tr"));
//        System.out.println(tr_collection.toString());
//        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//        WebElement element = driver.findElement(By.xpath(".//*[@id='example']/tbody"));
//        List<WebElement> rowCollection = element.findElements(By.xpath("//*[@id='example']/tbody/tr"));
//        System.out.println("Numer of rows in this table: " + rowCollection.size());
        usersFromTable(driver);

    }

    public void usersFromTable(WebDriver driver) {
        List<User> userList = new ArrayList<User>();
        List<WebElement> td_collection = driver.findElements(By.xpath("//*[@id='example']/tbody/tr/td"));
        System.out.println("td_collection size "+td_collection.size());
        List<String> list= new ArrayList<String>();
        int count=0;
        for (WebElement td : td_collection) {
            list.add(td.getText());
            count++;
        }
        System.out.println(list);
        for (int j=0;j<=count-8;j=j+8) {
//            for (int i = 0; i <= 7; i++) {
////                td_collection.get(j+i).getText();
//

            userList.add(ser

                    new User(
                    td_collection.get(j+0).getText(),
                    td_collection.get(j+1).getText(),
                    td_collection.get(j+2).getText(),
                    td_collection.get(j+3).getText(),
                    td_collection.get(j+4).getText(),
                    td_collection.get(j+5).getText(),
                    td_collection.get(j+6).getText(),
                    td_collection.get(j+7).getText()
            ));
        }

        System.out.println(userList);
//            for (WebElement tdElement : td_collection) {
//                userList.add(new User(
//                        tdElement.findElement(By.cssSelector(".status")).getText(),
//                        tdElement.findElement(By.cssSelector(".firstName")).getText(),
//                        tdElement.findElement(By.cssSelector(".lastName")).getText(),
//                        tdElement.findElement(By.cssSelector(".login.sorting_1")).getText(),
//                        tdElement.findElement(By.cssSelector(".territorialCommunity_name")).getText(),
//                        tdElement.findElement(By.cssSelector(".email")).getText(),
//                        tdElement.findElement(By.cssSelector(".role_type")).getText())
//                );
//            }
    }
    class User {
        String status;
        String firstName;
        String lastName;
        String login;
        String territorialCommunity_name;
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
                    ", territorialCommunity_name='" + territorialCommunity_name + '\'' +
                    ", email='" + email + '\'' +
                    ", role_type='" + role_type + '\'' +
                    ", button='" + button + '\'' +
                    '}';
        }

        public User(String status, String firstName, String lastName, String login, String territorialCommunity_name, String email, String role_type, String button) {
            this.status = status;
            this.firstName = firstName;
            this.lastName = lastName;
            this.login = login;
            this.territorialCommunity_name = territorialCommunity_name;
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

        public String getTerritorialCommunity_name() {
            return territorialCommunity_name;
        }

        public void setTerritorialCommunity_name(String territorialCommunity_name) {
            this.territorialCommunity_name = territorialCommunity_name;
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
