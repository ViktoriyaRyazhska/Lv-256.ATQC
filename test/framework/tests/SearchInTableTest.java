package framework.tests;

import framework.application.Application;
import framework.application.ApplicationSourcesRepo;
import framework.pages.AdminHomePage;
import framework.pages.LoginPage;
import framework.pages.coowners.actions.CoownersTable;
import framework.testdata.UserContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchInTableTest {
    WebDriver driver;
    private Application app;
    private LoginPage loginpage;
    private AdminHomePage adminhomepage;

    @BeforeClass
    public void setUp() {
        app = app.get(ApplicationSourcesRepo.getFirefoxHerokuApplication());
        loginpage = app.load();
        adminhomepage = loginpage.successfullLoginAdmin(UserContainer.getAdmin());
    }

    @AfterClass
    public void tearDown() {
        app.quit();
    }

    @Test
    public void searchInTable() {
        CoownersTable coownersTable = adminhomepage.goToNonConfirmedCoowners();
        coownersTable.getNonConfirmedCoowners();
        usersFromTable(driver);

    }

    public void usersFromTable(WebDriver driver) {
        List<User> userList=new ArrayList<User>();
        WebElement table_element = driver.findElement(By.id("example"));
        List<WebElement> tr_collection=driver.findElements(By.xpath("//id('example')/tbody/tr"));
        System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
        int row_num;
        int col_num;
        row_num=1;
        for(WebElement trElement : tr_collection)
        {
            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
            System.out.println("NUMBER OF COLUMNS="+td_collection.size());
            col_num=1;
            for(WebElement tdElement : td_collection)
            {
                System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
                col_num++;
            }
            row_num++;
        }
    }
    class User {
        String firstName;
        String lastName;
        String login;
        String territorialCommunity_name;
        String role_type;

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

        public String getRole_type() {
            return role_type;
        }

        public void setRole_type(String role_type) {
            this.role_type = role_type;
        }

        public User(String firstName, String lastName, String login, String territorialCommunity_name, String role_type) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.login = login;
            this.territorialCommunity_name = territorialCommunity_name;
            this.role_type = role_type;
        }
    }
}


