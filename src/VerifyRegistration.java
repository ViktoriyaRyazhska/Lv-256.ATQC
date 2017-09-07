import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class VerifyRegistration extends MyTestBase {

	@Test
	  public void test1() throws Exception {
		driver.get(baseURL);
	    driver.findElement(By.linkText("Зареєструватися")).click();
	    driver.findElement(By.id("firstName")).clear();
	    driver.findElement(By.id("firstName")).sendKeys("test");
	    driver.findElement(By.id("lastName")).clear();
	    driver.findElement(By.id("lastName")).sendKeys("test");
	    driver.findElement(By.id("middleName")).clear();
	    driver.findElement(By.id("middleName")).sendKeys("test");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("test.pm300@gmail.com");
	    driver.findElement(By.id("login")).clear();
	    driver.findElement(By.id("login")).sendKeys("testpm3000");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("Mk123456");
	    driver.findElement(By.id("confirmPassword")).clear();
	    driver.findElement(By.id("confirmPassword")).sendKeys("Mk123456");
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("Lviv");
	    driver.findElement(By.id("region")).clear();
	    driver.findElement(By.id("region")).sendKeys("Lviv");
	    driver.findElement(By.id("district")).clear();
	    driver.findElement(By.id("district")).sendKeys("Lviv");
	    driver.findElement(By.id("street")).clear();
	    driver.findElement(By.id("street")).sendKeys("Volodymyra");
	    driver.findElement(By.id("building")).clear();
	    driver.findElement(By.id("building")).sendKeys("70");
	    driver.findElement(By.id("flat")).clear();
	    driver.findElement(By.id("flat")).sendKeys("70");
	    driver.findElement(By.id("postcode")).clear();
	    driver.findElement(By.id("postcode")).sendKeys("81037");
	    driver.findElement(By.id("passport_seria")).clear();
	    driver.findElement(By.id("passport_seria")).sendKeys("");
	    driver.findElement(By.id("passport_number")).clear();
	    driver.findElement(By.id("passport_number")).sendKeys("");
	    driver.findElement(By.id("published_by_data")).clear();
	    driver.findElement(By.id("published_by_data")).sendKeys("");
	    driver.findElement(By.id("phone_number")).clear();
	    driver.findElement(By.id("phone_number")).sendKeys("0979797789");
	    new Select(driver.findElement(By.id("territorial_Community"))).selectByVisibleText("Україна");
	    driver.findElement(By.id("submit")).click();
	    
	    assertEquals(driver.findElement(By.cssSelector("p")).getText(), "Вітаємо - реєстрація майже завершина. Для завершення реєстрації Вам потрібно пройти по посиланню, яке було відправлено на Ваш e-mail.");
	    assertEquals(driver.findElement(By.linkText("Повернутись на головну")).getText(), "Повернутись на головну");
	  }
}
