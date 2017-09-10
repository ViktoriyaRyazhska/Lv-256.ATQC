import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminHomePage {
	private WebDriver driver;
	private WebElement firstname;
	private WebElement logout;
	private WebElement administration;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;

		firstname = driver.findElement(By.xpath("//tbody/tr/td[text( )='First name']/following-sibling::td"));
		logout = driver.findElement(By.id("logout"));
		administration = driver.findElement(By.xpath("//a[text( )='Administration']"));
	}

	public LoginPage logout() {
		logout.click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		return new LoginPage(driver);
	}

	public WebElement getFirstname() {
		return firstname;
	}
}