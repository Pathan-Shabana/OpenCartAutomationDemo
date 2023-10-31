package com.qa.opencart.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.listners.DriverFactory;
import com.qa.opencart.pages.CustomerLoginPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	public WebDriver driver;
	LoginPage lp;
	CustomerLoginPage clp;
	Properties prop;
	DriverFactory df=new DriverFactory();
	public BaseTest()
	{
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("./src/test/resources/configuration/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void setUp()
	{
		driver=df.initDriver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		lp= new LoginPage(driver);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
