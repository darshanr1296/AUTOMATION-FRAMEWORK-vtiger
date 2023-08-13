package VTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VTiger.Genericutilities.WebDriverUtility;

public class Homepage extends WebDriverUtility
{
	//creat pom class for every web page
	
	//identify elements using annotations
	@FindBy(linkText="Organizations") private WebElement org;
	
	@FindBy(xpath="//a[text()='Contacts']") private WebElement cnt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement Administratorimg;
	
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement signoutbtn;
	
	//create constructor to initialise  these elements
	public Homepage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//provide getters to access these methods
	public WebElement getOrg() 
	{
		return org;
	}

	public WebElement getCnt() 
	{
		return cnt;
	}
	
	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	
	
	public WebElement getAdministratorimg() {
		return Administratorimg;
	}

		//provide business library
		public void clickonorglink()
		{
			org.click();
		}
		
		public void clickoncontlink()
		{
			cnt.click();
		}
		
		public void clickonsignoutbtn(WebDriver driver)
		{
			MouseOverAction(driver,Administratorimg);
			signoutbtn.click();
		}

		
		
	

}
