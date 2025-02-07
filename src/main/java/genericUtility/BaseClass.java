package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pomClasses.HomePage;
import pomClasses.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver;		//used only in listeners
	public PropertiesUtility pUtil=new PropertiesUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	
	@BeforeSuite(alwaysRun = true)
	public void dbConnection()
	{
		System.out.println("DB connection successful");
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String BROWSER) throws Exception
	{
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("safari"))
		{
			driver=new SafariDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		sDriver=driver;			//initializing static driver with actual driver to be used in listeners
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver, 15);
		String URL=pUtil.getDataFromProperties("url");
		sUtil.accessToApplication(driver, URL);
		System.out.println("Browser launched successfully");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginOperation() throws Exception
	{
		String UN=pUtil.getDataFromProperties("username");
		String PWD=pUtil.getDataFromProperties("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(UN, PWD);
		System.out.println("Login done successfully");
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutOperation()
	{
		HomePage hp=new HomePage(driver);
		hp.signOutOperation(driver);
		System.out.println("Logout done successfully");
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("Browser closed successfully");
	}
	
	@AfterSuite(alwaysRun = true)
	public void dbConnectionClosed()
	{
		System.out.println("DB disconnected");
	}
}
