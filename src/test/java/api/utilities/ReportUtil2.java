package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
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

public class ReportUtil2 implements ITestListener{
	
	ExtentSparkReporter htmlReporter;//user interface
	ExtentReports reports;//common information
	ExtentTest test;//entries for test
	
	public void configureReport() {
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "MyRAFrameowrkExtentReport-"+timestamp+".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);		
		//add environment detail
		reports.setSystemInfo("Machine", "MyMac1");
		reports.setSystemInfo("User", "nehal");		
		//Configuration		
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report Demo");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}		
	//OnStart method is called when any test starts
	public void onStart(ITestContext context) {
	    configureReport();
	    System.out.println("On Start Method is now invoked .....");
	  }
	  //OnFinish Method is called after all Tests are executed
	 public void onFinish(ITestContext context) {
		 System.out.println("On Finish Method is now invoked .....");
		 reports.flush();
				  }
		public void onTestStart(ITestResult result) {
	    System.out.println("Name of the test method started:"+result.getName());
	  }
	 
	  public void onTestSuccess(ITestResult result) {
		  System.out.println("Name of the test method successfully executed:"+result.getName());
		  test = reports.createTest(result.getName());
		  test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is "+result.getName(), ExtentColor.GREEN));
		  }
	 
	  public void onTestFailure(ITestResult result) {
		  System.out.println("Name of the test method failed:"+result.getName());
		  test = reports.createTest(result.getName());
		  test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is "+result.getName(), ExtentColor.RED));
		  test.fail(result.getThrowable());
	  }

	   public void onTestSkipped(ITestResult result) {
		  System.out.println("Name of the test method skipped:"+result.getName());
		  test = reports.createTest(result.getName());
		  test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case is "+result.getName(), ExtentColor.AMBER));
	  }
	
	

}
