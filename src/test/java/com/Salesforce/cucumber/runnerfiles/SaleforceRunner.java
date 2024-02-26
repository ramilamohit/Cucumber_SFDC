package com.Salesforce.cucumber.runnerfiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/resources/Login.feature"},
				glue = {"com.Salesforce.cucumber.stepdefns"},
				plugin = {"pretty","html:target/cucumber-pom-selenium.html"},
				dryRun = true,
				tags = "@Smoke"
		)
public class SaleforceRunner extends AbstractTestNGCucumberTests{

}


