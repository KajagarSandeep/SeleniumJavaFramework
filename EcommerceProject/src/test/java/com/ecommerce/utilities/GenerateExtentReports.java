package com.ecommerce.utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReports implements ITestListener {
	
	ExtentReports extent;
	ExtentTest logger;
	ExtentSparkReporter spark;
	
	public void onStart(ITestContext testContext) {
		//To create file name
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());
		String repoName="report"+"_"+timeStamp+".html";
		
		// to store the extent repots
		extent= new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/"+repoName);
		
		extent.attachReporter(spark);
		
		//Setting up system details
		extent.setSystemInfo("Host Name","eCommerce.com");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("UserID","t12346a");
		
		//setting up Report details
		spark.config().setDocumentTitle("Ecommerce");
		spark.config().setReportName("Regression Testing");
		spark.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult result) {
		logger=extent.createTest(result.getName());
		logger.generateLog(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult result) {
		logger=extent.createTest(result.getName());
		logger.generateLog(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
		String screenShotPath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
		
		File f=new File(screenShotPath);
		
		if(f.exists()) {
			try {
				logger.addScreenCaptureFromPath(screenShotPath);
			}
			catch(Exception exp) {
				System.out.println(exp.getMessage());
			}
		}
	}
	
	public void onTestSkipper(ITestResult result) {
		logger=extent.createTest(result.getName());
		logger.generateLog(Status.SKIP, MarkupHelper.createLabel(result.getName(),ExtentColor.AMBER));
		
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
