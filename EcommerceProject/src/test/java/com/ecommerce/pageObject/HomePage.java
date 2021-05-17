package com.ecommerce.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	By signIn=By.xpath("//a[@title='Log in to your customer account']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickonSignin() {
		driver.findElement(signIn).click();
	}
	
	
	

}
