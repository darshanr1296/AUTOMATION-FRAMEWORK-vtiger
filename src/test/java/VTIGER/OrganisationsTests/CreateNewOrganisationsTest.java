package VTIGER.OrganisationsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import VTiger.Genericutilities.ExcelFileUtililty;
import VTiger.Genericutilities.JavaUtility;
import VTiger.Genericutilities.PropertyFileUtility;
import VTiger.Genericutilities.WebDriverUtility;
import VTiger.ObjectRepository.CreateNewOrganisationPage;
import VTiger.ObjectRepository.Homepage;
import VTiger.ObjectRepository.LoginPage;
import VTiger.ObjectRepository.Organisationinformationpage;
import VTiger.ObjectRepository.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOrganisationsTest 
{
	@Test
	public void CreateNewOrgTest() throws Throwable
	{
		//create new organisation
		//create object for all generic utilities
		ExcelFileUtililty eutil=new ExcelFileUtililty();
		JavaUtility jutil=new JavaUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		//read all required data
		String URL = putil.Readdatafrompropertyfile("url");
		String BROWSER = putil.Readdatafrompropertyfile("browser");	
		String USERNAME = putil.Readdatafrompropertyfile("username");
		String PASSWORD = putil.Readdatafrompropertyfile("password");	
		
	    String ORGNAME = eutil.readfromExcelfile("Organisation", 1, 2);
	    
	    WebDriver driver=null;
		//launch the browser
	    if(BROWSER.contains("chrome"))
	    {
	    	
	    	driver=new ChromeDriver();
	    }
	    else if(BROWSER.contains("edge")) 
	    {
	    	
	    	driver=new EdgeDriver();
	    }
	    else
	    {
	    	System.out.println("invalid browser");
	    }
	    
	    driver.get(URL);
	    wutil.maximisewindow(driver);
	    wutil.waitforpageload(driver);
	    
	    //login to app
	    LoginPage lp=new LoginPage(driver);
		lp.Logintoapp(USERNAME, PASSWORD);
		
		//click on organisations link
		Homepage hp= new Homepage(driver);
		hp.clickonorglink();
		
		//navigate to create new organisation link
		OrganizationPage op=new OrganizationPage(driver);
		op.clickoncreatelookup();
		
		//create new organisation by filling all mandatory fields and save
		CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
		cnop.createneworg(ORGNAME);
		Reporter.log("organisation created");
		
		
		//validate
		Organisationinformationpage oip=new Organisationinformationpage(driver);
		String orgheader = oip.getOrgHeader();
		Assert.assertTrue(orgheader.contains(ORGNAME));
		
		//signout of app
		hp.clickonsignoutbtn(driver);
		
		
		
		
		
		
		
	}

}
