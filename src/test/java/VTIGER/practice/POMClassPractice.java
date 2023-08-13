package VTIGER.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import VTiger.Genericutilities.ExcelFileUtililty;
import VTiger.Genericutilities.PropertyFileUtility;
import VTiger.ObjectRepository.LoginPage;
import VTiger.ObjectRepository.OrganizationPage;

public class POMClassPractice 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new EdgeDriver();
		
		
		PropertyFileUtility putil=new PropertyFileUtility();
		
		String URL = putil.Readdatafrompropertyfile("url");
		String USERNAME = putil.Readdatafrompropertyfile("username");
		String PASSWORD = putil.Readdatafrompropertyfile("password");
		
		driver.get(URL);
		
		/*lp.getUserNameEdt().sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getSubmitBtn().click(); */
		
		LoginPage lp=new LoginPage(driver);
		lp.Logintoapp(USERNAME, PASSWORD);
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getOrg().click();
		op.getOrg().click();
		
		ExcelFileUtililty eutil=new ExcelFileUtililty();
		String ORG = eutil.readfromExcelfile("Organisation", 1, 2);
		
		//fill in the org name
		op.getOrg().sendKeys(ORG);
		
		//save
		op.getOrg().click();
		
	}

}
