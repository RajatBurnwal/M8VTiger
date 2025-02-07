package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	JavaUtility jUtil=new JavaUtility();
	String dateTimeStamp=jUtil.getCalendarDetails("dd-MM-YYYY hh-mm-ss");
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Listeners test started");
		Reporter.log(methodName+" Listeners test started");
		
		//Adding test method to reports
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Listeners test passed");
		Reporter.log(methodName+"Listeners test passed");
		
		test.log(Status.PASS, methodName+" test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Listeners test failed");
		Reporter.log(methodName+"Listeners test failed");
		
		test.log(Status.FAIL, methodName+" test failed");
		test.log(Status.INFO, result.getThrowable());	
		SeleniumUtility sUtil=new SeleniumUtility();
		try {
			String path=sUtil.getWebpageScreenshot(BaseClass.sDriver, dateTimeStamp);
			
			//attaching screenshot to report
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Listeners test skipped");
		Reporter.log(methodName+"Listeners test skipped");
		
		test.log(Status.SKIP, methodName+" test skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Listeners suite started");
		
		//Configuration of Extent Report
		ExtentSparkReporter reporter=new ExtentSparkReporter(".\\Extent Reports\\report-"+dateTimeStamp+".html");
		reporter.config().setDocumentTitle("VTiger Report");
		reporter.config().setReportName("Vtiger execution report");
		reporter.config().setTheme(Theme.STANDARD);
		
		//Generation of Extent Report
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Test Engineer", "Rajat");
		report.setSystemInfo("Base Application", "VTiger");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Listeners suite ended");
		
		//Flush out report to create a report
		report.flush();
	}
	
	

}
