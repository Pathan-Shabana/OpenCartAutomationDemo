package com.qa.listners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utilities.FrameWorkConstants;

public class DriverFactory {
	
	WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();
	public WebDriver initDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", FrameWorkConstants.getChromedriverPath());
		
			tlDriver.set(new ChromeDriver());
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", FrameWorkConstants.getFirefoxdriverPath());
			tlDriver.set(new FirefoxDriver());
		}
		return getDriver();
		
		
	}
	public static synchronized WebDriver getDriver() {
		
		return tlDriver.get();
	}
	public String getScreenshotPath()
	{
		File source=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return path;
	}

}
