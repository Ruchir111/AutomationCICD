package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractClassLearningComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;
	
		// TODO Auto-generated method stub
		
		public LandingPage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			
			//The two lines below work only when this method is called
			PageFactory.initElements(driver, this);
		}
		
		//WebElement userEmails = driver.findElement(By.id("userEmail");)
				
				
				//page Factory
		@FindBy(id = "userEmail")
		WebElement userEmail;
		
		@FindBy(id = "userPassword")
		WebElement userPass;
		
		@FindBy(id = "login")
		WebElement submit;
		
		@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
		WebElement errorMessage;
		
		@FindBy(css = "button[routerlink='/dashboard/myorders'")
		public WebElement OrderButton;
		
		public void actionsApplication(String email, String password) throws InterruptedException {
			userEmail.sendKeys(email);
			userPass.sendKeys(password);
			driver.manage().window().setSize(new Dimension(1920, 1080));
			Thread.sleep(3000);
			
			submit.click();
			
			
		}
		public String getErrorMessage() throws InterruptedException {
			waitForWebElementToAppear(errorMessage);
			String a=errorMessage.getText();
			return a;
		}
		
		public void sendPageRequest(String url1) {
			driver.get(url1);
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message")));
		}
		
		
	}
