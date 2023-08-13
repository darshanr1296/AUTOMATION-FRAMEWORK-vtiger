package VTiger.Genericutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import VTiger.ObjectRepository.Homepage;
import VTiger.ObjectRepository.LoginPage;

/*
 * <scope>test</scope> pom.xml
 * This class consists of all basic configration annotations for all the common actions  
 */
public class BaseClass 
{
	public ExcelFileUtililty eutil=new ExcelFileUtililty();
	public JavaUtility jutil=new JavaUtility();
	public PropertyFileUtility putil=new PropertyFileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	
	public WebDriver driver=null;
	
	//only used listener takescreenshot
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun=true)
	public void bsconfig()
	{
		System.out.println("----db connection successfull----");
	}
	
	//@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void bcconfig() throws Throwable
	{
		
		String URL = putil.Readdatafrompropertyfile("url");
		String BROWSER = putil.Readdatafrompropertyfile("browser");	
		
		 if(BROWSER.contains("chrome"))
		    {
		    	
		    	driver=new ChromeDriver();
		    	System.out.println(" ----chrome browser launched----");
		    }
		    else if(BROWSER.contains("edge")) 
		    {
		    	
		    	driver=new EdgeDriver();
		    	System.out.println("--- Edge browser launched---");
		    }
		    else
		    {
		    	System.out.println("---invalid browser---");
		    }
		    
		 wutil.maximisewindow(driver);
		 wutil.waitforpageload(driver);
		 
		//only used listener takescreenshot
		 sdriver=driver;
		 
		 //load url
		 driver.get(URL);
		   	
	}
    
	@BeforeMethod(alwaysRun=true)
	public void bmconfig() throws Throwable 
				
	{
		String USERNAME = putil.Readdatafrompropertyfile("username");
		String PASSWORD = putil.Readdatafrompropertyfile("password");	
		
		LoginPage lp=new LoginPage(driver);
		lp.Logintoapp(USERNAME, PASSWORD);	
		System.out.println("----LOGIN SUCCESSFULL----");
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void amconfig()
	{
		//signout of app
		Homepage hp=new Homepage(driver);
		hp.clickonsignoutbtn(driver);
		System.out.println("----LOGOUT SUCCESSFULL----");
	}
	
	@AfterClass(alwaysRun=true)
	public void acconfig()
	{
		driver.quit();
		System.out.println("---browser closed--");
		
	}
	
	
	
	
	
	@AfterSuite(alwaysRun=true)
	public void asconfig()
	{
		System.out.println("---db connection closed----");
	}
	

}
