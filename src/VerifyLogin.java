import org.testng.annotations.Test;
import org.openqa.selenium.By;
import static org.testng.Assert.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyLogin extends MyTestBase {

	@Test
	public void testValidLoginAndPassword() throws Exception {

		driver.get(baseURL);
		fillLoginForm("andriy", "andriy");
		submitLoginForm();
		VerifyLoginMessage();
	}

	@Test
	public void testEmptyLoginAndPassword() throws Exception {
		
		driver.get(baseURL);
		fillLoginForm("","");
		submitLoginForm();
		VerifyErrorMessage();
	}

	@Test
	public void testInvalidLoginAdnInvalidPass() throws Exception {
		
		driver.get(baseURL);
		fillLoginForm("test","Lk123456");
		submitLoginForm();
		VerifyErrorMessage();
	}

	@Test
	public void testValidLoginAdnInvalidPass() throws Exception {
		
		driver.get(baseURL);
		fillLoginForm("andriy","123456WQ");
		submitLoginForm();
		VerifyErrorMessage();
	}
	@Test
	public void testInvalidLoginAdnValidPass() throws Exception {
		
		driver.get(baseURL);
		fillLoginForm("test12","andriy");
		submitLoginForm();
		VerifyErrorMessage();
	}
	
	private void fillLoginForm(String email, String password) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(email);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
	}

	private void submitLoginForm() {

		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

	}

	private void VerifyErrorMessage() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginForm > div")));
		assertEquals(driver.findElement(By.cssSelector("#loginForm > div")).getText(), "Неправильний логін або пароль");
	}

	private void VerifyLoginMessage() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='header']/div/h3[1]")));
		assertEquals(driver.findElement(By.xpath("//div[@id='header']/div/h3[1]")).getText(),  "Децентралізований майновий реєстр");
		assertEquals(driver.findElement(By.xpath("//div[@id='header']/div[2]/div/div/button")).getText(),  "andriy");
		
	}
}
