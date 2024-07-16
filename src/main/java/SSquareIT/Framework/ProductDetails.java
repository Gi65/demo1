package SSquareIT.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BasePageClass;

public class ProductDetails extends BasePageClass{
	static WebDriver driver;

	@FindBy(xpath="(//h1[text()='Nikon D300']/..//following-sibling::ul[@class='list-unstyled'])[2]//h2")
	private WebElement price;
	
	@FindBy(xpath="//input[@name='quantity']")
	private WebElement qty;
	
	@FindBy(id="input-quantity")
	private WebElement setQuantityButton;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement cartButton;
	
	public ProductDetails(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public String getPrice() {
		String productPrice=price.getText();
		return productPrice;
	}
	
	public CartPage setQuantity(String quantity) {
		qty.clear();
		qty.sendKeys(quantity);
		setQuantityButton.click();
		cartButton.click();
		clickOnCart();
		CartPage cp=new CartPage(driver);  
		return cp;
	}
}
