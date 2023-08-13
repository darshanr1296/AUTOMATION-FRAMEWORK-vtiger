package VTiger.Genericutilities;

import java.util.Date;
import java.util.Random;

/**
 * this class consists of generic methods related to java
 * @author Admin
 *
 */

public class JavaUtility
{
	
 /**
 * this method will generate random number for every run
 * @return
 */
	public int getRandomnumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}

	
  /**
   * 
   * This method will generate the system date
   * @return
   */
	public String GetSystemDate()
	{
		Date d=new Date();
		return d.toString();
	}
	
	
  /**
   * 
   * This method will generate system date in specific format	
   * @return
   */
	public String GetSystemDateinFormat()
	{
		Date d=new Date();
		String[] darry = d.toString().split(" ");
		String day=darry[2];
		String month=darry[1];
		String year=darry[5];
		String time=darry[3].replace(":", "-");
		
		String date=day+"-"+month+"-"+year+"-"+time;
		return date;
	}

}
