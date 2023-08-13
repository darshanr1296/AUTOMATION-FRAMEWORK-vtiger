package VTiger.Genericutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * This class consists of generic methods related to property file
 * @author Admin
 *
 */
public class PropertyFileUtility 
{
	
	/**
	 * This method will read data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String Readdatafrompropertyfile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.propertyFilePath);
		Properties pro=new Properties();
		pro.load(fis);
		
		String value = pro.getProperty(key);
		return value;
		
	}

}
