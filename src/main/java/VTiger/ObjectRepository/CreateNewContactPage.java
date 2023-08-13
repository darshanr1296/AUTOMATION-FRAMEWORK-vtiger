package VTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VTiger.Genericutilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
	//create separate class for every web page
	
	//identify elements using annotations
	@FindBy(name="lastname") private WebElement  lstname; 
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement savebtn;
	
	@FindBy(xpath="//input[@name='account_name'] /following-sibling::img[@src='themes/softed/images/select.gif']") private WebElement OrgLookupImg;
	
	@FindBy(xpath="//input[@name='search_text']") private WebElement Orgsearchedt;
	
	@FindBy(name="search") private WebElement Orgsrchbtn;
	
	//create constructor to initiliaze these elements
    public CreateNewContactPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

    //provide getters to access these methods
	public WebElement getLstname() {
		return lstname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public WebElement getOrgLookupImg() {
		return OrgLookupImg;
	}

	public WebElement getOrgsearchedt() {
		return Orgsearchedt;
	}

	public WebElement getOrgsrchbtn() {
		return Orgsrchbtn;
	}
	
    
   //business library
	/*
	 * 
	 * this method will create contact with organisation
	 */

	public void CreateNewContact(String CONTACTNAME)
    {
    	lstname.sendKeys(CONTACTNAME);
    	savebtn.click();
    }
	public void CreateNewContact(WebDriver driver,String CONTACTNAME,String ORGNAME)
	{
		lstname.sendKeys(CONTACTNAME);
		OrgLookupImg.click();
		switchTowindow(driver,"Accounts");
		Orgsearchedt.sendKeys(ORGNAME);
		Orgsrchbtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchTowindow(driver,"Contacts");
		savebtn.click();
		

	}
    
    

}
