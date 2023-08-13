package VTIGER.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Retryanalyzerpractice 
{
	@Test(retryAnalyzer=VTiger.Genericutilities.RetryAnalyserImplementation.class)
	public void sample()
	{
		Assert.fail();
		System.out.println("retry demo");
	}

}
