package main.java.framework.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommisionerHomePage {
		public WebDriver driver;
		public WebElement coowners;
		public WebElement registration;
		public WebElement active;
		public WebElement inactive;
		public WebElement nonConfirmfd;
		public WebElement blocked;
		public CommisionerHomePage (WebDriver driver) {
			this.driver=driver;
			coowners=driver.findElement(By.xpath("//a[@data-toggle=\"dropdown\"]"));
			active=driver.findElement(By.xpath("//a[contains(@href,\"get-all-users\")]"));
			inactive=driver.findElement(By.cssSelector(".dropdown-menu [href$='inactive']"));
			nonConfirmfd=driver.findElement(By.xpath("//a[contains(@href,\"notcomfirmed\")]"));
			blocked=driver.findElement(By.xpath("//a[contains(@href,\"block\")]"));
			registration=driver.findElement(By.partialLinkText("Зареєструвати співвласника"));
		}
		public WebDriver getDriver() {
			return driver;
		}
		public void setDriver(WebDriver driver) {
			this.driver = driver;
		}
		public WebElement getCoowners() {
			return coowners;
		}
		public void setCoowners(WebElement coowners) {
			this.coowners = coowners;
		}
		public WebElement getRegistration() {
			return registration;
		}
		public void setRegistration(WebElement registration) {
			this.registration = registration;
		}
		public WebElement getActive() {
			return active;
		}
		public void setActive(WebElement active) {
			this.active = active;
		}
		public WebElement getInactive() {
			return inactive;
		}
		public void setInactive(WebElement inactive) {
			this.inactive = inactive;
		}
		public WebElement getNonConfirmfd() {
			return nonConfirmfd;
		}
		public void setNonConfirmfd(WebElement nonConfirmfd) {
			this.nonConfirmfd = nonConfirmfd;
		}
		public WebElement getBlocked() {
			return blocked;
		}
		public void setBlocked(WebElement blocked) {
			this.blocked = blocked;
		}
	}

}
