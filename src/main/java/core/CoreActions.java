package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import exceptionHandler.ErrorCode;
import exceptionHandler.FrameworkLevelExceptionalHandler;
import testdata.FilesLocation;
import utilities.Log;
import utilities.Reporter;

public class CoreActions extends BaseClass{

	public static void click(WebElement element, String elementName) {
		try {
			waitForElementToBeClickable(element);
			element.click();
			Log.info("Clicked on "+elementName);
			Reporter.setMethodMessage("Clicked on "+elementName);
		}catch(Exception e) {
			try {
				JavascriptExecutor jse=(JavascriptExecutor) getDriver();
				jse.executeScript("arguments[0].click();", element);
				Log.info("Clicked on "+elementName);
				Reporter.setMethodMessage("Clicked on "+elementName+" using JS");
			}catch(Exception e1) {
				throw new FrameworkLevelExceptionalHandler("Couldn't click on "+e.getMessage(), ErrorCode.UnableToPerformSeleniumClickActionException);
			}	
		}
	}
	
	public static void setText(WebElement element, String text) {
		try {
			waitForElementToBeDisplayed(element);
			element.clear();
			element.sendKeys(text);
			Log.info("Text entered is "+text);
			Reporter.setMethodMessage("Text entered is "+text);
		}catch(Exception e) {
			try {
				Actions act=new Actions(getDriver());
				act.moveToElement(element).sendKeys(text);
				Log.info("Text entered is "+text);
				Reporter.setMethodMessage("Text entered is "+text);
			}catch(Exception e1) {
				throw new FrameworkLevelExceptionalHandler("Unable to enter text:"+e1.getMessage(), ErrorCode.UnableToPerformSeleniumSetTextActionException);
			}
		}
	}
	
	public static void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(Integer.parseInt(getPropFileData("timeout"))));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementToBeDisplayed(WebElement element) {
		WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(Integer.parseInt(getPropFileData("timeout"))));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static String getPropFileData(String key) {
		String value="";
		try {
			FileInputStream file=new FileInputStream(FilesLocation.configFile);
			Properties prop=new Properties();
			prop.load(file);
			value=prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static String getElementText(WebElement element) {
		String value="";
		try {
			waitForElementToBeDisplayed(element);
			value=element.getText();
			Log.info("Text value retrieved: "+value);
		}catch(Exception e) {
			e.getMessage();
		}
		return value;
	}
	
}
