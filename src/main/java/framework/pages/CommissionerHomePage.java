package main.java.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class representation of a Commissioner home page.
 *
 * @author Kryvenko Yaroslava
 */
public abstract class CommissionerHomePage extends DropdownHomePage{
		public WebElement coowners;		
		public WebElement active;
		public WebElement inactive;
		public WebElement nonConfirmed;
		public WebElement blocked;
		public CommissionerHomePage (WebDriver driver) {
			super(driver);
			coowners=driver.findElement(By.xpath("//a[@data-toggle=\"dropdown\"]"));
			active=driver.findElement(By.xpath("//a[contains(@href,\"get-all-users\")]"));
			inactive=driver.findElement(By.cssSelector(".dropdown-menu [href$='inactive']"));
			nonConfirmed=driver.findElement(By.xpath("//a[contains(@href,\"notcomfirmed\")]"));
			blocked=driver.findElement(By.xpath("//a[contains(@href,\"block\")]"));			
		}

		public WebElement getCoowners() {
			return coowners;
		}
		public void setCoowners(WebElement coowners) {
			this.coowners = coowners;
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
			return nonConfirmed;
		}
		public void setNonConfirmfd(WebElement nonConfirmfd) {
			this.nonConfirmed = nonConfirmfd;
		}
		public WebElement getBlocked() {
			return blocked;
		}
		public void setBlocked(WebElement blocked) {
			this.blocked = blocked;
		}
	}

