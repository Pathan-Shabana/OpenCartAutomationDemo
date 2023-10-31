package com.qa.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	public String getElementText(WebElement element)
	{
		return element.getText();
	}
	public void getElementsText(List<WebElement> elements)
	{
		for(int i=0;i<elements.size();i++)
		{
			elements.get(i).getText();
		}
	}
	public String getElementAttribute(WebElement element,String name)
	{
		return element.getAttribute(name);
	}
	public Select selectFromDropDown(By locator)
	{
		return new Select(getElement(locator));
	}
	public WebElement waitForTheElementPresence(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	public WebElement waitUntilElementClickable(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public WebElement waitUntilElementIsVisible(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
		
	
		
	}


