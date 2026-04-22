package WorkPracticeCompany.StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjectModel.ConfirmationPage;
import PageObjectModel.LandingPage;
import PageObjectModel.PaymentPage;
import PageObjectModel.ProductCatalogue;
import WorkPracticeCompany.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation extends BaseTest{
	
	
	public LandingPage landingPage;
	
	public ProductCatalogue pc;
	public ConfirmationPage cp=new ConfirmationPage(driver);
	@Given("I landed on Ecom Page")
	public void I_landed_on_ecom_Page() throws IOException {
	landingPage=	launchTheApp();
	
	}
	
	@Given("^Log in with username(.*) and password(.*)$")
	public void log_in_with_username_and_password(String uname, String pwd) throws InterruptedException {
		landingPage.actionsApplication(uname, pwd);
		
	}
	//When: I add product <productName> to cart
	
	@When("^I add product (.*) to cart$")
	public void I_add_product_to_cart(String prodName) throws InterruptedException {
		List<WebElement> products = pc.getProductList();
		pc.addProductsToCart(prodName);
	}
	
	@When("^Checkout (.*) and submit the order$")
	public void Checkout_submit_order() throws InterruptedException {
	
		
		pc.sleepOption();
		pc.goToCart();//has access to parent class methods as well

	PaymentPage pp = new PaymentPage(driver);
	pp.addCountry("India");
	pp.payThePayment();
	}
	@Then("{string} message is displayed on confirmation page")
	public void message_is_displayed_on_confirmation_page(String string) throws InterruptedException {
		
//		String confirm = cp.getConfirmationMessage();
//		Assert.assertTrue(string.equalsIgnoreCase(confirm));
		//driver.close();
	}
}
