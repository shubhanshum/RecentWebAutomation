package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import core.BaseClass;
import core.CoreActions;
import utilities.Reporter;

public class BaseTest extends BaseClass{

	@BeforeMethod
	public void setUp() {
		Reporter.getInstance();
		String browserName=CoreActions.getPropFileData("browsername");
		String url=CoreActions.getPropFileData("url");
		if(browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options=new ChromeOptions();
			threadLocal.set(new ChromeDriver(options));
		}else {
			FirefoxOptions options=new FirefoxOptions();
			threadLocal.set(new FirefoxDriver(options));
		}
		getDriver().get(url);
		getDriver().manage().window().maximize();
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		Reporter.getResult(result);
		getDriver().quit();
		threadLocal.remove();
		Reporter.flush();
	}
	
	/*
	 * @AfterClass public void tearDown() { getDriver().quit();
	 * threadLocal.remove(); Reporter.flush(); }
	 */
}
