package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This is a utility class which works with Properties file
 * @author rajat burnwal
 * @version 02.01.25
 */
public class PropertiesUtility {

	/**
	 * This is a generic method to fetch data from properties file
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getDataFromProperties(String key) throws Exception
	{
		FileInputStream fis=new FileInputStream(IPathUtility.propertiesPath);
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
	}
}
