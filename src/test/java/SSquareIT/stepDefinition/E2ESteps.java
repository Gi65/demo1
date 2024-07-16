package SSquareIT.stepDefinition;

import static testComponents.BaseTest.driver;

import java.io.IOException;

import org.testng.Assert;

import SSquareIT.Framework.CartPage;
import SSquareIT.Framework.CheckoutPage;
import SSquareIT.Framework.HomePage;
import SSquareIT.Framework.LandingPage;
import SSquareIT.Framework.LoginPage;
import SSquareIT.Framework.ProductDetails;
import SSquareIT.Framework.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testComponents.BaseTest;

public class E2ESteps extends BaseTest{

	LoginPage login;
	HomePage hp;
	ProductPage pp;
	CheckoutPage checkout;
	
	
	@Given("Navigate to baseUrl")
	public void Navigate_to_baseUrl() throws IOException {
		initBrowser();
		LandingPage lp=new LandingPage(driver);
		login=lp.NavigationToLoginPage();
	}
   
	@Given("^Login with username (.+) and password (.+)$")
	public void Login_with_username_and_password(String name, String password) {
		hp=login.loginAction(name, password);
	}
	
	@When("^added product (.+) to cart and checkout$")
	public void added_product_to_cart_and_checkout(String product) {
		pp=hp.clickOnCameraTab();
		ProductDetails pd=pp.addProductToCart(product);
		Assert.assertEquals(pd.getPrice(), "$98.00");
		CartPage cp=pd.setQuantity("2"); 
		checkout=cp.goToCheckOutPage();	  
		checkout.clickToCheckOut();
	}
	@Then("verify the details {string}")
	public void verify_the_details(String string) {
		checkout.closeErrorMessage();
		checkout.getSuccessMessage();
		boolean isSuccess= checkout.getSuccessMessage().equalsIgnoreCase("***");
		Assert.assertTrue(isSuccess);
		tearDown();

	}
}
