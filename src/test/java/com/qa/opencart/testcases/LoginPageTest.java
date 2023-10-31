package com.qa.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.pages.CustomerLoginPage;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority=1)
	public void verifyLoginPageTitle()
	{
		System.out.println(lp.getLoginPageTitle());
	}
	@Test(priority=2)
	public void verifySearchBoxDisplay()
	{
		Assert.assertEquals(lp.isSearchBoxDisplayed(), true);
	}
	@Test(priority=3)
	public void verifyHeaderElementsText()
	{
		lp.getHeaderElementsText();
	}
	@Test(priority=4)
	public void verifyFooterElementText()
	{
		lp.getFooterContentHeadings();
	}
	@Test(priority=5)
	public void verifyCartLinkDisplay()
	{
		Assert.assertEquals(lp.isCartLinkDisplayed(), true);
	}
	@Test(priority=6)
	public void verifySignInLinkDisplay()
	{
		Assert.assertEquals(lp.isSignInLinkDisplayed(), true);
	}
	@Test(priority=7)
	public void verifyCreateAccountLinkDisplay()
	{
		Assert.assertEquals(lp.isCreateAccountLinkDisplayed(), true);
	}
	@Test(priority=7)
	public CustomerLoginPage verifyCustomerLoginPageLanding()
	{
		return lp.landOnCustomerLoginPage();
		
	}
	
	
	


}