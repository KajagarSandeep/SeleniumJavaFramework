package com.ecommerce.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
	
	WebDriver driver;
	
	By radioButton=By.xpath("//span/input[@id='id_gender1']");
	By firstName=By.xpath("//input[@id='customer_firstname']");
	By lastName=By.xpath("//input[@id='customer_lastname']");
	By passwrd=By.xpath("//input[@id='passwd']");
	By day=By.xpath("//select[@id='days']");
	By Month=By.xpath("//select[@id='months']");
	By year=By.xpath("//select[@id='years']");
	By addressFN=By.xpath("//input[@id='firstname']");
	By addressLN=By.xpath("//input[@id='lastname']");
	By company=By.xpath("//input[@id='company']");
	By address=By.xpath("//input[@id='address1']");
	By city=By.xpath("//input[@id='city']");
	By state=By.xpath("//*[@id=\"id_state\"]");
	By zipCode=By.xpath("//input[@id='postcode']");
	By country=By.xpath("//select[@id='id_country']");
	By mobilePhone=By.xpath("//input[@id='phone_mobile']");
	By assignAddress=By.xpath("//button[@id='submitAccount']");
	By submitButton=By.xpath("//button[@id='submitAccount']");

	
	
	
	
	public CreateAccountPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void clickOnRadio() {
		driver.findElement(radioButton).click();
	}
	
	public void firstName(String fName) {
		driver.findElement(firstName).sendKeys(fName);
	}
	public void lastName(String lName) {
		driver.findElement(lastName).sendKeys(lName);
	}
	public void password(String password) {
		driver.findElement(passwrd).sendKeys(password);
	}
	
	public void DateOfBirth() {
		WebElement days=driver.findElement(day);
		Select dobDays=new Select(days);
		dobDays.selectByValue("23");
		
		WebElement month=driver.findElement(Month);
		Select dobMonths=new Select(month);
		dobMonths.selectByValue("12");
		
		WebElement years=driver.findElement(year);
		Select dobYears=new Select(years);
		dobYears.selectByValue("2011");
	}
	
	public String validateFisrtName() {
		String addFN=driver.findElement(addressFN).getAttribute("value");
		return addFN;
	}
	
	public String validateLastName() {
		String addLN=driver.findElement(addressLN).getAttribute("value");
		return addLN;
	}
	
	public void companyName(String cmpnyName) {
		driver.findElement(company).sendKeys(cmpnyName);
	}
	
	public void address(String fullAddress) {
		driver.findElement(address).sendKeys(fullAddress);
	}
	
	public void city(String cityName) {
		driver.findElement(city).sendKeys(cityName);
	}
	
	public void state(String stateName) {
		WebElement stName=driver.findElement(state);
		Select sName=new Select(stName);
		sName.selectByIndex(34);;
	}
	
	public void zipCode(String zpCode) {
		driver.findElement(zipCode).sendKeys(zpCode);
	}
	
	public void country(String cntry) {
		WebElement cntryName=driver.findElement(country);
		Select cntName=new Select(cntryName);
		cntName.selectByIndex(1);;
	}
	
	public void mobileNum(String phoneNumber) {
		driver.findElement(mobilePhone).sendKeys(phoneNumber);
	}
	
	public void assignAdd() {
		driver.findElement(assignAddress).sendKeys("Hello");
	}
	
	public void submitForm() {
		driver.findElement(submitButton).click();
	}

}
