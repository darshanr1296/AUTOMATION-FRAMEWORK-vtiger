package Vtigerassignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class scenerio3 {

	public static void main(String[] args) throws Throwable
	{

	       WebDriver driver=new ChromeDriver();
	       driver.get("http://localhost:8888");
	    
	       /*driver.findElement(By.name("user_name")).sendKeys("admin");
		   driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin");
		   driver.findElement(By.name("submitButton")).click();;
		   driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		   driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();*/
			
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
	}
	

}
