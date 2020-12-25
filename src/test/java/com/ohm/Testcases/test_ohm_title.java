package com.ohm.Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ohm.qa.Constants.Constants;
import com.ohm.utilities.Browserfactory;
import com.ohm.utilities.TestUtility;

public class test_ohm_title extends BaseTest
{
	private By Logo_img= By.xpath("//div[@id='divLogo']//img");
	private By Header= By.xpath("//div[@id='logInPanelHeading']");
	
	@Test(priority = 1)
	public void verify_ohm_title()
	{
		logger=extent.createTest("verify_ohm_title");
		String title = Browserfactory.driver.getTitle();
		System.out.println("The Page title is "+ title);
		Assert.assertEquals(title, Constants.Asserttitle);
		logger.log(Status.PASS, "Title verified");
	}
	
	@Test(priority = 2)
	public void verify_ohm_Logo()
	{
		logger=extent.createTest("verify_ohm_Logo");
		Assert.assertTrue(TestUtility.isElementDisplayed(Browserfactory.driver.findElement(Logo_img)));
		logger.log(Status.PASS, "Logo verified");
	}
	
	@Test(priority = 3)
	public void verify_ohm_login_header()
	{
		logger=extent.createTest("verify_ohm_login_header");
		String Logo_Header = TestUtility.get_Text_of_an_element(Browserfactory.driver, Header, 5);
		Assert.assertEquals(Logo_Header, Constants.LOGO_HEADER);
		logger.log(Status.PASS, "Logo Header verified");
	}

}
