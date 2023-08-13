package VTIGER.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
import VTiger.Genericutilities.PropertyFileUtility;
import VTiger.Genericutilities.WebDriverUtility;



public class demo1 {

	public static void main(String[] args) throws Throwable  
	{
		
		//create  contact
		/*WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();*/
		
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		ExcelFileUtililty eutil=new ExcelFileUtililty();
		
		String BROWSER = putil.Readdatafrompropertyfile("browser");
		String URL = putil.Readdatafrompropertyfile("url");
		String USERNAME = putil.Readdatafrompropertyfile("username");
		String PASSWORD = putil.Readdatafrompropertyfile("password");
		String CONTACTNAME = eutil.readfromExcelfile("contact", 1, 2);
		
		
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
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
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	
		//navigate to contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//create contact link
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		
		//write last name textfield from excel save
		
		/*FileInputStream fis=new FileInputStream(".//src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("contact");
		Row rw = sh.getRow(1);
		Cell ce = rw.getCell(2);
		String value = ce.getStringCellValue();*/
		driver.findElement(By.name("lastname")).sendKeys(CONTACTNAME);
		
		//save
        driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
        
        //validate
        String cntheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(cntheader.contains(CONTACTNAME))
		{
			System.out.println("pass");
			System.out.println(cntheader);
		}
		else
		{
			System.out.println("fail");
		}
		
        //signout of application
		WebElement mous = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(mous).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	}

}
