package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import core.BaseClass;
import core.CoreActions;
import testdata.FilesLocation;

public class Reporter extends BaseClass{

static String timestamp=new SimpleDateFormat("dd.mm.YYYY.hh.mm.ss").format(new Date());
	
	public static void setReport() {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir").concat(FilesLocation.reportPath));
		sparkReporter.config().setDocumentTitle("Ebay Automation Report");
		sparkReporter.config().setReportName("Ebay Automation Tests");
		sparkReporter.config().setTheme(Theme.DARK);
		extentReports=new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", "Windows");
		extentReports.setSystemInfo("Browser", CoreActions.getPropFileData("browsername"));
	}
	
	public static void getResult(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE){
			extentTest.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"Test case failed due to below issue",ExtentColor.RED));
			extentTest.fail(result.getThrowable());
			File srcFile=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
			File destFile=new File (System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+timestamp+".png");
			String filePath=destFile.getAbsolutePath();
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			extentTest.addScreenCaptureFromPath(filePath);
		}
		else if (result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(Status.PASS,MarkupHelper.createLabel(result.getName()+"Test case passed",ExtentColor.GREEN));
		}
		else{
			extentTest.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"Test case skipped",ExtentColor.YELLOW));
			extentTest.skip(result.getThrowable());
		}
	}
	
	public static void flush() {
		extentReports.flush();
	}
	
	public static void setTestName(String name) {
		extentTest=extentReports.createTest(name);
	}
	
	public static void setMethodMessage(String Message) {
		extentTest.log(Status.INFO,Message);
	}
	
	public static ExtentReports getInstance() {
        if(extentReports == null) {
            setReport();
        }   
        return extentReports;
    }
}
