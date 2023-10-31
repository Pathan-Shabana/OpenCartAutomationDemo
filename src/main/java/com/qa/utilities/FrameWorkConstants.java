package com.qa.utilities;

public class FrameWorkConstants {
	private static final String CHROMEDRIVER_PATH=System.getProperty("user.dir")+"\\driverexecutables\\chromedriver.exe";
	private static final String FIREFOXDRIVER_PATH=System.getProperty("user.dir")+"\\driverexecutables\\geckodriver.exe";
	private static final String LOGINPAGE_TITLE="Home Page";
	private static final String CUSTOMER_LOGINPAGE_TITLE="Customer Login";

	public static String getLoginpageTitle() {
		return LOGINPAGE_TITLE;
	}

	public static String getCustomerLoginpageTitle() {
		return CUSTOMER_LOGINPAGE_TITLE;
	}

	public static String getChromedriverPath() {
		return CHROMEDRIVER_PATH;
	}

	public static String getFirefoxdriverPath() {
		return FIREFOXDRIVER_PATH;
	}
	

}
