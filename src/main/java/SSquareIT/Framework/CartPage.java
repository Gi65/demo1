package SSquareIT.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	static WebDriver driver;

	@FindBy(xpath="//strong[text()='Total']/../following-sibling::td")
	private WebElement totalprice;
	
	@FindBy(xpath="//strong[text()='Checkout']")
	private WebElement checkOutButton;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public String getPrice() {
		String netPrice=totalprice.getText();
		return netPrice;
	}
	public CheckoutPage goToCheckOutPage() {
		checkOutButton.click();
		CheckoutPage checkout=new CheckoutPage(driver);
		return checkout;
	}
}
