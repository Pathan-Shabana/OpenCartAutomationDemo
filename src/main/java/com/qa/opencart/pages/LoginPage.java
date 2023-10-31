package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utilities.ElementUtils;

public class LoginPage {
	WebDriver driver;
	ElementUtils eu;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		eu=new ElementUtils(driver);
		
	}

	private By footerlinktext=By.xpath("//ul[@class='footer links']/li/a");
	private By headerContentText=By.xpath("//ul[@id='ui-id-2']/li/a/span[not(@class='ui-menu-icon ui-icon ui-icon-carat-1-e')]");
	private By searchBox=By.xpath("//input[@id='search']");
	private By cart=By.xpath("//a[@class='action showcart']");
	private By defaultWlCumMessage=By.xpath("//div[@class='panel header']//span[@class='not-logged-in'][normalize-space()='Default welcome msg!']");
	private By signinlink=By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
	private By createaccountlink=By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']");
	
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean isSearchBoxDisplayed()
	{
		return eu.getElement(searchBox).isDisplayed();
	}
	public void getFooterContentHeadings()
	{
		eu.getElementsText(eu.getElements(footerlinktext));
	}
	public void getHeaderElementsText()
	{
		eu.getElementsText(eu.getElements(headerContentText));
	}
	public String getDefaultWelcomeText()
	{
		return eu.getElementText(eu.getElement(defaultWlCumMessage));
	}
	public boolean isCartLinkDisplayed()
	{
		return eu.getElement(cart).isDisplayed();
	}
	public boolean isSignInLinkDisplayed()
	{
		return eu.getElement(signinlink).isDisplayed();
	}
	public boolean isCreateAccountLinkDisplayed()
	{
		return eu.getElement(createaccountlink).isDisplayed();
	}
	public CustomerLoginPage landOnCustomerLoginPage()
	{
		eu.getElement(signinlink).click();
		return new CustomerLoginPage(driver);
	}
	
	
	
	

}
