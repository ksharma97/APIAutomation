package BaseURIsAndHeaders;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	protected static ExtentReports extent;
	protected static ExtentSparkReporter html;
	protected static ExtentTest test;
	
	@BeforeSuite
	public void setExtentReport() {
		System.out.println("In Report setting claass");
		extent = new ExtentReports();
		html = new ExtentSparkReporter(System.getProperty("user.dir")+"//Report.html");
		extent.attachReporter(html);
	}
	
	@AfterSuite
	public void endReport() {
		System.out.println("In Report ending class");
		extent.flush();
	}
}
