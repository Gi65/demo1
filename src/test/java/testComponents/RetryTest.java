package testComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer {

	int count=0;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<2) {
			count++;
		    return true;
		}
		return false;
	}

}
