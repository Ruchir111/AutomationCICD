package Resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//here when test runs parallel the overiding was happening so
//we put ThreadLocal Class that makes different thread for 
//parallel test
public class ExtentReporterNG {
	
	public static ExtentReports getReportObject() {
		
		String dynamicPath = System.getProperty("user.dir")+"//reports//index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(dynamicPath);
		
		reporter.config().setReportName("WebAutomationsResult");
		reporter.config().setDocumentTitle("TestResults");
		
		ExtentReports extentReports = new ExtentReports();
		extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Tester", "Ruchir Patil");
		return extentReports;
	}

}
