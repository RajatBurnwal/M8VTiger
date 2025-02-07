package sample;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtility.PropertiesUtility;
import pomClasses.LoginPage;

public class PracticePOMClassLogin {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		PropertiesUtility pUtil=new PropertiesUtility();
		String URL=pUtil.getDataFromProperties("url");
		driver.get(URL);
		String UN=pUtil.getDataFromProperties("username");
		String PWD=pUtil.getDataFromProperties("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(UN, PWD);

	}

}
