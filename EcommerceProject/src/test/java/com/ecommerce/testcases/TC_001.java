package com.ecommerce.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.pageObject.AuthencationPage;
import com.ecommerce.pageObject.CreateAccountPage;
import com.ecommerce.pageObject.HomePage;
import com.ecommerce.pageObject.LoggedInPage;

public class TC_001 extends BaseClass {
	
	public String Email;
	@Test(priority = 1)
	public void homePage() throws Exception {
		HomePage hPage=PageFactory.initElements(driver, HomePage.class);
		hPage.clickonSignin();
		logger.info("Clicked on signin");
		captureScreen(driver, "homePage");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
	}
	
	@Test(priority = 2)
	public void createEmail() throws Exception {
		AuthencationPage acPage=PageFactory.initElements(driver, AuthencationPage.class);
		String text=acPage.readPageHeading();
		System.out.println(text);
		if(text.equals("AUTHENTICATION")) {
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver, "createEmail");
			Assert.assertTrue(false);
		}
		
		String emailStart=RandomStringUtils.randomAlphabetic(5);
		Email=emailStart+"@gmail.com";
		acPage.passEmail(Email);
		captureScreen(driver, "EmailPassed");
		logger.info("Email Passed");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test(priority = 3)
	public void enterDetails() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		CreateAccountPage caPage = PageFactory.initElements(driver, CreateAccountPage.class);
		caPage.clickOnRadio();
		caPage.firstName("Rocky");
		caPage.lastName("German Shepherd");
		caPage.password("RockyGS");
		caPage.DateOfBirth();
		String addFrstName=caPage.validateFisrtName();
		String addLstName=caPage.validateLastName();
		if(addFrstName.equals("Rocky") && addLstName.equals("German Shepherd")) {
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver, "enterDetails");
			Assert.assertTrue(false);
		}
		caPage.companyName("Harvey Specter LLC");
		caPage.address("HarveySpecter at mikeRoss at louisLitt");
		caPage.city("Cincinati");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		caPage.state("Oklahoma");
		caPage.zipCode("45634");
		caPage.country("United States");
		caPage.mobileNum("1575346622");
		caPage.assignAdd();
		captureScreen(driver, "Details Added");
		logger.info("Details Added");
		caPage.submitForm();
	}
	
	@Test(priority = 4)
	public void signOutTest() throws Exception {
		LoggedInPage liPage=PageFactory.initElements(driver, LoggedInPage.class);
		liPage.signOut();
		captureScreen(driver, "signedOut");
		logger.info("Signed out successfully");
		
	}
	
	@Test(priority = 5)
	public void logInTest() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		logger.debug("debugging");
		AuthencationPage atPage=PageFactory.initElements(driver, AuthencationPage.class);
		atPage.loginEmail(Email, "RockyGS");
		String UsrAccName=atPage.userAccountName();
		System.out.println(UsrAccName);
		if(UsrAccName.equals("Rocky German Shepherd")) {
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver, "logInTest");
			Assert.assertTrue(false);
		}
		captureScreen(driver, "LoggedIn");
		logger.info("userName retrived successfully");
	}

}
