package com.ecommerce.testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ecommerce.utilities.ReadConfigFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	ReadConfigFile getValue=new ReadConfigFile();
	public String BaseURL= getValue.baseURL();
	
	Logger logger= org.apache.logging.log4j.LogManager.getLogger(BaseClass.class);
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browserName) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get(BaseURL);
		logger.info("Successfully passed URL");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		logger.info("browser window closed");
		driver.quit();
		logger.info("browser window quit");
	}
	
	public void captureScreen(WebDriver driver,String tname) throws Exception {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot Taken");
	}

}
