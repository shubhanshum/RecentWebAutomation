package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.CoreActions;

public class ProductsListingPage {

	WebDriver driver;
	
	public ProductsListingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@href,'H&M')]")
	public WebElement hmLink;
	
	@FindBy(xpath = "//div[contains(@class,'productinfo')]//p[text()='Men Tshirt']/following-sibling::a[1]")
	public WebElement menTshirtAddToCartBtn;
	
	@FindBy(xpath = "//div[@class='modal-content']//a[contains(@href,'view_cart')]")
	public WebElement viewCartBtn;
	
	public void addProductAndGoToCart() {
		CoreActions.click(hmLink, "H&M Link");
		CoreActions.click(menTshirtAddToCartBtn, "Men Tshirt Add To Cart button");
		CoreActions.click(viewCartBtn, "View Cart Link");
	}
}
