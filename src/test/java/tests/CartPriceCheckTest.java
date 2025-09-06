package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.CoreActions;
import pageobjects.HomePage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.ProductsListingPage;
import pageobjects.ViewCartPage;
import utilities.Log;
import utilities.Reporter;

public class CartPriceCheckTest extends BaseTest{
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	ProductsListingPage productsListingPage;
	ViewCartPage viewCartPage;
	
	@Test
	public void checkprice() {
		Log.stratTestCase(this.getClass().getSimpleName());
		Reporter.setTestName(this.getClass().getSimpleName());
		landingPage=new LandingPage(getDriver());
		homePage=new HomePage(getDriver());
		loginPage=new LoginPage(getDriver());
		productsListingPage=new ProductsListingPage(getDriver());
		viewCartPage=new ViewCartPage(getDriver());
		String email=CoreActions.getPropFileData("email");
		String password=CoreActions.getPropFileData("pwd");
		landingPage.clickLoginLink();
		loginPage.login(email, password);
		homePage.clickOnProductsTab();
		productsListingPage.addProductAndGoToCart();
		Assert.assertEquals(viewCartPage.getPrice(), viewCartPage.getTotalPrice());
		Log.endTestCase(this.getClass().getSimpleName());
	}
	
}
