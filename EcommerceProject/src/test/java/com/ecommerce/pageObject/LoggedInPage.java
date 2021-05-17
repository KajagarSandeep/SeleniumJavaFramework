package com.ecommerce.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInPage {

	WebDriver driver;
	
	By signOut=By.xpath("//a[@title='Log me out']");
	
	public LoggedInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void signOut() {
		driver.findElement(signOut).click();
	}
	
	
	
}
