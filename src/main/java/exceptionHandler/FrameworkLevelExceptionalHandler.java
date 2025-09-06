package exceptionHandler;

import org.openqa.selenium.WebDriver;

import utilities.Log;

public class FrameworkLevelExceptionalHandler extends RuntimeException{

	private ErrorCode errCode;
	private WebDriver driver;
	
	public FrameworkLevelExceptionalHandler(WebDriver driver) {
		this.driver=driver;
	}
	
	public FrameworkLevelExceptionalHandler(String message, ErrorCode code) {
		super(message);
		this.errCode=code;
		Log.debug("in Exception: "+this.errCode+" at...");
	}
}
