package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.CoreActions;
import pageobjects.HomePage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import utilities.Log;
import utilities.Reporter;

public class SigninTest extends BaseTest{

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Test
	public void signinTest() {
		Log.stratTestCase(this.getClass().getSimpleName());
		Reporter.setTestName(this.getClass().getSimpleName());
		landingPage=new LandingPage(getDriver());
		homePage=new HomePage(getDriver());
		loginPage=new LoginPage(getDriver());
		String email=CoreActions.getPropFileData("email");
		String password=CoreActions.getPropFileData("pwd");
		landingPage.clickLoginLink();
		loginPage.login(email, password);
		Assert.assertTrue(homePage.verifyDeleteAccountDisplayed());
		Log.endTestCase(this.getClass().getSimpleName());
	}
}
