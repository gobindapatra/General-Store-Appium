package org.GeneralStore.TestUtils;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
public class Listeners extends BaseTest implements ITestListener
{
	ExtentReports extent = ExtentReportsNG.getReportObject();
    ExtentTest test;
    
    AndroidDriver driver;

	@Override
	public void onTestStart(ITestResult result)
	{
		test =extent.createTest(result.getMethod().getMethodName());
		//result.getMethod().getMethodName() - get all method name of Test case
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		test.fail(result.getThrowable());
		//screenshot code
		try {
			driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			test.addScreenCaptureFromPath(getScreenShot(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}

}
