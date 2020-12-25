package com.ohm.utilities;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ohm.qa.Constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserfactory {

	public static WebDriver driver = null;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	static Logger logger=Logger.getLogger("OHM");
	public static WebDriver initialize()
	{
		if(driver == null){
			if(Constants.browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(Constants.browserName.equalsIgnoreCase("ff")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		logger.info("Browser Opened");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.pageLoadTimeout, TimeUnit.SECONDS);
		logger.info("Page Load wait given");
		driver.manage().window().maximize();
		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		driver = e_driver;

		driver.get(Constants.URL);
		logger.info("Url opened");

		return driver;
	}


	public static void quit() {
		driver.quit();
		driver = null;
		logger.info("Browser Closed");

	}
}
