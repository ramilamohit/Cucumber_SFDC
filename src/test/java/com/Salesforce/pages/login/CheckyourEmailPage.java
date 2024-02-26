package com.Salesforce.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Salesforce.pages.base.BasePage;

public class CheckyourEmailPage extends BasePage 
{
	@FindBy(id = "header")WebElement header;
	
	public CheckyourEmailPage(WebDriver driver)
	{
		super(driver);
	}

	public String headerText()
	{
		String checkemail = getTextFromElement(header,"Check Email header");
		return checkemail;
	}

}
