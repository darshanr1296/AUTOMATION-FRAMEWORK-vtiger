package VTIGER.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import VTiger.Genericutilities.ExcelFileUtililty;
import VTiger.Genericutilities.JavaUtility;
import VTiger.Genericutilities.PropertyFileUtility;
import VTiger.Genericutilities.WebDriverUtility;

public class utilitydemo 
	{
		
		public static void main(String[] args) throws Throwable 
		{
			//create object of all utilities
			JavaUtility jutil=new JavaUtility();
			PropertyFileUtility putil=new PropertyFileUtility();
			WebDriverUtility wutil=new WebDriverUtility();
			ExcelFileUtililty eutil=new ExcelFileUtililty();
		
            //read all data from property file
			String BROWSER = putil.Readdatafrompropertyfile("browser");
			String URL = putil.Readdatafrompropertyfile("url");
			String USERNAME = putil.Readdatafrompropertyfile("username");
			String PASSWORD =putil.Readdatafrompropertyfile("password");
			
			String value = eutil.readfromExcelfile("contact", 1, 2)+jutil.getRandomnumber();
			
			WebDriver driver=null;
			
			//launch browser
			if(BROWSER.equalsIgnoreCase("edge"))
			{
				//WebDriverManager.edgedriver.setup();
				driver=new EdgeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
			}
			else
			{
				System.out.println("invalid browser name");
			}
			
		    wutil.maximisewindow(driver);
		    wutil.waitforpageload(driver);
			driver.get(URL);
			
			//login to app
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//navigate to contacts
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			
			//click on create contact link
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
			
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(value);
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//Step 7: Validate
			String contHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(contHeader.contains(value))
			{
				System.out.println("=== PASS ===");
			}
			else
			{
				System.out.println("=== FAIL ===");
			}
			
			WebElement mous = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        wutil.MouseOverAction(driver, mous);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		}
	}