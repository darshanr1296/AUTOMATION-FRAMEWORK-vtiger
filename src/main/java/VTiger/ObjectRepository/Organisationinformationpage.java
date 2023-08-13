package VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organisationinformationpage 
{
	//create pom class for every webpage
	
	//identify elements using annotations
	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement orgHeaderText;
	
	//create constructor to intialise these elements
	public Organisationinformationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//provide getters to access these methods
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}

	//business library
	/**
	 * this method will return the header text
	 * @return
	 */
	public String getOrgHeader()
	{
		return orgHeaderText.getText();
	}
	
	
	
	

}
