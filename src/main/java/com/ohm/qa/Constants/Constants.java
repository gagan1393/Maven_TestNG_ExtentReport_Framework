package com.ohm.qa.Constants;

public class Constants {
	
	public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/Drivers/chromedriver.exe";
	public static final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/Drivers/geckodriver.exe";
	public static String browserName = "ff";
	public static String URL = "https://opensource-demo.orangehrmlive.com/";
	public static long pageLoadTimeout = 20;
	public static long implicitlyWait = 10;
	public static String Asserttitle = "OrangeHRM";
	public static String LOGO_HEADER = "LOGIN Panel";
	public static final int SHORT_WAIT = 3000;
	public static final int MEDIUM_WAIT = 6000;
	public static final int LONG_WAIT = 10000;
	public static final String TEST_DATA_SHEET_PATH = System.getProperty("user.dir") + "/src/main/java/com/ohm/qa/TestData/Book1.xlsx";
	public static final String EXTENT_REPORT_PATH = System.getProperty("user.dir") + "/src/test/resources/Reports/ohm_extentreport.html";
	public static String Actual_invalidcreatial = "Invalid credentials";
	
}
