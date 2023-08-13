package VTIGER.OrganisationsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import VTiger.Genericutilities.BaseClass;
import VTiger.Genericutilities.ExcelFileUtililty;
import VTiger.Genericutilities.JavaUtility;
import VTiger.Genericutilities.PropertyFileUtility;
import VTiger.Genericutilities.WebDriverUtility;
import VTiger.ObjectRepository.CreateNewOrganisationPage;
import VTiger.ObjectRepository.Homepage;
import VTiger.ObjectRepository.LoginPage;
import VTiger.ObjectRepository.Organisationinformationpage;
import VTiger.ObjectRepository.OrganizationPage;

public class CreateMultipleOrgWithIndustry extends BaseClass
{
	
	ExcelFileUtililty eutil=new ExcelFileUtililty();
	JavaUtility jutil=new JavaUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	
	@Test(dataProvider="getData")
	public void createMultipleOrg(String ORG,String INDUSTRY) throws Throwable
	{
		  WebDriver driver=null;
		//read all required data
		String URL = putil.Readdatafrompropertyfile("url");
		String BROWSER = putil.Readdatafrompropertyfile("browser");	
		String USERNAME = putil.Readdatafrompropertyfile("username");
		String PASSWORD = putil.Readdatafrompropertyfile("password");	
		
	    String ORGNAME = ORG+jutil.getRandomnumber();
		
		//click on organisations link
		Homepage hp= new Homepage(driver);
		hp.clickonorglink();
		
		//navigate to create new organisation link
		OrganizationPage op=new OrganizationPage(driver);
		op.clickoncreatelookup();
		
		//create new organisation with industry drop down
		CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
		cnop.createneworg(ORGNAME,INDUSTRY);
		
		//validate
		Organisationinformationpage oip=new Organisationinformationpage(driver);
		String orgheader = oip.getOrgHeader();
		Assert.assertTrue(orgheader.contains(ORGNAME));
		System.out.println(orgheader);
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eutil.readMultipleData("MultipleOrg");
		
	}
	

}
