package com.qa.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.utilities.FrameWorkConstants;

public class CustomerLoginPageTest extends BaseTest {
	public void customerLoginPageSetUp()
	{
		clp=lp.landOnCustomerLoginPage();
	}

	@Test(priority=1)
	public void verifyPageTitle()
	{
		customerLoginPageSetUp();
		Assert.assertEquals(clp.getPageTitle(), FrameWorkConstants.getCustomerLoginpageTitle());

	}
	@Test(priority=2)
	public void verifyCreateAccountDipslay()
	{
		customerLoginPageSetUp();
		Assert.assertEquals(clp.isCreateAccountLinkDisplayed(), true);
	}
	@Test(priority=3)
	public void verifyForgotPasswordLinkDisplay()
	{
		customerLoginPageSetUp();
		Assert.assertEquals(clp.isForgotPasswordLinkDisplayed(), true);
	}
	@Test(priority=4)

	public void verifySignInButtonDisplay()
	{
		customerLoginPageSetUp();
		Assert.assertEquals(clp.isSignInButtonDisplayed(), false);
	}
	@Test(priority=5)
	public void verifyCustomerLogin()
	{
		customerLoginPageSetUp();
		clp.customerLogin(prop.getProperty("username"), prop.getProperty("password"));
	}


}
