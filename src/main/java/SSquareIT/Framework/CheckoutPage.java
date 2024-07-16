package SSquareIT.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	@FindBy(xpath="//div//a[text()='Checkout']")
	private WebElement checkOut;
	
	@FindBy(css="button.close")
	private WebElement errorMessage;
	
	@FindBy(xpath="(//a[text()='Nikon D300'])[2]/../span")
	private WebElement successMessage;
	
	
	
	public CheckoutPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	public void clickToCheckOut()
	{
		checkOut.click();
	}
	public void closeErrorMessage() {
		errorMessage.click();
	}
	public String getSuccessMessage() {
		String successMessageText=successMessage.getText();
		return successMessageText;
	}
}
