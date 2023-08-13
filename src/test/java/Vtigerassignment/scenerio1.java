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

public class scenerio1 
{
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
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		FileInputStream test=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(test);
        Sheet sh=wb.getSheet("contact");
		Row rw=sh.getRow(1);
		Cell ce=rw.getCell(2);
		String value = ce.getStringCellValue();
		//System.out.println(value);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(value);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement mous = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Actions act=new Actions(driver);
		act.moveToElement(mous).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}

}
