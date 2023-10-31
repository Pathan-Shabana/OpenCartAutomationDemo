package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utilities.ElementUtils;

public class CustomerLoginPage {
	WebDriver driver;
	ElementUtils eu;
	public CustomerLoginPage(WebDriver driver)
	{
		this.driver=driver;
		eu=new ElementUtils(driver);
		
	}
	
	private By pageHeading=By.xpath("//span[@class='base']");
	private By registeredCustomerHeading=By.xpath("//div[@class='login-container']//strong[@id='block-customer-login-heading']");
	private By createaccountlink=By.xpath("//a[@class='action create primary']//span[contains(text(),'Create an Account')]");
	private By forgotPasswordLink=By.xpath("//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]");
	private By email=By.xpath("//input[@id='email']");
	private By password=By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']");
	private By signinbutton=By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]");
	
	public String getPageHeading()
	{
		return eu.getElementText(eu.getElement(pageHeading));
	}
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	public String getRegisteredCustomerText()
	{
		return eu.getElementText(eu.getElement(registeredCustomerHeading));
	}
	public boolean isCreateAccountLinkDisplayed()
	{
		return eu.getElement(createaccountlink).isDisplayed();
	}
	public boolean isForgotPasswordLinkDisplayed()
	{
		return eu.getElement(forgotPasswordLink).isDisplayed();
	}
	public boolean isSignInButtonDisplayed()
	{
		return eu.getElement(signinbutton).isDisplayed();
	}
	public void customerLogin(String username,String pwd)
	{
		eu.getElement(email).sendKeys(username);
		eu.getElement(password).sendKeys(pwd);
		eu.getElement(signinbutton).click();
		
	}
	
	

}
