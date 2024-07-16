package SSquareIT.Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testComponents.BaseTest;

public class VerifyInvaliLogin extends BaseTest {
   
	@Test                      //@Test(retryAnalyzer=RetryTest.java)
	public void verifyLoginWithInvalidCreds() throws IOException {
	WebDriver driver=initBrowser();
	LandingPage lp=new LandingPage(driver);
	LoginPage login=lp.NavigationToLoginPage();
	HomePage hp=login.loginAction("min@gmail.com", "Ad");
	
	SoftAssert sa=new SoftAssert();
	String actual=driver.getCurrentUrl();
	String expected="https://tutorialsninja.com/demo/index.php?route=account/account";
	tearDown();
	sa.assertEquals(actual, expected);
	sa.assertAll();
	}
	
}
