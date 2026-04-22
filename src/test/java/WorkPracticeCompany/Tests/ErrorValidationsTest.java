package WorkPracticeCompany.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import WorkPracticeCompany.TestComponents.*;

import WorkPracticeCompany.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups={"ErrorHandling"},retryAnalyzer = Retry.class) //to use groups successfully do add beforemethod(alwaysRun='true') similar for aftermethod annotation
	public void loginErrorHandlingTest() throws InterruptedException {
		//String pName = "ZARA COAT 3";
		 lp.actionsApplication("kamal@gmail.com","Rootroot#123");
		Assert.assertEquals("", lp.getErrorMessage());
	}
}
