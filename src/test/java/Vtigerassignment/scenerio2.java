package Vtigerassignment;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class scenerio2 {

	public static void main(String[] args) throws Throwable 
	{
       WebDriver driver=new EdgeDriver();
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		
		Properties pro=new Properties();
		
		pro.load(fis);
		
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
	
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		FileInputStream test=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(test);
        String ORGNAME=wb.getSheet("Organisation").getRow(1).getCell(2).getStringCellValue();
		
		
		//System.out.println(value);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
		

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		

		//Step 7: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("=== PASS ===");
		}
		else
		{
			System.out.println("=== FAIL ===");
		}
		
		
		WebElement mous = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Actions act=new Actions(driver);
		act.moveToElement(mous).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']y")).click();
		
		//driver.findElement(By.name("accountname"))args;
	}

}
