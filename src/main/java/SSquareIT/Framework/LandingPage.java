package SSquareIT.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	static WebDriver driver;
  
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath="//li//a[text()='Login']")
	private WebElement loginButton;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginPage NavigationToLoginPage() {
		myAccount.click();
		loginButton.click();
		LoginPage login=new LoginPage(driver);
		return login;
		
	}
}
