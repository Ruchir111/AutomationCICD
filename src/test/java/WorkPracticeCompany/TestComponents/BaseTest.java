package WorkPracticeCompany.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;

import PageObjectModel.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage lp;
	public void initiliseDriver() throws IOException {
		
		
		//propertise class
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream
				(System.getProperty("user.dir")+"//src//main"
				+ "//java//Resources//GlobalData.properties");
		ChromeOptions options = new ChromeOptions();

		// force visible mode
		options.addArguments("--disable-gpu");
		options.addArguments("--start-maximized");
		options.addArguments("--headless=new");

		// DO NOT add headless

		 driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver = new ChromeDriver();
		
		
//		prop.load(fis);
//		
//		String browserName = prop.getProperty("chrome");//!=null ? System.getProperty("browser") : prop.getProperty("browser");
//		
//		//prop.getProperty("browser");
//		if(browserName.equalsIgnoreCase("chrome")) {
//			
//			WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		
//		}else if(browserName.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//			
//		}else if(browserName.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		
//		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchTheApp() throws IOException {
		initiliseDriver();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message")));
		
		lp = new LandingPage(driver);
	
		lp.sendPageRequest("https://www.rahulshettyacademy.com/client");
		
		return lp;
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		//driver.close();
	}
	public String getScreenShot(String fileNameTestCase, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File file = new File(System.getProperty("user.dir")+"//reports//"+fileNameTestCase+".png");
		
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//" + fileNameTestCase + ".png";
	}
	public List<HashMap<String, String>> getJsonDataToMapForConversion(String filePath) throws IOException {
		String jsonContent = FileUtils.readFileToString(new 
				File(filePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = 
				mapper.readValue(jsonContent, new 
						TypeReference<List<HashMap<String, String>>>(){
	});
return data;
}
	
	
	

}
