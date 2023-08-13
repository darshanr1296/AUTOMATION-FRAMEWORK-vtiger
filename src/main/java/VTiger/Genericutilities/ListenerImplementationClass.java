package VTiger.Genericutilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
 * This class provides implementation to ITestListener interface of TestNG
 * Example for Abstraction
 */
public class ListenerImplementationClass implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println("----Execution started----"+methodName);
	
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println("----PASS----"+methodName);
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println("----FAIL----"+methodName);
	    System.out.println(result.getThrowable());
		
	    WebDriverUtility wu=new WebDriverUtility();
	    JavaUtility ju=new JavaUtility();
	    
	    String ScreenshotName=methodName+ju.GetSystemDateinFormat();
	    //take screenshot for failed test scripts
	    try {
			wu.takescreenshot(BaseClass.sdriver, ScreenshotName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println("----SKIP----"+methodName);
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("suite execution started");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("suite execution ended");
	}
	

}
