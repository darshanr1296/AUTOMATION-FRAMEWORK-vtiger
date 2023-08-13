package VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage 
{
	//create separate class for every web page
	
	//identify elements using annotations
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]") private WebElement cnt;
	
	//create constructor to initialize these elements
	public Contactpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//provide getters to access these menthods
	public WebElement getCnt() 
	{
		return cnt;
	}
	
	//business library
	public void clickonCntLookupImg()
	{
		cnt.click();
	}
	
	

}
