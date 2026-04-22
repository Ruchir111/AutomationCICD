package AbstractClassLearningComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent  {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css = "[routerlink='/dashboard/cart']")
	WebElement cart;
	public void goToCart() {
		cart.click();
	}
	public void sleepOption() throws InterruptedException {
		//Thread.sleep(2000);
	}
	public void waitForEmelementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
		
		//this has By Locator
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForEmelementToDisAppear(WebElement wl) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
		
		//this has By Locator
		//		expliWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		wait.until(ExpectedConditions.invisibilityOf(wl));
	}
	public void waitForWebElementToAppear(WebElement wl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
	}
}
