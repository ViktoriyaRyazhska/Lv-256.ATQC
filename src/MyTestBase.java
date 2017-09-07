import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.fail;
public class MyTestBase {
	static protected WebDriver driver;
    protected String baseURL;
    protected StringBuffer verificationErrors = new StringBuffer();

    @BeforeSuite
    public void setUp() throws Exception {

        System.setProperty("webdriver.gecko.driver", "D:\\1\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseURL = "http://regres.herokuapp.com/login";

    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
