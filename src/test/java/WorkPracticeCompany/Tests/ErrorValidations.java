package WorkPracticeCompany.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import WorkPracticeCompany.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test
	public void submitOrder() throws InterruptedException {
		//String pName = "ZARA COAT 3";
		 lp.actionsApplication("ka@eeverest.com","Rootroot#123");
		Assert.assertEquals("", lp.getErrorMessage());
	}
}
