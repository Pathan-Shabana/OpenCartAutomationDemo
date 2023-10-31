package com.qa.listners;


import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportListener extends DriverFactory implements ITestListener {


	String folder="./build/";
	String file="htmlreport";
	ExtentReports extentreport=init();
	ExtentTest extenttest;
	

	private static final ThreadLocal<ExtentTest> test=new ThreadLocal<>();
	

	public ExtentReports init()
	{
		Path path=Paths.get(folder);
		if(!Files.exists(path))
		{
			try {
				Files.createDirectories(path);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(folder+file);
		sparkreporter.config().setDocumentTitle("OpenCart Automation Test Results");
		sparkreporter.config().setReportName("Regression Test Results");
		sparkreporter.config().setTheme(Theme.STANDARD);
		extentreport= new ExtentReports();
		extentreport.attachReporter(sparkreporter);
		extentreport.setReportUsesManualConfiguration(true);

		return extentreport;
	}
	
	
	public synchronized void onStart(ITestContext context)
	{
		System.out.println("The test suite has started!");

	}
	public synchronized void onFinish(ITestContext context)
	{
		System.out.println("The test suit has ended");
		extentreport.flush();
		test.remove();
	}
	public synchronized void onTestStart(ITestResult result)
	{
		String testcasename=result.getMethod().getMethodName();
		String testcasedescription=result.getMethod().getDescription();
		String classname=result.getTestClass().getName();
		int n=classname.lastIndexOf('.');
		classname=classname.substring(n+1, classname.length());
		String suite=result.getTestContext().getSuite().getName();
		extenttest=extentreport.createTest(testcasename, testcasedescription);
		extenttest.assignAuthor("Shabana Khan");
		extenttest.assignCategory(suite);
		extenttest.assignCategory(classname);
		test.set(extenttest);
		test.get().getModel().setStartTime(new Date(result.getStartMillis()));


	}
	public synchronized void onTestSuccess(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName()+" has been passed!");

		test.get().getModel().setEndTime(new Date(result.getEndMillis()));
	}
	public synchronized void onTestFailure(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName()+" has been failed!");
		test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotPath()).build());

		test.get().getModel().setEndTime(new Date(result.getEndMillis()));
	}
	public synchronized void onTestSkipped(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName()+" has been skipped!");

		test.get().getModel().setEndTime(new Date(result.getEndMillis()));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test has failed but with some success percentage");
		test.get().getModel().setEndTime(new Date(result.getEndMillis()));
		
	}


}
