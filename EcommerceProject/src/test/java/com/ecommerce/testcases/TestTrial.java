package com.ecommerce.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ecommerce.pageObject.AuthencationPage;
import com.ecommerce.pageObject.CreateAccountPage;
import com.ecommerce.pageObject.HomePage;
import com.ecommerce.pageObject.LoggedInPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTrial {
	
	static WebDriver driver;
	public static String Email="";
	
	@BeforeClass
	public static void setup() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	driver.get("http://automationpractice.com/index.php");

	}
	@Test(priority = 1)
	public static void testCase1() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		HomePage hPage=new HomePage(driver);
		hPage.clickonSignin();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		AuthencationPage acPage=new AuthencationPage(driver);
		String text=acPage.readPageHeading();
		System.out.println(text);
		if(text.equals("AUTHENTICATION")) {
			Assert.assertEquals(true, true);
		}
		else {
			Assert.assertEquals(true, false);
		}
	}
	@Test(priority = 2)
	public static void createEmail() {
		String emailStart=RandomStringUtils.randomAlphabetic(6);
		Email=emailStart+"@gmail.com";
		AuthencationPage acPage=new AuthencationPage(driver);
		acPage.passEmail(Email);
	}
	
	@Test(priority = 3)
	public static void enterDetails() {
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		CreateAccountPage caPage=new CreateAccountPage(driver);
		caPage.clickOnRadio();
		caPage.firstName("rocky");
		caPage.lastName("GS");
		caPage.password("rockyGS");
		caPage.DateOfBirth();
		String addFrstName=caPage.validateFisrtName();
		String addLstName=caPage.validateLastName();
		if(addFrstName.equals("rocky") && addLstName.equals("GS")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		caPage.companyName("harveySpecter LLC");
		caPage.address("HareySpect near mike ross on luis lit");
		caPage.city("Cincinati");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		caPage.state("Oklahoma");
		caPage.zipCode("46527");
		caPage.country("United States");
		caPage.mobileNum("1575346622");
		caPage.assignAdd();
		caPage.submitForm();
	}
	
	@Test(priority = 4)
	public static void signOutTest() {
		LoggedInPage liPage= new LoggedInPage(driver);
		liPage.signOut();
	}
	
	@Test(priority=5)
	public static void logInTest() {
		AuthencationPage atPage=new AuthencationPage(driver);
		atPage.loginEmail(Email, "rockyGS");
		String UsrAccName=atPage.userAccountName();
		System.out.println(UsrAccName);
	}
//	@AfterClass
//	public static void tearDown() {
//		driver.quit();
//	}

}
