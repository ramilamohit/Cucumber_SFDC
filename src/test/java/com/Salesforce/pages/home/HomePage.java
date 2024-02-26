package com.Salesforce.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Salesforce.pages.base.BasePage;

public class HomePage extends BasePage {
	
	@FindBy(id = "userNavButton")WebElement userNavDrdown;
	@FindBy(linkText = "Logout")WebElement logoutlink;

		
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	public void waitimplicit(int time)
	{
		implicitwait(time);
	}

	public String getPageTitle()
	{
		waitforTitle(60,"Home","Home Page");
		return getTitle();
	}
	
	public void clickUsermenuNavigation()
	{
		waitforVisibility(userNavDrdown,60,"Usermenu dropdown");		
		clickElement(userNavDrdown, "User Navigation Dropdown");
	}
	
	public WebDriver clicklogout()
	{
		clickElement(logoutlink, "logout button");
		return driver;

	}
	public void checkText(String str1,String str2,String text)
	{
		checkTextValue(str1, str2, text);

	}
	


}
