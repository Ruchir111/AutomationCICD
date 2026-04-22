package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import AbstractClassLearningComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;
	
		// TODO Auto-generated method stub
		
		public ProductCatalogue(WebDriver driver) {
			
			super(driver);
			this.driver = driver;
			
			//The two lines below work only when this method is called
			PageFactory.initElements(driver, this);
		}
		
				
		//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
				//page Factory
		@FindBy(css = ".mb-3")
		List<WebElement> products;
		
		@FindBy(css = ".ng-animating")
		WebElement ng;
		
		@FindBy(css = ".cartSection h3")
		List <WebElement> CartList; 
		
		By productsBy = By.cssSelector(".mb-3");
		By toastMessage = By.cssSelector("#toast-container");
		
		AbstractComponent ab;
		public List<WebElement> getProductList() {
				//waitForEmelementToAppear(productsBy);
			return products;
			
		}
		public WebElement getProductsByName(String productName) {
			return getProductList().stream().filter(productStream->
					productStream.findElement(By.cssSelector("b")).
					getText().equals(productName)).findFirst().orElse(null);
			
			
		}
		public void addProductsToCart(String a) throws InterruptedException {
			Thread.sleep(5000);
			getProductsByName(a).findElement(By.cssSelector(".btn.w-10.rounded")).click();
			waitForEmelementToAppear(toastMessage);
			waitForEmelementToDisAppear(ng);
		}
		public Boolean assertCartItems(String productName) {
			return CartList.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		}
		
		
	}
