package VTIGER.OrganisationsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

public class CreateOrganisationWithIndustryTest  extends BaseClass
{
	@Test(groups="RegressionSuite")
	public void createorgwithindustry() throws Throwable
	{
				
			    String ORGNAME = eutil.readfromExcelfile("Organisation", 4, 2);
			    String INDUSTRY = eutil.readfromExcelfile("Organisation", 4, 3);
			    
				
				//click on organisations link
				Homepage hp= new Homepage(driver);
				hp.clickonorglink();
				
				//navigate to create new organisation link
				OrganizationPage op=new OrganizationPage(driver);
				op.clickoncreatelookup();
				
				//create new organisation with industry drop down
				CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
				cnop.createneworg(ORGNAME, INDUSTRY);
				
				//validate
				Organisationinformationpage oip=new Organisationinformationpage(driver);
				String orgheader = oip.getOrgHeader();
				Assert.assertTrue(orgheader.contains(ORGNAME));
				System.out.println(ORGNAME);			
				
				
				
	}
	

}
