package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.CoreActions;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "name")
	public WebElement nameTextbox;
	
	@FindBy(name = "email")
	public WebElement emailTextbox;
	
	@FindBy(name = "password")
	public WebElement pwdTextbox;
	
	@FindBy(xpath = "//button[@data-qa='signup-button']")
	public WebElement signupBtn;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	public WebElement loginBtn;
	
	public void login(String username, String password) {
		CoreActions.setText(emailTextbox, username);
		CoreActions.setText(pwdTextbox, password);
		CoreActions.click(loginBtn, "Login button");
	}
}
