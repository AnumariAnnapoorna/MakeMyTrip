package com.qa.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	public void onStart(ITestContext textContext) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+reportName);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("HostName", "localhost");
		//reports.setSystemInfo(timeStamp, reportName);
		reports.setSystemInfo("OS", "Windows10");
		
		htmlReporter.config().setDocumentTitle("");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	public void onFinish(ITestContext testContext) {
		reports.flush();
	}
	
	public void onTestSuccess(ITestResult tr) {
		test=reports.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		test.log(Status.PASS, "Test is Passed");
	}
	
	public void onTestFailure(ITestResult tr) {
		test=reports.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		test.log(Status.FAIL, "Test is Failed");
		test.log(Status.FAIL, tr.getThrowable());
		String efile=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		File file=new File(efile);
		if(file.exists()) {
			try {
				test.fail("Screenshot for test failed is : "+test.addScreenCaptureFromPath(efile));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void onTestSkipped(ITestResult tr) {
		test=reports.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		test.log(Status.SKIP, "Test is Skipped");
	}
}
