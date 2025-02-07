package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertiesUtility;

public class FetchingPropertiesData {

	public static void main(String[] args) throws Exception {
		
//		C:\Users\rajat burnwal\Desktop\Sample.properties
//		FileInputStream fis=new FileInputStream("C:\\Users\\rajat burnwal\\Desktop\\Sample.properties");
//		Properties prop=new Properties();
//		prop.load(fis);
//		String URL=prop.getProperty("url");
////		System.out.println(value);
//		WebDriver driver=new ChromeDriver();
//		driver.get(URL);
		
		PropertiesUtility pUtil=new PropertiesUtility();
		String URL=pUtil.getDataFromProperties("url");
		System.out.println(URL);
	}

}
