package testscripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyzerTest implements IRetryAnalyzer{
	int retryattemptcounter= 0;
	int max=3;


@Override
public boolean retry(ITestResult result) {

	if(!result.isSuccess()){
		if(retryattemptcounter<max) {
			retryattemptcounter ++;
			return true;
		}
	}
	return false;

}
}
