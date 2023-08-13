package VTIGER.practice;

import VTiger.Genericutilities.ExcelFileUtililty;
import VTiger.Genericutilities.JavaUtility;
import VTiger.Genericutilities.PropertyFileUtility;

public class GenericUtilitypractice {

	
	public static void main(String[] args) throws Throwable 
	{
		JavaUtility jutil=new JavaUtility();
		int value = jutil.getRandomnumber();
		System.out.println(value);
		
		System.out.println(jutil.GetSystemDate());
		
		System.out.println(jutil.GetSystemDateinFormat());
		
		PropertyFileUtility putil=new PropertyFileUtility();
		String value1 = putil.Readdatafrompropertyfile("username");
		System.out.println(value1);
		
		
		
		ExcelFileUtililty eutil=new ExcelFileUtililty();
		eutil.readfromExcelfile("contact", 1, 2);
		
		eutil.WriteDateIntoExcelFile("hi", 5, 6 ,"kgf");
		System.out.println("data added");

	}

}
