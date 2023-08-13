package VTiger.Genericutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
 * this Class provides Implementation for Iretryanalyser interface
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer
{

    int count=1;
    int retrycount=3;
	public boolean retry(ITestResult result) 
	{
		while(count<retrycount)
		{
			count++;
			return true; //retry
		}

		return false; //dont retry
	}

}
