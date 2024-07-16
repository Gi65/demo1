package SSquareIT.Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class E2ETest2 extends BaseTest {
	
    @Test(dataProvider="getData")
	public void endToEndTest(String username,String password) throws IOException {
		WebDriver driver=initBrowser();
		LandingPage lp=new LandingPage(driver);
		LoginPage login=lp.NavigationToLoginPage();
		HomePage hp=login.loginAction(username, password);
		ProductPage pp=hp.clickOnCameraTab();
		ProductDetails pd=pp.addProductToCart("Nikon D300");
		Assert.assertEquals(pd.getPrice(), "$98.00");
		CartPage cp=pd.setQuantity("2"); 
		//Assert.assertEquals(cp.getPrice(), "$196.00");
		CheckoutPage checkout=cp.goToCheckOutPage();	  
		checkout.clickToCheckOut();
		checkout.closeErrorMessage();
		checkout.getSuccessMessage();
		boolean isSuccess= checkout.getSuccessMessage().equalsIgnoreCase("***");
		Assert.assertTrue(isSuccess);
		tearDown();
    }
    @DataProvider(name="getData")
    public Object[][] getData() {
    	return new Object[][]{ {"Adminadmin@gmail.com","Admin@123"},
    		                   {"adminyourstore@gmail.com","Admin"}};
    	}
    }

