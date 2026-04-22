package WorkPracticeCompany.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//Flaky Tests Endup Here
public class Retry implements IRetryAnalyzer{
	int count = 0;
	int maxTry = 1;
	
	public boolean retry(ITestResult result){
		if(count<maxTry) {
			count++;
			return true;
		}else
		return false;
		
	}

}
