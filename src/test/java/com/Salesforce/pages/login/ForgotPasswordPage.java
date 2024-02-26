package com.Salesforce.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Salesforce.pages.base.BasePage;


public class ForgotPasswordPage extends BasePage {
	
	@FindBy(xpath = "//input[@id='un']")WebElement txtuserid;
	@FindBy(xpath = "//*[contains(@value,'Continue')]")WebElement continuebtn;

		
	public ForgotPasswordPage(WebDriver driver)
	{
		super(driver);
	}

	public void enterUsername(String data)
	{
		enterText(txtuserid, data, "Username textbox");
	}

	public WebDriver clickContinue()
	{
		clickElement(continuebtn, "Continue button");
		return driver;
	}	
	
}
