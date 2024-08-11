package ExtentReport;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports getReport()
	{
		ExtentSparkReporter extentSpark = new ExtentSparkReporter("./target/report.html");
		extentSpark.config().setReportName("TestNG report");
		extentSpark.config().setDocumentTitle("TestNG practise");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(extentSpark);
		extent.setSystemInfo("Tester", "Srinivas");
		return extent;
		
	}

}
