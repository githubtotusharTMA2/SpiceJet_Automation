package testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.relevantcodes.extentreports.Report;

public class Extent_Report implements ITestListener {
	
	
	protected static WebDriver driver;
    protected static ExtentReports reports;
    protected static ExtentTest test;

 

    public void onTestStart(ITestResult result) {
        System.out.println("Test start");
        test = reports.startTest(result.getMethod().getMethodName());
        test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
    }

 

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test success");
        test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
    }

 

    public void onTestFailure(ITestResult result) {
        System.out.println("Test failure");
        test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("C:\\images\\" + result.getMethod().getMethodName() + ".png"));
            String file = test.addScreenCapture("C:\\images\\" + result.getMethod().getMethodName() + ".png");
            test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
            test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed",
                    result.getThrowable().getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped");
        test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
    }

 

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("on test success within percentage");
    }

 

    public void onStart(ITestContext context) {
        System.out.println("on start");
        System.setProperty("webdriver.chrome.driver", "E:\\QA_Infotech\\Training_Works\\Eclipse\\Utils\\Selenium_browser_drivers\\chromedriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(); // Set the drivers path in environment variables to avoid
                                        // code(System.setProperty())
        reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
    }

 

    public void onFinish(ITestContext context) {
        System.out.println("on finish");
        driver.close();
        reports.endTest(test);
        reports.flush();
    }

	private ExtentReports extent;
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory)
	{
		extent = new ExtentReports(outputDirectory + File.separator + "Extent.html", true);
		
		for(ISuite suite : suites)
		{
		   Map<String, ISuiteResult> result = suite.getResults();
		   
		   for(ISuiteResult r : result.values())
		   {
			   ITestContext context = r.getTestContext();
			   
			   buildTestNodes(context.getPassedTests(), LogStatus.PASS);
			   buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
			   buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
		   }
		}
		
		extent.flush();
		extent.close();
	}

	public void buildTestNodes(IResultMap tests, LogStatus status)
	{
		ExtentTest test;
		if(tests.size() > 0)
		{
			for(ITestResult result : tests.getAllResults())
			{
				test = extent.startTest(result.getMethod().getMethodName());
				
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				
				for(String group : result.getMethod().getGroups())
					test.assignCategory(group);
				if(result.getThrowable() != null)
				{
					test.log(status, result.getThrowable());
				}
				else
				{
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}
				
				extent.endTest(test);
			}
		}
	}
	
	private Date getTime(long millis)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}


}
