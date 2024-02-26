Feature: Salesfoce Login 

Scenario:Verify the error message with valid username and empty password
Given the url "https://login.salesforce.com/"
When user on "LoginPage"
Then verify the Login Page title
Given the value of username
And clear the password
And click on the LogIn button
Then verify error message should be displayed as "Please enter your password."

Scenario:Verify the HomePage display
Given the url "https://login.salesforce.com/"
When user on "LoginPage"
Then verify the Login Page title
Given the value of username
And the value of password
And click on the LogIn button
When user on "HomePage"
Then verify the Home Page title

Scenario:Verify the Remember me checkbox
Given the url "https://login.salesforce.com/"
When user on "LoginPage"
Then verify the Login Page title
Given the value of username
And the value of password
And check the Remember me checkbox
And click on the LogIn button
When user on "HomePage"
Then verify the Home Page title
Given click user navigation menu
Given click the logout
Then verify the username in username textbox

@Smoke
Scenario:Verify Password reset message
Given the url "https://login.salesforce.com/"
When user on "LoginPage"
Then verify the Login Page title
Given the value of username
And clear the password
When click on Forgot password
When user on "ForgotPasswordPage"
When click on continue button
When user on "CheckyourEmailPage"
Then verify the password reset message as "Check Your Email"

Scenario: Verify ErrorMessage as incorrect username and password
Given the url "https://login.salesforce.com/"
When user on "LoginPage"
Then verify the Login Page title
Given the value of wrong username as "123" and wrong password as "22131"
And click on the LogIn button
Then verify the error message 


