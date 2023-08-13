package VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	//create separate class for every web page
	
	//identify elements using annotations
	@FindBy(linkText="Organizations") private WebElement org;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement orglookup;
	
	//create constructor  to initialize these elements
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	//provide getters to access these  methods
	public WebElement getOrg() {
		return org;
	}
	
	//business library
	/**
	 * 
	 * this method will click on create organisation lookup image
	 */
	public void clickoncreatelookup()
	{
		orglookup.click();
	}



}
