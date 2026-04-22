package WorkPracticeCompany.Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AbstractClassLearningComponents.AbstractComponent;
import PageObjectModel.ConfirmationPage;
import PageObjectModel.LandingPage;
import PageObjectModel.PaymentPage;
import PageObjectModel.ProductCatalogue;
import WorkPracticeCompany.TestComponents.BaseTest;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {

		@Test(dataProvider="dataExport")//, groups= {"Purchase"})
		//@Test(dataProvider="dataExport") Array Declaration
		public void submitOrder(HashMap<String, String> Input) throws InterruptedException, IOException {
		//public void submitOrder(String a, String b, String c) Array Declaration
		System.out.println("Iam in Stand Alone");
		driver.manage().window().setSize(new Dimension(1920, 1080));
		lp.actionsApplication(Input.get("email"), Input.get("password"));
		//List<WebElement> products = lp.g
		ProductCatalogue pc = new ProductCatalogue(driver);
		List<WebElement> products = pc.getProductList();
		pc.addProductsToCart(Input.get("product"));
		//pc.addProductsToCart("ADIDAS ORIGINAL");
		pc.sleepOption();
		pc.goToCart();//has access to parent class methods as well

		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		

		pc.sleepOption();
		//List<WebElement> cartList = driver.findElements(By.cssSelector(".cartSection h3"));
		
	//Assert.assertTrue(pc.assertCartItems("ZARA COAT 3"));
	//Assert.assertTrue(pc.assertCartItems("adidas original"));
	Thread.sleep(3000);
	//jse.executeScript("window.scrollBy(0,1200)");
	PaymentPage pp = new PaymentPage(driver);
	pp.addCountry("India");
	pp.payThePayment();
//	ConfirmationPage cp = new ConfirmationPage(driver);
//	String confirm = cp.getConfirmationMessage();
//	Assert.assertTrue(confirm.equalsIgnoreCase("Thankyou for the order."));
	
	
	}
		@Test(dependsOnMethods= {"submitOrder"})
		public void myOrders() throws InterruptedException {
			
			System.out.println("Iam in myOrders");
			
			
			lp.actionsApplication("kamal123@everest.com", "Rootroot#123");
			
			lp.OrderButton.click();
			List<WebElement> wl= driver.findElements(By.cssSelector("tr td:nth-child(3)"));
			//Assert.assertTrue(wl.stream().anyMatch(s->s.getText().equalsIgnoreCase("ZARA COAT 3")));
		}
		
		//How to send data using jason or 2d array
		@DataProvider
		public Object[][] dataExport() throws IOException{

			
			List<HashMap<String, String>>
			data = getJsonDataToMapForConversion(System.getProperty("user.dir")+"//src//test//java//"
					+ "WorkPracticeCompany//data//"
					+ "PurchaseOrder.json");
			System.out.println(data.get(0));
			return new Object[][] {{data.get(0)},{data.get(1)}};
			
			
			
			
		}
		
//		public File getScreenShot(String fileName) throws IOException {
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			File source = ts.getScreenshotAs(OutputType.FILE);
//			
//			File file = new File(System.clearProperty("user.dir")+"fileName"+".png");
//			
//			FileUtils.copyFile(source, file);
//			return file;
//		}
}

//HashMap<String, String> map = new HashMap<String, String>();
//map.put("email", "kamal123@everest.com");
//map.put("password", "Rootroot#123");
//map.put("product", "ZARA COAT 3");
//
//HashMap<String, String> map1 = new HashMap<String,String>();
//map1.put("password", "Rootroot#123");
//map1.put("email", "kamal123@everest.com");
//map1.put("product", "ADIDAS ORIGINAL");
