package com.ecommerce.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthencationPage {
	
	
	WebDriver driver;
	
	By pageHeading=By.xpath("//h1[@class='page-heading']");
	By enterEmail=By.xpath("//input[@id='email_create']");
	By createAccountButton=By.xpath("//button[@id='SubmitCreate']");
	By loginEmail=By.xpath("//input[@id='email']");
	By loginPassword=By.xpath("//input[@id='passwd']");
	By submitLogin=By.xpath("//button[@id='SubmitLogin']");
	By userAccountName=By.xpath("//a[@title='View my customer account']/span");
	
	public AuthencationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String readPageHeading() {
		String pgHeading=driver.findElement(pageHeading).getText();
		return pgHeading;
	}
	
	public void passEmail(String Email) {
		driver.findElement(enterEmail).sendKeys(Email);
		driver.findElement(createAccountButton).click();
		
	}
	
	public void loginEmail(String Email,String password) {
		driver.findElement(loginEmail).sendKeys(Email);
		driver.findElement(loginPassword).sendKeys(password);
		driver.findElement(submitLogin).click();
	}
	
	public String userAccountName() {
		String uAccName=driver.findElement(userAccountName).getText();
		return uAccName;
	}
}
