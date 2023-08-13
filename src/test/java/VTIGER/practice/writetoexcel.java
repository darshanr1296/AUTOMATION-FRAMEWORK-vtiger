package VTIGER.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writetoexcel {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sh=wb.getSheet("contact");
		
		Row rw = sh.createRow(7);
		
		Cell ce = rw.createCell(5);
		
		ce.setCellValue("batman");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		wb.write(fos);
		
		wb.close();
		System.out.println("data added");
		
	}

}
