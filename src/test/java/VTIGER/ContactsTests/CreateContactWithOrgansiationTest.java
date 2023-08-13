package VTIGER.ContactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import VTiger.Genericutilities.BaseClass;
import VTiger.Genericutilities.ExcelFileUtililty;
import VTiger.Genericutilities.JavaUtility;
import VTiger.Genericutilities.PropertyFileUtility;
import VTiger.Genericutilities.WebDriverUtility;
import VTiger.ObjectRepository.ContactInfoPage;
import VTiger.ObjectRepository.Contactpage;
import VTiger.ObjectRepository.CreateNewContactPage;
import VTiger.ObjectRepository.CreateNewOrganisationPage;
import VTiger.ObjectRepository.Homepage;
import VTiger.ObjectRepository.LoginPage;
import VTiger.ObjectRepository.Organisationinformationpage;
import VTiger.ObjectRepository.OrganizationPage;

@Listeners(VTiger.Genericutilities.ListenerImplementationClass.class)
public class CreateContactWithOrgansiationTest extends BaseClass
{

	@Test(groups="SmokeSuite")
	public void CreateContactWithOrgTest() throws Throwable 
	{
	
		
		String CNTNAME = eutil.readfromExcelfile("contact", 4, 2);
		String ORGNAME = eutil.readfromExcelfile("contact", 4, 3)+jutil.getRandomnumber();
		
		
		//3.navigate to organisations link
		Homepage hp=new Homepage(driver);
		hp.clickonorglink();
		
		//4.click on organisation lookup image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickoncreatelookup();
		
		//5.create organisation by filling mandatory fields
		CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
		cnop.createneworg(ORGNAME);
		
		//6.validate
		Organisationinformationpage oip=new Organisationinformationpage(driver);
		String orgtext = oip.getOrgHeader();
		Assert.assertTrue(orgtext.contains(ORGNAME));
		System.out.println(orgtext);
			
		//create contact using same organisation
		//7.navigate to contact link
		hp.clickoncontlink();
		
		//8.click on create new contact lookup image
		Contactpage cp=new Contactpage(driver);
		cp.clickonCntLookupImg();
		
		//9.fill all mandatory details
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.CreateNewContact(driver,CNTNAME,ORGNAME);
		//wutil.takescreenshot(driver, "Contact1");
		
		//10.validate
		ContactInfoPage cip=new ContactInfoPage(driver);
		String cntheader = cip.getcntHeaderText();
		Assert.assertTrue(cntheader.contains(CNTNAME));
		System.out.println(cntheader);
		
	}
		@Test
		public void demo()
		{
			Assert.fail();
			System.out.println("demo");
		}
		
	

}
