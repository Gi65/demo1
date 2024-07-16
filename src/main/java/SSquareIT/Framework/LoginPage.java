package SSquareIT.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	static WebDriver driver;

	@FindBy(id="input-email")
     private WebElement username;
	
	@FindBy(id="input-password")
    private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement submitButton;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public HomePage loginAction(String userEmail,String userPass) {
		username.sendKeys(userEmail);
		password.sendKeys(userPass);
		submitButton.click();
		HomePage hp=new HomePage(driver);
		return hp;
	}

}
