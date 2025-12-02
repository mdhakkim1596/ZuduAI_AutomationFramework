package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase_ZuduAI.BaseClass;


public class ExtentReportManager implements ITestListener{
	
	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test;
	
	String repname;
	
	public void onStart(ITestContext context) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    
		repname = "Time-Report-"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports_ZuduAI/"+repname);
		sparkReporter.config().setDocumentTitle("Automation Test Report");
		sparkReporter.config().setReportName("Functional Test");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application", "Zudu.ai");
		extent.setSystemInfo("Environment", "QA Team");
		extent.setSystemInfo("Tester", "Hakkim");
		extent.setSystemInfo("Browser", "Chrome, Edge, FireFox");
		
	  }
	
	public void onTestSuccess(ITestResult result) {
	   
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case Passed "+result.getName());
		
	  }
	
	public void onTestFailure(ITestResult result) {
	    
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed ");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	  }
	
	public void onTestSkipped(ITestResult result) {
	    test = extent.createTest(result.getName());
	    test.log(Status.SKIP, "Test Case Skipped "+result.getName());
	    test.log(Status.SKIP, result.getThrowable().getMessage());
	  }
	
	public void onFinish(ITestContext context) {
	    extent.flush();
	  }

}
