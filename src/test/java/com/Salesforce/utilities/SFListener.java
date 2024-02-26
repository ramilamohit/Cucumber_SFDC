package com.Salesforce.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//import com.Salesforce.base.BaseTest;

public class SFListener  implements ITestListener
{
	protected static Logger SFListenerlog = LogManager.getLogger();
	private static ExtentReportsUtility extentReport=ExtentReportsUtility.getInstance();


	@Override
	public void onTestStart(ITestResult result)
	{
		SFListenerlog.info("............."+result.getMethod().getMethodName()+".......test execution started........");
		extentReport.startSingleTestReport(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		SFListenerlog.info("............."+result.getMethod().getMethodName()+".......test execution completed with success........");
		extentReport.logTestpassed(result.getMethod().getMethodName()+"test execution completed with success");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		SFListenerlog.info("............."+result.getMethod().getMethodName()+".......test execution completed with failure........");
		extentReport.logTestFailed(result.getMethod().getMethodName()+"test is failed");
		String filename=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		String path=Constants.SCREENSHOTS_DIRECTORY_PATH+filename+".png"; 
		//takescreenshot(path);
		extentReport.logTestWithscreenshot(System.getProperty("user.dir")+"/reports/screenshots/"+filename+".png");
		extentReport.logTestFailedWithException(result.getThrowable());


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		SFListenerlog.info("............."+result.getMethod().getMethodName()+".......test execution skipped........");
		extentReport.logTestSkpied(result.getMethod().getMethodName()+"test execution skipped");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		SFListenerlog.info("............."+result.getMethod().getMethodName()+".......test execution failed with timeout........");
		extentReport.logTestFailedWithTimeout(result.getMethod().getMethodName()+"test failed with timeout");
	}

	@Override
	public void onStart(ITestContext context) {
		SFListenerlog.info("............."+context.getName()+"....has started................");
		extentReport.startExtentReport();

	}

	@Override
	public void onFinish(ITestContext context) {
		SFListenerlog.info("............."+context.getName()+".....has finised................");
		extentReport.endReport();

	}

}
