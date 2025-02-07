package tcRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pomClasses.ContactsPage;
import pomClasses.CreatingNewContactPage;
import pomClasses.HomePage;

public class TC_005 extends BaseClass{

	@Test(groups = "Smoke")
	public void contacts_002() throws Exception
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsMenu();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactIcon();
		
		String fName=eUtil.getDataFromExcel("Contacts", 5, 1);
		String lName=eUtil.getDataFromExcel("Contacts", 5, 2);
		String title=eUtil.getDataFromExcel("Contacts", 5, 3);
		String email=eUtil.getDataFromExcel("Contacts", 5, 4);
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createNewContact(fName, lName, title, email);
	}
}
