package VTiger.Genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consists of generic methods related to excel file
 * @author Admin
 *
 */
public class ExcelFileUtililty 
{
	
	/**
	 * This method will read data from excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable 
	 * @throws Throwable 
	 * @throws IOException
	 */
	public String readfromExcelfile(String sheetname,int rownum,int cellnum) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row rw = sh.getRow(rownum);
		Cell ce = rw.getCell(cellnum);
	    String value = ce.getStringCellValue();
	    wb.close();
	    return value;
		
	}
	
	/**
	 * THis will write data into excel sheet
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @param value
	 * @throws Throwable
	 */
	public void WriteDateIntoExcelFile(String sheetname,int rowno,int cellno,String value) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(sheetname);
		Row rw = sh.createRow(rowno);
		Cell ce = rw.createCell(cellno);
		ce.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(ConstantsUtility.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	public Object[][] readMultipleData(String MultipleOrg) throws Throwable
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("MultipleOrg");
		int lastrow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++) //row navigation
		{
			for(int j=0;j<lastcell;j++) //cell  navigation
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
