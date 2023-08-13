package VTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//Rule1  : create separate class for every web page
	
	//Rule2 : Identify elements using annotations
	@FindBy(name="user_name") private WebElement UserNameEdt;
	
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton") private WebElement submitBtn;
	
	//Rule 3:create a constructor to initialise these elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule 4:provide getters to access these variables
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	/*
	 * 
	 * This method is used for login
	 */
	public void Logintoapp(String USERNAME,String PASSWORD)
	{
		UserNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		submitBtn.click();
	}
	
	 

}
