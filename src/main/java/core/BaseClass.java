package core;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	protected static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();
	protected static ExtentSparkReporter sparkReporter;
	protected static ExtentReports extentReports;
	protected static ExtentTest extentTest;
	
	public static WebDriver getDriver() {
		return threadLocal.get();
	}
}
