package VTIGER.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class propertiesfile {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		
		Properties pro=new Properties();
		
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = pro.getProperty("url");
		System.out.println(URL);

	}

}
