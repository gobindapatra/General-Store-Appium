package org.GeneralStore.TestUtils;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG
{

	static ExtentReports extent;
	@Test
	public static ExtentReports getReportObject()
	{
		//ExtentReports , ExtentSparkReporter
				String path = "E://MyAppiumWorkPlace//AppiumFrameworkDesign//Extent Report//Report1.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setDocumentTitle("Test Result");
				reporter.config().setReportName("Web Automation Test");

				extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "Tester Name");
				extent.setSystemInfo("Devloper", "Developer Name");
				return extent;
		   
	}
}
