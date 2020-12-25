package com.ohm.Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ohm.qa.Constants.Constants;
import com.ohm.utilities.Browserfactory;
import com.ohm.utilities.TestUtility;



public class test_ohm_logintest extends BaseTest
{
	private By emailId = By.id("txtUsername");
	private By pwd = By.id("txtPassword");
	private By signInButton = By.id("btnLogin");
	private By Invalid_message = By.id("spanMessage");
	
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object data [][]  = TestUtility.getTestData("login");
		return data;
	}
	
	
	@Test(dataProvider = "getTestData")
	public void verifyloginTest(String username, String password)
	{
		logger=extent.createTest("verifyloginTest");
		TestUtility.sendKeys(Browserfactory.driver, Browserfactory.driver.findElement(emailId), 5, username);
		TestUtility.sendKeys(Browserfactory.driver, Browserfactory.driver.findElement(pwd), 5, password);
		TestUtility.clickOn(Browserfactory.driver, Browserfactory.driver.findElement(signInButton), 5);
		String invalidcrediantials = TestUtility.get_Text_of_an_element(Browserfactory.driver, Invalid_message, 5);
		Assert.assertEquals(invalidcrediantials, Constants.Actual_invalidcreatial);
		logger.log(Status.PASS, "Login Test verified");
	}
	

}
