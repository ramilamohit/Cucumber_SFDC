package com.Salesforce.cucumber.stepdefns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.Salesforce.pages.home.HomePage;
import com.Salesforce.pages.login.CheckyourEmailPage;
import com.Salesforce.pages.login.ForgotPasswordPage;
import com.Salesforce.pages.login.LoginPage;
import com.Salesforce.utilities.Constants;
import com.Salesforce.utilities.Log4JUtility;
import com.Salesforce.utilities.PropertiesUtility;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepdefinition {

	public  WebDriver driver;
	
	protected static Logger log = LogManager.getLogger();
	protected static Log4JUtility logObject=Log4JUtility.getInstance();
	LoginPage login;
	HomePage home;
	SoftAssert sftasrt = new SoftAssert();
	ForgotPasswordPage forgotpwdpage;
	CheckyourEmailPage chkemailpg;

	
	public  void launchBrowser(String browserName) {
		switch(browserName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
			break;
		case "chrome":
		 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			break;
		}
		System.out.println(browserName+" browser opened");
	}
	
	public  void goToUrl(String url) {
		driver.get(url);
		log.info(url+ "is entered");
	}

	public  void closeBrowser() {
		driver.close();
		log.info("current browser closed");
	}
	
	@BeforeAll
	public static void setUpBeforeAllScenarios() {
		log=logObject.getLogger();
	}
	@Before
	public void setUpEachScenario() {
		
		launchBrowser("chrome");
		
	}
	@After
	public void tearDown() {
		closeBrowser();
	}
	@AfterStep
	public void after_each_step(Scenario sc) {
		if(sc.isFailed()){
			
		}
	}

@Given("the url {string}")
public void the_url(String string) {
	log.info("Title of the current page extracted");
	
	goToUrl(string);

}

@When("user on {string}")
public void user_on(String page) {
	 if(page.equalsIgnoreCase("LoginPage"))
	    	login=new LoginPage(driver);
	    else if(page.equalsIgnoreCase("homepage"))
	    	home=new HomePage(driver);
	    else if(page.equalsIgnoreCase("ForgotPasswordPage"))
	    	forgotpwdpage = new ForgotPasswordPage(driver);
	    else if(page.equalsIgnoreCase("CheckyourEmailPage"))
	    	chkemailpg = new CheckyourEmailPage(driver);		
}

@Then("verify the Login Page title")
public void verify_the_login_page_title()
{	
	String exploginTle = "Login | Salesforce";	
	String loginpg = login.getPageTitle();
	login.checkText(exploginTle, loginpg, "Login Page title");
	Assert.assertEquals(loginpg, exploginTle, "Login Page title");

}


@Given("the value of username")
public void the_value_of_username() 
{
	String userName=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
	login.enterUsername(userName);	
	String name = login.getUsername();
    login.checkText(userName, name, "Username text visible");
	sftasrt.assertEquals(name, userName, "Username visible");

}

@Given("clear the password")
public void clear_the_password()
{
	login.enterPassword("");
	login.checkText("", "", "Password txt is empty");
	sftasrt.assertEquals("", "", "Password txt is empty");
}

@Given("the value of password")
public void the_value_of_password()
{
	String passWord=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");
	login.enterPassword(passWord);

}


@Given("check the Remember me checkbox")
public void check_the_remember_me_checkbox()
{
	login.checkRemembercheckbox();

}

@When("click on Forgot password")
public void click_on_forgot_password() 
{
	driver = login.clickForgotPassword();
 }

@Then("verify the password reset message as {string}")
public void verify_the_password_reset_message_as(String expcheckemail)
{
	String checkemail = chkemailpg.headerText();	
	login.checkText(expcheckemail, checkemail, "Check Email Header");
	Assert.assertEquals(checkemail, expcheckemail);
}

@When("click on continue button")
public void click_on_continue_button()  
{
	String userName=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
	forgotpwdpage.enterUsername(userName);
	driver = forgotpwdpage.clickContinue();
}

@Given("the value of wrong username as {string} and wrong password as {string}")
public void the_value_of_wrong_username_as_and_wrong_password_as(String string, String string2)
{
	login.enterUsername(string);
	login.enterPassword(string2);
}

@Then("verify the error message")
public void verify_the_error_message() 
{
	String expErrorMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	String actualerrormsg = login.getErrormsg();
	login.checkText(actualerrormsg,expErrorMsg,"Error Message");
	Assert.assertEquals(actualerrormsg, expErrorMsg);

}


@Given("click on the LogIn button")
public void click_on_the_log_in_button()
{
	login.ClickLoginButton(); 
}

@Then("verify the Home Page title")
public void verify_the_home_page_title()
{
	String expTitle ="Home Page ~ Salesforce - Developer Edition";

	String hometitle = home.getPageTitle();
	home.checkText(hometitle, expTitle, "HomePage display");			
	Assert.assertEquals(hometitle, expTitle, "HomePage display");

}


@Then("verify error message should be displayed as {string}")
public void verify_error_message_should_be_displayed_as(String expError) {

	String errormsg = login.getErrormsg();
	login.checkText(expError, errormsg, "Error Message Element");
	sftasrt.assertEquals(errormsg, expError, "Error Message Element");
	sftasrt.assertAll();

 }

@Given("click user navigation menu")
public void click_user_navigation_menu() {
	home.clickUsermenuNavigation();

}

@Given("click the logout")
public void click_the_logout()
{
	home.clicklogout();
}


@Then("verify the username in username textbox")
public void verify_the_username_in_username_textbox()
{
	login.waitimplicit(40);

	String getUserId = login.getUsername();	
	String userName=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");	
	login.checkText(userName, getUserId, "User TxtBox is populated with valid User Id");
	Assert.assertEquals(getUserId, userName);
	
}


	
	
}
