package VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import VTiger.Genericutilities.WebDriverUtility;

public class CreateNewOrganisationPage extends WebDriverUtility
{
	//create separate class for every web page
	
	//identify elements using annotations
    @FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement createorg;
	
	@FindBy(name="accountname") private WebElement fillorg;
	
	@FindBy(xpath="//select[@name='industry']") private WebElement fillindustry;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement saveorg;

	//create constructor  to initialize these elements
	public CreateNewOrganisationPage(WebDriver driver)
	{
			PageFactory.initElements(driver,this);
	}
	
	//provide getters to access these  methods
	public WebElement getCreateorg() {
		return createorg;
	}

	public WebElement getFillorg() {
		return fillorg;
	}

	public WebElement getSaveorg() {
		return saveorg;
	}
	
	public WebElement getFillindustry() {
		return fillindustry;
	}

	//business libraries
	public void createneworg(String ORGNAME)
	{
		fillorg.sendKeys(ORGNAME);
		saveorg.click();
		
	}
	public void createneworg(String ORGNAME,String INDUSTRY)
	{
		fillorg.sendKeys(ORGNAME);
		HandleDropdown(fillindustry,INDUSTRY);
		saveorg.click();
	}
}
