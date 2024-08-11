package Listerners;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;

import ExtentReport.Reports;
import TestComponents.BaseClass;

public class listerner extends BaseClass implements ITestListener{

	public ExtentReports extent;
	public ExtentTest extentTest;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extent = Reports.getReport();
		extentTest = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		extentTest.log(Status.PASS, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.fail(result.getThrowable());
		
		try {
			//driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstanceName());
			
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
			.get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String path = takeScreenShot(result.getMethod().getMethodName(),driver);
			extentTest.addScreenCaptureFromPath(path,result.getMethod().getMethodName());
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
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}
	
	

}
