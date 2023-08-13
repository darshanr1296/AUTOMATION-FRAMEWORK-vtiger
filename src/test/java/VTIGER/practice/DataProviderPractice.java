package VTIGER.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
	@Test(dataProvider="getdata")
	public void addtocartTest(String name,int price,String model)
	{
		System.out.println("phone name"+name+"price"+price+"model"+model);
	}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0]="iphone";
		data[0][1]=21000;
		data[0][2]="s12";
		
		data[1][0]="redmi";
		data[1][1]=20000;
		data[1][2]="d2";
		return data;
		
	}

}
