package com.tests;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestExtentReports {

	WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest logger;

	@BeforeClass
	public void beforeClass()
	{

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ms");
		String path= System.getProperty("user.dir")+"/extent-reports/" + sdf.format(new Date())+ ".html";
		htmlreporter=new ExtentHtmlReporter(path);
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		reports.setSystemInfo("username", "farheen.m.sulthana");
		reports.setSystemInfo("host", "localhost");
		reports.setSystemInfo("Environment", "TestEnvironment");

		htmlreporter.config().setReportName("Test Me App Report");
	}
	/*
	 * @Test public void failTest() { reports.createTest("failTest");
	 * logger.log(Status.INFO, "fail is started"); Assert.assertTrue(false); }
	 */
	
	  @Test public void passTest() { reports.createTest("passTest");
	  logger.log(Status.INFO,  MarkupHelper.createLabel("Inside Pass Test", ExtentColor.GREEN));
	  Assert.assertTrue(true); }
	 


	/*
	 * @Test public void skipTest() { reports.createTest("skipTest");
	 * logger.log(Status.INFO, "skip is started"); throw new SkipException("Skip");
	 * }
	 */

	@AfterMethod 
	public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) { 
			logger.log(Status.PASS, MarkupHelper.createLabel("This Passed!", ExtentColor.GREEN));
			}
		else if(result.getStatus()==ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel("This Skipped!", ExtentColor.AMBER)); }
		else if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel("This Failed!", ExtentColor.RED)); }

	}

	@AfterClass
	public void afterClass()
	{
		
		reports.flush();
		driver.close();

	}

}

