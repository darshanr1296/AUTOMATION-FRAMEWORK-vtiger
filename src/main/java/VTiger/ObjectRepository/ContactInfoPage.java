package VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	//create separate class for every web page
	
	//identify elements using annotations
	@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement cntHeaderText;
	
	//create constructor to intiliaze these elements
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//provide getters to access these methods
	public WebElement getCntHeaderText() {
		return cntHeaderText;
	}
	
	//business library
	/*
	 * this method will give header of the contact page
	 */
	public String getcntHeaderText()
	{
		return cntHeaderText.getText();
	}

	
	
	
	
	
	

}
