package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractClassLearningComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent{

	WebDriver driver;
	public PaymentPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".totalRow button")
	WebElement country;
	
	@FindBy(css = ".form-group .input.txt.text-validated")
	WebElement countrySelect;
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement countryClick;
	
	@FindBy(css = ".action__submit")
	WebElement pay;
	
	public void addCountry(String countryName) throws InterruptedException {
		sleepOption();
		country.click();
		sleepOption();
		countrySelect.sendKeys(countryName);
		sleepOption();
		countryClick.click();
		sleepOption();
	}
	public void payThePayment() {
		pay.click();
	}

}
