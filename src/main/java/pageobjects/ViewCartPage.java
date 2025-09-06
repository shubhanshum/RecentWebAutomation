package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.CoreActions;

public class ViewCartPage {

	WebDriver driver;
	
	public ViewCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//td[@class='cart_price']/p")
	public WebElement priceTxt;
	
	@FindBy(xpath = "//p[@class='cart_total_price']")
	public WebElement totalTxt;
	
	
	public int getPrice() {
		String text=CoreActions.getElementText(priceTxt);
		String[]rupees=text.split(" ");
		return Integer.parseInt(rupees[1]);
	}
	
	public int getTotalPrice() {
		String text=CoreActions.getElementText(totalTxt);
		String[]rupees=text.split(" ");
		return Integer.parseInt(rupees[1]);
	}
	
}
