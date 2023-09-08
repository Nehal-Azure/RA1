package api.utilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtil1 {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentSparkReporter("ExtentReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add environment detail
		reports.setSystemInfo("Machine", "MyMac1");
		reports.setSystemInfo("User", "nehal");
		
		//Configuration
		
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report Demo");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('ZZZ')'");
	}
	
	@Test
	public void testreportDemo1() {
		
		test = reports.createTest("Launch Browser and Open url");
		AssertJUnit.assertTrue(true);
		
			
	}
	@Test
	public void testreportDemo2() {
		
		test = reports.createTest("Do not Launch Browser and do not Open url");
		AssertJUnit.assertTrue(false);
		
			
	}
	@Test
	public void testreportDemo3() {
		
		test = reports.createTest("Again Launch Browser and Again Open url");
		AssertJUnit.assertTrue(true);
		
			
	}
	
	@Test
	public void testreportDemo4() {
		
		test = reports.createTest("This is skipp Test");
		throw new SkipException("Thowing exception as part of demo");
				
	}	
	@AfterMethod
	public void getTestResult(ITestResult result) {

		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAIL ", ExtentColor.RED));
			test.fail(result.getThrowable());
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASS ", ExtentColor.GREEN));
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIP ", ExtentColor.AMBER));
			
		}
			
	}
	@AfterMethod
	@AfterTest
	public void tearDown() {
		reports.flush();
		
	}
	
	
	

}
