package tcRepo;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pomClasses.ContactsPage;
import pomClasses.CreatingNewContactPage;
import pomClasses.HomePage;

public class TC_006 extends BaseClass{

	@Test(groups = {"Smoke","Sanity"})
	public void contacts_003() throws Exception
	{
               
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsMenu();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactIcon();
		
		String fName=eUtil.getDataFromExcel("Contacts", 8, 1);
		String lName=eUtil.getDataFromExcel("Contacts", 8, 2);
		String title=eUtil.getDataFromExcel("Contacts", 8, 3);
		String email=eUtil.getDataFromExcel("Contacts", 8, 4);
		String mailingCity=eUtil.getDataFromExcel("Contacts", 8, 5);
		String mailingState=eUtil.getDataFromExcel("Contacts", 8, 6);
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createNewContact(fName, lName, title, email, mailingCity, mailingState);
	}
	
	@Test(retryAnalyzer = genericUtility.RetryAnalyzerImplementation.class)
	public void parallelTest()
	{
        Assert.fail();     
	}
}
