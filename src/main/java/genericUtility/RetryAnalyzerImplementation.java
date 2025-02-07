package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer{

	int count=1;
	int maxCount=4;
	
	@Override
	public boolean retry(ITestResult result) {
		//count=1<=4->true   count=2<=4-> ...... count=5<=4-> false
		while (count<=maxCount) {
			count++;
			return true;			
		}
		return false;
	}
	
}