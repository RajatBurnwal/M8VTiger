package tcRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pomClasses.ContactsPage;
import pomClasses.CreatingNewContactPage;
import pomClasses.HomePage;

public class TC_004 extends BaseClass{

	@Test(groups = {"Sanity","Regression"})
	public void contacts_001() throws Exception
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsMenu();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactIcon();
		
		String fName=eUtil.getDataFromExcel("Contacts", 2, 1);
		String lName=eUtil.getDataFromExcel("Contacts", 2, 2);
		String leadSource=eUtil.getDataFromExcel("Contacts", 2, 3);
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createNewContact(fName, lName, leadSource);
	}
}
