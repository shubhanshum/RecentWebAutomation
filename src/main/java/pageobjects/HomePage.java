package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import core.CoreActions;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@href,'delete')]")
	public WebElement deleteAccountLnk;
	
	@FindBy(xpath = "//a[contains(@href,'brand_products')]/span")
	public List<WebElement> displayedProductsLink;
	
	@FindBy(xpath = "//div[contains(@class,'shop-menu')]//a[contains(@href,'products')]")
	public WebElement productsLnk;
	
	public boolean verifyDeleteAccountDisplayed() {
		return deleteAccountLnk.isDisplayed();
	}
	
	public void clickOnProductsTab() {
		CoreActions.click(productsLnk, "Products tab");
	}
	
	public void printAvailableProductsLink() {
		for(WebElement links: displayedProductsLink) {
			System.out.println(CoreActions.getElementText(productsLnk));
		}
	}
}
