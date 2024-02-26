package com.Salesforce.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Salesforce.pages.base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(id = "username")WebElement userid;
	@FindBy(id ="password")WebElement password;
	@FindBy(id = "error")WebElement errormsglb;
	@FindBy(id = "Login")WebElement btn;
	@FindBy(id = "rememberUn")WebElement chkbox;
	@FindBy(partialLinkText = "Forgot")WebElement forgotpassword;

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	public void waitimplicit(int time)
	{
		implicitwait(time);
	}
	
	
	public void enterUsername(String data)
	{
		enterText(userid, data, "Username ");
	}
	public String getUsername()
	{
		String name = getAttributFromElement(userid, "Username value");
		return name;
	}
	
	public void enterPassword(String data)
	{
		enterText(password, data, "Password");

	}
	public String getErrormsg()
	{
		String errormsg = getTextFromElement(errormsglb,"Error Message Element");
		return errormsg;
	}

	public void checkRemembercheckbox()
	{
		checkboxclick(chkbox, "check box");

	}

	public WebDriver clickForgotPassword()
	{
		clickElement(forgotpassword, "Forgot Password button");
		return driver;
	}
	public WebDriver ClickLoginButton()
	{
		clickElement(btn, "Login button");
		return driver;
	}
	
	public String getPageTitle()
	{
		waitforTitle(60,"Login","Login Page");
		return getTitle();
	}
	public void checkText(String str1,String str2,String text)
	{
		checkTextValue(str1, str2, text);

	}
	
	
}
