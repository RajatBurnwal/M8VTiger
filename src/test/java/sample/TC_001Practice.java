package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.ExcelUtility;
import genericUtility.PropertiesUtility;
import genericUtility.SeleniumUtility;
import pomClasses.CreatingNewLeadPage;
import pomClasses.HomePage;
import pomClasses.LeadsPage;
import pomClasses.LoginPage;

public class TC_001Practice {

	@Test
	public void tc_001() throws Exception
	{
		WebDriver driver=new ChromeDriver();
		
		SeleniumUtility sUtil=new SeleniumUtility();
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver, 15);
		
		PropertiesUtility pUtil=new PropertiesUtility();
		String URL=pUtil.getDataFromProperties("url");
		String UN=pUtil.getDataFromProperties("username");
		String PWD=pUtil.getDataFromProperties("password");
		sUtil.accessToApplication(driver, URL);
		
		LoginPage lop=new LoginPage(driver);
		lop.loginToApplication(UN, PWD);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsMenu();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadIcon();
		
		ExcelUtility eUtil=new ExcelUtility();
		String lName=eUtil.getDataFromExcel("Leads", 2, 1);
		String company=eUtil.getDataFromExcel("Leads", 2, 2);
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createNewLead(lName, company);
		
		hp.signOutOperation(driver);
		driver.quit();
	}
}
