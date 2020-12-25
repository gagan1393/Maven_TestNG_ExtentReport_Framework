package com.ohm.Testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ohm.qa.Constants.Constants;
import com.ohm.utilities.Browserfactory;
import com.ohm.utilities.TestUtility;

public class BaseTest {
	static ExtentReports extent;
	static ExtentTest logger;

	@BeforeSuite
	public void precondition()
	{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(Constants.EXTENT_REPORT_PATH);
		extent = new ExtentReports(); 
		extent.attachReporter(reporter);


	}

	@BeforeClass
	public void setup()
	{
		Browserfactory.initialize();
	}

	@AfterClass
	public void teardown()
	{
		Browserfactory.quit();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{

		if(result.getStatus()==ITestResult.FAILURE)
		{
			String temp=TestUtility.getScreenshot(Browserfactory.driver, result.getName());
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			logger.fail("Test Failed");
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			TestUtility.getScreenshot(Browserfactory.driver, result.getName());
			logger.skip("Test Skipped");
		}
		extent.flush();
	}


}
